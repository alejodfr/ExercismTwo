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

/**
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

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Problema: Transformar el formato de datos de letras y puntajes en un juego
    de palabras (Lexiconia). Actualmente los puntajes están agrupados:
        {1: [A, E, I, ...], 2: [D, G], ...}
    y se necesita convertirlos a un formato individual:
        {a: 1, e: 1, i: 1, d: 2, g: 2, ...}
    Además, las letras deben estar en MINÚSCULAS.

    OBJETIVOS:
    I.   Crear un objeto ETL con una función transform.
    II.  transform recibe Map<Int, Collection<Char>> (puntos → letras mayúsculas).
    III. transform devuelve Map<Char, Int> (letra minúscula → puntos).
    IV.  Cada letra individual debe mapearse a su puntaje correspondiente.
    V.   Convertir todas las letras a minúsculas.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. ANÁLISIS DEL FORMATO DE ENTRADA
       └── Map<Int, Collection<Char>>:
           └── Clave (Int): puntaje (1, 2, 3, ..., 10).
           └── Valor (Collection<Char>): lista de letras MAYÚSCULAS que valen ese puntaje.
       └── Ejemplo concreto:
             1 → ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T']
             2 → ['D', 'G']
             3 → ['B', 'C', 'M', 'P']

    II. ANÁLISIS DEL FORMATO DE SALIDA
        └── Map<Char, Int>:
            └── Clave (Char): letra MINÚSCULA individual.
            └── Valor (Int): puntaje de esa letra.
        └── Ejemplo: 'a' → 1, 'b' → 3, 'c' → 3, 'd' → 2.

    III. ESTRATEGIA DE TRANSFORMACIÓN
         a) Crear un mapa mutable vacío (resultado).
         b) Recorrer CADA ENTRADA del mapa de entrada (forEach en source).
            └── Desestructurar: (points, letters) — points es el puntaje, letters
                es la colección de letras.
         c) Para CADA LETRA dentro de letters:
            └── Convertir la letra a minúscula (.lowercaseChar()).
            └── Asignar en result: result[letraEnMinuscula] = points.
         d) Devolver result.

    IV. CONSIDERACIONES
        └── Si una letra aparece dos veces (no debería en este problema),
            la última asignación gana.
        └── En este problema, cada letra aparece en un solo grupo, no hay
            duplicados.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object ETL {                                                             │
    │     fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> { │
    │         val result = mutableMapOf<Char, Int>()                           │
    │         source.forEach { points, letters ->                              │
    │             letters.forEach { letter ->                                  │
    │                 result[letter.lowercaseChar()] = points                  │
    │             }                                                            │
    │         }                                                                │
    │         return result                                                    │
    │     }                                                                    │
    │ }                                                                        │
    │                                                                          │
    │ fun main() {                                                             │
    │     val input = mapOf(                                                   │
    │         1 to listOf('A', 'E', 'I'),                                     │
    │         2 to listOf('D', 'G'),                                          │
    │         3 to listOf('B', 'C')                                           │
    │     )                                                                    │
    │     val result = ETL.transform(input)                                    │
    │     println(result)                                                      │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada que declara un SINGLETON (única instancia).
         └── En Kotlin, object crea una clase y su única instancia en una sola
             declaración.
         └── Analogía: el diccionario oficial del juego — solo hay uno, no necesitas
             crear copias.

    II.  ETL
         └── Nombre del objeto: "Extract, Transform, Load".
         └── Identificador elegido por el programador (por convención, mayúscula).

    III. fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int>
         └── fun: palabra reservada "función".
         └── transform: nombre de la función.
         └── (source: Map<Int, Collection<Char>>): parámetro llamado "source"
             de tipo Map (diccionario) que asocia Int → Collection<Char>.
         └── : Map<Char, Int>: tipo de retorno — devuelve un mapa de Char → Int.
         └── Analogía: una máquina que recibe piezas desordenadas (mapa agrupado)
             y las organiza individualmente (mapa uno-a-uno).

    IV.  Map<K, V>
         └── Tipo genérico: diccionario (mapa) que asocia CLAVES (K) con VALORES (V).
         └── En español: "mapa" o "diccionario".
         └── Cada clave es ÚNICA. No puede haber dos claves iguales.
         └── Analogía: un diccionario de idiomas — buscas por palabra (clave) y
             obtienes su traducción (valor).

    V.   Collection<Char>
         └── Collection<T>: tipo genérico para una colección de elementos T.
         └── <Char> : el tipo de elemento es Char (carácter como 'A', 'b').
         └── Puede ser una List, Set, u otra subclase de Collection.
         └── Analogía: una bolsa que contiene varias letras.

    VI.  Char
         └── Tipo de dato que almacena un ÚNICO CARÁCTER Unicode.
         └── Se escribe entre comillas simples: 'A', 'z', '1'.
         └── Analogía: una ficha con una sola letra escrita.

    VII. Int
         └── Tipo de dato: entero de 32 bits (rango -2³¹ a 2³¹-1).
         └── Aquí representa el puntaje de las letras.
         └── Analogía: el número de puntos que vale una letra en el juego.

    VIII. val result = mutableMapOf<Char, Int>()
          └── val: variable INMUTABLE (la referencia no cambia, pero el contenido
              del mapa SÍ puede cambiar porque es mutable).
          └── mutableMapOf<K, V>(): función que crea un MAPA MUTABLE vacío.
          └── <Char, Int>: las claves serán Char (letras), los valores Int (puntos).
          └── mutable: se puede modificar (agregar, eliminar, actualizar entradas).
          └── Analogía: una pizarra en blanco donde iremos escribiendo letras
              con sus puntajes.

    IX.  source.forEach { points, letters ->
         └── forEach: método que ITERA sobre cada elemento de la colección.
         └── En un Map, itera sobre cada ENTRADA (clave + valor).
         └── { points, letters -> }: LAMBDA (función anónima).
         └── points: nombre para la CLAVE de cada entrada (Int).
         └── letters: nombre para el VALOR de cada entrada (Collection<Char>).
         └── -> : separa los parámetros del cuerpo de la lambda.
         └── Analogía: "Para cada grupo de letras: toma el puntaje y la lista
             de letras, y haz algo con ellos."

    X.   letters.forEach { letter ->
         └── Segundo forEach: itera sobre CADA LETRA dentro de la colección.
         └── letter: nombre para cada elemento Char individual.
         └── Este forEach está ANIDADO dentro del primero.
         └── Analogía: "Para cada letra dentro de la lista, procesa una por una."

    XI.  result[letter.lowercaseChar()] = points
         └── result[...]: OPERADOR DE ASIGNACIÓN en mapa.
         └── letter.lowercaseChar(): método que convierte 'A' → 'a', 'B' → 'b'.
         └── letter.lowercaseChar() es la CLAVE.
         └── points es el VALOR que se asigna.
         └── En Kotlin, mapa[clave] = valor es equivalente a mapa.put(clave, valor).
         └── Analogía: escribir en la pizarra "letra a → 1 punto".

    XII. .lowercaseChar()
         └── Método de la clase Char: devuelve el equivalente en MINÚSCULA.
         └── 'A'.lowercaseChar() → 'a'
         └── 'a'.lowercaseChar() → 'a' (ya está en minúscula, no cambia).
         └── Específico de Kotlin (Java usa Character.toLowerCase()).

    XIII. return result
          └── Palabra reservada: DEVOLVER el mapa resultante.
          └── Termina la función transform y entrega el mapa construido.

    XIV. main()
         └── Función principal (punto de entrada del programa).
         └── Sin ella, el programa no puede ejecutarse.

    XV.  mapOf(...)
         └── Función de biblioteca estándar que crea un MAPA INMUTABLE.
         └── Recibe pares clave → valor separados por comas.
         └── mapOf(1 to 'A', 2 to 'B') → {1='A', 2='B'}.

    XVI. 1 to listOf('A', 'E', 'I')
         └── to: palabra reservada (infix) que crea un PAR (Pair).
         └── 1 to listOf(...) equivale a Pair(1, listOf(...)).
         └── Se usa para crear entradas de mapa.
         └── Analogía: "1 va con ['A', 'E', 'I']".

    XVII. listOf('A', 'E', 'I')
          └── listOf: función que crea una LISTA INMUTABLE con los argumentos dados.
          └── 'A', 'E', 'I' son tres caracteres literales (Char).
          └── Analogía: meter tres fichas con letras en una bolsa (lista).

    XVIII. ETL.transform(input)
           └── ETL: nombre del objeto singleton.
           └── . : operador punto — accede a los miembros del objeto.
           └── transform(input): llama a la función transform pasándole input.
           └── Analogía: meter los datos en la máquina transformadora.

    XIX. println(result)
         └── println: función que imprime texto en la consola.
         └── Kotlin convierte automáticamente el mapa a su representación textual.
         └── Imprimirá {a=1, e=1, i=1, d=2, g=2, b=3, c=3}.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO ETL

        FUNCION transformar(fuente):
            ENTRADA: fuente (Map<Int, Collection<Char>>)
            SALIDA: Map<Char, Int>

            resultado = mapaMutable(<Char, Int>)     // mapa vacío

            PARA CADA (puntos, letras) EN fuente:
                PARA CADA letra EN letras:
                    resultado[letra.enMinuscula()] = puntos

            DEVOLVER resultado

    ──────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. entrada = mapa(
            1 → lista('A', 'E', 'I'),
            2 → lista('D', 'G'),
            3 → lista('B', 'C')
          )
        2. resultado = ETL.transformar(entrada)
        3. imprimir(resultado)
           // → {a=1, e=1, i=1, d=2, g=2, b=3, c=3}

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: transform({1: ['A', 'E'], 2: ['D']}) — caso simple de 3 letras

        Entrada: source = {1: ['A', 'E'], 2: ['D']}

        Proceso:
            resultado = {}  // vacío

            ── Iteración 1 del forEach externo ──
            points = 1, letters = ['A', 'E']
            ├── forEach interno sobre ['A', 'E']:
            │   ├── letter = 'A' → 'A'.lowercaseChar() = 'a'
            │   │   resultado['a'] = 1   → resultado = {a=1}
            │   └── letter = 'E' → 'E'.lowercaseChar() = 'e'
            │       resultado['e'] = 1   → resultado = {a=1, e=1}

            ── Iteración 2 del forEach externo ──
            points = 2, letters = ['D']
            └── forEach interno sobre ['D']:
                └── letter = 'D' → 'D'.lowercaseChar() = 'd'
                    resultado['d'] = 2   → resultado = {a=1, e=1, d=2}

        Resultado: {a=1, e=1, d=2}

        └── Cada letra mayúscula se convierte a minúscula y se empareja con su puntaje.

    EJEMPLO 2: transform({1: ['O', 'U'], 3: ['B', 'C', 'M']}) — múltiples grupos

        Entrada: source = {1: ['O', 'U'], 3: ['B', 'C', 'M']}

        Proceso:
            resultado = {}
            Iteración 1: points=1, letters=['O','U']
                'O' → 'o' → resultado['o']=1
                'U' → 'u' → resultado['u']=1
                → resultado = {o=1, u=1}
            Iteración 2: points=3, letters=['B','C','M']
                'B' → 'b' → resultado['b']=3
                'C' → 'c' → resultado['c']=3
                'M' → 'm' → resultado['m']=3
                → resultado = {o=1, u=1, b=3, c=3, m=3}

        Resultado: {o=1, u=1, b=3, c=3, m=3}

        └── Las letras O y U valen 1 punto; B, C, M valen 3 puntos.

    EJEMPLO 3: transform({5: ['K'], 8: ['J', 'X'], 10: ['Q', 'Z']}) — puntajes altos

        Entrada: source = {5: ['K'], 8: ['J', 'X'], 10: ['Q', 'Z']}

        Proceso:
            resultado = {}
            Iteración 1: points=5, letters=['K']
                'K' → 'k' → resultado['k']=5
                → resultado = {k=5}
            Iteración 2: points=8, letters=['J','X']
                'J' → 'j' → resultado['j']=8
                'X' → 'x' → resultado['x']=8
                → resultado = {k=5, j=8, x=8}
            Iteración 3: points=10, letters=['Q','Z']
                'Q' → 'q' → resultado['q']=10
                'Z' → 'z' → resultado['z']=10
                → resultado = {k=5, j=8, x=8, q=10, z=10}

        Resultado: {k=5, j=8, x=8, q=10, z=10}

        └── Letras poco comunes valen más puntos. Cada letra se asigna a su valor.

    EJEMPLO 4: transform({}) — mapa vacío

        Entrada: source = {} (mapa vacío)

        Proceso:
            resultado = {}
            El forEach externo no itera (no hay entradas).
            resultado permanece vacío.
            return resultado

        Resultado: {}

        └── Caso borde: ninguna letra, resultado vacío.
*/
