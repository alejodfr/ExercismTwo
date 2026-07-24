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

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Limpiar números telefónicos ingresados por el usuario eliminando
 *  puntuación y código de país, validando el formato NANP (NXX-NXX-XXXX).
 *
 *  -----------------------------------------------------------------
 *  🧠  ANÁLISIS DE LA SOLUCIÓN
 *
 *  class PhoneNumber(rawNumber: String) {
 *      val number: String
 *      init {
 *          var digits = rawNumber.filter { it.isDigit() }
 *          if (digits.length == 11) {
 *              require(digits.startsWith("1")) { "11-digit numbers must start with 1" }
 *              digits = digits.drop(1)
 *          }
 *          require(digits.length == 10) { "Incorrect number of digits" }
 *          require(digits[0] in '2'..'9') { "Area code cannot start with 0 or 1" }
 *          require(digits[3] in '2'..'9') { "Exchange code cannot start with 0 or 1" }
 *          number = digits
 *      }
 *  }
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  filter + isDigit — Extrae solo los dígitos del string original.
 *  2.  Código de país — Si hay 11 dígitos y empieza con '1', lo elimina.
 *  3.  require + length — Valida que queden exactamente 10 dígitos.
 *  4.  Rangos con in — Verifica que posición 0 y 3 estén en '2'..'9'.
 *  5.  Asignación — Guarda el número limpio en la propiedad val number.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio                 │
 *  ├───────────────────────────┼──────────────────────────────────────┤
 *  │  filter                   │  rawNumber.filter { it.isDigit() }   │
 *  │  isDigit()                │  Filtra caracteres no numéricos      │
 *  │  require                  │  Valida condiciones con excepción    │
 *  │  drop(n)                  │  digits.drop(1) elimina prefijo      │
 *  │  startsWith               │  digits.startsWith("1")             │
 *  │  Rangos '2'..'9'         │  digits[0] in '2'..'9'              │
 *  │  init block               │  Bloque de inicialización            │
 *  │  val (inmutabilidad)      │  number se asigna una sola vez       │
 *  └───────────────────────────┴──────────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  replace con Regex
 *      rawNumber.replace(Regex("[^0-9]"), "") en vez de filter.
 *  B)  Función privada auxiliar
 *      Extraer validaciones a métodos privados separados.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  O(n) tiempo, O(n) espacio — filter recorre todo el string y crea
 *  uno nuevo. Las validaciones restantes son O(1).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  CLASE PhoneNumber(rawNumber: String)
 *      number: String (inmutable)
 *      INICIALIZAR:
 *          digits = rawNumber SOLO DÍGITOS
 *          SI digits.longitud == 11 ENTONCES
 *              REQUERIR digits EMPIEZA CON "1"
 *              digits = digits SIN PRIMER CARÁCTER
 *          REQUERIR digits.longitud == 10
 *          REQUERIR digits[0] EN '2'..'9'
 *          REQUERIR digits[3] EN '2'..'9'
 *          number = digits
 *      FIN INICIALIZAR
 *  FIN CLASE
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: "+1 (613)-995-0253"
 *  ─────────────────────────────────────────────────────────────────
 *  filter { it.isDigit() } → "16139950253" (11 dígitos)
 *  startsWith("1")? sí → drop(1) → "6139950253"
 *  length == 10? sí
 *  digits[0] = '6' in '2'..'9'? sí
 *  digits[3] = '9' in '2'..'9'? sí
 *  Resultado: "6139950253"
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: "123-456-7890"
 *  ─────────────────────────────────────────────────────────────────
 *  filter → "1234567890" (10 dígitos)
 *  length == 10? sí
 *  digits[0] = '1' in '2'..'9'? NO → IllegalArgumentException
 *  Resultado: "Area code cannot start with 0 or 1"
 *
 *  ================================================================
 */