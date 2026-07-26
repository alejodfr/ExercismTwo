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

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Convertir un número en su cadena de sonidos de lluvia (Raindrops) según divisibilidad por 3, 5 y 7.
 *
 *  -----------------------------------------------------------------
 *  🧠  ANÁLISIS DE LA SOLUCIÓN
 *
 *  object Raindrops {
 *      fun convert(n: Int): String {
 *          var result = ""
 *          if (n % 3 == 0) result += "Pling"
 *          if (n % 5 == 0) result += "Plang"
 *          if (n % 7 == 0) result += "Plong"
 *          return if (result.isEmpty()) n.toString() else result
 *      }
 *  }
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  `object Raindrops` — Objeto singleton que envuelve la función.
 *  2.  `var result = ""` — Acumulador de cadenas vacío inicial.
 *  3.  Tres `if` independientes — Cada uno verifica divisibilidad por un primo y concatena el sonido.
 *  4.  `result.isEmpty()` — Si ningún if se cumplió, se devuelve el número como string.
 *  5.  `n.toString()` — Convierte el entero a String para el caso por defecto.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  object                   │  Singleton contenedor de función  │
 *  │  var                      │  Variable mutable para `result`   │
 *  │  if                       │  Condicional sin else if (c/u independiente)│
 *  │  % (módulo)               │  Verificar divisibilidad         │
 *  │  += (concatenación)       │  Acumular cadenas con "+="       │
 *  │  .isEmpty()               │  Saber si no hubo coincidencias  │
 *  │  .toString()              │  Convertir Int a String          │
 *  │  if como expresión        │  `return if (cond) a else b`     │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  buildString { } — Usar `buildString { append(...) }` para mejor rendimiento con cadenas.
 *  B)  List + joinToString — Almacenar sonidos en lista y usar `joinToString("")`.
 *  C)  when + map — Usar `when` con pares (condición, sonido) iterados.
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  Complejidad O(1) — siempre 3 verificaciones fijas, sin importar el valor de n.
 *  Memoria O(1) — solo almacena el resultado en una cadena.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  OBJETO Raindrops
 *      FUNCIÓN convertir(n: Int): String
 *          resultado := ""
 *          SI n % 3 == 0 ENTONCES resultado := resultado + "Pling"
 *          SI n % 5 == 0 ENTONCES resultado := resultado + "Plang"
 *          SI n % 7 == 0 ENTONCES resultado := resultado + "Plong"
 *          SI resultado está vacío ENTONCES
 *              DEVOLVER n como texto
 *          SINO
 *              DEVOLVER resultado
 *          FIN SI
 *      FIN FUNCIÓN
 *  FIN OBJETO
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: "28"
 *  ─────────────────────────────────────────────────────────────────
 *  28 % 3 = 1 → no agrega "Pling"
 *  28 % 5 = 3 → no agrega "Plang"
 *  28 % 7 = 0 → agrega "Plong"
 *  resultado = "Plong"
 *  Resultado: "Plong"
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: "30"
 *  ─────────────────────────────────────────────────────────────────
 *  30 % 3 = 0 → agrega "Pling"
 *  30 % 5 = 0 → agrega "Plang"
 *  30 % 7 = 2 → no agrega "Plong"
 *  resultado = "PlingPlang"
 *  Resultado: "PlingPlang"
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 3: "34"
 *  ─────────────────────────────────────────────────────────────────
 *  34 % 3 = 1 → no agrega "Pling"
 *  34 % 5 = 4 → no agrega "Plang"
 *  34 % 7 = 6 → no agrega "Plong"
 *  resultado = "" → vacío, devuelve "34"
 *  Resultado: "34"
 *
 *  ================================================================
 */

/*
 *  =====================  VARIANTE MÁS ELEGANTE  =====================
 *
 *  object Raindrops {
 *      fun convert(n: Int): String = buildString {
 *          if (n % 3 == 0) append("Pling")
 *          if (n % 5 == 0) append("Plang")
 *          if (n % 7 == 0) append("Plong")
 *      }.ifEmpty { n.toString() }
 *  }
 *
 *  ✅  Ventajas
 *  ────────────────────────────────────────────────────────────────────
 *  •  Sin var — Todo es val, estilo funcional.
 *  •  buildString — Usa StringBuilder internamente, evita crear
 *     Strings intermedias en cada concatenación (+=).
 *  •  ifEmpty — Reemplaza el if/else manual de forma declarativa.
 *  ================================================================
 */