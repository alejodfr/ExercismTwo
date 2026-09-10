@file:Suppress("SpellCheckingInspection")


/**
 *
 * Introduction
 * Raindrops is a slightly more complex version of the FizzBuzz challenge, a classic interview question.
 *
 * Instructions
 * Your task is to convert a number into its corresponding raindrop sounds.
 *
 * If a given number:
 *
 * is divisible by 3, add "Pling" to the result.
 * is divisible by 5, add "Plang" to the result.
 * is divisible by 7, add "Plong" to the result.
 * is not divisible by 3, 5, or 7, the result should be the number as a string.
 * Examples
 * 28 is divisible by 7, but not 3 or 5, so the result would be "Plong".
 * 30 is divisible by 3 and 5, but not 7, so the result would be "PlingPlang".
 * 34 is not divisible by 3, 5, or 7, so the result would be "34".
 *
 *
 * */

// ▶ object Raindrops {
//   └▶ ① object → singleton: una única instancia con nombre Raindrops.
object Raindrops {

    // ▶ fun convert(n: Int): String {
    //   └▶ ② recibe el número y devuelve su cadena de sonidos (o el número
    //           como texto).
    fun convert(n: Int): String {
        // ▶ var result = ""
        //   └▶ ③ acumulador mutable que empieza vacío.
        var result = ""
        // ▶ if (n % 3 == 0) { result += "Pling" }
        //   └▶ ④ % → resto; si es 0, n es divisible por 3 → concatena "Pling".
        if (n % 3 == 0){
            result += "Pling"
        }
        // ▶ if (n % 5 == 0) { result += "Plang" }
        //   └▶ ⑤ chequeo independiente (no es else if): pueden cumplirse varios.
        if (n % 5 == 0){
            result += "Plang"
        }
        // ▶ if (n % 7 == 0) { result += "Plong" }
        //   └▶ ⑥ mismo patrón para 7.
        if (n % 7 == 0){
            result += "Plong"
        }
        // ▶ if (result.isEmpty()) { return n.toString() } else { return result }
        //   ├▶ ⑦ si ningún if se cumplió, result sigue vacío → se devuelve
        //   │       el número convertido a texto.
        //   └▶ ⑧ si hubo al menos una coincidencia, se devuelve lo acumulado.
        if (result.isEmpty()){
            return n.toString()
        } else {
            return result
        }
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Convertir un número en su cadena de sonidos de lluvia según su
 *      divisibilidad por 3 ("Pling"), 5 ("Plang") y 7 ("Plong"); si no
 *      es divisible por ninguno, devolver el número como texto.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar buildString { if (...) append(...) }.ifEmpty { n.toString() }
 *          en vez de var + concatenación manual con +=.
 *      B)  Guardar los sonidos en una List<Pair<Int,String>> y usar
 *          filter + joinToString("") para generar el resultado.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "convert(30)"
 *      ─────────────────────────────────────────────────────────
 *      30%3=0→"Pling"; 30%5=0→"Plang"; 30%7≠0
 *      Resultado: "PlingPlang"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "convert(34)"
 *      ─────────────────────────────────────────────────────────
 *      34%3≠0, 34%5≠0, 34%7≠0 → result vacío → n.toString()
 *      Resultado: "34"
 *
 *  ================================================================
 */
