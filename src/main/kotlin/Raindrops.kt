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

object Raindrops {

    fun convert(n: Int): String {
        var result = ""
        if (n % 3 == 0){
            result += "Pling"
        }
        if (n % 5 == 0){
            result += "Plang"
        }
        if (n % 7 == 0){
            result += "Plong"
        }
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
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Empezar con un acumulador de texto vacío.
 *      II.  Comprobar divisibilidad por 3, 5 y 7 de forma
 *           independiente, concatenando el sonido correspondiente.
 *      III. Si al final no se concatenó ningún sonido, devolver el
 *           número como String; si no, devolver lo acumulado.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun convert(n: Int): String {
 *      →      var result = ""
 *      ①  Acumulador mutable que empieza vacío.
 *
 *      →      if (n % 3 == 0){
 *      →          result += "Pling"
 *      ②  Si n es divisible por 3, se concatena "Pling".
 *      →      }
 *      →      if (n % 5 == 0){
 *      →          result += "Plang"
 *      ③  Chequeo independiente para 5 (no es else if: pueden
 *          cumplirse varias condiciones a la vez).
 *      →      }
 *      →      if (n % 7 == 0){
 *      →          result += "Plong"
 *      ④  Mismo patrón para 7.
 *      →      }
 *
 *      →      if (result.isEmpty()){
 *      →          return n.toString()
 *      ⑤  Si ningún if se cumplió, result sigue vacío: se devuelve el
 *          número convertido a texto.
 *      →      } else {
 *      →          return result
 *      ⑥  Si hubo al menos una coincidencia, se devuelve lo acumulado.
 *      →      }
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN convertir(n): Texto
 *          resultado ← ""
 *          SI n % 3 == 0: resultado += "Pling"
 *          SI n % 5 == 0: resultado += "Plang"
 *          SI n % 7 == 0: resultado += "Plong"
 *          SI resultado VACÍO: DEVOLVER n COMO TEXTO
 *          SINO: DEVOLVER resultado
 *      FIN FUNCIÓN
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
