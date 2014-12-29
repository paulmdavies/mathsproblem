package com.paulmdavies.mathsproblem

object DivisionProblem
{
    def apply( left : Int, right : Int ) : DivisionProblem = new DivisionProblem( left, right )
}

class DivisionProblem private [mathsproblem]( private [mathsproblem] val left : Int, private [mathsproblem] val right : Int ) extends Problem
{
    val answer = right
    
    override def toString() : String = "%d ÷ %d".format( left * right, right )
}