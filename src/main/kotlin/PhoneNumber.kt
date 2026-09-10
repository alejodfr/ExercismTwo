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

// ▶ class PhoneNumber(rawNumber: String) {
//   └▶ ① rawNumber → parámetro del constructor (sin val: solo se usa
//           dentro del init, no se guarda como propiedad).
class PhoneNumber(rawNumber: String) {

    // ▶ val number: String
    //   └▶ ② propiedad pública donde quedará el número ya limpio; se
    //           asigna dentro del init.
    val number: String

    // ▶ init {
    //   └▶ ③ bloque que se ejecuta al construir el objeto: limpia y valida.
    init {
        // ▶ var digits = rawNumber.filter { it.isDigit() }
        //   └▶ ④ filter { it.isDigit() } → conserva solo dígitos; elimina
        //           espacios, guiones, paréntesis y el "+".
        var digits = rawNumber.filter { it.isDigit() }

        // ▶ if (digits.length == 11) {
        //   └▶ ⑤ 11 dígitos → puede llevar el código de país delante.
        if (digits.length == 11) {
            // ▶ require(digits.startsWith("1")) { "11-digit numbers must start with 1" }
            //   └▶ ⑥ el único código de país válido es "1".
            require(digits.startsWith("1")) { "11-digit numbers must start with 1" }
            // ▶ digits = digits.drop(1)
            //   └▶ ⑦ .drop(1) → quita el primer carácter, dejando 10 dígitos.
            digits = digits.drop(1)
        }

        // ▶ require(digits.length == 10) { "Incorrect number of digits" }
        //   └▶ ⑧ tras el posible recorte deben quedar exactamente 10 dígitos.
        require(digits.length == 10) { "Incorrect number of digits" }

        // ▶ require(digits[0] in '2'..'9') { "Area code cannot start with 0 or 1" }
        // ▶ require(digits[3] in '2'..'9') { "Exchange code cannot start with 0 or 1" }
        //   └▶ ⑨ el primer dígito del área (pos 0) y del código de
        //           intercambio (pos 3) deben estar en el rango '2'..'9'.
        require(digits[0] in '2'..'9') { "Area code cannot start with 0 or 1" }
        require(digits[3] in '2'..'9') { "Exchange code cannot start with 0 or 1" }

        // ▶ number = digits
        //   └▶ ⑩ si todas las validaciones pasan, se guarda el número limpio.
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
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar una expresión regular Regex("[^0-9]") con .replace("")
 *          en vez de filter { it.isDigit() }.
 *      B)  Extraer las validaciones a funciones privadas separadas
 *          (validateLength, validateAreaCode, ...) para mayor claridad.
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
