@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * You work for a company that makes an online, fantasy-survival game.
 * When a player finishes a level, they are awarded energy points.
 * The amount of energy awarded depends on which magical items the
 * player found while exploring that level.
 *
 * Instructions
 *
 * Your task is to write the code that calculates the energy points
 * awarded to players when they complete a level.
 *
 * The points depend on two things:
 * - The level (a number) that the player completed.
 * - The base value of each magical item collected during that level.
 *
 * Rules:
 * 1. For each magical item, take the base value and find all its
 *    multiples that are less than the level number.
 * 2. Combine the sets of numbers.
 * 3. Remove any duplicates.
 * 4. Calculate the sum of all remaining numbers.
 *
 * Example:
 * Player completed level 20 and found two items with base values 3 and 5.
 *
 * Multiples of 3 less than 20: {3, 6, 9, 12, 15, 18}
 * Multiples of 5 less than 20: {5, 10, 15}
 * Combined (duplicates removed): {3, 5, 6, 9, 10, 12, 15, 18}
 * Sum: 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78
 * Therefore, the player earns 78 energy points.
 */

// ▶ object SumOfMultiples {
//   └▶ ① object → singleton: una única instancia con nombre SumOfMultiples.
object SumOfMultiples {

    // ▶ fun sum(factors: Set<Int>, limit: Int): Int {
    //   └▶ ② factors → conjunto de valores base; limit → el nivel alcanzado.
    fun sum(factors: Set<Int>, limit: Int): Int {
        // ▶ val multiplesOfThree = mutableSetOf<Int>()
        //   └▶ ③ Set mutable vacío: descarta duplicados automáticamente.
        val multiplesOfThree = mutableSetOf<Int>()
        // ▶ for (factor in factors) {
        //   └▶ ④ recorre cada valor base del conjunto.
        for (factor in factors) {
            // ▶ if (factor == 0) { continue }
            //   └▶ ⑤ continue → salta a la siguiente iteración; evita dividir
            //           entre cero más abajo.
            if (factor == 0){ continue }
            // ▶ for (i in factor..(limit - 1)) {
            //   └▶ ⑥ recorre desde factor hasta limit-1 (estrictamente menor
            //           que el límite).
            for (i in factor..(limit-1)) {
                // ▶ if (i % factor == 0) {
                //   └▶ ⑦ % → resto; si es 0, i es múltiplo exacto de factor.
                if (i % factor == 0) {
                    // ▶ multiplesOfThree.add(i)
                    //   └▶ ⑧ agrega i al set (si ya estaba, no se duplica).
                    multiplesOfThree.add(i)
                }
            }
        }
        // ▶ return multiplesOfThree.sum()
        //   └▶ ⑨ .sum() sobre el set devuelve la suma total de los múltiplos.
        return multiplesOfThree.sum()
    }
}

fun main(){
    val factors = setOf(3,5)
    val limit = 20
    println(SumOfMultiples.sum(factors, limit))
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular los puntos de energía otorgados a un jugador: para
 *      cada objeto mágico (con un valor base), tomar todos sus
 *      múltiplos menores al nivel, combinarlos sin duplicados y
 *      sumarlos.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Estilo funcional: (1 until limit).filter { n -> factors.any
 *          { it != 0 && n % it == 0 } }.sum() — sin bucles anidados
 *          explícitos.
 *      B)  Fórmula matemática cerrada (suma de progresión aritmética)
 *          para cada factor y aplicar inclusión-exclusión para evitar
 *          contar dos veces los múltiplos comunes.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "sum({3, 5}, 20)"
 *      ─────────────────────────────────────────────────────────
 *      Múltiplos de 3 < 20: {3,6,9,12,15,18}
 *      Múltiplos de 5 < 20: {5,10,15}
 *      Unión sin duplicados: {3,5,6,9,10,12,15,18}
 *      Resultado: 78
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "sum({0, 3}, 10)"
 *      ─────────────────────────────────────────────────────────
 *      factor=0 → continue (se ignora)
 *      factor=3 → múltiplos {3,6,9}
 *      Resultado: 18
 *
 *  ================================================================
 */
