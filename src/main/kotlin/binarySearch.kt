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
 * GUÍA DE RESOLUCIÓN - BÚSQUEDA BINARIA (BINARY SEARCH)
 * ======================================================
 *
 * La búsqueda binaria encuentra un elemento en una lista ordenada
 * dividiendo repetidamente el espacio de búsqueda a la mitad.
 *
 * Precondición: la lista debe estar ORDENADA de menor a mayor.
 *
 *
 * ──────────────────────────────────────────────────────────────────
 * Explicación línea por línea del código en el objeto:
 * ──────────────────────────────────────────────────────────────────
 *
 * object BinarySearch {
 * │
 * │  La palabra reservada 'object' en Kotlin significa "objeto".
 * │  Crea una única instancia (singleton) de la clase.
 * │  A diferencia de 'class', no necesitamos instanciar con ().
 * │  Similar a un "objeto estático" en otros lenguajes.
 * │
 * │  Concepto: una 'object declaration' define un singleton.
 * │  En español diríamos: "declaración de objeto".
 * │
 * │  Analogía en Java: sería como una clase con todos sus métodos static.
 * │
 * ──────────────────────────────────────────────────────────────────
 *
 *     fun search(list: List<Int>, item: Int): Int {
 *     │  │      │    │          │    │       │
 *     │  │      │    │          │    │       └── Int: tipo de retorno (entero).
 *     │  │      │    │          │    │           Palabra reservada. Significa "entero".
 *     │  │      │    │          │    │           En español: "tipo entero".
 *     │  │      │    │          │    │
 *     │  │      │    │          │    └── Int: tipo del parámetro 'item'.
 *     │  │      │    │          │        Palabra reservada. En español: "tipo entero".
 *     │  │      │    │          │
 *     │  │      │    │          └── item: nombre del parámetro (el elemento a buscar).
 *     │  │      │    │              Significa "elemento" o "ítem".
 *     │  │      │    │
 *     │  │      │    └── , : separa los parámetros de la función.
 *     │  │      │
 *     │  │      └── list: nombre del primer parámetro (la lista ordenada).
 *     │  │          Significa "lista".
 *     │  │
 *     │  └── List<Int>: tipo del primer parámetro.
 *     │      List es una interfaz de lista ordenada (colección).
 *     │      <Int> es un tipo genérico: lista de enteros.
 *     │      Palabra reservada. En español: "lista de enteros".
 *     │
 *     └── fun: palabra reservada que declara una función.
 *         En español: "función".
 *         Sintaxis: fun nombreDeFuncion(parametro: Tipo): TipoRetorno { ... }
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         var left = 0
 *         │   │    │
 *         │   │    └── 0: valor inicial (extremo izquierdo del array).
 *         │   │
 *         │   └── left: nombre de la variable. Significa "izquierda".
 *         │       Almacena el índice del límite izquierdo de búsqueda.
 *         │
 *         └── var: palabra reservada. Declara una variable MUTABLE
 *             (su valor puede reasignarse/cambiarse).
 *             Significa "variable".
 *             En español: "variable mutable".
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         var right = list.size - 1
 *         │   │      │    │     │
 *         │   │      │    │     └── 1: se resta 1 porque los índices
 *         │   │      │    │         empiezan en 0. Si hay 7 elementos,
 *         │   │      │    │         el último índice es 6.
 *         │   │      │    │
 *         │   │      │    └── list.size: propiedad que devuelve la
 *         │   │      │        cantidad de elementos de la lista.
 *         │   │      │        En español: "tamaño de la lista".
 *         │   │      │
 *         │   │      └── = : operador de asignación.
 *         │   │          Asigna el valor de la derecha a la variable.
 *         │   │
 *         │   └── right: nombre de la variable. Significa "derecha".
 *         │       Almacena el índice del límite derecho de búsqueda.
 *         │       Inicialmente es el último índice de la lista.
 *         │
 *         └── var: palabra reservada. Variable mutable.
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         while (left <= right) {
 *         │     │    │   │
 *         │     │    │   └── right: límite derecho actual.
 *         │     │    │
 *         │     │    └── <= : operador "menor o igual que".
 *         │     │        Mientras left sea menor o igual que right,
 *         │     │        aún hay elementos por revisar.
 *         │     │        En español: "menor o igual que".
 *         │     │
 *         │     └── left: límite izquierdo actual.
 *         │
 *         └── while: palabra reservada. Significa "mientras".
 *             Crea un bucle que se repite MIENTRAS la condición
 *             entre paréntesis sea verdadera (true).
 *             En español: "mientras".
 *             Sintaxis: while (condición) { ... }
 *             Es una estructura de control de flujo.
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *             val mid = (left + right) / 2
 *             │   │    │    │   │      │
 *             │   │    │    │   │      └── 2: se divide entre 2 para
 *             │   │    │    │   │          encontrar el punto medio.
 *             │   │    │    │   │
 *             │   │    │    │   └── / : operador de división entera.
 *             │   │    │    │       En Kotlin, la división entre Int
 *             │   │    │    │       trunca los decimales.
 *             │   │    │    │       En español: "división entera".
 *             │   │    │    │
 *             │   │    │    └── + : operador de suma.
 *             │   │    │        En español: "más" (operador suma).
 *             │   │    │
 *             │   │    └── left + right: suma de ambos límites.
 *             │   │        Ej: left=0, right=6 → suma=6 → mid=3
 *             │   │
 *             │   └── = : operador de asignación.
 *             │
 *             └── val: palabra reservada. Declara una variable INMUTABLE
 *                 (de solo lectura, no se puede reasignar).
 *                 Significa "valor".
 *                 En español: "variable inmutable".
 *                 Diferencia clave:
 *                   - val → no puede reasignarse (como final en Java)
 *                   - var → sí puede reasignarse (variable mutable)
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *             when {
 *             │
 *             │  when: palabra reservada. Significa "cuando".
 *             │  Es una expresión condicional similar a switch.
 *             │  Evalúa múltiples ramas (condiciones) y ejecuta
 *             │  la primera que se cumpla.
 *             │  En español: "cuando".
 *             │  Sintaxis: when { condicion1 -> accion1 ... }
 *             │
 *             ──────────────────────────────────────────────────────
 *
 *                 list[mid] == item -> return mid
 *                 │    │     │   │      │      │
 *                 │    │     │   │      │      └── mid: índice donde
 *                 │    │     │   │      │          se encontró el elemento.
 *                 │    │     │   │      │
 *                 │    │     │   │      └── return: palabra reservada.
 *                 │    │     │   │          Significa "retornar".
 *                 │    │     │   │          Finaliza la función y
 *                 │    │     │   │          devuelve el valor.
 *                 │    │     │   │          En español: "retornar".
 *                 │    │     │   │
 *                 │    │     │   └── -> : flecha (arrow). Separa la
 *                 │    │     │       condición de la acción en when.
 *                 │    │     │       En español: "entonces" o "flecha".
 *                 │    │     │
 *                 │    │     └── == : operador de igualdad estructural.
 *                 │    │         Compara el VALOR, no la referencia.
 *                 │    │         En español: "es igual que".
 *                 │    │         Ej: list[3] == 23 → true si el valor
 *                 │    │         en el índice 3 es 23.
 *                 │    │
 *                 │    └── item: el elemento que estamos buscando.
 *                 │
 *                 └── list[mid]: accede al elemento en la posición
 *                     media de la lista. Usa el índice calculado.
 *                     list[indice] devuelve el elemento en esa posición.
 *                     En español: "lista en posición media".
 *
 *                 Caso 1: El elemento del medio ES el que buscamos.
 *                 ¡Éxito! Retornamos el índice mid.
 *
 *             ──────────────────────────────────────────────────────
 *
 *                 list[mid] < item -> left = mid + 1
 *                 │    │     │   │      │    │   │
 *                 │    │     │   │      │    │   └── 1: avanzamos
 *                 │    │     │   │      │    │       un índice más allá
 *                 │    │     │   │      │    │       del medio.
 *                 │    │     │   │      │    │
 *                 │    │     │   │      │    └── + : suma.
 *                 │    │     │   │      │
 *                 │    │     │   │      └── mid + 1: el nuevo límite
 *                 │    │     │   │          izquierdo es mid+1.
 *                 │    │     │   │          Descartamos la mitad izquierda.
 *                 │    │     │   │
 *                 │    │     │   └── = : asignación. Reasignamos left.
 *                 │    │     │
 *                 │    │     └── -> : flecha en when.
 *                 │    │
 *                 │    └── < : operador "menor que".
 *                 │        Compara si list[mid] es menor que item.
 *                 │        En español: "menor que".
 *                 │
 *                 └── list[mid] < item: ¿el elemento del medio es
 *                     MENOR que el que buscamos?
 *
 *                 Caso 2: El elemento del medio es menor.
 *                 El elemento buscado está en la mitad DERECHA.
 *                 Movemos left a mid+1 para buscar solo a la derecha.
 *
 *             ──────────────────────────────────────────────────────
 *
 *                 else -> right = mid - 1
 *                 │      │    │    │   │
 *                 │      │    │    │   └── 1: retrocedemos un índice.
 *                 │      │    │    │
 *                 │      │    │    └── - : resta.
 *                 │      │    │
 *                 │      │    └── mid - 1: el nuevo límite derecho
 *                 │      │        es mid-1. Descartamos la mitad
 *                 │      │        derecha y la posición media.
 *                 │      │
 *                 │      └── = : asignación. Reasignamos right.
 *                 │
 *                 └── else: palabra reservada. Significa "si no".
 *                     Rama por defecto. Se ejecuta si ninguna
 *                     condición anterior se cumplió.
 *                     En este caso: list[mid] > item
 *                     (el elemento del medio es MAYOR que el buscado).
 *                     En español: "si no" o "de lo contrario".
 *
 *                 Caso 3: El elemento del medio es mayor.
 *                 El elemento buscado está en la mitad IZQUIERDA.
 *                 Movemos right a mid-1 para buscar solo a la izquierda.
 *
 *             ──────────────────────────────────────────────────────
 *
 *             } // cierre de when
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         } // cierre de while
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         return throw NoSuchElementException("$item not found in list")
 *         │      │     │                   │       │
 *         │      │     │                   │       └── "$item not found in list":
 *         │      │     │                   │           string template. Interpola
 *         │      │     │                   │           el valor de 'item' dentro del
 *         │      │     │                   │           mensaje. Ej: si item=99 →
 *         │      │     │                   │           "99 not found in list"
 *         │      │     │                   │           $ se usa para interpolar variables.
 *         │      │     │                   │           En español: "plantilla de cadena".
 *         │      │     │                   │
 *         │      │     │                   └── ( ... ): paréntesis del constructor.
 *         │      │     │                       Pasan el mensaje de error.
 *         │      │     │
 *         │      │     └── NoSuchElementException: clase de excepción de Kotlin/Java.
 *         │      │         Significa "excepción de elemento no encontrado".
 *         │      │         Se lanza cuando se intenta acceder a un elemento
 *         │      │         que no existe. En español: "excepción de elemento inexistente".
 *         │      │
 *         │      └── throw: palabra reservada. Significa "lanzar".
 *             Lanza una excepción (interrumpe el flujo normal).
 *             En español: "lanzar excepción".
 *         │
 *         └── return: palabra reservada. Significa "retornar".
 *             Aquí combinado con throw: return throw ... finaliza la función
 *             lanzando una excepción en lugar de devolver un valor normal.
 *             Si el bucle while terminó sin encontrar el elemento
 *             (left > right), significa que no está en la lista.
 *             Lanzamos NoSuchElementException con un mensaje descriptivo.
 *             En español: "retornar lanzando excepción (elemento no encontrado)".
 *
 * ──────────────────────────────────────────────────────────────────
 * OTROS CONCEPTOS IMPORTANTES USADOS:
 * ──────────────────────────────────────────────────────────────────
 *
 * @file:Suppress("SpellCheckingInspection")
 * │      │
 * │      └── "SpellCheckingInspection": nombre de la inspección
 * │          de ortografía que se está suprimiendo.
 * │
 * └── @file:Suppress: anotación a nivel de archivo.
 *     @file indica que la anotación aplica a todo el archivo.
 *     Suppress suprime advertencias específicas del compilador.
 *     En español: "suprimir advertencias de revisión ortográfica".
 *
 * ──────────────────────────────────────────────────────────────────
 * TABLA DE PALABRAS RESERVADAS (EN ESPAÑOL):
 * ──────────────────────────────────────────────────────────────────
 *
 * Palabra    | Significado (ES)  | Explicación
 * ───────────┼───────────────────┼─────────────────────────────────────────
 * object     | objeto            | Declara un singleton (instancia única)
 * fun        | función           | Declara una función/método
 * var        | variable          | Variable mutable (se puede reasignar)
 * val        | valor             | Variable inmutable (no reasignable)
 * Int        | entero            | Tipo de dato: número entero de 32 bits
 * List       | lista             | Interfaz de colección ordenada
 * while      | mientras          | Bucle que se repite mientras se cumpla condición
 * when       | cuando            | Expresión condicional (switch)
 * else       | si no             | Rama por defecto en when o if
 * return     | retornar          | Devuelve un valor y finaliza la función
 * throw      | lanzar            | Lanza una excepción (interrumpe el flujo)
 * in         | en                | Usado en bucles para indicar pertenencia
 *
 * ──────────────────────────────────────────────────────────────────
 * OPERADORES IMPORTANTES (NO SON PALABRAS RESERVADAS):
 * ──────────────────────────────────────────────────────────────────
 *
 * Operador   | Significado (ES)  | Explicación
 * ───────────┼───────────────────┼─────────────────────────────────────────
 * ==         | igual que         | Comparación de igualdad estructural
 * <          | menor que         | Comparación numérica
 * <=         | menor o igual que | Comparación numérica
 * +          | más               | Suma aritmética
 * -          | menos             | Resta aritmética
 * /          | división          | División entera (trunca decimales)
 * =          | asignación        | Asigna un valor a una variable
 * ->         | entonces / flecha | Separa condición de acción en when
 * $          | dólar             | Prefijo de interpolación en string templates
 *
 * ──────────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO:
 * ──────────────────────────────────────────────────────────────────
 *
 * 1. Inicializar dos punteros: left al inicio (0) y right al final
 *    (list.size - 1).
 *
 * 2. Mientras left <= right:
 *    a. Calcular el índice del medio: mid = (left + right) / 2
 *    b. Si list[mid] == item → ¡encontrado! Retornar mid.
 *    c. Si list[mid] < item → el elemento está a la derecha.
 *       Mover left = mid + 1.
 *    d. Si list[mid] > item → el elemento está a la izquierda.
 *       Mover right = mid - 1.
 *
 * 3. Si el bucle termina sin encontrar → lanzar NoSuchElementException.
 *
 * Ejemplo paso a paso para buscar el 23 en [4, 8, 12, 16, 23, 28, 32]:
 *
 *   Iteración 1:
 *     left=0, right=6, mid=(0+6)/2=3
 *     list[3]=16, 16 < 23 → left = 3+1 = 4
 *     Nuevo rango: [23, 28, 32]
 *
 *   Iteración 2:
 *     left=4, right=6, mid=(4+6)/2=5
 *     list[5]=28, 28 > 23 → right = 5-1 = 4
 *     Nuevo rango: [23]
 *
 *   Iteración 3:
 *     left=4, right=4, mid=(4+4)/2=4
 *     list[4]=23, 23 == 23 → ¡encontrado! Retorna 4 ✓
 *
 *   Si buscamos 99:
 *     Se repetirá hasta left > right sin encontrar.
 *     Lanza NoSuchElementException("99 not found in list") ✗
 */