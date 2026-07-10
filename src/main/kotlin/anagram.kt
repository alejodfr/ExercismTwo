@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * At a garage sale, you find a lovely vintage typewriter at a bargain price!
 * Excitedly, you rush home, insert a sheet of paper, and start typing away.
 * However, your excitement wanes when you examine the output: all words are
 * garbled! For example, it prints "stop" instead of "post" and "least"
 * instead of "stale." Carefully, you try again, but now it prints "spot" and
 * "slate." After some experimentation, you find there is a random delay
 * before each letter is printed, which messes up the order. You now
 * understand why they sold it for so little money!
 *
 * You realize this quirk allows you to generate anagrams, which are words
 * formed by rearranging the letters of another word. Pleased with your
 * finding, you spend the rest of the day generating hundreds of anagrams.
 *
 * Instructions
 *
 * Given a target word and one or more candidate words, your task is to find
 * the candidates that are anagrams of the target.
 *
 * An anagram is a rearrangement of letters to form a new word: for example
 * "owns" is an anagram of "snow". A word is not its own anagram: for
 * example, "stop" is not an anagram of "stop".
 *
 * The target word and candidate words are made up of one or more ASCII
 * alphabetic characters (A-Z and a-z). Lowercase and uppercase characters
 * are equivalent: for example, "PoTS" is an anagram of "sTOp", but "StoP"
 * is not an anagram of "sTOp". The words you need to find should be taken
 * from the candidate words, using the same letter case.
 *
 * Given the target "stone" and the candidate words "stone", "tones",
 * "banana", "tons", "notes", and "Seton", the anagram words you need to
 * find are "tones", "notes", and "Seton".
 *
 * Track specific instructions
 *
 * The anagrams can be returned in any order.
 */

class Anagram(val target: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { candidate ->
            candidate.lowercase() != target.lowercase() &&
            candidate.lowercase().toList().sorted() == target.lowercase().toList().sorted()
        }.toSet()
    }
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Dada una palabra objetivo (target) y una o más palabras candidatas,
    encontrar las candidatas que son anagramas del objetivo.

    Un anagrama es una reorganización de letras para formar una nueva palabra.
    Una palabra NO es su propio anagrama.

    OBJETIVOS:
    I.   Recibir la palabra objetivo en el constructor de la clase Anagram.
    II.  Implementar match() que recibe una colección de palabras candidatas.
    III. Detectar cuáles candidatas son anagramas del target:
         - Mismas letras, distinto orden.
         - Ignorar diferencias entre mayúsculas y minúsculas.
    IV.  Excluir la propia palabra objetivo de los resultados.
    V.   Devolver los resultados como un Set (colección sin duplicados).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I.  ALMACENAR LA PALABRA OBJETIVO
        └── El constructor primario recibe target: String.
        └── Al poner "val" en el parámetro, Kotlin lo convierte automáticamente
            en propiedad de la clase, accesible desde cualquier método.

    II. RECIBIR LA LISTA DE CANDIDATOS
        └── El método match(anagrams: Collection<String>) recibe una colección
            de strings (puede ser List, Set, etc.).
        └── Devuelve Set<String> para evitar duplicados.

    III. FILTRAR CADA CANDIDATO
        a) Convertir candidato y target a minúsculas con .lowercase().
           └── Así "STONE" y "stone" se comparan igual.
        b) Verificar que candidato != target (una palabra no es anagrama de sí misma).
        c) Convertir ambas palabras a lista de caracteres con .toList().
        d) Ordenar las listas con .sorted().
           └── Si dos palabras tienen las mismas letras, al ordenarlas quedan IGUALES.
        e) Comparar las listas ordenadas con ==.
           └── Si coinciden → es un anagrama.

    IV. ENTREGAR EL RESULTADO
        └── El filter devuelve una List. Con .toSet() la convertimos a Set.
        └── Set garantiza que no haya palabras repetidas en la salida.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ class Anagram(val target: String) {                                     │
    │     fun match(anagrams: Collection<String>): Set<String> {              │
    │         return anagrams.filter { candidate ->                           │
    │             candidate.lowercase() != target.lowercase() &&              │
    │             candidate.lowercase().toList().sorted() ==                  │
    │                 target.lowercase().toList().sorted()                    │
    │         }.toSet()                                                       │
    │     }                                                                   │
    │ }                                                                       │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   class
         └── Palabra reservada: "clase". Define una plantilla para crear objetos.
         └── Analogía: un molde para hacer galletas. Defines la forma una vez
             y creas muchas galletas con esa forma.

    II.  Anagram
         └── Nombre de la clase. Por convención en Kotlin, comienza con mayúscula.

    III. (val target: String)
         └── Constructor primario: paréntesis después del nombre de la clase.
         └── val: declara el parámetro como propiedad INMUTABLE de la clase.
         └── target: nombre del parámetro. Almacena la palabra objetivo.
         └── : String: el tipo de dato es "cadena de texto".
         └── Analogía: el nombre de la persona que buscas en una lista.

    IV.  {
         └── Llave de apertura del cuerpo de la clase.

    V.   fun
         └── Palabra reservada: "function". Define una función o método.
         └── Analogía: una receta de cocina con pasos a seguir.

    VI.  match
         └── Nombre del método: significa "emparejar" o "encontrar coincidencias".

    VII. (anagrams: Collection<String>)
         └── Parámetro: lista de palabras candidatas.
         └── anagrams: nombre del parámetro.
         └── : Collection<String>: tipo "Colección de Strings".
         └── Collection es una interfaz genérica que incluye List, Set, etc.

    VIII. : Set<String>
          └── Tipo de retorno: "Conjunto de Strings".
          └── Set: colección que NO permite elementos duplicados.
          └── Analogía: una bolsa de compras donde cada producto solo puede estar una vez.

    IX.  return
         └── Palabra reservada: "retornar". Devuelve un valor y termina la función.

    X.   anagrams.filter { ... }
         └── filter: función de orden superior.
         └── Recorre cada elemento y conserva solo aquellos para los que
             la lambda (el bloque entre llaves) devuelve true.
         └── Analogía: un colador de cocina — solo pasan los ingredientes
             que son lo suficientemente pequeños.

    XI.  candidate ->
         └── Lambda con parámetro EXPLÍCITO (en lugar del implícito it).
         └── candidate: nombre temporal para cada elemento de la colección.
         └── ->: flecha que separa el parámetro del cuerpo de la lambda.
         └── Analogía: "para cada elemento al que llamaré candidato, haz..."

    XII. candidate.lowercase() / target.lowercase()
         └── .lowercase(): método de String que convierte a MINÚSCULAS.
         └── "StOne" → "stone". Ignora diferencias de mayúsculas/minúsculas.
         └── Analogía: ponerse gafas que hacen que todas las letras se vean
             del mismo tamaño.

    XIII. !=
          └── Operador "distinto de".
          └── Devuelve true si los dos valores NO son iguales.
          └── Aquí: "candidato NO debe ser igual a target".

    XIV. &&  (AND lógico)
         └── Operador "Y". Ambas condiciones deben ser true.
         └── true && true = true, cualquier otra combinación = false.
         └── Analogía: para subir a una montaña rusa necesitas medir más de 1.40m
             Y no tener miedo a las alturas.

    XV.  .toList()
         └── Método de String que convierte la cadena en una List<Char>.
         └── "stone" → ['s', 't', 'o', 'n', 'e'].
         └── Analogía: desarmar una palabra en fichas de Scrabble sueltas.

    XVI. .sorted()
         └── Método de List que ordena los elementos ascendentemente (A-Z).
         └── ['s','t','o','n','e'] → ['e','n','o','s','t'].
         └── Analogía: ordenar las fichas de Scrabble alfabéticamente.

    XVII. ==
          └── Operador de igualdad estructural.
          └── Compara si dos objetos tienen el MISMO CONTENIDO (valor).
          └── NO compara referencias (direcciones de memoria).
          └── Ej: [e,n,o,s,t] == [e,n,o,s,t] → true.

    XVIII. .toSet()
           └── Convierte la lista resultante a un Set (conjunto).
           └── Elimina cualquier posible duplicado.
           └── Analogía: al pasar por la puerta giratoria, las personas repetidas
               solo entran una vez.

    XIX.  }
          └── Llave de cierre del cuerpo del método match.

    XX.   }
          └── Llave de cierre del cuerpo de la clase Anagram.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE Anagrama
        ENTRADA: objetivo (texto)

        FUNCION coincidir(candidatos):
            resultado = candidatos.FILTRAR { candidato ->
                candidato.MINUSCULAS() DIFERENTE objetivo.MINUSCULAS()
                Y
                candidato.MINUSCULAS().A_LISTA().ORDENADO() IGUAL
                objetivo.MINUSCULAS().A_LISTA().ORDENADO()
            }
            DEVOLVER resultado.A_CONJUNTO()

    ───────────────────────────────────────────────────────────────────────────

    ALGORITMO PASO A PASO:
    1. Recibir la palabra objetivo en el constructor.
    2. Recibir la colección de candidatos en match().
    3. Para cada candidato:
       a. Ignorar mayúsculas/minúsculas (todo a minúsculas).
       b. Si el candidato es la misma palabra que el target → saltar.
       c. Descomponer ambas palabras en listas de caracteres.
       d. Ordenar ambas listas alfabéticamente.
       e. Si las listas ordenadas son iguales → el candidato ES un anagrama.
    4. Devolver todos los anagramas encontrados como un conjunto (Set).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Anagram("stone").match(["stone", "tones", "banana", "notes", "Seton"])

        Entrada:  target = "stone"
                  candidatos = ["stone", "tones", "banana", "notes", "Seton"]

        ┌──────────┬───────────────┬───────────────┬──────────────┬──────────┐
        │Candidato │ lower != target│ lower.toList │ .sorted()    │Anagrama? │
        │          │  .lowercase()  │   .sorted()  │ == target's  │          │
        ├──────────┼───────────────┼───────────────┼──────────────┼──────────┤
        │ "stone"  │ stone==stone→F│ [e,n,o,s,t]  │ IGUAL        │ NO ✗    │
        │ "tones"  │ tones!=stone→T│ [e,n,o,s,t]  │ IGUAL        │ SÍ ✓    │
        │ "banana" │ banana!=stone→T│[a,a,a,b,n,n]│ DIFERENTE    │ NO ✗    │
        │ "notes"  │ notes!=stone→T│ [e,n,o,s,t]  │ IGUAL        │ SÍ ✓    │
        │ "Seton"  │ seton!=stone→T│ [e,n,o,s,t]  │ IGUAL        │ SÍ ✓    │
        └──────────┴───────────────┴───────────────┴──────────────┴──────────┘

        Resultado: {"tones", "notes", "Seton"}

        Explicación: "stone" se descarta por ser la palabra objetivo.
        "tones", "notes" y "Seton" tienen las mismas letras [e,n,o,s,t].
        "banana" tiene letras diferentes → descartado.

    EJEMPLO 2: Anagram("listen").match(["enlist", "inlets", "silent", "list", "tinsel"])

        Entrada:  target = "listen"
                  candidatos = ["enlist", "inlets", "silent", "list", "tinsel"]

        sorted(target) = [e,i,l,n,s,t]

        "enlist":  sorted = [e,i,l,n,s,t] → IGUAL → SÍ ✓
        "inlets":  sorted = [e,i,l,n,s,t] → IGUAL → SÍ ✓
        "silent":  sorted = [e,i,l,n,s,t] → IGUAL → SÍ ✓
        "list":    sorted = [i,l,s,t] → DIFERENTE (falta e,n) → NO ✗
        "tinsel":  sorted = [e,i,l,n,s,t] → IGUAL → SÍ ✓

        Resultado: {"enlist", "inlets", "silent", "tinsel"}

        Explicación: "list" solo tiene 4 letras, no puede ser anagrama
        de "listen" que tiene 6 letras.

    EJEMPLO 3: Anagram("Elvis").match(["lives", "Levis", "evil", "velis", "elvis"])

        Entrada:  target = "Elvis"
                  candidatos = ["lives", "Levis", "evil", "velis", "elvis"]

        sorted(target.lowercase()) = [e,i,l,s,v]

        "lives":  lower "lives" != "elvis" → T, sorted [e,i,l,s,v] → IGUAL → SÍ ✓
        "Levis":  lower "levis" != "elvis" → T, sorted [e,i,l,s,v] → IGUAL → SÍ ✓
        "evil":   sorted [e,i,l,v] → DIFERENTE (falta s) → NO ✗
        "velis":  lower "velis" != "elvis" → T, sorted [e,i,l,s,v] → IGUAL → SÍ ✓
        "elvis":  lower "elvis" == "elvis" → F (es la misma palabra) → NO ✗

        Resultado: {"lives", "Levis", "velis"}

        Explicación: "evil" tiene solo 4 letras. "elvis" se descarta por ser
        la palabra objetivo. "Levis" se incluye porque la comparación ignora
        mayúsculas/minúsculas.
*/
