@file:Suppress("SpellCheckingInspection")


/**
 *  Instructions
 *
 *  Create an implementation of the rotational cipher, also sometimes called
 *  the Caesar cipher.
 *
 *  The Caesar cipher is a simple shift cipher that relies on transposing all
 *  the letters in the alphabet using an integer key between 0 and 26. Using a
 *  key of 0 or 26 will always yield the same output due to modular arithmetic.
 *  The letter is shifted for as many values as the value of the key.
 *
 *  The general notation for rotational ciphers is ROT + <key>. The most
 *  commonly used rotational cipher is ROT13.
 *
 *  A ROT13 on the Latin alphabet would be as follows:
 *
 *    Plain:  abcdefghijklmnopqrstuvwxyz
 *    Cipher: nopqrstuvwxyzabcdefghijklm
 *
 *  It is stronger than the Atbash cipher because it has 27 possible keys, and
 *  25 usable keys.
 *
 *  Ciphertext is written out in the same formatting as the input including
 *  spaces and punctuation.
 *
 *  Examples
 *
 *    ROT5  "omg"                              -> "trl"
 *    ROT0  "c"                                -> "c"
 *    ROT26 "Cool"                             -> "Cool"
 *    ROT13 "The quick brown fox jumps..."     -> "Gur dhvpx oebja sbk..."
 *    ROT13 "Gur dhvpx oebja sbk..."           -> "The quick brown fox jumps..."
 *
 */

class RotationalCipher(private val key: Int) {

    init {
        require(key in 0..26) { "The key must be between 0 and 26" }
    }

    fun encode(text: String): String {
        val plain = "abcdefghijklmnopqrstuvwxyz"
        val cipher = plain.drop(key) + plain.take(key)

        return text.map { char ->
            when {
                char.isLowerCase() -> {
                    val index = plain.indexOf(char)
                    cipher[index]
                }
                char.isUpperCase() -> {
                    val lowerChar = char.lowercaseChar()
                    val index = plain.indexOf(lowerChar)
                    cipher[index].uppercaseChar()
                }
                else -> char
            }
        }.joinToString("")
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Implementar el cifrado César (rotacional) desplazando cada letra
 *  del alfabeto una cantidad fija de posiciones definida por una clave.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *  1.  Definir el alfabeto base en orden (a-z).
 *  2.  Generar el alfabeto cifrado rotando los caracteres según la key.
 *  3.  Recorrer cada carácter del texto de entrada.
 *  4.  Si es letra, buscar su índice en el alfabeto base y reemplazarlo
 *      por el carácter en la misma posición del alfabeto cifrado.
 *  5.  Conservar mayúsculas, minúsculas y caracteres no alfabéticos.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  require(key in 0..26) — valida que la clave esté en el rango
 *      permitido; lanza IllegalArgumentException si no.
 *  2.  plain.drop(key) + plain.take(key) — construye el alfabeto
 *      desplazado: descarta los primeros `key` chars y los coloca
 *      al final.
 *  3.  text.map { char -> ... } — transforma cada carácter aplicando
 *      una lamba.
 *  4.  char.isLowerCase() / isUpperCase() — verifica si es letra
 *      minúscula o mayúscula.
 *  5.  plain.indexOf(char) — encuentra la posición del carácter en
 *      el alfabeto original.
 *  6.  cipher[index] — obtiene el carácter cifrado en esa posición.
 *  7.  .joinToString("") — une la lista resultante en un String.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  require()                │  Validar clave en 0..26          │
 *  │  String.drop(n)           │  Quitar primeros n caracteres    │
 *  │  String.take(n)           │  Tomar primeros n caracteres     │
 *  │  CharSequence.map {}      │  Transformar cada carácter       │
 *  │  Char.isLowerCase()       │  Detectar minúscula              │
 *  │  Char.isUpperCase()       │  Detectar mayúscula              │
 *  │  String.indexOf()         │  Buscar posición de un char      │
 *  │  Char.uppercaseChar()     │  Convertir a mayúscula           │
 *  │  Iterable.joinToString()  │  Unir lista en un String         │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  Usar Character.isLetter() y aritmética módulo 26 para
 *      desplazar directamente con (char - 'a' + key) % 26.
 *  B)  fold() en vez de map() + joinToString() para construir
 *      el resultado en una sola pasada.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  Tiempo: O(n) — recorre cada carácter una vez.
 *  Memoria: O(n) — construye un nuevo String del mismo tamaño.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  CLASE RotationalCipher(key: Int)
 *      INICIALIZACIÓN:
 *          SI key NO está en 0..26 → lanzar error
 *
 *      FUNCIÓN encode(texto: String): String
 *          alfabeto := "abcdefghijklmnopqrstuvwxyz"
 *          cifrado := alfabeto.drop(key) + alfabeto.take(key)
 *          resultado := ""
 *          POR CADA char EN texto:
 *              SI char es minúscula:
 *                  índice := alfabeto.indexOf(char)
 *                  resultado += cifrado[índice]
 *              SI NO SI char es mayúscula:
 *                  minúscula := char en minúscula
 *                  índice := alfabeto.indexOf(minúscula)
 *                  resultado += cifrado[índice] en mayúscula
 *              SI NO:
 *                  resultado += char
 *          DEVOLVER resultado
 *      FIN FUNCIÓN
 *  FIN CLASE
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: RotationalCipher(5).encode("omg")
 *  ─────────────────────────────────────────────────────────────────
 *  key = 5
 *  plain  = abcdefghijklmnopqrstuvwxyz
 *  cipher = fghijklmnopqrstuvwxyzabcde
 *  'o' → índice 14 → cipher[14] = 't'
 *  'm' → índice 12 → cipher[12] = 'r'
 *  'g' → índice 6  → cipher[6]  = 'l'
 *  Resultado: "trl"
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: RotationalCipher(13).encode("ABC")
 *  ─────────────────────────────────────────────────────────────────
 *  key = 13
 *  plain  = abcdefghijklmnopqrstuvwxyz
 *  cipher = nopqrstuvwxyzabcdefghijklm
 *  'A' → minúscula 'a' → índice 0 → cipher[0] = 'n' → mayúscula 'N'
 *  'B' → minúscula 'b' → índice 1 → cipher[1] = 'o' → mayúscula 'O'
 *  'C' → minúscula 'c' → índice 2 → cipher[2] = 'p' → mayúscula 'P'
 *  Resultado: "NOP"
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 3: RotationalCipher(0).encode("Cool!")
 *  ─────────────────────────────────────────────────────────────────
 *  key = 0
 *  plain  = abcdefghijklmnopqrstuvwxyz
 *  cipher = abcdefghijklmnopqrstuvwxyz
 *  'C' → 'C' (sin cambio)
 *  'o' → 'o'
 *  'o' → 'o'
 *  'l' → 'l'
 *  '!' → '!' (no es letra, se conserva)
 *  Resultado: "Cool!"
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 4: RotationalCipher(22).encode("Kotlin is better")
 *  ─────────────────────────────────────────────────────────────────
 *  key = 22
 *  plain  = abcdefghijklmnopqrstuvwxyz
 *  cipher = wxyzabcdefghijklmnopqrstuv
 *  'K' → 'k'(10) → cipher[10] = 'g' → mayúscula 'G'
 *  'o' → index 14  → cipher[14] = 'k'
 *  't' → index 19  → cipher[19] = 'p'
 *  'l' → index 11  → cipher[11] = 'h'
 *  'i' → index 8   → cipher[8]  = 'e'
 *  'n' → index 13  → cipher[13] = 'j'
 *  ' ' → ' ' (no es letra)
 *  'i' → index 8   → cipher[8]  = 'e'
 *  's' → index 18  → cipher[18] = 'o'
 *  ' ' → ' '
 *  'b' → index 1   → cipher[1]  = 'x'
 *  'e' → index 4   → cipher[4]  = 'a'
 *  't' → index 19  → cipher[19] = 'p'
 *  't' → index 19  → cipher[19] = 'p'
 *  'e' → index 4   → cipher[4]  = 'a'
 *  'r' → index 17  → cipher[17] = 'n'
 *  Resultado: "Gkhpj eo xappan"
 *
 *
 *  ================================================================
 */