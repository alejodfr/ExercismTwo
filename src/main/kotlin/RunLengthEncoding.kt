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



// ▶ object RunLengthEncoding {
//   └▶ ① object → singleton: una única instancia con nombre RunLengthEncoding.
object RunLengthEncoding {

    // ▶ fun encode(input: String): String {
    //   └▶ ② comprime: cada grupo de caracteres iguales seguidos se
    //           sustituye por conteo + carácter (el conteo se omite si es 1).
    fun encode(input: String): String {
        // ▶ if (input.isEmpty()) return ""
        //   └▶ ③ caso borde: sin caracteres no hay nada que codificar; además
        //           evita que input[0] falle más abajo.
        if (input.isEmpty()) return ""

        // ▶ var count = 1
        // ▶ var currentChar = input[0]
        // ▶ val result = StringBuilder()
        //   ├▶ ④ count → repeticiones del grupo actual (empieza en 1: ya
        //   │       tenemos el primer carácter).
        //   ├▶ ⑤ currentChar → carácter que se está contando.
        //   └▶ ⑥ StringBuilder → acumula el resultado sin crear muchos String.
        var count = 1
        var currentChar = input[0]
        val result = StringBuilder()

        // ▶ for (i in 1 until input.length) {
        //   └▶ ⑦ recorre desde el índice 1 (el 0 ya está capturado) hasta el
        //           final; until excluye input.length.
        for (i in 1 until input.length) {
            // ▶ if (input[i] == currentChar) { count++ }
            //   └▶ ⑧ si sigue el mismo carácter, solo se incrementa el contador.
            if (input[i] == currentChar) {
                count++
            } else {
                // ▶ if (count > 1) result.append(count)
                // ▶ result.append(currentChar)
                // ▶ count = 1;  currentChar = input[i]
                //   └▶ ⑨ carácter distinto → "cierra" el grupo previo: escribe
                //           el número solo si hubo más de una repetición, luego
                //           el carácter; reinicia el contador y cambia de carácter.
                if (count > 1) result.append(count)
                result.append(currentChar)
                count = 1
                currentChar = input[i]
            }
        }
        // ▶ if (count > 1) result.append(count)
        // ▶ result.append(currentChar)
        // ▶ return result.toString()
        //   └▶ ⑩ al salir del bucle queda el último grupo sin cerrar: se
        //           escribe igual que los demás y se devuelve el texto.
        if (count > 1) result.append(count)
        result.append(currentChar)
        return result.toString()
    }

    // ▶ fun decode(input: String): String {
    //   └▶ ⑪ proceso inverso: un número indica cuántas veces se repite el
    //           carácter que le sigue.
    fun decode(input: String): String {
        // ▶ val result = StringBuilder()
        // ▶ var countStr = ""
        //   ├▶ ⑫ result → acumula el texto expandido.
        //   └▶ ⑬ countStr → junta los dígitos del número cifra a cifra
        //           (puede tener varias, p. ej. "12").
        val result = StringBuilder()
        var countStr = ""

        // ▶ for (char in input) {
        for (char in input) {
            // ▶ if (char.isDigit()) { countStr += char }
            //   └▶ ⑭ si es dígito, se concatena a countStr para formar el número.
            if (char.isDigit()) {
                countStr += char
            } else {
                // ▶ val count = if (countStr.isEmpty()) 1 else countStr.toInt()
                //   └▶ ⑮ si no se leyó ningún dígito, el conteo es 1; si sí, se
                //           convierte countStr a entero.
                val count = if (countStr.isEmpty()) 1 else countStr.toInt()
                // ▶ repeat(count) { result.append(char) }
                //   └▶ ⑯ añade la letra esa cantidad de veces.
                repeat(count) { result.append(char) }
                // ▶ countStr = ""
                //   └▶ ⑰ limpia el acumulador de dígitos para el siguiente grupo.
                countStr = ""
            }
        }
        // ▶ return result.toString()
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
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: encode("AABCCCDEEEE")
 *      ─────────────────────────────────────────────────────────
 *      currentChar='A', count=1
 *      i=1 'A' == 'A' → count=2
 *      i=2 'B' ≠ 'A'  → count>1: escribe "2A"; count=1; currentChar='B'
 *      i=3 'C' ≠ 'B'  → count=1: escribe "B";  count=1; currentChar='C'
 *      i=4..5 'C' == 'C' → count=3
 *      i=6 'D' ≠ 'C'  → escribe "3C"; currentChar='D'
 *      i=7 'E' ≠ 'D'  → escribe "D";  currentChar='E'
 *      i=8..10 'E' == 'E' → count=4
 *      Fin del bucle → último grupo: escribe "4E"
 *      Resultado: "2AB3CD4E"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: decode("12WB12W3B24WB")
 *      ─────────────────────────────────────────────────────────
 *      "12"→'W' = 12 'W';  ""→'B' = "B";  "12"→'W' = 12 'W';
 *      "3"→'B' = "BBB";  "24"→'W' = 24 'W';  ""→'B' = "B"
 *      Resultado: "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 3: encode("")  y  encode("XYZ")
 *      ─────────────────────────────────────────────────────────
 *      encode("")  → input vacío → devuelve ""
 *      encode("XYZ") → ningún carácter se repite: count=1 siempre, nunca
 *      se escribe número → "XYZ"
 *      Resultado: "" y "XYZ"
 *
 *  ================================================================
 */
