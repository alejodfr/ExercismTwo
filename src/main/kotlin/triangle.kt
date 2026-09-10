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

// ▶ class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
//   ├▶ ① <out T : Number> → parámetro de tipo genérico restringido a
//   │       subtipos de Number (Int, Double, ...); out indica covarianza.
//   └▶ ② (val a: T, val b: T, val c: T) → los tres lados, guardados como
//           propiedades inmutables.
class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    // ▶ init {
    //   └▶ ③ bloque que se ejecuta al construir el objeto; aquí se valida.
    init {
        // ▶ require(a.toDouble() > 0 && b.toDouble() > 0 && c.toDouble() > 0) { ... }
        //   ├▶ ④ require → lanza IllegalArgumentException si la condición es false.
        //   └▶ ⑤ .toDouble() → unifica el tipo genérico para poder comparar.
        require( a.toDouble() > 0 && b.toDouble() >0 && c.toDouble() > 0) { "All sides mut be > 0" }
        // ▶ require( (a+b >= c) && (b+c >= a) && (a+c >= b) ) { ... }
        //   └▶ ⑥ desigualdad triangular: la suma de dos lados debe ser
        //           mayor o igual al tercero.
        require(
            (a.toDouble() + b.toDouble() >= c.toDouble()) &&
            (b.toDouble() + c.toDouble() >= a.toDouble()) &&
            (a.toDouble() + c.toDouble() >= b.toDouble())
        ) { "All sides must be the addition of the first equal to the third" }

    }


    // ▶ val isEquilateral: Boolean
    //   ├▶ ⑦ get() → getter calculado: se evalúa cada vez que se lee.
    //   └▶ ⑧ a == b && b == c → true solo si los tres lados son iguales.
    val isEquilateral: Boolean
        get() = a.toDouble() == b.toDouble() && b.toDouble() == c.toDouble()

    // ▶ val isIsosceles: Boolean
    //   └▶ ⑨ usa || (OR): basta con que dos lados cualesquiera coincidan.
    val isIsosceles: Boolean
        get() = a.toDouble() == b.toDouble() || b.toDouble() == c.toDouble() || a.toDouble() == c.toDouble()

    // ▶ val isScalene: Boolean
    //   └▶ ⑩ usa != y && (AND): los tres lados deben ser distintos entre sí.
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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Determinar si un triángulo es equilátero, isósceles o escaleno
 *      según las longitudes de sus tres lados, validando que forme un
 *      triángulo válido (lados positivos y desigualdad triangular).
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar un Set de los tres lados y comparar su tamaño (1 →
 *          equilátero, 2 → isósceles, 3 → escaleno) en vez de
 *          comparaciones booleanas independientes.
 *      B)  Restringir T a Double directamente (sin genéricos) si no se
 *          necesita soportar Int y Double al mismo tiempo.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Triangle(3, 4, 5)"
 *      ─────────────────────────────────────────────────────────
 *      require: 3,4,5 > 0 ✓; 3+4≥5, 4+5≥3, 3+5≥4 ✓
 *      isEquilateral: 3==4? no → false
 *      isIsosceles: 3==4? no, 4==5? no, 3==5? no → false
 *      isScalene: 3!=4 y 4!=5 y 3!=5 → true
 *      Resultado: ESCALENO
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "Triangle(0, 5, 5)"
 *      ─────────────────────────────────────────────────────────
 *      require(0 > 0 && ...) → 0 > 0 es false → lanza excepción
 *      Resultado: IllegalArgumentException("All sides mut be > 0")
 *
 *  ================================================================
 */
