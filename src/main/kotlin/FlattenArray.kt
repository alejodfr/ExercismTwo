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



// ▶ object Flattener {
//   └▶ ① object → singleton: una única instancia con nombre Flattener.
object Flattener {
    // ▶ fun flatten(source: Collection<Any?>): List<Any> {
    //   └▶ ② recibe una colección anidada (con posibles null) y devuelve
    //           una lista plana sin null.
    fun flatten(source: Collection<Any?>): List<Any> {
        // ▶ val result = mutableListOf<Any>()
        //   └▶ ③ acumulador del resultado ya aplanado.
        val result = mutableListOf<Any>()

        // ▶ val stack = ArrayDeque<Any?>()
        // ▶ stack.addAll(source)
        //   └▶ ④ ArrayDeque usado como pila: addAll mete los elementos de
        //           entrada tal cual, sin aplanar todavía.
        val stack = ArrayDeque<Any?>()
        stack.addAll(source)

        // ▶ while (stack.isNotEmpty()) {
        //   └▶ ⑤ se repite mientras queden elementos por procesar.
        while (stack.isNotEmpty()) {
            // ▶ val element = stack.removeLast()
            //   └▶ ⑥ removeLast() → saca el último agregado (comportamiento LIFO).
            val element = stack.removeLast()

            // ▶ when (element) {
            when (element) {
                // ▶ null -> { }
                //   └▶ ⑦ si es null, la rama no hace nada: se descarta.
                null -> { /* Ignorar / No hace nada */ }

                // ▶ is Collection<*> -> { stack.addAll(element) }
                //   └▶ ⑧ si es una subcolección, se vuelven a meter sus
                //           elementos a la pila para procesarlos después.
                is Collection<*> -> {
                    stack.addAll(element)
                }

                // ▶ else -> { result.add(element) }
                //   └▶ ⑨ si es un valor simple (no null, no colección), va
                //           directo al resultado.
                else -> {
                    result.add(element)
                }
            }
        }

        // ▶ return result.reversed()
        //   └▶ ⑩ los elementos salieron en orden inverso al de entrada (por
        //           ser pila): se invierte la lista una sola vez al final.
        return result.reversed()
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Aplanar un array anidado de cualquier profundidad en una sola
 *      lista, excluyendo los valores null que puedan aparecer.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Recursión clásica: fun flatten(list) = list.flatMap { if
 *          (it is Collection<*>) flatten(it) else listOfNotNull(it) }.
 *      B)  Usar una Queue (FIFO) con addFirst/removeFirst para
 *          preservar el orden original sin necesidad de invertir al
 *          final.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "flatten([1, [2, 3]])"
 *      ─────────────────────────────────────────────────────────
 *      pila=[1,[2,3]] → saca [2,3] → mete 2,3 → pila=[1,2,3]
 *      saca 3→result=[3]; saca 2→result=[3,2]; saca 1→result=[3,2,1]
 *      reversed() → [1,2,3]
 *      Resultado: [1, 2, 3]
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "flatten([1, [2, 6, null], [[null, [4]], 5]])"
 *      ─────────────────────────────────────────────────────────
 *      Cada null se ignora; las subcolecciones se desanidan
 *      recursivamente vía la pila.
 *      Resultado: [1, 2, 6, 4, 5]
 *
 *  ================================================================
 */
