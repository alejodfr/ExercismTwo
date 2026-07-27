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

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Mapear colores de resistencias a su valor numérico y listar los colores disponibles.
 *
 *  -----------------------------------------------------------------
 *  🧠  ANÁLISIS DE LA SOLUCIÓN
 *
 *  object ResistorColor {
 *      private val colorsList = listOf(
 *          "black", "brown", "red", "orange", "yellow",
 *          "green", "blue", "violet", "grey", "white"
 *      )
 *      fun colorCode(input: String): Int = colorsList.indexOf(input)
 *      fun colors(): List<String> = colorsList
 *  }
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  `object ResistorColor` — Objeto singleton que agrupa los datos y funciones.
 *  2.  `private val colorsList` — Lista inmutable privada con los colores en orden (índice = valor).
 *  3.  `colorCode(input)` — Devuelve el índice del color usando `indexOf`, que retorna -1 si no existe.
 *  4.  `colors()` — Expone la lista completa de colores.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  object                   │  Singleton contenedor            │
 *  │  private val              │  Propiedad privada inmutable     │
 *  │  listOf                   │  Crear lista literal             │
 *  │  indexOf                  │  Buscar índice de un elemento    │
 *  │  función con expresión    │  `fun x(): T = expr`             │
 *  │  String                   │  Tipo del color de entrada       │
 *  │  List<String>             │  Tipo de retorno de colores()    │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  when expression — Mapear cada color manualmente con `when`.
 *  B)  Map — Usar `mapOf("black" to 0, ...)` para la búsqueda.
 *  C)  Enum class — Definir un enum `Color { black, brown, ... }` con propiedad `ordinal`.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  colorCode: O(n) por el indexOf (recorre la lista). Con map sería O(1).
 *  colors: O(1) — solo devuelve la referencia a la lista.
 *  Memoria: O(1) fijo (10 colores).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  OBJETO ResistorColor
 *      listaColors := ["black", "brown", ..., "white"]
 *
 *      FUNCIÓN colorCode(input: String): Int
 *          DEVOLVER índice de input en listaColors
 *      FIN FUNCIÓN
 *
 *      FUNCIÓN colors(): ListaDe<String>
 *          DEVOLVER listaColors
 *      FIN FUNCIÓN
 *  FIN OBJETO
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: colorCode("red")
 *  ─────────────────────────────────────────────────────────────────
 *  listaColors = ["black", "brown", "red", ...]
 *  indexOf("red") → 2
 *  Resultado: 2
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: colors()
 *  ─────────────────────────────────────────────────────────────────
 *  Devuelve la lista completa
 *  Resultado: ["black", "brown", "red", "orange", "yellow",
 *              "green", "blue", "violet", "grey", "white"]
 *
 *  ================================================================
 */