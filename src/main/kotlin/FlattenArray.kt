@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * A shipment of emergency supplies has arrived, but there's a problem.
 * To protect from damage, the items — flashlights, first-aid kits,
 * blankets — are packed inside boxes, and some of those boxes are
 * nested several layers deep inside other boxes!
 *
 * To be prepared for an emergency, everything must be easily accessible
 * in one box. Can you unpack all the supplies and place them into a
 * single box, so they're ready when needed most?
 *
 * Instructions
 *
 * Take a nested array of any depth and return a fully flattened array.
 *
 * Note that some language tracks may include null-like values in the
 * input array, and the way these values are represented varies by track.
 * Such values should be excluded from the flattened array.
 *
 * Additionally, the input may be of a different data type and contain
 * different types, depending on the track.
 *
 * Check the test suite for details.
 *
 * Example
 *
 * input:  [1, [2, 6, null], [[null, [4]], 5]]
 *
 * output: [1, 2, 6, 4, 5]
 */



object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val result = mutableListOf<Any>()

        // 1. Cargamos la pila inicial (los metemos tal cual)
        val stack = ArrayDeque<Any?>()
        stack.addAll(source)

        // 2. Procesamos mientras la pila no esté vacía
        while (stack.isNotEmpty()) {
            val element = stack.removeLast()

            when (element) {
                null -> { /* Ignorar / No hace nada */ }

                is Collection<*> -> {
                    // Volvemos a meter los sub-elementos a la pila
                    stack.addAll(element)
                }

                else -> {
                    // Guardamos el valor en nuestra lista acumuladora
                    result.add(element)
                }
            }
        }

        // 3. Como los sacamos en orden LIFO (al revés),
        //    invertimos 'result' una sola vez al final
        return result.reversed()
    }
}

/**
 * Míralo en acción con un ejemplo simple:
 *
 * Si la entrada es [1, [2, 3]]:
 *
 *   1. stack recibe [1, [2, 3]]
 *   2. removeLast() saca [2, 3] y al ser una colección mete 2 y 3 a la pila
 *   3. removeLast() saca 3 -> result: [3]
 *   4. removeLast() saca 2 -> result: [3, 2]
 *   5. removeLast() saca 1 -> result: [3, 2, 1]
 *   6. result.reversed() -> devuelve [1, 2, 3]
 *
 * ¡Has implementado un algoritmo iterativo para desanidar estructuras usando ArrayDeque!
 */