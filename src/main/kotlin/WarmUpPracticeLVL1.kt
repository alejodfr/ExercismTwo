@file:Suppress("SpellCheckingInspection")

import kotlin.math.pow


// ─────────────────────────────────────────────
//  WARM-UP PRACTICE — Level 1
//  Fill in each function body to make the main()
//  output the expected result shown in the comments.
// ─────────────────────────────────────────────


// ── 1. VARIABLES ──────────────────────────────
// Create a variable for your name that cannot be changed,
// and a variable for your age that starts at 20 and increases by 1.
// Print: "My name is <name> and next year I will be <age+1>"
fun variablesExercise() {
    // your code here
    val name = "Alejandro"
    var age = 20
    age+=1
    println("My name is $name and the next year I will be $age")
}


// ── 2. DATA TYPES ─────────────────────────────
// Declare one variable of each type: Int, Double, Char, Boolean.
// Print all four values on a single line separated by " | "
// Expected: 7 | 3.14 | K | true
fun dataTypesExercise() {
    // your code here
    val sample1: Int = 7
    val sample2: Double = 3.14
    val sample3: Char = 'K'
    val sample4: Boolean = true
    println(": $sample1 | $sample2 | $sample3 | $sample4")
}


// ── 3. NULL SAFETY — safe call & Elvis ────────
// Declare a nullable String? with the value "Kotlin".
// Print its length using a safe call.
// Then set it to null and print its value using the Elvis operator
// with the fallback "no value".
// Expected:
//   Length: 6
//   Value: no value
fun nullSafetyExercise() {
    // your code here
    var name: String? = "Kotlin"
    println("Length: ${name?.length}")
    name = null
    println("Value: ${name?: "No Value"}")

}


// ── 4. NULL SAFETY — safe cast ────────────────
// Declare an Any variable holding the number 99.
// Try to cast it to String using a safe cast and print the result.
// Then declare an Any variable holding "hello" and cast it to String,
// then print it in uppercase.
// Expected:
//   Cast Int as String: null
//   Cast String as String: HELLO
fun safeCastExercise() {
    // your code here
    val obj: Any = 99
    val str: String? = obj as? String
    println("is safe to say the word: $str")
    val name: Any = "hello"
    val trueName: String? = name as? String
    println("now is sure is safe to say the word: $trueName")

}


// ── 5. IF / ELSE as expression ────────────────
// Given a temperature value of 38, use an if/else expression
// to assign "hot" if temp > 30, "warm" if temp > 20, otherwise "cold".
// Print: "38 degrees is hot"
fun ifElseExercise() {
    val temp = 38
    // your code here
    if (temp > 30){
        println("hot")
    } else if (temp> 20){
        println("warm")
    } else{
        println("cold")
    }
}


// ── 6. WHEN — ranges ──────────────────────────
// Given a score of 85, use a when expression to assign a grade:
//   90-100 → "A", 80-89 → "B", 70-79 → "C", below 70 → "F"
// Print: "Score 85 → Grade B"
fun whenRangesExercise() {
    val score = 85
    // your code here
    val grade = when (score){
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
    println("Score $score → Grade $grade")
}


// ── 7. WHEN — type check ──────────────────────
// Declare an Any variable holding 3.14.
// Use a when expression to detect and print its type name.
// Expected: "3.14 is a Double"
fun whenTypeExercise() {
    val value: Any = 3.14
    // your code here
    when (value) {
        is Double -> "$value is a Double"
    }
}


// ── 8. FOR — range & step ─────────────────────
// Print all even numbers from 2 to 20 on one line separated by spaces.
// Expected: 2 4 6 8 10 12 14 16 18 20
fun forStepExercise() {
    // your code here
    for (i in 2..20 step 2){
        print("$i ")
    }
}


// ── 9. FOR — downTo ───────────────────────────
// Count down from 10 to 1, then print "Go!".
// Expected:
//   10 9 8 7 6 5 4 3 2 1
//   Go!
fun forDownToExercise() {
    // your code here
    for (i in 10 downTo  1){
        print("$i ")
        if (i == 1){
            println()
            println("Go!"); break
        }
    }
}


// ── 10. WHILE ─────────────────────────────────
// Use a while loop to find the first power of 2 that is greater than 100.
// Print: "First power of 2 greater than 100: 128"
fun whileExercise() {
    // your code here
    var result = 2
    while (result <= 100) {
        result = result * 2
    }
    println("First power of 2 greater than 100: $result")
}





// ── 11. DO-WHILE ──────────────────────────────
// Ask the user to guess the secret number 7.
// Since we can't read input here, simulate with a list of guesses: [3, 9, 7].
// Use a do-while loop that prints "Trying: <guess>" each iteration
// and stops when the correct guess is found.
// Print "Correct!" when done.
// Expected:
//   Trying: 3
//   Trying: 9
//   Trying: 7
//   Correct!
fun doWhileExercise() {
    val guesses = listOf(3, 9, 7)
    val secret = 7
    // your code here
    var index = 0
    do {
        println("Trying: ${guesses[index]}")
        index += 1
    } while (guesses[index-1] != secret)
    println("You found the number")
}


// ── 12. BREAK & CONTINUE ──────────────────────
// Loop from 1 to 15.
// Skip multiples of 3 with continue.
// Stop entirely when you reach a multiple of 11 with break.
// Print each number that passes both filters on one line.
// Expected: 1 2 4 5 7 8 10
fun breakContinueExercise() {
    // your code here
    for (i in 1..15) {
        if (i % 11 == 0) break       // para completamente
        if (i % 3 == 0) continue     // salta al siguiente
        print("$i ")                 // imprime si pasa ambos filtros
    }
}

// ── 13. ARRAYS ────────────────────────────────
// Create an array of 5 integers: 10, 20, 30, 40, 50.
// Change the middle element to 99.
// Print the sum of all elements.
// Expected: Sum: 219
fun arraysExercise() {
    // your code here
    val myArray: Array<Int> = arrayOf(10, 20, 30, 40, 50)
    myArray[myArray.size / 2] = 99
    var sumTotal = 0
    for (i in myArray){
        sumTotal+=i
    }
    println("Sum: $sumTotal")
}


// ── 14. ARRAY — init with lambda ──────────────
// Create an array of size 6 where each element equals its index cubed (i*i*i).
// Print the array as a list.
// Expected: [0, 1, 8, 27, 64, 125]
fun arrayCubesExercise() {
    // your code here
    val myArray = Array(6) { i -> i * i * i }
    println(myArray.toList())
}


// ── 15. LIST ──────────────────────────────────
// Start with a mutable list containing: "banana", "apple", "cherry"
// Add "mango", remove "apple", then print the list sorted alphabetically.
// Expected: [banana, cherry, mango]
fun listExercise() {
    // your code here
    val fruits = mutableListOf("banana", "apple", "cherry")
    fruits.add("mango")
    fruits.remove("apple")
    println(fruits.sorted())
}


// ── 16. SET ───────────────────────────────────
// Create a mutable set and add these words one by one:
// "sun", "moon", "sun", "star", "moon"
// Print the set and its size (duplicates should be gone).
// Expected: size = 3
fun setExercise() {
    // your code here
    val astronomy = mutableSetOf<String>()
    astronomy.add("sun")
    astronomy.add("moon")
    astronomy.add("sun")
    astronomy.add("star")
    astronomy.add("moon")
    println(astronomy)
    println("Expected: size = ${astronomy.size}")
}


// ── 17. MAP ───────────────────────────────────
// Create a mutable map of 3 countries and their capitals.
// Add one more country, then iterate and print each pair as:
// "<country> → <capital>"
fun mapExercise() {
    // your code here
}


// ── 18. MAP — safe access ─────────────────────
// Using the map from exercise 17 (or a new one), look up a key that
// does not exist and print a fallback message using ?:
// Expected: Capital of Atlantis: unknown
fun mapNullExercise() {
    val capitals = mapOf("Colombia" to "Bogotá", "Japan" to "Tokyo")
    // your code here
}


// ── MAIN ──────────────────────────────────────
fun main() {
    variablesExercise()
    dataTypesExercise()
    nullSafetyExercise()
    safeCastExercise()
    ifElseExercise()
    whenRangesExercise()
    whenTypeExercise()
    forStepExercise()
    forDownToExercise()
    whileExercise()
    doWhileExercise()
    breakContinueExercise()
    arraysExercise()
    arrayCubesExercise()
    listExercise()
    setExercise()
    mapExercise()
    mapNullExercise()
}
