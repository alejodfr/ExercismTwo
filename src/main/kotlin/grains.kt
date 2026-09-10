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

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        if (number < 1 || number > 64) throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
        val bigNumber = BigInteger.valueOf(2)
        return bigNumber.pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        var total = BigInteger.ZERO
        for (i in 1..64){
            total += getGrainCountForSquare(i)
        }
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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Validar que la casilla esté entre 1 y 64.
 *      II.  Los granos en la casilla n son 2^(n-1); usar BigInteger
 *           porque 2⁶³ supera el rango de Long.
 *      III. El total es la suma de getGrainCountForSquare(i) para i
 *           de 1 a 64.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun getGrainCountForSquare(number: Int): BigInteger {
 *      →      if (number < 1 || number > 64) throw IllegalArgumentException(...)
 *      ①  Valida que la casilla esté en rango [1, 64]; si no, lanza
 *          una excepción.
 *
 *      →      val bigNumber = BigInteger.valueOf(2)
 *      ②  BigInteger permite números enteros de tamaño arbitrario,
 *          necesarios porque 2⁶⁴ excede Long.
 *
 *      →      return bigNumber.pow(number - 1)
 *      ③  pow(n-1) calcula 2 elevado a (n-1): la casilla 1 tiene
 *          2⁰=1 grano, la casilla 4 tiene 2³=8.
 *      →  }
 *
 *      →  fun getTotalGrainCount(): BigInteger {
 *      →      var total = BigInteger.ZERO
 *      →      for (i in 1..64){
 *      →          total += getGrainCountForSquare(i)
 *      ④  Acumula los granos de cada una de las 64 casillas.
 *      →      }
 *      →      return total
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Calcular el total directamente con la fórmula de la suma
 *          geométrica: 2⁶⁴ - 1, sin bucle.
 *      B)  Usar (1..64).sumOf { getGrainCountForSquare(it) } — aunque
 *          sumOf no soporta BigInteger de forma nativa, requeriría un
 *          fold en su lugar.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN granosEnCasilla(numero): BigEntero
 *          SI numero < 1 O numero > 64: LANZAR Error
 *          DEVOLVER 2 ELEVADO A (numero - 1)
 *      FIN FUNCIÓN
 *
 *      FUNCIÓN totalGranos(): BigEntero
 *          total ← 0
 *          PARA i DESDE 1 HASTA 64: total ← total + granosEnCasilla(i)
 *          DEVOLVER total
 *      FIN FUNCIÓN
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
