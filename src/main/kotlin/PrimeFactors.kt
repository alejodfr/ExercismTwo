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

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Calcular los factores primos de un número natural dado.
 *
 *  -----------------------------------------------------------------
 *  🧠  ANÁLISIS DE LA SOLUCIÓN
 *
 *  object PrimeFactorCalculator {
 *      fun primeFactors(int: Int): List<Int> {
 *          val factors = mutableListOf<Int>()
 *          var number = int
 *          var divisor = 2
 *          while (number > 1) {
 *              if (number % divisor == 0) {
 *                  factors.add(divisor)
 *                  number /= divisor
 *              } else {
 *                  divisor++
 *              }
 *          }
 *          return factors
 *      }
 *
 *      fun primeFactors(long: Long): List<Long> {
 *          // Misma lógica con tipos Long
 *      }
 *  }
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  `object PrimeFactorCalculator` — Objeto singleton que agrupa las funciones.
 *  2.  `mutableListOf` — Crea una lista mutable para acumular factores.
 *  3.  Variable `number` — Copia mutable del argumento para poder reducirla.
 *  4.  Variable `divisor` — Entero que se prueba como factor, comenzando en 2.
 *  5.  `while (number > 1)` — Bucle principal: mientras quede número por factorizar.
 *  6.  `if (number % divisor == 0)` — Si divide exacto, se agrega a factores y se reduce `number`.
 *  7.  `else { divisor++ }` — Si no divide exacto, se prueba el siguiente entero.
 *  8.  Sobrecarga (overloading) — Misma función para `Int` y `Long`.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  object                   │  Singleton contenedor de funciones│
 *  │  var                      │  Variable mutable para `number`   │
 *  │  val                      │  Lista inmutable devuelta        │
 *  │  mutableListOf            │  Lista mutable para factores     │
 *  │  while                    │  Bucle de factorización          │
 *  │  if/else                  │  Control de divisibilidad        │
 *  │  % (módulo)               │  Verificar divisibilidad exacta  │
 *  │  /= (asignación div)      │  Reducir `number` tras cada div  │
 *  │  Sobrecarga               │  Misma función para Int y Long   │
 *  │  Long                     │  Tipo de 64 bits para números    │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  Recursivo — Función que se llama a sí misma reduciendo `n` y probando divisores.
 *  B)  Secuencia infinita — Usar `generateSequence` para iterar divisores y `flatMap` para extraer factores.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  Complejidad O(sqrt(n)) en el peor caso, ya que el divisor crece hasta la raíz cuadrada.
 *  Memoria O(k) donde k es la cantidad de factores primos.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  OBJETO CalculadoraFactoresPrimos
 *      FUNCIÓN factoresPrimos(num: Int|Long): ListaDe<Int|Long>
 *          factores := lista vacía
 *          numero := num
 *          divisor := 2
 *          MIENTRAS numero > 1
 *              SI numero % divisor == 0 ENTONCES
 *                  agregar divisor a factores
 *                  numero := numero / divisor
 *              SINO
 *                  divisor := divisor + 1
 *              FIN SI
 *          FIN MIENTRAS
 *          DEVOLVER factores
 *      FIN FUNCIÓN
 *  FIN OBJETO
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: "60"
 *  ─────────────────────────────────────────────────────────────────
 *  divisor=2, n=60 → 60%2=0 → add 2, n=30
 *  divisor=2, n=30 → 30%2=0 → add 2, n=15
 *  divisor=2, n=15 → 15%2≠0 → divisor=3
 *  divisor=3, n=15 → 15%3=0 → add 3, n=5
 *  divisor=3, n=5  → 5%3≠0  → divisor=4
 *  divisor=4, n=5  → 5%4≠0  → divisor=5
 *  divisor=5, n=5  → 5%5=0  → add 5, n=1
 *  Resultado: [2, 2, 3, 5]
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: "13"
 *  ─────────────────────────────────────────────────────────────────
 *  divisor=2, n=13 → 13%2≠0 → divisor=3
 *  divisor=3, n=13 → 13%3≠0 → divisor=4
 *  ... hasta divisor=13 → 13%13=0 → add 13, n=1
 *  Resultado: [13]
 *
 *  ================================================================
 */