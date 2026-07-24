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