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

/**
 * ╔══════════════════════════════════════════════════════════╗
 * ║          TRIANGLE — GUÍA DE ESTUDIO COMPLETA            ║
 * ╚══════════════════════════════════════════════════════════╝
 *
 * ─────────────────────────────────────────────────────────────────────
 * 1. CÓDIGO ANOTADO (Árbol de análisis línea por línea)
 * ─────────────────────────────────────────────────────────────────────
 *
 * class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
 * │                                                          ──► class = definir clase
 * │                                                          ──► Triangle = nombre
 * │                                                          ──► <out T : Number> = genérico
 * │                                                          ──► T : Number = T solo acepta tipos numéricos
 * │                                                          ──► out = covarianza (produce T, no consume)
 * │                                                          ──► val a: T, b: T, c: T = tres lados
 * │
 *     init {                                                 ──► init = inicialización al crear objeto
 *     │
 *         require( a.toDouble() > 0 && b.toDouble() >0      ──► require() = validar condición
 *                && c.toDouble() > 0)                        ──► Si es false → IllegalArgumentException
 *         { "All sides mut be > 0" }                         ──► toDouble() = convertir a Double
 *         │                                                  ──► > 0 = lado debe ser positivo
 *         │
 *         require(                                           ──► Segunda validación
 *             (a.toDouble() + b.toDouble() >= c.toDouble())  ──► a + b >= c (desigualdad triangular)
 *             &&                                              ──► && = Y lógico, TODAS deben cumplirse
 *             (b.toDouble() + c.toDouble() >= a.toDouble())  ──► b + c >= a
 *             &&
 *             (a.toDouble() + c.toDouble() >= b.toDouble())  ──► a + c >= b
 *         ) { "All sides must be the addition..." }
 *     }
 *     │
 *     val isEquilateral: Boolean                             ──► isEquilateral = ¿es equilátero?
 *         get() = a.toDouble() == b.toDouble()               ──► get() = propiedad calculada
 *                 && b.toDouble() == c.toDouble()             ──► a == b Y b == c → todos iguales
 *     │
 *     val isIsosceles: Boolean                               ──► isIsosceles = ¿es isósceles?
 *         get() = a.toDouble() == b.toDouble()               ──► a == b (dos lados iguales)
 *                 || b.toDouble() == c.toDouble()             ──► || = O lógico, BASTA UNO
 *                 || a.toDouble() == c.toDouble()             ──► a == c (o estos dos)
 *     │
 *     val isScalene: Boolean                                 ──► isScalene = ¿es escaleno?
 *         get() = a.toDouble() != b.toDouble()               ──► a != b (diferentes)
 *                 && b.toDouble() != c.toDouble()             ──► b != c
 *                 && a.toDouble() != c.toDouble()             ──► a != c → todos diferentes
 * }
 *
 * ─────────────────────────────────────────────────────────────────────
 * 2. TABLA DE PALABRAS RESERVADAS
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────────────────────────────────────────────┐
 * │ PALABRA      │ SIGNIFICADO                                      │
 * ├──────────────┼──────────────────────────────────────────────────┤
 * │ class        │ Define una nueva clase                          │
 * │ out          │ Covarianza: la clase produce valores del tipo T  │
 * │ val          │ Propiedad de solo lectura (inmutable)            │
 * │ init         │ Bloque que se ejecuta al crear el objeto         │
 * │ get          │ Getter personalizado de una propiedad            │
 * │ require      │ Valida una condición; lanza exception si es false│
 * │ Number       │ Clase base de todos los tipos numéricos (Int,    │
 * │              │ Double, Float, Long, etc.)                       │
 * │ Boolean      │ Tipo lógico: true o false                       │
 * └──────────────┴──────────────────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 3. TABLA DE OPERADORES IMPORTANTES
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────┬───────────────────────────────────────┐
 * │ OPERADOR     │ TIPO     │ EXPLICACIÓN                           │
 * ├──────────────┼──────────┼───────────────────────────────────────┤
 * │ >            │Comparación│ "mayor que" → true si izquierda > der│
 * │ >=           │Comparación│ "mayor o igual que"                  │
 * │ ==           │Comparación│ "igual a" (compara valores)          │
 * │ !=           │Comparación│ "diferente de"                       │
 * │ &&           │ Lógico   │ "Y" → true si AMBAS condiciones true  │
 * │ ||           │ Lógico   │ "O" → true si AL MENOS UNA es true    │
 * │ +            │Aritmético│ Suma: a + b                          │
 * │ .            │ Acceso   │ Llama método: a.toDouble()            │
 * │ < >          │ Genérico │ Parámetros de tipo: <T : Number>     │
 * └──────────────┴──────────┴───────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 4. RESUMEN ALGORÍTMICO
 * ─────────────────────────────────────────────────────────────────────
 *
 * ▸ PROBLEMA: Dados 3 lados, clasificar el triángulo y validar
 *   que sea geometricamente valido.
 *
 * ▸ PSEUDOCÓDIGO:
 *
 *   CLASE Triangle (a, b, c):
 *       AL CREAR:
 *           SI a <= 0 O b <= 0 O c <= 0 → ERROR "lados deben ser > 0"
 *           SI a + b < c O b + c < a O a + c < b → ERROR "no es triangulo valido"
 *
 *       PROPIEDAD equilatero:
 *           DEVOLVER a == b Y b == c
 *
 *       PROPIEDAD isosceles:
 *           DEVOLVER a == b O b == c O a == c
 *
 *       PROPIEDAD escaleno:
 *           DEVOLVER a != b Y b != c Y a != c
 *
 * ▸ EJEMPLO: Triangle(3, 4, 5)
 *
 *   ┌─ VALIDACION ───────────────────────────────────────────────────┐
 *   │                                                                │
 *   │   require(3>0 && 4>0 && 5>0) → true ✓                         │
 *   │   require(3+4>=5 && 4+5>=3 && 3+5>=4) → true ✓               │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌─ CLASIFICACION ───────────────────────────────────────────────┐
 *   │                                                                │
 *   │   isEquilateral: 3==4? NO, 4==5? NO  → false                 │
 *   │   isIsosceles:    3==4? NO, 4==5? NO, 3==5? NO  → false      │
 *   │   isScalene:      3!=4? SI, 4!=5? SI, 3!=5? SI  → true ✓    │
 *   │                                                                │
 *   │   Resultado: ESCALENO                                          │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 *
 * ▸ EJEMPLO: Triangle(5, 5, 5)
 *
 *   ┌─ CLASIFICACION ───────────────────────────────────────────────┐
 *   │                                                                │
 *   │   isEquilateral: 5==5 Y 5==5 → true ✓                        │
 *   │   isIsosceles:  5==5? SI (al menos dos iguales) → true       │
 *   │   isScalene:    5!=5? NO → false                              │
 *   │                                                                │
 *   │   Resultado: EQUILATERO (tambien isosceles)                    │
 *   │                                                                │
 *   └────────────────────────────────────────────────────────────────┘
 */