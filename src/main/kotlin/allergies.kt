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

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Dado el puntaje de alergias de una persona (un entero que codifica
 *      cada alérgeno como una potencia de 2), determinar si es alérgica a
 *      un alérgeno específico y obtener la lista completa de sus alergias,
 *      ignorando cualquier bit que no corresponda a un alérgeno conocido.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Modelar los alérgenos con un enum: cada uno es un valor fijo
 *           conocido (EGGS, PEANUTS, SHELLFISH, ...) con un score asociado
 *           que es una potencia de 2 (1, 2, 4, 8, 16, 32, 64, 128).
 *      II.  Detectar una alergia específica (isAllergicTo): usar AND bit
 *           a bit entre el score total y el score del alérgeno; si el
 *           resultado no es cero, el bit está presente y la persona es
 *           alérgica.
 *      III. Obtener la lista completa (getList): recorrer tdos los
 *           alérgenos con Allergen.values() y filtrar los que dan true
 *           en isAllergicTo.
 *      IV.  Ignorar valores desconocidos: el AND bit a bit solo coincide
 *           con los bits de alérgenos conocidos, así que cualquier bit
 *           extra (256, 512, ...) queda automáticamente descartado.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  enum class Allergen(val score: Int) {
 *      ①  enum class: define un conjunto fijo de constantes con nombre,
 *          como los días de la semana.
 *      ②  Allergen: nombre del enum; cada constante representa un
 *          alérgeno.
 *      ③  (val score: Int): constructor del enum; score es una
 *          propiedad inmutable que guarda el valor entero (potencia de
 *          2) de bit.
 *
 *      →      EGGS(1), PEANUTS(2), SHELLFISH(4), STRAWBERRIES(8),
 *              TOMATOES(16), CHOCOLATE(32), POLLEN(64), CATS(128)
 *      ④  Constantes del enum, cada una una instancia de Allergen con
 *          su propio score. Son analogía a interruptores de un panel
 *          de luces, cada uno con su propio número de identificación.
 *      →  }
 *
 *      →  class Allergies(val score: Int) {
 *      ⑤  Clase que representa las alergias de una persona; score es
 *          el puntaje total que codifica tdas sus alergias (ej. 34 =
 *          2 + 32).
 *
 *      →      fun getList(): List<Allergen> {
 *      ⑥  Metdo que devuelve la lista completa de alérgenos presentes.
 *      →          return Allergen.values().filter { isAllergicTo(it) }
 *      ⑦  Allergen.values(): array generado automáticamente con todas
 *          las constantes del enum, como el catálogo completo de una
 *          tienda.
 *      ⑧  .filter { isAllergicTo(it) }: conserva solo los alérgenos
 *          para los que isAllergicTo devuelve true; it es el parámetro
 *          implícito de la lambda (cada alérgeno en turno).
 *      →      }
 *
 *      →      fun isAllergicTo(allergen: Allergen): Boolean {
 *      ⑨  Metdo que determina si la persona es alérgica a un alérgeno
 *          dado; devuelve true o false.
 *      →          return score and allergen.score != 0
 *      ⑩  and: operador AND bit a bit; compara cada bit del score con
 *          cada bit de allergen.score, y solo da 1 donde ambos bits
 *          son 1.
 *      ⑪  != 0: si el resultado no es cero, hay al menos un bit
 *          coincidente — analogía a dos llaves que deben tener la
 *          misma muesca en la misma posición para que la cerradura
 *          gire.
 *      →      }
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar un Set<Allergen> construido con valores de enum cuyo
 *          ordinal se desplaza con shl (1 shl ordinal) en vez de
 *          guardar el score explícitamente en el constructor.
 *      B)  Convertir el score a su representación binaria
 *          (Integer.toBinaryString) y comprobar cada bit por posición
 *          en vez de usar and.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      ENUMERACIÓN Alergeno
 *          HUEVOS=1, MANI=2, MARISCO=4, FRESAS=8, TOMATE=16,
 *          CHOCOLATE=32, POLEN=64, GATOS=128
 *
 *      FUNCIÓN esAlergicoA(puntaje, alergeno): booleano
 *          DEVOLVER (puntaje Y alergeno.valor) DIFERENTE DE 0
 *      FIN FUNCIÓN
 *
 *      FUNCIÓN obtenerLista(puntaje): lista de Alergeno
 *          DEVOLVER TDOS_LOS_ALERGENOS.FILTRAR(a -> esAlergicoA(puntaje, a))
 *      FIN FUNCIÓN
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
 *      Ejemplo 2: "Ana — score=0 (sin alergias)"
 *      ─────────────────────────────────────────────────────────
 *      Tdo bit en 0 → 0 and cualquier score = 0 → siempre false.
 *      Resultado: []
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 3: "María — score=257 (eggs=1 + valor desconocido=256)"
 *      ─────────────────────────────────────────────────────────
 *      257 en binario = 100000001 (bit 0 y bit 8 activados)
 *      isAllergicTo(EGGS): 257 and 1 = 1 ≠ 0 → true
 *      Resto de alérgenos: sus bits no coinciden con el bit 0 ni el
 *      bit 8 → false
 *      El bit 256 (bit 8) no corresponde a ningún alérgeno conocido,
 *      así que el AND simplemente lo ignora.
 *      Resultado: [EGGS]
 *
 *  ================================================================
 */
