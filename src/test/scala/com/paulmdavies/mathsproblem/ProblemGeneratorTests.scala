package com.paulmdavies.mathsproblem

import org.scalatest._
import org.scalatest.prop._
import Matchers._
import org.scalacheck.Gen

class ProblemGeneratorTests extends FlatSpec with Matchers with PropertyChecks
{
    it should "generate a random problem within the given bounds" in
    {
        forAll { ( low : Int, high : Int ) => whenever ( 
                low < high &&
                high.toLong - low.toLong < Int.MaxValue
            ) { 
            val generator = ProblemGenerator( low, high )
            val problem = generator.apply()
            problem.left should be >= low
            problem.left should be < high
            problem.right should be >= low
            problem.right should be < high
        } }
    }
    
    it should "fail if lower limit is less than upper limit" in
    {
        forAll { ( low : Int, high : Int ) => whenever ( !( low < high ) ) {
            an [IllegalArgumentException] should be thrownBy ProblemGenerator( low, high )
        } }
    }
    
    it should "fail if the range is too big" in
    {
        an [IllegalArgumentException] should be thrownBy ProblemGenerator( Int.MinValue + 5, Int.MaxValue - 5 )
    }
}