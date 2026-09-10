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


// ▶ fun transcribeToRna(dna: String): String {
//   └▶ ① recibe la cadena de ADN y devuelve su complemento de ARN.
fun transcribeToRna(dna: String): String{
    // ▶ return dna.toList().map { when (it) {
    //   ├▶ ② .toList() → convierte el String en List<Char>.
    //   └▶ ③ .map { ... } → transforma cada carácter con el when; it es
    //           cada Char en turno (parámetro implícito de la lambda).
    return dna.toList().map { when(it){
        // ▶ 'G' -> 'C'  /  'C' -> 'G'  /  'T' -> 'A'  /  'A' -> 'U'
        //   └▶ ④ cada rama mapea un nucleótido de ADN a su complemento de ARN.
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        // ▶ else -> throw IllegalArgumentException("Invalid nucleotide: $it")
        //   └▶ ⑤ rama por defecto obligatoria: cualquier carácter inválido
        //           lanza excepción con el carácter problemático.
        else -> throw IllegalArgumentException("Invalid nucleotide: $it")
    } }.joinToString("")
    //   └▶ ⑥ joinToString("") → concatena la lista de Chars en un String
    //           sin separador.
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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Determinar el complemento de ARN a partir de una secuencia de
 *      ADN, aplicando las reglas G→C, C→G, T→A, A→U, y rechazando
 *      caracteres que no sean nucleótidos válidos.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar un Map<Char, Char> de complementos y buscar con
 *          map[it] ?: throw ..., en vez de un when.
 *      B)  Usar .replace() encadenado por cada nucleótido (menos
 *          seguro: hay que evitar sustituciones cruzadas).
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "GCTA"
 *      ─────────────────────────────────────────────────────────
 *      G→C, C→G, T→A, A→U
 *      Resultado: "CGAU"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "GCTX"
 *      ─────────────────────────────────────────────────────────
 *      G→C, C→G, T→A, X→ no coincide con ningún caso → else
 *      Resultado: lanza IllegalArgumentException("Invalid nucleotide: X")
 *
 *  ================================================================
 */
