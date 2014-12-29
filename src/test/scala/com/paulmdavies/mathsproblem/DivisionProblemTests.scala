package com.paulmdavies.mathsproblem

import org.scalatest._
import Matchers._
import org.scalatest.prop._

class DivisionProblemTests extends FlatSpec with Matchers with PropertyChecks
{
    it should "know the answer to the problem" in
    {
        forAll { ( left : Int, right : Int ) => {
            DivisionProblem( left, right ).answer should equal ( right )
        } }
    }
    
    it should "be able to tell if a guess is correct" in
    {
        forAll { ( left : Int, right : Int ) => {
            DivisionProblem( left, right ).guess( right ) should equal ( true )
            DivisionProblem( left, right ).guess( right + 1 ) should equal ( false )
        } }
    }
    
    it should "serialise correctly" in
    {
        forAll { ( left : Int, right : Int ) => {
            DivisionProblem( left, right ).toString should equal( "%d ÷ %d".format( left * right, right ) )
        } }
    }
}