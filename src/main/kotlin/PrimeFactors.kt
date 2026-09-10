@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 * Compute the prime factors of a given natural number.
 *
 * A prime number is only evenly divisible by itself and 1.
 *
 * Note that 1 is not a prime number.
 *
 * Example
 * What are the prime factors of 60?
 *
 * Our first divisor is 2. 2 goes into 60, leaving 30.
 * 2 goes into 30, leaving 15.
 * 2 doesn't go cleanly into 15. So let's move on to our next divisor, 3.
 * 3 goes cleanly into 15, leaving 5.
 * 3 does not go cleanly into 5. The next possible factor is 4.
 * 4 does not go cleanly into 5. The next possible factor is 5.
 * 5 does go cleanly into 5.
 * We're left only with 1, so now, we're done.
 * Our successful divisors in that computation represent the list of prime factors of 60: 2, 2, 3, and 5.
 *
 * You can check this yourself:
 *
 * 2 * 2 * 3 * 5
 * = 4 * 15
 * = 60
 * Success!
 *
 */

object PrimeFactorCalculator {
    fun primeFactors(int: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var number = int
        var divisor = 2

        while (number > 1) {
            if (number % divisor == 0) {
                factors.add(divisor)
                number /= divisor
            } else {
                divisor++
            }
        }

        return factors
    }

    fun primeFactors(long: Long): List<Long> {
        val factors = mutableListOf<Long>()
        var number = long
        var divisor = 2L

        while (number > 1) {
            if (number % divisor == 0L) {
                factors.add(divisor) // Guardamos el factor
                number /= divisor     // Reducimos el número
            } else {
                divisor++             // Probamos con el siguiente divisor
            }
        }
        return factors
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular los factores primos de un número natural, probando
 *      divisores crecientes desde 2 hasta reducir el número a 1.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Empezar con divisor = 2 y una copia mutable del número.
 *      II.  Mientras number > 1: si divisor divide exacto, guardarlo
 *           como factor y reducir number dividiéndolo; si no,
 *           avanzar al siguiente divisor.
 *      III. Repetir hasta que number llegue a 1.
 *      IV.  La misma lógica se sobrecarga para Int y Long.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun primeFactors(int: Int): List<Int> {
 *      →      val factors = mutableListOf<Int>()
 *      →      var number = int
 *      →      var divisor = 2
 *      ①  number es una copia mutable para poder reducirla; divisor
 *          comienza en el menor primo posible.
 *
 *      →      while (number > 1) {
 *      →          if (number % divisor == 0) {
 *      →              factors.add(divisor)
 *      →              number /= divisor
 *      ②  Si divisor divide exacto a number, se agrega a la lista de
 *          factores y number se reduce dividiéndolo entre divisor.
 *
 *      →          } else {
 *      →              divisor++
 *      ③  Si no divide exacto, se prueba con el siguiente entero.
 *      →          }
 *      →      }
 *
 *      →      return factors
 *      ④  Devuelve la lista completa de factores primos encontrados.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Recursivo: fun primeFactors(n, divisor=2) que se llama a sí
 *          misma reduciendo n y avanzando divisor.
 *      B)  Optimizar probando solo 2 y luego impares, o detener el
 *          bucle en divisor*divisor > number (el resto sería primo).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN factoresPrimos(num): ListaDeEnteros
 *          factores ← LISTA_VACIA
 *          numero ← num
 *          divisor ← 2
 *          MIENTRAS numero > 1:
 *              SI numero % divisor == 0:
 *                  factores.AGREGAR(divisor)
 *                  numero ← numero / divisor
 *              SINO:
 *                  divisor ← divisor + 1
 *          DEVOLVER factores
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "primeFactors(60)"
 *      ─────────────────────────────────────────────────────────
 *      60÷2=30, 30÷2=15, 15÷3=5, 5÷5=1
 *      Resultado: [2, 2, 3, 5]
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "primeFactors(13)"
 *      ─────────────────────────────────────────────────────────
 *      divisor sube de 2 a 13 sin dividir exacto hasta 13÷13=1
 *      Resultado: [13]
 *
 *  ================================================================
 */
