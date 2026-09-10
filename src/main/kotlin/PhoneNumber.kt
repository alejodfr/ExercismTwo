@file:Suppress("SpellCheckingInspection")



/**
 * Phone Number
 *
 * Clean up user-entered phone numbers so that they can be sent SMS messages.
 *
 * The North American Numbering Plan (NANP) is a telephone numbering system
 * used by many countries in North America. All NANP countries share the
 * same international country code: 1.
 *
 * NANP numbers are ten-digit numbers consisting of:
 *   - A three-digit area code (NXX)
 *   - A seven-digit local number (NXX-XXXX)
 *
 * where N is any digit from 2 through 9 and X is any digit from 0 through 9.
 *
 * Sometimes the number has a country code (1 or +1) prefixed. Your task is
 * to remove punctuation and the country code if present.
 *
 * Examples:
 *   +1 (613)-995-0253  →  6139950253
 *   613-995-0253       →  6139950253
 *   1 613 995 0253     →  6139950253
 *   613.995.0253       →  6139950253
 *
 * Note: Only 1 is considered a valid country code.
 */

class PhoneNumber(rawNumber: String) {

    val number: String

    init {
        // 1. Limpiamos dejando solo los dígitos numéricos
        var digits = rawNumber.filter { it.isDigit() }

        // 2. Manejamos el código de país si tiene 11 dígitos
        if (digits.length == 11) {
            require(digits.startsWith("1")) { "11-digit numbers must start with 1" }
            digits = digits.drop(1)
        }

        // 3. Validamos la longitud final (deben ser exactamente 10 dígitos)
        require(digits.length == 10) { "Incorrect number of digits" }

        // 4. Validamos que el Area Code y Exchange Code no empiecen con 0 o 1
        require(digits[0] in '2'..'9') { "Area code cannot start with 0 or 1" }
        require(digits[3] in '2'..'9') { "Exchange code cannot start with 0 or 1" }

        // Si pasó todas las validaciones, guardamos el número limpio
        number = digits
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Limpiar números telefónicos ingresados por el usuario: quitar
 *      puntuación, eliminar el código de país si está presente, y
 *      validar el formato NANP (NXX-NXX-XXXX).
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Extraer solo los dígitos del texto de entrada.
 *      II.  Si quedan 11 dígitos, validar que empiecen con "1" (código
 *           de país) y eliminarlo.
 *      III. Validar que queden exactamente 10 dígitos.
 *      IV.  Validar que el área y el código de intercambio (posiciones
 *           0 y 3) no empiecen con 0 ni 1.
 *      V.   Guardar el número limpio en la propiedad number.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  var digits = rawNumber.filter { it.isDigit() }
 *      ①  filter conserva solo los caracteres que son dígitos,
 *          eliminando espacios, guiones, paréntesis y el "+".
 *
 *      →  if (digits.length == 11) {
 *      →      require(digits.startsWith("1")) { "11-digit numbers must start with 1" }
 *      →      digits = digits.drop(1)
 *      ②  Si hay 11 dígitos, deben empezar con "1" (código de país
 *          válido); .drop(1) lo elimina, dejando 10 dígitos.
 *      →  }
 *
 *      →  require(digits.length == 10) { "Incorrect number of digits" }
 *      ③  Tras el posible recorte, deben quedar exactamente 10 dígitos.
 *
 *      →  require(digits[0] in '2'..'9') { "Area code cannot start with 0 or 1" }
 *      →  require(digits[3] in '2'..'9') { "Exchange code cannot start with 0 or 1" }
 *      ④  El primer dígito del área (posición 0) y del código de
 *          intercambio (posición 3) deben estar en el rango '2'..'9'.
 *
 *      →  number = digits
 *      ⑤  Si todas las validaciones pasan, se guarda el número limpio.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar una expresión regular Regex("[^0-9]") con .replace("")
 *          en vez de filter { it.isDigit() }.
 *      B)  Extraer las validaciones a funciones privadas separadas
 *          (validateLength, validateAreaCode, ...) para mayor claridad.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      CLASE PhoneNumber(rawNumber)
 *          AL CREAR:
 *              digits ← rawNumber SOLO DÍGITOS
 *              SI digits.LONGITUD == 11:
 *                  REQUERIR digits EMPIEZA CON "1"
 *                  digits ← digits SIN PRIMER CARÁCTER
 *              REQUERIR digits.LONGITUD == 10
 *              REQUERIR digits[0] EN '2'..'9'
 *              REQUERIR digits[3] EN '2'..'9'
 *              number ← digits
 *      FIN CLASE
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "PhoneNumber(\"+1 (613)-995-0253\")"
 *      ─────────────────────────────────────────────────────────
 *      filter → "16139950253" (11 dígitos) → empieza con "1" → drop(1)
 *      → "6139950253" (10 dígitos); [0]='6', [3]='9' ambos en 2..9
 *      Resultado: number = "6139950253"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "PhoneNumber(\"123-456-7890\")"
 *      ─────────────────────────────────────────────────────────
 *      filter → "1234567890" (10 dígitos); [0]='1' NO está en 2..9
 *      Resultado: lanza IllegalArgumentException("Area code cannot start with 0 or 1")
 *
 *  ================================================================
 */
