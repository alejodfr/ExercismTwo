@file:Suppress("SpellCheckingInspection")

/**
 * Perfect Numbers
 *
 * Determine if a number is perfect, abundant, or deficient based on
 * Nicomachus' (60-120 CE) classification scheme for positive integers.
 *
 * The aliquot sum is the sum of the factors of a number not including
 * the number itself. For example, the aliquot sum of 15 is 1 + 3 + 5 = 9.
 *
 * Perfect  — a number equals its aliquot sum.
 *   e.g. 6  = 1 + 2 + 3
 *        28 = 1 + 2 + 4 + 7 + 14
 *
 * Abundant — a number is less than its aliquot sum.
 *   e.g. 12 → 1 + 2 + 3 + 4 + 6 = 16  (> 12)
 *        24 → 1 + 2 + 3 + 4 + 6 + 8 + 12 = 36  (> 24)
 *
 * Deficient — a number is greater than its aliquot sum.
 *   e.g. 8 → 1 + 2 + 4 = 7  (< 8)
 *        Prime numbers are always deficient.
 */

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) { "The number must be greater than zero" }

    val divisores = mutableListOf<Int>()
    for (i in 1 until naturalNumber) {
        if (naturalNumber % i == 0) {
            divisores.add(i)
        }
    }

    val resultado = divisores.sum()

    return when {
        resultado == naturalNumber -> Classification.PERFECT
        resultado > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Clasificar un número entero positivo como DEFICIENTE, PERFECTO o
 *  ABUNDANTE según su suma alícuota (suma de sus divisores propios).
 *
 *  -----------------------------------------------------------------
 *  🧠  ANÁLISIS DE LA SOLUCIÓN
 *
 *  fun classify(naturalNumber: Int): Classification {
 *      require(naturalNumber > 0) { "The number must be greater than zero" }
 *
 *      val divisores = mutableListOf<Int>()
 *      for (i in 1 until naturalNumber) {
 *          if (naturalNumber % i == 0) divisores.add(i)
 *      }
 *
 *      val resultado = divisores.sum()
 *
 *      return when {
 *          resultado == naturalNumber -> Classification.PERFECT
 *          resultado > naturalNumber  -> Classification.ABUNDANT
 *          else                       -> Classification.DEFICIENT
 *      }
 *  }
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  require(naturalNumber > 0)
 *      — Lanza una excepción si el número no es positivo. Es una
 *      precondición que garantiza que el resto del código recibe
 *      una entrada válida.
 *
 *  2.  for (i in 1 until naturalNumber)
 *      — Itera desde 1 hasta naturalNumber - 1 (excluye al propio
 *      número). El operador until crea un rango semiabierto.
 *
 *  3.  naturalNumber % i == 0
 *      — Si el residuo de la división es 0, entonces i es divisor.
 *
 *  4.  divisores.sum()
 *      — Función de extensión que suma todos los elementos de la
 *      lista. Equivale a la suma alícuota.
 *
 *  5.  when { ... }
 *      — Expresión condicional que compara la suma alícuota contra
 *      el número original y devuelve la clasificación correspondiente.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  require()                │  Valida precondiciones           │
 *  │  until                    │  Rango exclusivo [1, n)          │
 *  │  % (módulo)               │  Detecta divisores exactos       │
 *  │  MutableList / .add()     │  Colección mutable de divisores  │
 *  │  .sum()                   │  Suma todos los elementos        │
 *  │  when                     │  Expresión condicional múltiple  │
 *  │  enum class               │  Conjunto fijo de constantes     │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  Con optimización hasta √n (más eficiente):
 *      var suma = 1  // 1 siempre es divisor
 *      for (i in 2..sqrt(n).toInt()) {
 *          if (n % i == 0) {
 *              suma += i
 *              if (i != n / i) suma += n / i
 *          }
 *      }
 *
 *  B)  Con programación funcional:
 *      val suma = (1 until n).filter { n % it == 0 }.sum()
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  La solución actual es O(n) porque recorre todos los números
 *  desde 1 hasta n-1. Para números grandes, el enfoque con √n
 *  (alternativa A) reduce la complejidad a O(√n).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  FUNCIÓN clasificar(numero: Entero): Clasificacion
 *      ASSERT numero > 0
 *
 *      suma := 0
 *
 *      PARA CADA i DESDE 1 HASTA numero - 1:
 *          SI numero % i == 0:
 *              suma := suma + i
 *          FIN SI
 *      FIN PARA
 *
 *      SI suma == numero:
 *          DEVOLVER PERFECTO
 *      SINO SI suma > numero:
 *          DEVOLVER ABUNDANTE
 *      SINO:
 *          DEVOLVER DEFICIENTE
 *      FIN SI
 *  FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: n = 6
 *  ─────────────────────────────────────────────────────────────────
 *  Divisores propios: 1, 2, 3
 *  Suma alícuota:     1 + 2 + 3 = 6
 *  Comparación:       6 == 6
 *  Resultado:         Classification.PERFECT  ✅
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: n = 12
 *  ─────────────────────────────────────────────────────────────────
 *  Divisores propios: 1, 2, 3, 4, 6
 *  Suma alícuota:     1 + 2 + 3 + 4 + 6 = 16
 *  Comparación:       16 > 12
 *  Resultado:         Classification.ABUNDANT  ✅
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 3: n = 8
 *  ─────────────────────────────────────────────────────────────────
 *  Divisores propios: 1, 2, 4
 *  Suma alícuota:     1 + 2 + 4 = 7
 *  Comparación:       7 < 8
 *  Resultado:         Classification.DEFICIENT  ✅
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 4: n = 1 (caso borde)
 *  ─────────────────────────────────────────────────────────────────
 *  Divisores propios: (ninguno, el for va de 1 until 1 = vacío)
 *  Suma alícuota:     0
 *  Comparación:       0 < 1
 *  Resultado:         Classification.DEFICIENT  ✅
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 5: n = 28
 *  ─────────────────────────────────────────────────────────────────
 *  Divisores propios: 1, 2, 4, 7, 14
 *  Suma alícuota:     1 + 2 + 4 + 7 + 14 = 28
 *  Comparación:       28 == 28
 *  Resultado:         Classification.PERFECT  ✅
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 6: n = 0 (precondición)
 *  ─────────────────────────────────────────────────────────────────
 *  require(0 > 0) → IllegalArgumentException
 *  Resultado:         EXCEPCIÓN  ❌
 *
 *  ================================================================
 */