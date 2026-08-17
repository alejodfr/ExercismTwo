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
 *
 *      Implementar el cifrado César (rotacional): desplazar cada letra
 *      del alfabeto una cantidad fija de posiciones definida por una
 *      clave, preservando mayúsculas/minúsculas y caracteres no
 *      alfabéticos.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Validar que la clave esté entre 0 y 26.
 *      II.  Construir el alfabeto cifrado rotando el alfabeto base
 *           según la clave.
 *      III. Recorrer cada carácter del texto: si es letra, ubicar su
 *           posición en el alfabeto base y sustituirla por el
 *           carácter en la misma posición del alfabeto cifrado.
 *      IV.  Conservar mayúsculas, minúsculas y símbolos no alfabéticos.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  init {
 *      →      require(key in 0..26) { "The key must be between 0 and 26" }
 *      ①  Valida que la clave esté en el rango permitido; lanza
 *          excepción si no.
 *      →  }
 *
 *      →  val plain = "abcdefghijklmnopqrstuvwxyz"
 *      →  val cipher = plain.drop(key) + plain.take(key)
 *      ②  .drop(key) descarta los primeros key caracteres; .take(key)
 *          toma esos mismos caracteres y los pone al final: así se
 *          construye el alfabeto rotado.
 *
 *      →      return text.map { char ->
 *      →          when {
 *      →              char.isLowerCase() -> {
 *      →                  val index = plain.indexOf(char)
 *      →                  cipher[index]
 *      ③  Si es minúscula, se busca su posición en plain y se toma el
 *          carácter en esa misma posición del alfabeto cifrado.
 *
 *      →              char.isUpperCase() -> {
 *      →                  val lowerChar = char.lowercaseChar()
 *      →                  val index = plain.indexOf(lowerChar)
 *      →                  cipher[index].uppercaseChar()
 *      ④  Si es mayúscula, se busca su versión minúscula en plain, se
 *          sustituye y se vuelve a convertir a mayúscula.
 *
 *      →              else -> char
 *      ⑤  Cualquier carácter no alfabético se deja igual.
 *      →          }
 *      →      }.joinToString("")
 *      ⑥  .map transforma cada carácter; .joinToString("") reconstruye
 *          el String final sin separador.
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      CLASE RotationalCipher(key)
 *          AL CREAR: REQUERIR key EN 0..26
 *          FUNCIÓN encode(texto): Texto
 *              alfabeto ← "abcdefghijklmnopqrstuvwxyz"
 *              cifrado ← alfabeto.QUITAR_PRIMEROS(key) + alfabeto.TOMAR_PRIMEROS(key)
 *              resultado ← ""
 *              PARA CADA char EN texto:
 *                  SI char es minúscula: resultado += cifrado[alfabeto.INDICE(char)]
 *                  SINO SI char es mayúscula: resultado += cifrado[alfabeto.INDICE(minusc)].MAYUSCULA()
 *                  SINO: resultado += char
 *              DEVOLVER resultado
 *      FIN CLASE
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
