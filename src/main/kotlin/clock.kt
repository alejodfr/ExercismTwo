@file:Suppress("SpellCheckingInspection")

/**
 *
 *Instructions
 *
 * Implement a clock that handles times without dates.
 *
 * You should be able to add and subtract minutes to it.
 *
 * Two clocks that represent the same time should be equal to each other.
 *
 *
 *
 */

class Clock(hour: Int, minute: Int) {

    private val totalMinutes = Math.floorMod(hour * 60 + minute, 24 * 60)

    private val normalizedHour = totalMinutes / 60
    private val normalizedMinute = totalMinutes % 60

    fun add(minutes: Int) = Clock(normalizedHour, normalizedMinute + minutes)

    fun subtract(minutes: Int) = Clock(normalizedHour, normalizedMinute - minutes)

    override fun toString() =
        "%02d:%02d".format(normalizedHour, normalizedMinute)

    override fun equals(other: Any?) =
        other is Clock &&
                normalizedHour == other.normalizedHour &&
                normalizedMinute == other.normalizedMinute

    override fun hashCode() =
        31 * normalizedHour + normalizedMinute
}

fun main() {
    val clock = Clock(10, 30)
    println(clock)                    // 10:30

    val added = clock.add(45)
    println(added)                    // 11:15

    val subtracted = clock.subtract(60)
    println(subtracted)               // 09:30

    // comparar dos relojes
    println(Clock(10, 30) == Clock(10, 30))  // true
    println(Clock(10, 30) == Clock(10, 31))  // false
}

/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                  GUÍA DE ESTUDIO: CLOCK EN KOTLIN                          ║
║        Explicación pedagógica para principiantes en programación           ║
╚══════════════════════════════════════════════════════════════════════════════╝

┌─────────────────────────────────────────────────────────────────────────────┐
│  EXPLICACIÓN LÍNEA POR LÍNIA (ANOTACIONES ESQUEMÁTICAS)                   │
└─────────────────────────────────────────────────────────────────────────────┘

  class Clock(hour: Int, minute: Int) {
  ┌─────┐  ┌───┐  ┌─────┐ ┌──┐  ┌───┐    ┌──────┐  ┌──┐
  │  1  │  │  2 │  │  3  │ │ 4│  │ 5 │    │  6   │  │7 │
  └─────┘  └───┘  └─────┘ └──┘  └───┘    └──────┘  └──┘
  │        │      │       │     │         │         │
  │        │      │       │     │         │         └── Parámetro del constructor
  │        │      │       │     │         └── Tipo de dato Int (entero)
  │        │      │       │     └── Segundo parámetro: "minute"
  │        │      │       └── Paréntesis de apertura de parámetros
  │        │      └── Nombre de la clase
  │        └── Palabra reservada "class" = "clase" (define un molde/plantilla)
  └── Sin modificador de visibilidad → es "public" por defecto

  ─────────────────────────────────────────────────────────────────────────────
  Significado: "Crea un molde llamado Clock que recibe dos números enteros
  (hour y minute) al construir un reloj."
  Analogía: Como una máquina de hacer relojes — le dices "hazme un reloj
  con hora 10 y minuto 30" y ella construye uno.
  ─────────────────────────────────────────────────────────────────────────────

      private val totalMinutes = Math.floorMod(hour * 60 + minute, 24 * 60)
      ┌───────┐ ┌───┐ ┌─────────────┐   ┌────┐ ┌────┐ ┌──┐ ┌──┐  ┌──┐  ┌────┐  ┌──┐  ┌────┐
      │   1   │ │ 2 │ │      3      │   │ 4  │ │ 5  │ │6 │ │7 │  │8 │  │ 9  │  │10│  │ 11 │
      └───────┘ └───┘ └─────────────┘   └────┘ └────┘ └──┘ └──┘  └──┘  └────┘  └──┘  └────┘
      │        │     │                  │     │     │   │    │    │      │      │     │
      │        │     │                  │     │     │   │    │    │      │      │     └── 24*60 = 1440 min/día
      │        │     │                  │     │     │   │    │    │      │      └── Minuendo del módulo
      │        │     │                  │     │     │   │    │    │      └── Operador + (suma)
      │        │     │                  │     │     │   │    │    └── 60 (minutos por hora)
      │        │     │                  │     │     │   │    └── Operador * (multiplicación)
      │        │     │                  │     │     │   └── Parámetro "hour" (hora)
      │        │     │                  │     │     └── Operador * (multiplicación)
      │        │     │                  │     └── Parámetro "minute" (minuto)
      │        │     │                  └── Llamada: Math.floorMod(dividendo, divisor)
      │        │     └── Nombre de la propiedad
      │        └── "val" = "valor" → declara una constante (no cambia)
      └── "private" = "privado" → solo accesible dentro de la clase

      ─────────────────────────────────────────────────────────────────────────
      Math.floorMod(a, b) → módulo con piso matemático.
      Siempre da resultado NO negativo (0..b-1).
      Ej: Math.floorMod(-5, 1440) = 1435  (en Java/Kotlin -5 % 1440 = -5)
      ─────────────────────────────────────────────────────────────────────────

      private val normalizedHour = totalMinutes / 60
      ┌───────┐ ┌───┐ ┌───────────────┐   ┌──────────────┐ ┌──┐ ┌──┐
      │   1   │ │ 2 │ │       3       │   │      4       │ │5 │ │6 │
      └───────┘ └───┘ └───────────────┘   └──────────────┘ └──┘ └──┘
      │        │     │                    │               │    │
      │        │     │                    │               │    └── 60 (minutos por hora)
      │        │     │                    │               └── Operador / (división entera)
      │        │     │                    └── Propiedad totalMinutes (arriba)
      │        │     └── Nombre de la propiedad: "hora normalizada" (0..23)
      │        └── "val" = valor constante
      └── "private" = privado

      ─────────────────────────────────────────────────────────────────────────
      Si totalMinutes = 150: 150 / 60 = 2 (división entera, trunca decimales)
      ─────────────────────────────────────────────────────────────────────────

      private val normalizedMinute = totalMinutes % 60
      ┌───────┐ ┌───┐ ┌─────────────────┐   ┌──────────────┐ ┌──┐ ┌──┐
      │   1   │ │ 2 │ │        3        │   │      4       │ │5 │ │6 │
      └───────┘ └───┘ └─────────────────┘   └──────────────┘ └──┘ └──┘
      │        │     │                      │               │    │
      │        │     │                      │               │    └── 60
      │        │     │                      │               └── Operador % (módulo/residuo)
      │        │     │                      └── totalMinutes
      │        │     └── "minuto normalizado" (0..59)
      │        └── "val"
      └── "private"

      ─────────────────────────────────────────────────────────────────────────
      Si totalMinutes = 150: 150 % 60 = 30 (el RESIDUO de dividir 150 ÷ 60)
      ─────────────────────────────────────────────────────────────────────────

      fun add(minutes: Int) = Clock(normalizedHour, normalizedMinute + minutes)
      ┌───┐ ┌───┐ ┌───────┐ ┌──┐ ┌───┐  ┌──┐  ┌─────┐ ┌───────────┐ ┌──┐ ┌──────────────────────────┐ ┌──┐
      │ 1 │ │ 2 │ │   3   │ │4 │ │ 5 │  │6 │  │  7  │ │     8     │ │9 │ │          10              │ │11│
      └───┘ └───┘ └───────┘ └──┘ └───┘  └──┘  └─────┘ └───────────┘ └──┘ └──────────────────────────┘ └──┘
      │    │    │         │    │    │     │     │       │             │    │                            │
      │    │    │         │    │    │     │     │       │             │    │                            └── Cierra paréntesis
      │    │    │         │    │    │     │     │       │             │    └── Llama al constructor Clock(...)
      │    │    │         │    │    │     │     │       │             └── Operador + suma minutos
      │    │    │         │    │    │     │     │       └── Parámetro minutes
      │    │    │         │    │    │     │     └── Propiedad normalizedMinute
      │    │    │         │    │    │     └── Propiedad normalizedHour
      │    │    │         │    │    └── "Int" = entero
      │    │    │         │    └── "minutes" = parámetro: minutos a añadir
      │    │    │         └── ":" = separador nombre/tipo
      │    │    └── Nombre de la función
      │    └── "fun" = "function" = "función" → define un bloque de código reusable
      └── Sin "private" → es público

      ─────────────────────────────────────────────────────────────────────────
      "=" expresión-cuerpo: la función DEVUELVE lo que está a la derecha del =
      ─────────────────────────────────────────────────────────────────────────

      fun subtract(minutes: Int) = Clock(normalizedHour, normalizedMinute - minutes)
      ┌───┐ ┌───────┐ ┌───┐ ┌──┐  ┌──┐  ┌─────┐ ┌─────────────────────┐ ┌──┐
      │ 1 │ │   2   │ │ 3 │ │4 │  │5 │  │  6  │ │         7           │ │8 │
      └───┘ └───────┘ └───┘ └──┘  └──┘  └─────┘ └─────────────────────┘ └──┘
      │    │         │    │    │    │     │       │                       │
      │    │         │    │    │    │     │       │                       └── ) cierra llamada
      │    │         │    │    │    │     │       └── Clock(normalizedHour, normalizedMinute - minutes)
      │    │         │    │    │    │     └── Nombre del constructor
      │    │         │    │    │    └── Operador = (cuerpo-expresión)
      │    │         │    │    └── ": Int" = tipo entero del parámetro
      │    │         │    └── Parámetro "minutes"
      │    │         └── Nombre de la función
      │    └── "fun" = función
      └── "private" no está → es público

      ─────────────────────────────────────────────────────────────────────────
      Diferencia con add: usa "-" en vez de "+" para restar minutos.
      ─────────────────────────────────────────────────────────────────────────

      override fun toString() =
      ┌────────┐ ┌───┐ ┌────────┐ ┌──┐ ┌──┐
      │   1    │ │ 2 │ │   3    │ │4 │ │5 │
      └────────┘ └───┘ └────────┘ └──┘ └──┘
      │         │    │         │    │
      │         │    │         │    └── = expresión-cuerpo (devuelve el String)
      │         │    │         └── "()" = sin parámetros
      │         │    └── "toString" = "to string" = "a texto"
      │         └── "fun" = función
      └── "override" = "sobrescribir" → reemplaza el toString heredado de Any

      ─────────────────────────────────────────────────────────────────────────
      En Kotlin toda clase hereda de "Any". Any tiene toString() que devuelve
      algo como "Clock@1a2b3c". Con override lo cambiamos por "10:30".
      ─────────────────────────────────────────────────────────────────────────

          "%02d:%02d".format(normalizedHour, normalizedMinute)
          ┌──────┐ ┌──┐ ┌──────┐ ┌───────────────┐ ┌───────────────────────┐
          │  1   │ │2 │ │  3   │ │       4        │ │          5            │
          └──────┘ └──┘ └──────┘ └───────────────┘ └───────────────────────┘
          │       │    │        │                  │
          │       │    │        │                  └── Argumentos: hora y minuto normalizados
          │       │    │        └── .format(...) → reemplaza %02d por los números
          │       │    └── ":" literal (separador hora:minuto)
          │       └── "%02d" patrón: "0" rellena con cero, "2" dos dígitos, "d" decimal
          └── Cadena de formato (String)

      ─────────────────────────────────────────────────────────────────────────
      "%02d:%02d" con hora=9, minuto=5 → "09:05"
      "%02d:%02d" con hora=23, minuto=59 → "23:59"
      ─────────────────────────────────────────────────────────────────────────

      override fun equals(other: Any?) =
      ┌────────┐ ┌───┐ ┌──────┐ ┌─────┐ ┌──┐ ┌──┐
      │   1    │ │ 2 │ │  3   │ │  4  │ │5 │ │6 │
      └────────┘ └───┘ └──────┘ └─────┘ └──┘ └──┘
      │         │    │       │      │    │    │
      │         │    │       │      │    │    └── = (cuerpo-expresión)
      │         │    │       │      │    └── ")" cierra parámetros
      │         │    │       │      └── Any? = "Any" (Object) + "?" (nullable = puede ser null)
      │         │    │       └── Parámetro "other" = el otro objeto a comparar
      │         │    └── "equals" = "igual a" → compara si dos objetos son iguales
      │         └── "fun"
      └── "override" = sobrescribir el equals de Any

      ─────────────────────────────────────────────────────────────────────────
      Sin override, Clock(10,30) == Clock(10,30) sería false porque compararía
      referencias de memoria, no el contenido. ¡Override arregla eso!
      ─────────────────────────────────────────────────────────────────────────

          other is Clock &&
          ┌─────┐ ┌──┐ ┌─────┐ ┌──┐
          │  1  │ │2 │ │  3  │ │4 │
          └─────┘ └──┘ └─────┘ └──┘
          │      │    │       │
          │      │    │       └── && = "and" = "y" (operador lógico Y)
          │      │    └── "Clock" = nombre de la clase
          │      └── "is" = "es" → pregunta: ¿other ES un Clock?
          └── Parámetro "other"

      ─────────────────────────────────────────────────────────────────────────
      "is" es como instanceof en Java. Si other no es Clock, devuelve false
      y ni siquiera evalúa lo que sigue (cortocircuito).
      ─────────────────────────────────────────────────────────────────────────

                  normalizedHour == other.normalizedHour &&
                  ┌──────────────┐ ┌──┐ ┌─────────────────┐ ┌──┐
                  │      1       │ │2 │ │        3         │ │4 │
                  └──────────────┘ └──┘ └─────────────────┘ └──┘
                  │               │   │                    │
                  │               │   │                    └── && (Y lógico)
                  │               │   └── other.normalizedHour (hora del otro reloj)
                  │               └── "==" = "igual a" (compara valores)
                  └── this.normalizedHour (hora de este reloj)
                  (this está implícito en Kotlin)

                  normalizedMinute == other.normalizedMinute
                  ┌────────────────┐ ┌──┐ ┌───────────────────┐
                  │       1        │ │2 │ │        3          │
                  └────────────────┘ └──┘ └───────────────────┘
                  │                 │   │
                  │                 │   └── other.normalizedMinute
                  │                 └── "==" compara valores
                  └── this.normalizedMinute

      ─────────────────────────────────────────────────────────────────────────
      Equals completo: dos Clock son iguales si:
      1. other es de tipo Clock (is)
      2. Y las horas normalizadas son iguales (==)
      3. Y los minutos normalizados son iguales (==)
      ─────────────────────────────────────────────────────────────────────────

      override fun hashCode() =
      ┌────────┐ ┌───┐ ┌────────┐ ┌──┐
      │   1    │ │ 2 │ │   3    │ │4 │
      └────────┘ └───┘ └────────┘ └──┘
      │         │    │         │
      │         │    │         └── = expresión-cuerpo
      │         │    └── "hashCode" = "código hash" → número identificador del objeto
      │         └── "fun"
      └── "override"

      ─────────────────────────────────────────────────────────────────────────
      Regla de oro en Kotlin/Java:
      SIEMBRA que sobrescribes equals, DEBES sobrescribir hashCode.
      Dos objetos iguales (equals=true) deben tener el MISMO hashCode.
      ─────────────────────────────────────────────────────────────────────────

          31 * normalizedHour + normalizedMinute
          ┌──┐ ┌──┐ ┌──────────────┐ ┌──┐ ┌────────────────┐
          │1 │ │2 │ │      3       │ │4 │ │       5        │
          └──┘ └──┘ └──────────────┘ └──┘ └────────────────┘
          │   │   │                │    │
          │   │   │                │    └── normalizedMinute
          │   │   │                └── "+" suma
          │   │   └── normalizedHour (hora normalizada 0..23)
          │   └── "*" multiplicación
          └── 31 (número primo — convención para hashCode)

      ─────────────────────────────────────────────────────────────────────────
      Si Clock(10, 30): hashCode = 31 * 10 + 30 = 310 + 30 = 340
      Si Clock(10, 31): hashCode = 31 * 10 + 31 = 310 + 31 = 341
      Son distintos → distintas → bien.
      ─────────────────────────────────────────────────────────────────────────

  }  ← LLAVE DE CIERRE de la clase Clock

  ┌─────────────────────────────────────────────────────────────────────────┐
  │  FUNCIÓN main (NO hace parte de la clase — es independiente)           │
  └─────────────────────────────────────────────────────────────────────────┘

  fun main() {
  ┌───┐ ┌────┐ ┌──┐ ┌──┐
  │ 1 │ │ 2  │ │3 │ │4 │
  └───┘ └────┘ └──┘ └──┘
  │    │      │    │
  │    │      │    └── "{" abre bloque de código
  │    │      └── "()" sin parámetros
  │    └── "main" = "principal" — punto de entrada del programa
  └── "fun" = función

      val clock = Clock(10, 30)
      ┌───┐ ┌─────┐ ┌──┐ ┌──────────────────┐
      │ 1 │ │  2  │ │3 │ │        4         │
      └───┘ └─────┘ └──┘ └──────────────────┘
      │    │       │    │
      │    │       │    └── Clock(10, 30) → llama al constructor, crea objeto
      │    │       └── "=" asigna el resultado a la variable
      │    └── "clock" = nombre de la variable
      └── "val" = "valor" → declara constante inmutable (no se reasigna)

      println(clock)                    // 10:30
      ┌───────┐ ┌─────┐ ┌─────────────┐
      │   1   │ │  2  │ │      3       │
      └───────┘ └─────┘ └─────────────┘
      │        │      │
      │        │      └── Paréntesis de cierre + comentario
      │        └── clock (pasa el objeto a println)
      └── println = "print line" = "imprimir línea" → llama a clock.toString() automáticamente

      val added = clock.add(45)
      ┌───┐ ┌─────┐ ┌──┐ ┌──────────────────────┐
      │ 1 │ │  2  │ │3 │ │         4             │
      └───┘ └─────┘ └──┘ └──────────────────────┘
      │    │       │    │
      │    │       │    └── clock.add(45) → llama a add(45), devuelve NUEVO Clock
      │    │       └── "=" asigna
      │    └── "added" = variable (nuevo Clock con 45 min más)
      └── "val"

      println(added)                    // 11:15

      val subtracted = clock.subtract(60)
      println(subtracted)               // 09:30

      println(Clock(10, 30) == Clock(10, 30))  // true
      ┌───────┐ ┌─────────────────────┐ ┌──┐ ┌─────────────────────┐ ┌────────┐
      │   1   │ │         2           │ │3 │ │         4           │ │   5    │
      └───────┘ └─────────────────────┘ └──┘ └─────────────────────┘ └────────┘
      │        │                       │    │                       │
      │        │                       │    │                       └── Comentario: resultado esperado
      │        │                       │    └── Clock(10, 30) → segundo reloj
      │        │                       └── "==" → llama a equals() internamente
      │        └── Clock(10, 30) → primer reloj
      └── println

      println(Clock(10, 30) == Clock(10, 31))  // false
  }

┌─────────────────────────────────────────────────────────────────────────────┐
│  TABLA DE PALABRAS RESERVADAS (KEYWORDS)                                   │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────┬──────────────────┬────────────────────────────────────────────┐
│  PALABRA    │ SIGNIFICADO      │ EXPLICACIÓN EN ESPAÑOL                    │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ class       │ clase            │ Define un molde o plantilla para crear     │
│             │                  │ objetos con propiedades y comportamientos. │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ private     │ privado          │ Solo se puede usar DENTRO de la clase.     │
│             │                  │ Nadie desde fuera puede acceder.           │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ val         │ valor            │ Declara una variable INMUTABLE (constante).│
│             │                  │ Una vez asignada, NO puede cambiar.        │
│             │                  │ Como una promesa: "esto siempre será así". │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ fun         │ función          │ Define un bloque de código reutilizable    │
│             │                  │ que hace una tarea específica.             │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ override    │ sobrescribir     │ Reemplaza un método heredado de la clase   │
│             │                  │ padre (Any) con una nueva implementación.  │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ Int         │ entero           │ Tipo de dato: número entero (sin decimal)  │
│             │                  │ Ej: 0, 42, -5, 1439.                      │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ Any?        │ cualquier (o     │ Tipo que acepta CUALQUIER objeto o null.  │
│             │ nulo)            │ El "?" significa "puede ser null".         │
├─────────────┼──────────────────┼────────────────────────────────────────────┤
│ is          │ es               │ Operador de tipo: pregunta si una variable │
│             │                  │ es de cierta clase. Como "instanceof" en   │
│             │                  │ Java.                                      │
└─────────────┴──────────────────┴────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────┐
│  TABLA DE OPERADORES IMPORTANTES                                           │
└─────────────────────────────────────────────────────────────────────────────┘

┌──────────┬──────────────────────┬──────────────────────────────────────────┐
│ OPERADOR │ SIGNIFICADO          │ EXPLICACIÓN EN ESPAÑOL                   │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│    *     │ multiplicación       │ Multiplica dos números.                  │
│          │                      │ hour * 60 → convierte horas a minutos.   │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│    +     │ suma                 │ Suma dos números.                        │
│          │                      │ hour*60 + minute → total de minutos.     │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│    /     │ división entera      │ Divide y TRUNCA los decimales.           │
│          │                      │ totalMinutes / 60 → cuántas horas caben. │
│          │                      │ 150 / 60 = 2 (NO 2.5)                   │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│    %     │ módulo (residuo)     │ Devuelve el RESTO de la división.        │
│          │                      │ totalMinutes % 60 → minutos sobrantes.  │
│          │                      │ 150 % 60 = 30 (lo que sobra tras 2h)    │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│    =     │ asignación           │ Asigna el valor de la derecha a la       │
│          │                      │ variable de la izquierda.                │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│   ==     │ igualdad             │ Compara si dos VALORES son iguales.      │
│          │                      │ En Kotlin, llama a equals() por detrás.  │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│   &&     │ AND (Y lógico)       │ Devuelve true SOLO si ambas condiciones  │
│          │                      │ son verdaderas.                          │
│          │                      │ true && true  = true                     │
│          │                      │ true && false = false                    │
├──────────┼──────────────────────┼──────────────────────────────────────────┤
│   ::     │ referencia a método  │ Usado en "%02d:%02d" — el "::" es parte  │
│          │                      │ del string, no un operador de código.    │
│          │                      │ Separa hora y minuto en el formato.      │
└──────────┴──────────────────────┴──────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────────────────┐
│  RESUMEN ALGORÍTMICO — PASO A PASO                                         │
└─────────────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ ALGORITMO: CONSTRUIR UN RELOJ (Clock)                             │
  └────────────────────────────────────────────────────────────────────┘

  ENTRADA:  hour (Int), minute (Int)  — ejemplo: hour = 25, minute = -30
  SALIDA:   Un objeto Clock con hora y minuto NORMALIZADOS (0..23, 0..59)

  ┌────────────────────────────────────────────────────────────────────┐
  │ PASO 1 — Convertir todo a minutos totales                         │
  │                                                                    │
  │   totalMinutos = hour * 60 + minute                                │
  │   totalMinutos = 25 * 60 + (-30)                                   │
  │   totalMinutos = 1500 - 30                                         │
  │   totalMinutos = 1470                                              │
  │                                                                    │
  │   ¿Qué significa? 25:30 son 1470 minutos desde la medianoche.     │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ PASO 2 — Ajustar al rango [0, 1440) con Math.floorMod             │
  │                                                                    │
  │   totalAjustado = Math.floorMod(totalMinutos, 1440)                │
  │   totalAjustado = Math.floorMod(1470, 1440)                        │
  │   totalAjustado = 1470   (porque 1470 está entre 0 y 1439)        │
  │                                                                    │
  │   OTRO EJEMPLO: Math.floorMod(-30, 1440)                          │
  │   = 1440 + (-30 % 1440) → pero floorMod da 1410 (¡correcto!)     │
  │   porque -30 minutos = 23:30 del día anterior = minuto 1410       │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ PASO 3 — Extraer hora normalizada                                 │
  │                                                                    │
  │   hora = totalAjustado / 60  (división entera)                    │
  │   hora = 1470 / 60                                                │
  │   hora = 24 (NO, porque 24*60 = 1440, 1470/60 = 24.5 → trunca a  │
  │           ¿espera?, 24*60=1440, restan 30 min... 1470/60=24.5 →  │
  │           en Kotlin división entera de Int: 1470/60 = 24)        │
  │                                                                    │
  │   CORRECCIÓN: ¡por eso usamos floorMod PRIMERO!                   │
  │   Con floorMod(1470, 1440) = 1470 todavía...                     │
  │   Pero 1470 / 60 = 24 → eso está MAL porque 24 no es hora válida │
  │   (0..23). ¿Qué pasa?                                             │
  │                                                                    │
  │   ¡Ah! 1470 NO es < 1440. floorMod(1470, 1440) = 30.             │
  │   Porque 1470 - 1440 = 30. ¡PISO MATEMÁTICO!                    │
  │   1470 / 1440 = 1.0208..., piso = 1                      │
  │   1470 - (1 * 1440) = 30. Correcto.                               │
  │                                                                    │
  │   Entonces: totalAjustado = 30                                    │
  │   hora = 30 / 60 = 0                                              │
  │   minuto = 30 % 60 = 30                                           │
  │   Resultado: 00:30 ✔                                              │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ EJEMPLO COMPLETO 1: Clock(25, -30)                                │
  │                                                                    │
  │   1. totalMinutos = 25 * 60 + (-30) = 1470                        │
  │   2. totalAjustado = floorMod(1470, 1440) = 30                    │
  │   3. hora = 30 / 60 = 0                                           │
  │   4. minuto = 30 % 60 = 30                                        │
  │   5. toString() → "00:30"                                         │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ EJEMPLO COMPLETO 2: Clock(0, -5)                                   │
  │                                                                    │
  │   1. totalMinutos = 0 * 60 - 5 = -5                               │
  │   2. totalAjustado = floorMod(-5, 1440) = 1435                    │
  │       (porque -5 + 1440 = 1435)                                    │
  │   3. hora = 1435 / 60 = 23                                         │
  │   4. minuto = 1435 % 60 = 55                                       │
  │   5. toString() → "23:55"                                          │
  │                                                                    │
  │   Sentido común: 5 min antes de 00:00 es 23:55 del día anterior.  │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ EJEMPLO COMPLETO 3: Clock(10, 30).add(45)                         │
  │                                                                    │
  │   1. add(45) crea un NUEVO Clock: Clock(10, 30 + 45)              │
  │   2. internamente: Clock(10, 75)                                   │
  │   3. totalMinutos = 10 * 60 + 75 = 675                            │
  │   4. totalAjustado = floorMod(675, 1440) = 675                    │
  │   5. hora = 675 / 60 = 11                                          │
  │   6. minuto = 675 % 60 = 15                                        │
  │   7. Resultado: "11:15" ✔                                          │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ EJEMPLO COMPLETO 4: Clock(10, 30).subtract(60)                    │
  │                                                                    │
  │   1. subtract(60) crea Clock(10, 30 - 60) = Clock(10, -30)        │
  │   2. totalMinutos = 10 * 60 + (-30) = 570                         │
  │   3. totalAjustado = floorMod(570, 1440) = 570                    │
  │   4. hora = 570 / 60 = 9                                           │
  │   5. minuto = 570 % 60 = 30                                        │
  │   6. "09:30" ✔                                                     │
  └────────────────────────────────────────────────────────────────────┘

  ┌────────────────────────────────────────────────────────────────────┐
  │ PSEUDOCÓDIGO                                                       │
  └────────────────────────────────────────────────────────────────────┘

    CLASE Clock
        ENTRADA: hora (entero), minuto (entero)

        PASO 1: totalMinutos = hora * 60 + minuto
        PASO 2: totalAjustado = floorMod(totalMinutos, 1440)
                └── Ajusta al rango [0, 1439] (minutos de un día)

        PASO 3: horaNormalizada = totalAjustado / 60
                └── Divide para obtener la hora (0-23)

        PASO 4: minutoNormalizado = totalAjustado % 60
                └── Residuo para obtener el minuto (0-59)

        FUNCIÓN add(minutos):
            DEVOLVER Clock(horaNormalizada, minutoNormalizado + minutos)
            └── Crea NUEVO reloj sumando minutos

        FUNCIÓN subtract(minutos):
            DEVOLVER Clock(horaNormalizada, minutoNormalizado - minutos)
            └── Crea NUEVO reloj restando minutos

        FUNCIÓN toString:
            DEVOLVER "horaNormalizada:minutoNormalizado" en formato 2 dígitos
            └── "%02d:%02d" → "09:05"

        FUNCIÓN equals(otro):
            SI otro ES Clock Y
               horaNormalizada == otro.horaNormalizada Y
               minutoNormalizado == otro.minutoNormalizado:
                DEVOLVER true
            SINO:
                DEVOLVER false

        FUNCIÓN hashCode:
            DEVOLVER 31 * horaNormalizada + minutoNormalizado

  ┌────────────────────────────────────────────────────────────────────┐
  │ ¿POR QUÉ ES INMUTABLE?                                             │
  └────────────────────────────────────────────────────────────────────┘

  Clock usa SOLO "val" (constantes). add() y subtract() NO modifican el
  reloj original — CREAN uno nuevo. Esto se llama INMUTABILIDAD.

    clock = Clock(10, 30)
    clock.add(45)   → clock sigue siendo 10:30
    added = clock.add(45)  → added es un Clock NUEVO con 11:15

  Ventaja: evitar errores. Nadie puede modificar tu reloj sin que tú
  crees explícitamente uno nuevo.
*/

