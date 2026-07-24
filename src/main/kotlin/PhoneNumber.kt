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