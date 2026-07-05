@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * At a garage sale, you find a lovely vintage typewriter at a bargain price!
 * Excitedly, you rush home, insert a sheet of paper, and start typing away.
 * However, your excitement wanes when you examine the output: all words are
 * garbled! For example, it prints "stop" instead of "post" and "least"
 * instead of "stale." Carefully, you try again, but now it prints "spot" and
 * "slate." After some experimentation, you find there is a random delay
 * before each letter is printed, which messes up the order. You now
 * understand why they sold it for so little money!
 *
 * You realize this quirk allows you to generate anagrams, which are words
 * formed by rearranging the letters of another word. Pleased with your
 * finding, you spend the rest of the day generating hundreds of anagrams.
 *
 * Instructions
 *
 * Given a target word and one or more candidate words, your task is to find
 * the candidates that are anagrams of the target.
 *
 * An anagram is a rearrangement of letters to form a new word: for example
 * "owns" is an anagram of "snow". A word is not its own anagram: for
 * example, "stop" is not an anagram of "stop".
 *
 * The target word and candidate words are made up of one or more ASCII
 * alphabetic characters (A-Z and a-z). Lowercase and uppercase characters
 * are equivalent: for example, "PoTS" is an anagram of "sTOp", but "StoP"
 * is not an anagram of "sTOp". The words you need to find should be taken
 * from the candidate words, using the same letter case.
 *
 * Given the target "stone" and the candidate words "stone", "tones",
 * "banana", "tons", "notes", and "Seton", the anagram words you need to
 * find are "tones", "notes", and "Seton".
 *
 * Track specific instructions
 *
 * The anagrams can be returned in any order.
 */

class Anagram(val target: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { candidate ->
            candidate.lowercase() != target.lowercase() &&
            candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
        }.toSet()
    }
}

/**
 * ──────────────────────────────────────────────────────────────
 * ANAGRAMA (Anagram) — Guía de estudio
 * ──────────────────────────────────────────────────────────────
 *
 * CÓDIGO ANOTADO
 * ──────────────────────────────────────────────────────────────
 *
 * class Anagram(val target: String) {
 * │
 * │   target ─► palabra objetivo. Llega desde afuera:
 * │   Anagram("stone").match(listaDeCandidatos)
 * │
 * ├── fun match(anagrams: Collection<String>): Set<String> {
 * │   │
 * │   └── return anagrams.filter { candidate ->
 * │       │
 * │       ├── candidate.lowercase() != target.lowercase() &&
 * │       │   │
 * │       │   ├── candidate.lowercase()
 * │       │   │   └── ─► Convierte el candidato a minúsculas.
 * │       │   │       "StOne" → "stone"
 * │       │   │
 * │       │   ├── target.lowercase()
 * │       │   │   └── ─► Convierte el target a minúsculas.
 * │       │   │       "STONE" → "stone"
 * │       │   │
 * │       │   ├── != (distinto)
 * │       │   │   └── ─► Una palabra NO es anagrama de sí misma.
 * │       │   │       "stone" ≠ "stone" → false, se descarta.
 * │       │   │
 * │       │   └── && (Y lógico)
 * │       │       └── ─► Ambas condiciones deben ser true.
 * │       │
 * │       ├── candidate.lowercase().toList().sorted() ==
 * │       │   target.lowercase().toList().sorted()
 * │       │   │
 * │       │   ├── .toList()
 * │       │   │   └── ─► Convierte el String en lista de Chars.
 * │       │   │       "stone" → ['s','t','o','n','e']
 * │       │   │
 * │       │   ├── .sorted()
 * │       │   │   └── ─► Ordena los caracteres alfabéticamente.
 * │       │   │       ['s','t','o','n','e'] → ['e','n','o','s','t']
 * │       │   │
 * │       │   └── == (igual)
 * │       │       └── ─► Si las listas ordenadas son IGUALES,
 * │       │           las palabras tienen las mismas letras
 * │       │           → son anagramas.
 * │       │           ["e","n","o","s","t"] == ["e","n","o","s","t"]
 * │       │
 * │       └── }.toSet()
 * │           └── ─► Convierte el resultado de List a Set
 * │               (colección sin elementos repetidos).
 * │   }
 * │
 * └── }
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE PALABRAS RESERVADAS
 * ──────────────────────────────────────────────────────────────
 *
 * Palabra     | Español     | Explicación
 * ────────────┼─────────────┼────────────────────────────────────
 * class       | clase       | Plantilla para crear objetos
 * val         | valor       | Variable inmutable (parámetro)
 * fun         | función     | Declara una función o método
 * String      | cadena      | Tipo de dato textual
 * Collection  | colección   | Tipo genérico que agrupa elementos
 * Set         | conjunto    | Colección SIN elementos duplicados
 * return      | retornar    | Devuelve un valor y termina la función
 * it          | ello        | Parámetro implícito en lambdas
 * filter      | filtrar     | Conserva elementos que cumplen condición
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE OPERADORES IMPORTANTES
 * ──────────────────────────────────────────────────────────────
 *
 * Operador | Nombre (ES)  | Explicación
 * ─────────┼──────────────┼─────────────────────────────────────
 * !=       | distinto     | Verifica si dos valores son diferentes
 * ==       | igual que    | Compara igualdad de contenido
 * &&       | Y lógico     | TRUE solo si ambas condiciones son true
 * .        | punto        | Accede a métodos y propiedades
 * ->       | flecha       | Separa parámetro de cuerpo en lambda
 * {}       | llaves       | Define bloque de código o cuerpo lambda
 *
 * ──────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO
 * ──────────────────────────────────────────────────────────────
 *
 * PSEUDOCÓDIGO:
 * ─────────────
 *   clase Anagrama(objetivo):
 *     función coincidir(candidatos):
 *       devolver candidatos.filtrar { candidato →
 *         candidato.minúsculas() ≠ objetivo.minúsculas()
 *         Y
 *         candidato.minúsculas().aLista().ordenar() =
 *         objetivo.minúsculas().aLista().ordenar()
 *       }.aConjunto()
 *
 * ¿CÓMO DETECTAR UN ANAGRAMA?
 * ────────────────────────────
 *   Dos palabras son anagramas si tienen las MISMAS letras en
 *   DISTINTO orden. Para compararlas sin importar el orden:
 *     1. Convertir ambas a minúsculas (ignorar mayúsculas/minúsculas)
 *     2. Convertir a lista de caracteres
 *     3. Ordenar alfabéticamente
 *     4. Comparar las listas
 *
 *   "stone".lowercase().toList().sorted() → [e, n, o, s, t]
 *   "tones".lowercase().toList().sorted() → [e, n, o, s, t]
 *   └── IGUALES → "tones" SÍ es anagrama ✓
 *
 *   "banana".lowercase().toList().sorted() → [a, a, a, b, n, n]
 *   └── DISTINTAS → "banana" NO es anagrama ✗
 *
 * EJEMPLO — Anagram("stone").match([...]):
 * ───────────────────────────────────────
 *   candidatos = ["stone", "tones", "banana", "notes", "Seton"]
 *
 *   "stone" → igual que target → descartado ✗
 *   "tones" → distinto Y sorted igual → anagrama ✓
 *   "banana" → sorted diferente → descartado ✗
 *   "notes" → distinto Y sorted igual → anagrama ✓
 *   "Seton" → distinto Y sorted igual → anagrama ✓
 *   (minúsculas: "seton" sorted = [e,n,o,s,t])
 *
 *   Resultado: {"tones", "notes", "Seton"} ✓
 */