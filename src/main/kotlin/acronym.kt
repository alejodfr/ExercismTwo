@file:Suppress("SpellCheckingInspection")
/*
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

object Acronym {
    fun generate(phrase: String) : String {

        val auxList = mutableListOf<String>()
        val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
        for (i in list){
            auxList.add(i.first().uppercaseChar().toString())
        }
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

    // Caso 6 — todo en minúsculas
    println(Acronym.generate("portable network graphics")) // PNG
}

/*
 * # Acronym — Guía de resolución
 *
 * ## Enunciado
 *
 * Dada una frase, generar su acrónimo tomando la primera letra
 * de cada palabra y convirtiéndola a mayúscula.
 *
 * Ejemplos:
 *   "As Soon As Possible"   -> "ASAP"
 *   "Liquid-crystal display" -> "LCD"
 *   "Thank George It's Friday!" -> "TGIF"
 *
 * ## Orden de pensamiento
 *
 * 1. Separar la frase en palabras — los separadores pueden ser
 *    espacios, guiones o guiones bajos.
 * 2. Filtrar elementos vacíos — separadores consecutivos generan
 *    cadenas vacías que causan errores al tomar la primera letra.
 * 3. Tomar la primera letra de cada palabra y convertirla a mayúscula.
 * 4. Unir todas las letras en un solo String.
 *
 * ## Paso a paso
 *
 * ### Separar la frase en palabras con split()
 *
 *   val list = phrase.split(" ", "-", "_")
 *
 * - split() divide el String en una lista usando los separadores dados.
 * - Se usan tres separadores: espacio, guión y guión bajo.
 * - Los guiones son separadores de palabras igual que los espacios.
 * - Los guiones bajos se usan para énfasis (_word_) y deben ignorarse.
 *
 * ### Filtrar elementos vacíos
 *
 *   .filter { it.isNotEmpty() }
 *
 * - Cuando hay separadores consecutivos (ej. "--"), split() genera
 *   cadenas vacías "" entre ellos.
 * - Llamar .first() sobre una cadena vacía lanza error: "Char sequence is empty".
 * - filter { it.isNotEmpty() } elimina esas cadenas vacías antes de continuar.
 *
 * ### Lista mutable acumuladora
 *
 *   val auxList = mutableListOf<String>()
 *
 * - Lista mutable de Strings donde se irán acumulando las letras.
 * - Es String (no Char) porque .toString() convierte cada Char a String.
 * - Se declara fuera del loop para no reiniciarse en cada iteración.
 *
 * ### Loop — tomar la primera letra de cada palabra
 *
 *   for (i in list) {
 *       auxList.add(i.first().uppercaseChar().toString())
 *   }
 *
 * - i          -> cada palabra de la lista
 * - .first()   -> primer carácter de la palabra (retorna Char)
 * - .uppercaseChar() -> convierte el Char a mayúscula
 * - .toString() -> convierte el Char a String para agregarlo a auxList
 * - .add()     -> agrega el resultado a auxList
 *
 * ### Retornar el acrónimo
 *
 *   return auxList.joinToString("")
 *
 * - joinToString("") une todos los elementos de la lista en un solo String.
 * - El "" indica que no hay separador entre los elementos.
 * - Ejemplo: ["A", "S", "A", "P"] -> "ASAP"
 *
 * ## Código completo
 *
 *   object Acronym {
 *       fun generate(phrase: String): String {
 *           val auxList = mutableListOf<String>()
 *           val list = phrase.split(" ", "-", "_").filter { it.isNotEmpty() }
 *           for (i in list) {
 *               auxList.add(i.first().uppercaseChar().toString())
 *           }
 *           return auxList.joinToString("")
 *       }
 *   }
 */