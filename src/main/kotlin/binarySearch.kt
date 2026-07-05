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

/**
 * ──────────────────────────────────────────────────────────────
 * BÚSQUEDA BINARIA (Binary Search) — Guía de estudio
 * ──────────────────────────────────────────────────────────────
 *
 * Busca un elemento en una lista ORDENADA dividiendo el espacio
 * de búsqueda a la mitad en cada paso.
 * PRECONDICIÓN: la lista debe estar ordenada de menor a mayor.
 *
 * CÓDIGO ANOTADO
 * ──────────────────────────────────────────────────────────────
 *
 * object BinarySearch {
 * │
 * ├── fun search(list: List<Int>, item: Int): Int {
 * │   │
 * │   ├── var left = 0
 * │   │   └── ─► left = índice izquierdo, empieza en 0.
 * │   │       var = mutable (cambia durante la búsqueda).
 * │   │
 * │   ├── var right = list.size - 1
 * │   │   └── ─► right = índice derecho (última posición).
 * │   │       Si hay 7 elementos, right = 7 - 1 = 6.
 * │   │
 * │   ├── while (left <= right) {
 * │   │   └── ─► Mientras left NO supere a right, hay
 * │   │       elementos por revisar. Si left > right,
 * │   │       el elemento no está y salimos del bucle.
 * │   │
 * │   ├── val mid = (left + right) / 2
 * │   │   └── ─► Calcula el índice del medio.
 * │   │       left=0, right=6 → mid = (0+6)/2 = 3
 * │   │       División de enteros trunca decimales.
 * │   │
 * │   ├── when {
 * │   │   │
 * │   │   ├── list[mid] == item -> return mid
 * │   │   │   └── ─► ¿El medio ES el que buscamos?
 * │   │   │       ¡Encontrado! Retornamos su índice.
 * │   │   │
 * │   │   ├── list[mid] < item -> left = mid + 1
 * │   │   │   └── ─► ¿El medio es MENOR que item?
 * │   │   │       El elemento está a la DERECHA.
 * │   │   │       Movemos left: descartamos mitad izquierda.
 * │   │   │
 * │   │   └── else -> right = mid - 1
 * │   │       └── ─► Si no es igual ni menor, es MAYOR.
 * │   │           El elemento está a la IZQUIERDA.
 * │   │           Movemos right: descartamos mitad derecha.
 * │   │
 * │   ├── } // fin del when
 * │   │
 * │   └── } // fin del while
 * │
 * ├── return throw NoSuchElementException("$item not found in list")
 * │   └── ─► Si el while termina sin encontrar (left > right),
 * │       lanzamos una excepción: "elemento no encontrado".
 * │       "$item" interpola el valor en el mensaje.
 * │
 * └── }
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE PALABRAS RESERVADAS
 * ──────────────────────────────────────────────────────────────
 *
 * Palabra  | Español     | Explicación
 * ─────────┼─────────────┼──────────────────────────────────────
 * object   | objeto      | Singleton (instancia única global)
 * fun      | función     | Declara una función o método
 * var      | variable    | Variable mutable (se puede reasignar)
 * val      | valor       | Variable inmutable (no reasignable)
 * Int      | entero      | Tipo de dato numérico entero
 * List     | lista       | Colección ordenada de elementos
 * while    | mientras    | Bucle que se repite mientras condición sea true
 * when     | cuando      | Expresión condicional múltiple (switch)
 * else     | si no       | Rama por defecto en when o if
 * return   | retornar    | Devuelve un valor y termina la función
 * throw    | lanzar      | Lanza una excepción e interrumpe el flujo
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE OPERADORES IMPORTANTES
 * ──────────────────────────────────────────────────────────────
 *
 * Operador | Nombre (ES)   | Explicación
 * ─────────┼───────────────┼─────────────────────────────────────
 * ==       | igual que     | Compara igualdad de valores
 * <        | menor que     | Compara si un valor es menor que otro
 * <=       | menor o igual | Compara menor o igual
 * >        | mayor que     | Compara si un valor es mayor que otro
 * /        | división      | División entera (trunca decimales)
 * +        | suma          | Suma aritmética
 * -        | resta         | Resta aritmética
 * =        | asignación    | Asigna un valor a una variable
 * ->       | flecha        | Separa condición de acción en when
 * .        | punto         | Accede a métodos y propiedades
 * $        | dólar         | Interpola variables en strings
 *
 * ──────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO
 * ──────────────────────────────────────────────────────────────
 *
 * PSEUDOCÓDIGO:
 * ─────────────
 *   función buscar(lista, elemento):
 *     izquierda = 0
 *     derecha = lista.tamaño - 1
 *
 *     mientras (izquierda <= derecha):
 *       medio = (izquierda + derecha) / 2
 *
 *       si lista[medio] == elemento:
 *         devolver medio                 ← encontrado
 *       si lista[medio] < elemento:
 *         izquierda = medio + 1          ← buscar derecha
 *       si no:
 *         derecha = medio - 1            ← buscar izquierda
 *
 *     lanzar Excepción("elemento no encontrado")
 *
 * EJEMPLO — buscar 23 en [4, 8, 12, 16, 23, 28, 32]:
 * ───────────────────────────────────────────────────
 *   Índices:  0   1   2   3   4   5   6
 *   Valores: [4,  8, 12, 16, 23, 28, 32]
 *
 *   Iteración 1:
 *     left=0  right=6  mid=(0+6)/2=3
 *     list[3]=16, 16 < 23 → left = 3+1 = 4
 *     └── Descartamos [4, 8, 12, 16]
 *
 *   Iteración 2:
 *     left=4  right=6  mid=(4+6)/2=5
 *     list[5]=28, 28 > 23 → right = 5-1 = 4
 *     └── Descartamos [28, 32]
 *
 *   Iteración 3:
 *     left=4  right=4  mid=(4+4)/2=4
 *     list[4]=23, 23 == 23 → ¡encontrado! Retorna 4 ✓
 *
 *   Solo 3 pasos para 7 elementos. Con búsqueda lineal
 *   habrían sido hasta 7 pasos. ¡La binaria es más rápida!
 *
 * EJEMPLO — buscar 99 en la misma lista:
 * ───────────────────────────────────────
 *   Itera hasta que left > right sin éxito.
 *   left=0→4→6→7, right=6→6→6→6
 *   left(7) > right(6) → sale del while
 *   → lanza NoSuchElementException("99 not found in list") ✗
 */