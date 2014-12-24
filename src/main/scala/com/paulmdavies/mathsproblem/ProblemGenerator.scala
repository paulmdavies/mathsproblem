package com.paulmdavies.mathsproblem

import scala.util.Random

object ProblemGenerator
{
    private [mathsproblem] val LIMIT = 1000
    
    def apply( lowerLimit : Int, upperLimit : Int ) : ProblemGenerator = new ProblemGenerator( lowerLimit, upperLimit )
    
    private [mathsproblem] def problemConstructors : Seq[(Int,Int) => Problem] = Seq(AdditionProblem.apply _, SubtractionProblem.apply _)
    
    private [mathsproblem] def randomProblemConstructor : (Int, Int) => Problem = problemConstructors( Random.nextInt( problemConstructors.size ) )
}

class ProblemGenerator private [mathsproblem] ( private [mathsproblem] lowerLimit : Int, private [mathsproblem] upperLimit : Int )
{
    require( lowerLimit < upperLimit, "Lower limit (%d) should be less than upper limit (%d)".format( lowerLimit, upperLimit ) )
    require( lowerLimit >= -1 * ProblemGenerator.LIMIT, "Minimum value is -%d".format( ProblemGenerator.LIMIT ) )
    require( upperLimit <= ProblemGenerator.LIMIT, "Maximum value is %d".format( ProblemGenerator.LIMIT ) )
    
    private [mathsproblem] def numberInRange() = scala.util.Random.nextInt( upperLimit - lowerLimit ) + lowerLimit
    
    def apply() : Problem =
    {
        val left = numberInRange()
        val right = numberInRange()
        ProblemGenerator.randomProblemConstructor( left, right )
    }
}