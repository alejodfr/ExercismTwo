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
 * ╔══════════════════════════════════════════════════════════╗
 * ║       NUCLEOTIDE COUNT — GUÍA DE ESTUDIO COMPLETA       ║
 * ╚══════════════════════════════════════════════════════════╝
 *
 * ─────────────────────────────────────────────────────────────────────
 * 1. CÓDIGO ANOTADO (Árbol de análisis línea por línea)
 * ─────────────────────────────────────────────────────────────────────
 *
 * class Dna(val input: String) {                 ──► class + nombre = definir clase
 * │                                                ──► val input: String = parámetro constructor
 * │                                                ──► val = solo lectura, String = tipo texto
 * │
 *     init {                                       ──► init = bloque de inicialización
 *     │                                             ──► Se ejecuta al crear: Dna("GATTACA")
 *     │
 *         input.filter { it != 'A' && it != 'C'   ──► filter {} recorre cada carácter
 *                     && it != 'G' && it != 'T' }  ──► Conserva solo los NO válidos
 *         │                                         ──► it = cada carácter (nombre implícito)
 *         │                                         ──► != significa "diferente de"
 *         │                                         ──► && = Y lógico, TODAS deben ser true
 *         │                                         ──► Si es A, C, G o T → no pasa el filtro
 *         │
 *             .forEach { throw IllegalArgumentException(   ──► forEach ejecuta bloque por c/u
 *                           "Invalid nucleotide: $it") }   ──► throw lanza excepción y detiene
 *                                                          ──► $it interpola el carácter en texto
 *     }
 *     │
 *     val nucleotideCounts: Map<Char, Int>         ──► Propiedad de solo lectura (val)
 *     │                                             ──► Map<Char, Int> = diccionario
 *     │                                             ──► Char = clave (A, C, G, T)
 *     │                                             ──► Int = valor (cantidad)
 *         get() {                                   ──► Getter personalizado
 *         │                                         ──► Se ejecuta al llamar .nucleotideCounts
 *         │
 *             return mapOf(                         ──► mapOf() construye el Map
 *             │
 *                 'A' to input.count { it == 'A' }, ──► 'A' clave → count {} cuenta ocurrencias
 *             │                                       ──► to crea par clave→valor
 *             │                                       ──► it == 'A' es true si carácter = 'A'
 *                 'C' to input.count { it == 'C' }, ──► Igual para 'C'
 *                 'G' to input.count { it == 'G' }, ──► Igual para 'G'
 *                 'T' to input.count { it == 'T' }  ──► Igual para 'T'
 *             )
 *         }
 * }
 *
 * ─────────────────────────────────────────────────────────────────────
 * 2. TABLA DE PALABRAS RESERVADAS
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────────────────────────────────────────────┐
 * │ PALABRA      │ SIGNIFICADO                                      │
 * ├──────────────┼──────────────────────────────────────────────────┤
 * │ class        │ Define una nueva clase (molde para crear objetos)│
 * │ val          │ Variable o propiedad de solo lectura (inmutable) │
 * │ init         │ Bloque que se ejecuta al instanciar la clase     │
 * │ it           │ Nombre implícito del parámetro en una lambda     │
 * │ throw        │ Lanza una excepción (detiene la ejecución)       │
 * │ return       │ Devuelve un valor desde una función o getter     │
 * │ get          │ Define el getter personalizado de una propiedad  │
 * └──────────────┴──────────────────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 3. TABLA DE OPERADORES IMPORTANTES
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────┬───────────────────────────────────────┐
 * │ OPERADOR     │ TIPO     │ EXPLICACIÓN                           │
 * ├──────────────┼──────────┼───────────────────────────────────────┤
 * │ !=           │Comparación│ "diferente de" → true si son distintos│
 * │ &&           │ Lógico   │ "Y" → true solo si AMBAS condiciones  │
 * │ ==           │Comparación│ "igual a" → true si son iguales      │
 * │ to           │ Asociación│ Crea un par (clave, valor)           │
 * │ { }          │ Lambda   │ Bloque de código anónimo que se pasa  │
 * │ ->           │ Separador│ Separa parámetros del cuerpo lambda   │
 * │ $            │Interpolac│ Inserta variable dentro de un String  │
 * └──────────────┴──────────┴───────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 4. RESUMEN ALGORÍTMICO
 * ─────────────────────────────────────────────────────────────────────
 *
 * ▸ PROBLEMA: Contar nucleótidos (A, C, G, T) en un String de ADN.
 *   Si hay caracteres inválidos → lanzar error.
 *
 * ▸ PSEUDOCÓDIGO:
 *
 *   CLASE Dna CON entrada: String
 *       AL CREAR:
 *           PARA CADA caracter c EN entrada:
 *               SI c NO es 'A' Y c NO es 'C' Y c NO es 'G' Y c NO es 'T':
 *                   LANZAR error "caracter invalido: c"
 *
 *       PROPIEDAD conteos:
 *           DEVOLVER Mapa:
 *               'A' → contar A en entrada
 *               'C' → contar C en entrada
 *               'G' → contar G en entrada
 *               'T' → contar T en entrada
 *
 * ▸ EJEMPLO: entrada = "GATTACA"
 *
 *   ┌─ VALIDACION (init) ────────────────────────────────────────────┐
 *   │                                                                │
 *   │ filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }   │
 *   │                                                                │
 *   │ G → G != A? SI, G != C? SI, G != G? NO  → descartado          │
 *   │ A → A != A? NO                              → descartado       │
 *   │ T → T != T? NO                              → descartado       │
 *   │ T → descartado                                                │
 *   │ A → descartado                                                │
 *   │ C → descartado                                                │
 *   │ A → descartado                                                │
 *   │                                                                │
 *   │ Resultado: [] lista vacia → no hay invalidos ✓                │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌─ CONTEO (get) ────────────────────────────────────────────────┐
 *   │                                                               │
 *   │   count(it == 'A') → [G no, A SI, T no, T no, A SI, C no, A SI] = 3 │
 *   │   count(it == 'C') → [no, no, no, no, no, SI, no] = 1        │
 *   │   count(it == 'G') → [SI, no, no, no, no, no, no] = 1        │
 *   │   count(it == 'T') → [no, no, SI, SI, no, no, no] = 2        │
 *   │                                                               │
 *   │ Resultado: {A=3, C=1, G=1, T=2}                              │
 *   └────────────────────────────────────────────────────────────────┘
 */