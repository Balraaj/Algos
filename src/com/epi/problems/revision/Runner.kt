package com.epi.problems.revision


fun main(){
}



fun columnTest(){
    myloop@    for(a in 'A'..'Z'){
        for (b in 'A'..'Z'){
            for(c in 'A'..'Z'){
                var columnNameOR = "$a$b$c"
                var index = ProblemSolver.getColumnIndexFromName(columnNameOR)
                var columnName = ProblemSolver.getColumnNameFromIndex(index)
                if(columnName != columnNameOR){
                    print("Mismatched for : $columnNameOR")
                    break@myloop
                }
                println("$columnNameOR has index: $index, and column name: $columnName")
            }
        }
    }
    print("\nSuccess")
}



