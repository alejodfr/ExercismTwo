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

// ▶ object Darts {
//   └▶ ① object → declara un singleton: una única instancia con nombre Darts.
object Darts {

    // ▶ fun score(x: Number, y: Number): Int {
    //   └▶ ② Number → acepta cualquier tipo numérico (Int, Double, ...).
    fun score(x: Number, y: Number ): Int {
        var firstCordinate = x
        var secondCordinate = y
        // ▶ var distance = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0))
        //   ├▶ ③ Math.pow(v, 2.0) → eleva v al cuadrado.
        //   └▶ ④ Math.sqrt(...) → raíz cuadrada de la suma = distancia
        //           euclidiana del punto al origen (0, 0).
        var distance = Math.sqrt(Math.pow(firstCordinate.toDouble(), 2.0) + Math.pow(secondCordinate.toDouble(), 2.0))
        // ▶ if (distance <= 1) { return 10 }
        //   └▶ ⑤ distancia ≤ 1 → círculo interior → 10 puntos.
        if (distance<=1){
            return 10
        // ▶ } else if (distance <= 5) { return 5 }
        //   └▶ ⑥ si no, pero ≤ 5 → círculo medio → 5 puntos.
        } else if (distance<=5){
            return 5
        // ▶ } else if (distance <= 10) { return 1 }
        //   └▶ ⑦ si no, pero ≤ 10 → círculo exterior → 1 punto.
        } else if (distance<=10){
            return 1
        // ▶ } else { return 0 }
        //   └▶ ⑧ si no cumple nada anterior → fuera del blanco → 0 puntos.
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

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular los puntos obtenidos en un lanzamiento de dardos según
 *      la distancia del punto (x, y) al centro (0, 0) del blanco.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar when { distance <= 1 -> 10; distance <= 5 -> 5; ... }
 *          en vez de la cadena if/else if.
 *      B)  Comparar el cuadrado de la distancia contra los radios al
 *          cuadrado, evitando calcular la raíz cuadrada.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "score(0, 0)"
 *      ─────────────────────────────────────────────────────────
 *      distancia = √(0²+0²) = 0 → 0 <= 1 → return 10
 *      Resultado: 10 puntos
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "score(8, 6)"
 *      ─────────────────────────────────────────────────────────
 *      distancia = √(64+36) = √100 = 10 → 10 <= 10 → return 1
 *      Resultado: 1 punto
 *
 *  ================================================================
 */
