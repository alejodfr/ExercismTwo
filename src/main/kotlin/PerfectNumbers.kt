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

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Clasificar un número entero positivo como DEFICIENTE, PERFECTO
 *      o ABUNDANTE según su suma alícuota (suma de sus divisores
 *      propios, sin incluir el número mismo).
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Validar que el número sea positivo con require.
 *      II.  Recorrer desde 1 hasta naturalNumber-1 y acumular en una
 *           lista los que dividen exactamente al número.
 *      III. Sumar esa lista de divisores (suma alícuota).
 *      IV.  Comparar la suma contra el número original para elegir la
 *           clasificación.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun classify(naturalNumber: Int): Classification {
 *      →      require(naturalNumber > 0) { "The number must be greater than zero" }
 *      ①  Lanza excepción si el número no es positivo.
 *
 *      →      val divisores = mutableListOf<Int>()
 *      →      for (i in 1 until naturalNumber) {
 *      →          if (naturalNumber % i == 0) {
 *      →              divisores.add(i)
 *      ②  until crea un rango exclusivo [1, naturalNumber); si el
 *          residuo de la división es 0, i es divisor y se agrega.
 *      →          }
 *      →      }
 *
 *      →      val resultado = divisores.sum()
 *      ③  Suma todos los divisores encontrados: la suma alícuota.
 *
 *      →      return when {
 *      →          resultado == naturalNumber -> Classification.PERFECT
 *      →          resultado > naturalNumber -> Classification.ABUNDANT
 *      →          else -> Classification.DEFICIENT
 *      →      }
 *      ④  Compara la suma contra el número original: igual → PERFECT,
 *          mayor → ABUNDANT, menor → DEFICIENT.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Optimizar recorriendo solo hasta √n, sumando cada divisor y
 *          su complementario (n/divisor) para reducir de O(n) a O(√n).
 *      B)  Estilo funcional: (1 until n).filter { n % it == 0 }.sum()
 *          en vez del bucle for con lista mutable (ver
 *          FancyPerfectNumbers.kt).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN clasificar(numero): Clasificacion
 *          REQUERIR numero > 0
 *          suma ← 0
 *          PARA i DESDE 1 HASTA numero - 1:
 *              SI numero % i == 0: suma ← suma + i
 *          SI suma == numero: DEVOLVER PERFECTO
 *          SINO SI suma > numero: DEVOLVER ABUNDANTE
 *          SINO: DEVOLVER DEFICIENTE
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "classify(28)"
 *      ─────────────────────────────────────────────────────────
 *      Divisores: 1,2,4,7,14 → suma=28 → 28==28 → PERFECT
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "classify(8)"
 *      ─────────────────────────────────────────────────────────
 *      Divisores: 1,2,4 → suma=7 → 7<8 → DEFICIENT
 *
 *  ================================================================
 */
