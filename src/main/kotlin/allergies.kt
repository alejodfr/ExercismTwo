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
 * # Allergies — Guía de resolución
 *
 * ## Enunciado
 *
 * Dado un score numérico, determinar a qué alérgenos es alérgica
 * una persona y si es alérgica a un alérgeno específico.
 *
 * Cada alérgeno tiene un valor que es potencia de 2:
 *   EGGS=1, PEANUTS=2, SHELLFISH=4, STRAWBERRIES=8,
 *   TOMATOES=16, CHOCOLATE=32, POLLEN=64, CATS=128
 *
 * El score es la suma de los valores de cada alérgeno.
 * Ejemplo: alérgico a peanuts y chocolate -> score = 2 + 32 = 34
 *
 * ## Orden de pensamiento
 *
 * 1. El score es un número que contiene información de todas las
 *    alergias — cada alérgeno ocupa un bit diferente.
 * 2. Para saber si un alérgeno está en el score, se usa el
 *    operador `and` que compara bit por bit.
 * 3. Si el resultado del `and` es != 0, comparten un bit —
 *    la persona es alérgica a ese alérgeno.
 * 4. Para obtener la lista completa, se filtran todos los
 *    alérgenos del enum usando isAllergicTo().
 *
 * ## Paso a paso
 *
 * ### El constructor
 *
 *   class Allergies(val score: Int)
 *
 * - score: Int -> el número que representa las alergias.
 *   Llega desde afuera: Allergies(34), Allergies(0), etc.
 *
 * ### isAllergicTo()
 *
 *   fun isAllergicTo(allergen: Allergen): Boolean {
 *       return score and allergen.score != 0
 *   }
 *
 * - allergen.score -> el valor del alérgeno en el enum (ej. PEANUTS=2)
 * - `and` -> compara bit por bit score y allergen.score
 * - != 0  -> si comparten algún bit, el resultado es distinto de 0
 *
 * Ejemplo con score=34 y PEANUTS(2):
 *   34 = 0 0 1 0 0 0 1 0
 *    2 = 0 0 0 0 0 0 1 0
 *   AND= 0 0 0 0 0 0 1 0 = 2 != 0 -> true (es alérgico)
 *
 * Ejemplo con score=34 y EGGS(1):
 *   34 = 0 0 1 0 0 0 1 0
 *    1 = 0 0 0 0 0 0 0 1
 *   AND= 0 0 0 0 0 0 0 0 = 0 -> false (no es alérgico)
 *
 * ### getList()
 *
 *   fun getList(): List<Allergen> {
 *       return Allergen.values().filter { isAllergicTo(it) }
 *   }
 *
 * - Allergen.values() -> todos los alérgenos del enum
 * - filter { isAllergicTo(it) } -> conserva solo los que dan true
 * - it -> cada alérgeno en turno
 *
 * ## Código completo
 *
 *   class Allergies(val score: Int) {
 *
 *       fun getList(): List<Allergen> {
 *           return Allergen.values().filter { isAllergicTo(it) }
 *       }
 *
 *       fun isAllergicTo(allergen: Allergen): Boolean {
 *           return score and allergen.score != 0
 *       }
 *   }
 */

