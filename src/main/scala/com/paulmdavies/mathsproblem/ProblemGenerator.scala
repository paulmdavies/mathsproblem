package com.paulmdavies.mathsproblem

object ProblemGenerator
{
    def apply( lowerLimit : Int, upperLimit : Int ) : ProblemGenerator = new ProblemGenerator( lowerLimit, upperLimit )
}

class ProblemGenerator private [mathsproblem] ( private [mathsproblem] lowerLimit : Int, private [mathsproblem] upperLimit : Int )
{
    require( lowerLimit <= upperLimit, "Lower limit (%d) should be less than upper limit (%d)" )
    
    private [mathsproblem] def numberInRange() = scala.util.Random.nextInt( upperLimit - lowerLimit ) + lowerLimit
    
    def apply() : Problem =
    {
        val left = numberInRange()
        val right = numberInRange()
        new AdditionProblem( left, right )
    }
}