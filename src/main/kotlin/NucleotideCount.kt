@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 *
 * Each of us inherits from our biological parents a set of chemical instructions
 * known as DNA that influence how our bodies are constructed. All known life
 * depends on DNA!
 *
 *   Note: You do not need to understand anything about nucleotides or DNA to
 *   complete this exercise.
 *
 * DNA is a long chain of other chemicals and the most important are the four
 * nucleotides, adenine, cytosine, guanine and thymine. A single DNA chain can
 * contain billions of these four nucleotides and the order in which they occur
 * is important! We call the order of these nucleotides in a bit of DNA a "DNA
 * sequence".
 *
 * We represent a DNA sequence as an ordered collection of these four nucleotides
 * and a common way to do that is with a string of characters such as "ATTACG"
 * for a DNA sequence of 6 nucleotides. 'A' for adenine, 'C' for cytosine, 'G'
 * for guanine, and 'T' for thymine.
 *
 * Given a string representing a DNA sequence, count how many of each nucleotide
 * is present. If the string contains characters that aren't A, C, G, or T then
 * it is invalid and you should signal an error.
 *
 * For example:
 *
 *   "GATTACA" -> 'A': 3, 'C': 1, 'G': 1, 'T': 2
 *   "INVALID" -> error
 */

class Dna(val input: String) {

    init {
        input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
            .forEach { throw IllegalArgumentException("Invalid nucleotide: $it") }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            return mapOf(
                'A' to input.count { it == 'A' },
                'C' to input.count { it == 'C' },
                'G' to input.count { it == 'G' },
                'T' to input.count { it == 'T' }
            )
        }
}

fun main() {
    println("Enter a DNA sequence:")
    val input = readln()

    try {
        val dna = Dna(input)
        println(dna.nucleotideCounts)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Se pide contar cuántas veces aparece cada nucleótido (A, C, G, T) en una
    secuencia de ADN representada como String. Si la cadena contiene caracteres
    que no sean A, C, G o T, debe señalarse un error.

    OBJETIVOS:
    I.   Crear una clase Dna que reciba la secuencia en su constructor.
    II.  Validar en el init que todos los caracteres sean A, C, G o T.
         Si hay alguno inválido, lanzar IllegalArgumentException.
    III. Proveer una propiedad nucleotideCounts que devuelva un Map<Char, Int>
         con la cuenta de cada nucleótido.
    IV.  En main: leer una secuencia del usuario, crear Dna, e imprimir el mapa.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    Para resolver el problema se siguen estas etapas:

    I. DISENO DE LA CLASE
       └── Crear la clase Dna con un constructor que reciba input: String.
       └── Usar val para que input sea de solo lectura (inmutable).

    II. VALIDACION DE LA ENTRADA (init)
        a) Usar filter para CONSERVAR solo los caracteres que NO sean
           A, C, G ni T.
        b) Si filter devuelve algo (lista no vacía), usar forEach para
           lanzar una excepción por cada carácter inválido.
        c) Si filter devuelve lista vacía → todo es válido.

    III. PROPIEDAD DE CONTEOS
         a) Declarar val nucleotideCounts de tipo Map<Char, Int>.
         b) Definir un getter personalizado (get()).
         c) Usar mapOf para construir el diccionario.
         d) Para cada nucleótido, usar input.count { it == 'X' }.
         e) count recorre el String y cuenta cuántos caracteres cumplen
            la condición.

    IV. INTERACCION CON USUARIO (main)
        └── Leer la secuencia, crear Dna, imprimir el mapa.
        └── try/catch para manejar la excepción de caracteres inválidos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ @file:Suppress("SpellCheckingInspection")                                │
    │                                                                          │
    │ class Dna(val input: String) {                                           │
    │                                                                          │
    │     init {                                                               │
    │         input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }│
    │             .forEach { throw IllegalArgumentException("Invalid nucleoti- │
    │                         de: $it") }                                      │
    │     }                                                                    │
    │                                                                          │
    │     val nucleotideCounts: Map<Char, Int>                                 │
    │         get() {                                                          │
    │             return mapOf(                                                │
    │                 'A' to input.count { it == 'A' },                        │
    │                 'C' to input.count { it == 'C' },                        │
    │                 'G' to input.count { it == 'G' },                        │
    │                 'T' to input.count { it == 'T' }                         │
    │             )                                                            │
    │         }                                                                │
    │ }                                                                        │
    │                                                                          │
    │ fun main() {                                                             │
    │     println("Enter a DNA sequence:")                                     │
    │     val input = readln()                                                 │
    │                                                                          │
    │     try {                                                                │
    │         val dna = Dna(input)                                             │
    │         println(dna.nucleotideCounts)                                    │
    │     } catch (e: IllegalArgumentException) {                              │
    │         println("Error: ${e.message}")                                   │
    │     }                                                                    │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   @file:Suppress("SpellCheckingInspection")
         └── Anotación a nivel de archivo que suprime advertencias de ortografía.
         └── Opcional; solo evita warnings en el IDE.

    II.  class
         └── Palabra reservada que define una "clase" (molde/plantilla).
         └── Crea un nuevo tipo de dato con propiedades y métodos.
         └── Analogía: un molde para hacer galletas — defines la forma una vez
             y puedes crear muchas galletas (objetos).

    III. Dna
         └── Nombre de la clase elegido por el programador.
         └── Por convención en Kotlin, comienza con mayúscula.

    IV.  (val input: String)
        └── Parámetro del constructor primario.
        └── val: el parámetro se convierte en propiedad de solo lectura.
        └── input: nombre del parámetro.
        └── : String — tipo de dato: cadena de texto.
        └── Analogía: la materia prima que se le da al objeto al crearlo.

    V.   { } (llaves de la clase)
         └── Delimitan el cuerpo de la clase.
         └── Todo lo que está entre ellas pertenece a la clase.

    VI.  init
         └── Bloque de inicialización.
         └── Se ejecuta automáticamente cuando se crea una instancia:
             new Dna("GATTACA").
         └── Es el momento ideal para validar los datos de entrada.

    VII. input.filter { ... }
         └── .filter { } — función que recorre el String y CONSERVA solo los
             caracteres que hacen verdadera la condición entre llaves.
         └── La condición es: it != 'A' && it != 'C' && it != 'G' && it != 'T'.
         └── O sea, conserva los caracteres que NO son nucleótidos válidos.

    VIII. it
          └── Parámetro implícito en una lambda de un solo argumento.
          └── Representa "el elemento actual que se está evaluando".
          └── Aquí: cada carácter del String input, uno por uno.

    IX.  !=
         └── Operador de comparación: "diferente de".
         └── true si los dos valores NO son iguales.
         └── 'A' != 'A' → false;  'X' != 'A' → true.

    X.   &&
         └── Operador lógico "AND" (Y).
         └── Devuelve true solo si AMBAS condiciones son verdaderas.
         └── Tabla: true && true = true; cualquier otra combinación = false.
         └── Analogía: "quiero pizza Y quiero hamburguesa" — solo se cumple
             si quieres ambas.

    XI.  'A', 'C', 'G', 'T'
         └── Literales de carácter (tipo Char).
         └── Las comillas simples indican un solo carácter.

    XII. .forEach { ... }
         └── Función que ejecuta el bloque { } para CADA elemento de la
             colección.
         └── Aquí: para cada carácter inválido (los que pasaron el filter),
             lanza una excepción.
         └── Si hay varios inválidos, el primer throw detiene la ejecución.

    XIII. throw
          └── Palabra reservada: "lanzar".
          └── Detiene la ejecución normal y lanza una excepción.

    XIV. IllegalArgumentException("Invalid nucleotide: $it")
         └── IllegalArgumentException: tipo de excepción.
         └── "Invalid nucleotide: $it": mensaje de error con interpolación.
         └── $it: el carácter inválido se inserta en el texto.

    XV.  val nucleotideCounts: Map<Char, Int>
         └── Declaración de propiedad de solo lectura (val).
         └── nucleotideCounts: nombre de la propiedad (conteos de nucleótidos).
         └── Map<Char, Int>: tipo de dato — diccionario que asocia
             caracteres (Char) con números enteros (Int).
         └── Ejemplo: {A=3, C=1, G=1, T=2}

    XVI. get()
         └── Definición de un getter personalizado.
         └── Cuando alguien accede a .nucleotideCounts, se ejecuta este bloque.
         └── Permite calcular el valor en el momento (no está almacenado).

    XVII. return
          └── Palabra reservada que devuelve un valor desde la función/getter.

    XVIII. mapOf(...)
           └── Función de biblioteca que construye un Map (diccionario).
           └── Recibe pares clave → valor separados por comas.
           └── Analogía: un diccionario de palabras — buscas por clave (A)
               y obtienes su valor (3).

    XIX. 'A' to input.count { it == 'A' }
         └── 'A': clave del mapa (el nucleótido).
         └── to: operador de asociación que crea un par (clave, valor).
         └── input.count { it == 'A' }: cuenta cuántas 'A' hay en input.
         └── it == 'A': condición que verifica si el carácter actual es 'A'.
         └── count { } recorre todo el String y cuenta las coincidencias.

    XX.  'C' to input.count { it == 'C' }
         └── Misma estructura para la citosina (C).

    XXI. 'G' to input.count { it == 'G' }
         └── Misma estructura para la guanina (G).

    XXII. 'T' to input.count { it == 'T' }
          └── Misma estructura para la timina (T).

    XXIII. fun main()
           └── Función principal: punto de entrada del programa.

    XXIV. println(...)
          └── Función que imprime texto en consola.

    XXV. val input = readln()
         └── val: variable inmutable.
         └── readln(): lee una línea desde la consola.

    XXVI. try { ... } catch (e: IllegalArgumentException) { ... }
          └── try: bloque que envuelve código que puede lanzar excepción.
          └── catch: captura la excepción si ocurre.
          └── e: variable con la excepción atrapada.
          └── ${e.message}: interpolación del mensaje de error.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE Dna
        ENTRADA: secuencia (Texto) — se guarda como propiedad de solo lectura.

        AL CREAR (init):
            PARA CADA caracter c EN secuencia:
                SI c NO es 'A' Y c NO es 'C' Y c NO es 'G' Y c NO es 'T':
                    LANZAR Error("Nucleotido invalido: " + c)

        PROPIEDAD conteos: Mapa(Caracter → Entero)
            OBTENER:
                DEVOLVER mapaDe(
                    'A' → contar A en secuencia,
                    'C' → contar C en secuencia,
                    'G' → contar G en secuencia,
                    'T' → contar T en secuencia
                )

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. IMPRIMIR "Enter a DNA sequence:"
        2. LEER entrada DESDE consola
        3. INTENTAR:
            3a. adn = NUEVO Dna(entrada)
            3b. IMPRIMIR adn.conteos
           CAPTURAR Error:
            3c. IMPRIMIR "Error: " + mensajeDelError

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: "GATTACA" — secuencia válida de 7 nucleótidos

        Entrada: "GATTACA"
        Proceso:
          PASO 1 — Validación (init):
            filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
            G → G!=A? SI, G!=C? SI, G!=G? NO  → descartado
            A → A!=A? NO                       → descartado
            T → T!=T? NO                       → descartado
            T → T!=T? NO                       → descartado
            A → A!=A? NO                       → descartado
            C → C!=C? NO                       → descartado
            A → A!=A? NO                       → descartado
            Resultado: [] lista vacía → válido ✓

          PASO 2 — Conteo:
            A → count(it=='A') → 3  (posiciones 2, 5, 7)
            C → count(it=='C') → 1  (posición 6)
            G → count(it=='G') → 1  (posición 1)
            T → count(it=='T') → 2  (posiciones 3, 4)
        Salida: {A=3, C=1, G=1, T=2}
        └── Coincide con el ejemplo del enunciado.

    EJEMPLO 2: "ACGT" — un nucleótido de cada tipo

        Entrada: "ACGT"
        Proceso:
          Validación: filter → [] (todos válidos) ✓
          Conteo:
            A → count(it=='A') → 1
            C → count(it=='C') → 1
            G → count(it=='G') → 1
            T → count(it=='T') → 1
        Salida: {A=1, C=1, G=1, T=1}
        └── Exactamente uno de cada nucleótido.

    EJEMPLO 3: "ACXT" — nucleótido inválido (X)

        Entrada: "ACXT"
        Proceso:
          PASO 1 — Validación (init):
            filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
            A → A!=A? NO              → descartado
            C → C!=C? NO              → descartado
            X → X!=A? SI, X!=C? SI, X!=G? SI, X!=T? SI → CONSERVADO
            T → T!=T? NO              → descartado
            Resultado: ['X']
            forEach: throw IllegalArgumentException("Invalid nucleotide: X")
        Salida: El programa lanza excepción y entra al catch.
        └── Se imprime: "Error: Invalid nucleotide: X"
*/
