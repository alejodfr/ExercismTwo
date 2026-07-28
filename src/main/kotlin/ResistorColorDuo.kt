@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 * If you want to build something using a Raspberry Pi, you'll probably use
 * resistors. For this exercise, you need to know two things about them:
 *
 * Each resistor has a resistance value.
 * Resistors are small - so small in fact that if you printed the resistance
 * value on them, it would be hard to read.
 * To get around this problem, manufacturers print color-coded bands onto the
 * resistors to denote their resistance values. Each band has a position and a
 * numeric value.
 *
 * The first 2 bands of a resistor have a simple encoding scheme: each color
 * maps to a single number. For example, if they printed a brown band (value 1)
 * followed by a green band (value 5), it would translate to the number 15.
 *
 * In this exercise you are going to create a helpful program so that you don't
 * have to remember the values of the bands. The program will take color names
 * as input and output a two digit number, even if the input is more than two
 * colors!
 *
 * The band colors are encoded as follows:
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
 * From the example above: brown-green should return 15, and
 * brown-green-violet should return 15 too, ignoring the third color.
 *
 * */



object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val firstDigit = colors[0].ordinal.toString()
        val secondDigit = colors[1].ordinal.toString()
        val result = (firstDigit+secondDigit).toInt()
        return result
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Convertir los dos primeros colores de una resistencia en un
 *  número de dos dígitos, ignorando cualquier color adicional.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *  1. Recibir una lista de colores como parámetro vararg.
 *  2. Obtener el valor numérico de cada color mediante su ordinal
 *     dentro del enum Color (coincide con el valor real).
 *  3. Concatenar el primer dígito con el segundo como Strings y
 *     convertir el resultado a Int para formar el número de dos cifras.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  enum class Color — Define los 10 colores con su ordinal
 *      coincidiendo con el valor de la banda (BLACK=0, BROWN=1, etc.).
 *  2.  vararg colors: Color — Permite pasar cualquier cantidad de
 *      argumentos del tipo Color sin necesidad de un array explícito.
 *  3.  colors[0].ordinal — Obtiene la posición ordinal del enum
 *      (0 para BLACK, 1 para BROWN, etc.).
 *  4.  .toString() — Convierte el entero a String para concatenar.
 *  5.  firstDigit + secondDigit — Concatena ambos Strings (ej. "1"+"5"
 *      = "15").
 *  6.  .toInt() — Transforma el String resultante de vuelta a Int.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  enum class               │  Define constantes con un        │
 *  │                           │  ordinal numérico asociado.      │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  .ordinal                 │  Devuelve la posición del valor  │
 *  │                           │  enum (0-based).                 │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  vararg                   │  Parámetro que acepta cero o     │
 *  │                           │  más argumentos del mismo tipo.  │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  String concatenación     │  Une dos Strings con el operador │
 *  │                           │  +.                              │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  .toInt()                 │  Convierte un String a un valor  │
 *  │                           │  numérico Int.                   │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  Aritmético directo: colors[0].ordinal * 10 + colors[1].ordinal
 *      — evita la conversión a String y es más eficiente.
 *  B)  Con una función de extensión o un mapa inmutable
 *      (Map<Color, Int>) que asocie cada color a su valor numérico,
 *      útil si se necesita personalizar la asignación.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  Tiempo O(1) — solo se accede a los dos primeros elementos del
 *  vararg y se realizan operaciones constantes. Espacio O(1) — no
 *  se crean estructuras adicionales significativas.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  FUNCION valor(vararg colores: Color): Int
 *      primerDigito <- colores[0].ordinal
 *      segundoDigito <- colores[1].ordinal
 *      resultado <- concatenar(primerDigito, segundoDigito) como texto
 *      DEVOLVER convertir resultado a Int
 *  FIN FUNCION
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: "brown, green"
 *  ─────────────────────────────────────────────────────────────────
 *  colores[0] = BROWN  -> ordinal 1 -> "1"
 *  colores[1] = GREEN  -> ordinal 5 -> "5"
 *  "1" + "5" = "15"
 *  "15".toInt() = 15
 *  Resultado: 15
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: "brown, green, violet"
 *  ─────────────────────────────────────────────────────────────────
 *  colores[0] = BROWN  -> ordinal 1 -> "1"
 *  colores[1] = GREEN  -> ordinal 5 -> "5"
 *  "1" + "5" = "15"
 *  El tercer color (VIOLET) se ignora por completo.
 *  Resultado: 15
 *
 *  ================================================================
 */