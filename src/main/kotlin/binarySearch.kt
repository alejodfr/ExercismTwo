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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Implementar búsqueda binaria: encontrar el índice de un
 *      elemento en una lista ordenada dividiendo repetidamente el
 *      espacio de búsqueda a la mitad.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Establecer límites left = 0 y right = size - 1.
 *      II.  Mientras left <= right, calcular el índice medio.
 *      III. Comparar el elemento medio con el buscado: si es igual,
 *           devolver el índice; si es menor, descartar la mitad
 *           izquierda; si es mayor, descartar la mitad derecha.
 *      IV.  Si el bucle termina sin encontrar el elemento, lanzar
 *           NoSuchElementException.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun search(list: List<Int>, item: Int): Int {
 *      →      var left = 0
 *      →      var right = list.size - 1
 *      ①  left y right delimitan el segmento de búsqueda actual.
 *
 *      →      while (left <= right){
 *      ②  Mientras quede al menos un elemento por revisar.
 *
 *      →          val mid = (left + right) / 2
 *      ③  División entera: índice del elemento central del segmento.
 *
 *      →          when{
 *      →              list[mid] == item -> return mid
 *      ④  Si coincide, se encontró: devuelve el índice de inmediato.
 *
 *      →              list[mid] < item -> left = mid + 1
 *      ⑤  Si el medio es menor que el buscado, descarta la mitad
 *          izquierda moviendo left justo después de mid.
 *
 *      →              else            -> right = mid -1
 *      ⑥  Si es mayor, descarta la mitad derecha moviendo right justo
 *          antes de mid.
 *      →          }
 *      →      }
 *
 *      →      return throw NoSuchElementException("$item not found in list")
 *      ⑦  Si el bucle termina (left > right), el elemento no existe.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Versión recursiva: search(list, item, left, right) que se
 *          llama a sí misma sobre la mitad correspondiente.
 *      B)  Devolver Int? (nullable) en vez de lanzar excepción, y que
 *          el llamador decida cómo manejar el caso "no encontrado".
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN buscar(lista, elemento): Entero
 *          izquierda ← 0
 *          derecha ← lista.tamaño - 1
 *          MIENTRAS izquierda <= derecha:
 *              medio ← (izquierda + derecha) / 2
 *              SI lista[medio] == elemento: DEVOLVER medio
 *              SINO SI lista[medio] < elemento: izquierda ← medio + 1
 *              SINO: derecha ← medio - 1
 *          LANZAR Error("elemento no encontrado")
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "search([4,8,12,16,23,28,32], 23)"
 *      ─────────────────────────────────────────────────────────
 *      left=0,right=6,mid=3→16<23→left=4
 *      left=4,right=6,mid=5→28>23→right=4
 *      left=4,right=4,mid=4→23==23→return 4
 *      Resultado: 4
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "search([4,8,12,16,23,28,32], 99)"
 *      ─────────────────────────────────────────────────────────
 *      El bucle reduce left/right hasta left > right sin encontrar 99.
 *      Resultado: lanza NoSuchElementException("99 not found in list")
 *
 *  ================================================================
 */
