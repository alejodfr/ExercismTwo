@file:Suppress("SpellCheckingInspection")

import java.math.BigInteger

/**
 * # Grains
 *
 * ## Introduction
 * There once was a wise servant who saved the life of a prince.
 * The king promised to pay whatever the servant could dream up.
 * Knowing that the king loved chess, the servant told the king he
 * would like to have grains of wheat. One grain on the first square
 * of a chessboard, with the number of grains doubling on each
 * successive square.
 *
 * ## Instructions
 * Calculate the number of grains of wheat on a chessboard.
 *
 * A chessboard has **64 squares**. Square 1 has one grain, square 2
 * has two grains, square 3 has four grains, and so on, doubling each
 * time.
 *
 * Write code that calculates:
 *
 *   - The number of grains on a **given square**
 *   - The **total number** of grains on the chessboard
 *
 */

// ▶ object Board {
//   └▶ ① object → singleton: una única instancia con nombre Board.
object Board {

    // ▶ fun getGrainCountForSquare(number: Int): BigInteger {
    //   └▶ ② devuelve los granos de una casilla; BigInteger porque 2⁶³
    //           supera el rango de Long.
    fun getGrainCountForSquare(number: Int): BigInteger {
        // ▶ if (number < 1 || number > 64) throw IllegalArgumentException(...)
        //   └▶ ③ valida que la casilla esté en el rango [1, 64].
        if (number < 1 || number > 64) throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
        // ▶ val bigNumber = BigInteger.valueOf(2)
        //   └▶ ④ crea el BigInteger 2, que será la base de la potencia.
        val bigNumber = BigInteger.valueOf(2)
        // ▶ return bigNumber.pow(number - 1)
        //   └▶ ⑤ pow(n-1) → 2 elevado a (n-1): casilla 1 = 2⁰ = 1;
        //           casilla 4 = 2³ = 8.
        return bigNumber.pow(number - 1)
    }

    // ▶ fun getTotalGrainCount(): BigInteger {
    //   └▶ ⑥ suma los granos de las 64 casillas.
    fun getTotalGrainCount(): BigInteger {
        // ▶ var total = BigInteger.ZERO
        //   └▶ ⑦ acumulador inicializado en 0.
        var total = BigInteger.ZERO
        // ▶ for (i in 1..64) { total += getGrainCountForSquare(i) }
        //   └▶ ⑧ recorre cada casilla y añade sus granos al total.
        for (i in 1..64){
            total += getGrainCountForSquare(i)
        }
        // ▶ return total
        return total
    }
}

fun main(){
    println("Enter a number between 1 and 64")
    val number = readln().toInt()
    println("The number of grains on square $number is ${Board.getGrainCountForSquare(number)}")
    println("The total number of grains on the chessboard is ${Board.getTotalGrainCount()}")
}



/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular la cantidad de granos de trigo en una casilla dada de
 *      un tablero de ajedrez (que se duplica en cada casilla) y el
 *      total acumulado en las 64 casillas.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Calcular el total directamente con la fórmula de la suma
 *          geométrica: 2⁶⁴ - 1, sin bucle.
 *      B)  Usar (1..64).fold(BigInteger.ZERO) { acc, i -> acc +
 *          getGrainCountForSquare(i) } en vez del bucle for.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "getGrainCountForSquare(1)"
 *      ─────────────────────────────────────────────────────────
 *      2^(1-1) = 2^0 = 1
 *      Resultado: 1 grano
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "getGrainCountForSquare(64)"
 *      ─────────────────────────────────────────────────────────
 *      2^(64-1) = 2^63 = 9.223.372.036.854.775.808
 *      Resultado: 9223372036854775808 granos
 *
 *  ================================================================
 */
