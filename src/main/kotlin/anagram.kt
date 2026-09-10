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

// ▶ class Anagram(val target: String) {
//   └▶ ① target → la palabra base; se guarda como propiedad inmutable.
class Anagram(val target: String) {

    // ▶ fun match(anagrams: Collection<String>): Set<String> {
    //   └▶ ② recibe las candidatas y devuelve un Set con las que son anagramas.
    fun match(anagrams: Collection<String>): Set<String> {
        // ▶ return anagrams.filter { candidate ->
        //   └▶ ③ filter → conserva solo las candidatas para las que la
        //           lambda devuelve true.
        return anagrams.filter { candidate ->
            // ▶ candidate.lowercase() != target.lowercase() &&
            //   └▶ ④ descarta la candidata si es la misma palabra que el
            //           objetivo (ignorando mayúsculas): no es su propio anagrama.
            candidate.lowercase() != target.lowercase() &&
            // ▶ candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
            //   └▶ ⑤ .toList().sorted() → letras ordenadas; dos palabras con
            //           las mismas letras dan listas ordenadas idénticas.
            candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
        }.toSet()
        //   └▶ ⑥ .toSet() → convierte la List resultante en un Set sin duplicados.
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Dada una palabra objetivo y una colección de candidatas,
 *      encontrar las candidatas que son anagramas del objetivo,
 *      ignorando mayúsculas/minúsculas y excluyendo la propia
 *      palabra objetivo.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Comparar frecuencias de letras con groupingBy { it }
 *          .eachCount() en vez de ordenar las listas de caracteres.
 *      B)  Precalcular target.lowercase().toList().sorted() una sola
 *          vez fuera del filter para no repetir el trabajo en cada
 *          candidata.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Anagram(\"stone\").match([\"stone\",\"tones\",\"banana\",\"notes\",\"Seton\"])"
 *      ─────────────────────────────────────────────────────────
 *      "stone" == target → descartada
 *      "tones", "notes", "Seton" → mismas letras ordenadas [e,n,o,s,t]
 *      "banana" → letras distintas → descartada
 *      Resultado: {"tones", "notes", "Seton"}
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "Anagram(\"listen\").match([\"enlist\",\"list\"])"
 *      ─────────────────────────────────────────────────────────
 *      "enlist" → mismas 6 letras que "listen" → anagrama
 *      "list" → solo 4 letras, no coincide → descartada
 *      Resultado: {"enlist"}
 *
 *  ================================================================
 */
