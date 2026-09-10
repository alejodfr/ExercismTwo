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

// ▶ object PrimeFactorCalculator {
//   └▶ ① object → singleton: una única instancia con nombre PrimeFactorCalculator.
object PrimeFactorCalculator {
    // ▶ fun primeFactors(int: Int): List<Int> {
    //   └▶ ② versión para Int; devuelve la lista de factores primos (con repetición).
    fun primeFactors(int: Int): List<Int> {
        // ▶ val factors = mutableListOf<Int>()
        // ▶ var number = int
        // ▶ var divisor = 2
        //   ├▶ ③ number → copia mutable que se irá reduciendo.
        //   └▶ ④ divisor → arranca en 2, el menor primo posible.
        val factors = mutableListOf<Int>()
        var number = int
        var divisor = 2

        // ▶ while (number > 1) {
        //   └▶ ⑤ se repite hasta reducir number a 1.
        while (number > 1) {
            // ▶ if (number % divisor == 0) {
            //   ├▶ ⑥ divisor divide exacto → factors.add(divisor) lo guarda.
            //   └▶ ⑦ number /= divisor → reduce el número dividiéndolo.
            if (number % divisor == 0) {
                factors.add(divisor)
                number /= divisor
            } else {
                // ▶ divisor++
                //   └▶ ⑧ no divide exacto → probar con el siguiente entero.
                divisor++
            }
        }

        // ▶ return factors
        return factors
    }

    // ▶ fun primeFactors(long: Long): List<Long> {
    //   └▶ ⑨ misma lógica sobrecargada para Long (números grandes); 2L y
    //           0L son literales de tipo Long.
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
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Recursivo: fun primeFactors(n, divisor=2) que se llama a sí
 *          misma reduciendo n y avanzando divisor.
 *      B)  Optimizar probando solo 2 y luego impares, o detener el
 *          bucle en divisor*divisor > number (el resto sería primo).
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
