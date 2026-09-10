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

object Isogram {

    fun isIsogram(input: String): Boolean {
        val letters = input.filter { it != '-' && it != ' ' }.lowercase()
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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Eliminar guiones y espacios del texto de entrada.
 *      II.  Convertir el resultado a minúsculas para ignorar el caso.
 *      III. Comparar la longitud del texto filtrado contra la cantidad
 *           de letras únicas (sin duplicados): si coinciden, es
 *           isograma.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun isIsogram(input: String): Boolean {
 *      →      val letters = input.filter { it != '-' && it != ' ' }.lowercase()
 *      ①  filter conserva solo los caracteres que no son guion ni
 *          espacio; .lowercase() normaliza mayúsculas y minúsculas.
 *
 *      →      return letters.length == letters.toList().distinct().size
 *      ②  .toList() convierte el String a lista de caracteres;
 *          .distinct() elimina duplicados; si la longitud original
 *          coincide con la cantidad de únicos, no hay repetidos.
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN esIsograma(entrada: Texto): Booleano
 *          letras ← entrada.FILTRAR(c != '-' Y c != ' ').MINUSCULAS()
 *          DEVOLVER letras.LONGITUD == letras.SIN_DUPLICADOS().TAMAÑO
 *      FIN FUNCIÓN
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
