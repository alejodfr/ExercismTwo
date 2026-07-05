@file:Suppress("SpellCheckingInspection")


/**
 * # Eliud's Eggs
 *
 * ## Introduction
 * Your friend Eliud inherited a farm from her grandma Tigist.
 * Her granny was an inventor and had a tendency to build things
 * in an overly complicated manner. The chicken coop has a digital
 * display showing an encoded number representing the positions of
 * all eggs that could be picked up.
 *
 * Eliud is asking you to write a program that shows the actual
 * number of eggs in the coop.
 *
 * ## Encoding
 * The position information encoding is calculated as follows:
 *
 * 1. Scan the potential egg-laying spots and mark down a **1**
 *    for an existing egg or a **0** for an empty spot.
 * 2. Convert the number from **binary** to **decimal**.
 * 3. Show the result on the display.
 */

object EliudsEggs {

    fun eggCount(number: Int): Int{
        val num = number
        val binary = num.toString(2) // transformar a binario
        val count = binary.count { it == '1' } // cuenta cuantos '1' hay en el binario
        return count
    }
}

fun main(){
    println("Enter the number")
    val number = readln().toInt()
    println("Decimal number on the display: $number")
    println("Actual eggs in the coop: ${EliudsEggs.eggCount(number)}")
}

/**
 * ╔══════════════════════════════════════════════════════════════╗
 * ║      GUÍA DE ESTUDIO — EliudsEggs.kt (Huevos de Eliud)     ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * ────────────────────────────────────────────────────────────
 *  CÓDIGO ANOTADO
 * ────────────────────────────────────────────────────────────
 *
 * object EliudsEggs {                                   ──► Objeto singleton
 * │
 * └── fun eggCount(number: Int): Int {                  ──► Recibe un número decimal,
 *     │                                                     cuenta cuántos bits "1" tiene
 *     │                                                     en binario → cantidad de huevos
 *     │
 *     ├── val num = number                              ──► Copia el parámetro (val → no cambia)
 *     │
 *     ├── val binary = num.toString(2)                  ──► Convierte el número a String binario
 *     │                                                     Ej: 6 → "110"
 *     │
 *     ├── val count = binary.count { it == '1' }        ──► Cuenta cuántos caracteres '1'
 *     │                                                     aparecen en la cadena binaria
 *     │
 *     └── return count                                  ──► Devuelve el conteo
 *     }
 * }
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE PALABRAS RESERVADAS
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────┬────────────────────────────────────────────────┐
 *  │ Palabra  │  Significado                                   │
 *  ├──────────┼────────────────────────────────────────────────┤
 *  │ object   │  Objeto singleton                              │
 *  │ fun      │  Definir función                               │
 *  │ val      │  Variable inmutable (no reasignable)           │
 *  │ Int      │  Tipo entero                                   │
 *  │ count    │  Función que cuenta elementos según condición  │
 *  │ return   │  Devolver valor                                │
 *  │ it       │  Parámetro implícito dentro de una lambda      │
 *  │ ==       │  Comparación de igualdad                       │
 *  └──────────┴────────────────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  TABLA DE OPERADORES IMPORTANTES
 * ────────────────────────────────────────────────────────────
 *
 *  ┌──────────┬──────────┬─────────────────────────────────────┐
 *  │ Operador │  Uso     │  Explicación                        │
 *  ├──────────┼──────────┼─────────────────────────────────────┤
 *  │  .       │ a.b()    │  Llamar método                      │
 *  │  ==      │ a == b   │  ¿Son iguales?                      │
 *  │  { }     │ { it }   │  Lambda (función anónima)           │
 *  │  ->      │ (2)      │  Base para toString(base)           │
 *  └──────────┴──────────┴─────────────────────────────────────┘
 *
 * ────────────────────────────────────────────────────────────
 *  RESUMEN ALGORÍTMICO
 * ────────────────────────────────────────────────────────────
 *
 *  PSEUDOCÓDIGO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  función eggCount(numero):                             │
 *  │      binario ← convertir numero a base 2 (String)      │
 *  │      contar cuántos caracteres '1' tiene binario       │
 *  │      devolver ese conteo                               │
 *  └─────────────────────────────────────────────────────────┘
 *
 *  EJEMPLO TRABAJADO:
 *  ┌─────────────────────────────────────────────────────────┐
 *  │  Entrada: number = 11                                   │
 *  │                                                         │
 *  │  Paso 1: 11.toString(2) → "1011"                        │
 *  │                                                         │
 *  │  Paso 2: "1011".count { it == '1' }                    │
 *  │           carácter por carácter:                        │
 *  │           '1' → sí (1)                                  │
 *  │           '0' → no                                      │
 *  │           '1' → sí (2)                                  │
 *  │           '1' → sí (3)                                  │
 *  │           total = 3                                     │
 *  │                                                         │
 *  │  Interpretación: el número 11 en decimal                │
 *  │  → 1011 en binario → 3 posiciones con huevo            │
 *  │  → 3 huevos en el gallinero                            │
 *  └─────────────────────────────────────────────────────────┘
 */
