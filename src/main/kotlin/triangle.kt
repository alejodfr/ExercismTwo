@file:Suppress("SpellCheckingInspection")

/*
 * Instructions
 *
 * Determine if a triangle is equilateral, isosceles, or scalene.
 *
 * - Equilateral: all three sides the same length.
 * - Isosceles:   at least two sides the same length.
 * - Scalene:     all sides of different lengths.
 *
 * Note: for a valid triangle, all sides must be > 0, and the sum of any
 * two sides must be greater than or equal to the third side:
 *
 *   a + b ≥ c
 *   b + c ≥ a
 *   a + c ≥ b
 */

class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        require( a.toDouble() > 0 && b.toDouble() >0 && c.toDouble() > 0) { "All sides mut be > 0" }
        require(
            (a.toDouble() + b.toDouble() >= c.toDouble()) &&
            (b.toDouble() + c.toDouble() >= a.toDouble()) &&
            (a.toDouble() + c.toDouble() >= b.toDouble())
        ) { "All sides must be the addition of the first equal to the third" }

    }


    val isEquilateral: Boolean
        get() = a.toDouble() == b.toDouble() && b.toDouble() == c.toDouble()

    val isIsosceles: Boolean
        get() = a.toDouble() == b.toDouble() || b.toDouble() == c.toDouble() || a.toDouble() == c.toDouble()

    val isScalene: Boolean
        get() = a.toDouble() != b.toDouble() && b.toDouble() != c.toDouble() && a.toDouble() != c.toDouble()
}

fun main(){
    // Crear triángulos de prueba
    val equilateral = Triangle(5, 5, 5)
    val isosceles = Triangle(3, 3, 5)
    val scalene = Triangle(3, 4, 5)

    // Probar isEquilateral
    println("Triangle(5,5,5) isEquilateral: ${equilateral.isEquilateral}") // true
    println("Triangle(3,3,5) isEquilateral: ${isosceles.isEquilateral}")   // false

    // Probar isIsosceles
    println("Triangle(3,3,5) isIsosceles: ${isosceles.isIsosceles}") // true
    println("Triangle(3,4,5) isIsosceles: ${scalene.isIsosceles}")   // false

    // Probar isScalene
    println("Triangle(3,4,5) isScalene: ${scalene.isScalene}") // true
    println("Triangle(3,3,5) isScalene: ${isosceles.isScalene}") // false

    // Probar con Double
    val doubleTriangle = Triangle(3.0, 4.0, 5.0)
    println("Triangle(3.0,4.0,5.0) isScalene: ${doubleTriangle.isScalene}") // true

    // Probar triángulo inválido
    try {
        val invalid = Triangle(0, 5, 5)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}") // All sides must be > 0
    }
}

/*
 * # Triangle — Guía de resolución
 *
 * ## Enunciado
 *
 * Dado un triángulo con tres lados a, b, c, determinar si es
 * equilátero, isósceles o escaleno. Además, validar que el
 * triángulo sea geométricamente válido.
 *
 * ## Orden de pensamiento
 *
 * 1. La clase recibe tres lados de tipo genérico T : Number —
 *    así funciona con Int, Double, Float, etc.
 * 2. Antes de clasificar, hay que validar que el triángulo sea válido.
 *    Esto va en init porque debe ocurrir al crear el objeto.
 * 3. Cada clasificación es una propiedad calculada con get() —
 *    se evalúa cuando la llamas, no al crear el objeto.
 *
 * ## Paso a paso
 *
 * ### La clase y sus parámetros
 *
 *   class Triangle<out T : Number>(val a: T, val b: T, val c: T)
 *
 * - <out T : Number> -> tipo genérico restringido a Number.
 *   Permite usar la clase con Int, Double, Float, etc.
 * - out -> indica que Triangle solo produce valores de tipo T.
 * - val a, b, c: T -> los tres lados del triángulo del tipo T.
 * - Como T es genérico, no se puede comparar directamente —
 *   hay que convertir con .toDouble() para operar con los lados.
 *
 * ### Validaciones en init
 *
 *   init {
 *       require(a.toDouble() > 0 && b.toDouble() > 0 && c.toDouble() > 0) { ... }
 *       require((a.toDouble() + b.toDouble() >= c.toDouble()) && ...) { ... }
 *   }
 *
 * - El init se ejecuta al crear el objeto — si el triángulo
 *   no es válido, lanza IllegalArgumentException de inmediato.
 * - Primera validación: todos los lados deben ser > 0.
 * - Segunda validación: la suma de cualquier dos lados debe ser
 *   mayor o igual al tercero (regla geométrica del triángulo).
 * - .toDouble() es necesario porque T : Number no soporta
 *   operadores de comparación o suma directamente.
 *
 * ### isEquilateral
 *
 *   val isEquilateral: Boolean
 *       get() = a.toDouble() == b.toDouble() && b.toDouble() == c.toDouble()
 *
 * - Los tres lados deben ser iguales.
 * - Se usa && porque TODAS las condiciones deben cumplirse.
 *
 * ### isIsosceles
 *
 *   val isIsosceles: Boolean
 *       get() = a.toDouble() == b.toDouble() || b.toDouble() == c.toDouble() || a.toDouble() == c.toDouble()
 *
 * - Al menos dos lados deben ser iguales.
 * - Se usa || porque BASTA con que UNA condición se cumpla.
 * - Nota: un triángulo equilátero también es isósceles.
 *
 * ### isScalene
 *
 *   val isScalene: Boolean
 *       get() = a.toDouble() != b.toDouble() && b.toDouble() != c.toDouble() && a.toDouble() != c.toDouble()
 *
 * - Todos los lados deben ser diferentes.
 * - Se usa && porque TODOS deben ser distintos entre sí.
 * - Se necesitan las tres comparaciones: a!=b, b!=c, a!=c.
 *   Solo a!=b && b!=c no es suficiente — podrían ser a==c.
 *
 * ## Código completo
 *
 *   class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
 *
 *       init {
 *           require(a.toDouble() > 0 && b.toDouble() > 0 && c.toDouble() > 0) { "All sides must be > 0" }
 *           require(
 *               (a.toDouble() + b.toDouble() >= c.toDouble()) &&
 *               (b.toDouble() + c.toDouble() >= a.toDouble()) &&
 *               (a.toDouble() + c.toDouble() >= b.toDouble())
 *           ) { "Invalid triangle" }
 *       }
 *
 *       val isEquilateral: Boolean
 *           get() = a.toDouble() == b.toDouble() && b.toDouble() == c.toDouble()
 *
 *       val isIsosceles: Boolean
 *           get() = a.toDouble() == b.toDouble() || b.toDouble() == c.toDouble() || a.toDouble() == c.toDouble()
 *
 *       val isScalene: Boolean
 *           get() = a.toDouble() != b.toDouble() && b.toDouble() != c.toDouble() && a.toDouble() != c.toDouble()
 *   }
 */