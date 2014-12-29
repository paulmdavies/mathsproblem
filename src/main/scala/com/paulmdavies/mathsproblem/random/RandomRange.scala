package com.paulmdavies.mathsproblem.random

import scala.util.Random

object RandomRange
{
    val UPPER_LIMIT = 1000
    val LOWER_LIMIT = -1 * UPPER_LIMIT
    
    def apply( lower : Int, upper : Int ) : RandomRange = 
    {
        new RandomRange( lower, upper )
    }
}

class RandomRange private [random] (
    private [random] val lowerLimit : Int,
    private [random] val upperLimit : Int
) extends RandomRangeBase
{
    require( lowerLimit < upperLimit, "Lower limit must be less than upper limit" )
    require( upperLimit <= RandomRange.UPPER_LIMIT )
    require( lowerLimit >= RandomRange.LOWER_LIMIT )
    
    def apply() : Int = Random.nextInt( upperLimit - lowerLimit ) + lowerLimit
}