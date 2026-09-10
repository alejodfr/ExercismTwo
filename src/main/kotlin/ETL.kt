@file:Suppress("SpellCheckingInspection")


/**
 * # ETL — Extract, Transform, Load
 *
 * ## Introduction
 * You work for a company that makes an online multiplayer game called
 * **Lexiconia**.
 *
 * To play the game, each player is given 13 letters, which they must
 * rearrange to create words. Different letters have different point
 * values, since it's easier to create words with some letters than others.
 *
 * The game was originally launched in English, but it is very popular,
 * and now the company wants to expand to other languages as well.
 *
 * Different languages need to support different point values for letters.
 * The point values are determined by how often letters are used, compared
 * to other letters in that language.
 *
 * For example, the letter **C** is quite common in English, and is only
 * worth 3 points. But in Norwegian it's a very rare letter, and is worth
 * 10 points.
 *
 * ## Instructions
 * Your task is to change the data format of letters and their point
 * values in the game.
 *
 * Currently, letters are stored in groups based on their score, in a
 * **one-to-many** mapping:
 *
 * ```
 *  1 point:  "A", "E", "I", "O", "U", "L", "N", "R", "S", "T"
 *  2 points: "D", "G"
 *  3 points: "B", "C", "M", "P"
 *  4 points: "F", "H", "V", "W", "Y"
 *  5 points: "K"
 *  8 points: "J", "X"
 * 10 points: "Q", "Z"
 * ```
 *
 * This needs to be changed to store each individual letter with its score
 * in a **one-to-one** mapping:
 *
 * ```
 * "a" is worth 1 point
 * "b" is worth 3 points
 * "c" is worth 3 points
 * "d" is worth 2 points
 * ...
 * ```
 *
 * As part of this change, the team has also decided to change the letters
 * to be **lower-case** rather than upper-case.
 */

object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        source.forEach { points, letters ->
            letters.forEach { letter ->
                result[letter.lowercaseChar()] = points
            }

        }
        return result
    }

}

fun main(){
    val input = mapOf(
        1 to listOf('A', 'E', 'I'),
        2 to listOf('D', 'G'),
        3 to listOf('B', 'C')
    )

    val result = ETL.transform(input)
    println(result)
    // {a=1, e=1, i=1, d=2, g=2, b=3, c=3}
}



/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Transformar un mapa uno-a-muchos (puntaje → letras mayúsculas)
 *      en un mapa uno-a-uno (letra minúscula → puntaje).
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Crear un mapa mutable vacío para el resultado.
 *      II.  Recorrer cada entrada (puntos, letras) del mapa de entrada.
 *      III. Para cada letra dentro del grupo, convertirla a minúscula
 *           y asignarle el puntaje correspondiente en el resultado.
 *      IV.  Devolver el mapa resultante.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
 *      →      val result = mutableMapOf<Char, Int>()
 *      ①  Mapa mutable vacío donde se acumulará el resultado.
 *
 *      →      source.forEach { points, letters ->
 *      ②  forEach sobre un Map itera cada entrada, desestructurando
 *          clave (points) y valor (letters).
 *
 *      →          letters.forEach { letter ->
 *      ③  Segundo forEach anidado: recorre cada letra dentro del
 *          grupo actual.
 *
 *      →              result[letter.lowercaseChar()] = points
 *      ④  .lowercaseChar() convierte la letra a minúscula; se usa
 *          como clave y points como valor en el mapa resultado.
 *      →          }
 *      →      }
 *
 *      →      return result
 *      ⑤  Devuelve el mapa uno-a-uno construido.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Estilo funcional: source.flatMap { (p, letters) -> letters
 *          .map { it.lowercaseChar() to p } }.toMap() sin mapa mutable.
 *      B)  Usar associateBy o buildMap para construir el resultado de
 *          forma más declarativa.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN transformar(fuente: Mapa<Entero, ColeccionDeChar>): Mapa<Char, Entero>
 *          resultado ← MAPA_VACIO
 *          PARA CADA (puntos, letras) EN fuente:
 *              PARA CADA letra EN letras:
 *                  resultado[letra.MINUSCULA()] ← puntos
 *          DEVOLVER resultado
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "transform({1: ['A','E'], 2: ['D']})"
 *      ─────────────────────────────────────────────────────────
 *      'A'→'a'=1, 'E'→'e'=1, 'D'→'d'=2
 *      Resultado: {a=1, e=1, d=2}
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "transform({})"
 *      ─────────────────────────────────────────────────────────
 *      forEach externo no itera (mapa vacío)
 *      Resultado: {}
 *
 *  ================================================================
 */
