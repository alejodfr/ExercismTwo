@file:Suppress("SpellCheckingInspection")
// ? Solucion Refactorizado de PerfectNumbers.kt

enum class FancyClassification {
    DEFICIENT, PERFECT, ABUNDANT
}


object FancyPerfectNumbers {

    fun classify(naturalNumber: Int): FancyClassification {
        require(naturalNumber > 0) { "The number must be greater than zero" }

        // Filtramos directamente las letras/números en el rango y los sumamos
        val aliquotSum = (1 until naturalNumber)
            .filter { naturalNumber % it == 0 }
            .sum()

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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Validar que el número sea positivo.
 *      II.  Generar el rango 1 hasta naturalNumber-1, filtrar los que
 *           son divisores exactos y sumarlos en una sola expresión.
 *      III. Comparar la suma alícuota contra el número original para
 *           decidir la clasificación.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun classify(naturalNumber: Int): FancyClassification {
 *      →      require(naturalNumber > 0) { "The number must be greater than zero" }
 *      ①  Precondición: lanza excepción si el número no es positivo.
 *
 *      →      val aliquotSum = (1 until naturalNumber)
 *      →          .filter { naturalNumber % it == 0 }
 *      ②  filter conserva solo los i que dividen exactamente a
 *          naturalNumber (naturalNumber % i == 0).
 *
 *      →          .sum()
 *      ③  Suma todos los divisores propios encontrados: la suma
 *          alícuota.
 *
 *      →      return when {
 *      →          aliquotSum == naturalNumber -> FancyClassification.PERFECT
 *      →          aliquotSum > naturalNumber -> FancyClassification.ABUNDANT
 *      →          else -> FancyClassification.DEFICIENT
 *      →      }
 *      ④  when compara la suma alícuota contra el número original y
 *          devuelve la clasificación correspondiente.
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN clasificar(numero): Clasificacion
 *          REQUERIR numero > 0
 *          suma ← SUMAR(1 hasta numero-1 FILTRADO POR divisor exacto)
 *          SI suma == numero: DEVOLVER PERFECTO
 *          SINO SI suma > numero: DEVOLVER ABUNDANTE
 *          SINO: DEVOLVER DEFICIENTE
 *      FIN FUNCIÓN
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
