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

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Dado el puntaje de alergias de una persona, determinar:
    I.   Si es alérgica a un alérgeno específico.
    II.  La lista completa de sus alergias.

    El puntaje es un número entero que codifica las alergias mediante
    potencias de 2 (cada alérgeno ocupa un bit distinto):
       eggs=1, peanuts=2, shellfish=4, strawberries=8, tomatoes=16,
       chocolate=32, pollen=64, cats=128

    Si el puntaje incluye valores mayores (256, 512, ...), deben ignorarse.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I.  MODELAR LOS ALÉRGENOS CON UN ENUM
        └── Cada alérgeno es un valor fijo conocido. Usamos enum class.
        └── Cada constante tiene un score asociado (potencia de 2).

    II. DETECTAR UNA ALERGIA ESPECÍFICA (isAllergicTo)
        └── Usamos el operador AND bit a bit (and) entre el score total y
            el score del alérgeno.
        └── Si el resultado NO es cero → el bit está presente → es alérgico.
        └── Ej: score=34 (00100010), peanuts=2 (00000010)
            34 and 2 = 2 ≠ 0 → alérgico al maní.

    III. OBTENER LA LISTA COMPLETA (getList)
         └── Recorrer TODOS los alérgenos con Allergen.values().
         └── Filtrar aquellos para los que isAllergicTo devuelve true.
         └── Devolver la lista resultante.

    IV. IGNORAR VALORES DESCONOCIDOS
        └── El operador AND solo detecta los bits que coinciden con alérgenos
            conocidos. Bits adicionales (256+) simplemente no coinciden.
        └── Ej: score=257 → 257 and 1 = 1 (eggs), otros dan 0.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ enum class Allergen(val score: Int) {                                   │
    │     EGGS(1), PEANUTS(2), SHELLFISH(4), STRAWBERRIES(8),                │
    │     TOMATOES(16), CHOCOLATE(32), POLLEN(64), CATS(128)                  │
    │ }                                                                        │
    │ class Allergies(val score: Int) {                                        │
    │     fun getList(): List<Allergen> {                                      │
    │         return Allergen.values().filter { isAllergicTo(it) }             │
    │     }                                                                    │
    │     fun isAllergicTo(allergen: Allergen): Boolean {                      │
    │         return score and allergen.score != 0                             │
    │     }                                                                    │
    │ }                                                                        │
    │ fun main() {                                                             │
    │     val tom = Allergies(34)                                              │
    │     println(tom.isAllergicTo(Allergen.PEANUTS))    // true               │
    │     println(tom.isAllergicTo(Allergen.CHOCOLATE))  // true               │
    │     println(tom.isAllergicTo(Allergen.EGGS))       // false              │
    │     println(tom.getList())                         // [PEANUTS, CHOCOLATE]│
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   enum class
         └── Palabra reservada: "enumeración". Define un conjunto fijo de
             constantes con nombre.
         └── Analogía: los días de la semana (LUNES, MARTES, ...) — son
             valores predefinidos que nunca cambian.

    II.  Allergen
         └── Nombre del enum. Cada constante representa un tipo de alérgeno.

    III. (val score: Int)
         └── Constructor del enum: cada constante recibe un valor entero.
         └── val score: propiedad INMUTABLE accesible desde fuera.
         └── Int: tipo de dato entero (32 bits).
         └── Analogía: cada producto en una tienda tiene un código de barras
             único (su score).

    IV.  EGGS(1), PEANUTS(2), ...
         └── Constantes del enum. Cada una es una INSTANCIA de Allergen.
         └── El número entre paréntesis es el score que se pasa al constructor.
         └── Potencias de 2: 1,2,4,8,16,32,64,128.
         └── Analogía: interruptores individuales en un panel de luces —
             cada uno tiene su propio número de identificación.

    V.   class Allergies(val score: Int)
         └── Clase que representa las alergias de una persona.
         └── score: puntaje total que codifica TODAS las alergias.
         └── Ej: score=34 → tiene maní(2) y chocolate(32).

    VI.  fun getList(): List<Allergen>
         └── Método que devuelve la lista COMPLETA de alérgenos.
         └── : List<Allergen> — tipo de retorno: lista de objetos Allergen.

    VII. Allergen.values()
         └── Método generado automáticamente para enum class.
         └── Devuelve un ARRAY con todas las constantes del enum.
         └── [EGGS, PEANUTS, SHELLFISH, STRAWBERRIES, TOMATOES, CHOCOLATE,
             POLLEN, CATS]
         └── Analogía: el catálogo completo de productos de una tienda.

    VIII. .filter { isAllergicTo(it) }
          └── filter: conserva solo elementos que cumplen la condición.
          └── isAllergicTo(it): llama al método para cada alérgeno.
          └── it: parámetro IMPLÍCITO de la lambda (cada alérgeno en turno).

    IX.  fun isAllergicTo(allergen: Allergen): Boolean
         └── Método que determina si la persona es alérgica a un alérgeno.
         └── allergen: Allergen — parámetro de tipo Allergen.
         └── : Boolean — devuelve true o false.

    X.   return score and allergen.score != 0
         └── Operador and: AND BIT A BIT.
         └── Compara cada bit del score con cada bit de allergen.score.
         └── Solo si AMBOS bits son 1, el resultado tiene 1 en esa posición.
         └── != 0: si el resultado NO es cero, hay al menos un bit coincidente.
         └── Analogía: dos llaves que deben tener la misma muesca en la misma
             posición para que la cerradura gire.

    XI.  fun main()
         └── Punto de entrada del programa. Kotlin ejecuta main() al iniciar.

    XII. val tom = Allergies(34)
         └── val: variable inmutable.
         └── tom: nombre de la variable.
         └── Allergies(34): crea un objeto con score=34.
         └── 34 = 2 + 32 = peanuts + chocolate.

    XIII. println(...)
          └── Función que imprime texto en la consola con salto de línea.
          └── Llama automáticamente a toString() de cada objeto.

    XIV. // Comentario
          └── Doble barra: comentario de una línea (ignorado por el compilador).
          └── Muestra el resultado esperado de cada println.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    ENUMERACION Alergeno
        HUEVOS = 1, MANI = 2, MARISCO = 4, FRESAS = 8
        TOMATE = 16, CHOCOLATE = 32, POLEN = 64, GATOS = 128

    CLASE Alergias
        ENTRADA: puntaje (entero)

        FUNCION esAlergicoA(alergeno):
            DEVOLVER (puntaje Y alergeno.valor) DIFERENTE 0
            └── Y = operador AND bit a bit
            └── Si hay al menos un bit en común → true

        FUNCION obtenerLista():
            DEVOLVER Alergeno.TODOS().FILTRAR(esAlergicoA)
            └── Recorre todos los alérgenos y conserva los que dan true

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        tom = Alergias(34)
        imprimir(tom.esAlergicoA(MANI))      → verdadero
        imprimir(tom.esAlergicoA(CHOCOLATE)) → verdadero
        imprimir(tom.esAlergicoA(HUEVOS))    → falso
        imprimir(tom.obtenerLista())         → [MANI, CHOCOLATE]

    ¿CÓMO FUNCIONA AND BIT A BIT?
        score=34  = 00100010
        MANI=2    = 00000010
        AND       = 00000010 = 2 ≠ 0 → VERDADERO (tiene maní)

        score=34  = 00100010
        HUEVOS=1  = 00000001
        AND       = 00000000 = 0 → FALSO (no tiene huevos)

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Tom — score=34 (peanuts=2 + chocolate=32)

        Entrada: Allergies(34)

        isAllergicTo(EGGS):
          34 = 00100010, 1 = 00000001
          34 and 1 = 00000000 = 0 → false ✗

        isAllergicTo(PEANUTS):
          34 = 00100010, 2 = 00000010
          34 and 2 = 00000010 = 2 ≠ 0 → true ✓

        isAllergicTo(CHOCOLATE):
          34 = 00100010, 32 = 00100000
          34 and 32 = 00100000 = 32 ≠ 0 → true ✓

        isAllergicTo(CATS):
          34 = 00100010, 128 = 10000000
          34 and 128 = 00000000 = 0 → false ✗

        getList():
          Allergen.values() → [EGGS, PEANUTS, SHELLFISH, STRAWBERRIES,
                               TOMATOES, CHOCOLATE, POLLEN, CATS]
          filter → solo PEANUTS y CHOCOLATE dan true
          Resultado: [PEANUTS, CHOCOLATE]

    EJEMPLO 2: Ana — score=0 (sin alergias)

        Entrada: Allergies(0)

        isAllergicTo(EGGS):
          0 = 00000000, 1 = 00000001
          0 and 1 = 0 → false ✗ (para todos los alérgenos)

        getList():
          filter devuelve lista vacía porque ningún alérgeno da true
          Resultado: []

        Explicación: score=0 significa que ningún bit está activado.
        La persona no tiene ninguna alergia.

    EJEMPLO 3: María — score=257 (eggs=1 + valor desconocido=256)

        Entrada: Allergies(257)

        257 en binario: 100000001 (bit 0 y bit 8)

        isAllergicTo(EGGS):
          257 = 100000001, 1 = 000000001
          257 and 1 = 1 ≠ 0 → true ✓

        isAllergicTo(PEANUTS):
          257 = 100000001, 2 = 000000010
          257 and 2 = 0 → false ✗

        ... (todos los demás alérgenos dan false)

        getList():
          Solo EGGS da true
          Resultado: [EGGS]

        Explicación: el bit 256 (100000000) no coincide con ningún alérgeno
        conocido. Los alérgenos conocidos solo usan los primeros 8 bits
        (1,2,4,8,16,32,64,128). El operador AND simplemente ignora el bit
        extra porque no hay con quién coincidir.
*/
