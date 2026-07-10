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

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Determinar si un número es un número de Armstrong.

    Un número Armstrong cumple que es igual a la suma de sus dígitos,
    cada uno elevado a la potencia del número total de dígitos.

    Ejemplos:
      153 → 1³ + 5³ + 3³ = 1 + 125 + 27 = 153  ✓
      10  → 1² + 0² = 1 + 0 = 1 ≠ 10           ✗

    OBJETIVOS:
    I.   Separar el número en sus dígitos individuales.
    II.  Contar cuántos dígitos tiene (será el exponente).
    III. Elevar cada dígito a esa potencia y sumar los resultados.
    IV.  Comparar la suma con el número original. Si son iguales → true.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. OBTENER LOS DIGITOS
       └── Convertir el número a String: input.toString() → "153".
       └── Usar .map { it - '0' } para convertir cada carácter a entero:
           '1' - '0' = 1, '5' - '0' = 5, '3' - '0' = 3 → [1, 5, 3].

    II. CALCULAR LA POTENCIA
        └── power = digits.size (cantidad de dígitos).
        └── Para 153: power = 3.

    III. SUMAR CADA DIGITO ELEVADO A LA POTENCIA
         └── digits.sumOf { Math.pow(it.toDouble(), power.toDouble()).toInt() }
         └── Para cada dígito: elevarlo a power, convertir a Int, acumular.
         └── 1³ + 5³ + 3³ = 1 + 125 + 27 = 153.

    IV. COMPARAR
        └── input == suma → true si es Armstrong, false si no.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object ArmstrongNumber {                                                │
    │                                                                          │
    │     fun check(input: Int): Boolean {                                    │
    │         val digits = input.toString().map { it - '0' }                  │
    │         val power = digits.size                                         │
    │         return input == digits.sumOf {                                  │
    │             Math.pow(it.toDouble(), power.toDouble()).toInt()           │
    │         }                                                               │
    │     }                                                                    │
    │ }                                                                        │
    │                                                                          │
    │ fun main() {                                                             │
    │     val testCases = listOf(9, 10, 153, 154, 370, 371, 407, 9474, 9475)  │
    │     for (n in testCases) {                                               │
    │         println("$n -> ${ArmstrongNumber.check(n)}")                     │
    │     }                                                                    │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada: crea un singleton (instancia única).
         └── Analogía: una oficina central de registros — solo hay una.

    II.  ArmstrongNumber
         └── Nombre del objeto. Identificador con mayúscula inicial.

    III. fun
         └── Palabra reservada "function". Define una función/método.

    IV.  check
         └── Nombre de la función: "verificar" o "comprobar".

    V.   (input: Int)
         └── Parámetro: input es el número entero a evaluar.
         └── Int: tipo entero de 32 bits.

    VI.  : Boolean
         └── Tipo de retorno: la función devuelve true o false.

    VII. val
         └── Variable INMUTABLE (no se reasigna).
         └── Analogía: una promesa escrita en piedra.

    VIII. digits
         └── Variable que almacena la lista de dígitos (List<Int>).
         └── Ej: para 153 → [1, 5, 3].

    IX.  input.toString()
         └── Convierte el entero a String (cadena de texto).
         └── 153 → "153".

    X.   .map { ... }
         └── Función de orden superior: transforma CADA elemento de la colección.
         └── Aplica la lambda { } a cada carácter del String.
         └── Analogía: una máquina que procesa cada pieza en una fábrica.

    XI.  { it - '0' }
         └── Lambda (función anónima). it es el parámetro implícito.
         └── it: cada carácter del String ('1', '5', '3').
         └── - '0': resta el valor ASCII de '0' (48) al carácter.
         └── '1' - '0' = 49 - 48 = 1. Convierte char a entero.

    XII. power
         └── Variable que almacena la cantidad de dígitos.
         └── digits.size: propiedad que devuelve el tamaño de la lista.

    XIII. .size
         └── Propiedad de colecciones: devuelve el número de elementos.
         └── [1, 5, 3].size = 3.

    XIV. return
         └── Palabra reservada: termina la función y devuelve el valor.

    XV.  input == digits.sumOf { ... }
         └── Compara el número original con la suma calculada.
         └── == : operador de igualdad. Devuelve true si son iguales.

    XVI. digits.sumOf { ... }
         └── Función que suma los resultados de aplicar la lambda a cada elemento.
         └── Equivalente a: var s = 0; for (d in digits) { s += d^power }.

    XVII. Math.pow(base, exponente)
         └── Función de biblioteca: eleva "base" a la potencia "exponente".
         └── Ej: Math.pow(5.0, 3.0) = 125.0.
         └── Requiere Doubles en ambos parámetros.

    XVIII. .toDouble()
         └── Convierte un Int a Double.
         └── it.toDouble(): convierte el dígito (Int) a Double.
         └── power.toDouble(): convierte la potencia (Int) a Double.
         └── Math.pow requiere Doubles.

    XIX. .toInt()
         └── Convierte el resultado Double de Math.pow a Int.
         └── 125.0 → 125 (trunca la parte decimal).

    XX.  main()
         └── Función principal: punto de entrada del programa.

    XXI. val testCases = listOf(...)
         └── Variable inmutable que almacena una lista de números a probar.
         └── listOf(): función que crea una lista con los elementos dados.
         └── Analogía: una lista de compras escrita en papel.

    XXII. for (n in testCases) { ... }
         └── Bucle "para cada": itera sobre cada elemento de la lista.
         └── n toma el valor de cada elemento en cada iteración.
         └── Analogía: revisar cada elemento de una lista uno por uno.

    XXIII. println("$n -> ${ArmstrongNumber.check(n)}")
         └── Imprime el resultado en consola.
         └── $n: interpola el valor de n en el texto.
         └── ${ ... }: interpola el resultado de la expresión.
         └── -> : texto literal (flecha) para formatear la salida.

    XXIV. { } (llaves)
         └── Delimitan bloques de código (función, lambda, for).

    XXV. ( ) (paréntesis)
         └── Agrupan parámetros y argumentos de funciones.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO NumeroArmstrong:
        FUNCION verificar(numero):
            digitos = CONVERTIR_A_TEXTO(numero).MAPEAR(c → c - '0')
            potencia = digitos.TAMANIO
            suma = digitos.SUMAR { ELEVAR(d, potencia) }
            DEVOLVER numero == suma

    PROGRAMA PRINCIPAL:
        1. casos = [9, 10, 153, 154, 370, 371, 407, 9474, 9475]
        2. PARA CADA n EN casos:
             IMPRIMIR n + " -> " + NumeroArmstrong.verificar(n)

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: 153 (es Armstrong)

        Entrada: input = 153
        Proceso:
            digits = "153".map { it - '0' } = [1, 5, 3]
            power = [1, 5, 3].size = 3
            sumOf:
                Math.pow(1.0, 3.0).toInt() = 1
                Math.pow(5.0, 3.0).toInt() = 125
                Math.pow(3.0, 3.0).toInt() = 27
                suma = 1 + 125 + 27 = 153
            ¿153 == 153? → SÍ
        Resultado: true (es Armstrong)

    EJEMPLO 2: 10 (no es Armstrong)

        Entrada: input = 10
        Proceso:
            digits = "10".map { it - '0' } = [1, 0]
            power = [1, 0].size = 2
            sumOf:
                Math.pow(1.0, 2.0).toInt() = 1
                Math.pow(0.0, 2.0).toInt() = 0
                suma = 1 + 0 = 1
            ¿10 == 1? → NO
        Resultado: false (no es Armstrong)

    EJEMPLO 3: 9474 (es Armstrong, 4 dígitos)

        Entrada: input = 9474
        Proceso:
            digits = "9474".map { it - '0' } = [9, 4, 7, 4]
            power = [9, 4, 7, 4].size = 4
            sumOf:
                9⁴ = 9×9×9×9 = 6561
                4⁴ = 4×4×4×4 = 256
                7⁴ = 7×7×7×7 = 2401
                4⁴ = 4×4×4×4 = 256
                suma = 6561 + 256 + 2401 + 256 = 9474
            ¿9474 == 9474? → SÍ
        Resultado: true (es Armstrong)

    EJEMPLO 4: 154 (no es Armstrong)

        Entrada: input = 154
        Proceso:
            digits = "154".map { it - '0' } = [1, 5, 4]
            power = 3
            sumOf:
                1³ = 1
                5³ = 125
                4³ = 64
                suma = 1 + 125 + 64 = 190
            ¿154 == 190? → NO
        Resultado: false (no es Armstrong)
*/
