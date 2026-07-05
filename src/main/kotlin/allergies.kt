@file:Suppress("SpellCheckingInspection")

/*
 * Instructions
 *
 * Given a person's allergy score, determine whether or not they're allergic
 * to a given item, and their full list of allergies.
 *
 * An allergy test produces a single numeric score which contains the
 * information about all the allergies the person has (that they were tested
 * for).
 *
 * The list of items (and their value) that were tested are:
 *
 *   eggs (1)
 *   peanuts (2)
 *   shellfish (4)
 *   strawberries (8)
 *   tomatoes (16)
 *   chocolate (32)
 *   pollen (64)
 *   cats (128)
 *
 * So if Tom is allergic to peanuts and chocolate, he gets a score of 34.
 *
 * Now, given just that score of 34, your program should be able to say:
 *
 *   - Whether Tom is allergic to any one of those allergens listed above.
 *   - All the allergens Tom is allergic to.
 *
 * Note: a given score may include allergens not listed above (i.e. allergens
 * that score 256, 512, 1024, etc.). Your program should ignore those
 * components of the score. For example, if the allergy score is 257, your
 * program should only report the eggs (1) allergy.
 */

enum class Allergen(val score: Int) {
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128)
}

class Allergies(val score: Int) {

    fun getList(): List<Allergen> {
        return Allergen.values().filter { isAllergicTo(it) }
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return score and allergen.score != 0
    }
}

fun main() {
    // Score 34 = peanuts(2) + chocolate(32)
    val tom = Allergies(34)
    println(tom.isAllergicTo(Allergen.PEANUTS))    // true
    println(tom.isAllergicTo(Allergen.CHOCOLATE))  // true
    println(tom.isAllergicTo(Allergen.EGGS))       // false
    println(tom.isAllergicTo(Allergen.CATS))       // false
    println(tom.getList())                         // [PEANUTS, CHOCOLATE]

    // Score 0 = no alergias
    val ana = Allergies(0)
    println(ana.isAllergicTo(Allergen.EGGS))       // false
    println(ana.getList())                         // []

    // Score 255 = todos los alérgenos (1+2+4+8+16+32+64+128)
    val pedro = Allergies(255)
    println(pedro.isAllergicTo(Allergen.CATS))     // true
    println(pedro.getList())                       // [EGGS, PEANUTS, SHELLFISH, STRAWBERRIES, TOMATOES, CHOCOLATE, POLLEN, CATS]

    // Score 257 = eggs(1) + valor desconocido(256)
    // solo reporta eggs, ignora el 256
    val maria = Allergies(257)
    println(maria.getList())                       // [EGGS]
}

/*
 * ──────────────────────────────────────────────────────────────
 * ALERGIAS (Allergies) — Guía de estudio
 * ──────────────────────────────────────────────────────────────
 *
 * CÓDIGO ANOTADO
 * ──────────────────────────────────────────────────────────────
 *
 * enum class Allergen(val score: Int) {
 * │
 * ├── EGGS(1), PEANUTS(2), SHELLFISH(4), STRAWBERRIES(8),
 * │   └── ─► Cada alérgeno tiene un valor POTENCIA DE 2:
 * │       1, 2, 4, 8... así cada uno ocupa un bit distinto
 * │       en el score. 1 = 00000001, 2 = 00000010, etc.
 * │
 * ├── TOMATOES(16), CHOCOLATE(32), POLLEN(64), CATS(128)
 * │
 * └── }
 *
 * class Allergies(val score: Int) {
 * │
 * │   score ─► suma de todos los alérgenos de la persona.
 * │   Si score = 34 → 2 + 32 (peanuts + chocolate).
 * │
 * ├── fun getList(): List<Allergen> {
 * │   └── return Allergen.values().filter { isAllergicTo(it) }
 * │       │
 * │       ├── Allergen.values()
 * │       │   └── ─► Devuelve TODOS los alérgenos del enum.
 * │       │       [EGGS, PEANUTS, SHELLFISH, STRAWBERRIES,
 * │       │        TOMATOES, CHOCOLATE, POLLEN, CATS]
 * │       │
 * │       ├── filter { isAllergicTo(it) }
 * │       │   └── ─► Conserva solo los que dan true.
 * │       │       it = cada alérgeno del array.
 * │       │       isAllergicTo(it) = "¿el score contiene
 * │       │       este alérgeno?"
 * │       │       score=34 → [PEANUTS, CHOCOLATE]
 * │       │
 * │       └── ─► Retorna la lista de alergias detectadas.
 * │   }
 * │
 * ├── fun isAllergicTo(allergen: Allergen): Boolean {
 * │   └── return score and allergen.score != 0
 * │       │
 * │       ├── score and allergen.score
 * │       │   └── ─► Operador AND bit a bit.
 * │       │       Compara bit por bit. Si AMBOS tienen
 * │       │       el mismo bit en 1, el resultado tiene
 * │       │       ese bit en 1. Si no, da 0.
 * │       │
 * │       └── != 0
 * │           └── ─► Si NO es cero, comparten al menos un
 * │               bit → la persona es alérgica (true).
 * │               Si es 0 → no hay coincidencia (false).
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
 * enum        | enumeración | Define un conjunto fijo de constantes
 * class       | clase       | Plantilla para crear objetos
 * val         | valor       | Variable inmutable (parámetro)
 * Int         | entero      | Tipo de dato numérico entero
 * fun         | función     | Declara una función o método
 * Boolean     | booleano    | Tipo de dato true/false
 * List        | lista       | Colección ordenada de elementos
 * return      | retornar    | Devuelve valor y termina la función
 * it          | ello        | Parámetro implícito en lambdas
 * filter      | filtrar     | Conserva elementos que cumplen condición
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE OPERADORES IMPORTANTES
 * ──────────────────────────────────────────────────────────────
 *
 * Operador | Nombre (ES)   | Explicación
 * ─────────┼───────────────┼─────────────────────────────────────
 * and      | Y bit a bit   | AND binario: 1 y 1 = 1, lo demás 0
 * !=       | distinto de   | Compara si dos valores son diferentes
 * ==       | igual que     | Compara igualdad de contenido
 * .        | punto         | Accede a propiedades o métodos
 * ()       | paréntesis    | Llama funciones o agrupa expresiones
 * {}       | llaves        | Define bloques de código y lambdas
 *
 * ──────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO
 * ──────────────────────────────────────────────────────────────
 *
 * PSEUDOCÓDIGO:
 * ─────────────
 *   enumerar Alergeno(valor):
 *     HUEVOS = 1, MANI = 2, MARISCO = 4, FRESAS = 8
 *     TOMATE = 16, CHOCOLATE = 32, POLEN = 64, GATOS = 128
 *
 *   clase Alergias(puntaje):
 *     función esAlergicoA(alergeno):
 *       devolver puntaje Y alergeno.valor != 0
 *
 *     función obtenerLista():
 *       devolver Alergeno.valores().filtrar(esAlergicoA)
 *
 * ¿CÓMO FUNCIONA AND BIT A BIT?
 * ──────────────────────────────
 *   Cada alérgeno tiene UN SOLO bit en 1 (potencia de 2):
 *     EGGS    = 1  = 00000001
 *     PEANUTS = 2  = 00000010
 *     CATS    = 128 = 10000000
 *
 *   score = 34 = 00100010 (PEANUTS + CHOCOLATE)
 *
 *   ¿Es alérgico a PEANUTS?
 *     34 = 00100010
 *      2 = 00000010  (PEANUTS)
 *     AND = 00000010 = 2 ≠ 0 → true ✓
 *
 *   ¿Es alérgico a EGGS?
 *     34 = 00100010
 *      1 = 00000001  (EGGS)
 *     AND = 00000000 = 0 → false ✗
 *
 *   Como cada alérgeno es una potencia de 2, ocupan bits
 *   diferentes y no se "mezclan" al sumarlos. El operador
 *   AND puede extraer cada uno por separado.
 *
 * EJEMPLO — Tom con score=34:
 * ───────────────────────────
 *   isAllergicTo(PEANUTS)   → 34 AND 2 = 2  → true  ✓
 *   isAllergicTo(CHOCOLATE) → 34 AND 32 = 32 → true  ✓
 *   isAllergicTo(EGGS)      → 34 AND 1 = 0   → false ✗
 *   isAllergicTo(CATS)      → 34 AND 128 = 0 → false ✗
 *   getList() → [PEANUTS, CHOCOLATE] ✓
 */

