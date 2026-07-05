@file:Suppress("SpellCheckingInspection")


/**
 * # ETL — Extract, Transform, Load
 *
 * ## Introduction
 * You work for a company that makes an online multiplayer game called
 * **Lexiconia**.
 *
 * To play the game, each player is given 13 letters, which they must
 * rearrange to create words. Different letters have different point
 * values, since it's easier to create words with some letters than others.
 *
 * The game was originally launched in English, but it is very popular,
 * and now the company wants to expand to other languages as well.
 *
 * Different languages need to support different point values for letters.
 * The point values are determined by how often letters are used, compared
 * to other letters in that language.
 *
 * For example, the letter **C** is quite common in English, and is only
 * worth 3 points. But in Norwegian it's a very rare letter, and is worth
 * 10 points.
 *
 * ## Instructions
 * Your task is to change the data format of letters and their point
 * values in the game.
 *
 * Currently, letters are stored in groups based on their score, in a
 * **one-to-many** mapping:
 *
 * ```
 *  1 point:  "A", "E", "I", "O", "U", "L", "N", "R", "S", "T"
 *  2 points: "D", "G"
 *  3 points: "B", "C", "M", "P"
 *  4 points: "F", "H", "V", "W", "Y"
 *  5 points: "K"
 *  8 points: "J", "X"
 * 10 points: "Q", "Z"
 * ```
 *
 * This needs to be changed to store each individual letter with its score
 * in a **one-to-one** mapping:
 *
 * ```
 * "a" is worth 1 point
 * "b" is worth 3 points
 * "c" is worth 3 points
 * "d" is worth 2 points
 * ...
 * ```
 *
 * As part of this change, the team has also decided to change the letters
 * to be **lower-case** rather than upper-case.
 */

object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        source.forEach { points, letters ->
            letters.forEach { letter ->
                result[letter.lowercaseChar()] = points
            }

        }
        return result
    }

}

fun main(){
    val input = mapOf(
        1 to listOf('A', 'E', 'I'),
        2 to listOf('D', 'G'),
        3 to listOf('B', 'C')
    )

    val result = ETL.transform(input)
    println(result)
    // {a=1, e=1, i=1, d=2, g=2, b=3, c=3}
}

/*
 * ╔══════════════════════════════════════════════════════════════╗
 * ║        GUÍA DE ESTUDIO — ETL.kt (Extraer, Transformar,     ║
 * ║                                  Cargar)                   ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * ────────────────────────────────────────────────────────────
 *  CÓDIGO ANOTADO
 * ────────────────────────────────────────────────────────────
 *
 * object ETL {                                           ──► Objeto singleton
 * │
 * └── fun transform(source: Map<Int, Collection<Char>>)  ──► Recibe un mapa donde
 *         : Map<Char, Int> {                              ──► la clave es Int (puntos)
 *     │                                                     el valor es Collection<Char> (letras)
 *     │                                                     Devuelve Map<Char, Int> (letra → puntos)
 *     │
 *     ├── val result = mutableMapOf<Char, Int>()         ──► Crea un mapa MUTABLE vacío
 *     │                                                     para ir llenándolo
 *     │
 *     ├── source.forEach { points, letters ->            ──► Itera cada entrada del mapa
 *     │   │                                                  points  → clave (Int)
 *     │   │                                                  letters → valor (Collection<Char>)
 *     │   │
 *     │   └── letters.forEach { letter ->                ──► Itera cada letra de la colección
 *     │       │
 *     │       └── result[letter.lowercaseChar()] = points ──► Asigna en result:
 *     │                                                      clave = letra en minúscula
 *     │                                                      valor = puntos
 *     │     │                                                Si la letra ya existe, se SOBREESCRIBE
 *     │     }
 *     │   }
 *     │
 *     └── return result                                  ──► Devuelve el mapa transformado
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
 *  │  object      │  Singleton                                 │
 *  │  fun         │  Función                                   │
 *  │  val         │  Variable inmutable                        │
 *  │  Map<K,V>    │  Tipo: diccionario clave→valor             │
 *  │  Collection  │  Tipo: conjunto de elementos (List, Set)   │
 *  │  mutableMapOf│  Crea un mapa mutable (se puede modificar) │
 *  │  forEach     │  Itera sobre cada elemento                 │
 *  │  return      │  Devuelve valor                            │
 *  │  Char        │  Tipo carácter ('a', 'b', etc.)            │
 *  │  Int         │  Tipo entero                               │
 *  └──────────────┴────────────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE OPERADORES IMPORTANTES
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────┬──────────────┬─────────────────────────────────┐
 *  │ Operador │  Uso         │  Explicación                    │
 *  ├──────────┼──────────────┼─────────────────────────────────┤
 *  │  < , >   │ Map<K,V>     │  Genéricos (tipo parametrizado) │
 *  │  ->      │ a -> b       │  Separador en lambda / par      │
 *  │  {}      │ { ... }      │  Bloque lambda                  │
 *  │  []      │ mapa[clave]  │  Acceso / asignación en mapa    │
 *  │  .       │ a.b()        │  Llamada a método               │
 *  │  =       │ a = b        │  Asignación                     │
 *  │  ()      │ fun()        │  Llamada a función              │
 *  └──────────┴──────────────┴─────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  RESUMEN ALGORÍTMICO
 * ────────────────────────────────────────────────────────────
 *
 *  PSEUDOCÓDIGO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  función transform(source):                            │
 *  │      crear mapa vacío resultado                        │
 *  │      PARA CADA (puntos, letras) EN source:             │
 *  │          PARA CADA letra EN letras:                    │
 *  │              resultado[letra en minúscula] = puntos     │
 *  │      devolver resultado                                │
 *  └─────────────────────────────────────────────────────────┘
 *
 *  EJEMPLO TRABAJADO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  Entrada: {1: ['A', 'E'], 2: ['D']}                    │
 *  │                                                         │
 *  │  Iteración 1: points=1, letters=['A','E']              │
 *  │    letter='A' → result['a'] = 1   → {a=1}              │
 *  │    letter='E' → result['e'] = 1   → {a=1, e=1}         │
 *  │                                                         │
 *  │  Iteración 2: points=2, letters=['D']                  │
 *  │    letter='D' → result['d'] = 2   → {a=1, e=1, d=2}    │
 *  │                                                         │
 *  │  Resultado: {a=1, e=1, d=2}                            │
 *  └─────────────────────────────────────────────────────────┘
 */