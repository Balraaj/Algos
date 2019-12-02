package com.epi.problems.revision

object ProblemSolver{

    fun convertBase(number: String, base1: Int, base2: Int) : String{
        var signed = number[0] == '-' || number[0] == '+'
        var negative = signed && number[0] == '-'

        var startIndex = if(signed) 1 else 0
        var base10Number = 0

        for(i in startIndex until(number.length)){
            var digit = getDigitFromChar(number[i])
            base10Number = (base10Number * base1) + digit
        }

        var result = StringBuilder()
        while(base10Number > 0){
            var char = getCharFromDigit(base10Number % base2)
            result.append(char)
            base10Number/=base2
        }
        if(negative) result.append('-')
        return result.reverse().toString()
    }

    private fun getDigitFromChar(char: Char): Int{
        var intValue = char.toInt()
        return when(intValue){
            in 48..57 -> intValue - 48
            in 65..70 -> intValue - 55
            else -> throw NumberFormatException("Out of range")
        }
    }

    private fun getCharFromDigit(value: Int): Char{
        return when(value){
            in 0..9 -> (48 + value).toChar()
            in 10..15 -> (55 + value).toChar()
            else -> throw NumberFormatException("Out of range")
        }
    }


    fun getColumnIndexFromName(columnName: String): Int{
        var result = 0
        for(char in columnName){
            result = (result * 26) + char.toInt() - 'A'.toInt() + 1
        }
        return result
    }

    fun getColumnNameFromIndex(index: Int): String{
        var index = index
        var result = StringBuilder()
        while(index > 0){
            var reminder = index % 26
            var char = 'Z'
            if(reminder == 0){
                index = index / 26 -1
            }
            else{
                char = (64+reminder).toChar()
                index /= 26
            }
            result.append(char)
        }
        return result.reverse().toString()
    }

}