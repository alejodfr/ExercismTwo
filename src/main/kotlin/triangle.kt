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
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Determinar si un triángulo es equilátero, isósceles o escaleno según
    las longitudes de sus tres lados.

    REGLAS DE VALIDEZ:
    - Todos los lados deben ser > 0.
    - La suma de dos lados cualesquiera debe ser ≥ al tercero (desigualdad
      triangular): a + b ≥ c, b + c ≥ a, a + c ≥ b.

    OBJETIVOS:
    I.   Crear una clase Triangle con tipo genérico numérico <T : Number>.
    II.  Validar en el constructor (init) que los lados cumplan las reglas.
    III. Propiedad isEquilateral: true si todos los lados son iguales.
    IV.  Propiedad isIsosceles: true si al menos dos lados son iguales.
    V.   Propiedad isScalene: true si todos los lados son diferentes.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. DISENO DE LA CLASE
       └── Necesitamos una clase que almacene tres lados (a, b, c).
       └── Usamos <out T : Number> para que acepte Int, Double, etc.
       └── Los lados son propiedades val (inmutables) de tipo T.

    II. VALIDACION DE LOS LADOS
        a) Lados positivos: require(a > 0 && b > 0 && c > 0)
        b) Desigualdad triangular: require(a + b >= c && b + c >= a && a + c >= b)
        c) require lanza IllegalArgumentException si la condición es false.
        d) Convertimos a Double con .toDouble() para poder comparar tipos mixtos.

    III. CLASIFICACION DEL TRIANGULO
         a) Equilátero: a == b && b == c (todos iguales)
         b) Isósceles: a == b || b == c || a == c (al menos dos iguales)
         c) Escaleno: a != b && b != c && a != c (todos diferentes)
         d) Cada una es una propiedad calculada con get() personalizado.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ class Triangle<out T : Number>(val a: T, val b: T, val c: T) {          │
    │     init {                                                               │
    │         require(a.toDouble() > 0 && b.toDouble() > 0 &&                  │
    │                 c.toDouble() > 0) { "All sides must be > 0" }            │
    │         require(                                                        │
    │             (a.toDouble() + b.toDouble() >= c.toDouble()) &&             │
    │             (b.toDouble() + c.toDouble() >= a.toDouble()) &&             │
    │             (a.toDouble() + c.toDouble() >= b.toDouble())                │
    │         ) { "Inequality violation" }                                     │
    │     }                                                                    │
    │     val isEquilateral: Boolean                                           │
    │         get() = a.toDouble() == b.toDouble() &&                          │
    │                 b.toDouble() == c.toDouble()                             │
    │     val isIsosceles: Boolean                                             │
    │         get() = a.toDouble() == b.toDouble() ||                          │
    │                 b.toDouble() == c.toDouble() ||                          │
    │                 a.toDouble() == c.toDouble()                             │
    │     val isScalene: Boolean                                               │
    │         get() = a.toDouble() != b.toDouble() &&                          │
    │                 b.toDouble() != c.toDouble() &&                          │
    │                 a.toDouble() != c.toDouble()                             │
    │ }                                                                        │
    │ fun main() { /* pruebas */ }                                             │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   class
         └── Palabra reservada que define una "clase" (molde/plantilla).
         └── Analogía: un molde para hacer galletas — defines la forma una vez
             y creas muchas galletas (objetos).

    II.  Triangle
         └── Nombre de la clase. Convención: mayúscula inicial (PascalCase).

    III. <out T : Number>
         └── Parámetro de tipo genérico.
         └── < > : indican que es una clase genérica (parametrizada por tipo).
         └── T : nombre del parámetro de tipo (convención: letra mayúscula).
         └── : Number : restricción de tipo superior — T solo puede ser Number
             o una subclase (Int, Double, Long, Float, etc.).
         └── out : "covarianza". Significa que la clase PRODUCE valores de tipo
             T (no los consume). Permite tratar Triangle<Int> como Triangle<Number>.
             └── Analogía: un productor de huevos puede dar huevos de gallina
                 (subclase) donde se esperan huevos en general (superclase).

    IV.  (val a: T, val b: T, val c: T)
         └── Parámetros del constructor primario + propiedades declaradas.
         └── val : la propiedad es de solo lectura (inmutable).
         └── a, b, c : los tres lados del triángulo.
         └── : T : tipo genérico — puede ser Int, Double, etc.

    V.   init
         └── Bloque de inicialización. Se ejecuta INMEDIATAMENTE después de
             que el constructor primario asigna las propiedades.
         └── Sirve para validar los datos o hacer cálculos iniciales.
         └── Analogía: la inspección de calidad al salir de la fábrica.

    VI.  require(condición) { "mensaje" }
         └── Función de Kotlin: valida una condición.
         └── Si la condición es false → lanza IllegalArgumentException con el
             mensaje dado.
         └── Analogía: un guardia de seguridad que no deja pasar si no cumples
             los requisitos.

    VII. .toDouble()
         └── Método de extensión: convierte cualquier Number a Double.
         └── Necesario porque T : Number no garantiza que los operadores >,
             +, == funcionen directamente (se resuelven en tiempo de compilación).

    VIII. > 0 , >=
          └── > : operador "mayor que". Compara dos números.
          └── >= : operador "mayor o igual que".
          └── Ambos devuelven un Boolean (true o false).

    IX.  &&
         └── Operador lógico AND ("Y").
         └── Devuelve true solo si AMBAS condiciones son true.
         └── true && true = true; cualquier otra combinación = false.

    X.   ||
         └── Operador lógico OR ("O").
         └── Devuelve true si AL MENOS UNA condición es true.
         └── false || true = true; false || false = false.

    XI.  + (suma)
         └── Operador aritmético: suma dos números.
         └── a.toDouble() + b.toDouble() → suma de los lados para la
             desigualdad triangular.

    XII. val isEquilateral: Boolean
         └── Declaración de propiedad con tipo explícito Boolean.
         └── isEquilateral : nombre (convención: "is" + adjetivo).
         └── Analogía: una característica del triángulo que se puede consultar:
             "¿eres equilátero?"

    XIII. get() = ...
          └── Getter personalizado (propiedad calculada).
          └── No almacena el valor; lo calcula cada vez que se accede.
          └── = expresión : "cuerpo-expresión" — devuelve el resultado directo.
          └── Analogía: una báscula — no guarda tu peso, lo calcula al subirte.

    XIV. == (igualdad)
         └── Operador de igualdad estructural: compara VALORES.
         └── a.toDouble() == b.toDouble() → true si los valores son iguales.
         └── En Kotlin, == llama internamente a equals().

    XV. != (diferencia)
        └── Operador "diferente de": true si los valores NO son iguales.

    XVI. != , == en isScalene
         └── isScalene requiere que TODOS los lados sean diferentes.
         └── a != b && b != c && a != c : las tres diferencias deben cumplirse.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE Triangulo< T : Numero >(a: T, b: T, c: T)
        AL CREAR:
            SI a <= 0 O b <= 0 O c <= 0:
                LANZAR ERROR "Todos los lados deben ser > 0"
            FIN SI
            SI a + b < c O b + c < a O a + c < b:
                LANZAR ERROR "No cumple la desigualdad triangular"
            FIN SI
        FIN AL CREAR

        PROPIEDAD esEquilatero: Booleano
            OBTENER = a == b Y b == c

        PROPIEDAD esIsosceles: Booleano
            OBTENER = a == b O b == c O a == c

        PROPIEDAD esEscaleno: Booleano
            OBTENER = a != b Y b != c Y a != c
    FIN CLASE

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Triangle(3, 4, 5) — triángulo escaleno válido

        Validación:
            require(3 > 0 && 4 > 0 && 5 > 0)        → true ✓
            require(3+4 >= 5 && 4+5 >= 3 && 3+5 >= 4) → true ✓
        Clasificación:
            isEquilateral: 3==4? NO, 4==5? NO       → false
            isIsosceles:    3==4? NO, 4==5? NO, 3==5? NO → false
            isScalene:      3!=4? SI, 4!=5? SI, 3!=5? SI → true
        Resultado: ESCALENO

    EJEMPLO 2: Triangle(5, 5, 5) — triángulo equilátero

        Validación:
            require(5 > 0 && 5 > 0 && 5 > 0) → true ✓
            require(5+5 >= 5 && 5+5 >= 5 && 5+5 >= 5) → true ✓
        Clasificación:
            isEquilateral: 5==5 Y 5==5 → true ✓
            isIsosceles:   5==5? SI (al menos dos iguales) → true
            isScalene:     5!=5? NO → false
        Resultado: EQUILATERO

    EJEMPLO 3: Triangle(0, 5, 5) — triángulo INVALIDO (lado = 0)

        Validación:
            require(0 > 0 && 5 > 0 && 5 > 0)
            └── 0 > 0 es FALSE → lanza IllegalArgumentException
        Resultado: EXCEPCION "All sides must be > 0"
        └── El objeto NO se crea; el programa lanza un error.

    EJEMPLO 4: Triangle(1, 1, 3) — triángulo INVALIDO (desigualdad)

        Validación:
            require(1 > 0 && 1 > 0 && 3 > 0) → true ✓
            require(1+1 >= 3 && ...)
            └── 1+1 >= 3 → 2 >= 3 → FALSE → lanza excepción
        Resultado: EXCEPCION "No cumple desigualdad triangular"
*/