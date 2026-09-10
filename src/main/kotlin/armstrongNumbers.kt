@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 *
 * An Armstrong number is a number that is the sum of its own digits each raised
 * to the power of the number of digits.
 *
 * For example:
 *   - 9 is an Armstrong number, because 9 = 9¹ = 9
 *   - 10 is not an Armstrong number, because 10 ≠ 1² + 0² = 1
 *   - 153 is an Armstrong number, because 153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
 *   - 154 is not an Armstrong number, because 154 ≠ 1³ + 5³ + 4³ = 1 + 125 + 64 = 190
 *
 * Write some code to determine whether a number is an Armstrong number.
 */

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val digits = input.toString().map { it - '0' }
        val power = digits.size
        return input == digits.sumOf { Math.pow(it.toDouble(), power.toDouble()).toInt() }
    }
}

fun main() {
    val testCases = listOf(9, 10, 153, 154, 370, 371, 407, 9474, 9475)
    for (n in testCases) {
        println("$n -> ${ArmstrongNumber.check(n)}")
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Determinar si un número es un número de Armstrong: la suma de
 *      sus dígitos, cada uno elevado a la cantidad total de dígitos,
 *      debe ser igual al número original.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Convertir el número a String y luego a lista de dígitos
 *           individuales (restando el código de '0').
 *      II.  Contar cuántos dígitos hay: ese es el exponente.
 *      III. Elevar cada dígito a esa potencia y sumar los resultados.
 *      IV.  Comparar la suma con el número original.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun check(input: Int): Boolean {
 *      →      val digits = input.toString().map { it - '0' }
 *      ①  .toString() convierte el número a texto; .map { it - '0' }
 *          resta el código ASCII de '0' a cada carácter, obteniendo
 *          su valor numérico ('5' - '0' = 5).
 *
 *      →      val power = digits.size
 *      ②  La cantidad de dígitos será el exponente de la fórmula.
 *
 *      →      return input == digits.sumOf { Math.pow(it.toDouble(), power.toDouble()).toInt() }
 *      ③  sumOf aplica Math.pow(digito, power) a cada dígito y suma
 *          los resultados; se compara esa suma con el número original.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar exponenciación entera manual (repeat multiply) en vez
 *          de Math.pow, evitando conversiones a Double.
 *      B)  Calcular los dígitos con operaciones aritméticas (% 10 y
 *          / 10) en vez de convertir a String.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN esArmstrong(numero): Booleano
 *          digitos ← CONVERTIR_A_TEXTO(numero).MAPEAR(c → c - '0')
 *          potencia ← digitos.TAMAÑO
 *          suma ← digitos.SUMAR { ELEVAR(d, potencia) }
 *          DEVOLVER numero == suma
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "check(153)"
 *      ─────────────────────────────────────────────────────────
 *      digits=[1,5,3], power=3
 *      1³+5³+3³ = 1+125+27 = 153 == 153 → true
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "check(10)"
 *      ─────────────────────────────────────────────────────────
 *      digits=[1,0], power=2
 *      1²+0² = 1 != 10 → false
 *
 *  ================================================================
 */
