@file:Suppress("SpellCheckingInspection")
/**
 * Instructions
 *
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name
 * like Portable Network Graphics to its acronym (PNG).
 *
 * Punctuation is handled as follows: hyphens are word separators (like
 * whitespace); all other punctuation can be removed from the input.
 *
 * For example:
 *
 *   Input                          Output
 *   As Soon As Possible            ASAP
 *   Liquid-crystal display         LCD
 *   Thank George It's Friday!      TGIF
 */

// ▶ object Acronym {
//   └▶ ① object → singleton: una única instancia con nombre Acronym.
object Acronym {
    // ▶ fun generate(phrase: String): String {
    //   └▶ ② recibe la frase completa y devuelve su acrónimo.
    fun generate(phrase: String) : String {

        // ▶ val auxList = mutableListOf<String>()
        //   └▶ ③ lista mutable donde se acumularán las iniciales.
        val auxList = mutableListOf<String>()
        // ▶ val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
        //   ├▶ ④ split(" ","-","_") → divide la frase por esos tres separadores.
        //   └▶ ⑤ filter { it.isNotEmpty() } → descarta las cadenas vacías que
        //           dejan los separadores consecutivos.
        val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
        // ▶ for (i in list) {
        for (i in list){
            // ▶ auxList.add(i.first().uppercaseChar().toString())
            //   ├▶ ⑥ i.first() → primer carácter de la palabra.
            //   ├▶ ⑦ .uppercaseChar() → lo pasa a mayúscula.
            //   └▶ ⑧ .toString() → lo convierte a String para poder concatenarlo.
            auxList.add(i.first().uppercaseChar().toString())
        }
        // ▶ return auxList.joinToString("")
        //   └▶ ⑨ une todas las iniciales en un solo String, sin separador.
        return auxList.joinToString("")
    }
}

fun main() {
    // Caso 1 — palabras separadas por espacios
    println(Acronym.generate("As Soon As Possible"))       // ASAP

    // Caso 2 — palabras separadas por guiones
    println(Acronym.generate("Liquid-crystal display"))    // LCD

    // Caso 3 — puntuación al final de palabra
    println(Acronym.generate("Thank George It's Friday!")) // TGIF

    // Caso 4 — guiones bajos como énfasis
    println(Acronym.generate("The Road _Not_ Taken"))      // TRNT

    // Caso 5 — separadores consecutivos
    println(Acronym.generate("Something - Interesting"))   // SI

    // Caso 6 — tdo en minúsculas
    println(Acronym.generate("portable network graphics")) // PNG
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Convertir una frase en su acrónimo tomando la primera letra de
 *      cada palabra, tratando espacios, guiones y guiones bajos como
 *      separadores e ignorando cualquier otro signo de puntuación.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar una expresión regular Regex("[^A-Za-z-_ ]") para
 *          eliminar puntuación antes de dividir, en vez de confiar
 *          en que .first() ignore signos como el apóstrofo.
 *      B)  Estilo funcional con map en vez de un bucle for:
 *          list.map { it.first().uppercaseChar() }.joinToString("").
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "generate(\"As Soon As Possible\")"
 *      ─────────────────────────────────────────────────────────
 *      split → ["As","Soon","As","Possible"]
 *      iniciales → A,S,A,P
 *      Resultado: "ASAP"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "generate(\"Liquid-crystal display\")"
 *      ─────────────────────────────────────────────────────────
 *      split → ["Liquid","crystal","display"]
 *      iniciales → L,C,D
 *      Resultado: "LCD"
 *
 *  ================================================================
 */
