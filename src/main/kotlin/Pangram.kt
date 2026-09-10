@file:Suppress("SpellCheckingInspection")

/**
 * Pangram
 *
 * Your task is to figure out if a sentence is a pangram.
 *
 * A pangram is a sentence using every letter of the alphabet at least once.
 * It is case insensitive, so it doesn't matter if a letter is lower-case (e.g. k)
 * or upper-case (e.g. K).
 *
 * For this exercise, a sentence is a pangram if it contains each of the 26
 * letters in the English alphabet.
 *
 * Note:
 * Pangram comes from Greek, παν γράμμα, pan gramma, which means "every letter".
 *
 * The best known English pangram is:
 * "The quick brown fox jumps over the lazy dog."
 */

// ▶ object Pangram {
//   └▶ ① object → singleton: una única instancia con nombre Pangram.
object Pangram {

    // ▶ fun isPangram(input: String): Boolean {
    //   └▶ ② recibe la frase y devuelve true si es un pangrama.
    fun isPangram(input: String): Boolean {
        // ▶ return ('a'..'z').all { char ->
        //   ├▶ ③ ('a'..'z') → CharRange con las 26 letras del alfabeto.
        //   └▶ ④ .all { ... } → true solo si TODOS los elementos cumplen la
        //           condición; corta apenas uno falla (cortocircuito).
        return ('a'..'z').all { char ->
            // ▶ input.contains(char, ignoreCase = true)
            //   └▶ ⑤ busca la letra en la frase sin distinguir mayúsculas
            //           de minúsculas.
            input.contains(char, ignoreCase = true)
        }
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Determinar si una oración es un pangrama: que contenga cada
 *      letra del alfabeto inglés al menos una vez, sin distinguir
 *      mayúsculas de minúsculas.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Con Set: input.lowercase().filter { it.isLetter() }.toSet().size == 26.
 *      B)  Con bucle tradicional: for (c in 'a'..'z') if (c !in
 *          input.lowercase()) return false; return true.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "\"The quick brown fox jumps over the lazy dog.\""
 *      ─────────────────────────────────────────────────────────
 *      Contiene las 26 letras del alfabeto (a...z)
 *      Resultado: true
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "\"Hello World\""
 *      ─────────────────────────────────────────────────────────
 *      No contiene 'a' → .all() corta en la primera letra ausente
 *      Resultado: false
 *
 *  ================================================================
 */
