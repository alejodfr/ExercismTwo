@file:Suppress("SpellCheckingInspection")
// ? Solucion Refactorizado de PerfectNumbers.kt

object PerfectNumbers {

    fun classify(naturalNumber: Int): Classification {
        require(naturalNumber > 0) { "The number must be greater than zero" }

        // Filtramos directamente las letras/números en el rango y los sumamos
        val aliquotSum = (1 until naturalNumber)
            .filter { naturalNumber % it == 0 }
            .sum()

        return when {
            aliquotSum == naturalNumber -> Classification.PERFECT
            aliquotSum > naturalNumber -> Classification.ABUNDANT
            else -> Classification.DEFICIENT
        }
    }
}