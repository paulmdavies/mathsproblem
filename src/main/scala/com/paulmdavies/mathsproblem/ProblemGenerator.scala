package com.paulmdavies.mathsproblem

import scala.util.Random
import com.paulmdavies.mathsproblem.random._

object ProblemGenerator
{
    def apply( lowerLimit : Int, upperLimit : Int ) : ProblemGenerator = new ProblemGenerator( lowerLimit, upperLimit )
    
    private [mathsproblem] def problemConstructors : Seq[(Int,Int) => Problem] = Seq(
        AdditionProblem.apply _,
        SubtractionProblem.apply _,
        MultiplicationProblem.apply _,
        DivisionProblem.apply _
    )
    
    private [mathsproblem] def randomProblemConstructor : (Int, Int) => Problem = problemConstructors( Random.nextInt( problemConstructors.size ) )
}

class ProblemGenerator private [mathsproblem] ( private [mathsproblem] lowerLimit : Int, private [mathsproblem] upperLimit : Int )
{
    protected [mathsproblem] val randomRange = RandomRangeExcludingZero( lowerLimit, upperLimit )
    
    def apply() : Problem =
    {
        val left = randomRange()
        val right = randomRange()
        ProblemGenerator.randomProblemConstructor( left, right )
    }
}