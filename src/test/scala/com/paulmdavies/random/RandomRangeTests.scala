package com.paulmdavies.random

import org.scalatest._
import org.scalatest.prop._
import Matchers._

class RandomRangeTests extends FlatSpec with Matchers with PropertyChecks
{
    it should "fail if the lower limit is greater than or equal to the upper limit" in
    {
        forAll { ( low : Int, high : Int ) => whenever ( !( low < high ) ) {
            an [IllegalArgumentException] should be thrownBy RandomRange( low, high )
        } }
    }
    
    it should "fail if the range is too big" in
    {
        an [IllegalArgumentException] should be thrownBy RandomRange( Int.MinValue + 5, Int.MaxValue - 5 )
    }
    
    it should "generate numbers between the lower limit (inclusive) and the upper limit (exclusive)" in
    {
        forAll { ( low : Int, high : Int ) => whenever ( 
            low < high && 
            high.toLong - low.toLong < Int.MaxValue
        ) {
            val rr = RandomRange( low, high )
            val rand = rr()
            rand should be >= low
            rand should be <= high
        } }
    }
}