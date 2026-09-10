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

// ▶ enum class Classification {
//   └▶ ① enum → conjunto fijo de constantes con nombre; las tres
//           categorías posibles del número.
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

// ▶ fun classify(naturalNumber: Int): Classification {
//   └▶ ② recibe un entero y devuelve una de las tres constantes del enum.
fun classify(naturalNumber: Int): Classification {
    // ▶ require(naturalNumber > 0) { "The number must be greater than zero" }
    //   └▶ ③ require → lanza IllegalArgumentException si el número no es positivo.
    require(naturalNumber > 0) { "The number must be greater than zero" }

    // ▶ val divisores = mutableListOf<Int>()
    //   └▶ ④ lista mutable donde se acumulan los divisores propios.
    val divisores = mutableListOf<Int>()
    // ▶ for (i in 1 until naturalNumber) {
    //   └▶ ⑤ until → rango exclusivo [1, naturalNumber): no incluye el
    //           número mismo.
    for (i in 1 until naturalNumber) {
        // ▶ if (naturalNumber % i == 0) { divisores.add(i) }
        //   └▶ ⑥ % → resto; si es 0, i divide exacto y es divisor propio.
        if (naturalNumber % i == 0) {
            divisores.add(i)
        }
    }

    // ▶ val resultado = divisores.sum()
    //   └▶ ⑦ suma alícuota: la suma de todos los divisores propios.
    val resultado = divisores.sum()

    // ▶ return when {
    //   └▶ ⑧ compara la suma contra el número: igual → PERFECT, mayor →
    //           ABUNDANT, menor → DEFICIENT.
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
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Optimizar recorriendo solo hasta √n, sumando cada divisor y
 *          su complementario (n/divisor) para reducir de O(n) a O(√n).
 *      B)  Estilo funcional: (1 until n).filter { n % it == 0 }.sum()
 *          en vez del bucle for con lista mutable (ver
 *          FancyPerfectNumbers.kt).
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
