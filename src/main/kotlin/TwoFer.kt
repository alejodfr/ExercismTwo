@file:Suppress("SpellCheckingInspection")


/**
 * Introduction
 *
 * In some English accents, "two for" said quickly sounds like "two fer".
 * Two-for-one means if you buy one, you get one free.
 *
 * Imagine a bakery with a holiday offer: two cookies for the price of one.
 * You take the offer and give the extra cookie to someone else in the queue.
 *
 * Instructions
 *
 * Determine what you will say as you give away the extra cookie.
 *
 * - If you know the person's name:  "One for Do-yun, one for me."
 * - If you don't know their name:   "One for you, one for me."
 *
 * Examples:
 *   Name    | Dialogue
 *   --------|---------------------------
 *   Alice   | One for Alice, one for me.
 *   Bohdan  | One for Bohdan, one for me.
 *   (none)  | One for you, one for me.
 *   Zaphod  | One for Zaphod, one for me.
 */

fun twofer(name: String? = null): String {
    if (name != null){
        return "One for $name, one for me."
    } else {
        return "One for you, one for me."
    }
}

fun main() {
    // Con nombre
    println(twofer("Alice"))   // One for Alice, one for me.
    println(twofer("Zaphod"))  // One for Zaphod, one for me.

    // Sin nombre — dos formas equivalentes
    println(twofer())          // One for you, one for me.
    println(twofer(null))      // One for you, one for me.
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Se pide implementar una función que genere un mensaje para una oferta
    "two-for-one" (dos por uno) de galletas. Si conoces el nombre de la
    persona, dices "One for [nombre], one for me."; si no, dices "One for
    you, one for me."

    OBJETIVOS:
    I.   Crear una función twofer que acepte un parámetro opcional name.
    II.  Si name NO es null, devolver "One for $name, one for me."
    III. Si name ES null, devolver "One for you, one for me."
    IV.  Usar un valor por defecto (null) para que se pueda llamar sin
         argumentos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. ANALISIS DEL PROBLEMA
       └── Entrada: un nombre opcional (String o null).
       └── Salida: un String con el mensaje formateado.
       └── Si hay nombre → se interpola en el mensaje.
       └── Si no hay → se usa "you".

    II. DISENO DE LA FUNCION
        a) Declarar fun twofer con parámetro name: String? = null
           └── String? permite null.
           └── = null le da valor por defecto.
        b) Tipo de retorno: String (nunca null).
        c) Cuerpo: condicional if/else.

    III. IMPLEMENTACION
         a) Evaluar name != null → devolver "One for $name, one for me."
         b) else → devolver "One for you, one for me."

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ fun twofer(name: String? = null): String {                              │
    │     if (name != null) {                                                 │
    │         return "One for $name, one for me."                             │
    │     } else {                                                            │
    │         return "One for you, one for me."                               │
    │     }                                                                   │
    │ }                                                                       │
    │ fun main() {                                                            │
    │     println(twofer("Alice"))                                            │
    │     println(twofer("Zaphod"))                                           │
    │     println(twofer())                                                   │
    │     println(twofer(null))                                               │
    │ }                                                                       │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   fun
         └── Palabra reservada que declara una "función" (bloque de código
             reutilizable).
         └── Analogía: una receta de cocina — describes los pasos una vez y
             los ejecutas cada vez que la necesitas.

    II.  twofer
         └── Nombre de la función. Juego de palabras: "two for" → "two fer".
         └── Identificador elegido por el programador. Por convención en
             Kotlin usa camelCase (minúscula inicial).

    III. (name: String? = null)
         └── Parámetro opcional con valor por defecto.
         └── name : identificador del parámetro.
         └── String? : tipo nullable — puede ser un String o null.
             └── "?" marca que el tipo acepta null.
             └── Analogía: una caja que puede contener un texto o estar vacía.
         └── = null : valor por defecto. Si no se pasa argumento, name = null.
             └── "=" es operador de asignación: "dale el valor de la derecha".

    IV.  : String
         └── Declaración del tipo de retorno (lo que la función devuelve).
         └── Esta función SIEMPRE devuelve un String (nunca null).
         └── Analogía: la promesa de que al final de la receta obtendrás un plato.

    V.   if (name != null) { ... } else { ... }
         └── if : estructura condicional — "si se cumple esta condición..."
         └── name != null : expresión booleana.
             └── != : operador "diferente de" (compara si dos cosas NO son iguales).
             └── null : palabra reservada que representa "ausencia de valor".
         └── { ... } : bloque de código (agrupa una o más sentencias).
         └── else : "si no..." — ejecuta el segundo bloque cuando la condición es false.

    VI.  return
         └── Palabra reservada: "devolver".
         └── Termina la función y entrega el valor especificado.
         └── Analogía: la bandeja de salida del horno — sacas el resultado.

    VII. "One for $name, one for me."
         └── String literal (cadena de texto entre comillas dobles).
         └── $name : interpolación de variables.
             └── "$" seguido de un nombre de variable inserta su valor en el String.
             └── Si name = "Alice", el resultado es "One for Alice, one for me."
         └── Analogía: un marcador de posición en un molde — se rellena con el valor.

    VIII. "One for you, one for me."
          └── String fijo (sin interpolación). Siempre es el mismo texto.
          └── Se usa cuando name es null.

    IX.  main
         └── Función especial: punto de entrada del programa.
         └── Cuando ejecutas el programa, Kotlin busca y ejecuta main().
         └── Analogía: la puerta principal de una casa — todo empieza ahí.

    X.   println(...)
         └── Función de biblioteca: "print line" (imprimir línea).
         └── Muestra texto en la consola y añade un salto de línea al final.

    XI.  twofer("Alice") / twofer("Zaphod")
         └── Llamadas a la función con argumento (String no null).
         └── El argumento "Alice" se asigna al parámetro name.

    XII. twofer() / twofer(null)
         └── Llamadas sin argumento → se usa el valor por defecto null.
         └── twofer(null) pasa null explícitamente (equivalente).

    XIII. // Comentario
          └── Línea que comienza con "//": comentario de una línea.
          └── El compilador ignora los comentarios; son solo para humanos.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    FUNCION twofer(nombre: String o null = null) → String:
        SI nombre NO ES igual a null:
            DEVOLVER "One for " + nombre + ", one for me."
        SINO:
            DEVOLVER "One for you, one for me."
        FIN SI
    FIN FUNCION

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. imprimir( twofer("Alice") )   → "One for Alice, one for me."
        2. imprimir( twofer("Zaphod") )  → "One for Zaphod, one for me."
        3. imprimir( twofer() )          → "One for you, one for me."
        4. imprimir( twofer(null) )      → "One for you, one for me."

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: twofer("Alice")  — con nombre conocido

        Entrada:  name = "Alice"
        Proceso:
            name != null? → true (Alice NO es null)
            └── Se ejecuta el bloque if
            └── return "One for $name, one for me."
            └── $name se reemplaza por "Alice"
        Resultado: "One for Alice, one for me."

    EJEMPLO 2: twofer()  — sin argumento (valor por defecto)

        Entrada:  name = null (valor por defecto)
        Proceso:
            name != null? → false (null ES null)
            └── Se ejecuta el bloque else
            └── return "One for you, one for me."
        Resultado: "One for you, one for me."

    EJEMPLO 3: twofer(null)  — null explícito

        Entrada:  name = null (pasado explícitamente)
        Proceso:
            name != null? → false
            └── Se ejecuta el bloque else
            └── return "One for you, one for me."
        Resultado: "One for you, one for me."
        └── NOTA: twofer() y twofer(null) producen el mismo resultado.
*/