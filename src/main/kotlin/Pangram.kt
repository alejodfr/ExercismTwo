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

object Pangram {

    fun isPangram(input: String): Boolean {
        // * ¿Para TODAS las letras de la 'a' a la 'z', la frase contiene esa letra (ignorando mayúsculas)?
        return ('a'..'z').all { char ->
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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Generar el rango de letras 'a' a 'z'.
 *      II.  Verificar que TODAS esas letras estén presentes en la
 *           frase, ignorando mayúsculas.
 *      III. .all() se detiene apenas encuentra una letra ausente
 *           (cortocircuito).
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun isPangram(input: String): Boolean {
 *      →      return ('a'..'z').all { char ->
 *      ①  ('a'..'z') crea un CharRange con las 26 letras del
 *          alfabeto; .all { } comprueba si TODOS los elementos
 *          cumplen la condición dada.
 *
 *      →          input.contains(char, ignoreCase = true)
 *      ②  .contains(char, ignoreCase = true) busca la letra en la
 *          frase sin distinguir mayúsculas de minúsculas.
 *      →      }
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Con Set: input.lowercase().filter { it.isLetter() }.toSet().size == 26.
 *      B)  Con bucle tradicional: for (c in 'a'..'z') if (c !in
 *          input.lowercase()) return false; return true.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN esPangrama(entrada: Texto): Booleano
 *          PARA CADA letra DESDE 'a' HASTA 'z':
 *              SI entrada NO CONTIENE letra (ignorando mayúsculas):
 *                  DEVOLVER Falso
 *          DEVOLVER Verdadero
 *      FIN FUNCIÓN
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
