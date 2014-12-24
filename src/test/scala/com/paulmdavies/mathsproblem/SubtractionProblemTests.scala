package com.paulmdavies.mathsproblem

import org.scalatest._
import Matchers._
import org.scalatest.prop._

class SubtractionProblemTests extends FlatSpec with Matchers with PropertyChecks
{
    it should "know the answer to the problem" in
    {
        forAll { ( left : Int, right : Int ) => {
            SubtractionProblem( left, right ).answer should equal ( left - right )
        } }
    }
    
    it should "be able to tell if a guess is correct" in
    {
        forAll { ( left : Int, right : Int ) => {
            SubtractionProblem( left, right ).guess( left - right ) should equal ( true )
            SubtractionProblem( left, right ).guess( left - right + 1 ) should equal ( false )
        } }
    }
    
    it should "serialise correctly" in
    {
        forAll { ( left : Int, right : Int ) => {
            SubtractionProblem( left, right ).toString should equal( "%d - %d".format( left, right ) )
        } }
    }
}