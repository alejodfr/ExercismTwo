@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 *
 * If you want to build something using a Raspberry Pi, you'll probably use
 * resistors. For this exercise, you need to know only three things about them:
 *
 * - Each resistor has a resistance value.
 * - Resistors are small - so small in fact that if you printed the resistance
 *   value on them, it would be hard to read. To get around this problem,
 *   manufacturers print color-coded bands onto the resistors to denote their
 *   resistance values.
 * - Each band acts as a digit of a number.
 *
 * For example, if they printed a brown band (value 1) followed by a green band
 * (value 5), it would translate to the number 15. In this exercise, you are
 * going to create a helpful program so that you don't have to remember the
 * values of the bands. The program will take 3 colors as input, and outputs
 * the correct value, in ohms. The color bands are encoded as follows:
 *
 *   black: 0,  brown: 1,  red: 2,  orange: 3,  yellow: 4,
 *   green: 5,  blue: 6,  violet: 7,  grey: 8,  white: 9
 *
 * In Resistor Color Duo you decoded the first two colors. For instance:
 * orange-orange got the main value 33. The third color stands for how many
 * zeros need to be added to the main value. The main value plus the zeros
 * gives us a value in ohms. For the exercise it doesn't matter what ohms
 * really are. For example:
 *
 *   - orange-orange-black   -> 33 and no zeros   -> 33 ohms
 *   - orange-orange-red     -> 33 and 2 zeros    -> 3300 ohms
 *   - orange-orange-orange  -> 33 and 3 zeros    -> 33000 ohms
 *
 * (If Math is your thing, you may want to think of the zeros as exponents of
 * 10. If Math is not your thing, go with the zeros. It really is the same
 * thing, just in plain English instead of Math lingo.)
 *
 * This exercise is about translating the colors into a label:
 * "... ohms"
 *
 * So an input of "orange", "orange", "black" should return:
 * "33 ohms"
 *
 * When we get to larger resistors, a metric prefix is used to indicate a
 * larger magnitude of ohms, such as "kiloohms". That is similar to saying
 * "2 kilometers" instead of "2000 meters", or "2 kilograms" for "2000 grams".
 *
 * For example, an input of "orange", "orange", "orange" should return:
 * "33 kiloohms"
 */

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val baseValue = input[0].ordinal * 10 + input[1].ordinal
        val exponent = input[2].ordinal
        val multiplier = Math.pow(10.0, exponent.toDouble()).toLong()
        val totalOhms = baseValue * multiplier

        return when {
            totalOhms >= 1_000_000_000 -> "${totalOhms / 1_000_000_000} gigaohms"
            totalOhms >= 1_000_000 -> "${totalOhms / 1_000_000} megaohms"
            totalOhms >= 1_000 -> "${totalOhms / 1_000} kiloohms"
            else -> "$totalOhms ohms"
    }


}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Decodificar tres bandas de colores de una resistencia y devolver su valor
 *  en ohms con el prefijo métrico correspondiente (kilo, mega, giga).
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *  1. Las dos primeras bandas forman el valor base (decenas + unidades).
 *  2. La tercera banda indica cuántos ceros agregar (exponente de 10).
 *  3. Multiplicar el valor base por 10^exponente para obtener el total.
 *  4. Elegir el prefijo métrico según la magnitud del resultado.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  vararg — permite pasar una lista variable de argumentos del mismo tipo.
 *  2.  ordinal — propiedad de los enums que devuelve la posición (0-based).
 *  3.  Math.pow(10.0, exponent) — calcula 10 elevado al exponente.
 *  4.  when — expresión condicional que elige el prefijo según el umbral.
 *  5.  String templates — interpolación de variables con "${}".
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  vararg                   │  Recibir 3 colores como entrada  │
 *  │  Enum.ordinal             │  Obtener el valor numérico (0-9) │
 *  │  Math.pow()               │  Calcular 10^exponente           │
 *  │  toLong()                 │  Convertir Double a Long         │
 *  │  when                     │  Elegir prefijo (kilo/mega/giga) │
 *  │  String templates         │  "${totalOhms} kiloohms"         │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  Usar un mapa de colores a valores en vez de ordinal.
 *  B)  fold para construir el número combinando las bandas secuencialmente.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  Tiempo: O(1) — operaciones aritméticas fijas sin bucles.
 *  Memoria: O(1) — solo variables locales escalares.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  FUNCIÓN text(input: Color[]): String
 *      base := input[0].ordinal * 10 + input[1].ordinal
 *      exponente := input[2].ordinal
 *      total := base * 10^exponente
 *      SI total >= 1_000_000_000:
 *          DEVOLVER "${total / 1e9} gigaohms"
 *      SI NO SI total >= 1_000_000:
 *          DEVOLVER "${total / 1e6} megaohms"
 *      SI NO SI total >= 1_000:
 *          DEVOLVER "${total / 1e3} kiloohms"
 *      SI NO:
 *          DEVOLVER "${total} ohms"
 *  FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: "orange", "orange", "black"
 *  ─────────────────────────────────────────────────────────────────
 *  base = 3*10 + 3 = 33
 *  exponente = 0
 *  total = 33 * 10^0 = 33
 *  total < 1000 → "33 ohms"
 *  Resultado: "33 ohms"
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: "red", "violet", "red"
 *  ─────────────────────────────────────────────────────────────────
 *  base = 2*10 + 7 = 27
 *  exponente = 2
 *  total = 27 * 10^2 = 2700
 *  1000 <= total < 1_000_000 → "2 kiloohms"
 *  Resultado: "2 kiloohms"
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 3: "brown", "black", "yellow"
 *  ─────────────────────────────────────────────────────────────────
 *  base = 1*10 + 0 = 10
 *  exponente = 4
 *  total = 10 * 10^4 = 100000
 *  1000 <= total < 1_000_000 → "100 kiloohms"
 *  Resultado: "100 kiloohms"
 *
 *  ================================================================
 */
}
