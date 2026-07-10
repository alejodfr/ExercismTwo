@file:Suppress("SpellCheckingInspection")

/**
 * Instructions
 *
 * Calculate the points scored in a single toss of a Darts game.
 *
 * Darts is a game where players throw darts at a target.
 * The target rewards 4 different amounts of points,
 * depending on where the dart lands:
 *
 *   - Outside the target:        0 points
 *   - Outer circle (radius 10):  1 point
 *   - Middle circle (radius 5):  5 points
 *   - Inner circle (radius 1):  10 points
 *
 * All circles are concentric, centered at (0, 0).
 *
 * Given a point (x, y), calculate the correct score earned
 * by a dart landing at that point.
 */

object Darts {

    fun score(x: Number, y: Number ): Int {
        var firstCordinate = x
        var secondCordinate = y
        var distance = Math.sqrt(Math.pow(firstCordinate.toDouble(), 2.0) + Math.pow(secondCordinate.toDouble(), 2.0))
        if (distance<=1){
            return 10
        } else if (distance<=5){
            return 5
        } else if (distance<=10){
            return 1
        } else {
            return 0
        }

    }
}

fun main(){
    println("Enter the x coordinate")
    val x = readLine()
    println("Enter the y coordinate")
    val y = readLine()
    println("The score is ${Darts.score(x.toString().toDouble(), y.toString().toDouble())}")
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Calcular los puntos obtenidos en un lanzamiento de dardos.

    El blanco tiene 4 zonas concéntricas centradas en (0, 0):
      - Fuera del blanco (radio > 10):              0 puntos
      - Círculo exterior (radio ≤ 10):               1 punto
      - Círculo medio (radio ≤ 5):                   5 puntos
      - Círculo interior (radio ≤ 1):               10 puntos

    OBJETIVOS:
    I.   Calcular la distancia del punto (x, y) al origen (0, 0) con Pitágoras.
    II.  Comparar la distancia contra los radios 1, 5 y 10.
    III. Devolver 10, 5, 1 o 0 según la zona donde cayó el dardo.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    I. CALCULO DE LA DISTANCIA
       └── Usar el teorema de Pitágoras: distancia = raiz(x² + y²).
       └── En código: Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0)).
       └── Convertir x e y a Double con toDouble().

    II. EVALUACION DE LA ZONA
       └── if (distancia <= 1)   → círculo interior → 10 puntos.
       └── else if (distancia <= 5)   → círculo medio → 5 puntos.
       └── else if (distancia <= 10)  → círculo exterior → 1 punto.
       └── else → fuera del blanco → 0 puntos.

    III. PROGRAMA PRINCIPAL
       └── Pedir coordenadas con readLine(), convertir a Double.
       └── Llamar Darts.score(x, y) y mostrar el resultado.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ object Darts {                                                           │
    │                                                                          │
    │     fun score(x: Number, y: Number ): Int {                              │
    │         var firstCordinate = x                                           │
    │         var secondCordinate = y                                          │
    │         var distance = Math.sqrt(                                        │
    │             Math.pow(firstCordinate.toDouble(), 2.0)                     │
    │             + Math.pow(secondCordinate.toDouble(), 2.0)                  │
    │         )                                                                │
    │         if (distance<=1){                                                │
    │             return 10                                                    │
    │         } else if (distance<=5){                                         │
    │             return 5                                                     │
    │         } else if (distance<=10){                                        │
    │             return 1                                                     │
    │         } else {                                                         │
    │             return 0                                                     │
    │         }                                                                │
    │     }                                                                    │
    │ }                                                                        │
    │                                                                          │
    │ fun main(){                                                              │
    │     println("Enter the x coordinate")                                    │
    │     val x = readLine()                                                   │
    │     println("Enter the y coordinate")                                    │
    │     val y = readLine()                                                   │
    │     println("The score is ${Darts.score(x.toString().toDouble(),         │
    │         y.toString().toDouble())}")                                      │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   object
         └── Palabra reservada que crea un singleton (única instancia global).
         └── Analogía: una caja de herramientas única en el taller.

    II.  Darts
         └── Nombre del objeto. Por convención empieza con mayúscula.

    III. fun
         └── Palabra reservada "function". Define un bloque de código reutilizable.
         └── Analogía: una receta de cocina — se escribe una vez, se usa muchas veces.

    IV.  score
         └── Nombre de la función que calcula el puntaje.

    V.   (x: Number, y: Number)
         └── Parámetros: x (coordenada horizontal), y (coordenada vertical).
         └── Number: tipo padre de Int, Double, Float — acepta cualquier número.

    VI.  : Int
         └── Declara que la función devuelve un Int (entero de 32 bits).

    VII. var
         └── Declara variable MUTABLE (se puede reasignar después).
         └── Analogía: una pizarra blanca — puedes borrar y escribir de nuevo.

    VIII. firstCordinate / secondCordinate / distance
         └── Nombres de variables locales.
         └── firstCordinate = x, secondCordinate = y, distance = resultado del cálculo.

    IX.  = (asignación)
         └── Operador que guarda el valor de la derecha en la variable de la izquierda.
         └── NO confundir con == (comparación de igualdad).

    X.   Math.sqrt(...)
         └── Función de la biblioteca estándar: raíz cuadrada (square root).
         └── Devuelve Double.

    XI.  Math.pow(base, exponente)
         └── Eleva "base" a la potencia "exponente".
         └── Ej: Math.pow(3.0, 2.0) = 9.0.

    XII. .toDouble()
         └── Convierte un Number a Double (formato decimal de 64 bits).
         └── Necesario porque Math.pow solo acepta Doubles.

    XIII. 2.0
         └── Literal Double. El ".0" lo distingue de un entero.

    XIV. + (suma)
         └── Operador aritmético que suma dos valores.
         └── Aquí suma x² + y² dentro de la raíz cuadrada.

    XV.  if (condición) { ... }
         └── Estructura condicional: si la condición es true, ejecuta el bloque.
         └── Analogía: SI llueve → llevo paraguas.

    XVI. else if (condición) { ... }
         └── "Sino, si": se evalúa solo si el if anterior fue false.

    XVII. else { ... }
         └── "Sino": se ejecuta si ninguna condición anterior fue true.

    XVIII. <=
         └── Operador "menor o igual que". Devuelve true o false.
         └── distance <= 5 → "¿distance es menor o igual a 5?"

    XIX. return
         └── Termina la función y devuelve el valor indicado.
         └── return 10 → la función termina y entrega 10.

    XX.  { } (llaves)
         └── Delimitan un bloque de código (cuerpo de función, if, else, etc.).

    XXI. fun main()
         └── Función especial: punto de entrada del programa.
         └── Kotlin ejecuta main() automáticamente al iniciar.

    XXII. println("...")
         └── Función que imprime texto en consola y añade salto de línea.

    XXIII. val
         └── Declara variable INMUTABLE (no se puede reasignar).
         └── Analogía: una placa grabada en piedra.

    XXIV. readLine()
         └── Lee una línea de texto escrita por el usuario en la consola.
         └── Devuelve String? (puede ser null).

    XXV. "${ ... }"
         └── Plantilla de cadena: evalúa la expresión y la convierte a texto.
         └── Analogía: un hueco en un texto donde insertas un valor calculado.

    XXVI. .toString()
         └── Convierte un valor a su representación como String.

    XXVII. ( ) (paréntesis)
         └── En funciones: agrupan argumentos. En expresiones: agrupan operaciones.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    OBJETO Dardos:
        FUNCION puntuar(x, y):
            primeraCoord = x
            segundaCoord = y
            distancia = RAIZ_CUADRADA(primeraCoord² + segundaCoord²)
            SI distancia <= 1:
                DEVOLVER 10
            SINO SI distancia <= 5:
                DEVOLVER 5
            SINO SI distancia <= 10:
                DEVOLVER 1
            SINO:
                DEVOLVER 0

    PROGRAMA PRINCIPAL:
        1. IMPRIMIR "Ingrese la coordenada x"
        2. LEER x
        3. IMPRIMIR "Ingrese la coordenada y"
        4. LEER y
        5. xNum = CONVERTIR_A_DECIMAL(x)
        6. yNum = CONVERTIR_A_DECIMAL(y)
        7. puntos = Dardos.puntuar(xNum, yNum)
        8. IMPRIMIR "La puntuación es " + puntos

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: (0, 0) — centro exacto del blanco

        Entrada: x = 0, y = 0
        Proceso:
            distancia = √(0² + 0²) = 0
            ¿0 <= 1? → SÍ → return 10
        Resultado: 10 puntos

    EJEMPLO 2: (3, 4) — círculo medio

        Entrada: x = 3, y = 4
        Proceso:
            distancia = √(3² + 4²) = √(9 + 16) = √25 = 5
            ¿5 <= 1? → NO
            ¿5 <= 5? → SÍ → return 5
        Resultado: 5 puntos
        └── (3, 4) está justo en el borde del círculo medio (radio 5).

    EJEMPLO 3: (8, 6) — círculo exterior

        Entrada: x = 8, y = 6
        Proceso:
            distancia = √(8² + 6²) = √(64 + 36) = √100 = 10
            ¿10 <= 1? → NO
            ¿10 <= 5? → NO
            ¿10 <= 10? → SÍ → return 1
        Resultado: 1 punto
        └── (8, 6) está en el borde del círculo exterior (radio 10).

    EJEMPLO 4: (10, 10) — fuera del blanco

        Entrada: x = 10, y = 10
        Proceso:
            distancia = √(10² + 10²) = √(100 + 100) = √200 ≈ 14.14
            ¿14.14 <= 1? → NO
            ¿14.14 <= 5? → NO
            ¿14.14 <= 10? → NO
            else → return 0
        Resultado: 0 puntos
*/
