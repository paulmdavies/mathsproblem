package com.paulmdavies.mathsproblem

import org.scalatest._
import org.scalatest.prop._
import Matchers._
import org.scalacheck.Gen
import com.paulmdavies.mathsproblem.random._

class ProblemGeneratorTests extends FlatSpec with Matchers with PropertyChecks
{
    val validLimits = for ( n <- Gen.choose( RandomRange.LOWER_LIMIT, RandomRange.UPPER_LIMIT ) ) yield n
    
    it should "generate a random problem within the given bounds" in
    {
        forAll ( validLimits, validLimits ) { ( low : Int, high : Int ) => whenever ( 
                low < high
            ) { 
            val generator = ProblemGenerator( low, high )
            val problem = generator.apply()
            problem.left should be >= low
            problem.left should be <= high
            problem.right should be >= low
            problem.right should be <= high
        } }
    }
    
    it should "fail if the lower limit is greater than the upper limit" in
    {
        forAll { ( low : Int, high : Int ) => whenever ( low > high ) {
            an [IllegalArgumentException] should be thrownBy new ProblemGenerator( low, high )
        } }
    }
    
    it should "fail if the lower limit is less than the hard lower limit" in
    {
        forAll { ( low : Int ) => whenever ( low < RandomRange.LOWER_LIMIT ) {
            an [IllegalArgumentException] should be thrownBy new ProblemGenerator( low, low + 1 )
        } }
    }
    
    it should "fail if the upper limit is more than the hard upper limit" in
    {
        forAll { ( high : Int ) => whenever ( high > RandomRange.UPPER_LIMIT ) {
            an [IllegalArgumentException] should be thrownBy new ProblemGenerator( high - 1, high )
        } }
    }
}