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



// ▶ object ResistorColorDuo {
//   └▶ ① object → singleton: una única instancia con nombre ResistorColorDuo.
object ResistorColorDuo {

    // ▶ fun value(vararg colors: Color): Int {
    //   └▶ ② vararg → permite pasar cualquier cantidad de argumentos Color
    //           sin construir un array explícito.
    fun value(vararg colors: Color): Int {
        // ▶ val firstDigit = colors[0].ordinal.toString()
        // ▶ val secondDigit = colors[1].ordinal.toString()
        //   └▶ ③ .ordinal → posición del color en el enum (0-based, coincide
        //           con su valor); .toString() lo pasa a texto.
        val firstDigit = colors[0].ordinal.toString()
        val secondDigit = colors[1].ordinal.toString()
        // ▶ val result = (firstDigit + secondDigit).toInt()
        //   └▶ ④ concatena ambos dígitos como Strings ("1"+"5"="15") y
        //           convierte el resultado de vuelta a Int.
        val result = (firstDigit+secondDigit).toInt()
        // ▶ return result
        //   └▶ ⑤ los colores extra (colors[2], ...) simplemente no se usan.
        return result
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Convertir los dos primeros colores de una resistencia en un
 *      número de dos dígitos, ignorando cualquier color adicional.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Cálculo aritmético directo: colors[0].ordinal * 10 +
 *          colors[1].ordinal — evita convertir a String y es más
 *          eficiente.
 *      B)  Usar un Map<Color, Int> explícito en vez de .ordinal, si se
 *          necesita desacoplar el valor del orden de declaración.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "value(Color.BROWN, Color.GREEN)"
 *      ─────────────────────────────────────────────────────────
 *      BROWN.ordinal=1, GREEN.ordinal=5 → "1"+"5"="15" → 15
 *      Resultado: 15
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "value(Color.BROWN, Color.GREEN, Color.VIOLET)"
 *      ─────────────────────────────────────────────────────────
 *      Solo se usan colors[0] y colors[1]; el tercer color se ignora.
 *      Resultado: 15
 *
 *  ================================================================
 */
