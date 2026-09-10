@file:Suppress("SpellCheckingInspection")

/**
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

// ▶ enum class Allergen(val score: Int) {
//   ├▶ ① enum class → conjunto fijo y cerrado de constantes con nombre; no se
//   │       pueden crear más en ejecución (como los días de la semana).
//   ├▶ ② Allergen → nombre del tipo; cada constante de abajo ES un Allergen.
//   └▶ ③ (val score: Int) → constructor primario; val = propiedad inmutable que
//           cada constante fija con su propio número (potencia de 2 → un bit).
enum class Allergen(val score: Int) {
    // ▶ EGGS(1), PEANUTS(2), ... CATS(128)
    //   └▶ ④ las ocho constantes; cada paréntesis pasa su score al constructor.
    //           Analogía: interruptores de un panel, cada uno con su id.
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128)
    // ▶ }
    //   └▶ ⑤ cierra el cuerpo del enum.
}

// ▶ class Allergies(val score: Int) {
//   └▶ ⑥ clase normal; score es el puntaje total recibido (ej. 34 = 2 + 32) y
//           queda guardado como propiedad.
class Allergies(val score: Int) {

    // ▶ fun getList(): List<Allergen> {
    //   ├▶ ⑦ fun getList → declara un metdo sin parámetros.
    //   └▶ ⑧ : List<Allergen> → tipo de retorno: una lista de constantes del enum.
    fun getList(): List<Allergen> {
        // ▶ return Allergen.values().filter { isAllergicTo(it) }
        //   ├▶ ⑨ Allergen.values() → array con TDAS las constantes del enum,
        //   │       generado automáticamente.
        //   ├▶ ⑩ .filter { ... } → conserva solo los elementos que cumplen la
        //   │       condición entre llaves.
        //   └▶ ⑪ isAllergicTo(it) → condición; it = cada Allergen en turno
        //           (parámetro implícito de la lambda).
        return Allergen.values().filter { isAllergicTo(it) }
    }

    // ▶ fun isAllergicTo(allergen: Allergen): Boolean {
    //   ├▶ ⑫ allergen: Allergen → recibe el alérgeno a consultar.
    //   └▶ ⑬ : Boolean → devuelve true o false.
    fun isAllergicTo(allergen: Allergen): Boolean {
        // ▶ return score and allergen.score != 0
        //   ├▶ ⑭ score → puntaje total de la persona.
        //   ├▶ ⑮ and → AND bit a bit: pone 1 solo donde AMBOS números tienen 1
        //   │       en esa posición.
        //   ├▶ ⑯ allergen.score → el bit único de ese alérgeno.
        //   └▶ ⑰ != 0 → si algún bit coincidió, el resultado no es cero → la
        //           persona es alérgica. (Precedencia: primero and, luego != 0.)
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

    // Score 255 = tdos los alérgenos (1+2+4+8+16+32+64+128)
    val pedro = Allergies(255)
    println(pedro.isAllergicTo(Allergen.CATS))     // true
    println(pedro.getList())                       // [EGGS, PEANUTS, SHELLFISH, STRAWBERRIES, TOMATOES, CHOCOLATE, POLLEN, CATS]

    // Score 257 = eggs(1) + valor desconocido(256)
    // solo reporta eggs, ignora el 256
    val maria = Allergies(257)
    println(maria.getList())                       // [EGGS]
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Dado el puntaje de alergias de una persona (un entero que codifica
 *      cada alérgeno como una potencia de 2), determinar si es alérgica a
 *      un alérgeno concreto y obtener la lista completa de sus alergias,
 *      ignorando cualquier bit que no corresponda a un alérgeno conocido.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Guardar el desplazamiento en el propio enum con (1 shl ordinal)
 *          en lugar de escribir el score explícito en el constructor.
 *      B)  Convertir el score a binario (Integer.toBinaryString) y
 *          comprobar cada bit por posición en vez de usar and.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Tom — score=34 (peanuts=2 + chocolate=32)"
 *      ─────────────────────────────────────────────────────────
 *      isAllergicTo(EGGS):      34=00100010, 1=00000001   → and=0  → false
 *      isAllergicTo(PEANUTS):   34=00100010, 2=00000010   → and=2  → true
 *      isAllergicTo(CHOCOLATE): 34=00100010, 32=00100000  → and=32 → true
 *      isAllergicTo(CATS):      34=00100010, 128=10000000 → and=0  → false
 *      Resultado: [PEANUTS, CHOCOLATE]
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "María — score=257 (eggs=1 + valor desconocido=256)"
 *      ─────────────────────────────────────────────────────────
 *      257 en binario = 100000001 (bit 0 y bit 8 activados).
 *      isAllergicTo(EGGS): 257 and 1 = 1 ≠ 0 → true
 *      El bit 8 (256) no corresponde a ningún alérgeno, el AND lo ignora.
 *      Resultado: [EGGS]
 *
 *  ================================================================
 */
