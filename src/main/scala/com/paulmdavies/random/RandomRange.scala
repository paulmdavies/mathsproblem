package com.paulmdavies.random

import scala.util.Random

object RandomRange
{
    def apply( lowerLimit : Int, upperLimit : Int ) : RandomRange = new RandomRange( lowerLimit, upperLimit )
}

class RandomRange private [random] ( private [random] val lowerLimit : Int, private [random] val upperLimit : Int )
{
    require( lowerLimit < upperLimit, "Lower limit must be less than upper limit" )
    require( ( upperLimit.toLong - lowerLimit.toLong ) < Int.MaxValue, "Range is too large" )
    
    def apply() : Int = Random.nextInt( upperLimit - lowerLimit ) + lowerLimit
}