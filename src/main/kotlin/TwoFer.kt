@file:Suppress("SpellCheckingInspection")


/**
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

// ▶ fun twofer(name: String? = null): String {
//   ├▶ ① fun twofer → declara una función llamada twofer.
//   ├▶ ② name: String? = null → parámetro opcional nullable con valor por
//   │       defecto null (permite llamar twofer() sin argumentos).
//   └▶ ③ : String → siempre devuelve un texto, nunca null.
fun twofer(name: String? = null): String {
    // ▶ if (name != null) {
    //   └▶ ④ comprueba si se recibió un nombre real (distinto de null).
    if (name != null){
        // ▶ return "One for $name, one for me."
        //   └▶ ⑤ $name interpola el valor del parámetro dentro del texto.
        return "One for $name, one for me."
    // ▶ } else {
    } else {
        // ▶ return "One for you, one for me."
        //   └▶ ⑥ rama alternativa: mensaje fijo cuando no hay nombre.
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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Generar el mensaje de una oferta "two-for-one" de galletas.
 *      Si se conoce el nombre de la persona, decir "One for [nombre],
 *      one for me."; si no, decir "One for you, one for me."
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar un operador Elvis: "One for ${name ?: "you"}, one for me."
 *          evita el if/else explícito.
 *      B)  Sobrecargar la función (una versión sin parámetros y otra
 *          con String) en vez de usar un parámetro nullable.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "twofer(\"Alice\")"
 *      ─────────────────────────────────────────────────────────
 *      name = "Alice" → name != null → true
 *      Resultado: "One for Alice, one for me."
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "twofer()"
 *      ─────────────────────────────────────────────────────────
 *      name = null (valor por defecto) → name != null → false
 *      Resultado: "One for you, one for me."
 *
 *  ================================================================
 */
