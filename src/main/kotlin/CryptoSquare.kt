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
 * Implementa el métdo clásico para componer mensajes secretos llamado
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
 *    Ejemplo:
 *      Entrada:  "If man was meant to stay on the ground, god would have given us roots."
 *      Normalizado: "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"
 *      Rectángulo (c=8, r=7):
 *        "ifmanwas"
 *        "meanttos"
 *        "tayonthe"
 *        "groundgo"
 *        "dwouldha"
 *        "vegivenu"
 *        "sroots  "
 *
 * 4. Codificar
 *    Se lee hacia abajo por las columnas, de izquierda a derecha. El mensaje
 *    anterior se convierte en:
 *      "imtgdvsfearwermayoogoanouuiontnnlvtwttddesaohghnsseoau"
 *
 * 5. Salida por fragmentos
 *    Entrega el texto codificado en fragmentos que llenen rectángulos perfectos
 *    (r x c), con c fragmentos de longitud r, separados por espacios. Para
 *    frases a las que les falten n caracteres para completar el rectángulo
 *    perfecto, rellena cada uno de los últimos n fragmentos con un espacio
 *    al final.
 *      "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "
 *
 *    Al apilar estos fragmentos se revela la disposición original del
 *    cifrado:
 *      "imtgdvs"
 *      "fearwer"
 *      "mayoogo"
 *      "anouuio"
 *      "ntnnlvt"
 *      "wttddes"
 *      "aohghn "
 *      "sseoau "
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

/**
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Implementar el "square code" (código cuadrado): un método clásico para
    componer mensajes secretos.

    OBJETIVOS:
    I.   Normalizar el texto: eliminar espacios y puntuación, convertir a
         minúsculas.
    II.  Determinar el tamaño del rectángulo (columnas c y filas r) donde:
           - r * c >= longitud del mensaje
           - c >= r
           - c - r <= 1
    III. Dividir el texto normalizado en filas de longitud c (rellenando con
         espacios la última fila si falta).
    IV.  Leer las columnas de arriba a abajo, de izquierda a derecha.
    V.   Unir las columnas con un espacio entre ellas.

    Ejemplo:
      "If man was meant to stay on the ground, god would have given us roots."
      → "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I.  NORMALIZACIÓN
        └── filter { it.isLetterOrDigit() } conserva solo letras y dígitos.
        └── .lowercase() convierte todo a minúsculas.
        └── Si el resultado está vacío, devolver "" inmediatamente.

    II. DIMENSIONES DEL RECTÁNGULO
        └── La raíz cuadrada de la longitud da el tamaño ideal.
        └── c = ceil(sqrt(n)) → redondea hacia arriba para que c >= r.
        └── r = ceil(n / c) → número de filas necesarias para cubrir n chars.
        └── Esto garantiza: r*c >= n, c >= r, c-r <= 1.

    III. DIVIDIR EN FILAS
         └── .chunked(c) parte el String en trozos de tamaño c.
         └── El último trozo puede tener menos de c caracteres.
         └── .map { it.padEnd(c) } rellena con espacios hasta c.

    IV.  LEER COLUMNAS
         └── Para cada columna i (0 hasta c-1):
             └── Para cada fila j:
                 └── Tomar el carácter en la posición i de la fila j.
             └── Concatenar esos caracteres → una columna completa.
         └── Almacenar cada columna en una lista.

    V.  FORMAR LA SALIDA
        └── .joinToString(" ") une las columnas separadas por un espacio.
        └── Cada columna tiene longitud r (por el padding con espacios).
        └── El resultado final son c fragmentos de longitud r.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ import kotlin.math.ceil                                                  │
    │ import kotlin.math.sqrt                                                  │
    │                                                                          │
    │ object CryptoSquare {                                                    │
    │     fun ciphertext(plaintext: String): String {                          │
    │         val normalizedText = plaintext                                   │
    │             .filter { it.isLetterOrDigit() }                             │
    │             .lowercase()                                                 │
    │         if (normalizedText.isEmpty()) return ""                          │
    │         val normalTextLength = normalizedText.length                     │
    │         val c = ceil(sqrt(normalTextLength.toDouble())).toInt()          │
    │         val r = ceil((normalTextLength / c).toDouble()).toInt()          │
    │         val chunked = normalizedText                                     │
    │             .chunked(c)                                                  │
    │             .map { it.padEnd(c) }                                        │
    │         val auxList = mutableListOf<String>()                            │
    │         for (i in 0 until c) {                                           │
    │             var column = ""                                              │
    │             for (j in chunked.indices) {                                 │
    │                 column += chunked[j][i]                                  │
    │             }                                                            │
    │             auxList.add(column)                                          │
    │         }                                                                │
    │         return auxList.joinToString(" ")                                 │
    │     }                                                                    │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   import
         └── Palabra reservada: "importar". Trae código de otros paquetes
             para usarlo sin escribir la ruta completa cada vez.
         └── import kotlin.math.ceil
             └── Trae la función ceil (techo: redondeo hacia arriba).
         └── import kotlin.math.sqrt
             └── Trae la función sqrt (raíz cuadrada).
         └── Analogía: pedir prestadas herramientas específicas de la
             biblioteca de matemáticas.

    II.  object CryptoSquare
         └── object: palabra reservada que declara un SINGLETON (una única
             instancia en todo el programa).
         └── CryptoSquare: nombre del objeto.
         └── Analogía: una máquina de cifrado única en la oficina — solo hay
             una, todos la usan.

    III. fun ciphertext(plaintext: String): String
         └── fun: palabra reservada para declarar una FUNCIÓN.
         └── ciphertext: nombre de la función ("texto cifrado").
         └── (plaintext: String): parámetro de entrada — el texto original.
             └── plaintext: nombre del parámetro ("texto plano").
             └── String: tipo de dato (cadena de texto).
         └── : String: tipo de retorno — la función devuelve un String.

    IV.  val normalizedText
         └── val: variable INMUTABLE (no se puede reasignar).
         └── normalizedText: nombre de la variable ("texto normalizado").
         └── Analogía: una hoja de papel donde escribes la versión limpia
             del mensaje — una vez escrita, no la cambias.

    V.   plaintext.filter { it.isLetterOrDigit() }
         └── .filter(): método que recorre cada carácter y conserva solo
             aquellos que cumplen la condición.
         └── { it.isLetterOrDigit() }: LAMBDA — función anónima.
             └── it: parámetro IMPLÍCITO de la lambda (cada carácter).
             └── .isLetterOrDigit(): método de Char — devuelve true si el
                 carácter es una letra (a-z, A-Z) o un dígito (0-9).
         └── Analogía: un filtro de café — solo deja pasar lo que queremos
             (letras y números), el resto se queda fuera.

    VI.  .lowercase()
         └── Método de String: convierte TODOS los caracteres a minúsculas.
         └── "Hello".lowercase() → "hello".
         └── Analogía: bajar el volumen de mayúsculas a minúsculas.

    VII. if (normalizedText.isEmpty()) return ""
         └── if: estructura condicional.
         └── normalizedText.isEmpty(): ¿la cadena está vacía?
             └── .isEmpty(): método que devuelve true si la cadena tiene
                 longitud 0.
         └── return "": si está vacía, devolvemos una cadena vacía (caso
             especial para evitar división por cero después).
         └── Analogía: "Si no hay mensaje, no hay cifrado."

    VIII. val normalTextLength = normalizedText.length
          └── .length: propiedad que devuelve la CANTIDAD de caracteres
              en el String.
          └── normalTextLength: almacena ese número (tipo Int).
          └── Analogía: contar las letras de un mensaje antes de cifrarlo.

    IX.  val c = ceil(sqrt(normalTextLength.toDouble())).toInt()
         └── sqrt(): función que calcula la RAÍZ CUADRADA.
             └── sqrt(54) ≈ 7.348
         └── normalTextLength.toDouble(): convierte Int a Double para que
             sqrt() funcione (sqrt requiere Double).
             └── .toDouble(): método que convierte el número a decimal.
         └── ceil(): función "TECHO" — redondea hacia ARRIBA.
             └── ceil(7.348) = 8.0
         └── .toInt(): convierte el Double resultante a Int.
             └── 8.0.toInt() = 8
         └── c = 8 → número de columnas.
         └── Analogía: medir cuántas columnas necesitas para que el
             rectángulo sea lo más cuadrado posible.

    X.   val r = ceil((normalTextLength / c).toDouble()).toInt()
         └── normalTextLength / c: división ENTERA (Int / Int = Int).
             └── 54 / 8 = 6 (en enteros)
         └── .toDouble(): convierte 6 a 6.0.
         └── ceil(6.0) = 6.0
         └── .toInt(): 6
         └── r = 6 → número de filas.
         └── Verificación: r * c = 6 * 8 = 48. ¿48 >= 54? ¡NO!
         └── Por eso se usa también ceil: ceil(54.0 / 8) = ceil(6.75) = 7
         └── Alternativa correcta: normalTextLength / c.toDouble()
             └── 54 / 8.0 = 6.75
             └── ceil(6.75) = 7.0
             └── .toInt() = 7
         └── r = 7 filas. 7 * 8 = 56 >= 54 ✓

    XI.  val chunked = normalizedText.chunked(c).map { it.padEnd(c) }
         └── .chunked(c): método que DIVIDE el String en trozos de tamaño c.
             └── "ifmanwasmeanttos...".chunked(8)
             └── → ["ifmanwas", "meanttos", "tayonthe", "groundgo",
                      "dwouldha", "vegivenu", "sroots"]
             └── Último trozo: "sroots" (6 chars, no 8).
         └── .map { it.padEnd(c) }: TRANSFORMA cada trozo.
             └── .map(): aplica una función a cada elemento de la lista.
             └── it: cada trozo (String).
             └── .padEnd(c): rellena con espacios al final hasta alcanzar
                 longitud c.
                 └── "sroots".padEnd(8) → "sroots  "
         └── Resultado: lista de Strings, todos de longitud c.
         └── Analogía: cortar una tira de texto en pedazos de igual tamaño
             y rellenar el último con espacios para que todos midan igual.

    XII. val auxList = mutableListOf<String>()
         └── val: variable inmutable (la referencia no cambia).
         └── auxList: nombre ("lista auxiliar").
         └── mutableListOf<String>(): función que crea una LISTA MUTABLE
             vacía que almacenará Strings.
         └── Analogía: una bandeja vacía donde iremos poniendo las columnas
             una por una.

    XIII. for (i in 0 until c)
          └── for: bucle "para cada".
          └── i in 0 until c: la variable i toma valores 0, 1, 2, ..., c-1.
              └── until: "hasta pero sin incluir" — 0 until 8 → 0..7.
          └── Cada iteración representa una COLUMNA.
          └── Analogía: "Para cada columna de la 0 a la 7..."

    XIV. var column = ""
         └── var: variable MUTABLE (se puede reasignar).
         └── column: nombre ("columna").
         └── = "": se inicializa como cadena vacía.
         └── En cada iteración del for exterior, se CREA UNA NUEVA variable
             column vacía para empezar a construir la columna i.
         └── Analogía: coger una hoja nueva en blanco para cada columna.

    XV.  for (j in chunked.indices)
         └── Segundo bucle ANIDADO (dentro del primero).
         └── chunked.indices: propiedad que devuelve el RANGO de índices
             válidos de la lista (0, 1, 2, ..., chunked.size - 1).
             └── Equivalente a: 0 until chunked.size
         └── j representa el índice de cada FILA (cada trozo).
         └── Analogía: "Para cada fila (trozo) en la lista..."

    XVI. column += chunked[j][i]
         └── +=: operador de ASIGNACIÓN CON CONCATENACIÓN.
             └── column += "a" equivale a column = column + "a".
         └── chunked[j]: accede al j-ésimo trozo (String).
         └── [i]: accede al i-ésimo CARACTER de ese String.
             └── chunked[0][0] = 'i' (primera fila, primera columna)
             └── chunked[1][0] = 'm' (segunda fila, primera columna)
         └── Al iterar j de 0 a chunked.size-1, se toman los caracteres
             de la columna i de todas las filas, UNO POR UNO.
         └── Analogía: leer hacia abajo en una columna de una tabla.

    XVII. auxList.add(column)
          └── .add(): método de MutableList que AGREGA un elemento al final
              de la lista.
          └── column: el String completo de la columna i.
          └── Después de 8 iteraciones, auxList contiene:
              ["imtgdvs", "fearwer", "mayoogo", ..., "sseoau "]

    XVIII. return auxList.joinToString(" ")
           └── return: devuelve el resultado y termina la función.
           └── auxList.joinToString(" "): CONCATENA todos los Strings de la
               lista usando " " (un espacio) como separador.
               └── "imtgdvs" + " " + "fearwer" + " " + "mayoogo" + ...
           └── Resultado final: "imtgdvs fearwer mayoogo ... sseoau "

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO CryptoSquare:

        FUNCION ciphertext(textoPlano):
            ENTRADA: textoPlano (String)
            SALIDA: String (texto cifrado)

            // 1. Normalizar
            textoNormal = textoPlano.FILTRAR(caracter → esLetraODigito).MINUSCULAS()

            // 2. Si no hay texto, devolver vacío
            SI textoNormal.ESTA_VACIO():
                DEVOLVER ""

            // 3. Calcular dimensiones
            longitud = textoNormal.LONGITUD
            columnas = TECHO(RAIZ(longitud))
            filas = TECHO(longitud / columnas)

            // 4. Dividir en filas y rellenar con espacios
            filasLista = textoNormal.DIVIDIR(columnas)
            PARA CADA fila EN filasLista:
                fila = fila.RELLENAR(columnas, ' ')

            // 5. Leer columnas
            columnasLista = LISTA_VACIA()
            PARA i DESDE 0 HASTA columnas - 1:
                columna = ""
                PARA j DESDE 0 HASTA filasLista.LONGITUD - 1:
                    columna = columna + filasLista[j][i]
                columnasLista.AGREGAR(columna)

            // 6. Unir con espacios
            DEVOLVER columnasLista.UNIR(" ")

    ──────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL (implícito en el objeto):
        1. cryptoSquare.ciphertext("texto") → "texto cifrado"

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Mensaje vacío

        Entrada: plaintext = ""
        Proceso:
            normalizedText = "".filter { ... }.lowercase() = ""
            "" está vacío → return ""
        Resultado: ""
        └── Caso borde: texto vacío produce cifrado vacío.

    ──────────────────────────────────────────────────────────────────────────

    EJEMPLO 2: ciphertext("If man was meant to stay on the ground,
                          god would have given us roots.")

        Entrada: plaintext = "If man was meant to stay on the ground,
                              god would have given us roots."

        Paso 1 — NORMALIZAR:
            filter { isLetterOrDigit() }:
                "Ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"
            lowercase():
                "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"
            normalizedText = "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"

        Paso 2 — DIMENSIONES:
            normalTextLength = 54
            c = ceil(sqrt(54.0)) = ceil(7.348) = 8
            r = ceil(54 / 8.0) = ceil(6.75) = 7
            └── rectángulo de 7 filas × 8 columnas = 56 espacios (54 chars + 2 de padding)

        Paso 3 — DIVIDIR EN FILAS:
            chunked(8): ["ifmanwas", "meanttos", "tayonthe", "groundgo",
                         "dwouldha", "vegivenu", "sroots"]
            map(padEnd(8)):
                ["ifmanwas", "meanttos", "tayonthe", "groundgo",
                 "dwouldha", "vegivenu", "sroots  "]

        Paso 4 — LEER COLUMNAS:
            i=0: chunked[0][0]='i', [1][0]='m', [2][0]='t', [3][0]='g',
                 [4][0]='d', [5][0]='v', [6][0]='s' → "imtgdvs"
            i=1: chunked[0][1]='f', [1][1]='e', [2][1]='a', [3][1]='r',
                 [4][1]='w', [5][1]='e', [6][1]='r' → "fearwer"
            i=2: → "mayoogo"
            i=3: → "anouuio"
            i=4: → "ntnnlvt"
            i=5: → "wttddes"
            i=6: → "aohghn "
            i=7: → "sseoau "

            auxList = ["imtgdvs", "fearwer", "mayoogo", "anouuio",
                       "ntnnlvt", "wttddes", "aohghn ", "sseoau "]

        Paso 5 — UNIR CON ESPACIOS:
            "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "

        Resultado: "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau "
        └── 8 fragmentos de 7 caracteres cada uno, separados por espacios.
        └── Los dos últimos fragmentos tienen un espacio al final (padding).

    ──────────────────────────────────────────────────────────────────────────

    EJEMPLO 3: ciphertext("123456789") — texto corto (solo dígitos)

        Entrada: plaintext = "123456789"

        Paso 1:
            normalizedText = "123456789" (sin cambios)
            longitud = 9

        Paso 2:
            c = ceil(sqrt(9.0)) = ceil(3.0) = 3
            r = ceil(9 / 3.0) = ceil(3.0) = 3
            └── rectángulo perfecto de 3×3

        Paso 3:
            chunked(3): ["123", "456", "789"]
            map(padEnd(3)): ["123", "456", "789"] (todos ya tienen 3)

        Paso 4:
            i=0: "1"+"4"+"7" = "147"
            i=1: "2"+"5"+"8" = "258"
            i=2: "3"+"6"+"9" = "369"
            auxList = ["147", "258", "369"]

        Paso 5:
            "147 258 369"

        Resultado: "147 258 369"
        └── Como el cuadrado es perfecto, no hay padding.

    ──────────────────────────────────────────────────────────────────────────

    EJEMPLO 4: ciphertext("a@b!c.") — solo 3 letras útiles

        Entrada: plaintext = "a@b!c."

        Paso 1:
            filter { isLetterOrDigit() }: "abc"
            lowercase(): "abc"
            normalizedText = "abc"
            longitud = 3

        Paso 2:
            c = ceil(sqrt(3.0)) = ceil(1.732) = 2
            r = ceil(3 / 2.0) = ceil(1.5) = 2
            └── rectángulo 2×2 = 4 espacios (3 chars + 1 de padding)

        Paso 3:
            chunked(2): ["ab", "c"]
            map(padEnd(2)): ["ab", "c "]

        Paso 4:
            i=0: "a"+"c" = "ac"
            i=1: "b"+" " = "b "
            auxList = ["ac", "b "]

        Paso 5:
            "ac b "

        Resultado: "ac b "
        └── 2 fragmentos de 2 caracteres. El segundo fragmento tiene
            un espacio al final (padding para completar la columna).

    ──────────────────────────────────────────────────────────────────────────

    EJEMPLO 5: ciphertext("¡Hola, mundo!") — con caracteres especiales

        Entrada: plaintext = "¡Hola, mundo!"

        Paso 1:
            filter { isLetterOrDigit() }: "Holamundo"
            lowercase(): "holamundo"
            normalizedText = "holamundo"
            longitud = 9

        Paso 2:
            c = ceil(sqrt(9)) = 3
            r = ceil(9 / 3) = 3
            └── rectángulo perfecto 3×3

        Paso 3:
            chunked(3): ["hol", "amu", "ndo"]

        Paso 4:
            i=0: "h"+"a"+"n" = "han"
            i=1: "o"+"m"+"d" = "omd"
            i=2: "l"+"u"+"o" = "luo"
            auxList = ["han", "omd", "luo"]

        Paso 5:
            "han omd luo"

        Resultado: "han omd luo"
        └── La ñ y los signos ¡! se filtran; el espacio también.
*/
