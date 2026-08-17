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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Generar el mensaje de una oferta "two-for-one" de galletas.
 *      Si se conoce el nombre de la persona, decir "One for [nombre],
 *      one for me."; si no, decir "One for you, one for me."
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Declarar una función twofer con un parámetro opcional
 *           name de tipo String? y valor por defecto null.
 *      II.  Si name no es null, interpolarlo en el mensaje.
 *      III. Si name es null, usar el mensaje fijo con "you".
 *      IV.  El valor por defecto null permite llamar la función sin
 *           argumentos.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun twofer(name: String? = null): String {
 *      ①  fun declara una función; twofer es su nombre.
 *      ②  name: String? = null — parámetro opcional nullable con
 *          valor por defecto null.
 *      ③  : String — la función siempre devuelve un texto, nunca null.
 *
 *      →      if (name != null){
 *      ④  Comprueba si se recibió un nombre real (no null).
 *
 *      →          return "One for $name, one for me."
 *      ⑤  $name interpola el valor del parámetro dentro del texto.
 *
 *      →      } else {
 *      →          return "One for you, one for me."
 *      ⑥  Rama alternativa: mensaje fijo cuando no hay nombre.
 *      →      }
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN dosPorUno(nombre: Texto o nulo = nulo): Texto
 *          SI nombre NO ES nulo:
 *              DEVOLVER "One for " + nombre + ", one for me."
 *          SINO:
 *              DEVOLVER "One for you, one for me."
 *      FIN FUNCIÓN
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
