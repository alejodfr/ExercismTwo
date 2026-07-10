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

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Problema: En un gallinero digital, los huevos se codifican en binario.
    Se marca 1 si hay un huevo y 0 si no. Ese binario se convierte a decimal
    y se muestra en una pantalla. Eliud necesita el programa inverso: dado
    el número decimal, ¿cuántos huevos hay realmente?

    OBJETIVOS:
    I.   Crear un objeto EliudsEggs con una función eggCount.
    II.  eggCount recibe un Int (número decimal de la pantalla).
    III. Convertir ese número a su representación binaria (String de 0s y 1s).
    IV.  Contar cuántos caracteres '1' hay en la cadena binaria.
    V.   Devolver ese conteo (la cantidad de huevos).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. ENTENDER EL PROBLEMA
       └── El display muestra un número decimal.
       └── Ese decimal provino de un número binario donde:
           └── 1 = hay un huevo en esa posición.
           └── 0 = no hay huevo.
       └── Queremos saber cuántos 1s tiene el binario original.
       └── Es decir: contar los bits encendidos (population count / popcount).

    II. CONVERTIR DECIMAL A BINARIO
        └── En Kotlin, toString(2) convierte un Int a su representación binaria.
        └── Ejemplos:
            0.toString(2) → "0"
            1.toString(2) → "1"
            2.toString(2) → "10"
            6.toString(2) → "110"
            11.toString(2) → "1011"

    III. CONTAR LOS UNOS
         └── .count { it == '1' } cuenta cuántos caracteres cumplen la condición.
         └── it es el parámetro implícito de la lambda (cada carácter).
         └── == '1' compara si el carácter es exactamente '1'.

    IV. CONSIDERACIONES
        └── Si el número es 0, toString(2) → "0" → no hay unos → 0 huevos.
        └── El rango de números posibles no está limitado, pero Int en Kotlin
            es de 32 bits (rango -2³¹ a 2³¹-1). Para este ejercicio asumimos
            números positivos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object EliudsEggs {                                                      │
    │     fun eggCount(number: Int): Int {                                     │
    │         val num = number                                                 │
    │         val binary = num.toString(2)                                     │
    │         val count = binary.count { it == '1' }                           │
    │         return count                                                     │
    │     }                                                                    │
    │ }                                                                        │
    │                                                                          │
    │ fun main() {                                                             │
    │     println("Enter the number")                                          │
    │     val number = readln().toInt()                                        │
    │     println("Decimal number on the display: $number")                    │
    │     println("Actual eggs in the coop: ${EliudsEggs.eggCount(number)}")   │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada que declara un SINGLETON.
         └── Crea clase e instancia única en una sola línea.
         └── Analogía: el sensor del gallinero — hay una única unidad que
             cuenta los huevos.

    II.  EliudsEggs
         └── Nombre del objeto (mayúscula inicial, convención Kotlin).
         └── "Los huevos de Eliud" — nombre descriptivo del problema.

    III. fun eggCount(number: Int): Int
         └── fun: palabra reservada "función".
         └── eggCount: nombre de la función ("conteo de huevos").
         └── (number: Int): parámetro de entrada — el número decimal.
         └── : Int: tipo de retorno — devuelve un entero (cantidad de huevos).
         └── Analogía: una calculadora especial que recibe un número y te dice
             cuántos huevos hay.

    IV.  val num = number
         └── val: variable INMUTABLE.
         └── num: nombre de la copia del parámetro.
         └── = number: asigna el valor recibido.
         └── En Kotlin, los parámetros de función son inmutables, pero aquí
             se asigna a otra val por claridad (es redundante, pero didáctico).

    V.   .toString(2)
         └── Método de la clase Int (heredado de Number).
         └── Convierte el número a su representación en STRING en la BASE dada.
         └── toString(2) = base 2 (binario).
         └── toString(8) = base 8 (octal).
         └── toString(16) = base 16 (hexadecimal).
         └── Analogía: traducir un número decimal a un idioma que solo usa
             los dígitos 0 y 1.

    VI.  binary
         └── Variable (String) que almacena la representación binaria.
         └── Ej: para num = 6, binary = "110".

    VII. .count { it == '1' }
         └── .count(): método de las colecciones/iterables.
         └── { it == '1' }: LAMBDA que define la condición.
         └── it: parámetro IMPLÍCITO — representa cada elemento de la cadena.
         └── == '1': compara el carácter con '1'.
         └── count devuelve cuántos elementos cumplen la condición.
         └── Analogía: pasar lista en el gallinero — "¿quién está presente?"
             y contar cuántos responden "sí".

    VIII. { ... } (lambda)
          └── Bloque de código que define una función anónima.
          └── Cuando el lambda tiene UN SOLO parámetro, Kotlin permite usar
              it en lugar de nombrarlo.
          └── Equivalente a: .count { character -> character == '1' }

    IX.  it
         └── Nombre por defecto del parámetro implícito en una lambda.
         └── Solo disponible cuando el lambda tiene exactamente un parámetro.
         └── Viene de "it" = "ello" o "eso" en inglés.
         └── Analogía: en una frase como "cuenta los que SON iguales a 1",
             "los que" es el sujeto implícito — it es ese sujeto.

    X.   ==
         └── Operador de IGUALDAD ESTRUCTURAL.
         └── Compara VALORES, no referencias.
         └── En este caso, it == '1' devuelve true si el carácter es '1'.
         └── Analogía: preguntar "¿esto ES exactamente un 1?"

    XI.  return count
         └── return: palabra reservada que DEVUELVE el valor y termina la función.
         └── count: la cantidad de '1's encontrada.

    XII. main()
         └── Función principal: punto de entrada del programa.
         └── Se ejecuta automáticamente al correr la aplicación.

    XIII. readln()
          └── Función de biblioteca estándar: "read line".
          └── Lee UNA LÍNEA completa desde la consola (hasta Enter).
          └── Devuelve un String.

    XIV. .toInt()
         └── Método de String: convierte el texto a Int.
         └── Lanza NumberFormatException si el texto no es un número válido.
         └── Ej: "42".toInt() → 42.

    XV.  "Decimal number on the display: $number"
         └── INTERPOLACIÓN de cadenas (String templates).
         └── $number: dentro de un String entre comillas dobles, reemplaza
             $variable por el valor de esa variable convertido a texto.
         └── Analogía: un hueco en un texto que se llena automáticamente.

    XVI. ${EliudsEggs.eggCount(number)}
         └── Interpolación CON EXPRESIÓN: ${...} ejecuta código y convierte
             el resultado a texto.
         └── EliudsEggs.eggCount(number): llama a la función eggCount del
             objeto EliudsEggs pasándole el número leído.
         └── Analogía: llamar al contador de huevos y pegar el resultado
             directamente en la frase.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO HuevosEliud

        FUNCION conteoHuevos(numero):
            ENTRADA: numero (entero)
            SALIDA: entero

            temporal = numero                       // copia del número
            binario = temporal.aTexto(2)            // convertir a binario (String)
            contador = binario.contar { cadaCaracter == '1' }  // contar los '1'
            DEVOLVER contador

    ──────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. Mostrar "Ingresa el número"
        2. numero = leerDeConsola().aEntero()
        3. Mostrar "Número decimal en la pantalla: [numero]"
        4. Mostrar "Huevos reales en el gallinero: [HuevosEliud.conteoHuevos(numero)]"

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: eggCount(0) — ningún huevo

        Entrada: number = 0
        Proceso:
            num = 0
            binary = 0.toString(2) = "0"
            count = "0".count { it == '1' }
                └── it='0', ¿'0' == '1'? → falso → no cuenta
            count = 0
        Resultado: 0 huevos
        └── Si el display muestra 0, significa que no hay ningún huevo.

    EJEMPLO 2: eggCount(6) — huevos en posiciones intermedias

        Entrada: number = 6
        Proceso:
            num = 6
            binary = 6.toString(2) = "110"
            count = "110".count { it == '1' }
                └── it='1' → ¿'1' == '1'? → verdadero → cuenta (1)
                └── it='1' → ¿'1' == '1'? → verdadero → cuenta (2)
                └── it='0' → ¿'0' == '1'? → falso → no cuenta
            count = 2
        Resultado: 2 huevos
        └── El 6 en binario es 110, significando: posición 3 tiene huevo (1),
            posición 2 tiene huevo (1), posición 1 vacía (0). → 2 huevos.

    EJEMPLO 3: eggCount(255) — todos los bits encendidos

        Entrada: number = 255
        Proceso:
            num = 255
            binary = 255.toString(2) = "11111111"  (8 unos)
            count = "11111111".count { it == '1' }
                └── 8 caracteres, todos son '1' → 8 cuentan
            count = 8
        Resultado: 8 huevos
        └── 255 en binario = 11111111 (8 bits). Los 8 espacios de este grupo
            tienen huevo.

    EJEMPLO 4: eggCount(7) — tres bits encendidos

        Entrada: number = 7
        Proceso:
            num = 7
            binary = 7.toString(2) = "111"
            count = "111".count { it == '1' }
                └── tres '1' → cuenta 3
            count = 3
        Resultado: 3 huevos
        └── 7 decimal = 111 binario → huevos en 3 posiciones consecutivas.

    EJEMPLO 5: eggCount(1024) — un solo bit encendido

        Entrada: number = 1024
        Proceso:
            num = 1024
            binary = 1024.toString(2) = "10000000000"  (1 seguido de 10 ceros)
            count = "10000000000".count { it == '1' }
                └── solo el primer carácter es '1' → cuenta 1
            count = 1
        Resultado: 1 huevo
        └── 1024 = 2¹⁰. Solo la posición 11 tiene huevo.
*/
