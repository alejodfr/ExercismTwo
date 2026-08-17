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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Convertir una frase en su acrónimo tomando la primera letra de
 *      cada palabra, tratando espacios, guiones y guiones bajos como
 *      separadores e ignorando cualquier otro signo de puntuación.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Separar la frase en palabras usando espacio, guión y
 *           guión bajo como delimitadores.
 *      II.  Descartar las cadenas vacías que puedan resultar de
 *           separadores consecutivos.
 *      III. Tomar la primera letra de cada palabra y convertirla a
 *           mayúscula.
 *      IV.  Concatenar todas las iniciales sin separador.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun generate(phrase: String) : String {
 *      →      val auxList = mutableListOf<String>()
 *      ①  Lista mutable donde se acumularán las iniciales.
 *
 *      →      val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
 *      ②  split() divide la frase por espacio, guión y guión bajo;
 *          filter descarta las cadenas vacías (separadores dobles).
 *
 *      →      for (i in list){
 *      →          auxList.add(i.first().uppercaseChar().toString())
 *      ③  .first() toma el primer carácter de la palabra;
 *          .uppercaseChar() lo pasa a mayúscula; .toString() lo
 *          convierte para poder concatenarlo.
 *      →      }
 *
 *      →      return auxList.joinToString("")
 *      ④  Une todas las iniciales en un solo String, sin separador.
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN generar(frase: Texto): Texto
 *          palabras ← frase.SEPARAR(" ", "-", "_").FILTRAR(no_vacio)
 *          iniciales ← LISTA_VACIA
 *          PARA CADA palabra EN palabras:
 *              iniciales.AGREGAR(palabra.PRIMERA_LETRA().MAYUSCULA())
 *          DEVOLVER iniciales.UNIR("")
 *      FIN FUNCIÓN
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
