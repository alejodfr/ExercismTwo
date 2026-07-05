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
 * ──────────────────────────────────────────────────────────────
 * NÚMERO ARMSTRONG — Guía de estudio
 * ──────────────────────────────────────────────────────────────
 *
 * Un número Armstrong es igual a la suma de sus dígitos elevados
 * a la potencia del número de dígitos.
 *   153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 → Armstrong ✓
 *    10 = 1² + 0² = 1 + 0 = 1 ≠ 10          → No es ✗
 *
 * CÓDIGO ANOTADO
 * ──────────────────────────────────────────────────────────────
 *
 * object ArmstrongNumber {
 * │
 * ├── fun check(input: Int): Boolean {
 * │   │
 * │   ├── val digits = input.toString().map { it - '0' }
 * │   │   │
 * │   │   ├── input.toString()
 * │   │   │   └── ─► Convierte el número entero a String.
 * │   │   │       153 → "153"
 * │   │   │
 * │   │   ├── .map { it - '0' }
 * │   │   │   └── ─► Transforma cada Char a su valor Int.
 * │   │   │       it = cada carácter ('1', '5', '3')
 * │   │   │       '1' - '0' = 49 - 48 = 1
 * │   │   │       Resultado: [1, 5, 3]
 * │   │   │
 * │   │   └── ─► digits = lista de dígitos individuales
 * │   │
 * │   ├── val power = digits.size
 * │   │   └── ─► Cuenta los dígitos → será el exponente.
 * │   │       153 tiene 3 dígitos → power = 3
 * │   │
 * │   ├── return input == digits.sumOf {
 * │   │       Math.pow(it.toDouble(), power.toDouble()).toInt()
 * │   │   }
 * │   │   │
 * │   │   ├── digits.sumOf { ... }
 * │   │   │   └── ─► Suma el resultado de aplicar la lambda
 * │   │   │       a cada dígito. Como un bucle que acumula.
 * │   │   │
 * │   │   ├── Math.pow(it.toDouble(), power.toDouble())
 * │   │   │   │
 * │   │   │   ├── it.toDouble()
 * │   │   │   │   └── ─► Convierte el dígito (Int) a Double.
 * │   │   │   │       Math.pow requiere Doubles.
 * │   │   │   │
 * │   │   │   ├── power.toDouble()
 * │   │   │   │   └── ─► Exponente también a Double.
 * │   │   │   │
 * │   │   │   └── Math.pow(base, exponente)
 * │   │   │       └── ─► base^exponente.
 * │   │   │           Math.pow(5.0, 3.0) = 125.0
 * │   │   │
 * │   │   ├── .toInt()
 * │   │   │   └── ─► Vuelve el Double a Int.
 * │   │   │       125.0 → 125
 * │   │   │
 * │   │   └── input == suma
 * │   │       └── ─► Compara el número original con la suma.
 * │   │           Si son iguales → true (es Armstrong).
 * │   }
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
 * val      | valor       | Variable inmutable (no se reasigna)
 * Int      | entero      | Tipo de dato numérico entero
 * Boolean  | booleano    | Tipo de dato true/false
 * return   | retornar    | Devuelve valor y termina la función
 * it       | ello        | Parámetro implícito en lambdas
 *
 * ──────────────────────────────────────────────────────────────
 * TABLA DE OPERADORES IMPORTANTES
 * ──────────────────────────────────────────────────────────────
 *
 * Operador | Nombre (ES)   | Explicación
 * ─────────┼───────────────┼─────────────────────────────────────
 * ==       | igual que     | Compara igualdad de contenido
 * -        | resta         | Resta aritmética (o entre chars)
 * .        | punto         | Accede a propiedades y métodos
 * ->       | flecha        | Separador en lambdas
 * {}       | llaves        | Define bloque o cuerpo de lambda
 * ()       | paréntesis    | Llama funciones o agrupa expresiones
 *
 * ──────────────────────────────────────────────────────────────
 * RESUMEN ALGORÍTMICO
 * ──────────────────────────────────────────────────────────────
 *
 * PSEUDOCÓDIGO:
 * ─────────────
 *   objeto NumeroArmstrong:
 *     función verificar(numero):
 *       digitos = numero.aTexto().mapear(c → c - '0')
 *       potencia = digitos.tamaño
 *       suma = digitos.sumarDe { elevar(it, potencia) }
 *       devolver numero == suma
 *
 * EJEMPLO — 153:
 * ──────────────
 *   input = 153
 *   Paso 1: "153".map { it - '0' } = [1, 5, 3]
 *   Paso 2: power = [1, 5, 3].size = 3
 *   Paso 3:
 *     Math.pow(1.0, 3.0).toInt() = 1
 *     Math.pow(5.0, 3.0).toInt() = 125
 *     Math.pow(3.0, 3.0).toInt() = 27
 *     suma = 1 + 125 + 27 = 153
 *   Paso 4: 153 == 153 → true ✓
 *
 * EJEMPLO — 10:
 * ─────────────
 *   input = 10
 *   digits = [1, 0], power = 2
 *   sum: 1² = 1, 0² = 0, suma = 1
 *   10 == 1 → false ✗
 *
 * TRUCO: it - '0'
 * ────────────────
 *   Los caracteres tienen valor ASCII. '0' = 48, '1' = 49...
 *   Restar '0' convierte el char a su valor numérico:
 *     '1' - '0' = 49 - 48 = 1
 *     '5' - '0' = 53 - 48 = 5
 *   Así obtenemos cada dígito como entero sin parsear.
 *
 *   digits.sumOf { ... } equivale a:
 *     var suma = 0
 *     for (d in digits) { suma += d^potencia }
 */