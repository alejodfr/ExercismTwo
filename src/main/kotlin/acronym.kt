@file:Suppress("SpellCheckingInspection")
/**
 * Instructions
 *
 * Convert a phrase to its acronym.
 *
 * Techies love their TLA (Three Letter Acronyms)!
 *
 * Help generate some jargon by writing a program that converts a long name
 * like Portable Network Graphics to its acronym (PNG).
 *
 * Punctuation is handled as follows: hyphens are word separators (like
 * whitespace); all other punctuation can be removed from the input.
 *
 * For example:
 *
 *   Input                          Output
 *   As Soon As Possible            ASAP
 *   Liquid-crystal display         LCD
 *   Thank George It's Friday!      TGIF
 */

object Acronym {
    fun generate(phrase: String) : String {

        val auxList = mutableListOf<String>()
        val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
        for (i in list){
            auxList.add(i.first().uppercaseChar().toString())
        }
        return auxList.joinToString("")
    }
}

fun main() {
    // Caso 1 — palabras separadas por espacios
    println(Acronym.generate("As Soon As Possible"))       // ASAP

    // Caso 2 — palabras separadas por guiones
    println(Acronym.generate("Liquid-crystal display"))    // LCD

    // Caso 3 — puntuación al final de palabra
    println(Acronym.generate("Thank George It's Friday!")) // TGIF

    // Caso 4 — guiones bajos como énfasis
    println(Acronym.generate("The Road _Not_ Taken"))      // TRNT

    // Caso 5 — separadores consecutivos
    println(Acronym.generate("Something - Interesting"))   // SI

    // Caso 6 — todo en minúsculas
    println(Acronym.generate("portable network graphics")) // PNG
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Convertir una frase en su acrónimo (sigla).

    OBJETIVOS:
    I.   Tomar la primera letra de cada palabra.
    II.  Los guiones (-) y guiones bajos (_) se tratan como separadores
         de palabras (igual que los espacios).
    III. Ignorar cualquier otro signo de puntuación.
    IV.  Convertir todas las iniciales a MAYÚSCULAS.
    V.   Devolver las iniciales concatenadas sin separadores.

    Ejemplos:
      "As Soon As Possible"          → "ASAP"
      "Liquid-crystal display"       → "LCD"
      "Thank George It's Friday!"    → "TGIF"

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I.  SEPARAR LA FRASE EN PALABRAS
        └── Usar split() con múltiples separadores: espacio (" "),
            guión ("-") y guión bajo ("_").
        └── split devuelve una lista de subcadenas.

    II.  ELIMINAR CADENAS VACÍAS
         └── Si hay separadores consecutivos (ej: "a  b"), split genera
             cadenas vacías que deben filtrarse.
         └── .filter { it.isNotEmpty() } elimina las cadenas vacías.
         └── Es necesario porque llamar .first() a una cadena vacía
             lanzaría una excepción.

    III. EXTRAER LA PRIMERA LETRA DE CADA PALABRA
         └── for (i in list): recorre cada palabra.
         └── i.first(): obtiene el primer carácter de la palabra.
         └── .uppercaseChar(): lo convierte a mayúscula.
         └── .toString(): convierte el Char a String para poder concatenar.

    IV.  ALMACENAR Y CONCATENAR
         └── auxList.add(): guarda cada inicial en una lista mutable.
         └── .joinToString(""): une todos los elementos sin separador.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object Acronym {                                                         │
    │     fun generate(phrase: String) : String {                              │
    │         val auxList = mutableListOf<String>()                            │
    │         val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }  │
    │         for (i in list){                                                 │
    │             auxList.add(i.first().uppercaseChar().toString())            │
    │         }                                                                │
    │         return auxList.joinToString("")                                  │
    │     }                                                                    │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada: "objeto". En Kotlin, object declara un
             Singleton — una clase que tiene UNA SOLA instancia en todo
             el programa.
         └── No necesitas crear instancias con new; usas Acronym directamente.
         └── Analogía: el directorio telefónico de la ciudad — solo hay uno,
             no tienes que crearlo, ya existe.

    II.  Acronym
         └── Nombre del objeto singleton.

    III. fun generate(phrase: String): String
         └── Método: genera el acrónimo a partir de una frase.
         └── phrase: String — parámetro que recibe la frase de entrada.
         └── : String — devuelve un String (el acrónimo).

    IV.  val auxList = mutableListOf<String>()
         └── val: variable INMUTABLE (la referencia no cambia, pero el
             contenido de la lista sí puede modificarse).
         └── auxList: nombre de la variable, "lista auxiliar".
         └── mutableListOf<String>(): función que crea una lista MUTABLE
             vacía que almacena elementos de tipo String.
         └── Analogía: una bandeja vacía donde irás poniendo letras una a una.

    V.   val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
         └── split(" ","-","_"): divide la frase usando ESPACIO, GUIÓN
             y GUIÓN BAJO como separadores.
             └── "Liquid-crystal display" → ["Liquid", "crystal", "display"]
             └── "The Road _Not_ Taken"   → ["The", "Road", "Not", "Taken"]
         └── filter { it.isNotEmpty() }: conserva solo cadenas NO VACÍAS.
             └── Elimina cadenas "" que split genera con separadores dobles.
         └── it: parámetro implícito de la lambda (cada subcadena).

    VI.  for (i in list)
         └── for: bucle "para cada".
         └── i: variable que toma el valor de CADA elemento en la lista
             (una palabra por iteración).
         └── in: separa la variable de la colección a recorrer.
         └── list: la colección de palabras a iterar.
         └── Analogía: "para cada invitado en la lista de invitados, haz..."

    VII. auxList.add(i.first().uppercaseChar().toString())
         └── auxList.add(): agrega un elemento al final de la lista mutable.
         └── i.first(): obtiene el PRIMER carácter de la palabra i.
             └── "Liquid".first() → 'L'
         └── .uppercaseChar(): convierte el Char a MAYÚSCULA.
             └── 'l'.uppercaseChar() → 'L'
         └── .toString(): convierte el Char a String para poder concatenar.
             └── 'L'.toString() → "L"

    VIII. return auxList.joinToString("")
          └── return: devuelve el resultado y termina la función.
          └── auxList.joinToString(""): concatena todos los Strings de la
              lista en uno solo, usando "" (cadena vacía) como separador.
              └── ["A","S","A","P"] → "ASAP"
          └── Analogía: ensartar cuentas en un hilo sin espacio entre ellas.

    IX.  { } (llaves del for y del objeto)
         └── Las llaves {} delimitan bloques de código.
         └── En el for: el bloque se ejecuta para cada iteración.
         └── En el object: contiene los miembros del objeto.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO Acronimo:
        FUNCION generar(frase):
            iniciales = LISTA_VACIA()
            palabras = frase.SEPARAR(" ", "-", "_")
            palabras = palabras.FILTRAR(no_vacio)
            PARA CADA palabra EN palabras:
                iniciales.AGREGAR(palabra.PRIMERA().MAYUSCULA())
            DEVOLVER iniciales.UNIR("")

    ───────────────────────────────────────────────────────────────────────────

    ALGORITMO PASO A PASO:
    1. Crear una lista vacía para almacenar las iniciales.
    2. Dividir la frase usando espacio, guión y guión bajo como separadores.
    3. Eliminar las cadenas vacías que puedan aparecer.
    4. Para cada palabra en la lista:
       a. Tomar el primer carácter.
       b. Convertirlo a mayúscula.
       c. Agregarlo a la lista de iniciales.
    5. Unir todas las iniciales en un solo String.
    6. Devolver el acrónimo resultante.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Acronym.generate("As Soon As Possible")

        Entrada: phrase = "As Soon As Possible"

        split(" ","-","_"):
          ["As", "Soon", "As", "Possible"]

        filter(it.isNotEmpty()):
          ["As", "Soon", "As", "Possible"]  (ninguna cadena vacía)

        for:
          "As"       → 'A' → 'A' → "A" → auxList = ["A"]
          "Soon"     → 'S' → 'S' → "S" → auxList = ["A","S"]
          "As"       → 'A' → 'A' → "A" → auxList = ["A","S","A"]
          "Possible" → 'P' → 'P' → "P" → auxList = ["A","S","A","P"]

        joinToString(""): "ASAP"

        Resultado: "ASAP" ✓

    EJEMPLO 2: Acronym.generate("Liquid-crystal display")

        Entrada: phrase = "Liquid-crystal display"

        split(" ","-","_"):
          ["Liquid", "crystal", "display"]

        filter(it.isNotEmpty()):
          ["Liquid", "crystal", "display"]

        for:
          "Liquid"  → 'L' → "L"
          "crystal" → 'c' → 'C' → "C"
          "display" → 'd' → 'D' → "D"

        joinToString(""): "LCD"

        Resultado: "LCD" ✓

        Explicación: el guión actúa como separador igual que el espacio.

    EJEMPLO 3: Acronym.generate("Thank George It's Friday!")

        Entrada: phrase = "Thank George It's Friday!"

        split(" ","-","_"):
          ["Thank", "George", "It's", "Friday!"]

        filter(it.isNotEmpty()):
          ["Thank", "George", "It's", "Friday!"]

        for:
          "Thank"   → 'T' → "T"
          "George"  → 'G' → "G"
          "It's"    → 'I' → "I"
          "Friday!" → 'F' → "F"

        joinToString(""): "TGIF"

        Resultado: "TGIF" ✓

        Explicación: Los apóstrofes ('), signos de puntuación (!) y otros
        caracteres no separadores se IGNORAN. Solo importa la primera letra
        de cada palabra separada por espacio, guión o guión bajo.

    EJEMPLO EXTRA: Acronym.generate("The Road _Not_ Taken")
        split → ["The", "Road", "Not", "Taken"]
        iniciales → T, R, N, T
        Resultado: "TRNT" (el guión bajo separa "Not" como palabra aparte)
*/
