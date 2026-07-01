@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * At a garage sale, you find a lovely vintage typewriter at a bargain price!
 * Excitedly, you rush home, insert a sheet of paper, and start typing away.
 * However, your excitement wanes when you examine the output: all words are
 * garbled! For example, it prints "stop" instead of "post" and "least"
 * instead of "stale." Carefully, you try again, but now it prints "spot" and
 * "slate." After some experimentation, you find there is a random delay
 * before each letter is printed, which messes up the order. You now
 * understand why they sold it for so little money!
 *
 * You realize this quirk allows you to generate anagrams, which are words
 * formed by rearranging the letters of another word. Pleased with your
 * finding, you spend the rest of the day generating hundreds of anagrams.
 *
 * Instructions
 *
 * Given a target word and one or more candidate words, your task is to find
 * the candidates that are anagrams of the target.
 *
 * An anagram is a rearrangement of letters to form a new word: for example
 * "owns" is an anagram of "snow". A word is not its own anagram: for
 * example, "stop" is not an anagram of "stop".
 *
 * The target word and candidate words are made up of one or more ASCII
 * alphabetic characters (A-Z and a-z). Lowercase and uppercase characters
 * are equivalent: for example, "PoTS" is an anagram of "sTOp", but "StoP"
 * is not an anagram of "sTOp". The words you need to find should be taken
 * from the candidate words, using the same letter case.
 *
 * Given the target "stone" and the candidate words "stone", "tones",
 * "banana", "tons", "notes", and "Seton", the anagram words you need to
 * find are "tones", "notes", and "Seton".
 *
 * Track specific instructions
 *
 * The anagrams can be returned in any order.
 */

class Anagram(val target: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { candidate ->
            candidate.lowercase() != target.lowercase() &&
            candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
        }.toSet()
    }
}

/**
 * # Anagram — Guía de resolución
 *
 * ## Enunciado
 *
 * Dada una palabra objetivo (target) y una colección de candidatos,
 * encontrar cuáles candidatos son anagramas del target.
 *
 * Reglas:
 * - Una palabra no es anagrama de sí misma.
 * - Las mayúsculas y minúsculas son equivalentes.
 * - Los anagramas pueden retornarse en cualquier orden.
 *
 * Ejemplo:
 *   target = "stone"
 *   candidatos = ["stone", "tones", "banana", "notes", "Seton"]
 *   resultado  = ["tones", "notes", "Seton"]
 *
 * ## Orden de pensamiento
 *
 * 1. Dos palabras son anagramas si tienen exactamente las mismas
 *    letras en cualquier orden.
 * 2. Para comparar letras sin importar el orden, se convierten a
 *    lista, se ordenan alfabéticamente y se comparan.
 * 3. Para ignorar mayúsculas, se convierte tod0 a lowercase antes
 *    de comparar.
 * 4. Una palabra no puede ser anagrama de sí misma — hay que
 *    excluirla aunque sus letras ordenadas sean iguales.
 * 5. filter() permite quedarse solo con los candidatos que cumplan
 *    ambas condiciones.
 *
 * ## Paso a paso
 *
 * ### El constructor
 *
 *   class Anagram(val target: String)
 *
 * - target: String -> la palabra objetivo que llega desde afuera.
 *   El checker la usa así: Anagram("stone").match(candidatos)
 *
 * ### El parámetro de match()
 *
 *   fun match(anagrams: Collection<String>): Set<String>
 *
 * - Collection<String> -> superclase de List, Set, etc.
 *   Acepta cualquier tipo de colección de Strings.
 * - : Set<String> -> retorna un Set para evitar duplicados.
 *
 * ### La comparación de letras
 *
 *   "stone".lowercase().toList().sorted()  // [e, n, o, s, t]
 *   "tones".lowercase().toList().sorted()  // [e, n, o, s, t]
 *   // son iguales -> es anagrama ✅
 *
 *   "stone".lowercase().toList().sorted()  // [e, n, o, s, t]
 *   "banana".lowercase().toList().sorted() // [a, a, a, b, n, n]
 *   // son distintas -> no es anagrama ❌
 *
 * ### El filter con dos condiciones
 *
 *   anagrams.filter { candidate ->
 *       candidate.lowercase() != target.lowercase() &&
 *       candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
 *   }
 *
 * - candidate -> cada palabra de la colección en turno
 * - Primera condición: que no sea la misma palabra que target
 *   (ignorando mayúsculas)
 * - Segunda condición: que sus letras ordenadas sean iguales
 *   a las letras ordenadas del target
 * - && -> ambas condiciones deben cumplirse
 *
 * ### Convertir a Set
 *
 *   .toSet()
 *
 * - filter() retorna una List pero la función debe retornar Set.
 * - toSet() convierte la lista al tipo requerido.
 *
 * ## Código completo
 *
 *   class Anagram(val target: String) {
 *       fun match(anagrams: Collection<String>): Set<String> {
 *           return anagrams.filter { candidate ->
 *               candidate.lowercase() != target.lowercase() &&
 *               candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
 *           }.toSet()
 *       }
 *   }
 */