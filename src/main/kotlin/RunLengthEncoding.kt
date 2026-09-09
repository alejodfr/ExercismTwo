@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 * Implement run-length encoding and decoding.
 *
 * Run-length encoding (RLE) is a simple form of data compression, where
 * runs (consecutive data elements) are replaced by just one data value
 * and count.
 *
 * For example we can represent the original 53 characters with only 13.
 *
 *     "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"
 *         ->  "12WB12W3B24WB"
 *
 * RLE allows the original data to be perfectly reconstructed from the
 * compressed data, which makes it a lossless data compression.
 *
 *     "AABCCCDEEEE"  ->  "2AB3CD4E"  ->  "AABCCCDEEEE"
 *
 * For simplicity, you can assume that the unencoded string will only
 * contain the letters A through Z (either lower or upper case) and
 * whitespace. This way data to be encoded will never contain any
 * numbers and numbers inside data to be decoded always represent
 * the count for the following character.
 */



object RunLengthEncoding {

    fun encode(input: String): String {
        if (input.isEmpty()) return ""

        var count = 1
        var currentChar = input[0]
        val result = StringBuilder()

        for (i in 1 until input.length) {
            if (input[i] == currentChar) {
                count++
            } else {
                if (count > 1) result.append(count)
                result.append(currentChar)
                count = 1
                currentChar = input[i]
            }
        }
        if (count > 1) result.append(count)
        result.append(currentChar)
        return result.toString()
    }

    fun decode(input: String): String {
        val result = StringBuilder()
        var countStr = ""

        for (char in input) {
            if (char.isDigit()) {
                countStr += char
            } else {
                val count = if (countStr.isEmpty()) 1 else countStr.toInt()
                repeat(count) { result.append(char) }
                countStr = ""
            }
        }
        return result.toString()
    }
}


/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Implementar la codificación y decodificación por longitud de
 *      series (Run-Length Encoding). Al codificar, se sustituye cada
 *      grupo de caracteres consecutivos iguales por el número de
 *      repeticiones seguido del carácter (el número se omite si solo
 *      aparece una vez). Al decodificar, se hace el proceso inverso:
 *      un número indica cuántas veces se repite el carácter siguiente.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.    encode: si el texto está vacío, devolver "".
 *      II.   Recorrer el texto llevando un carácter actual y un
 *            contador de cuántas veces se ha repetido seguido.
 *      III.  Cuando aparece un carácter distinto, "cerrar" el grupo
 *            anterior: escribir el contador (solo si es mayor que 1)
 *            y luego el carácter; después reiniciar el contador a 1 y
 *            cambiar el carácter actual.
 *      IV.   Al terminar el bucle queda un último grupo sin cerrar:
 *            escribirlo también.
 *      V.    decode: recorrer el texto acumulando los dígitos en un
 *            texto auxiliar; al encontrar una letra, convertir esos
 *            dígitos a número (o 1 si no había dígitos) y repetir la
 *            letra esa cantidad de veces.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun encode(input: String): String {
 *      →      if (input.isEmpty()) return ""
 *      ①  Caso borde: si no hay caracteres, no hay nada que codificar
 *          y se devuelve cadena vacía. Además evita que input[0] falle
 *          más abajo.
 *
 *      →      var count = 1
 *      →      var currentChar = input[0]
 *      →      val result = StringBuilder()
 *      ②  count cuenta las repeticiones del grupo actual (empieza en 1
 *          porque ya tenemos el primer carácter). currentChar guarda
 *          el carácter que se está contando. StringBuilder acumula el
 *          resultado de forma eficiente sin crear muchos String.
 *
 *      →      for (i in 1 until input.length) {
 *      ③  Se recorre desde el índice 1 (el 0 ya está capturado) hasta
 *          el último carácter. "until" excluye input.length.
 *
 *      →          if (input[i] == currentChar) {
 *      →              count++
 *      ④  Si el carácter actual es igual al que venimos contando, solo
 *          se incrementa el contador y se sigue.
 *
 *      →          } else {
 *      →              if (count > 1) result.append(count)
 *      →              result.append(currentChar)
 *      →              count = 1
 *      →              currentChar = input[i]
 *      ⑤  Si es distinto, se cierra el grupo previo: se añade el número
 *          solo cuando hubo más de una repetición, luego el carácter.
 *          Después se reinicia el contador a 1 y se pasa a contar el
 *          nuevo carácter.
 *      →          }
 *      →      }
 *
 *      →      if (count > 1) result.append(count)
 *      →      result.append(currentChar)
 *      →      return result.toString()
 *      ⑥  Al salir del bucle siempre queda el último grupo pendiente
 *          (nunca se cerró porque no vino un carácter distinto tras
 *          él). Se escribe igual que los demás y se devuelve el texto.
 *
 *      →  fun decode(input: String): String {
 *      →      val result = StringBuilder()
 *      →      var countStr = ""
 *      ⑦  result acumula el texto expandido. countStr va juntando los
 *          dígitos que forman el número de repeticiones (puede tener
 *          varias cifras, p. ej. "12").
 *
 *      →      for (char in input) {
 *      →          if (char.isDigit()) {
 *      →              countStr += char
 *      ⑧  Si el carácter es un dígito, se concatena a countStr para
 *          construir el número completo cifra a cifra.
 *
 *      →          } else {
 *      →              val count = if (countStr.isEmpty()) 1 else countStr.toInt()
 *      →              repeat(count) { result.append(char) }
 *      →              countStr = ""
 *      ⑨  Si es una letra: si no se había leído ningún dígito, el conteo
 *          es 1; si sí, se convierte countStr a entero. repeat(count)
 *          añade la letra esa cantidad de veces. Luego se limpia
 *          countStr para el siguiente grupo.
 *      →          }
 *      →      }
 *      →      return result.toString()
 *      ⑩  Se devuelve el texto reconstruido. Como el enunciado garantiza
 *          que un número siempre va seguido de un carácter, no queda
 *          countStr sin usar al final.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  encode con expresiones regulares: buscar el patrón
 *          "(.)\\1*" (un carácter y sus repeticiones), y por cada
 *          coincidencia emitir length + carácter, omitiendo el número
 *          si length == 1.
 *      B)  encode agrupando: recorrer el texto y partirlo en bloques de
 *          caracteres iguales (fold o un bucle que arma una lista de
 *          pares carácter/conteo), y luego mapear cada par a texto.
 *      C)  decode con regex "(\\d*)(\\D)": el primer grupo captura los
 *          dígitos (opcionales) y el segundo el carácter; repetir el
 *          carácter según el número (o 1 si viene vacío).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN encode(input): Texto
 *          SI input está vacío: DEVOLVER ""
 *          count ← 1
 *          currentChar ← input[0]
 *          result ← constructor de texto vacío
 *          PARA i DESDE 1 HASTA longitud(input) - 1:
 *              SI input[i] == currentChar:
 *                  count ← count + 1
 *              SINO:
 *                  SI count > 1: AÑADIR count A result
 *                  AÑADIR currentChar A result
 *                  count ← 1
 *                  currentChar ← input[i]
 *          SI count > 1: AÑADIR count A result
 *          AÑADIR currentChar A result
 *          DEVOLVER result COMO TEXTO
 *      FIN FUNCIÓN
 *
 *      FUNCIÓN decode(input): Texto
 *          result ← constructor de texto vacío
 *          countStr ← ""
 *          PARA CADA char EN input:
 *              SI char es dígito:
 *                  countStr ← countStr + char
 *              SINO:
 *                  SI countStr está vacío: count ← 1
 *                  SINO: count ← countStr COMO ENTERO
 *                  REPETIR count VECES: AÑADIR char A result
 *                  countStr ← ""
 *          DEVOLVER result COMO TEXTO
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: encode("AABCCCDEEEE")
 *      ─────────────────────────────────────────────────────────
 *      currentChar='A', count=1
 *      i=1 'A' == 'A' → count=2
 *      i=2 'B' ≠ 'A'  → count>1: escribe "2A"; count=1; currentChar='B'
 *      i=3 'C' ≠ 'B'  → count=1: escribe "B";  count=1; currentChar='C'
 *      i=4 'C' == 'C' → count=2
 *      i=5 'C' == 'C' → count=3
 *      i=6 'D' ≠ 'C'  → escribe "3C"; count=1; currentChar='D'
 *      i=7 'E' ≠ 'D'  → escribe "D";  count=1; currentChar='E'
 *      i=8 'E' == 'E' → count=2
 *      i=9 'E' == 'E' → count=3
 *      i=10 'E' == 'E' → count=4
 *      Fin del bucle → último grupo: escribe "4E"
 *      Resultado: "2AB3CD4E"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: decode("12WB12W3B24WB")
 *      ─────────────────────────────────────────────────────────
 *      '1','2' → countStr="12"
 *      'W'     → count=12 → 12 letras 'W'; countStr=""
 *      'B'     → countStr vacío → count=1 → "B"
 *      '1','2' → countStr="12"
 *      'W'     → 12 letras 'W'; countStr=""
 *      '3'     → countStr="3"
 *      'B'     → 3 letras 'B'; countStr=""
 *      '2','4' → countStr="24"
 *      'W'     → 24 letras 'W'; countStr=""
 *      'B'     → count=1 → "B"
 *      Resultado: "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 3: encode("")  y  encode("XYZ")
 *      ─────────────────────────────────────────────────────────
 *      encode("")  → input vacío → devuelve ""
 *      encode("XYZ") → ningún carácter se repite: cada grupo tiene
 *      count=1, así que nunca se escribe número → "XYZ"
 *      Resultado: "" y "XYZ"
 *
 *  ================================================================
 */


