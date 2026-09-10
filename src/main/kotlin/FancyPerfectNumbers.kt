@file:Suppress("SpellCheckingInspection")
// ? Solucion Refactorizado de PerfectNumbers.kt

// ▶ enum class FancyClassification {
//   └▶ ① enum → las tres categorías posibles del número.
enum class FancyClassification {
    DEFICIENT, PERFECT, ABUNDANT
}


// ▶ object FancyPerfectNumbers {
//   └▶ ② object → singleton: una única instancia con nombre FancyPerfectNumbers.
object FancyPerfectNumbers {

    // ▶ fun classify(naturalNumber: Int): FancyClassification {
    //   └▶ ③ misma lógica que PerfectNumbers, pero en estilo funcional.
    fun classify(naturalNumber: Int): FancyClassification {
        // ▶ require(naturalNumber > 0) { "The number must be greater than zero" }
        //   └▶ ④ precondición: lanza excepción si el número no es positivo.
        require(naturalNumber > 0) { "The number must be greater than zero" }

        // ▶ val aliquotSum = (1 until naturalNumber).filter { naturalNumber % it == 0 }.sum()
        //   ├▶ ⑤ (1 until naturalNumber) → rango exclusivo, sin el número mismo.
        //   ├▶ ⑥ .filter { naturalNumber % it == 0 } → conserva solo los
        //   │       divisores exactos.
        //   └▶ ⑦ .sum() → los suma → suma alícuota, todo en una expresión.
        val aliquotSum = (1 until naturalNumber)
            .filter { naturalNumber % it == 0 }
            .sum()

        // ▶ return when {
        //   └▶ ⑧ compara aliquotSum con el número original y devuelve la
        //           clasificación correspondiente.
        return when {
            aliquotSum == naturalNumber -> FancyClassification.PERFECT
            aliquotSum > naturalNumber -> FancyClassification.ABUNDANT
            else -> FancyClassification.DEFICIENT
        }
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Versión funcional de PerfectNumbers.kt: clasificar un número
 *      natural como DEFICIENTE, PERFECTO o ABUNDANTE según su suma
 *      alícuota, usando filter + sum en vez de un bucle for manual.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Optimizar recorriendo solo hasta √n y sumando cada divisor
 *          junto con su complementario (n / divisor).
 *      B)  Usar sumOf en vez de filter + sum: (1 until n).sumOf { if
 *          (n % it == 0) it else 0 }.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "classify(6)"
 *      ─────────────────────────────────────────────────────────
 *      Divisores: 1,2,3 → suma=6 → 6==6 → PERFECT
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "classify(12)"
 *      ─────────────────────────────────────────────────────────
 *      Divisores: 1,2,3,4,6 → suma=16 → 16>12 → ABUNDANT
 *
 *  ================================================================
 */
