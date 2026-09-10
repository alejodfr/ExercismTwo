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

// ▶ class Dna(val input: String) {
//   └▶ ① recibe la secuencia de ADN y la guarda como propiedad inmutable.
class Dna(val input: String) {

    // ▶ init {
    //   └▶ ② bloque que se ejecuta al construir el objeto: aquí se valida.
    init {
        // ▶ input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
        //   └▶ ③ filter → conserva solo los caracteres que NO son ninguno
        //           de los cuatro nucleótidos válidos.
        input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
            // ▶ .forEach { throw IllegalArgumentException("Invalid nucleotide: $it") }
            //   └▶ ④ si queda algún carácter inválido, forEach lanza la
            //           excepción con ese carácter.
            .forEach { throw IllegalArgumentException("Invalid nucleotide: $it") }
    }

    // ▶ val nucleotideCounts: Map<Char, Int>
    //   └▶ ⑤ propiedad calculada: se construye cada vez que se lee (get()).
    val nucleotideCounts: Map<Char, Int>
        get() {
            // ▶ return mapOf(
            //   ├▶ ⑥ 'A' to input.count { it == 'A' } → to crea el par
            //   │       clave→valor; count recorre la cadena contando 'A'.
            //   └▶ ⑦ se repite el mismo patrón para 'C', 'G' y 'T'.
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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Contar cuántas veces aparece cada nucleótido (A, C, G, T) en
 *      una secuencia de ADN, señalando un error si aparece algún
 *      carácter distinto de esos cuatro.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar input.groupingBy { it }.eachCount() para obtener el
 *          conteo de todos los caracteres en un solo recorrido.
 *      B)  Validar con una expresión regular Regex("[^ACGT]") en vez
 *          de filter + forEach.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Dna(\"GATTACA\").nucleotideCounts"
 *      ─────────────────────────────────────────────────────────
 *      Validación: sin caracteres inválidos → ok
 *      Conteo: A=3, C=1, G=1, T=2
 *      Resultado: {A=3, C=1, G=1, T=2}
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "Dna(\"ACXT\")"
 *      ─────────────────────────────────────────────────────────
 *      filter conserva ['X'] (no es A, C, G ni T)
 *      Resultado: lanza IllegalArgumentException("Invalid nucleotide: X")
 *
 *  ================================================================
 */
