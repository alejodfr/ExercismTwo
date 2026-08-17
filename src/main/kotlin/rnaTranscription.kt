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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Determinar el complemento de ARN a partir de una secuencia de
 *      ADN, aplicando las reglas G→C, C→G, T→A, A→U, y rechazando
 *      caracteres que no sean nucleótidos válidos.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Convertir el String de ADN en una lista de caracteres.
 *      II.  Transformar cada carácter con un when que mapea cada
 *           nucleótido a su complemento.
 *      III. Si aparece un carácter que no sea A, C, G o T, lanzar
 *           IllegalArgumentException.
 *      IV.  Unir la lista transformada de nuevo en un String.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun transcribeToRna(dna: String): String{
 *      →      return dna.toList().map { when(it){
 *      ①  .toList() convierte el String en List<Char>; .map transforma
 *          cada carácter aplicando el when.
 *
 *      →          'G' -> 'C'
 *      →          'C' -> 'G'
 *      →          'T' -> 'A'
 *      →          'A' -> 'U'
 *      ②  Cada rama del when mapea un nucleótido de ADN a su
 *          complemento de ARN.
 *
 *      →          else -> throw IllegalArgumentException("Invalid nucleotide: $it")
 *      ③  Rama por defecto obligatoria: cualquier carácter inválido
 *          lanza una excepción con el carácter problemático.
 *
 *      →      } }.joinToString("")
 *      ④  joinToString("") concatena la lista de Chars transformada
 *          en un único String sin separador.
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN transcribirAArn(adn: Texto): Texto
 *          DEVOLVER adn.MAPEAR(caracter c):
 *              SEGÚN c:
 *                  'G' → 'C'; 'C' → 'G'; 'T' → 'A'; 'A' → 'U'
 *                  OTRO → LANZAR Error("Nucleotido invalido: " + c)
 *              .UNIR("")
 *      FIN FUNCIÓN
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
