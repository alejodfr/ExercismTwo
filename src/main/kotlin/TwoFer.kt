@file:Suppress("SpellCheckingInspection")


/*
 * Introduction
 *
 * In some English accents, "two for" said quickly sounds like "two fer".
 * Two-for-one means if you buy one, you get one free.
 *
 * Imagine a bakery with a holiday offer: two cookies for the price of one.
 * You take the offer and give the extra cookie to someone else in the queue.
 *
 * Instructions
 *
 * Determine what you will say as you give away the extra cookie.
 *
 * - If you know the person's name:  "One for Do-yun, one for me."
 * - If you don't know their name:   "One for you, one for me."
 *
 * Examples:
 *   Name    | Dialogue
 *   --------|---------------------------
 *   Alice   | One for Alice, one for me.
 *   Bohdan  | One for Bohdan, one for me.
 *   (none)  | One for you, one for me.
 *   Zaphod  | One for Zaphod, one for me.
 */

fun twofer(name: String? = null): String {
    if (name != null){
        return "One for $name, one for me."
    } else {
        return "One for you, one for me."
    }
}

fun main() {
    // Con nombre
    println(twofer("Alice"))   // One for Alice, one for me.
    println(twofer("Zaphod"))  // One for Zaphod, one for me.

    // Sin nombre — dos formas equivalentes
    println(twofer())          // One for you, one for me.
    println(twofer(null))      // One for you, one for me.
}

/*
 * # Two Fer — Guía de resolución
 *
 * ## Enunciado
 *
 * Dado un nombre opcional, retornar la frase correcta:
 * - Si se conoce el nombre: "One for [nombre], one for me."
 * - Si no se conoce:        "One for you, one for me."
 *
 * ## Orden de pensamiento
 *
 * 1. El nombre es opcional — puede no pasarse ningún argumento.
 *    Eso significa que el parámetro necesita ? (puede ser null)
 *    y = null (valor por defecto, para que sea opcional).
 * 2. La función siempre retorna un String — nunca null.
 *    Por eso el tipo de retorno es String, no String?.
 * 3. Con un if/else se maneja cada caso.
 *
 * ## Paso a paso
 *
 * ### La función y sus parámetros
 *
 *   fun twofer(name: String? = null): String
 *
 * - name: String? -> el nombre puede ser null
 * - = null        -> valor por defecto, permite llamar twofer() sin argumentos
 * - : String      -> siempre retorna un String, nunca null
 *
 * ### El if/else
 *
 *   if (name != null) {
 *       return "One for $name, one for me."
 *   } else {
 *       return "One for you, one for me."
 *   }
 *
 * - Si name != null -> usa el nombre en la frase
 * - Si name == null -> usa "you" en su lugar
 * - $name           -> interpolación de String, inserta el valor de name
 *
 * ## Código completo
 *
 *   fun twofer(name: String? = null): String {
 *       if (name != null) {
 *           return "One for $name, one for me."
 *       } else {
 *           return "One for you, one for me."
 *       }
 *   }
 */