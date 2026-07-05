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
 * ╔══════════════════════════════════════════════════════════╗
 * ║       RNA TRANSCRIPTION — GUÍA DE ESTUDIO COMPLETA      ║
 * ╚══════════════════════════════════════════════════════════╝
 *
 * ─────────────────────────────────────────────────────────────────────
 * 1. CÓDIGO ANOTADO (Árbol de análisis línea por línea)
 * ─────────────────────────────────────────────────────────────────────
 *
 * fun transcribeToRna(dna: String): String {  ──► fun = declarar función
 * │                                              ──► transcribeToRna = nombre
 * │                                              ──► dna: String = parámetro (String de entrada)
 * │                                              ──► : String = tipo de retorno (devuelve String)
 * │
 *     return dna.toList().map { when(it) {       ──► return = devolver resultado
 *     │                                            ──► dna.toList() = convertir String a lista de Chars
 *     │                                            ──► "GCTA".toList() → ['G','C','T','A']
 *     │                                            ──► map { } = transformar CADA elemento
 *     │                                            ──► it = cada carácter (uno por uno)
 *         'G' -> 'C'                               ──► Si it = 'G' → devolver 'C'
 *         'C' -> 'G'                               ──► Si it = 'C' → devolver 'G'
 *         'T' -> 'A'                               ──► Si it = 'T' → devolver 'A'
 *         'A' -> 'U'                               ──► Si it = 'A' → devolver 'U'
 *         else -> throw IllegalArgumentException(  ──► else = caso por defecto (OBLIGATORIO)
 *                    "Invalid nucleotide: $it")    ──► throw lanza excepción si no es A,C,G,T
 *     } }.joinToString("")                         ──► joinToString("") = unir lista en String
 *     │                                            ──► "" = sin separador entre caracteres
 *     │                                            ──► ['C','G','A','U'] → "CGAU"
 * }
 *
 * ─────────────────────────────────────────────────────────────────────
 * 2. TABLA DE PALABRAS RESERVADAS
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────────────────────────────────────────────┐
 * │ PALABRA      │ SIGNIFICADO                                      │
 * ├──────────────┼──────────────────────────────────────────────────┤
 * │ fun          │ Declara una función (bloque de código reusable)  │
 * │ return       │ Devuelve un valor y termina la función           │
 * │ it           │ Parámetro implícito en lambda de 1 argumento     │
 * │ when         │ Evalúa un valor contra múltiples casos (switch)  │
 * │ else         │ Rama por defecto en when (obligatorio si faltan  │
 * │              │ casos cubiertos)                                 │
 * │ throw        │ Lanza una excepción (detiene la ejecución)       │
 * └──────────────┴──────────────────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 3. TABLA DE OPERADORES IMPORTANTES
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────┬───────────────────────────────────────┐
 * │ OPERADOR     │ TIPO     │ EXPLICACIÓN                           │
 * ├──────────────┼──────────┼───────────────────────────────────────┤
 * │ ->           │ Separador│ En when: separa caso de resultado     │
 * │              │          │ Ej: 'G' -> 'C' significa "si es G, da C"│
 * │ { }          │ Lambda   │ Bloque de código anónimo              │
 * │ .            │ Acceso   │ Llama un método: dna.toList()         │
 * │ ::           │ Ref.     │ Referencia a método (no usado aquí)   │
 * │ $            │Interpolac│ Inserta variable en String: "$it"     │
 * └──────────────┴──────────┴───────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 4. RESUMEN ALGORÍTMICO
 * ─────────────────────────────────────────────────────────────────────
 *
 * ▸ PROBLEMA: Dado un String de ADN, transcribirlo a ARN:
 *   G→C, C→G, T→A, A→U. Si hay caracter invalido → error.
 *
 * ▸ PSEUDOCÓDIGO:
 *
 *   FUNCION transcribirAArn(adn: String) → String:
 *       PARA CADA caracter c EN adn:
 *           SEGUN c:
 *               'G' → TOMAR 'C'
 *               'C' → TOMAR 'G'
 *               'T' → TOMAR 'A'
 *               'A' → TOMAR 'U'
 *               OTRO → LANZAR error "nucleotido invalido: c"
 *       DEVOLVER todos los caracteres unidos en un String
 *
 * ▸ EJEMPLO: entrada = "GCTA"
 *
 *   ┌─ PASO 1: toList() ─────────────────────────────────────────────┐
 *   │                                                                │
 *   │   "GCTA".toList() → ['G', 'C', 'T', 'A']                      │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌─ PASO 2: map { when(it) { ... } } ────────────────────────────┐
 *   │                                                                │
 *   │   'G' → case 'G' → 'C'                                        │
 *   │   'C' → case 'C' → 'G'                                        │
 *   │   'T' → case 'T' → 'A'                                        │
 *   │   'A' → case 'A' → 'U'                                        │
 *   │                                                                │
 *   │   Resultado: ['C', 'G', 'A', 'U']                             │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌─ PASO 3: joinToString("") ────────────────────────────────────┐
 *   │                                                                │
 *   │   ['C', 'G', 'A', 'U'].joinToString("") → "CGAU"             │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌─ FLUJO COMPLETO ──────────────────────────────────────────────┐
 *   │                                                                │
 *   │   "GCTA"  →  ['G','C','T','A']  →  ['C','G','A','U']  →  "CGAU" │
 *   │    (input)      toList()              map{when}        join   │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 */