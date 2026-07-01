@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 *
 * An Armstrong number is a number that is the sum of its own digits each raised
 * to the power of the number of digits.
 *
 * For example:
 *   - 9 is an Armstrong number, because 9 = 9¹ = 9
 *   - 10 is not an Armstrong number, because 10 ≠ 1² + 0² = 1
 *   - 153 is an Armstrong number, because 153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
 *   - 154 is not an Armstrong number, because 154 ≠ 1³ + 5³ + 4³ = 1 + 125 + 64 = 190
 *
 * Write some code to determine whether a number is an Armstrong number.
 */

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val digits = input.toString().map { it - '0' }
        val power = digits.size
        return input == digits.sumOf { Math.pow(it.toDouble(), power.toDouble()).toInt() }
    }
}

fun main() {
    val testCases = listOf(9, 10, 153, 154, 370, 371, 407, 9474, 9475)
    for (n in testCases) {
        println("$n -> ${ArmstrongNumber.check(n)}")
    }
}

/**
 * GUÍA DE RESOLUCIÓN - NÚMEROS ARMSTRONG
 * ======================================
 *
 * Números Armstrong son aquellos que son iguales a la suma de sus dígitos
 * elevados a la potencia del número total de dígitos.
 *
 * Ejemplo: 153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
 *
 *
 * ──────────────────────────────────────────────────────────────────
 * Explicación línea por línea del código en el objeto:
 * ──────────────────────────────────────────────────────────────────
 *
 * object ArmstrongNumber {
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
 *     fun check(input: Int): Boolean {
 *     │  │     │       │      │
 *     │  │     │       │      └── Boolean: tipo de retorno (true o false).
 *     │  │     │       │          Palabra reservada. Significa "booleano".
 *     │  │     │       │          En español: "tipo booleano".
 *     │  │     │       │
 *     │  │     │       └── Int: tipo del parámetro. Significa "entero".
 *     │  │     │            Palabra reservada. En español: "tipo entero".
 *     │  │     │
 *     │  │     └── input: nombre del parámetro que recibe el número.
 *     │  │
 *     │  └── check: nombre de la función. Significa "verificar".
 *     │
 *     └── fun: palabra reservada que declara una función.
 *         En español: "función".
 *         Syntaxis: fun nombreDeFuncion(parametro: Tipo): TipoRetorno { ... }
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         val digits = input.toString().map { it - '0' }
 *         │   │      │     │         │   │    │   │
 *         │   │      │     │         │   │    │   └── '0': carácter cero.
 *         │   │      │     │         │   │    │
 *         │   │      │     │         │   │    └── it: cada dígito como Char.
 *         │   │      │     │         │   │        Palabra reservada en lambda
 *         │   │      │     │         │   │        con un solo parámetro implícito.
 *         │   │      │     │         │   │        En español: "él/ello" (ref al elem).
 *         │   │      │     │         │   │
 *         │   │      │     │         │   └── { it - '0' }: lambda (función anónima).
 *         │   │      │     │         │       Resta el código ASCII de '0' al de 'it',
 *         │   │      │     │         │       convirtiendo el Char en Int numérico.
 *         │   │      │     │         │       Ej: '5' - '0' = 53 - 48 = 5
 *         │   │      │     │         │
 *         │   │      │     │         └── .map { ... }: transforma cada elemento.
 *         │   │      │     │             Palabra reservada. Significa "mapear" o
 *         │   │      │     │             "transformar". Devuelve una nueva lista.
 *         │   │      │     │
 *         │   │      │     └── .toString(): convierte el Int a String.
 *         │   │      │         Ej: 153 → "153". Palabra reservada de Kotlin.
 *         │   │      │
 *         │   │      └── = : operador de asignación.
 *         │   │
 *         │   └── digits: nombre de la variable. Significa "dígitos".
 *         │
 *         └── val: palabra reservada. Declara una variable inmutable
 *             (no se puede reasignar).
 *             Significa "valor". En español: "valor" o "variable inmutable".
 *             Diferencias:
 *               - val → no puede reasignarse (equivalente a final en Java)
 *               - var → sí puede reasignarse (variable mutable)
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         val power = digits.size
 *         │   │      │      │
 *         │   │      │      └── .size: propiedad que devuelve el tamaño
 *         │   │      │          de la lista. Ej: [1,5,3].size → 3.
 *         │   │      │          En español: "tamaño".
 *         │   │      │
 *         │   │      └── digits: la lista de dígitos que creamos antes.
 *         │   │
 *         │   └── power: variable. Significa "potencia".
 *         │
 *         └── val: declara variable inmutable.
 *             Almacena la cantidad de dígitos (el exponente).
 *
 * ──────────────────────────────────────────────────────────────────
 *
 *         return input == digits.sumOf { Math.pow(it.toDouble(), power.toDouble()).toInt() }
 *         │      │      │    │       │    │     │   │         │      │          │
 *         │      │      │    │       │    │     │   │         │      │          └── .toInt(): convierte el resultado Double a Int.
 *         │      │      │    │       │    │     │   │         │      │
 *         │      │      │    │       │    │     │   │         │      └── power.toDouble(): convierte el exponente a Double.
 *         │      │      │    │       │    │     │   │         │          .toDouble() es un mét0do de extensión de Kotlin.
 *         │      │      │    │       │    │     │   │         │
 *         │      │      │    │       │    │     │   │         └── , power.toDouble(): segundo argumento de Math.pow.
 *         │      │      │    │       │    │     │   │             El exponente.
 *         │      │      │    │       │    │     │   │
 *         │      │      │    │       │    │     │   └── it.toDouble(): convierte el dígito (Int) a Double.
 *         │      │      │    │       │    │     │       Math.pow() requiere Doubles.
 *         │      │      │    │       │    │     │
 *         │      │      │    │       │    │     └── Math.pow(..., ...): función de la biblioteca
 *         │      │      │    │       │    │         matemática de Java. Significa "potencia".
 *         │      │      │    │       │    │         Eleva el primer argumento al segundo.
 *         │      │      │    │       │    │         Ej: Math.pow(5.0, 3.0) → 125.0
 *         │      │      │    │       │    │
 *         │      │      │    │       │    └── { Math.pow(...) }: lambda. Recibe 'it' (cada dígito).
 *         │      │      │    │       │
 *         │      │      │    │       └── .sumOf { ... }: función que suma los resultados
 *         │      │      │    │           de aplicar la lambda a cada elemento.
 *         │      │      │    │           Significa "suma de". Palabra reservada.
 *         │      │      │    │           En español: "suma de cada elemento transformado".
 *         │      │      │    │
 *         │      │      │    └── digits.sumOf { ... }: suma cada dígito elevado a la potencia.
 *         │      │      │        Ej: para 153: 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
 *         │      │      │
 *         │      │      └── == : operador de igualdad estructural.
 *         │      │          Compara el contenido, no la referencia.
 *         │      │          En español: "igual a" o "es igual que".
 *         │      │          Diferencia con === (referencia) y equals().
 *         │      │
 *         │      └── input: el número original ingresado.
 *         │          Comparamos: si la suma es igual al número original → true.
 *         │
 *         └── return: palabra reservada. Significa "retornar" o "devolver".
 *             Finaliza la ejecución de la función y devuelve el valor.
 *             En español: "retornar".
 *
 * ──────────────────────────────────────────────────────────────────
 * OTROS CONCEPTOS IMPORTANTES USADOS:
 * ──────────────────────────────────────────────────────────────────
 *
 * for (n in testCases) { ... }
 * │   │  │     │
 * │   │  │     └── testCases: una lista de enteros.
 * │   │  │
 * │   │  └── in: palabra reservada. Significa "en" o "dentro de".
 * │   │      Se usa para iterar sobre un rango o colección.
 * │   │      En español: "en" (ej: "para cada n en casosDePrueba").
 * │   │
 * │   └── n: nombre temporal de cada elemento durante la iteración.
 * │
 * └── for: palabra reservada. Significa "para" o "para cada".
 *     En español: "para" (estructura de control de bucle).
 *     Itera sobre cada elemento de la colección.
 *     Equivalente a: for (int i = 0; i < testCases.size; i++)
 *        pero más legible y moderno.
 *
 * ──────────────────────────────────────────────────────────────────
 *
 * println("$n -> ${ArmstrongNumber.check(n)}")
 * │       │ │  │   │            │        │
 * │       │ │  │   │            │        └── n): argumento de la función check.
 * │       │ │  │   │            │
 * │       │ │  │   │            └── .check(n): llamamos a la función definida arriba.
 * │       │ │  │   │
 * │       │ │  │   └── ArmstrongNumber: el objeto singleton. Accedemos a su función.
 * │       │ │  │       En español: "objeto ArmstrongNumber".
 * │       │ │  │
 * │       │ │  └── ${...}: expresión dentro de un string (string template).
 * │       │ │      Evalúa el código dentro de las llaves y lo convierte a String.
 * │       │ │      Palabra reservada de Kotlin. En español: "plantilla de string".
 * │       │ │
 * │       │ └── " -> ": string literal (texto fijo) con una flecha para legibilidad.
 * │       │
 * │       └── $n: interpola el valor de la variable n dentro del string.
 * │           $ es el prefijo de interpolación. En español: "signo de dólar".
 * │
 * └── println(...): función que imprime texto en consola y añade salto de línea.
 *     Significa "print line" (imprimir línea).
 *     En español: "imprimir línea".
 *
 * ──────────────────────────────────────────────────────────────────
 * TABLA DE PALABRAS RESERVADAS (EN ESPAÑOL):
 * ──────────────────────────────────────────────────────────────────
 *
 * Palabra    | Significado (ES)  | Explicación
 * ───────────┼───────────────────┼─────────────────────────────────────────
 * object     | objeto            | Declara un singleton (instancia única)
 * fun        | función           | Declara una función/mét0do
 * val        | valor             | Variable inmutable (no reasignable)
 * Boolean    | booleano          | Tipo de dato: true o false
 * Int        | entero            | Tipo de dato: número entero
 * return     | retornar          | Devuelve un valor y finaliza la función
 * for        | para              | Bucle que itera sobre colecciones
 * in         | en                | Usado en bucles para indicar pertenencia
 * it         | ello/él           | Parámetro implícito en lambdas
 *
 * ──────────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO:
 * ──────────────────────────────────────────────────────────────────
 *
 * 1. Convertir el número a una lista de sus dígitos individuales.
 *    (input.toString().map { it - '0' })
 *
 * 2. Contar cuántos dígitos tiene → esa será la potencia.
 *    (digits.size)
 *
 * 3. Elevar cada dígito a esa potencia y sumar los resultados.
 *    (digits.sumOf { Math.pow(it.toDouble(), power.toDouble()).toInt() })
 *
 * 4. Comparar la suma con el número original.
 *    (input == suma)
 *
 * 5. Si son iguales → es un número Armstrong (true).
 *    Si no → no lo es (false).
 *
 * Ejemplo paso a paso para 153:
 *   - digits = [1, 5, 3]
 *   - power = 3
 *   - sum = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
 *   - 153 == 153 → true ✓
 *
 * Ejemplo paso a paso para 10:
 *   - digits = [1, 0]
 *   - power = 2
 *   - sum = 1² + 0² = 1 + 0 = 1
 *   - 10 == 1 → false ✗
 */