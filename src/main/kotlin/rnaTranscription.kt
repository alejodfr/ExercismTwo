@file:Suppress("SpellCheckingInspection")


/**
 * Introduction
 *
 * You work for a bioengineering company that specializes in developing therapeutic solutions.
 * Your team has just been given a new project to develop a targeted therapy for a rare type of cancer.
 *
 * Note: It's all very complicated, but the basic idea is that sometimes people's bodies produce too much
 * of a given protein. That can cause all sorts of havoc.
 * But if you can create a very specific molecule (called a micro-RNA), it can prevent the protein from
 * being produced.
 * This technique is called RNA Interference.
 *
 * Instructions
 *
 * Your task is to determine the RNA complement of a given DNA sequence.
 * Both DNA and RNA strands are a sequence of nucleotides.
 * The four nucleotides found in DNA are adenine (A), cytosine (C), guanine (G), and thymine (T).
 * The four nucleotides found in RNA are adenine (A), cytosine (C), guanine (G), and uracil (U).
 * Given a DNA strand, its transcribed RNA strand is formed by replacing each nucleotide with its complement:
 *
 *     G -> C
 *     C -> G
 *     T -> A
 *     A -> U
 *
 * Note: If you want to look at how the inputs and outputs are structured, take a look at the examples
 * in the test suite.
 */


fun transcribeToRna(dna: String): String{
    return dna.toList().map { when(it){
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        else -> throw IllegalArgumentException("Invalid nucleotide: $it")
    } }.joinToString("")
}

fun main() {
    println("Enter a DNA sequence:")
    val dna = readln()

    try {
        val result = transcribeToRna(dna)
        println("RNA complement: $result")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Se pide determinar el complemento de ARN a partir de una secuencia de ADN.
    Las reglas de transcripción son: G→C, C→G, T→A, A→U.

    OBJETIVOS:
    I.   Recibir una cadena de ADN como String.
    II.  Reemplazar cada nucleótido según su complemento:
         G → C,  C → G,  T → A,  A → U.
    III. Si la cadena contiene un carácter que no sea A, C, G o T,
         lanzar una excepción IllegalArgumentException.
    IV.  Devolver la cadena de ARN resultante.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    Para resolver el problema se siguen estas etapas:

    I. ANALISIS DE LA ENTRADA
       └── Recibir un String de ADN (ej: "GCTA").
       └── Verificar que el programa pueda leerlo desde consola (readln).

    II. TRANSFORMACION NUCLEOTIDO POR NUCLEOTIDO
        a) Convertir el String a una lista de caracteres (toList).
        b) Usar map para transformar CADA carácter:
           └── 'G' → 'C'
           └── 'C' → 'G'
           └── 'T' → 'A'
           └── 'A' → 'U'
           └── cualquier otro → lanzar error.

    III. CONSTRUCCION DEL RESULTADO
         └── Unir la lista transformada en un String con joinToString("").

    IV. INTERACCION CON USUARIO
        └── main: pedir ADN, llamar transcribeToRna, mostrar resultado.
        └── try/catch para capturar errores de nucleótidos inválidos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ @file:Suppress("SpellCheckingInspection")                                │
    │                                                                          │
    │ fun transcribeToRna(dna: String): String{                                │
    │     return dna.toList().map { when(it){                                  │
    │         'G' -> 'C'                                                       │
    │         'C' -> 'G'                                                       │
    │         'T' -> 'A'                                                       │
    │         'A' -> 'U'                                                       │
    │         else -> throw IllegalArgumentException("Invalid nucleotide: $it")│
    │     } }.joinToString("")                                                 │
    │ }                                                                        │
    │                                                                          │
    │ fun main() {                                                             │
    │     println("Enter a DNA sequence:")                                     │
    │     val dna = readln()                                                   │
    │                                                                          │
    │     try {                                                                │
    │         val result = transcribeToRna(dna)                                │
    │         println("RNA complement: $result")                               │
    │     } catch (e: IllegalArgumentException) {                              │
    │         println("Error: ${e.message}")                                   │
    │     }                                                                    │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   @file:Suppress("SpellCheckingInspection")
         └── Anotación a nivel de archivo.
         └── Le dice al compilador que NO muestre advertencias de ortografía.
         └── Es opcional; solo evita warnings en el IDE.

    II.  fun
         └── Palabra reservada que declara una función (bloque de código reutilizable).
         └── Analogía: una receta de cocina — describes los pasos una vez
             y los ejecutas cada vez que necesitas ese plato.

    III. transcribeToRna
         └── Nombre de la función elegido por el programador.
         └── Significa "transcribir a ARN".

    IV.  dna: String
         └── Parámetro de entrada de la función.
         └── dna: nombre del parámetro que contiene la secuencia de ADN.
         └── ": String" — declara el tipo de dato: cadena de texto.
         └── Analogía: la materia prima que le das a la máquina.

    V.   : String (después de los paréntesis)
         └── Tipo de retorno: indica que la función devuelve un String.
         └── Es el tipo de dato del resultado final (la cadena de ARN).

    VI.  { (llave de apertura después de ": String")
         └── Inicia el bloque de código de la función.
         └── Todo lo que está entre { } pertenece a la función.

    VII. return
         └── Palabra reservada: "devolver".
         └── Finaliza la ejecución de la función y entrega el valor calculado.
         └── Analogía: entregar el plato cocinado al cliente.

    VIII. dna.toList()
          └── .toList() — método que convierte el String en una lista de Chars.
          └── "GCTA".toList() → ['G', 'C', 'T', 'A']
          └── . (punto): operador de acceso a métodos y propiedades.

    IX.  .map { ... }
         └── Función de orden superior de las colecciones en Kotlin.
         └── Transforma CADA elemento de la lista aplicando el bloque { }.
         └── El bloque recibe un elemento y devuelve su transformación.
         └── Analogía: una máquina donde entran letras y salen letras cambiadas.

    X.   it
         └── Parámetro implícito en una lambda de un solo argumento.
         └── Representa "el elemento actual que se está procesando".
         └── En este caso: cada carácter de la lista por turno.
         └── Analogía: la cinta transportadora que trae una pieza a la vez.

    XI.  when(it) { ... }
         └── Estructura de control condicional múltiple.
         └── Similar a switch en otros lenguajes como Java o C.
         └── Evalúa el valor de it contra múltiples casos posibles.
         └── Analogía: un clasificador de correo — según la letra, va a un
             casillero distinto.

    XII. 'G' -> 'C'
         └── 'G': literal de carácter (tipo Char). Las comillas simples
             indican un solo carácter.
         └── -> (flecha): separador que conecta "caso" con "resultado".
         └── Significa: "si it es 'G', entonces devuelve 'C'".

    XIII. 'C' -> 'G'
          └── Misma estructura: si it es 'C', devuelve 'G'.

    XIV. 'T' -> 'A'
         └── Si it es 'T', devuelve 'A'.

    XV.  'A' -> 'U'
         └── Si it es 'A', devuelve 'U'.

    XVI. else
         └── Rama por defecto del when (obligatoria en when de expresión).
         └── Se ejecuta si ningún caso anterior coincidió.
         └── Analogía: el cajón de "varios" donde va todo lo que no clasificó.

    XVII. throw
          └── Palabra reservada: "lanzar".
          └── Interrumpe la ejecución normal del programa y lanza una excepción.
          └── Analogía: tirar una alarma de incendios — todo se detiene
              y se activa el protocolo de emergencia.

    XVIII. IllegalArgumentException(...)
           └── Tipo de excepción: "excepción de argumento ilegal".
           └── Indica que se recibió un valor inválido como argumento.
           └── "(...)" contiene el mensaje descriptivo del error.

    XIX. "Invalid nucleotide: $it"
         └── String con interpolación de variables.
         └── $it: el carácter it se inserta dentro del texto.
         └── "$" — carácter especial que inicia la interpolación.
         └── Ej: si it = 'X', el mensaje resultante es
             "Invalid nucleotide: X".

    XX.  }.joinToString("")
         └── }  — cierra el bloque de map.
         └── .joinToString("") — método que une los elementos de la lista
             en un único String.
         └── "" — argumento que indica separador vacío (sin separador
             entre caracteres).
         └── ['C','G','A','U'].joinToString("") → "CGAU".

    XXI. } (cierre de transcribeToRna)
         └── Llave de cierre que termina el bloque de la función.

    XXII. fun main()
          └── Segunda función del archivo.
          └── main: nombre especial — punto de entrada del programa.
          └── Kotlin busca y ejecuta la función main() automáticamente
              al iniciar el programa.
          └── Analogía: la puerta principal de una casa — todo empieza ahí.

    XXIII. println(...)
           └── Función de la biblioteca estándar: "print line".
           └── Imprime texto en la consola y añade un salto de línea al final.
           └── Automáticamente llama a toString() del objeto recibido.

    XXIV. val
          └── Palabra reservada para declarar variable de solo lectura
              (inmutable / constante).
          └── Una vez asignada, no se puede reasignar.
          └── Viene de "value" (valor).
          └── Analogía: un marcador escrito con tinta indeleble.

    XXV. readln()
         └── Función de biblioteca estándar: "read line".
         └── Lee una línea completa desde la consola (lo que el usuario
             escribe y presiona Enter).
         └── Devuelve un String.

    XXVI. try { ... } catch (e: IllegalArgumentException) { ... }
          └── try: bloque que envuelve código que podría fallar.
          └── catch: bloque que captura la excepción SI ocurre.
          └── e: nombre de la variable que contiene la excepción atrapada.
          └── e.message: propiedad que contiene el texto descriptivo del error.
          └── ${e.message}: interpolación del mensaje dentro del String.

    XXVII. "Error: ${e.message}"
           └── Otro ejemplo de interpolación de Strings.
           └── ${expresión} — sintaxis para interpolar una expresión más
               compleja (con punto, paréntesis, etc.).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    FUNCION transcribirAArn(adn: Texto): Texto
        listaCaracteres = adn.convertirALista()
        transformados = listaCaracteres.mapear(cada caracter c):
            SEGUN c:
                CASO 'G':  TOMAR 'C'
                CASO 'C':  TOMAR 'G'
                CASO 'T':  TOMAR 'A'
                CASO 'A':  TOMAR 'U'
                OTRO CASO: LANZAR Error("Nucleotido invalido: " + c)
        DEVOLVER transformados.unirEnTexto("")

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. IMPRIMIR "Enter a DNA sequence:"
        2. LEER adn DESDE consola
        3. INTENTAR:
            3a. resultado = transcribirAArn(adn)
            3b. IMPRIMIR "RNA complement: " + resultado
           CAPTURAR Error:
            3c. IMPRIMIR "Error: " + mensajeDelError

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: "GCTA" — secuencia normal de 4 nucleótidos

        Entrada: "GCTA"
        Proceso:
          toList()            → ['G', 'C', 'T', 'A']
          map(when):
            'G' → 'C'
            'C' → 'G'
            'T' → 'A'
            'A' → 'U'
          Resultado intermedio: ['C', 'G', 'A', 'U']
          joinToString("")    → "CGAU"
        Salida: "CGAU"
        └── Cada nucleótido fue reemplazado correctamente.

    EJEMPLO 2: "AAA" — nucleótido repetido tres veces

        Entrada: "AAA"
        Proceso:
          toList()            → ['A', 'A', 'A']
          map(when):
            'A' → 'U'   (tres veces)
          Resultado intermedio: ['U', 'U', 'U']
          joinToString("")    → "UUU"
        Salida: "UUU"
        └── Todas las adeninas (A) se convierten en uracilos (U).

    EJEMPLO 3: "GCTX" — nucleótido inválido (X)

        Entrada: "GCTX"
        Proceso:
          toList()            → ['G', 'C', 'T', 'X']
          map(when):
            'G' → 'C'
            'C' → 'G'
            'T' → 'A'
            'X' → else → throw IllegalArgumentException
        Salida: El programa lanza una excepción y entra al bloque catch.
        └── Se imprime: "Error: Invalid nucleotide: X"
        └── X no es A, C, G ni T, por lo tanto se rechaza.
*/
