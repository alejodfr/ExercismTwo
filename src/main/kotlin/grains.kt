@file:Suppress("SpellCheckingInspection")

import java.math.BigInteger

/**
 * # Grains
 *
 * ## Introduction
 * There once was a wise servant who saved the life of a prince.
 * The king promised to pay whatever the servant could dream up.
 * Knowing that the king loved chess, the servant told the king he
 * would like to have grains of wheat. One grain on the first square
 * of a chessboard, with the number of grains doubling on each
 * successive square.
 *
 * ## Instructions
 * Calculate the number of grains of wheat on a chessboard.
 *
 * A chessboard has **64 squares**. Square 1 has one grain, square 2
 * has two grains, square 3 has four grains, and so on, doubling each
 * time.
 *
 * Write code that calculates:
 *
 *   - The number of grains on a **given square**
 *   - The **total number** of grains on the chessboard
 *
 */

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        if (number < 1 || number > 64) throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
        val bigNumber = BigInteger.valueOf(2)
        return bigNumber.pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        var total = BigInteger.ZERO
        for (i in 1..64){
            total += getGrainCountForSquare(i)
        }
        return total
    }
}

fun main(){
    println("Enter a number between 1 and 64")
    val number = readln().toInt()
    println("The number of grains on square $number is ${Board.getGrainCountForSquare(number)}")
    println("The total number of grains on the chessboard is ${Board.getTotalGrainCount()}")
}

/**
 * ╔══════════════════════════════════════════════════════════════╗
 * ║        GUÍA DE ESTUDIO — grains.kt (Granos de trigo)       ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * ────────────────────────────────────────────────────────────
 *  CÓDIGO ANOTADO
 * ────────────────────────────────────────────────────────────
 *
 * import java.math.BigInteger                          ──► Importa BigInteger para números
 *                                                          enormes (2⁶⁴ es gigantesco)
 *
 * object Board {                                       ──► Objeto singleton
 * │
 * ├── fun getGrainCountForSquare(number: Int): BigInteger {  ──► Recibe un número de casilla
 * │   │                                                          devuelve BigInteger
 * │   │
 * │   ├── if (number < 1 || number > 64)                 ──► Valida: solo casillas 1..64
 * │   │       throw IllegalArgumentException(             ──► Si no, lanza excepción
 * │   │       "Only integers between 1 and 64 ...")      ──► con mensaje explicativo
 * │   │   }
 * │   │
 * │   ├── val bigNumber = BigInteger.valueOf(2)          ──► bigNumber = 2
 * │   │
 * │   └── return bigNumber.pow(number - 1)              ──► 2^(number - 1)
 * │   }                                                     Casilla 1 → 2⁰ = 1
 * │                                                          Casilla 2 → 2¹ = 2
 * │                                                          Casilla 3 → 2² = 4 ...
 * │
 * └── fun getTotalGrainCount(): BigInteger {             ──► Suma total de granos
 *     │
 *     ├── var total = BigInteger.ZERO                   ──► Inicia total en 0
 *     │
 *     ├── for (i in 1..64) {                            ──► Itera i = 1, 2, 3, ..., 64
 *     │   │
 *     │   └── total += getGrainCountForSquare(i)        ──► Suma los granos de cada casilla
 *     │   }                                                 1 + 2 + 4 + 8 + ... + 2⁶³
 *     │
 *     └── return total                                  ──► Devuelve la suma total
 *     }
 * }
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE PALABRAS RESERVADAS
 * ────────────────────────────────────────────────────────────
 *
 *  ┌─────────────────┬─────────────────────────────────────────┐
 *  │  Palabra        │  Significado                            │
 *  ├─────────────────┼─────────────────────────────────────────┤
 *  │  import         │  Importa clases de otros paquetes       │
 *  │  object         │  Singleton                              │
 *  │  fun            │  Función                                │
 *  │  if             │  Condicional                            │
 *  │  throw          │  Lanzar una excepción (error)           │
 *  │  IllegalArgumentException │ Tipo de excepción: argumento   │
 *  │                 │  inválido                               │
 *  │  val            │  Variable inmutable                     │
 *  │  var            │  Variable mutable                       │
 *  │  return         │  Devolver valor                         │
 *  │  for            │  Bucle (repetir)                        │
 *  │  in             │  "en" (dentro de un rango)              │
 *  │  ..             │  Operador de rango (1..64 = 1 a 64)     │
 *  │  Int            │  Tipo entero                            │
 *  │  BigInteger     │  Entero de precisión arbitraria         │
 *  └─────────────────┴─────────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE OPERADORES IMPORTANTES
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────┬──────────────┬─────────────────────────────────┐
 *  │ Operador │  Uso         │  Explicación                    │
 *  ├──────────┼──────────────┼─────────────────────────────────┤
 *  │  <       │ a < b        │  Menor que                      │
 *  │  >       │ a > b        │  Mayor que                      │
 *  │  ||      │ a || b       │  OR lógico (o)                  │
 *  │  -       │ a - b        │  Resta                          │
 *  │  +=      │ a += b       │  a = a + b (suma y asigna)      │
 *  │  ..      │ 1..64        │  Rango del 1 al 64 inclusive    │
 *  │  .       │ a.b()        │  Llamar método                  │
 *  │  ()      │ fun()        │  Invocar función                │
 *  └──────────┴──────────────┴─────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  RESUMEN ALGORÍTMICO
 * ────────────────────────────────────────────────────────────
 *
 *  PSEUDOCÓDIGO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  función granosEnCasilla(n):                           │
 *  │      SI n < 1 O n > 64 → lanzar error                  │
 *  │      SINO → devolver 2^(n-1)                          │
 *  │                                                         │
 *  │  función totalGranos():                                 │
 *  │      total = 0                                          │
 *  │      PARA i DESDE 1 HASTA 64:                          │
 *  │          total += granosEnCasilla(i)                   │
 *  │      devolver total                                     │
 *  └─────────────────────────────────────────────────────────┘
 *
 *  EJEMPLO TRABAJADO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  getGrainCountForSquare(4)                              │
 *  │    ¿4 < 1 O 4 > 64? → NO                                │
 *  │    2^(4-1) = 2³ = 8 granos                             │
 *  │                                                         │
 *  │  getTotalGrainCount()                                   │
 *  │    i=1 → 2⁰ = 1                                        │
 *  │    i=2 → 2¹ = 2                                        │
 *  │    i=3 → 2² = 4                                        │
 *  │    i=4 → 2³ = 8                                        │
 *  │    ...                                                  │
 *  │    i=64 → 2⁶³ = 9.22×10¹⁸                              │
 *  │    Total = 2⁶⁴ - 1 = 18.446.744.073.709.551.615        │
 *  └─────────────────────────────────────────────────────────┘
 */

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Problema: Calcular granos de trigo en un tablero de ajedrez.
    Casilla 1 = 1 grano, casilla 2 = 2, casilla 3 = 4, y así sucesivamente
    (se duplica en cada casilla).

    OBJETIVOS:
    I.   Función que reciba un número de casilla (1-64) y devuelva los granos
         en esa casilla (2^(n-1)).
    II.  Función que calcule el TOTAL de granos en todo el tablero (suma de
         todas las casillas).
    III. Validar que la casilla esté entre 1 y 64; si no, lanzar excepción.
    IV.  Usar BigInteger para manejar números enormes (2⁶⁴ ≈ 1.84×10¹⁹).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. ENTENDER EL PROBLEMA
       └── Un tablero de ajedrez tiene 64 casillas.
       └── Patrón: 1, 2, 4, 8, 16, ... (potencias de 2).
       └── Fórmula para la casilla n: granos = 2^(n-1).

    II. VALIDACIÓN
        └── Si n < 1 o n > 64, el problema no tiene sentido.
        └── Lanzamos una excepción para detener la ejecución.

    III. BIGINTEGER
         └── Kotlin/Java tienen tipos Int (32 bits) y Long (64 bits).
         └── 2⁶³ ya supera el rango de Long (9.22×10¹⁸ > 9.22×10¹⁸).
         └── Usamos BigInteger que puede crecer sin límite.

    IV. CÁLCULO DE GRANOS EN UNA CASILLA
        └── bigNumber.pow(number - 1) → 2^(n-1)
        └── Ej: casilla 4 → 2^(4-1) = 2³ = 8.

    V. CÁLCULO DEL TOTAL
       └── Sumatoria desde i=1 hasta i=64 de getGrainCountForSquare(i).
       └── Equivalente a 2⁶⁴ - 1 (progresión geométrica).
       └── Se usa un bucle for con variable mutable var.

    VI. MAIN (prueba interactiva)
        └── Pedir al usuario un número por consola.
        └── Mostrar granos en esa casilla y el total del tablero.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ import java.math.BigInteger                                              │
    │                                                                          │
    │ object Board {                                                           │
    │     fun getGrainCountForSquare(number: Int): BigInteger {                │
    │         if (number < 1 || number > 64)                                   │
    │             throw IllegalArgumentException("...")                        │
    │         val bigNumber = BigInteger.valueOf(2)                            │
    │         return bigNumber.pow(number - 1)                                 │
    │     }                                                                    │
    │                                                                          │
    │     fun getTotalGrainCount(): BigInteger {                               │
    │         var total = BigInteger.ZERO                                      │
    │         for (i in 1..64) {                                               │
    │             total += getGrainCountForSquare(i)                           │
    │         }                                                                │
    │         return total                                                     │
    │     }                                                                    │
    │ }                                                                        │
    │                                                                          │
    │ fun main() {                                                             │
    │     println("Enter a number between 1 and 64")                           │
    │     val number = readln().toInt()                                        │
    │     println("... ${Board.getGrainCountForSquare(number)}")               │
    │     println("... ${Board.getTotalGrainCount()}")                         │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   import
         └── Palabra reservada que trae código de otros paquetes.
         └── import java.math.BigInteger → trae la clase BigInteger del paquete
             java.math para poder usarla sin escribir java.math.BigInteger cada vez.
         └── Analogía: como tomar prestado un libro de la biblioteca para usarlo
             en tu casa.

    II.  java.math.BigInteger
         └── Clase de la biblioteca estándar de Java/Kotlin.
         └── Almacena números enteros de PRECISIÓN ARBITRARIA (sin límite de bits).
         └── Necesario porque 2⁶⁴ es demasiado grande para Int o Long.
         └── Analogía: una hoja de papel infinita donde puedes escribir un número
             tan largo como quieras.

    III. object Board
         └── object: palabra reservada que declara un SINGLETON (una única instancia).
         └── Board: nombre del objeto (por convención, mayúscula inicial).
         └── No necesita constructor, Kotlin crea la única instancia automáticamente.
         └── Analogía: hay UN solo tablero de ajedrez en el juego; no necesitas
             crear múltiples copias.

    IV.  fun
         └── Palabra reservada que define una FUNCIÓN (bloque de código reutilizable).
         └── Analogía: una receta de cocina — describes pasos una vez y los ejecutas
             cada vez que invocas la función.

    V.   getGrainCountForSquare
         └── Nombre de función: "obtener cantidad de granos para una casilla".
         └── Sigue la convención camelCase (primera palabra minúscula, siguientes
             mayúscula).

    VI.  (number: Int)
         └── Parámetro de entrada: nombre "number", tipo Int (entero de 32 bits).
         └── ":" separa el nombre del tipo de dato.
         └── Analogía: el número de casilla que el usuario elige en el tablero.

    VII. : BigInteger
         └── Después de los paréntesis, indica el TIPO DE RETORNO de la función.
         └── Esta función DEVUELVE un BigInteger.
         └── Si no se especifica, el tipo de retorno es Unit (como void).

    VIII. if (number < 1 || number > 57)
          └── if: palabra reservada para CONDICIONAL (SI).
          └── (condición): entre paréntesis se evalúa si es verdadera o falsa.
          └── number < 1: ¿el número es MENOR que 1? (operador <).
          └── || : operador OR lógico — "O". Verdadero si AL MENOS una condición
               es verdadera.
          └── number > 64: ¿el número es MAYOR que 64? (operador >).
          └── Analogía: "SI el casillero está fuera del tablero (menor a 1 O mayor
               a 64), entonces es inválido."

    IX.  throw
         └── Palabra reservada para LANZAR una excepción (error).
         └── Detiene la ejecución normal y pasa el control al bloque catch (si hay).
         └── Analogía: una alarma que suena cuando alguien mete un dato incorrecto.

    X.   IllegalArgumentException("...")
         └── Tipo de excepción: "argumento ilegal" (dato no válido).
         └── El mensaje entre paréntesis explica qué salió mal.
         └── Solo letras (A-Z, a-z), espacios y punto.

    XI.  val bigNumber
         └── val: palabra reservada para variable INMUTABLE (no reasignable).
         └── bigNumber: nombre de variable ("número grande").
         └── Una vez asignado, no puede cambiar.

    XII. BigInteger.valueOf(2)
         └── Llamada a un MÉTODO ESTÁTICO de BigInteger.
         └── valueOf(2) crea un BigInteger con valor 2.
         └── Es equivalente a escribir BigInteger("2") pero más eficiente para
             valores pequeños.
         └── Analogía: pedirle a la fábrica de BigInteger que te dé el número 2.

    XIII. bigNumber.pow(number - 1)
          └── pow(): método que calcula POTENCIA (exponenciación).
          └── pow(3) → 2³ = 8.
          └── number - 1: el exponente. Casilla n → 2^(n-1).
          └── Analogía: empezar con 2 y multiplicarlo por sí mismo (n-1) veces.

    XIV. return
         └── Palabra reservada: DEVOLVER un valor al lugar que llamó la función.
         └── return bigNumber.pow(...) → entrega el resultado y termina.

    XV.  getTotalGrainCount
         └── Segunda función: "obtener el total de granos en todo el tablero".
         └── No recibe parámetros, solo devuelve BigInteger.

    XVI. var total = BigInteger.ZERO
         └── var: palabra reservada para variable MUTABLE (se puede reasignar).
         └── total: nombre de variable que acumulará la suma.
         └── BigInteger.ZERO: constante estática que vale cero (0).
         └── Analogía: una alcancía vacía que vamos a llenar moneda por moneda.

    XVII. for (i in 1..64)
          └── for: palabra reservada para BUCLE (repetir).
          └── i in 1..64: la variable i toma valores 1, 2, 3, ..., 64.
          └── 1..64: operador de RANGO (range), del 1 al 64 inclusive.
          └── Analogía: "Para cada casilla desde la 1 hasta la 64, haz algo."

    XVIII. total += getGrainCountForSquare(i)
           └── +=: operador de ASIGNACIÓN CON SUMA.
           └── total += X es equivalente a total = total + X.
           └── getGrainCountForSquare(i): llama a la función para la casilla i.
           └── Analogía: saca los granos de la casilla i y échalos a la alcancía.

    XIX. main
         └── Función especial: PUNTO DE ENTRADA del programa.
         └── Kotlin ejecuta main() automáticamente al correr el programa.
         └── Analogía: la puerta principal de una casa — por donde se entra.

    XX.  readln()
         └── Función de la biblioteca estándar: "read line" (leer línea).
         └── Lee una línea de texto desde el teclado (consola).
         └── Devuelve un String (texto).

    XXI. .toInt()
         └── Método que convierte un String a Int (entero).
         └── Si el texto no es un número válido, lanza excepción.
         └── Ej: "42".toInt() → 42.

    XXII. ${Board.getGrainCountForSquare(number)}
          └── Interpolación de cadenas (String templates).
          └── ${...}: dentro de un String con comillas dobles, ejecuta lo que hay
              entre llaves y CONVIERTE el resultado a texto.
          └── Board.getGrainCountForSquare(number): llama a la función del objeto
              Board pasando number como argumento.
          └── Analogía: un hueco en una frase que se rellena automáticamente con
              el resultado de un cálculo.

    XXIII. Board.getTotalGrainCount()
           └── Board: nombre del objeto singleton.
           └── . : operador punto — "accede al miembro de".
           └── getTotalGrainCount(): llamada a la función.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO Tablero

        FUNCION granosEnCasilla(numero):
            ENTRADA: numero (entero, 1-64)
            SALIDA: BigInteger

            SI numero < 1 O numero > 64:
                LANZAR error "Solo enteros entre 1 y 64"
            SINO:
                numeronGrande = BigInteger(2)
                DEVOLVER numeronGrande.elevado(numero - 1)

        FUNCION totalGranos():
            SALIDA: BigInteger

            total = BigInteger.CERO
            PARA cada i DESDE 1 HASTA 64:
                total = total + granosEnCasilla(i)
            DEVOLVER total

    ──────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. Mostrar "Ingresa un número entre 1 y 64"
        2. Leer número ingresado por el usuario y convertirlo a entero
        3. Mostrar "Los granos en la casilla [numero] son [Tablero.granosEnCasilla(numero)]"
        4. Mostrar "El total de granos en el tablero es [Tablero.totalGranos()]"

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: getGrainCountForSquare(1) — primera casilla

        Entrada: numero = 1
        Proceso:
            ¿1 < 1 O 1 > 64? → ¿falso O falso? → falso → NO lanza excepción
            numeronGrande = 2
            2^(1-1) = 2^0 = 1
        Resultado: 1 grano
        └── La primera casilla tiene exactamente 1 grano.

    EJEMPLO 2: getGrainCountForSquare(10) — casilla 10

        Entrada: numero = 10
        Proceso:
            ¿10 < 1 O 10 > 64? → falso
            numeronGrande = 2
            2^(10-1) = 2^9 = 512
        Resultado: 512 granos
        └── Patrón de duplicación: 1 → 2 → 4 → 8 → 16 → 32 → 64 → 128 → 256 → 512

    EJEMPLO 3: getTotalGrainCount() — suma total del tablero

        Entrada: ninguna
        Proceso:
            total = 0
            i = 1: total = 0 + 2^0 = 0 + 1 = 1
            i = 2: total = 1 + 2^1 = 1 + 2 = 3
            i = 3: total = 3 + 2^2 = 3 + 4 = 7
            i = 4: total = 7 + 2^3 = 7 + 8 = 15
            i = 5: total = 15 + 2^4 = 15 + 16 = 31
            ...
            i = 64: total = (2^64 - 1) = 18.446.744.073.709.551.615
        Resultado: 18.446.744.073.709.551.615 granos
        └── Equivale a 2^64 - 1. Es un número de 20 dígitos, más granos que
            los que existen en la Tierra.

    EJEMPLO 4: getGrainCountForSquare(70) — casilla inválida (fuera de rango)

        Entrada: numero = 70
        Proceso:
            ¿70 < 1 O 70 > 64? → ¿falso O verdadero? → verdadero
            → LANZA IllegalArgumentException
        Resultado: el programa se detiene con un error
        └── El tablero solo tiene 64 casillas. La entrada 70 no es válida.
*/
