@file:Suppress("SpellCheckingInspection")

/**
 * Introduction
 *
 * You work for a company that makes an online, fantasy-survival game.
 * When a player finishes a level, they are awarded energy points.
 * The amount of energy awarded depends on which magical items the
 * player found while exploring that level.
 *
 * Instructions
 *
 * Your task is to write the code that calculates the energy points
 * awarded to players when they complete a level.
 *
 * The points depend on two things:
 * - The level (a number) that the player completed.
 * - The base value of each magical item collected during that level.
 *
 * Rules:
 * 1. For each magical item, take the base value and find all its
 *    multiples that are less than the level number.
 * 2. Combine the sets of numbers.
 * 3. Remove any duplicates.
 * 4. Calculate the sum of all remaining numbers.
 *
 * Example:
 * Player completed level 20 and found two items with base values 3 and 5.
 *
 * Multiples of 3 less than 20: {3, 6, 9, 12, 15, 18}
 * Multiples of 5 less than 20: {5, 10, 15}
 * Combined (duplicates removed): {3, 5, 6, 9, 10, 12, 15, 18}
 * Sum: 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78
 * Therefore, the player earns 78 energy points.
 */

object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val multiplesOfThree = mutableSetOf<Int>()
        for (factor in factors) {
            if (factor == 0){ continue }
            for (i in factor..(limit-1)) {
                if (i % factor == 0) {
                    multiplesOfThree.add(i)
                }
            }
        }
        return multiplesOfThree.sum()
    }
}

fun main(){
    val factors = setOf(3,5)
    val limit = 20
    println(SumOfMultiples.sum(factors, limit))
}

/** ══════════════════════════════════════════════════════════════════
 *  📚  GUÍA DE ANOTACIONES ESQUEMÁTICAS ASCII
 *  ─────────────────────────────────────────────────────────────────
 *  Sum of Multiples — Explicación completa del código fuente
 * ══════════════════════════════════════════════════════════════════
 *
 *  ┌── CÓDIGO ANOTADO ─────────────────────────────────────────────
 *  │
 *  │  object SumOfMultiples {
 *  │  └── object ──────► Declara un singleton (una sola instancia)
 *  │                       └── Español: "objeto"
 *  │                       └── Analogía: una caja de herramientas
 *  │                           única en el taller. No la fabricas,
 *  │                           solo la abres: SumOfMultiples.sum()
 *  │
 *  │      fun sum(factors: Set<Int>, limit: Int): Int {
 *  │      └── fun ──────► Declara una función (código reutilizable)
 *  │      │                └── Español: "función"
 *  │      │                └── Analogía: una receta de cocina:
 *  │      │                    ingredientes (parámetros) → plato (retorno)
 *  │      │
 *  │      ├── sum ──────► Nombre de la función ("suma")
 *  │      │
 *  │      ├── factors ──► Parámetro: conjunto de números base
 *  │      │  │            └── Set<Int> ──► colección sin duplicados de enteros
 *  │      │  └── limit ─► Parámetro: tope o nivel del jugador
 *  │      │               └── Int ──► número entero
 *  │      │
 *  │      └── : Int ────► Tipo de retorno: esta función devuelve un entero
 *  │
 *  │      val multiplesOfThree = mutableSetOf<Int>()
 *  │      └── val ──────► Variable de solo lectura (inmutable en referencia)
 *  │      │               └── Español: "valor"
 *  │      │               └── No reasignable, pero su contenido SÍ cambia
 *  │      │               └── (el Set es mutable aunque val sea fijo)
 *  │      │
 *  │      ├── = ────────► Asignación: "lo de la derecha va a la izquierda"
 *  │      │
 *  │      └── mutableSetOf<Int>() ──► Crea un Set mutable vacío de enteros
 *  │          └── Set ───► sin duplicados (clave: 15 aparece una sola vez)
 *  │          └── mutable ─► podemos hacer .add() dentro del bucle
 *  │          └── <Int> ──► solo guarda enteros
 *  │
 *  │      for (factor in factors) {
 *  │      └── for ──────► Bucle: repite el bloque para cada elemento
 *  │      │               └── Español: "para"
 *  │      │               └── Analogía: revisar cada libro en una estantería
 *  │      │
 *  │      ├── factor ───► Variable que toma el valor de cada elemento
 *  │      │  └── in ────► "en" — recorre el conjunto factors
 *  │      │
 *  │      └── factors ──► Conjunto a iterar {3, 5}
 *  │          └── 1ª vuelta: factor = 3 │ 2ª vuelta: factor = 5
 *  │
 *  │      if (factor == 0) { continue }
 *  │      └── if ───────► Condicional: si se cumple, ejecuta el bloque
 *  │      │               └── Español: "si"
 *  │      │               └── Analogía: un desvío en el camino
 *  │      │
 *  │      ├── factor == 0 ──► ¿factor es igual a cero?
 *  │      │  └── == ────► comparación de igualdad (NO confundir con =)
 *  │      │
 *  │      └── continue ─► Salta a la siguiente iteración del bucle
 *  │          └── Español: "continuar"
 *  │          └── ¿Por qué? Si factor = 0, i % 0 lanza error
 *  │             (división entre cero). continue lo evita.
 *  │
 *  │      for (i in factor..(limit - 1)) {
 *  │      └── for ──────► Segundo bucle (anidado dentro del primero)
 *  │      │               └── Por cada factor, prueba números candidatos
 *  │      │
 *  │      ├── i ────────► Variable del iterador interno (i = índice)
 *  │      │
 *  │      ├── factor ───► Inicio del rango (primer múltiplo posible)
 *  │      │
 *  │      ├── .. ───────► Operador de rango inclusivo: a..b = [a, b]
 *  │      │  └── Español: "hasta" (incluye ambos extremos)
 *  │      │
 *  │      └── limit - 1 ──► Excluye limit porque .. es inclusivo
 *  │          └── Si limit=20, el rango llega hasta 19 (menores que 20)
 *  │
 *  │      if (i % factor == 0) {
 *  │      └── if ───────► ¿Este número i es múltiplo de factor?
 *  │       └── i % factor ──► Módulo: residuo de dividir i ÷ factor
 *  │           └── % ────► "módulo" — ej: 9 % 3 = 0, 10 % 3 = 1
 *  │           └── == 0 ──► residuo cero → i es divisible exactamente
 *  │
 *  │      multiplesOfThree.add(i)
 *  │      └── .add(i) ──► Agrega i al conjunto acumulador
 *  │          └── Si ya existe (ej. 15 con factores 3 y 5),
 *  │              el Set lo ignora — no hay duplicados
 *  │
 *  │      return multiplesOfThree.sum()
 *  │      └── return ───► Devuelve el valor y termina la función
 *  │       └── .sum() ──► Suma todos los enteros del Set
 *  │           └── Itera internamente y acumula: 3+5+6+9+10+12+15+18
 *  │
 *  └───────────────────────────────────────────────────────────────
 *
 *  ┌── TABLA DE PALABRAS RESERVADAS ───────────────────────────────
 *  │
 *  │  ┌───────────┬──────────────────┬──────────────────────────────────────────┐
 *  │  │ Palabra   │ Español          │ Explicación                              │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ object    │ objeto           │ Declara un singleton (una única           │
 *  │  │           │                  │ instancia global). Sin new, se usa        │
 *  │  │           │                  │ directo: Nombre.metodo().                  │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ fun       │ función          │ Define un bloque de código con nombre,    │
 *  │  │           │                  │ parámetros y tipo de retorno.             │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ val       │ valor            │ Variable de solo lectura. La referencia   │
 *  │  │           │                  │ no se reasigna, pero el contenido sí       │
 *  │  │           │                  │ puede mutar (si es mutable).               │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ for       │ para             │ Bucle que itera sobre colecciones/rangos.  │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ in        │ en               │ Usado en for: indica qué colección        │
 *  │  │           │                  │ o rango se recorre.                       │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ if        │ si               │ Condicional: ejecuta código si la         │
 *  │  │           │                  │ expresión booleana es true.                │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ continue  │ continuar        │ Dentro de un bucle, salta a la siguiente   │
 *  │  │           │                  │ iteración (ignora el resto del cuerpo).    │
 *  │  └───────────┴──────────────────┴──────────────────────────────────────────┘
 *  │
 *  └───────────────────────────────────────────────────────────────
 *
 *  ┌── TABLA DE OPERADORES IMPORTANTES ────────────────────────────
 *  │
 *  │  ┌───────────┬──────────────────┬──────────────────────────────────────────┐
 *  │  │ Operador  │ Español          │ Explicación                              │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ =         │ asignación       │ Asigna el valor derecho a la variable     │
 *  │  │           │                  │ izquierda. NO confundir con ==.           │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ ==        │ igualdad         │ Compara si dos valores son iguales.       │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ %         │ módulo/residuo   │ Residuo de la división entera.            │
 *  │  │           │                  │ x % y == 0 → x es múltiplo de y.          │
 *  │  │           │                  │ Ej: 10 % 3 = 1, 9 % 3 = 0.               │
 *  │  ├───────────┼──────────────────┼──────────────────────────────────────────┤
 *  │  │ ..        │ rango (hasta)    │ Crea un intervalo inclusivo [a, b].      │
 *  │  │           │                  │ Ej: 3..5 produce 3, 4, 5.                │
 *  │  └───────────┴──────────────────┴──────────────────────────────────────────┘
 *  │
 *  └───────────────────────────────────────────────────────────────
 *
 *  ┌── RESUMEN ALGORÍTMICO ─────────────────────────────────────────
 *  │
 *  │  PSEUDOCÓDIGO
 *  │  ────────────
 *  │
 *  │    ENTRADA: factors = conjunto de enteros, limit = entero
 *  │    SALIDA:  suma de todos los múltiplos < limit
 *  │
 *  │    1.  multiples ← conjunto vacío
 *  │    2.  POR CADA factor EN factors:
 *  │    3.      SI factor = 0 → SALTAR
 *  │    4.      POR i DESDE factor HASTA limit - 1:
 *  │    5.          SI i ES MÚLTIPLO DE factor (i % factor = 0):
 *  │    6.              AGREGAR i A multiples
 *  │    7.          FIN SI
 *  │    8.      FIN POR
 *  │    9.  FIN POR
 *  │    10. DEVOLVER suma(multiples)
 *  │
 *  │  ──────────────────────────────────────────────────────────────
 *  │
 *  │  EJEMPLO RESUELTO
 *  │  ───────────────
 *  │
 *  │    Input: factors = {3, 5}, limit = 20
 *  │
 *  │    multiples = {}
 *  │    ─────────────────────────────────────────────────────
 *  │    factor = 3  (≠ 0 → continuamos)
 *  │    ├── i =  3 → 3 % 3 = 0 → ✓ → multiples = {3}
 *  │    ├── i =  4 → 4 % 3 = 1 → ✗
 *  │    ├── i =  5 → 5 % 3 = 2 → ✗
 *  │    ├── i =  6 → 6 % 3 = 0 → ✓ → multiples = {3, 6}
 *  │    ├── i =  7 → 7 % 3 = 1 → ✗
 *  │    ├── i =  8 → 8 % 3 = 2 → ✗
 *  │    ├── i =  9 → 9 % 3 = 0 → ✓ → multiples = {3, 6, 9}
 *  │    ├── i = 10 → 10 % 3 = 1 → ✗
 *  │    ├── i = 11 → 11 % 3 = 2 → ✗
 *  │    ├── i = 12 → 12 % 3 = 0 → ✓ → multiples = {3, 6, 9, 12}
 *  │    ├── i = 13 → 13 % 3 = 1 → ✗
 *  │    ├── i = 14 → 14 % 3 = 2 → ✗
 *  │    ├── i = 15 → 15 % 3 = 0 → ✓ → multiples = {3, 6, 9, 12, 15}
 *  │    ├── i = 16 → 16 % 3 = 1 → ✗
 *  │    ├── i = 17 → 17 % 3 = 2 → ✗
 *  │    ├── i = 18 → 18 % 3 = 0 → ✓ → multiples = {3, 6, 9, 12, 15, 18}
 *  │    └── i = 19 → 19 % 3 = 1 → ✗
 *  │
 *  │    factor = 5  (≠ 0 → continuamos)
 *  │    ├── i =  5 → 5 % 5 = 0 → ✓ → multiples = {3, 5, 6, 9, 12, 15, 18}
 *  │    ├── i =  6 → 6 % 5 = 1 → ✗
 *  │    ├── i =  7 → 7 % 5 = 2 → ✗
 *  │    ├── i =  8 → 8 % 5 = 3 → ✗
 *  │    ├── i =  9 → 9 % 5 = 4 → ✗
 *  │    ├── i = 10 → 10 % 5 = 0 → ✓ → multiples = {3, 5, 6, 9, 10, 12, 15, 18}
 *  │    ├── i = 11 → 11 % 5 = 1 → ✗
 *  │    ├── i = 12 → 12 % 5 = 2 → ✗
 *  │    ├── i = 13 → 13 % 5 = 3 → ✗
 *  │    ├── i = 14 → 14 % 5 = 4 → ✗
 *  │    ├── i = 15 → 15 % 5 = 0 → ✓ → ya existe (del factor 3), no se duplica
 *  │    ├── i = 16 → 16 % 5 = 1 → ✗
 *  │    ├── i = 17 → 17 % 5 = 2 → ✗
 *  │    ├── i = 18 → 18 % 5 = 3 → ✗
 *  │    └── i = 19 → 19 % 5 = 4 → ✗
 *  │
 *  │    multiples = {3, 5, 6, 9, 10, 12, 15, 18}
 *  │    ─────────────────────────────────────────────────────
 *  │    suma = 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78
 *  │
 *  │  ✅ Resultado: SumOfMultiples.sum({3, 5}, 20) → 78
 *  │
 *  └───────────────────────────────────────────────────────────────
 */