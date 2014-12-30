import com.paulmdavies.mathsproblem._
import com.paulmdavies.mathsproblem.stats._

object Main extends App
{
    override def main( args : Array[String] ) : Unit =
    {
		val lowerLimit = args( 0 ).toInt
		val upperLimit = args( 1 ).toInt

		val stats = ProblemStats()
		val generator = ProblemGenerator( lowerLimit, upperLimit )

		def shutdown
		{
			println( stats.report )
		}

        sys.addShutdownHook( shutdown )
        
        var stop = false
        while ( !stop )
        {
            val problem = generator()
            println( "Question: %s".format( problem ) )
            var validAnswer = false 
            while ( !validAnswer )
            {
                val answer = Console.readLine( "Answer: ")
                answer.toLowerCase match
                {
                    case "exit" => 
                    {
                        validAnswer = true
                        stop = true
                    }
                    case ans : String =>
                    {
                        try 
                        {
                            val intAns = ans.toInt
                            problem.guess( intAns ) match
                            {
                                case true => println( "--- Correct! ---\n" )
                                case false => println( "--- Wrong... ---\n" )
                            }
                            stats.add( problem, intAns )
                            validAnswer = true
                        }
                        catch
                        {
                            case e : NumberFormatException =>
                            {
                                println( "You answer %s is not a number - please either type a number, or 'EXIT' to quit".format( answer ) )
                            }
                        }
                    }
                }
            }
        }
    }
}