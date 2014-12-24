package com.paulmdavies.mathsproblem

import org.scalatest._
import Matchers._
import org.scalatest.prop._

class AdditionProblemTests extends FlatSpec with Matchers with PropertyChecks
{
    it should "know the answer to the problem" in
    {
        forAll { ( left : Int, right : Int ) => {
            AdditionProblem( left, right ).answer should equal ( left + right )
        } }
    }
    
    it should "be able to tell if a guess is correct" in
    {
        forAll { ( left : Int, right : Int ) => {
            AdditionProblem( left, right ).guess( left + right ) should equal ( true )
            AdditionProblem( left, right ).guess( left + right + 1 ) should equal ( false )
        } }
    }
    
    it should "serialise correctly" in
    {
        forAll { ( left : Int, right : Int ) => {
            AdditionProblem( left, right ).toString should equal( "%d + %d".format( left, right ) )
        } }
    }
}