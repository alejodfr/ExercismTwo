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

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Se pide determinar si una palabra o frase es un isograma.
    Un isograma es una palabra sin letras repetidas. Los espacios y guiones
    pueden aparecer varias veces y se ignoran.

    OBJETIVOS:
    I.   Recibir una palabra o frase como String.
    II.  Filtrar (eliminar) los guiones y espacios.
    III. Convertir toodo a minúsculas para que la comparación no distinga
         mayúsculas de minúsculas.
    IV.  Verificar que NO haya letras repetidas:
         la longitud del texto filtrado debe ser igual a la cantidad de
         letras únicas (sin duplicados).
    V.   Devolver true si es isograma, false si no.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    Para resolver el problema se siguen estas etapas:

    I. LIMPIEZA DE LA CADENA
       a) Eliminar guiones: filter { it != '-' }
       b) Eliminar espacios: filter { it != ' ' }
       c) Convertir a minúsculas: .lowercase()
       └── Resultado: un String con solo letras, toodo en minúscula.

    II. DETECCION DE REPETICIONES
        a) letters.length: cuántos caracteres tiene el String filtrado.
        b) letters.toList(): convierte el String en una lista de Chars.
        c) .distinct(): elimina elementos duplicados de la lista.
        d) .size: cuántos elementos únicos quedan.
        e) Comparar: si length == size → no hay repetidos → true.

    III. LOGICA CENTRAL
         └── La línea return letters.length == letters.toList().distinct().size
             hace toodo el trabajo en UNA sola expresión.

    IV. INTERACCION CON USUARIO (main)
        └── Leer frase, llamar Isogram.isIsogram(frase), imprimir resultado.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ @file:Suppress("SpellCheckingInspection")                                │
    │                                                                          │
    │ object Isogram {                                                         │
    │                                                                          │
    │     fun isIsogram(input: String): Boolean {                              │
    │         val letters = input.filter { it != '-' && it != ' ' }.lowercase()│
    │         return letters.length == letters.toList().distinct().size        │
    │     }                                                                    │
    │ }                                                                        │
    │                                                                          │
    │ fun main(){                                                              │
    │     println("Type a word or phrase")                                     │
    │     val input = readln()                                                 │
    │     println("Is the word or phrase an isogram? ${Isogram.isIsogram(input)}")│
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   @file:Suppress("SpellCheckingInspection")
         └── Anotación a nivel de archivo que suprime advertencias de ortografía.
         └── Opcional; solo evita warnings en el IDE.

    II.  object
         └── Palabra reservada que declara un "objeto singleton".
         └── Crea UNA ÚNICA instancia de la clase, accesible globalmente.
         └── No es necesario usar new ni crear instancias con constructor.
         └── Analogía: el director ejecutivo de una empresa — solo hay uno.

    III. Isogram
         └── Nombre del objeto (y también su tipo).
         └── Por convención, comienza con mayúscula.

    IV.  fun
         └── Palabra reservada que declara una función.
         └── Analogía: una receta de cocina.

    V.   isIsogram
         └── Nombre de la función: "esIsograma".
         └── Sigue la convención camelCase (minúscula la primera letra,
             mayúscula en cada palabra siguiente).

    VI.  (input: String)
         └── Parámetro de entrada.
         └── input: nombre del parámetro (la frase a evaluar).
         └── : String — tipo de dato: cadena de texto.
         └── Analogía: la materia prima que entra a la máquina.

    VII. : Boolean
         └── Tipo de retorno: la función devuelve un valor booleano.
         └── Boolean solo tiene dos valores posibles: true (verdadero)
             o false (falso).

    VIII. { ... } (cuerpo de la función)
          └── Llaves que delimitan el bloque de código de la función.

    IX.  val letters = ...
         └── val: declara variable inmutable (de solo lectura).
         └── letters: nombre de la variable (letras).
         └── Guarda el resultado de la cadena procesada.

    X.   input.filter { it != '-' && it != ' ' }
         └── .filter { } — función que recorre el String y CONSERVA solo los
             caracteres que cumplen la condición entre llaves.
         └── it: cada carácter del String, uno por uno.
         └── it != '-' && it != ' ' : conserva los caracteres que NO son
             guion Y NO son espacio.
         └── !=: operador "diferente de".
         └── &&: operador "AND lógico" — ambas deben ser verdaderas.

    XI.  .lowercase()
         └── Métoodo que convierte TODOS los caracteres del String a
             minúsculas.
         └── "Hello".lowercase() → "hello"
         └── Sirve para que la comparación ignore mayúsculas/minúsculas.

    XII. return
         └── Palabra reservada "devolver".
         └── Finaliza la función y entrega el valor calculado.

    XIII. letters.length
          └── Propiedad que devuelve la longitud (cantidad de caracteres)
              del String letters.
          └── "hello".length → 5

    XIV. ==
         └── Operador de igualdad estructural.
         └── Compara si dos VALORES son iguales.
         └── 5 == 5 → true; 5 == 3 → false

    XV.  letters.toList()
         └── .toList() — métoodo que convierte el String en una lista de Chars.
         └── "hola".toList() → ['h', 'o', 'l', 'a']

    XVI. .distinct()
         └── Métoodo que elimina elementos DUPLICADOS de la lista.
         └── ['h','o','l','a'] → igual (todos únicos)
         └── ['h','e','l','l','o'] → ['h','e','l','o'] (la 'l' se repite)
         └── Analogía: poner todas las cartas sobre la mesa y luego retirar
             las que están repetidas, dejando solo una de cada tipo.

    XVII. .size
          └── Propiedad que devuelve el número de elementos de la lista.
          └── ['h','e','l','o'].size → 4

    XVIII. fun main()
           └── Función principal: punto de entrada del programa.

    XIX. println("...")
         └── Imprime texto en la consola.

    XX.  val input = readln()
         └── val: variable inmutable.
         └── readln(): lee una línea completa desde la consola.

    XXI. ${Isogram.isIsogram(input)}
         └── Interpolación de expresiones en Strings.
         └── ${ ... } ejecuta el código dentro de las llaves y convierte
             el resultado a texto.
         └── Isogram.isIsogram(input): llama a la función del objeto Isogram.
         └── Si devuelve true, se imprime "true"; si false, "false".

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO Isograma:

        FUNCION esIsograma(entrada: Texto): Booleano
            letras = entrada.filtrar(cada caracter c):
                         SI c NO es '-' Y c NO es ' ':
                             CONSERVAR c
                     .convertirAMinusculas()
            DEVOLVER letras.longitud == letras.convertirALista().sinDuplicados().tamano

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. IMPRIMIR "Type a word or phrase"
        2. LEER entrada DESDE consola
        3. IMPRIMIR "Is the word or phrase an isogram? " + esIsograma(entrada)

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: "six-year-old" — es un isograma (todas las letras son únicas)

        Entrada: "six-year-old"
        Proceso:
          filter { it != '-' && it != ' ' }
            "six-year-old" → "sixyearold"  (se eliminan los guiones)
          .lowercase()
            "sixyearold" → "sixyearold"    (ya está en minúsculas)
          letters.length → 10
          letters.toList() → ['s','i','x','y','e','a','r','o','l','d']
          .distinct() → ['s','i','x','y','e','a','r','o','l','d']
                        (todos son únicos, ningún cambio)
          .size → 10
          10 == 10 → true
        Resultado: true
        └── "six-year-old" SÍ es un isograma.

    EJEMPLO 2: "hello" — NO es un isograma (la 'l' se repite)

        Entrada: "hello"
        Proceso:
          filter: "hello" → "hello"  (no hay guiones ni espacios que quitar)
          .lowercase(): "hello" → "hello"
          letters.length → 5
          letters.toList() → ['h','e','l','l','o']
          .distinct() → ['h','e','l','o']  (la 'l' repetida se elimina)
          .size → 4
          5 == 4 → false
        Resultado: false
        └── "hello" NO es un isograma porque la letra 'l' aparece dos veces.

    EJEMPLO 3: "Lumberjacks" — es un isograma (todos los caracteres únicos)

        Entrada: "Lumberjacks"
        Proceso:
          filter: "Lumberjacks" → "Lumberjacks"  (sin guiones ni espacios)
          .lowercase(): "Lumberjacks" → "lumberjacks"
          letters.length → 11
          letters.toList() → ['l','u','m','b','e','r','j','a','c','k','s']
          .distinct() → ['l','u','m','b','e','r','j','a','c','k','s']
                        (todos únicos)
          .size → 11
          11 == 11 → true
        Resultado: true
        └── "Lumberjacks" SÍ es un isograma. La L mayúscula se normalizó a
            minúscula, así que no hay conflicto.
*/
