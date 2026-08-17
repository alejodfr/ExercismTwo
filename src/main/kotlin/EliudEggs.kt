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

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Dado el número decimal que muestra la pantalla del gallinero,
 *      calcular cuántos huevos hay realmente contando los bits en 1
 *      de su representación binaria.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Convertir el número decimal a su representación binaria
 *           como String.
 *      II.  Contar cuántos caracteres '1' aparecen en esa cadena.
 *      III. Ese conteo es la cantidad real de huevos.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  fun eggCount(number: Int): Int{
 *      →      val num = number
 *      →      val binary = num.toString(2) // transformar a binario
 *      ①  toString(2) convierte el entero a String en base 2
 *          (binario); ej. 6 → "110".
 *
 *      →      val count = binary.count { it == '1' } // cuenta cuantos '1' hay en el binario
 *      ②  .count { it == '1' } recorre la cadena binaria y cuenta los
 *          caracteres que son exactamente '1'.
 *
 *      →      return count
 *      ③  Ese conteo de unos es la cantidad de huevos en el gallinero.
 *      →  }
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Usar Integer.bitCount(number), función de la biblioteca
 *          estándar de Java que cuenta bits en 1 directamente.
 *      B)  Contar con desplazamiento de bits: mientras number > 0,
 *          sumar (number and 1) y desplazar number con shr(1).
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN conteoHuevos(numero): Entero
 *          binario ← numero.CONVERTIR_A_BASE(2)
 *          contador ← binario.CONTAR(caracter == '1')
 *          DEVOLVER contador
 *      FIN FUNCIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "eggCount(11)"
 *      ─────────────────────────────────────────────────────────
 *      11.toString(2) = "1011"
 *      count { it == '1' } → 3
 *      Resultado: 3 huevos
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "eggCount(0)"
 *      ─────────────────────────────────────────────────────────
 *      0.toString(2) = "0"
 *      count { it == '1' } → 0
 *      Resultado: 0 huevos
 *
 *  ================================================================
 */
