@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 *
 * Calculate the points scored in a single toss of a Darts game.
 *
 * Darts is a game where players throw darts at a target.
 * The target rewards 4 different amounts of points,
 * depending on where the dart lands:
 *
 *   - Outside the target:        0 points
 *   - Outer circle (radius 10):  1 point
 *   - Middle circle (radius 5):  5 points
 *   - Inner circle (radius 1):  10 points
 *
 * All circles are concentric, centered at (0, 0).
 *
 * Given a point (x, y), calculate the correct score earned
 * by a dart landing at that point.
 */

object Darts {

    fun score(x: Number, y: Number ): Int {
        var firstCordinate = x
        var secondCordinate = y
        var distance = Math.sqrt(Math.pow(firstCordinate.toDouble(), 2.0) + Math.pow(secondCordinate.toDouble(), 2.0))
        if (distance<=1){
            return 10
        } else if (distance<=5){
            return 5
        } else if (distance<=10){
            return 1
        } else {
            return 0
        }

    }
}

fun main(){
    println("Enter the x coordinate")
    val x = readLine()
    println("Enter the y coordinate")
    val y = readLine()
    println("The score is ${Darts.score(x.toString().toDouble(), y.toString().toDouble())}")
}

/**
 * ╔══════════════════════════════════════════════════════════════╗
 * ║        GUÍA DE ESTUDIO — Darts.kt (Puntuación de Dardos)   ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * ────────────────────────────────────────────────────────────
 *  CÓDIGO ANOTADO (Árbol de análisis línea por línea)
 * ────────────────────────────────────────────────────────────
 *
 * object Darts {                                       ──► Define un objeto singleton llamado Darts
 * │                                                         (una única instancia, como un módulo)
 * │
 * └── fun score(x: Number, y: Number): Int {            ──► Función que recibe dos coordenadas (x, y)
 *     │                                                     como Number (Int o Double) y devuelve Int
 *     │
 *     ├── var firstCordinate = x                        ──► Guarda x en una variable mutable
 *     ├── var secondCordinate = y                       ──► Guarda y en una variable mutable
 *     │
 *     ├── var distance = Math.sqrt(                     ──► Calcula la distancia al centro (0,0)
 *     │   │   Math.pow(firstCordinate.toDouble(), 2.0)  ──► x²  (convierte a Double)
 *     │   │   +                                         ──► +
 *     │   │   Math.pow(secondCordinate.toDouble(), 2.0) ──► y²
 *     │   )                                             ──► √(x² + y²)  → teorema de Pitágoras
 *     │
 *     ├── if (distance <= 1) {                          ──► ¿Círculo interno? (radio ≤ 1)
 *     │   │   return 10                                 ──► 10 puntos
 *     │   └── }
 *     │
 *     ├── else if (distance <= 5) {                     ──► ¿Círculo medio? (radio ≤ 5)
 *     │   │   return 5                                  ──► 5 puntos
 *     │   └── }
 *     │
 *     ├── else if (distance <= 10) {                    ──► ¿Círculo externo? (radio ≤ 10)
 *     │   │   return 1                                  ──► 1 punto
 *     │   └── }
 *     │
 *     └── else {                                        ──► Fuera del blanco (radio > 10)
 *             return 0                                  ──► 0 puntos
 *         }
 *     }
 * }
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE PALABRAS RESERVADAS
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────────┬────────────────────────────────────────────┐
 *  │  Palabra     │  Significado                               │
 *  ├──────────────┼────────────────────────────────────────────┤
 *  │  object      │  Declara un singleton (objeto único)       │
 *  │  fun         │  Define una función / método               │
 *  │  var         │  Declara variable mutable (se puede reasig)│
 *  │  val         │  Declara variable inmutable (no cambia)    │
 *  │  if          │  Condicional: si se cumple la condición    │
 *  │  else        │  Sino (alternativa cuando no se cumple)    │
 *  │  else if     │  Sino si (nueva condición si la anterior   │
 *  │              │  fue falsa)                                │
 *  │  return      │  Devuelve un valor y termina la función    │
 *  │  Int         │  Tipo número entero (32 bits)              │
 *  │  Number      │  Tipo padre de Int, Double, Float, etc.    │
 *  └──────────────┴────────────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE OPERADORES IMPORTANTES
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────┬──────────┬─────────────────────────────────────┐
 *  │ Operador │  Uso     │  Explicación                        │
 *  ├──────────┼──────────┼─────────────────────────────────────┤
 *  │  <=      │ a <= b   │  Menor o igual que                  │
 *  │  -       │ a - b    │  Resta                              │
 *  │  .       │ a.b()    │  Llamar método / acceder propiedad  │
 *  │  ->      │ args ->  │  Lambda (función anónima)           │
 *  └──────────┴──────────┴─────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  RESUMEN ALGORÍTMICO
 * ────────────────────────────────────────────────────────────
 *
 *  PSEUDOCÓDIGO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  función score(x, y):                                  │
 *  │      distancia ← √(x² + y²)                            │
 *  │      SI distancia ≤ 1  → devolver 10                   │
 *  │      SI NO SI distancia ≤ 5 → devolver 5               │
 *  │      SI NO SI distancia ≤ 10 → devolver 1              │
 *  │      SI NO → devolver 0                                │
 *  └─────────────────────────────────────────────────────────┘
 *
 *  EJEMPLO TRABAJADO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  Entrada: x = 0, y = 3                                 │
 *  │                                                         │
 *  │  Paso 1: calcular distancia                            │
 *  │    Math.sqrt(0² + 3²) = Math.sqrt(0 + 9) = √9 = 3      │
 *  │                                                         │
 *  │  Paso 2: evaluar condiciones                           │
 *  │    ¿3 ≤ 1? → NO                                        │
 *  │    ¿3 ≤ 5? → SÍ → devolver 5                           │
 *  │                                                         │
 *  │  Resultado: 5 puntos (círculo medio)                   │
 *  └─────────────────────────────────────────────────────────┘
 */