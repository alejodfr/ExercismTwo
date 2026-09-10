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

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular los puntos obtenidos en un lanzamiento de dardos según
 *      la distancia del punto (x, y) al centro (0, 0) del blanco.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Calcular la distancia del punto al origen usando el
 *           teorema de Pitágoras: distancia = raíz(x² + y²).
 *      II.  Comparar esa distancia contra los radios 1, 5 y 10, en
 *           orden creciente.
 *      III. Devolver 10, 5, 1 o 0 según en qué círculo cayó el dardo.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun score(x: Number, y: Number): Int {
 *      ①  Number acepta cualquier tipo numérico (Int, Double, ...).
 *
 *      →      var distance = Math.sqrt(Math.pow(firstCordinate.toDouble(), 2.0) + Math.pow(secondCordinate.toDouble(), 2.0))
 *      ②  Math.pow(v, 2.0) eleva al cuadrado; Math.sqrt() calcula la
 *          raíz cuadrada de la suma → distancia euclidiana al origen.
 *
 *      →      if (distance<=1){
 *      →          return 10
 *      ③  Si la distancia es ≤ 1, el dardo cayó en el círculo interior.
 *
 *      →      } else if (distance<=5){
 *      →          return 5
 *      ④  Si no, pero es ≤ 5, cayó en el círculo medio.
 *
 *      →      } else if (distance<=10){
 *      →          return 1
 *      ⑤  Si no, pero es ≤ 10, cayó en el círculo exterior.
 *
 *      →      } else {
 *      →          return 0
 *      ⑥  Si no cumple ninguna condición anterior, cayó fuera del blanco.
 *      →      }
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN puntuar(x, y): Entero
 *          distancia ← RAIZ(x² + y²)
 *          SI distancia <= 1: DEVOLVER 10
 *          SINO SI distancia <= 5: DEVOLVER 5
 *          SINO SI distancia <= 10: DEVOLVER 1
 *          SINO: DEVOLVER 0
 *      FIN FUNCIÓN
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
