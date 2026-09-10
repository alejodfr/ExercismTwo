@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 * If you want to build something using a Raspberry Pi, you'll probably
 * use resistors. For this exercise, you need to know two things about them:
 *
 * Each resistor has a resistance value.
 * Resistors are small - so small in fact that if you printed the resistance
 * value on them, it would be hard to read.
 * To get around this problem, manufacturers print color-coded bands onto the
 * resistors to denote their resistance values. Each band has a position and a
 * numeric value.
 *
 * The first 2 bands of a resistor have a simple encoding scheme: each color
 * maps to a single number.
 *
 * In this exercise you are going to create a helpful program so that you don't
 * have to remember the values of the bands.
 *
 * These colors are encoded as follows:
 *
 *   black:  0
 *   brown:  1
 *   red:    2
 *   orange: 3
 *   yellow: 4
 *   green:  5
 *   blue:   6
 *   violet: 7
 *   grey:   8
 *   white:  9
 *
 * The goal of this exercise is to create a way:
 *
 *   - to look up the numerical value associated with a particular color band
 *   - to list the different band colors
 *
 * Mnemonics map the colors to the numbers, that, when stored as an array,
 * happen to map to their index in the array:
 *   Better Be Right Or Your Great Big Values Go Wrong.
 *
 * */

// ▶ object ResistorColor {
//   └▶ ① object → singleton: una única instancia con nombre ResistorColor.
object ResistorColor {

    // ▶ private val colorsList = listOf("black", "brown", ..., "white")
    //   └▶ ② lista inmutable privada; el orden importa: índice 0 = "black"
    //           (valor 0), índice 9 = "white" (valor 9).
    private val colorsList = listOf(
        "black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"
    )

    // ▶ fun colorCode(input: String): Int = colorsList.indexOf(input)
    //   └▶ ③ indexOf → devuelve la posición del color (que coincide con su
    //           valor); devuelve -1 si no existe.
    fun colorCode(input: String): Int = colorsList.indexOf(input)

    // ▶ fun colors(): List<String> = colorsList
    //   └▶ ④ expone la lista completa de colores en orden.
    fun colors(): List<String> = colorsList
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Mapear colores de bandas de resistencias a su valor numérico
 *      (0-9) y proveer la lista completa de colores disponibles.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar un enum class Color con 10 constantes y su .ordinal
 *          como valor numérico, en vez de una lista de Strings.
 *      B)  Usar un Map<String, Int> explícito para lograr búsqueda en
 *          O(1) en vez de O(n) con indexOf.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "colorCode(\"red\")"
 *      ─────────────────────────────────────────────────────────
 *      indexOf("red") en ["black","brown","red",...] → 2
 *      Resultado: 2
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "colors()"
 *      ─────────────────────────────────────────────────────────
 *      Resultado: ["black","brown","red","orange","yellow",
 *                  "green","blue","violet","grey","white"]
 *
 *  ================================================================
 */
