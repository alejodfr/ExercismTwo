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