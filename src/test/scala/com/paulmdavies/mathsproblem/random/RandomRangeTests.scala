package com.paulmdavies.mathsproblem.random

import org.scalatest._
import org.scalatest.prop._
import org.scalacheck.Gen
import org.scalatest.Matchers._
import com.paulmdavies.mathsproblem.random._

class RandomRangeTests extends FlatSpec with Matchers with PropertyChecks
{
    val validLimits = for ( n <- Gen.choose( RandomRange.LOWER_LIMIT, RandomRange.UPPER_LIMIT ) ) yield n
    
    it should "fail if the lower limit is greater than or equal to the upper limit" in
    {
        forAll { ( low : Int, high : Int ) => whenever ( !( low < high ) ) {
            an [IllegalArgumentException] should be thrownBy new RandomRange( low, high )
        } }
    }
    
    it should "fail if the lower limit is less than the hard lower limit" in
    {
        forAll { ( low : Int ) => whenever ( low < RandomRange.LOWER_LIMIT ) {
            an [IllegalArgumentException] should be thrownBy new RandomRange( low, low + 1 )
        } }
    }
    
    it should "fail if the upper limit is more than the hard upper limit" in
    {
        forAll { ( high : Int ) => whenever ( high > RandomRange.UPPER_LIMIT ) {
            an [IllegalArgumentException] should be thrownBy new RandomRange( high - 1, high )
        } }
    }
    
    it should "generate numbers between the lower limit (inclusive) and the upper limit (inclusive)" in
    {
        forAll ( validLimits, validLimits ){ ( low : Int, high : Int ) => whenever ( 
            low < high 
        ) {
            val rr = RandomRange( low, high )
            val rand = rr()
            rand should be >= low
            rand should be <= high
        } }
    }
}