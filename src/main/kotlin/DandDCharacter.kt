@file:Suppress("SpellCheckingInspection")

import kotlin.math.floor

/**
 * Introduction
 *
 * After weeks of anticipation, you and your friends get together for your very first game of
 * Dungeons & Dragons (D&D). Since this is the first session of the game, each player has to
 * generate a character to play with. The character's abilities are determined by rolling 6-sided
 * dice, but where are the dice? With a shock, you realize that your friends are waiting for you
 * to produce the dice; after all it was your idea to play D&D! Panicking, you realize you forgot
 * to bring the dice, which would mean no D&D game. As you have some basic coding skills, you
 * quickly come up with a solution: you'll write a program to simulate dice rolls.
 *
 * Instructions
 *
 * For a game of Dungeons & Dragons, each player starts by generating a character they can play
 * with. This character has, among other things, six abilities: strength, dexterity, constitution,
 * intelligence, wisdom and charisma. These six abilities have scores that are determined randomly.
 * You do this by rolling four 6-sided dice and recording the sum of the largest three dice.
 * You do this six times, once for each ability.
 *
 * Your character's initial hitpoints are 10 + your character's constitution modifier. You find
 * your character's constitution modifier by subtracting 10 from your character's constitution,
 * dividing by 2 and rounding down.
 *
 * Write a random character generator that follows the above rules.
 *
 * For example, the six throws of four dice may look like:
 *
 *     5, 3, 1, 6: You discard the 1 and sum 5 + 3 + 6 = 14, which you assign to strength.
 *     3, 2, 5, 3: You discard the 2 and sum 3 + 5 + 3 = 11, which you assign to dexterity.
 *     1, 1, 1, 1: You discard the 1 and sum 1 + 1 + 1 = 3, which you assign to constitution.
 *     2, 1, 6, 6: You discard the 1 and sum 2 + 6 + 6 = 14, which you assign to intelligence.
 *     3, 5, 3, 4: You discard the 3 and sum 5 + 3 + 4 = 12, which you assign to wisdom.
 *     6, 6, 6, 6: You discard the 6 and sum 6 + 6 + 6 = 18, which you assign to charisma.
 *
 * Because constitution is 3, the constitution modifier is -4 and the hitpoints are 6.
 */

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int {
            val stats = List(4) { (1..6).random() }
            val totalSum = stats.sorted().drop(1).sum()
            return totalSum
        }

        fun modifier(score: Int): Int {
            val modified = floor((score - 10).toDouble() / 2).toInt()
            return modified
        }
    }

}

fun main() {
    val character = DndCharacter()
    println("Strength: ${character.strength}")
    println("Dexterity: ${character.dexterity}")
    println("Constitution: ${character.constitution}")
    println("Intelligence: ${character.intelligence}")
    println("Wisdom: ${character.wisdom}")
    println("Charisma: ${character.charisma}")
    println("Hitpoints: ${character.hitpoints}")
}

/**
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Simular la generación de un personaje de Dungeons & Dragons.

    Las reglas son:
    I.   Un personaje tiene 6 habilidades: strength, dexterity, constitution,
         intelligence, wisdom y charisma.
    II.  Cada habilidad se obtiene lanzando 4 dados de 6 caras (1-6) y sumando
         los 3 valores más altos (se descarta el más bajo).
    III. Los hitpoints (puntos de golpe) se calculan como:
            hitpoints = 10 + modificador de constitution.
         El modificador de constitution se calcula como:
            modifier = piso((constitution - 10) / 2).

    OBJETIVOS:
    I.   Implementar la función ability() que simule la tirada de dados.
    II.  Implementar la función modifier(score) que calcule el modificador.
    III. Crear una clase DndCharacter que tenga las 6 habilidades + hitpoints.
    IV.  Probar la creación de un personaje con main().

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. SIMULAR LA TIRADA DE DADOS (ability)
       a) Crear un Array de 4 elementos, cada uno un número aleatorio 1..6.
       b) Convertir el Array a List con .toList().
       c) Ordenar la lista con .sorted() (menor a mayor).
       d) Descartar el primer elemento (el más bajo) con .drop(1).
       e) Sumar los 3 restantes con .sum().
       └── Resultado: un entero entre 3 y 18.

    II. CALCULAR EL MODIFICADOR (modifier)
        a) Restar 10 al puntaje: score - 10.
        b) Dividir entre 2: (score - 10) / 2.
        c) Redondear hacia abajo con floor() (piso).
        └── Resultado: un entero entre -5 y +4.

    III. DISEÑO DE LA CLASE
         a) class DndCharacter — define el molde del personaje.
         b) Propiedades val (inmutables): strength, dexterity, etc.
         c) Cada propiedad se inicializa llamando a ability().
         d) hitpoints se calcula con 10 + modifier(constitution).
         e) companion object agrupa ability() y modifier() como métodos
            estáticos (compartidos por todas las instancias).

    IV. PROGRAMA PRINCIPAL (main)
        a) Crear una instancia: val character = DndCharacter().
        b) Acceder a las propiedades e imprimirlas una por una.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ @file:Suppress("SpellCheckingInspection")                                │
    │                                                                          │
    │ import kotlin.math.floor                                                 │
    │                                                                          │
    │ class DndCharacter {                                                     │
    │                                                                          │
    │     val strength: Int = ability()                                        │
    │     val dexterity: Int = ability()                                       │
    │     val constitution: Int = ability()                                    │
    │     val intelligence: Int = ability()                                    │
    │     val wisdom: Int = ability()                                          │
    │     val charisma: Int = ability()                                        │
    │     val hitpoints: Int = 10 + modifier(constitution)                     │
    │                                                                          │
    │     companion object {                                                   │
    │                                                                          │
    │         fun ability(): Int {                                             │
    │             val stats = Array(4) { (1..6).random() }.toList()            │
    │             val totalSum = stats.sorted().drop(1).sum()                  │
    │             return totalSum                                              │
    │         }                                                               │
    │                                                                          │
    │         fun modifier(score: Int): Int {                                  │
    │             val modified = floor((score - 10).toDouble() / 2).toInt()    │
    │             return modified                                              │
    │         }                                                               │
    │     }                                                                   │
    │ }                                                                       │
    │                                                                          │
    │ fun main() {                                                             │
    │     val character = DndCharacter()                                       │
    │     println("Strength: ${character.strength}")                           │
    │     println("Dexterity: ${character.dexterity}")                         │
    │     println("Constitution: ${character.constitution}")                   │
    │     println("Intelligence: ${character.intelligence}")                   │
    │     println("Wisdom: ${character.wisdom}")                               │
    │     println("Charisma: ${character.charisma}")                           │
    │     println("Hitpoints: ${character.hitpoints}")                         │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   @file:Suppress("SpellCheckingInspection")
         └── Anotación que suprime advertencias del corrector ortográfico.
         └── No afecta la ejecución, solo evita warnings en el IDE.

    II.  import kotlin.math.floor
         └── Importa la función floor() del paquete kotlin.math.
         └── floor() redondea un número decimal hacia abajo (piso).
         └── floor(3.7) → 3.0, floor(-2.3) → -3.0

    III. class
         └── Palabra reservada que define una CLASE (molde para objetos).
         └── Analogía: un molde para galletas — defines la forma una vez y
             puedes crear muchas galletas (objetos) con ese molde.

    IV.  DndCharacter
         └── Nombre de la clase (mayúscula inicial por convención).
         └── Cada objeto creado con DndCharacter() es un personaje distinto.

    V.   val
         └── Palabra reservada para declarar variable INMUTABLE (solo lectura).
         └── Una vez asignada, no se puede cambiar.
         └── Analogía: una placa grabada en piedra.

    VI.  strength / dexterity / constitution / intelligence / wisdom / charisma
         └── Nombres de las propiedades del personaje (sus habilidades).
         └── Cada una es de tipo Int (entero de 32 bits).

    VII. : Int
         └── Declaración explícita del tipo de dato.
         └── strength: Int → "strength es de tipo Int".

    VIII. = ability()
          └── = (asignación): guarda el valor devuelto por ability() en la propiedad.
          └── ability(): llama a la función del companion object.
          └── Cada propiedad se inicializa con una tirada de dados independiente.

    IX.  hitpoints: Int = 10 + modifier(constitution)
         └── hitpoints es una propiedad CALCULADA.
         └── 10 + modifier(constitution): suma 10 al modificador de constitution.
         └── constitution se refiere a la propiedad del mismo objeto (this.constitution).
         └── Como constitution ya se inicializó antes, está disponible.

    X.   companion object { ... }
         └── Bloque especial dentro de una clase.
         └── Los miembros dentro son ESTÁTICOS: pertenecen a la clase, no a las
             instancias.
         └── No necesitas crear un objeto para llamarlos: DndCharacter.ability().
         └── Analogía: el manual de instrucciones de la fábrica de muñecos —
             todos los muñecos siguen el mismo manual.

    XI.  fun
         └── Palabra reservada para definir una FUNCIÓN.
         └── Analogía: una receta de cocina.

    XII. ability
         └── Nombre de la función que simula la tirada de dados.

    XIII. ( )
          └── Paréntesis vacíos: la función no recibe parámetros.

    XIV. : Int
         └── Tipo de retorno: la función devuelve un Int.

    XV.  val stats = Array(4) { (1..6).random() }.toList()
         └── Array(4) { ... }: crea un arreglo de 4 elementos.
         └── { (1..6).random() }: lambda que se ejecuta 4 veces, generando un
             número aleatorio del 1 al 6 cada vez.
         └── (1..6): rango del 1 al 6 inclusive.
         └── .random(): método que devuelve un elemento aleatorio del rango.
         └── .toList(): convierte el Array a List (más fácil de manipular).
         └── Analogía: lanzar 4 dados en una mesa y anotar los resultados.

    XVI. stats.sorted()
         └── .sorted(): método que ordena la lista de menor a mayor.
         └── Ej: [3, 6, 1, 5] → [1, 3, 5, 6]
         └── Esto deja el valor más pequeño en la primera posición.

    XVII. .drop(1)
          └── Método que descarta los primeros n elementos de la lista.
          └── .drop(1): elimina el primer elemento (el dado más bajo).
          └── [1, 3, 5, 6].drop(1) → [3, 5, 6]

    XVIII. .sum()
           └── Método que suma todos los elementos de la lista.
           └── [3, 5, 6].sum() → 14

    XIX. return totalSum
         └── return: devuelve el valor calculado al lugar donde se llamó.
         └── totalSum: la suma de los 3 dados más altos.

    XX.  modifier(score: Int)
         └── Segunda función, RECIBE un parámetro.
         └── score: nombre del parámetro (el puntaje de habilidad).
         └── : Int — tipo del parámetro.

    XXI. floor((score - 10).toDouble() / 2).toInt()
         └── score - 10: resta 10 al puntaje (puede dar negativo).
         └── .toDouble(): convierte el resultado a Double (decimal).
         └── / 2: división decimal entre 2.
         └── floor(...): redondea hacia abajo.
         └── .toInt(): convierte el Double resultante a Int (trunca decimales).
         └── Ej: score=15 → (15-10)=5 → 5.0/2=2.5 → floor(2.5)=2.0 → 2

    XXII. fun main()
          └── Función principal: punto de entrada del programa.
          └── Kotlin ejecuta main() automáticamente.

    XXIII. val character = DndCharacter()
           └── Crea una INSTANCIA de la clase DndCharacter.
           └── character: variable que guarda la referencia al objeto.
           └── DndCharacter(): llamada al constructor; ejecuta todas las
               inicializaciones (las 6 tiradas de dados + hitpoints).

    XXIV. println("...")
          └── Función que imprime texto en consola y añade salto de línea.

    XXV. "${character.strength}"
         └── Interpolación de cadenas (String templates).
         └── ${...}: evalúa la expresión y la convierte a texto.
         └── character.strength: accede a la propiedad strength del objeto.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE PersonajeD&D:
        PROPIEDADES (inmutables):
            fuerza: Entero = habilidad()
            destreza: Entero = habilidad()
            constitucion: Entero = habilidad()
            inteligencia: Entero = habilidad()
            sabiduria: Entero = habilidad()
            carisma: Entero = habilidad()
            puntosVida: Entero = 10 + modificador(constitucion)

        COMPAÑERO (métodos estáticos):
            FUNCION habilidad(): Entero
                estadisticas = ARREGLO(4) { ALEATORIO(1..6) }
                estadisticas = CONVERTIR_A_LISTA(estadisticas)
                estadisticas = ORDENAR(estadisticas)
                estadisticas = DESCARTAR_PRIMERO(estadisticas)
                suma = SUMAR(estadisticas)
                DEVOLVER suma

            FUNCION modificador(puntaje: Entero): Entero
                calculo = (puntaje - 10) / 2
                calculo = REDONDEAR_ABAJO(calculo)
                DEVOLVER calculo

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. personaje = CREAR_PersonajeD&D()
        2. IMPRIMIR "Strength: " + personaje.fuerza
        3. IMPRIMIR "Dexterity: " + personaje.destreza
        4. IMPRIMIR "Constitution: " + personaje.constitucion
        5. IMPRIMIR "Intelligence: " + personaje.inteligencia
        6. IMPRIMIR "Wisdom: " + personaje.sabiduria
        7. IMPRIMIR "Charisma: " + personaje.carisma
        8. IMPRIMIR "Hitpoints: " + personaje.puntosVida

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: ability() — una tirada de ejemplo

        Proceso:
            Array(4) { (1..6).random() } → [3, 6, 1, 5] (valores hipotéticos)
            .toList() → [3, 6, 1, 5]
            .sorted() → [1, 3, 5, 6]    (orden ascendente)
            .drop(1) → [3, 5, 6]        (se descarta el 1)
            .sum() → 3 + 5 + 6 = 14
        Resultado: 14
        └── Los valores reales son aleatorios, pero la lógica siempre es la misma.

    EJEMPLO 2: modifier(15) — modificador de constitution 15

        Entrada: score = 15
        Proceso:
            score - 10 = 15 - 10 = 5
            .toDouble() = 5.0
            / 2 = 2.5
            floor(2.5) = 2.0
            .toInt() = 2
        Resultado: 2
        └── Un personaje con constitution 15 tiene modificador +2.

    EJEMPLO 3: modifier(3) — modificador de constitution 3

        Entrada: score = 3
        Proceso:
            score - 10 = 3 - 10 = -7
            .toDouble() = -7.0
            / 2 = -3.5
            floor(-3.5) = -4.0  (redondea hacia abajo, NO hacia cero)
            .toInt() = -4
        Resultado: -4
        └── Un personaje con constitution 3 tiene modificador -4.

    EJEMPLO 4: hitpoints con constitution 3

        Entrada: constitution = 3
        Proceso:
            modifier(3) = -4  (del ejemplo anterior)
            hitpoints = 10 + (-4) = 6
        Resultado: 6 puntos de golpe
        └── Ejemplo del enunciado original: "Because constitution is 3,
            the constitution modifier is -4 and the hitpoints are 6."

    EJEMPLO 5: hitpoints con constitution 18

        Entrada: constitution = 18
        Proceso:
            modifier(18):
                score - 10 = 18 - 10 = 8
                8.0 / 2 = 4.0
                floor(4.0) = 4.0
                .toInt() = 4
            hitpoints = 10 + 4 = 14
        Resultado: 14 puntos de golpe
        └── Constitution máxima (18) da el modificador máximo (+4) y los
            hitpoints más altos posibles (14).
*/