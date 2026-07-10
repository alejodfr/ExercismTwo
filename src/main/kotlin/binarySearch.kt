@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 *
 * Your task is to implement a binary search algorithm.
 *
 * A binary search algorithm finds an item in a list by repeatedly splitting it in half,
 * only keeping the half which contains the item we're looking for.
 * It allows us to quickly narrow down the possible locations of our item until we find it,
 * or until we've eliminated all possible locations.
 * **Caution:** Binary search only works when a list has been sorted.
 *
 * The algorithm looks like this:
 *
 *     Find the middle element of a sorted list and compare it with the item we're looking for.
 *     If the middle element is our item, then we're done!
 *     If the middle element is greater than our item, we can eliminate that element and all the elements after it.
 *     If the middle element is less than our item, we can eliminate that element and all the elements before it.
 *     If every element of the list has been eliminated then the item is not in the list.
 *     Otherwise, repeat the process on the part of the list that has not been eliminated.
 *
 * Here's an example:
 *
 * Let's say we're looking for the number 23 in the following sorted list: [4, 8, 12, 16, 23, 28, 32].
 *
 *     We start by comparing 23 with the middle element, 16.
 *     Since 23 is greater than 16, we can eliminate the left half of the list, leaving us with [23, 28, 32].
 *     We then compare 23 with the new middle element, 28.
 *     Since 23 is less than 28, we can eliminate the right half of the list: [23].
 *     We've found our item.
 */

object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1
        while (left <= right){
            val mid = (left + right) / 2
            when{
                list[mid] == item -> return mid  // encontrado
                list[mid] < item -> left = mid + 1 // busca derecha
                else            -> right = mid -1 // busca izquierda
            }
        }

        return throw NoSuchElementException("$item not found in list")
    }
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Implementar el algoritmo de búsqueda binaria (binary search).

    Dada una lista ORDENADA de menor a mayor, encontrar un elemento
    dividiendo repetidamente el espacio de búsqueda a la mitad.

    OBJETIVOS:
    I.   Establecer límites izquierdo (0) y derecho (tamaño - 1).
    II.  Mientras left ≤ right, calcular el índice medio.
    III. Comparar el elemento en la posición media con el buscado:
         - Si es igual → devolver el índice.
         - Si es menor → descartar mitad izquierda (left = mid + 1).
         - Si es mayor → descartar mitad derecha (right = mid - 1).
    IV.  Si el bucle termina sin éxito, lanzar NoSuchElementException.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. INICIALIZACION
       └── left = 0 (primer índice de la lista).
       └── right = list.size - 1 (último índice).

    II. BUCLE PRINCIPAL (while)
        └── while (left <= right): mientras el espacio de búsqueda no esté vacío.
        └── mid = (left + right) / 2 (índice del elemento central).
        └── División entera: trunca decimales (ej: (0+6)/2 = 3).

    III. COMPARACION CON when
         └── list[mid] == item → encontrado, devolver mid.
         └── list[mid] < item  → el elemento está a la derecha: left = mid + 1.
         └── else              → el elemento está a la izquierda: right = mid - 1.

    IV. FIN DEL BUCLE
        └── Si left > right, el elemento no existe.
        └── throw NoSuchElementException(...)  → lanza excepción.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object BinarySearch {                                                    │
    │     fun search(list: List<Int>, item: Int): Int {                        │
    │         var left = 0                                                     │
    │         var right = list.size - 1                                        │
    │         while (left <= right){                                           │
    │             val mid = (left + right) / 2                                 │
    │             when{                                                        │
    │                 list[mid] == item -> return mid                          │
    │                 list[mid] < item -> left = mid + 1                       │
    │                 else            -> right = mid - 1                       │
    │             }                                                            │
    │         }                                                                │
    │         return throw NoSuchElementException("$item not found in list")   │
    │     }                                                                    │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada: crea un singleton (instancia única global).
         └── Analogía: una biblioteca pública — solo hay una en la ciudad.

    II.  BinarySearch
         └── Nombre del objeto. Identificador con mayúscula inicial.

    III. fun
         └── Palabra reservada "function". Define una función/método.

    IV.  search
         └── Nombre de la función: "buscar".

    V.   (list: List<Int>, item: Int)
         └── Parámetros de entrada.
         └── list: List<Int> — lista de números enteros ordenados.
         └── List: colección ordenada de elementos.
         └── <Int>: tipo genérico — la lista contiene solo Ints.
         └── item: Int — el elemento que se desea encontrar.

    VI.  : Int
         └── Tipo de retorno: la función devuelve un entero (el índice).

    VII. var
         └── Variable MUTABLE (se puede reasignar).
         └── Analogía: una pizarra blanca — puedes cambiar lo escrito.

    VIII. left / right
         └── left: índice izquierdo (inicio del segmento actual).
         └── right: índice derecho (fin del segmento actual).
         └── Se actualizan en cada iteración para reducir la búsqueda.

    IX.  = 0 / = list.size - 1
         └── Asignación inicial.
         └── list.size: propiedad que devuelve la cantidad de elementos.
         └── list.size - 1: último índice válido (los índices empiezan en 0).

    X.   while (condición) { ... }
         └── Bucle "mientras": repite el bloque MIENTRAS la condición sea true.
         └── Analogía: "Mientras no encuentres la llave, sigue buscando."

    XI.  <=
         └── Operador "menor o igual que". left <= right → ¿aún hay elementos?

    XII. val
         └── Variable INMUTABLE (no se puede reasignar).
         └── mid se calcula una vez por iteración y no cambia dentro de ella.

    XIII. mid
         └── Índice del elemento central: (left + right) / 2.
         └── División entera: (0 + 6) / 2 = 3; (4 + 6) / 2 = 5.

    XIV. / (división)
         └── Operador de división. En enteros, trunca los decimales.
         └── 5 / 2 = 2 (no 2.5).

    XV.  + (suma)
         └── Suma left + right para calcular el punto medio.

    XVI. - (resta)
         └── left = mid + 1: mueve el límite izquierdo hacia la derecha.
         └── right = mid - 1: mueve el límite derecho hacia la izquierda.

    XVII. when { ... }
         └── Expresión condicional múltiple (similar a switch en otros lenguajes).
         └── Evalúa condiciones en orden hasta encontrar una verdadera.
         └── Analogía: un clasificador de correo — según el código postal, va a un destino.

    XVIII. list[mid]
         └── Accede al elemento en la posición mid de la lista.
         └── Los corchetes [] son el operador de índice.
         └── Analogía: buscar en un casillero numerado — el número es el índice.

    XIX. ==
         └── Operador de igualdad: compara valores (no referencias).
         └── list[mid] == item → "¿son iguales el elemento medio y el buscado?"

    XX.  <
         └── Operador "menor que".

    XXI. ->
         └── Flecha en when: separa la condición de la acción.
         └── "si se cumple esto → haz aquello".

    XXII. else (en when)
         └── Rama por defecto: se ejecuta si ninguna condición anterior coincide.

    XXIII. return
         └── Termina la función y devuelve el valor.
         └── return mid → devuelve el índice donde se encontró el elemento.

    XXIV. throw
         └── Palabra reservada: lanza una excepción (error controlado).
         └── Interrumpe el flujo normal del programa.

    XXV. NoSuchElementException("...")
         └── Tipo de excepción: "elemento no encontrado".
         └── El mensaje entre paréntesis describe el error.

    XXVI. "$item not found in list"
         └── Plantilla de cadena: $item inserta el valor buscado en el texto.
         └── Ej: si item = 99 → "99 not found in list".

    XXVII. { } (llaves)
         └── Delimitan bloques de código (función, while, when).

    XXVIII. ( ) (paréntesis)
         └── Agrupan condiciones (while), parámetros (función), argumentos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO BusquedaBinaria:
        FUNCION buscar(lista, elemento):
            izquierda = 0
            derecha = lista.tamaño - 1

            MIENTRAS (izquierda <= derecha):
                medio = (izquierda + derecha) / 2

                SEGUN:
                    CASO lista[medio] == elemento:
                        DEVOLVER medio
                    CASO lista[medio] < elemento:
                        izquierda = medio + 1
                    SINO:
                        derecha = medio - 1

            LANZAR Excepcion("elemento no encontrado")

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Buscar 23 en [4, 8, 12, 16, 23, 28, 32] (sí existe)

        lista = [4, 8, 12, 16, 23, 28, 32]  (tamaño = 7)
        item = 23

        Iteración 1:  left=0, right=6, mid=(0+6)/2=3
            list[3] = 16
            ¿16 == 23? → NO   ¿16 < 23? → SÍ
            left = 3+1 = 4   (descartamos [4, 8, 12, 16])

        Iteración 2:  left=4, right=6, mid=(4+6)/2=5
            list[5] = 28
            ¿28 == 23? → NO   ¿28 < 23? → NO
            else → right = 5-1 = 4   (descartamos [28, 32])

        Iteración 3:  left=4, right=4, mid=(4+4)/2=4
            list[4] = 23
            ¿23 == 23? → SÍ → return 4

        Resultado: 4 (el elemento está en el índice 4)
        └── Solo 3 pasos para 7 elementos. Con búsqueda lineal serían hasta 7.

    EJEMPLO 2: Buscar 1 en [1, 3, 5, 7, 9] (primer elemento)

        lista = [1, 3, 5, 7, 9]  (tamaño = 5)
        item = 1

        Iteración 1:  left=0, right=4, mid=(0+4)/2=2
            list[2] = 5
            ¿5 < 1? → NO   else: right = 2-1 = 1

        Iteración 2:  left=0, right=1, mid=(0+1)/2=0
            list[0] = 1
            ¿1 == 1? → SÍ → return 0

        Resultado: 0 (índice del primer elemento)

    EJEMPLO 3: Buscar 99 en [4, 8, 12, 16, 23, 28, 32] (no existe)

        lista = [4, 8, 12, 16, 23, 28, 32]
        item = 99

        Iteración 1:  left=0, right=6, mid=3  → 16 < 99 → left=4
        Iteración 2:  left=4, right=6, mid=5  → 28 < 99 → left=6
        Iteración 3:  left=6, right=6, mid=6  → 32 < 99 → left=7
        Condición: left=7, right=6 → 7 <= 6? → FALSO → sale del while

        Resultado: throw NoSuchElementException("99 not found in list")
        └── El bucle termina sin encontrar el elemento. Se lanza excepción.
*/
