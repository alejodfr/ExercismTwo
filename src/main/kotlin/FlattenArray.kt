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

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Aplanar un array anidado de cualquier profundidad en una sola
 *      lista, excluyendo los valores null que puedan aparecer.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Usar una pila (ArrayDeque) en vez de recursión para
 *           procesar los elementos de forma iterativa.
 *      II.  Sacar un elemento de la pila: si es null, ignorarlo; si es
 *           una colección, volver a meter sus elementos a la pila; si
 *           es un valor simple, guardarlo en el resultado.
 *      III. Como la pila procesa en orden LIFO (al revés), invertir el
 *           resultado una sola vez al final.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  val stack = ArrayDeque<Any?>()
 *      →  stack.addAll(source)
 *      ①  ArrayDeque funciona como pila: addAll mete todos los
 *          elementos de entrada tal cual, sin aplanar todavía.
 *
 *      →  while (stack.isNotEmpty()) {
 *      →      val element = stack.removeLast()
 *      ②  removeLast() saca el último elemento agregado (comportamiento
 *          de pila LIFO).
 *
 *      →      when (element) {
 *      →          null -> { /* Ignorar / No hace nada */ }
 *      ③  Si el elemento es null, la rama no hace nada: se descarta.
 *
 *      →          is Collection<*> -> {
 *      →              stack.addAll(element)
 *      ④  Si es una subcolección, se vuelven a meter sus elementos a
 *          la pila para procesarlos en las siguientes iteraciones.
 *
 *      →          else -> {
 *      →              result.add(element)
 *      ⑤  Si es un valor simple (no null, no colección), se agrega
 *          directamente al resultado.
 *      →          }
 *      →      }
 *      →  }
 *
 *      →  return result.reversed()
 *      ⑥  Como los elementos salen en orden inverso al de entrada
 *          (por ser pila), se invierte la lista una sola vez al final.
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN aplanar(origen: Coleccion): ListaDe<Any>
 *          resultado ← LISTA_VACIA
 *          pila ← PILA(origen)
 *          MIENTRAS pila NO esté vacía:
 *              elemento ← pila.SACAR_ULTIMO()
 *              SI elemento es nulo: CONTINUAR (ignorar)
 *              SINO SI elemento es Colección: pila.AGREGAR_TODOS(elemento)
 *              SINO: resultado.AGREGAR(elemento)
 *          DEVOLVER resultado.INVERTIR()
 *      FIN FUNCIÓN
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
