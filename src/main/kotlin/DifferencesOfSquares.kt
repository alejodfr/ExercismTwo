@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 *
 * Find the difference between the square of the sum and the sum of the squares of the first N natural numbers.
 *
 * The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)² = 55² = 3025.
 *
 * The sum of the squares of the first ten natural numbers is 1² + 2² + ... + 10² = 385.
 *
 * Hence the difference between the square of the sum of the first ten natural numbers and the sum of the
 * squares of the first ten natural numbers is 3025 - 385 = 2640.
 *
 * You are not expected to discover an efficient solution to this yourself from first principles; research
 * is allowed, indeed, encouraged. Finding the best algorithm for the problem is a key skill in software
 * engineering.
 */

class Squares(private val n: Int) {
    fun squareOfSum() = (1..n).sum().let { it * it }
    fun sumOfSquares() = (1..n).map { it * it }.sum()
    fun difference() = squareOfSum() - sumOfSquares()
}

fun main() {
    val squares = Squares(10)
    println("square of sum:    ${squares.squareOfSum()}")   // 3025
    println("sum of squares:   ${squares.sumOfSquares()}")  // 385
    println("difference:       ${squares.difference()}")    // 2640
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular la diferencia entre el cuadrado de la suma y la suma
 *      de los cuadrados de los primeros N números naturales.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Crear una clase Squares que reciba n en el constructor.
 *      II.  squareOfSum: sumar 1..n y elevar el resultado al cuadrado.
 *      III. sumOfSquares: elevar cada número al cuadrado y sumarlos.
 *      IV.  difference: restar sumOfSquares de squareOfSum.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  class Squares(private val n: Int) {
 *      ①  n se guarda como propiedad privada e inmutable.
 *
 *      →      fun squareOfSum() = (1..n).sum().let { it * it }
 *      ②  (1..n).sum() suma el rango de 1 a n; .let { it * it } toma
 *          ese resultado (it) y lo eleva al cuadrado.
 *
 *      →      fun sumOfSquares() = (1..n).map { it * it }.sum()
 *      ③  .map { it * it } transforma cada número en su cuadrado;
 *          .sum() suma la lista de cuadrados resultante.
 *
 *      →      fun difference() = squareOfSum() - sumOfSquares()
 *      ④  Reutiliza las dos funciones anteriores y resta sus
 *          resultados.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar las fórmulas cerradas: suma = n(n+1)/2, suma de
 *          cuadrados = n(n+1)(2n+1)/6, evitando iterar el rango.
 *      B)  Calcular ambos valores en un solo fold recorriendo el
 *          rango una única vez.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      CLASE Cuadrados(n)
 *          FUNCIÓN cuadradoDeLaSuma(): DEVOLVER (SUMAR(1..n))²
 *          FUNCIÓN sumaDeCuadrados(): DEVOLVER SUMAR(1..n MAPEADO A x²)
 *          FUNCIÓN diferencia(): DEVOLVER cuadradoDeLaSuma() - sumaDeCuadrados()
 *      FIN CLASE
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Squares(10)"
 *      ─────────────────────────────────────────────────────────
 *      squareOfSum = (1+...+10)² = 55² = 3025
 *      sumOfSquares = 1²+...+10² = 385
 *      difference = 3025 - 385 = 2640
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "Squares(1)"
 *      ─────────────────────────────────────────────────────────
 *      squareOfSum = 1²=1, sumOfSquares = 1²=1
 *      difference = 1 - 1 = 0
 *
 *  ================================================================
 */
