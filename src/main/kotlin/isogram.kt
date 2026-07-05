@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 *
 * Determine if a word or phrase is an isogram.
 *
 * An isogram (also known as a "non-pattern word") is a word or phrase without a
 * repeating letter, however spaces and hyphens are allowed to appear multiple times.
 *
 * Examples of isograms:
 *
 *   - lumberjacks
 *   - background
 *   - downstream
 *   - six-year-old
 *
 * The word isograms, however, is not an isogram, because the s repeats.
 */

object Isogram {

    fun isIsogram(input: String): Boolean {
        val letters = input.filter { it != '-' && it != ' ' }.lowercase()
        return letters.length == letters.toList().distinct().size
    }
}



fun main(){
    println("Type a word or phrase")
    val input = readln()
    println("Is the word or phrase an isogram? ${Isogram.isIsogram(input)}")
}

/**
 * ╔══════════════════════════════════════════════════════════════╗
 * ║      GUÍA DE ESTUDIO — isogram.kt (Verificar Isograma)     ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * ────────────────────────────────────────────────────────────
 *  CÓDIGO ANOTADO
 * ────────────────────────────────────────────────────────────
 *
 * object Isogram {                                       ──► Objeto singleton
 * │
 * └── fun isIsogram(input: String): Boolean {            ──► Recibe una frase, devuelve
 *     │                                                     true si no hay letras repetidas
 *     │
 *     ├── val letters = input                             ──► Toma el texto original
 *     │   .filter { it != '-' && it != ' ' }              ──► Elimina guiones y espacios
 *     │   .lowercase()                                    ──► Convierte todo a minúsculas
 *     │
 *     └── return letters.length                          ──► Longitud del String filtrado
 *             ==                                          ──► COMPARA con:
 *             letters.toList()                            ──► Convierte a lista de chars
 *             .distinct()                                  ──► Elimina duplicados
 *             .size                                       ──► Tamaño de la lista sin duplicados
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
 *  │  String      │  Tipo cadena de texto                      │
 *  │  Boolean     │  Tipo verdadero/falso                      │
 *  │  return      │  Devolver valor                            │
 *  │  it          │  Parámetro implícito en lambda             │
 *  │  !=          │  Diferente de                              │
 *  │  &&          │  AND lógico (y)                            │
 *  │  ==          │  Igualdad                                  │
 *  │  filter      │  Filtrar elementos que cumplen condición   │
 *  │  toList      │  Convertir a lista                         │
 *  │  distinct    │  Eliminar elementos duplicados             │
 *  │  lowercase   │  Convertir a minúsculas                    │
 *  │  length      │  Longitud de la cadena                     │
 *  │  size        │  Tamaño de la colección                    │
 *  └──────────────┴────────────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE OPERADORES IMPORTANTES
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────┬──────────────┬─────────────────────────────────┐
 *  │ Operador │  Uso         │  Explicación                    │
 *  ├──────────┼──────────────┼─────────────────────────────────┤
 *  │  !=      │ a != b       │  ¿Es diferente?                 │
 *  │  &&      │ a && b       │  AND: verdadero si ambos lo son │
 *  │  ==      │ a == b       │  ¿Son iguales?                  │
 *  │  .       │ a.b()        │  Llamar método                  │
 *  │  { }     │ { it }       │  Lambda (función anónima)       │
 *  └──────────┴──────────────┴─────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  RESUMEN ALGORÍTMICO
 * ────────────────────────────────────────────────────────────
 *
 *  PSEUDOCÓDIGO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  función esIsograma(texto):                            │
 *  │      filtrar: eliminar guiones y espacios              │
 *  │      convertir a minúsculas                            │
 *  │      SI longitud del texto filtrado                     │
 *  │         == cantidad de letras ÚNICAS (sin repetir):    │
 *  │         → true (es isograma)                           │
 *  │      SINO → false (hay letras repetidas)               │
 *  └─────────────────────────────────────────────────────────┘
 *
 *  EJEMPLO TRABAJADO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  Entrada: "six-year-old"                                │
 *  │                                                         │
 *  │  Paso 1: filter { it != '-' && it != ' ' }             │
 *  │    "six-year-old" → "sixyearold" (se quitan guiones)   │
 *  │                                                         │
 *  │  Paso 2: .lowercase()                                  │
 *  │    "sixyearold" → "sixyearold" (ya está en minúscula)  │
 *  │                                                         │
 *  │  Paso 3: letters.length                                │
 *  │    "sixyearold" tiene 10 caracteres                     │
 *  │                                                         │
 *  │  Paso 4: letters.toList().distinct()                   │
 *  │    ['s','i','x','y','e','a','r','o','l','d']           │
 *  │    .distinct() → igual (10 elementos, todos únicos)    │
 *  │                                                         │
 *  │  Paso 5: 10 == 10 → true → ¡Es isograma!              │
 *  │                                                         │
 *  ├─────────────────────────────────────────────────────────┤
 *  │  Entrada: "hello"                                       │
 *  │    filter+lowercase → "hello"                           │
 *  │    .toList().distinct() → ['h','e','l','o'] (4)        │
 *  │    5 == 4 → false → No es isograma (la 'l' se repite)  │
 *  └─────────────────────────────────────────────────────────┘
 */
