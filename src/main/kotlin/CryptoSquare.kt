@file:Suppress("SpellCheckingInspection")

import kotlin.math.ceil
import kotlin.math.sqrt


/**
 * Instructions - Crypto Square
 *
 * Implement the classic method for composing secret messages called a square code.
 * Given an English text, output the encoded version of that text.
 *
 * 1. Normalization
 *    The input is normalized: spaces and punctuation are removed, and the message
 *    is down-cased.
 *
 * 2. Rectangle size
 *    The plaintext is organized into a rectangle as square as possible. The size
 *    is decided by the length of the message. If c = columns and r = rows, find
 *    the smallest possible integer c such that:
 *      - r * c >= length of message
 *      - c >= r
 *      - c - r <= 1
 *
 * 3. Break into rows
 *    The normalized characters are broken into rows forming the rectangle.
 *    Example:
 *      Input:  "If man was meant to stay on the ground, god would have given us roots."
 *      Normalized: "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"
 *      Rectangle (c=8, r=7):
 *        "ifmanwas"
 *        "meanttos"
 *        "tayonthe"
 *        "groundgo"
 *        "dwouldha"
 *        "vegivenu"
 *        "sroots  "
 *
 * 4. Encode
 *    Read down the columns going left to right. The message above becomes:
 *      "imtgdvsfearwermayoogoanouuiontnnlvtwttddesaohghnsseoau"
 *
 * 5. Chunk output
 *    Output the encoded text in chunks that fill perfect rectangles (r x c),
 *    with c chunks of r length, separated by spaces. For phrases that are n
 *    characters short of the perfect rectangle, pad each of the last n chunks
 *    with a single trailing space.
 *      "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "
 *
 *    Stacking these chunks reveals the original ciphertext layout:
 *      "imtgdvs"
 *      "fearwer"
 *      "mayoogo"
 *      "anouuio"
 *      "ntnnlvt"
 *      "wttddes"
 *      "aohghn "
 *      "sseoau "
 *
 * ---------------------------------------------------------------------------
 *
 * Instrucciones - Crypto Square (traducción)
 *
 * Implementa el metdo clásico para componer mensajes secretos llamado
 * "square code" (código cuadrado). Dado un texto en inglés, produce la
 * versión codificada de ese texto.
 *
 * 1. Normalización
 *    La entrada se normaliza: se eliminan espacios y signos de puntuación,
 *    y el mensaje se convierte a minúsculas.
 *
 * 2. Tamaño del rectángulo
 *    El texto plano se organiza en un rectángulo lo más cuadrado posible.
 *    El tamaño se determina según la longitud del mensaje. Si c = columnas
 *    y r = filas, encuentra el menor entero c posible tal que:
 *      - r * c >= longitud del mensaje
 *      - c >= r
 *      - c - r <= 1
 *
 * 3. Dividir en filas
 *    Los caracteres normalizados se separan en filas formando el rectángulo.
 *
 * 4. Codificar
 *    Se lee hacia abajo por las columnas, de izquierda a derecha.
 *
 * 5. Salida por fragmentos
 *    Entrega el texto codificado en fragmentos que llenen rectángulos perfectos
 *    (r x c), con c fragmentos de longitud r, separados por espacios. Para
 *    frases a las que les falten n caracteres para completar el rectángulo
 *    perfecto, rellena cada uno de los últimos n fragmentos con un espacio
 *    al final.
 */

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val normalizedText = plaintext.filter { it.isLetterOrDigit() }.lowercase()
        if (normalizedText.isEmpty()) return ""
        val normalTextLength = normalizedText.length
        val c = ceil(sqrt(normalTextLength.toDouble())).toInt()
        val r = ceil((normalTextLength / c).toDouble()).toInt()
        val chunked = normalizedText.chunked(c).map { it.padEnd(c) }
        val auxList = mutableListOf<String>()
        for (i in 0 until c) {
            var column = ""
            for (j in chunked.indices) {
                column += chunked[j][i]
            }
            auxList.add(column)
        }
        return auxList.joinToString(" ")
    }

}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Implementar el "square code": normalizar un texto, organizarlo
 *      en un rectángulo lo más cuadrado posible, leer sus columnas de
 *      arriba a abajo y devolver el resultado en fragmentos separados
 *      por espacios.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Normalizar: quitar todo lo que no sea letra/dígito y pasar
 *           a minúsculas.
 *      II.  Calcular columnas c = techo(√longitud) y filas r =
 *           techo(longitud / c).
 *      III. Dividir el texto normalizado en trozos de tamaño c,
 *           rellenando con espacios el último trozo si falta.
 *      IV.  Leer cada columna recorriendo todas las filas y
 *           concatenar los caracteres encontrados.
 *      V.   Unir las columnas resultantes con un espacio.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  val normalizedText = plaintext.filter { it.isLetterOrDigit() }.lowercase()
 *      ①  filter conserva solo letras y dígitos; lowercase() unifica
 *          mayúsculas y minúsculas.
 *
 *      →  if (normalizedText.isEmpty()) return ""
 *      ②  Caso borde: sin texto normalizado, no hay nada que cifrar.
 *
 *      →  val c = ceil(sqrt(normalTextLength.toDouble())).toInt()
 *      ③  La raíz cuadrada da el tamaño ideal; ceil (techo) redondea
 *          hacia arriba para garantizar c >= r.
 *
 *      →  val r = ceil((normalTextLength / c).toDouble()).toInt()
 *      ④  Calcula cuántas filas hacen falta para cubrir todos los
 *          caracteres con c columnas.
 *
 *      →  val chunked = normalizedText.chunked(c).map { it.padEnd(c) }
 *      ⑤  .chunked(c) parte el texto en trozos de tamaño c (filas);
 *          .padEnd(c) rellena con espacios el último trozo incompleto.
 *
 *      →  for (i in 0 until c) {
 *      →      var column = ""
 *      →      for (j in chunked.indices) {
 *      →          column += chunked[j][i]
 *      ⑥  Para cada columna i, recorre todas las filas j y concatena
 *          el carácter en la posición i de cada fila.
 *      →      }
 *      →      auxList.add(column)
 *      →  }
 *
 *      →  return auxList.joinToString(" ")
 *      ⑦  Une todas las columnas leídas, separadas por un espacio.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar transposición de matriz genérica: convertir las filas
 *          en List<List<Char>> y transponerla con una función auxiliar
 *          en vez de índices manuales.
 *      B)  Calcular r y c con enteros sin pasar por Double, iterando
 *          desde 1 hasta encontrar el primer c que cumpla las 3
 *          condiciones del enunciado.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN ciphertext(textoPlano): Texto
 *          normal ← textoPlano.FILTRAR(esLetraODigito).MINUSCULAS()
 *          SI normal.VACIO(): DEVOLVER ""
 *          columnas ← TECHO(RAIZ(normal.LONGITUD))
 *          filas ← TECHO(normal.LONGITUD / columnas)
 *          bloques ← normal.DIVIDIR(columnas).RELLENAR(columnas, ' ')
 *          resultado ← LISTA_VACIA
 *          PARA i DESDE 0 HASTA columnas-1:
 *              columna ← ""
 *              PARA CADA bloque EN bloques: columna += bloque[i]
 *              resultado.AGREGAR(columna)
 *          DEVOLVER resultado.UNIR(" ")
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "ciphertext(\"123456789\")"
 *      ─────────────────────────────────────────────────────────
 *      normal="123456789" (9 chars), c=ceil(√9)=3, r=ceil(9/3)=3
 *      chunked → ["123","456","789"]
 *      columnas → "147","258","369"
 *      Resultado: "147 258 369"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "ciphertext(\"\")"
 *      ─────────────────────────────────────────────────────────
 *      normal="" → isEmpty() → return ""
 *      Resultado: ""
 *
 *  ================================================================
 */
