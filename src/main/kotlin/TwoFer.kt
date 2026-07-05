@file:Suppress("SpellCheckingInspection")


/*
 * Introduction
 *
 * In some English accents, "two for" said quickly sounds like "two fer".
 * Two-for-one means if you buy one, you get one free.
 *
 * Imagine a bakery with a holiday offer: two cookies for the price of one.
 * You take the offer and give the extra cookie to someone else in the queue.
 *
 * Instructions
 *
 * Determine what you will say as you give away the extra cookie.
 *
 * - If you know the person's name:  "One for Do-yun, one for me."
 * - If you don't know their name:   "One for you, one for me."
 *
 * Examples:
 *   Name    | Dialogue
 *   --------|---------------------------
 *   Alice   | One for Alice, one for me.
 *   Bohdan  | One for Bohdan, one for me.
 *   (none)  | One for you, one for me.
 *   Zaphod  | One for Zaphod, one for me.
 */

fun twofer(name: String? = null): String {
    if (name != null){
        return "One for $name, one for me."
    } else {
        return "One for you, one for me."
    }
}

fun main() {
    // Con nombre
    println(twofer("Alice"))   // One for Alice, one for me.
    println(twofer("Zaphod"))  // One for Zaphod, one for me.

    // Sin nombre — dos formas equivalentes
    println(twofer())          // One for you, one for me.
    println(twofer(null))      // One for you, one for me.
}

/*
 * ╔══════════════════════════════════════════════════════════╗
 * ║           TWO FER — GUÍA DE ESTUDIO COMPLETA            ║
 * ╚══════════════════════════════════════════════════════════╝
 *
 * ─────────────────────────────────────────────────────────────────────
 * 1. CÓDIGO ANOTADO (Árbol de análisis línea por línea)
 * ─────────────────────────────────────────────────────────────────────
 *
 * fun twofer(name: String? = null): String {  ──► fun = declarar función
 * │                                              ──► twofer = nombre de la función
 * │                                              ──► name = parámetro (String o null)
 * │                                              ──► String? = puede contener un String o null
 * │                                              ──► = null = valor por defecto (opcional)
 * │                                              ──► : String = tipo de retorno (NUNCA null)
 * │
 *     if (name != null) {                        ──► if = estructura condicional
 *     │                                           ──► name != null = "name NO es nulo"
 *     │                                           ──► != = operador "diferente de"
 *     │                                           ──► null = ausencia de valor
 *         return "One for $name, one for me."    ──► return = devolver resultado
 *     │                                           ──► $name = interpolación: inserta valor de name
 *     │                                           ──► "One for Alice, one for me."
 *     } else {                                    ──► else = caso contrario
 *     │
 *         return "One for you, one for me."      ──► Cuando name es null, usamos "you"
 *     }
 * }
 *
 * ─────────────────────────────────────────────────────────────────────
 * 2. TABLA DE PALABRAS RESERVADAS
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────────────────────────────────────────────┐
 * │ PALABRA      │ SIGNIFICADO                                      │
 * ├──────────────┼──────────────────────────────────────────────────┤
 * │ fun          │ Declara una función                             │
 * │ if / else    │ Estructura condicional: if (cond) { ... } else  │
 * │ return       │ Devuelve un valor y termina la función          │
 * │ null         │ Ausencia de valor, "nada"                       │
 * │ String       │ Tipo de dato para texto                         │
 * │ Boolean      │ Tipo lógico: true o false (resultado de !=)     │
 * └──────────────┴──────────────────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 3. TABLA DE OPERADORES IMPORTANTES
 * ─────────────────────────────────────────────────────────────────────
 *
 * ┌──────────────┬──────────┬───────────────────────────────────────┐
 * │ OPERADOR     │ TIPO     │ EXPLICACIÓN                           │
 * ├──────────────┼──────────┼───────────────────────────────────────┤
 * │ !=           │Comparación│ "diferente de" → true si NO es null  │
 * │ ==           │Comparación│ "igual a" → compara valores          │
 * │ ?            │ Nullable │ Marca que un tipo puede ser null      │
 * │              │          │ Ej: String? significa "String o null" │
 * │ =            │Asignación│ Asigna valor por defecto: = null      │
 * │ $            │Interpolac│ Inserta variable en String: "$name"   │
 * │ { }          │ Bloque   │ Agrupa múltiples sentencias           │
 * └──────────────┴──────────┴───────────────────────────────────────┘
 *
 * ─────────────────────────────────────────────────────────────────────
 * 4. RESUMEN ALGORÍTMICO
 * ─────────────────────────────────────────────────────────────────────
 *
 * ▸ PROBLEMA: Devolver "One for X, one for me." donde X es un nombre
 *   dado, o "you" si no se proporciona nombre.
 *
 * ▸ PSEUDOCÓDIGO:
 *
 *   FUNCION twofer(nombre: String o null = null) → String:
 *       SI nombre NO es null:
 *           DEVOLVER "One for " + nombre + ", one for me."
 *       SINO:
 *           DEVOLVER "One for you, one for me."
 *
 * ▸ EJEMPLOS:
 *
 *   ┌────────────────────────────────────────────────────────────────┐
 *   │ twofer("Alice")                                               │
 *   │                                                               │
 *   │   name = "Alice"                                              │
 *   │   └── name != null? → SI (true)                              │
 *   │       └── return "One for Alice, one for me."                │
 *   │                                                               │
 *   │ Resultado: "One for Alice, one for me."                       │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌────────────────────────────────────────────────────────────────┐
 *   │ twofer()  (sin argumento)                                    │
 *   │                                                               │
 *   │   name = null (valor por defecto)                             │
 *   │   └── name != null? → NO (false)                             │
 *   │       └── else → return "One for you, one for me."           │
 *   │                                                               │
 *   │ Resultado: "One for you, one for me."                         │
 *   └────────────────────────────────────────────────────────────────┘
 *
 *   ┌────────────────────────────────────────────────────────────────┐
 *   │ twofer(null)  (null explícito)                               │
 *   │                                                               │
 *   │   name = null                                                 │
 *   │   └── name != null? → NO (false)                             │
 *   │       └── else → return "One for you, one for me."           │
 *   │                                                               │
 *   │ Resultado: "One for you, one for me."                         │
 *   └────────────────────────────────────────────────────────────────┘
 */