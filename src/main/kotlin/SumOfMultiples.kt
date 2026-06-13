@file:Suppress("SpellCheckingInspection")

/*
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
 * # Sum of Multiples — Guía de resolución
 *
 * ## Enunciado
 *
 * Dado un conjunto de factores y un límite, hay que encontrar todos los
 * múltiplos de cada factor que sean menores que el límite, combinarlos
 * sin duplicados, y sumarlos.
 *
 * Ejemplo: factors = {3, 5}, limit = 20 -> resultado 78
 *
 * ## Orden de pensamiento
 *
 * 1. Necesito generar múltiplos de cada factor — eso implica recorrer
 *    números y verificar con %.
 * 2. Hay varios factores, no uno solo — eso implica un loop por cada factor.
 * 3. Por cada factor, hay varios múltiplos — eso implica otro loop dentro
 *    del primero (anidado).
 * 4. Los múltiplos no deben repetirse — un Set resuelve esto automáticamente.
 * 5. Al final, hay que sumar tod0 — sum() lo hace directo.
 * 6. Caso especial: si un factor es 0, no debe afectar el resultado.
 *    Hay que detectarlo y saltarlo antes de operar con él.
 *
 * ## Paso a paso
 *
 * ### El object
 *
 *   object SumOfMultiples {
 *
 * `object` crea un singleton — no necesitas instanciarlo, se usa
 * directamente como SumOfMultiples.sum(...)
 *
 * ### La función y sus parámetros
 *
 *   fun sum(factors: Set<Int>, limit: Int): Int {
 *
 * - factors: Set<Int> -> el conjunto de factores base (ej. {3, 5}).
 *   Es Set porque cada factor es único, no hay razón para repetirlos.
 * - limit: Int -> el número límite (el nivel del jugador).
 * - : Int -> la función retorna un número entero, la suma final.
 *
 * ### El conjunto acumulador
 *
 *   val multiplesOfThree = mutableSetOf<Int>()
 *
 * - mutableSetOf<Int>() -> un Set vacío y mutable de enteros.
 * - Es Set (no List) porque elimina duplicados automáticamente — si dos
 *   factores comparten un múltiplo (como el 15 con factores 3 y 5),
 *   solo se guarda una vez.
 * - Es mutable porque necesitamos agregar elementos dentro del loop.
 * - Se declara FUERA de los loops — si estuviera dentro, se reiniciaría
 *   vacío en cada iteración.
 *
 * ### Loop exterior — recorrer cada factor
 *
 *   for (factor in factors) {
 *
 * Recorre cada elemento del conjunto factors uno por uno.
 * En la primera vuelta factor = 3, en la segunda factor = 5.
 *
 * ### Caso especial — factor 0
 *
 *   if (factor == 0) { continue }
 *
 * - Si factor es 0, cualquier operación i % factor lanzaría
 *   ArithmeticException (división por cero).
 * - La regla del ejercicio dice que un factor 0 no debe afectar el
 *   resultado, es decir, debe ignorarse por completo.
 * - `continue` salta directamente a la siguiente iteración del loop
 *   exterior, sin ejecutar el loop interior para ese factor.
 * - Se coloca justo al inicio del loop exterior, ANTES del loop interior,
 *   para evitar que se ejecute cualquier código con ese factor inválido.
 *
 * ### Loop interior — generar los múltiplos de ese factor
 *
 *   for (i in factor..(limit - 1)) {
 *
 * - factor..(limit - 1) -> un rango desde el factor actual hasta limit - 1.
 * - El -1 es clave: la regla pide múltiplos MENORES QUE el límite, y ..
 *   en Kotlin es inclusivo, así que restamos 1 para excluir el límite mismo.
 *
 * ### Verificar si es múltiplo
 *
 *   if (i % factor == 0) {
 *       multiplesOfThree.add(i)
 *   }
 *
 * - i % factor == 0 -> el operador % retorna el residuo de la división.
 *   Si el residuo es 0, significa que i es divisible exactamente entre
 *   factor, es decir, es un múltiplo.
 * - .add(i) -> agrega i al set. Si ya estaba (porque otro factor generó
 *   el mismo múltiplo), el Set lo ignora silenciosamente.
 *
 * ### Retornar la suma
 *
 *   return multiplesOfThree.sum()
 *
 * - .sum() -> función de Kotlin que suma todos los elementos de una
 *   colección numérica.
 * - Retorna ese total como el resultado de la función.
 *
 * ## Código completo
 *
 *   object SumOfMultiples {
 *       fun sum(factors: Set<Int>, limit: Int): Int {
 *           val multiplesOfThree = mutableSetOf<Int>()
 *           for (factor in factors) {
 *               if (factor == 0) { continue }
 *               for (i in factor..(limit - 1)) {
 *                   if (i % factor == 0) {
 *                       multiplesOfThree.add(i)
 *                   }
 *               }
 *           }
 *           return multiplesOfThree.sum()
 *       }
 *   }
 */