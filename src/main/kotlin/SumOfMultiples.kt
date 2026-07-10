@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * You work for a company that makes an online, fantasy-survival game.
 * When a player finishes a level, they are awarded energy points.
 * The amount of energy awarded depends on which magical items the
 * player found while exploring that level.
 *
 * Instructions
 *
 * Your task is to write the code that calculates the energy points
 * awarded to players when they complete a level.
 *
 * The points depend on two things:
 * - The level (a number) that the player completed.
 * - The base value of each magical item collected during that level.
 *
 * Rules:
 * 1. For each magical item, take the base value and find all its
 *    multiples that are less than the level number.
 * 2. Combine the sets of numbers.
 * 3. Remove any duplicates.
 * 4. Calculate the sum of all remaining numbers.
 *
 * Example:
 * Player completed level 20 and found two items with base values 3 and 5.
 *
 * Multiples of 3 less than 20: {3, 6, 9, 12, 15, 18}
 * Multiples of 5 less than 20: {5, 10, 15}
 * Combined (duplicates removed): {3, 5, 6, 9, 10, 12, 15, 18}
 * Sum: 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78
 * Therefore, the player earns 78 energy points.
 */

object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val multiplesOfThree = mutableSetOf<Int>()
        for (factor in factors) {
            if (factor == 0){ continue }
            for (i in factor..(limit-1)) {
                if (i % factor == 0) {
                    multiplesOfThree.add(i)
                }
            }
        }
        return multiplesOfThree.sum()
    }
}

fun main(){
    val factors = setOf(3,5)
    val limit = 20
    println(SumOfMultiples.sum(factors, limit))
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Calcular los puntos de energía otorgados a un jugador al completar un
    nivel en un juego de fantasía. Los puntos dependen de los objetos
    mágicos recolectados: para cada objeto (con valor base), se toman todos
    sus múltiplos menores al número del nivel, se combinan (sin duplicados)
    y se suman.

    OBJETIVOS:
    I.   Crear un objeto singleton SumOfMultiples con un método sum.
    II.  Recibir un conjunto de factores (Set<Int>) y un límite (Int).
    III. Por cada factor, generar todos sus múltiplos < límite.
    IV.  Acumular los múltiplos en un Set para evitar duplicados.
    V.   Saltar factores igual a 0 (evitar división entre cero).
    VI.  Devolver la suma total de los múltiplos encontrados.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. ANALISIS DEL PROBLEMA
       └── Entrada: factors = {3, 5}, limit = 20
       └── Salida: 78 (suma de todos los múltiplos de 3 y 5 < 20)
       └── Restricción: cada número debe contarse UNA SOLA VEZ (sin duplicados)

    II. DISENO DE LA SOLUCION
        a) Usar un object (singleton) para agrupar la función sin necesidad
           de instanciar.
        b) La función recibe Set<Int> (factores) e Int (límite).
        c) Crear un mutableSetOf<Int>() para almacenar múltiplos sin duplicados.
        d) Recorrer cada factor con for.
        e) Si factor == 0, hacer continue (evitar división entre cero).
        f) Para cada factor, recorrer i desde factor hasta limit-1.
        g) Si i % factor == 0, agregar i al set.
        h) Al final, devolver .sum() del set.

    III. DETALLES TECNICOS
         a) .. es rango inclusivo: factor..(limit-1) = [factor, limit-1]
         b) Set.add() ignora elementos ya existentes → duplicados eliminados
         c) .sum() itera y suma todos los elementos del set

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object SumOfMultiples {                                                 │
    │     fun sum(factors: Set<Int>, limit: Int): Int {                      │
    │         val multiples = mutableSetOf<Int>()                             │
    │         for (factor in factors) {                                      │
    │             if (factor == 0) { continue }                              │
    │             for (i in factor..(limit - 1)) {                           │
    │                 if (i % factor == 0) {                                 │
    │                     multiples.add(i)                                   │
    │                 }                                                       │
    │             }                                                           │
    │         }                                                               │
    │         return multiples.sum()                                         │
    │     }                                                                   │
    │ }                                                                       │
    │ fun main() {                                                            │
    │     val factors = setOf(3, 5)                                           │
    │     val limit = 20                                                      │
    │     println(SumOfMultiples.sum(factors, limit))                        │
    │ }                                                                       │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada que declara un "objeto singleton".
         └── Crea una clase con una ÚNICA instancia global. No necesita new.
         └── Analogía: una caja de herramientas única en el taller. No la
             fabricas, solo la abres: SumOfMultiples.sum().

    II.  SumOfMultiples
         └── Nombre del objeto. Convención: PascalCase (mayúscula inicial).

    III. fun sum(factors: Set<Int>, limit: Int): Int
         └── fun : declara una función.
         └── sum : nombre de la función ("suma").
         └── factors : parámetro de tipo Set<Int>.
             └── Set : colección SIN elementos duplicados (conjunto).
             └── <Int> : parámetro de tipo — solo contiene enteros.
             └── Analogía: una bolsa de canicas donde no puede haber dos iguales.
         └── limit : parámetro de tipo Int (límite superior, exclusivo).
         └── : Int : tipo de retorno — la función devuelve un entero.

    IV.  val multiples = mutableSetOf<Int>()
         └── val : variable de solo lectura (la referencia no cambia).
         └── multiples : identificador de la variable.
         └── = : operador de asignación.
         └── mutableSetOf<Int>() : función que crea un Set mutable vacío.
             └── mutable : se puede modificar (.add(), .remove(), etc.).
             └── SetOf : "conjunto de" — sin duplicados automáticamente.
             └── <Int> : solo acepta enteros.
         └── Analogía: una mochila vacía donde iremos metiendo números; si
             intentas meter el mismo número dos veces, la mochila lo rechaza.

    V.   for (factor in factors)
         └── for : palabra reservada para bucles de iteración.
         └── factor : variable que toma el valor de cada elemento en cada vuelta.
         └── in : "en" — especifica la colección a recorrer.
         └── factors : el conjunto a iterar.
         └── Analogía: revisar cada libro en una estantería, uno por uno.

    VI.  if (factor == 0) { continue }
         └── if : condicional — ejecuta el bloque si la condición es true.
         └── factor == 0 : expresión booleana.
             └── == : operador de igualdad (compara valores).
         └── continue : salta a la siguiente iteración del bucle, ignorando
             el resto del cuerpo.
         └── ¿Por qué? Si factor = 0, i % 0 causaría ArithmeticException
             (división entre cero). continue lo evita.

    VII. for (i in factor..(limit - 1))
         └── Segundo bucle for (anidado dentro del primero).
         └── i : variable del iterador (convención: letra i para índice).
         └── in : "en" el rango especificado.
         └── factor..(limit - 1) : rango inclusivo.
             └── .. : operador de rango — crea un intervalo [inicio, fin].
             └── factor : inicio del rango.
             └── limit - 1 : fin del rango (restamos 1 porque .. es inclusivo
                 y queremos números ESTRICTAMENTE menores que limit).
             └── Analogía: una fila numerada del asiento factor al asiento
                 limit-1, incluyendo ambos extremos.

    VIII. if (i % factor == 0)
          └── if : condicional.
          └── i % factor : operador módulo — calcula el RESIDUO de i ÷ factor.
              └── % : operador de módulo/residuo.
              └── Ej: 9 % 3 = 0 (9 ÷ 3 = 3, residuo 0)
              └── Ej: 10 % 3 = 1 (10 ÷ 3 = 3, residuo 1)
          └── == 0 : si el residuo es cero → i es múltiplo exacto de factor.

    IX.  multiples.add(i)
         └── .add(i) : método del Set mutable — agrega el elemento i.
         └── Si i ya existe en el set, .add() simplemente lo ignora (no hay
             duplicados).
         └── Analogía: escribir en una lista de invitados; si alguien ya está
             anotado, no lo escribes dos veces.

    X.   return multiples.sum()
         └── return : devuelve el valor y termina la función.
         └── multiples.sum() : método de la biblioteca estándar.
             └── .sum() : suma todos los elementos numéricos de la colección.
             └── Itera internamente y acumula: 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18.

    XI.  main
         └── Función principal: punto de entrada del programa.

    XII. setOf(3, 5)
         └── Función que crea un Set INMUTABLE con los elementos dados.
         └── setOf : "conjunto de" — sin duplicados, solo lectura.

    XIII. println(SumOfMultiples.sum(factors, limit))
          └── println : imprime en consola.
          └── SumOfMultiples.sum(...) : llamada al método del singleton.
          └── factors, limit : variables definidas antes como argumentos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO SumaDeMultiplos:
        FUNCION suma(factores: Conjunto de enteros, limite: entero) → entero:
            acumulador ← CONJUNTO VACIO (mutable, sin duplicados)
            POR CADA factor EN factores:
                SI factor == 0:
                    CONTINUAR (saltar — evitar división entre cero)
                FIN SI
                PARA i DESDE factor HASTA limite - 1:
                    SI i % factor == 0:   (¿i es múltiplo de factor?)
                        acumulador.AGREGAR(i)
                    FIN SI
                FIN PARA
            FIN POR
            DEVOLVER acumulador.SUMAR()
        FIN FUNCION
    FIN OBJETO

    PROGRAMA PRINCIPAL:
        1. factores ← CONJUNTO(3, 5)
        2. limite ← 20
        3. imprimir( SumaDeMultiplos.suma(factores, limite) )

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: SumOfMultiples.sum(setOf(3, 5), 20)  — caso base

        Entrada: factors = {3, 5}, limit = 20

        Proceso:
          acumulador = {}

          factor = 3 (≠ 0 → continuar)
          ├── i=3  → 3%3=0 → agregar → acum = {3}
          ├── i=4  → 4%3=1 → no
          ├── i=5  → 5%3=2 → no
          ├── i=6  → 6%3=0 → agregar → acum = {3, 6}
          ├── i=7  → 7%3=1 → no
          ├── i=8  → 8%3=2 → no
          ├── i=9  → 9%3=0 → agregar → acum = {3, 6, 9}
          ├── i=10 → 10%3=1 → no
          ├── i=11 → 11%3=2 → no
          ├── i=12 → 12%3=0 → agregar → acum = {3, 6, 9, 12}
          ├── i=13 → 13%3=1 → no
          ├── i=14 → 14%3=2 → no
          ├── i=15 → 15%3=0 → agregar → acum = {3, 6, 9, 12, 15}
          ├── i=16 → 16%3=1 → no
          ├── i=17 → 17%3=2 → no
          ├── i=18 → 18%3=0 → agregar → acum = {3, 6, 9, 12, 15, 18}
          └── i=19 → 19%3=1 → no

          factor = 5 (≠ 0 → continuar)
          ├── i=5  → 5%5=0 → agregar → acum = {3, 5, 6, 9, 12, 15, 18}
          ├── i=6  → 6%5=1 → no
          ├── i=7  → 7%5=2 → no
          ├── i=8  → 8%5=3 → no
          ├── i=9  → 9%5=4 → no
          ├── i=10 → 10%5=0 → agregar → acum = {3, 5, 6, 9, 10, 12, 15, 18}
          ├── i=11 → 11%5=1 → no
          ├── i=12 → 12%5=2 → no
          ├── i=13 → 13%5=3 → no
          ├── i=14 → 14%5=4 → no
          ├── i=15 → 15%5=0 → ya existe, no se duplica
          ├── i=16 → 16%5=1 → no
          ├── i=17 → 17%5=2 → no
          ├── i=18 → 18%5=3 → no
          └── i=19 → 19%5=4 → no

          suma = 3+5+6+9+10+12+15+18 = 78

        Resultado: 78

    EJEMPLO 2: SumOfMultiples.sum(setOf(2), 10)  — un solo factor

        Entrada: factors = {2}, limit = 10

        Proceso:
          Múltiplos de 2 < 10: 2, 4, 6, 8
          Suma = 2 + 4 + 6 + 8 = 20

        Resultado: 20

    EJEMPLO 3: SumOfMultiples.sum(setOf(0, 3), 10)  — factor cero

        Entrada: factors = {0, 3}, limit = 10

        Proceso:
          factor = 0 → continue (salta — evita división entre cero)
          factor = 3:
            i=3 → 3%3=0 → agregar
            i=4 → 4%3=1 → no
            i=5 → 5%3=2 → no
            i=6 → 6%3=0 → agregar
            i=7 → 7%3=1 → no
            i=8 → 8%3=2 → no
            i=9 → 9%3=0 → agregar
          acumulador = {3, 6, 9}
          suma = 3+6+9 = 18

        Resultado: 18
        └── El factor 0 se ignora; no afecta el resultado.
*/