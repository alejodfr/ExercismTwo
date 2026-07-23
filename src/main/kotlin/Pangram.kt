@file:Suppress("SpellCheckingInspection")

/**
 * Pangram
 *
 * Your task is to figure out if a sentence is a pangram.
 *
 * A pangram is a sentence using every letter of the alphabet at least once.
 * It is case insensitive, so it doesn't matter if a letter is lower-case (e.g. k)
 * or upper-case (e.g. K).
 *
 * For this exercise, a sentence is a pangram if it contains each of the 26
 * letters in the English alphabet.
 *
 * Note:
 * Pangram comes from Greek, παν γράμμα, pan gramma, which means "every letter".
 *
 * The best known English pangram is:
 * "The quick brown fox jumps over the lazy dog."
 */

object Pangram {

    fun isPangram(input: String): Boolean {
        // * ¿Para TODAS las letras de la 'a' a la 'z', la frase contiene esa letra (ignorando mayúsculas)?
        return ('a'..'z').all { char ->
            input.contains(char, ignoreCase = true)
        }
    }
}

/**
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *  Determinar si una oración es un pangrama, es decir, si contiene
 *  cada letra del alfabeto inglés al menos una vez.
 *
 *  -----------------------------------------------------------------
 *  🧠  ANÁLISIS DE LA SOLUCIÓN
 *
 *  fun isPangram(input: String): Boolean {
 *      return ('a'..'z').all { char ->
 *          input.contains(char, ignoreCase = true)
 *      }
 *  }
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *  1.  ('a'..'z')  — crea un Rango que incluye todas las letras
 *      del alfabeto inglés en minúscula. En Kotlin, 'a'..'z' es
 *      un CharRange que produce 26 caracteres.
 *
 *  2.  .all { }    — es una función de extensión para colecciones
 *      que devuelve true si TODOS los elementos cumplen la condición
 *      dada. Tan pronto como un elemento no la cumple, se detiene
 *      (cortocircuito / short-circuit).
 *
 *  3.  input.contains(char, ignoreCase = true)
 *      — verifica si la cadena input contiene el caracter 'char'
 *      sin distinguir mayúsculas de minúsculas. El parámetro
 *      ignoreCase evita tener que convertir manualmente la cadena.
 *
 *  -----------------------------------------------------------------
 *  🛠️  FUNCIONES Y CONCEPTOS CLAVE DE KOTLIN
 *
 *  ┌───────────────────────────┬──────────────────────────────────┐
 *  │  Concepto                 │  Uso en el ejercicio             │
 *  ├───────────────────────────┼──────────────────────────────────┤
 *  │  CharRange                │  ('a'..'z') genera las 26 letras │
 *  │  Función de extensión     │  .all { } actúa sobre el rango   │
 *  │  Lambda / predicado       │  { char -> ... }                 │
 *  │  Parámetro con nombre     │  ignoreCase = true               │
 *  │  Short-circuit            │  .all() falla rápido             │
 *  │  Expresión única          │  La función solo tiene un return │
 *  └───────────────────────────┴──────────────────────────────────┘
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *  A)  Con conjunto (Set):
 *      input.lowercase().filter { it.isLetter() }.toSet().size == 26
 *
 *  B)  Con loop tradicional:
 *      for (c in 'a'..'z') if (c !in input.lowercase()) return false
 *      return true
 *
 *  -----------------------------------------------------------------
 *  ⚡  RENDIMIENTO
 *  La solución actual es O(n·m) en el peor caso, donde n = 26 y
 *  m = longitud de input. Gracias al cortocircuito de .all(),
 *  suele terminar antes si falta una letra temprana.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *  FUNCIÓN esPangrama(entrada: Texto): Booleano
 *
 *      PARA CADA letra DESDE 'a' HASTA 'z':
 *          SI entrada NO CONTIENE letra (ignorando mayúsculas):
 *              DEVOLVER Falso
 *          FIN SI
 *      FIN PARA
 *
 *      DEVOLVER Verdadero
 *  FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 1: "The quick brown fox jumps over the lazy dog."
 *  ─────────────────────────────────────────────────────────────────
 *
 *  ¿Contiene 'a'?  → Sí ("...azy...")        ✅
 *  ¿Contiene 'b'?  → Sí ("...brown...")      ✅
 *  ¿Contiene 'c'?  → Sí ("...quick...")      ✅
 *  ¿Contiene 'd'?  → Sí ("...dog...")        ✅
 *  ¿Contiene 'e'?  → Sí ("...the...")        ✅
 *  ¿Contiene 'f'?  → Sí ("...fox...")        ✅
 *  ¿Contiene 'g'?  → Sí ("...dog...")        ✅
 *  ¿Contiene 'h'?  → Sí ("...the...")        ✅
 *  ¿Contiene 'i'?  → Sí ("...quick...")      ✅
 *  ¿Contiene 'j'?  → Sí ("...jumps...")      ✅
 *  ¿Contiene 'k'?  → Sí ("...quick...")      ✅
 *  ¿Contiene 'l'?  → Sí ("...lazy...")       ✅
 *  ¿Contiene 'm'?  → Sí ("...jumps...")      ✅
 *  ¿Contiene 'n'?  → Sí ("...brown...")      ✅
 *  ¿Contiene 'o'?  → Sí ("...fox...")        ✅
 *  ¿Contiene 'p'?  → Sí ("...jumps...")      ✅
 *  ¿Contiene 'q'?  → Sí ("...quick...")      ✅
 *  ¿Contiene 'r'?  → Sí ("...brown...")      ✅
 *  ¿Contiene 's'?  → Sí ("...jumps...")      ✅
 *  ¿Contiene 't'?  → Sí ("...the...")        ✅
 *  ¿Contiene 'u'?  → Sí ("...quick...")      ✅
 *  ¿Contiene 'v'?  → Sí ("...over...")       ✅
 *  ¿Contiene 'w'?  → Sí ("...brown...")      ✅
 *  ¿Contiene 'x'?  → Sí ("...fox...")        ✅
 *  ¿Contiene 'y'?  → Sí ("...lazy...")       ✅
 *  ¿Contiene 'z'?  → Sí ("...lazy...")       ✅
 *
 *  Resultado: true  (es un pangrama)
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 2: "Hello World"
 *  ─────────────────────────────────────────────────────────────────
 *
 *  ¿Contiene 'a'?  → No                     ❌ (cortocircuito)
 *
 *  Resultado: false  (no es un pangrama)
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 3: "Pack my box with five dozen liquor jugs"
 *  ─────────────────────────────────────────────────────────────────
 *
 *  ¿Contiene 'a'?  → Sí   ✅
 *  ¿Contiene 'b'?  → Sí   ✅
 *  ¿Contiene 'c'?  → Sí   ✅
 *  ¿Contiene 'd'?  → Sí   ✅
 *  ¿Contiene 'e'?  → Sí   ✅
 *  ¿Contiene 'f'?  → Sí   ✅
 *  ¿Contiene 'g'?  → Sí   ✅
 *  ¿Contiene 'h'?  → No   ❌ (cortocircuito)
 *
 *  Resultado: false  (falta la 'h')
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 4: Entrada vacía ""
 *  ─────────────────────────────────────────────────────────────────
 *
 *  ¿Contiene 'a'?  → No   ❌ (cortocircuito)
 *
 *  Resultado: false  (una cadena vacía nunca es un pangrama)
 *
 *  ─────────────────────────────────────────────────────────────────
 *  Ejemplo 5: "abcdefghijklmnopqrstuvwxyz"
 *  ─────────────────────────────────────────────────────────────────
 *
 *  ¿Contiene 'a'?  → Sí   ✅
 *  ¿Contiene 'b'?  → Sí   ✅
 *      ...
 *  ¿Contiene 'z'?  → Sí   ✅
 *
 *  Resultado: true  (contiene el alfabeto completo)
 *
 *  ================================================================
 */