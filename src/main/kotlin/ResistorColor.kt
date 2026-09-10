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

object ResistorColor {

    private val colorsList = listOf(
        "black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"
    )

    fun colorCode(input: String): Int = colorsList.indexOf(input)

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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Guardar los 10 colores en una lista ordenada, donde el
 *           índice de cada color coincide con su valor numérico.
 *      II.  colorCode busca el índice de un color con indexOf.
 *      III. colors() expone la lista completa.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  private val colorsList = listOf(
 *      →      "black", "brown", "red", "orange", "yellow",
 *      →      "green", "blue", "violet", "grey", "white"
 *      →  )
 *      ①  Lista inmutable privada; el orden importa: el índice 0 es
 *          "black" (valor 0), el índice 9 es "white" (valor 9).
 *
 *      →  fun colorCode(input: String): Int = colorsList.indexOf(input)
 *      ②  indexOf busca el color recibido y devuelve su posición en la
 *          lista (que coincide con su valor); devuelve -1 si no existe.
 *
 *      →  fun colors(): List<String> = colorsList
 *      ③  Devuelve la lista completa de colores en orden.
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      OBJETO ResistorColor
 *          listaColores ← ["black", "brown", ..., "white"]
 *          FUNCIÓN colorCode(input): DEVOLVER índice de input en listaColores
 *          FUNCIÓN colors(): DEVOLVER listaColores
 *      FIN OBJETO
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
