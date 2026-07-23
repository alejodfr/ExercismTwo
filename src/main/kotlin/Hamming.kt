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

// ============================================================
//  1. INSTRUCCIONES
// ============================================================
//
// Dadas dos cadenas de ADN (Strings) de igual longitud, contar
// cuantas posiciones tienen letras diferentes (distancia Hamming).
//
// Objetivos:
//  - Validar que ambas cadenas tengan la misma longitud.
//  - Si no son iguales, lanzar IllegalArgumentException con
//    require().
//  - Recorrer ambas cadenas simultaneamente y contar las
//    posiciones donde los caracteres difieren.

// ============================================================
//  2. ORDEN DE PENSAMIENTO
// ============================================================
//
//  2.1 Validacion de longitud
//   - Usamos require(condicion) para verificar que las cadenas
//     midan lo mismo.
//   - Si la condicion es falsa, require lanza automaticamente
//     una IllegalArgumentException con el mensaje indicado.
//
//  2.2 Emparejamiento posicional
//   - zip() toma dos Strings y devuelve una lista de pares
//     (Char, Char), uno por cada posicion.
//   - Ej: "ABC".zip("ABX") -> [(A,A), (B,B), (C,X)]
//
//  2.3 Conteo de diferencias
//   - count() recibe una lambda que evalua cada par.
//   - Si left != right, cuenta 1; si son iguales, no cuenta.
//   - El resultado es la distancia Hamming.

// ============================================================
//  3. SINTAXIS DEL CODIGO
// ============================================================
//
// +----------------+------------------------------------------+--------------------------------------+
// | Palabra clave  | Significado                              | Analogia                             |
// +----------------+------------------------------------------+--------------------------------------+
// | object         | Declara un singleton (una unica          | Una caja con una unica copia.        |
// |                | instancia de la clase).                  |                                      |
// | fun            | Define una funcion o metdo.              | Una receta con pasos a seguir.       |
// | require        | Valida una condicion y lanza excepcion   | Un portero que no deja pasar si      |
// |                | si es falsa.                             | no cumples el requisito.             |
// | zip            | Combina dos secuencias en pares          | Crear parejas de baile con dos       |
// |                | posicion a posicion.                    | filas de personas.                   |
// | count          | Cuenta elementos que cumplen una         | Un contador con filtro.              |
// |                | condicion.                               |                                      |
// | { (a,b) -> }   | Lambda que recibe dos parametros.        | Una maquina que toma dos cosas       |
// |                |                                          | y produce un resultado.              |
// | length         | Propiedad que devuelve cuantos           | La longitud de una fila de          |
// |                | caracteres tiene el String.              | caracteres.                          |
// +----------------+------------------------------------------+--------------------------------------+

// ============================================================
//  4. PSEUDOCODIGO
// ============================================================
//
// objeto Hamming:
//     funcion compute(cadenaIzq: String, cadenaDer: String): Int
//         requerir que largo de cadenaIzq == largo de cadenaDer
//             si no, lanzar error "left and right strands must be of equal length"
//
//         emparejar cadenaIzq con cadenaDer en pares (izq, der)
//         contar cuantos pares tienen izq != der
//         devolver ese conteo

// ============================================================
//  5. EJEMPLOS TRABAJADOS
// ============================================================
//
// Ejemplo 1:
//   Entrada: leftStrand = "GAGCCTACTAACGGGAT"
//            rightStrand = "CATCGTAATGACGGCCT"
//   Proceso: zip -> 16 pares, count -> 7 diferencias
//   Resultado: 7
//
// Ejemplo 2:
//   Entrada: leftStrand = "A"
//            rightStrand = "A"
//   Proceso: zip -> 1 par ('A','A'), left != right? false
//   Resultado: 0
//
// Ejemplo 3:
//   Entrada: leftStrand = "A"
//            rightStrand = "G"
//   Proceso: zip -> 1 par ('A','G'), left != right? true
//   Resultado: 1
//