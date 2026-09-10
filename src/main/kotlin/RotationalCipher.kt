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

// ▶ class RotationalCipher(private val key: Int) {
//   └▶ ① key → cuántas posiciones se desplaza cada letra; private val →
//           inmutable e interna.
class RotationalCipher(private val key: Int) {

    // ▶ init { require(key in 0..26) { "The key must be between 0 and 26" } }
    //   └▶ ② al construir el objeto se valida que la clave esté en 0..26.
    init {
        require(key in 0..26) { "The key must be between 0 and 26" }
    }

    // ▶ fun encode(text: String): String {
    //   └▶ ③ recibe el texto plano y devuelve el texto cifrado.
    fun encode(text: String): String {
        // ▶ val plain = "abcdefghijklmnopqrstuvwxyz"
        //   └▶ ④ alfabeto base sin rotar.
        val plain = "abcdefghijklmnopqrstuvwxyz"
        // ▶ val cipher = plain.drop(key) + plain.take(key)
        //   ├▶ ⑤ .drop(key) → descarta los primeros key caracteres.
        //   └▶ ⑥ .take(key) → toma esos mismos y los pega al final →
        //           alfabeto rotado.
        val cipher = plain.drop(key) + plain.take(key)

        // ▶ return text.map { char ->
        //   └▶ ⑦ .map → transforma cada carácter del texto.
        return text.map { char ->
            // ▶ when {
            when {
                // ▶ char.isLowerCase() -> { val index = plain.indexOf(char); cipher[index] }
                //   └▶ ⑧ minúscula: busca su posición en plain y toma el
                //           carácter en la misma posición del alfabeto cifrado.
                char.isLowerCase() -> {
                    val index = plain.indexOf(char)
                    cipher[index]
                }
                // ▶ char.isUpperCase() -> { ... cipher[index].uppercaseChar() }
                //   └▶ ⑨ mayúscula: se pasa a minúscula para buscarla, se
                //           sustituye y se vuelve a poner en mayúscula.
                char.isUpperCase() -> {
                    val lowerChar = char.lowercaseChar()
                    val index = plain.indexOf(lowerChar)
                    cipher[index].uppercaseChar()
                }
                // ▶ else -> char
                //   └▶ ⑩ cualquier carácter no alfabético se deja igual.
                else -> char
            }
        }.joinToString("")
        //   └▶ ⑪ .joinToString("") → reconstruye el String final sin separador.
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Implementar el cifrado César (rotacional): desplazar cada letra
 *      del alfabeto una cantidad fija de posiciones definida por una
 *      clave, preservando mayúsculas/minúsculas y caracteres no
 *      alfabéticos.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar aritmética módulo 26 directamente: ((char - 'a' + key)
 *          % 26 + 'a'.code).toChar(), sin construir el alfabeto cifrado.
 *      B)  Usar fold() en vez de map() + joinToString() para construir
 *          el resultado en una sola pasada sin lista intermedia.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "RotationalCipher(5).encode(\"omg\")"
 *      ─────────────────────────────────────────────────────────
 *      cipher = fghijklmnopqrstuvwxyzabcde
 *      'o'→índice 14→'t'; 'm'→índice 12→'r'; 'g'→índice 6→'l'
 *      Resultado: "trl"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "RotationalCipher(0).encode(\"Cool!\")"
 *      ─────────────────────────────────────────────────────────
 *      key=0 → cipher es idéntico a plain → nada cambia; '!' se
 *      conserva por no ser letra.
 *      Resultado: "Cool!"
 *
 *  ================================================================
 */
