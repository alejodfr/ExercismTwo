@file:Suppress("SpellCheckingInspection")


// Introduction
//
// Your body is made up of cells that contain DNA. Those cells regularly
// wear out and need replacing, which they achieve by dividing into
// daughter cells. In fact, the average human body experiences about
// 10 quadrillion cell divisions in a lifetime!
//
// When cells divide, their DNA replicates too. Sometimes during this
// process mistakes happen and single pieces of DNA get encoded with
// the incorrect information. If we compare two strands of DNA and
// count the differences between them, we can see how many mistakes
// occurred. This is known as the "Hamming distance".
//
// The Hamming distance is useful in many areas of science, not just
// biology, so it's a nice phrase to be familiar with :)
//
// Instructions
//
// Calculate the Hamming distance between two DNA strands.
//
// We read DNA using the letters C, A, G and T. Two strands might
// look like this:
//
// GAGCCTACTAACGGGAT
// CATCGTAATGACGGCCT
// ^ ^ ^  ^ ^    ^^
//
// They have 7 differences, and therefore the Hamming distance is 7.
//
// Implementation notes
//
// The Hamming distance is only defined for sequences of equal length,
// so an attempt to calculate it between sequences of different lengths
// should not work.

object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        // 1. Validamos que midan lo mismo.
        // Si no miden lo mismo, require() lanza la excepción que Exercism espera.
        require(leftStrand.length == rightStrand.length) {
            "left and right strands must be of equal length"
        }

        // 2. Abrochamos las dos cadenas en parejas y contamos las diferencias
        return leftStrand.zip(rightStrand).count { (left, right) ->
            left != right
        }
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Calcular la distancia de Hamming entre dos cadenas de ADN de
 *      igual longitud: la cantidad de posiciones donde difieren.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Validar que ambas cadenas tengan la misma longitud; si no,
 *           lanzar una excepción.
 *      II.  Emparejar ambas cadenas posición a posición con zip().
 *      III. Contar los pares donde los caracteres son distintos.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun compute(leftStrand: String, rightStrand: String): Int {
 *      →      require(leftStrand.length == rightStrand.length) {
 *      →          "left and right strands must be of equal length"
 *      →      }
 *      ①  require lanza IllegalArgumentException con el mensaje dado
 *          si las longitudes no coinciden.
 *
 *      →      return leftStrand.zip(rightStrand).count { (left, right) ->
 *      ②  zip() combina ambas cadenas en una lista de pares (Char,
 *          Char), uno por cada posición.
 *
 *      →          left != right
 *      →      }
 *      ③  count evalúa la lambda por cada par y cuenta cuántos tienen
 *          caracteres diferentes.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Bucle for con índices: for (i in leftStrand.indices) if
 *          (leftStrand[i] != rightStrand[i]) contador++.
 *      B)  Usar leftStrand.indices.count { leftStrand[it] != rightStrand[it] }
 *          sin construir la lista intermedia de pares.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN calcularDistancia(cadenaIzq, cadenaDer): Entero
 *          REQUERIR cadenaIzq.LONGITUD == cadenaDer.LONGITUD
 *          pares ← EMPAREJAR(cadenaIzq, cadenaDer)
 *          DEVOLVER pares.CONTAR(izq != der)
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "compute(\"GAGCCTACTAACGGGAT\", \"CATCGTAATGACGGCCT\")"
 *      ─────────────────────────────────────────────────────────
 *      17 pares, 7 posiciones difieren
 *      Resultado: 7
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "compute(\"A\", \"A\")"
 *      ─────────────────────────────────────────────────────────
 *      1 par ('A','A'), left != right → false
 *      Resultado: 0
 *
 *  ================================================================
 */
