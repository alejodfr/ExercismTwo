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

object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val multiplesOfThree = mutableSetOf<Int>()
        for (factor in factors) {
            if (factor == 0){ continue }
            for (i in factor..(limit-1)) {
                if (i % factor == 0) {
                    multiplesOfThree.add(i)
                }
            }
        }
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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Crear un objeto singleton con una función sum(factors, limit).
 *      II.  Acumular los múltiplos en un Set mutable para evitar
 *           duplicados automáticamente.
 *      III. Recorrer cada factor; si es 0, saltarlo (evita división
 *           entre cero).
 *      IV.  Para cada factor, recorrer los números desde el propio
 *           factor hasta limit-1 y agregar los que sean múltiplos.
 *      V.   Devolver la suma de todos los múltiplos acumulados.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun sum(factors: Set<Int>, limit: Int): Int {
 *      ①  factors es el conjunto de valores base; limit es el nivel.
 *
 *      →      val multiplesOfThree = mutableSetOf<Int>()
 *      ②  Set mutable vacío: descarta duplicados automáticamente.
 *
 *      →      for (factor in factors) {
 *      →          if (factor == 0){ continue }
 *      ③  continue salta a la siguiente iteración si factor es 0,
 *          evitando la división por cero en el módulo.
 *
 *      →          for (i in factor..(limit-1)) {
 *      ④  Recorre desde factor hasta limit-1 (estrictamente menor al
 *          límite).
 *
 *      →              if (i % factor == 0) {
 *      →                  multiplesOfThree.add(i)
 *      ⑤  Si el residuo es 0, i es múltiplo exacto de factor y se
 *          agrega al set.
 *      →              }
 *      →          }
 *      →      }
 *
 *      →      return multiplesOfThree.sum()
 *      ⑥  .sum() sobre el set devuelve la suma total de los múltiplos.
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN suma(factores: ConjuntoDeEnteros, limite: Entero): Entero
 *          acumulador ← CONJUNTO VACÍO
 *          PARA CADA factor EN factores:
 *              SI factor == 0: CONTINUAR
 *              PARA i DESDE factor HASTA limite - 1:
 *                  SI i % factor == 0:
 *                      acumulador.AGREGAR(i)
 *          DEVOLVER acumulador.SUMAR()
 *      FIN FUNCIÓN
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
