package com.paulmdavies.mathsproblem

object MultiplicationProblem
{
    def apply( left : Int, right : Int ) : MultiplicationProblem = new MultiplicationProblem( left, right )
}

class MultiplicationProblem private [mathsproblem]( private [mathsproblem] val left : Int, private [mathsproblem] val right : Int ) extends Problem
{
    val answer = left * right
    
    override def toString() : String = "%d ⨉  %d".format( left, right )
}