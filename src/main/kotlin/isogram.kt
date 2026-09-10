@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 *
 * Determine if a word or phrase is an isogram.
 *
 * An isogram (also known as a "non-pattern word") is a word or phrase without a
 * repeating letter, however spaces and hyphens are allowed to appear multiple times.
 *
 * Examples of isograms:
 *
 *   - lumberjacks
 *   - background
 *   - downstream
 *   - six-year-old
 *
 * The word isograms, however, is not an isogram, because the s repeats.
 */

// ▶ object Isogram {
//   └▶ ① object → singleton: una única instancia con nombre Isogram.
object Isogram {

    // ▶ fun isIsogram(input: String): Boolean {
    //   └▶ ② recibe la palabra o frase y devuelve true/false.
    fun isIsogram(input: String): Boolean {
        // ▶ val letters = input.filter { it != '-' && it != ' ' }.lowercase()
        //   ├▶ ③ filter → conserva solo lo que no sea guion ni espacio.
        //   └▶ ④ .lowercase() → normaliza mayúsculas y minúsculas.
        val letters = input.filter { it != '-' && it != ' ' }.lowercase()
        // ▶ return letters.length == letters.toList().distinct().size
        //   ├▶ ⑤ .toList().distinct() → letras sin duplicados.
        //   └▶ ⑥ si la longitud original coincide con la cantidad de
        //           únicos, no hay letras repetidas → es isograma.
        return letters.length == letters.toList().distinct().size
    }
}



fun main(){
    println("Type a word or phrase")
    val input = readln()
    println("Is the word or phrase an isogram? ${Isogram.isIsogram(input)}")
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Determinar si una palabra o frase es un isograma (sin letras
 *      repetidas), ignorando espacios, guiones y diferencias entre
 *      mayúsculas y minúsculas.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar un Set: letters.toSet().size == letters.length (Set ya
 *          elimina duplicados, es equivalente a distinct().size).
 *      B)  Recorrer con un bucle y un Set mutable, devolviendo false
 *          apenas se detecta una letra repetida (corta antes).
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "\"six-year-old\""
 *      ─────────────────────────────────────────────────────────
 *      filter+lowercase → "sixyearold" (10 letras, todas únicas)
 *      10 == 10 → true
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "\"hello\""
 *      ─────────────────────────────────────────────────────────
 *      "hello" (5 letras); distinct → [h,e,l,o] (4 únicas, la 'l' se repite)
 *      5 != 4 → false
 *
 *  ================================================================
 */
