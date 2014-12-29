package com.paulmdavies.mathsproblem.random

object RandomRangeExcludingZero
{
    def apply( lowerLimit : Int, upperLimit : Int ) : RandomRangeBase =
    {
        val filteredLowerLimit = if ( lowerLimit == 0 ) 1 else lowerLimit
        val filteredUpperLimit = if ( upperLimit == 0 ) -1 else upperLimit
        
        lowerLimit > 0 || upperLimit < 0 match
        {
            case true => RandomRange( filteredLowerLimit, filteredUpperLimit )
            case false => new RandomRangeExcludingZero( lowerLimit, upperLimit )
        }
    }
}

class RandomRangeExcludingZero private [random] (
    private [random] val lowerLimit : Int,
    private [random] val upperLimit : Int
) extends RandomRangeBase
{
    require( lowerLimit < upperLimit, "Lower limit must be less than upper limit" )
    
    private [random] val randomRange = RandomRange( lowerLimit, upperLimit - 1 )
    
    def apply() : Int =
    {
        val rand = randomRange()
        if ( rand >= 0 ) rand + 1 else rand
    }
}