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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Guardar la palabra objetivo en el constructor de la clase.
 *      II.  Para cada candidata, comparar en minúsculas que no sea
 *           igual al objetivo (una palabra no es su propio anagrama).
 *      III. Convertir ambas palabras a listas de caracteres ordenadas
 *           y compararlas: si coinciden, son anagramas.
 *      IV.  Devolver el resultado como Set para evitar duplicados.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  class Anagram(val target: String) {
 *      ①  target se guarda como propiedad inmutable de la clase.
 *
 *      →      fun match(anagrams: Collection<String>): Set<String> {
 *      →          return anagrams.filter { candidate ->
 *      ②  filter conserva solo las candidatas para las que la lambda
 *          devuelve true.
 *
 *      →              candidate.lowercase() != target.lowercase() &&
 *      ③  Descarta la candidata si es exactamente la misma palabra que
 *          el objetivo (ignorando mayúsculas).
 *
 *      →              candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
 *      ④  Convierte ambas palabras a lista de caracteres y las ordena;
 *          si dos palabras tienen las mismas letras, sus listas
 *          ordenadas quedan idénticas.
 *
 *      →          }.toSet()
 *      ⑤  .toSet() convierte la List resultante en un Set sin
 *          duplicados.
 *      →      }
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      CLASE Anagrama(objetivo: Texto)
 *          FUNCIÓN coincidir(candidatos): ConjuntoDeTexto
 *              DEVOLVER candidatos.FILTRAR(candidato ->
 *                  candidato.MINUSCULAS() != objetivo.MINUSCULAS() Y
 *                  candidato.ORDENAR_LETRAS() == objetivo.ORDENAR_LETRAS()
 *              ).A_CONJUNTO()
 *      FIN CLASE
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
