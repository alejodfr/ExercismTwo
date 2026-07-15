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
 */
class Clock(private val hours: Int = 0, private val minutes: Int = 0) {
    private var h: Int = 0
    private var m: Int = 0

    init {
        normalize(hours, minutes)
    }

    private fun normalize(hours: Int, minutes: Int) {
        this.h = ((hours + minutes / 60) % 24)
            .let { if (minutes % 60 < 0) it - 1 else it }
            .let { if (it < 0) it + 24 else it }
        this.m = (minutes % 60)
            .let { if (it < 0) it + 60 else it }
    }

    @Override
    override fun equals(other: Any?): Boolean = other is Clock && h == other.h && m == other.m

    private fun Int.padZeroChars() = toString().padStart(length = 2, padChar = '0')

    override fun toString() = "${h.padZeroChars()}:${m.padZeroChars()}"

    fun subtract(minutes: Int) {
        m -= minutes
        normalize(h, m)
    }

    fun add(minutes: Int) {
        m += minutes
        normalize(h, m)
    }
}

/*
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Se pide implementar una clase Clock que maneje tiempos sin fechas.

    OBJETIVOS:
    I.   Crear un reloj que acepte hora (hours) y minuto (minutes) como enteros.
    II.  Normalizar la hora para que siempre esté en rango 00:00 - 23:59,
         incluso si los valores de entrada son negativos o exceden 24h.
    III. Poder SUMAR minutos (add) — modifica el reloj actual.
    IV.  Poder RESTAR minutos (subtract) — modifica el reloj actual.
    V.   Mostrar la hora en formato "HH:MM" con dos dígitos (toString).
    VI.  Comparar dos relojes: que sean iguales si tienen la misma hora (equals).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    Para resolver el problema se siguen estas etapas:

    I. DISENO DE LA CLASE
       └── Crear una clase Clock con propiedades hours y minutes (con valores
           por defecto 0) y campos mutables internos h y m.

    II. NORMALIZACION DE LA HORA (función normalize)
        a) Calcular la hora base: (hours + minutes / 60) % 24
           └── Esto da la hora ajustada por los minutos excedentes.
        b) Si minutes % 60 < 0 (minutos negativos), restar 1 a la hora.
           └── Se hace con .let { if (minutes % 60 < 0) it - 1 else it }
        c) Si la hora es negativa, sumar 24 para llevarla a [0, 23].
           └── Se hace con .let { if (it < 0) it + 24 else it }
        d) Calcular el minuto: minutes % 60
        e) Si el minuto es negativo, sumar 60 para llevarlo a [0, 59].
           └── .let { if (it < 0) it + 60 else it }

    III. OPERACIONES DE SUMAR/RESTAR
         └── add(minutes) suma al campo m, luego re-normaliza.
         └── subtract(minutes) resta del campo m, luego re-normaliza.
         └── AMBAS modifican el reloj actual (mutable).

    IV. REPRESENTACION EN TEXTO
        └── toString: "${h.padZeroChars()}:${m.padZeroChars()}"
        └── padZeroChars() extiende Int para formatear con 2 dígitos
            usando padStart(length = 2, padChar = '0').

    V. COMPARACION DE IGUALDAD
       └── equals: verificar que el otro objeto es Clock y que h y m coinciden.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ class Clock(private val hours: Int = 0, private val minutes: Int = 0) { │
    │     private var h: Int = 0                                              │
    │     private var m: Int = 0                                              │
    │     init { normalize(hours, minutes) }                                  │
    │     private fun normalize(hours: Int, minutes: Int) {                   │
    │         this.h = ((hours + minutes / 60) % 24)                          │
    │             .let { if (minutes % 60 < 0) it - 1 else it }               │
    │             .let { if (it < 0) it + 24 else it }                        │
    │         this.m = (minutes % 60)                                         │
    │             .let { if (it < 0) it + 60 else it }                        │
    │     }                                                                    │
    │     override fun equals(other: Any?) =                                   │
    │         other is Clock && h == other.h && m == other.m                  │
    │     private fun Int.padZeroChars() =                                     │
    │         toString().padStart(length = 2, padChar = '0')                  │
    │     override fun toString() = "${h.padZeroChars()}:${m.padZeroChars()}" │
    │     fun subtract(minutes: Int) { m -= minutes; normalize(h, m) }        │
    │     fun add(minutes: Int) { m += minutes; normalize(h, m) }             │
    │ }                                                                        │
    └──────────────────────────────────────────────────────────────────────────┘

    EXPLICACION DE CADA ELEMENTO (numeración en romanos):

    I.   class
         └── Palabra reservada que define una "clase" (molde/plantilla).
         └── En español: "clase". Crea un tipo de objeto con propiedades y métodos.
         └── Analogía: como un molde para hacer galletas; defines la forma una vez
             y puedes crear muchas galletas (objetos) con esa forma.

    II.  Clock
         └── Nombre de la clase. Por convención en Kotlin, comienza con mayúscula.
         └── Identificador elegido por el programador para nombrar el concepto "reloj".

    III. (private val hours: Int = 0, private val minutes: Int = 0)
         └── Parámetros del constructor primario con valores por defecto 0.
         └── private val: los almacena como propiedades inmutables y privadas.
         └── hours: parámetro de tipo Int para la hora.
         └── minutes: parámetro de tipo Int para el minuto.
         └── ": Int" indica que el tipo de dato es "integer" (número entero).
         └── "= 0" es el valor por defecto: si no se pasa argumento, se usa 0.

    IV.  private var h: Int = 0 / private var m: Int = 0
         └── private: solo accesible dentro de la clase.
         └── var: variable MUTABLE (puede cambiar de valor).
         └── h: almacena la hora normalizada (0-23).
         └── m: almacena el minuto normalizado (0-59).
         └── Se inicializan en 0 y luego el init block las ajusta.

    V.   init { ... }
         └── Bloque de inicialización: se ejecuta inmediatamente después del
             constructor primario.
         └── Aquí llama a normalize(hours, minutes) para calcular h y m.

    VI.  private fun normalize(hours: Int, minutes: Int)
         └── Función privada que normaliza los valores de hora y minuto.
         └── Recibe los parámetros hours y minutes del constructor.
         └── No devuelve nada (Unit): modifica directamente this.h y this.m.

    VII. this.h = ((hours + minutes / 60) % 24)
         └── this.h: asigna al campo h del objeto actual.
         └── hours + minutes / 60: suma la hora base más las horas contenidas
             en los minutos (división entera).
         └── % 24: mantiene la hora en rango 0-23 (módulo 24).

    VIII. .let { if (minutes % 60 < 0) it - 1 else it }
         └── .let { ... }: función de alcance de Kotlin. Toma el valor anterior
             como parámetro it y ejecuta el bloque, devolviendo el resultado.
         └── Si el residuo de minutes entre 60 es negativo, significa que la
             división entera (minutes / 60) redondeó hacia arriba y debemos
             restar 1 a la hora para compensar.
         └── Ej: minutes = -70 → -70/60 = -1 (trunca a -1), -70%60 = -10.
             hours + (-1) da la hora incorrecta; con el ajuste resta 1 más.

    IX.  .let { if (it < 0) it + 24 else it }
         └── Si la hora resultante es negativa, suma 24 para llevarla al rango
             0-23.
         └── Ej: hours=0, minutes=-5 → (0 + (-5/60)) % 24 = (0-1)%24 = -1
             → it + 24 = 23. Correcto: 5 min antes de medianoche = 23:55.

    X.   this.m = (minutes % 60).let { if (it < 0) it + 60 else it }
         └── minutes % 60: obtiene el residuo de minutes entre 60 (−59 a 59).
         └── Si el residuo es negativo, suma 60 para que quede en [0, 59].
         └── Ej: minutes = -5 → -5 % 60 = -5 → -5 + 60 = 55.

    XI.  override fun equals(other: Any?) = other is Clock && h == other.h && m == other.m
         └── override: sobrescribe el método equals heredado de Any.
         └── other is Clock: verifica que other sea de tipo Clock.
         └── h == other.h && m == other.m: compara hora y minuto.
         └── Si todo coincide, los relojes son iguales.

    XII. private fun Int.padZeroChars()
         └── Función de extensión sobre el tipo Int.
         └── private: solo visible dentro de Clock.
         └── toString(): convierte el entero a string ("5" → "5").
         └── padStart(length = 2, padChar = '0'): si el string tiene menos
             de 2 caracteres, rellena a la izquierda con '0' ("5" → "05").

    XIII. override fun toString() = "${h.padZeroChars()}:${m.padZeroChars()}"
         └── "${...}": string con template (interpolación de variables).
         └── Llama a padZeroChars() en h y m para formatear con 2 dígitos.
         └── ":" es el separador literal entre hora y minuto.
         └── Ej: h=9, m=5 → "09:05".

    XIV. fun subtract(minutes: Int) { m -= minutes; normalize(h, m) }
         └── m -= minutes: resta los minutos directamente al campo m.
         └── normalize(h, m): re-normaliza h y m para corregir posibles
             desbordamientos (negativos o ≥ 60).
         └── MODIFICA el reloj actual (no devuelve uno nuevo).

    XV.  fun add(minutes: Int) { m += minutes; normalize(h, m) }
         └── m += minutes: suma los minutos al campo m.
         └── normalize(h, m): re-normaliza.
         └── MODIFICA el reloj actual.

    XVI. Uso de var en h y m
         └── var = variable mutable (puede reasignarse).
         └── Se necesita porque add/subtract modifican el estado interno.
         └── Contrasta con val (inmutable) que no puede reasignarse.

    XVII. Uso de private val en el constructor
          └── Los parámetros del constructor se declaran como private val
              para almacenarlos como propiedades privadas e inmutables.
          └── Solo se usan en init para la primera normalización.

    XVIII. Ausencia de hashCode
           └── El código no implementa hashCode.
           └── Esto es INCORRECTO si los objetos se usan en HashSet/HashMap.
           └── Para equals personalizado, siempre debe implementarse hashCode.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE Reloj
        ENTRADA: horas (entero, default 0), minutos (entero, default 0)

        CAMPOS privados mutables:
            h: entero = 0   ← almacena la hora normalizada
            m: entero = 0   ← almacena el minuto normalizado

        INICIALIZACION:
            LLAMAR normalizar(horas, minutos)

        FUNCION normalizar(horas, minutos):
            h = (horas + (minutos / 60)) % 24
            SI (minutos % 60) < 0:
                h = h - 1
            SI h < 0:
                h = h + 24
            m = minutos % 60
            SI m < 0:
                m = m + 60

        FUNCION esIgual(otro):
            DEVOLVER otro ES Reloj Y h == otro.h Y m == otro.m

        FUNCION aTexto():
            DEVOLVER h.conCeros(2) + ":" + m.conCeros(2)

        FUNCION sumar(minutos):
            m = m + minutos
            normalizar(h, m)

        FUNCION restar(minutos):
            m = m - minutos
            normalizar(h, m)

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    NOTA: add() y subtract() MODIFICAN el reloj actual. Estos ejemplos
          muestran cómo quedan los campos internos después de cada operación.

    EJEMPLO 1: Clock(25, -30)  — valores fuera de rango

        Entrada:  hours = 25, minutes = -30
        Proceso en normalize:
          minutos / 60 = -30 / 60 = 0        (división entera, trunca a 0)
          hours + (minutes / 60) = 25 + 0 = 25
          (25) % 24 = 1                         → h = 1
          minutes % 60 = -30 % 60 = -30         → -30 < 0 → h = 1 - 1 = 0
          minutes % 60 = -30                    → -30 < 0 → m = -30 + 60 = 30
        Resultado: h=0, m=30 → toString = "00:30"
        └── 25:30 - 30 min = medianoche + 30 min = 00:30. Correcto.

    EJEMPLO 2: Clock(0, -5)  — minutos negativos

        Entrada:  hours = 0, minutes = -5
        Proceso en normalize:
          minutes / 60 = -5 / 60 = 0
          (0 + 0) % 24 = 0                     → h = 0
          minutes % 60 = -5 % 60 = -5          → -5 < 0 → h = 0 - 1 = -1
          h = -1 < 0                           → h = -1 + 24 = 23
          m = -5                               → -5 < 0 → m = -5 + 60 = 55
        Resultado: h=23, m=55 → toString = "23:55"
        └── 5 minutos antes de la medianoche = 23:55 del día anterior. Correcto.

    EJEMPLO 3: Clock(10, 30).add(45)  — suma que cruza la hora

        Entrada:  reloj con h=10, m=30. add(45)
        Proceso:
          m = 30 + 45 = 75
          normalize(10, 75):
            minutes / 60 = 75 / 60 = 1
            (10 + 1) % 24 = 11                → h = 11
            minutes % 60 = 75 % 60 = 15        → 15 ≥ 0, sin ajuste de hora
            m = 15                             → 15 ≥ 0, sin ajuste de minutos
        Resultado: h=11, m=15 → toString = "11:15"
        └── 10:30 + 45 min = 11:15. Correcto.

    EJEMPLO 4: Clock(10, 30).subtract(90)  — resta que cambia de hora

        Entrada:  reloj con h=10, m=30. subtract(90)
        Proceso:
          m = 30 - 90 = -60
          normalize(10, -60):
            minutes / 60 = -60 / 60 = -1
            (10 + (-1)) % 24 = 9              → h = 9
            minutes % 60 = -60 % 60 = 0        → 0, no hay ajuste de hora
            m = 0                              → 0 ≥ 0, sin ajuste
        Resultado: h=9, m=0 → toString = "09:00"
        └── 10:30 - 90 min = 09:00. Correcto.

    DIFERENCIA CLAVE con la versión inmutable:
          En este código, add() y subtract() MODIFICAN el objeto actual.
          clock.add(45) cambiará clock permanentemente, no devuelve uno nuevo.
          Para mantener el original, habría que crear una copia antes de operar.
*/
