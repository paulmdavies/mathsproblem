package com.paulmdavies.mathsproblem

import org.scalatest._
import org.scalatest.prop._
import Matchers._
import org.scalacheck.Gen

class ProblemGeneratorTests extends FlatSpec with Matchers with PropertyChecks
{
    val validLimits = for ( n <- Gen.choose( -1 * ProblemGenerator.LIMIT, ProblemGenerator.LIMIT ) ) yield n 
    
    it should "generate a random problem within the given bounds" in
    {
        forAll ( validLimits, validLimits ) { ( low : Int, high : Int ) => whenever ( low < high ) { 
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
        forAll ( validLimits, validLimits ) { ( low : Int, high : Int ) => whenever ( !( low < high ) ) {
            an [IllegalArgumentException] should be thrownBy ProblemGenerator( low, high )
        } }
    }
    
    it should "fail if the lower limit is less than the minimum limit" in
    {
        forAll { ( low : Int ) => whenever ( low < -1 * ProblemGenerator.LIMIT ) {
            an [IllegalArgumentException] should be thrownBy ProblemGenerator( low, 0 )
        } }
    }
    
    it should "fail if the upper limit is more than the maximum limit" in
    {
        forAll { ( high : Int ) => whenever ( high > ProblemGenerator.LIMIT ) {
            an [IllegalArgumentException] should be thrownBy ProblemGenerator( 0, high )
        } }
    }
}