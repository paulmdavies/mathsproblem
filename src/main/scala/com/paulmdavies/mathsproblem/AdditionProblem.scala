package com.paulmdavies.mathsproblem

object AdditionProblem
{
    def apply( left : Int, right : Int ) : AdditionProblem =
    {
        new AdditionProblem( left, right )
    }
}

class AdditionProblem private [mathsproblem] ( private [mathsproblem] val left : Int, private [mathsproblem] val right : Int )
{
    private [mathsproblem] val answer = left + right
    
    def guess( possibleAnswer : Int ) : Boolean = possibleAnswer == answer
    
    override def toString() : String = "%d + %d".format( left, right )
}