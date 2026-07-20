@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 *
 * Find the difference between the square of the sum and the sum of the squares of the first N natural numbers.
 *
 * The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)² = 55² = 3025.
 *
 * The sum of the squares of the first ten natural numbers is 1² + 2² + ... + 10² = 385.
 *
 * Hence the difference between the square of the sum of the first ten natural numbers and the sum of the
 * squares of the first ten natural numbers is 3025 - 385 = 2640.
 *
 * You are not expected to discover an efficient solution to this yourself from first principles; research
 * is allowed, indeed, encouraged. Finding the best algorithm for the problem is a key skill in software
 * engineering.
 */

class Squares(private val n: Int) {
    fun squareOfSum() = (1..n).sum().let { it * it }
    fun sumOfSquares() = (1..n).map { it * it }.sum()
    fun difference() = squareOfSum() - sumOfSquares()
}

fun main() {
    val squares = Squares(10)
    println("square of sum:    ${squares.squareOfSum()}")   // 3025
    println("sum of squares:   ${squares.sumOfSquares()}")  // 385
    println("difference:       ${squares.difference()}")    // 2640
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Calcular la diferencia entre el cuadrado de la suma y la suma de los
    cuadrados de los primeros N números naturales.

    OBJETIVOS:
    I.   Crear una clase Squares que reciba un entero positivo n.
    II.  squareOfSum(): calcular (1 + 2 + ... + n)².
    III. sumOfSquares(): calcular 1² + 2² + ... + n².
    IV.  difference(): restar sumOfSquares() de squareOfSum().

    Ejemplo con n = 10:
      squareOfSum()  = (1 + 2 + ... + 10)² = 55² = 3025
      sumOfSquares() = 1² + 2² + ... + 10² = 385
      difference()   = 3025 - 385 = 2640

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I.  ANALISIS DEL PROBLEMA
        └── Entrada: un entero n (a través del constructor de la clase).
        └── Salida: tres cálculos enteros.
        └── Fórmulas matemáticas conocidas:
              squareOfSum  = (Σᵢ₌₁ⁿ i)²
              sumOfSquares = Σᵢ₌₁ⁿ i²

    II. DISENO DE LA CLASE
        a) Declarar class Squares(private val n: Int)
           └── private val n: el número se almacena como propiedad privada.
        b) Tres métodos públicos sin parámetros.
        c) Aprovechar ranges de Kotlin (1..n) para iterar.

    III. IMPLEMENTACION
        a) squareOfSum(): sumar 1..n con .sum(), luego elevar al cuadrado.
        b) sumOfSquares(): mapear cada número a su cuadrado y sumar.
        c) difference(): restar sumOfSquares() de squareOfSum().

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ class Squares(private val n: Int) {                                     │
    │     fun squareOfSum() = (1..n).sum().let { it * it }                    │
    │     fun sumOfSquares() = (1..n).map { it * it }.sum()                   │
    │     fun difference() = squareOfSum() - sumOfSquares()                   │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   class
         └── Palabra reservada: declara una "clase" — un molde para crear
             objetos.
         └── Analogía: el plano de una casa — defines la estructura una vez
             y luego puedes construir muchas casas iguales.

    II.  Squares
         └── Nombre de la clase. Por convención en Kotlin usa PascalCase
             (mayúscula inicial).

    III. (private val n: Int)
         └── Constructor primario: parámetros que se pasan al crear una
             instancia.
         └── private: el parámetro solo es accesible dentro de la clase.
         └── val: inmutable — su valor no puede cambiar después de asignarse.
         └── n: nombre del parámetro.
         └── Int: tipo entero de 32 bits.
         └── Analogía: al encargar una pizza, dices el tamaño — "n" es el
             tamaño de la pizza y se queda fijo.

    IV.  (1..n)
         └── Range (rango) en Kotlin: una secuencia de números enteros
             desde 1 hasta n (inclusive).
         └── .. : operador "hasta" — crea un IntRange.
         └── Si n = 10, (1..n) representa [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
         └── Analogía: una fila numerada de asientos del 1 al n.

    V.   .sum()
         └── Función de extensión sobre colecciones numéricas.
         └── Suma todos los elementos del rango y devuelve el total.
         └── (1..10).sum() = 1 + 2 + ... + 10 = 55

    VI.  .let { it * it }
         └── let: función de scope que toma el objeto receptor como
             argumento (it) y ejecuta el bloque.
         └── it: nombre implícito del parámetro (el resultado de sum()).
         └── it * it: eleva al cuadrado (multiplica el número por sí mismo).
         └── Alternativa: podría escribirse como (1..n).sum().let { cuadrado ->
             cuadrado * cuadrado }.
         └── Analogía: "toma el resultado, llámalo 'it' y haz esto con él".

    VII. .map { it * it }
         └── map: función de transformación — aplica una operación a CADA
             elemento de la colección y devuelve una nueva lista.
         └── it: cada elemento individual del rango (1, luego 2, luego 3...).
         └── it * it: calcula el cuadrado de cada número.
         └── (1..3).map { it * it } → [1, 4, 9]
         └── Analogía: una máquina que recibe números y devuelve sus
             cuadrados — como una calculadora de cuadrados en serie.

    VIII. squareOfSum() = (1..n).sum().let { it * it }
          └── Declaración de función con expresión body (usa = en lugar de {}).
          └── No necesita return; el valor de la expresión es el resultado.
          └── Equivalente a:
              fun squareOfSum(): Int {
                  return (1..n).sum().let { it * it }
              }

    IX.  sumOfSquares() = (1..n).map { it * it }.sum()
         └── Encadenamiento de funciones: map() devuelve una lista,
             sum() suma esa lista.
         └── Flujo: rango → lista de cuadrados → suma total.

    X.   difference() = squareOfSum() - sumOfSquares()
         └── Llama a los otros dos métodos y resta sus resultados.
         └── Muestra la reutilización de código dentro de la misma clase.

    XI.  fun main()
         └── Punto de entrada del programa.
         └── Crea una instancia de Squares con n = 10.
         └── Llama a cada método e imprime los resultados.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE CuadradoDeLaSuma(n):
        METODO cuadradoDeLaSuma():
            suma = SUMAR(1..n)
            DEVOLVER suma * suma

        METODO sumaDeCuadrados():
            cuadrados = MAP(1..n) { numero → numero * numero }
            DEVOLVER SUMAR(cuadrados)

        METODO diferencia():
            DEVOLVER cuadradoDeLaSuma() - sumaDeCuadrados()

    ───────────────────────────────────────────────────────────────────────────

    ALGORITMO PASO A PASO:
    1. Crear la clase Squares que almacena n como propiedad privada.
    2. Para squareOfSum():
       a. Generar el rango de 1 a n.
       b. Sumar todos los números del rango.
       c. Elevar esa suma al cuadrado.
       d. Devolver el resultado.
    3. Para sumOfSquares():
       a. Generar el rango de 1 a n.
       b. Para cada número, calcular su cuadrado.
       c. Sumar todos los cuadrados.
       d. Devolver el resultado.
    4. Para difference():
       a. Llamar a squareOfSum() y restarle sumOfSquares().
       b. Devolver el resultado.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Squares(10).squareOfSum()

        n = 10
        Rango: 1..10

        sum() paso a paso:
          1 + 2 = 3
          3 + 3 = 6
          6 + 4 = 10
          10 + 5 = 15
          15 + 6 = 21
          21 + 7 = 28
          28 + 8 = 36
          36 + 9 = 45
          45 + 10 = 55

        let { it * it }: 55 * 55 = 3025

        Resultado: 3025 ✓

    EJEMPLO 2: Squares(10).sumOfSquares()

        n = 10
        Rango: 1..10

        map { it * it }:
          1 → 1² = 1
          2 → 2² = 4
          3 → 3² = 9
          4 → 4² = 16
          5 → 5² = 25
          6 → 6² = 36
          7 → 7² = 49
          8 → 8² = 64
          9 → 9² = 81
          10 → 10² = 100

        Lista resultante: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

        sum():
          1 + 4 = 5
          5 + 9 = 14
          14 + 16 = 30
          30 + 25 = 55
          55 + 36 = 91
          91 + 49 = 140
          140 + 64 = 204
          204 + 81 = 285
          285 + 100 = 385

        Resultado: 385 ✓

    EJEMPLO 3: Squares(10).difference()

        squareOfSum() = 3025
        sumOfSquares() = 385

        3025 - 385 = 2640

        Resultado: 2640 ✓

    ───────────────────────────────────────────────────────────────────────────

    EJEMPLO 4: Squares(1) — caso mínimo

        n = 1

        squareOfSum():
          (1..1).sum() = 1
          1 * 1 = 1

        sumOfSquares():
          (1..1).map { it * it } = [1]
          .sum() = 1

        difference() = 1 - 1 = 0

        Resultados: 1, 1, 0 ✓
        Explicación: con un solo número, la suma y el cuadrado coinciden.

    EJEMPLO 5: Squares(5)

        n = 5

        squareOfSum():
          (1 + 2 + 3 + 4 + 5) = 15
          15² = 225

        sumOfSquares():
          1² + 2² + 3² + 4² + 5² = 1 + 4 + 9 + 16 + 25 = 55

        difference() = 225 - 55 = 170

        Resultados: 225, 55, 170 ✓

    ───────────────────────────────────────────────────────────────────────────

    EJEMPLO 6: Squares(0) — caso límite

        n = 0

        (1..0) es un rango vacío (1 es mayor que 0).

        squareOfSum():
          .sum() = 0
          0 * 0 = 0

        sumOfSquares():
          .map { it * it } = []  (lista vacía)
          .sum() = 0

        difference() = 0 - 0 = 0

        Resultados: 0, 0, 0 ✓
*/

