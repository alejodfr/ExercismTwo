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

/**
 * ──────────────────────────────────────────────────────────────
 * ACRÓNIMO (Acronym) — Guía de estudio
 * ──────────────────────────────────────────────────────────────
 *
 * CÓDIGO ANOTADO
 * ──────────────────────────────────────────────────────────────
 *
 * object Acronym {
 * │
 * ├── fun generate(phrase: String) : String {
 * │   │
 * │   ├── val auxList = mutableListOf<String>()
 * │   │   │
 * │   │   └── ─► Lista vacía que acumulará las iniciales.
 * │   │       mutableListOf permite agregar (.add()) elementos.
 * │   │
 * │   ├── val list = phrase.split(" ","-","_").filter { it.isNotEmpty() }
 * │   │   │
 * │   │   ├── split(" ","-","_")
 * │   │   │   └── ─► Divide la frase usando espacio, guión y
 * │   │   │       guión bajo como separadores.
 * │   │   │       "Liquid-crystal display" →
 * │   │   │       ["Liquid", "crystal", "display"]
 * │   │   │
 * │   │   └── filter { it.isNotEmpty() }
 * │   │       └── ─► Elimina cadenas vacías que split() genera
 * │   │           con separadores consecutivos ("a  b" → ["a","","b"]).
 * │   │           Sin esto, .first() fallaría en cadenas vacías.
 * │   │
 * │   ├── for (i in list) {
 * │   │   │
 * │   │   ├── auxList.add(i.first().uppercaseChar().toString())
 * │   │   │   │
 * │   │   │   ├── i.first()         ─► primer carácter de la palabra
 * │   │   │   ├── .uppercaseChar()  ─► lo pasa a mayúscula
 * │   │   │   ├── .toString()       ─► convierte Char a String
 * │   │   │   └── auxList.add()     ─► guarda la letra en la lista
 * │   │   │
 * │   │   └── }
 * │   │
 * │   ├── return auxList.joinToString("")
 * │   │   └── ─► Une todas las letras sin separador.
 * │   │       ["A","S","A","P"] → "ASAP"
 * │   │
 * │   └── }
 * │
 * └── }
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE PALABRAS RESERVADAS
 * ──────────────────────────────────────────────────────────────
 *
 * Palabra        | Español       | Explicación
 * ───────────────┼───────────────┼────────────────────────────────
 * object         | objeto        | Singleton: una única instancia
 * fun            | función       | Declara una función o método
 * val            | valor         | Variable inmutable (no reasigna)
 * String         | cadena        | Tipo de dato textual
 * mutableListOf  | lista mutable | Crea una lista que acepta cambios
 * for            | para          | Bucle que recorre una colección
 * in             | en            | Separa elemento de colección en for
 * it             | ello          | Parámetro implícito de una lambda
 * return         | retornar      | Devuelve valor y termina la función
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE OPERADORES IMPORTANTES
 * ──────────────────────────────────────────────────────────────
 *
 * Operador | Nombre (ES) | Explicación
 * ─────────┼─────────────┼────────────────────────────────────────
 * .        | punto       | Accede a métodos y propiedades
 * ()       | paréntesis  | Llama funciones o agrupa expresiones
 * {}       | llaves      | Define bloques de código o lambdas
 * ==       | igualdad    | Compara si dos valores son iguales
 * ->       | flecha      | Separa parámetro de cuerpo en lambda
 * ""       | comillas    | Delimita un valor String literal
 *
 * ──────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO
 * ──────────────────────────────────────────────────────────────
 *
 * PSEUDOCÓDIGO:
 * ─────────────
 *   función generar(frase):
 *     iniciales = []
 *     palabras = frase.separar(" ", "-", "_")
 *     palabras = palabras.filtrar(no vacío)
 *     para cada palabra en palabras:
 *       iniciales.agregar(palabra.primera().mayúscula())
 *     devolver iniciales.unir("")
 *
 * EJEMPLO — "As Soon As Possible":
 * ────────────────────────────────
 *   split    → ["As", "Soon", "As", "Possible"]
 *   for:
 *     "As"       → 'A' → "A"
 *     "Soon"     → 'S' → "S"
 *     "As"       → 'A' → "A"
 *     "Possible" → 'P' → "P"
 *   join      → ["A","S","A","P"] → "ASAP" ✓
 *
 * EJEMPLO — "Liquid-crystal display":
 * ───────────────────────────────────
 *   split    → ["Liquid", "crystal", "display"]
 *   for      → "L" + "C" + "D"
 *   join     → "LCD" ✓
 *
 * ANATOMÍA DE UNA LAMBDA:
 * ──────────────────────
 *   .filter { it.isNotEmpty() }
 *   └──┬──┘ └──┬────────────────┘
 *      │       └── función anónima (lambda)
 *      │           it = cada elemento de la lista en turno
 *      │           isNotEmpty() = true si la cadena NO está vacía
 *      └── filter: conserva solo los elementos que dan true
 *          ─► elimina cadenas vacías que causarían error
 */