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
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. INSTRUCCIONES                                                            │
└─────────────────────────────────────────────────────────────────────────────┘

    Se pide implementar una clase Clock que maneje tiempos sin fechas.

    OBJETIVOS:
    I.   Crear un reloj que acepte hora (hour) y minuto (minute) como enteros.
    II.  Normalizar la hora para que siempre esté en rango 00:00 - 23:59,
         incluso si los valores de entrada son negativos o exceden 24h.
    III. Poder SUMAR minutos (add) — devuelve un NUEVO reloj, no modifica el original.
    IV.  Poder RESTAR minutos (subtract) — devuelve un NUEVO reloj.
    V.   Mostrar la hora en formato "HH:MM" con dos dígitos (toString).
    VI.  Comparar dos relojes: que sean iguales si tienen la misma hora (equals / hashCode).

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 2. ORDEN DE PENSAMIENTO                                                     │
└─────────────────────────────────────────────────────────────────────────────┘

    Para resolver el problema se siguen estas etapas:

    I. DISENO DE LA CLASE
       └── Crear una clase Clock con un constructor que reciba hour: Int y minute: Int.

    II. NORMALIZACION DE LA HORA
        a) Convertir todo a minutos totales:  hour * 60 + minute
        b) Ajustar al rango [0, 1440) usando Math.floorMod(..., 24 * 60)
           (1440 = total de minutos en un día).
        c) Extraer la hora: totalAjustado / 60   (división entera → 0-23)
        d) Extraer el minuto: totalAjustado % 60 (residuo → 0-59)

    III. OPERACIONES DE SUMAR/RESTAR
         └── add(minutes) crea un Clock(horaNormalizada, minutoNormalizado + minutes)
         └── subtract(minutes) crea un Clock(horaNormalizada, minutoNormalizado - minutes)
         └── El constructor se encarga de normalizar automáticamente.

    IV. REPRESENTACION EN TEXTO
        └── toString: "%02d:%02d".format(hora, minuto)
        └── %02d = rellenar con ceros a 2 dígitos.

    V. COMPARACION DE IGUALDAD
       └── equals: verificar que el otro objeto es Clock y que ambas propiedades coinciden.
       └── hashCode: 31 * hora + minuto (consistente con equals).

    VI. PRUEBAS (main)
        └── Crear un reloj, sumar, restar, comparar, e imprimir resultados.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 3. SINTAXIS DEL CODIGO                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    CODIGO FUENTE COMPLETO:

    ┌──────────────────────────────────────────────────────────────────────────┐
    │ class Clock(hour: Int, minute: Int) {                                   │
    │     private val totalMinutes = Math.floorMod(hour * 60 + minute, 24*60) │
    │     private val normalizedHour = totalMinutes / 60                      │
    │     private val normalizedMinute = totalMinutes % 60                    │
    │     fun add(minutes: Int) = Clock(normalizedHour, normalizedMinute + minutes)
    │     fun subtract(minutes: Int) = Clock(normalizedHour, normalizedMinute - minutes)
    │     override fun toString() = "%02d:%02d".format(normalizedHour, normalizedMinute)
    │     override fun equals(other: Any?) =                                   │
    │         other is Clock &&                                                │
    │         normalizedHour == other.normalizedHour &&                        │
    │         normalizedMinute == other.normalizedMinute                      │
    │     override fun hashCode() = 31 * normalizedHour + normalizedMinute    │
    │ }                                                                        │
    │ fun main() {                                                             │
    │     val clock = Clock(10, 30)                                            │
    │     println(clock)                                                       │
    │     val added = clock.add(45)                                            │
    │     println(added)                                                       │
    │     val subtracted = clock.subtract(60)                                  │
    │     println(subtracted)                                                  │
    │     println(Clock(10, 30) == Clock(10, 30))                              │
    │     println(Clock(10, 30) == Clock(10, 31))                              │
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

    III. (hour: Int, minute: Int)
         └── Parámetros del constructor primario.
         └── hour: parámetro de tipo Int (entero) que recibe la hora.
         └── minute: parámetro de tipo Int que recibe el minuto.
         └── ": Int" indica que el tipo de dato es "integer" (número entero).
         └── Analogía: son los datos que le das a la máquina para que sepa qué hora poner.

    IV.  private
         └── Modificador de visibilidad: "privado".
         └── Lo que está marcado como private solo puede usarse DENTRO de la clase.
         └── Analogía: el motor interno de un reloj — nadie desde fuera puede tocarlo.

    V.   val
         └── Palabra reservada que declara una variable INMUTABLE (constante).
         └── Viene de "value" (valor). Una vez asignada, no puede cambiar.
         └── Analogía: una promesa escrita en piedra — "esto siempre será así".

    VI.  totalMinutes
         └── Nombre de propiedad: "minutos totales".
         └── Almacena la cantidad total de minutos desde medianoche, normalizados.

    VII. Math.floorMod(a, b)
         └── Función matemática de la biblioteca de Kotlin/Java.
         └── Calcula el módulo con "piso matemático" (resultado siempre ≥ 0).
         └── Sirve para envolver valores negativos al rango correcto.
         └── Ej: floorMod(-5, 1440) = 1435 (en vez de -5 que daría % normal).

    VIII. hour * 60 + minute
         └── Fórmula para convertir horas y minutos a minutos totales.
         └── *  : operador multiplicación (convierte horas a minutos).
         └── +  : operador suma (combina horas y minutos).

    IX.  24 * 60
         └── 1440: total de minutos en un día (24 horas × 60 minutos).
         └── Sirve como "tope" del módulo para normalizar.

    X.   normalizedHour / normalizedMinute
         └── Propiedades calculadas: hora y minuto ya normalizados (0-23 y 0-59).
         └── "/" : división entera (trunca decimales). extrae la hora de totalMinutes.
         └── "%" : módulo/residuo. extrae el minuto restante.

    XI.  fun
         └── Palabra reservada "function" (función).
         └── Define un bloque de código reutilizable que hace una tarea.
         └── Analogía: una receta de cocina — describes los pasos una vez y los ejecutas
             cada vez que necesitas ese plato.

    XII. add / subtract
         └── Nombres de funciones: "sumar" y "restar".
         └── minutes: Int — parámetro que recibe la cantidad de minutos a sumar/restar.

    XIII. = (en fun add / subtract)
         └── "cuerpo-expresión": la función devuelve DIRECTAMENTE lo que está a la derecha.
         └── No necesita usar "return" ni llaves { }.

    XIV. Clock(normalizedHour, normalizedMinute ± minutes)
         └── Llama al CONSTRUCTOR de Clock para crear un NUEVO objeto.
         └── Esto hace que el reloj sea INMUTABLE: no modifica el original.

    XV.  override
         └── Palabra reservada: "sobrescribir" o "sobreescribir".
         └── Reemplaza un método que viene heredado de la clase padre (Any).
         └── Analogía: tu teléfono viene con un tono de llamada genérico (Any.toString),
             pero tú lo cambias por tu canción favorita (override).

    XVI. toString
         └── Método que devuelve una representación en texto del objeto.
         └── Viene de "to string" = "convertir a cadena de texto".

    XVII. "%02d:%02d".format(...)
         └── Cadena de formato: "%" indica marcador de posición.
         └── "0" rellena con cero a la izquierda si es necesario.
         └── "2" ancho de dos dígitos. "d" = decimal (número entero).
         └── ":" es el separador literal entre hora y minuto.
         └── .format(hora, minuto) reemplaza los %02d con los valores.

    XVIII. equals
          └── Método que compara si dos objetos son iguales en VALOR (no en referencia).
          └── other: Any? — recibe cualquier tipo de objeto (o null).
          └── "?" significa "nullable" (puede ser nulo).

    XIX. is
         └── Operador de tipo: pregunta "¿este objeto ES de esta clase?".
         └── other is Clock → "¿other es un reloj?"
         └── Equivalente a instanceof en otros lenguajes.

    XX.  &&  (AND lógico)
         └── Operador "Y": ambas condiciones deben ser verdaderas.
         └── En español: "y además".
         └── true && true = true; cualquier otra combinación = false.

    XXI. ==
         └── Operador de igualdad estructural (compara valores, no referencias).
         └── En Kotlin, internamente llama al método equals().

    XXII. hashCode
          └── Método que devuelve un número entero que identifica al objeto.
          └── Sirve para usar objetos en estructuras como HashSet o HashMap.
          └── Regla: si dos objetos son equals, deben tener el MISMO hashCode.

    XXIII. 31 * normalizedHour + normalizedMinute
          └── Fórmula típica para hashCode.
          └── 31 es un número primo (reduce colisiones).
          └── Combina hora y minuto en un único entero.

    XXIV. main
          └── Función especial: punto de entrada del programa.
          └── Cuando se ejecuta el programa, Kotlin busca y ejecuta main().
          └── Analogía: la puerta principal de una casa — todo empieza ahí.

    XXV. println(...)
         └── Función de la biblioteca estándar: "print line".
         └── Imprime texto en la consola y añade un salto de línea.
         └── Automáticamente llama a toString() del objeto que recibe.

    XXVI. val clock / val added / val subtracted
          └── Declaración de variables INMUTABLES con "val".
          └── clock = Clock(10,30) — crea un reloj con hora 10:30.
          └── added = clock.add(45) — crea un NUEVO reloj sumando 45 min.
          └── subtracted = clock.subtract(60) — crea un NUEVO reloj restando 60 min.

    XXVII. // comentario
          └── Línea que comienza con "//" es un comentario de una línea.
          └── El compilador ignora los comentarios; son solo para humanos.
          └── Muestran el resultado esperado de cada println.

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 4. PSEUDOCODIGO                                                             │
└─────────────────────────────────────────────────────────────────────────────┘

    CLASE Reloj
        ENTRADA: hora (entero), minuto (entero)

        PROPIEDAD privada: totalMinutos
            totalMinutos = floorMod(hora * 60 + minuto, 1440)
            └── Convierte hora y minuto a minutos totales y los ajusta al rango [0, 1439]

        PROPIEDAD privada: horaNormalizada
            horaNormalizada = totalMinutos / 60
            └── Extrae la hora (0-23) mediante división entera

        PROPIEDAD privada: minutoNormalizado
            minutoNormalizado = totalMinutos % 60
            └── Extrae el minuto (0-59) mediante el residuo

        FUNCION sumar(minutos):
            DEVOLVER nuevo Reloj(horaNormalizada, minutoNormalizado + minutos)
            └── Crea un nuevo reloj con los minutos añadidos (el constructor normaliza)

        FUNCION restar(minutos):
            DEVOLVER nuevo Reloj(horaNormalizada, minutoNormalizado - minutos)
            └── Crea un nuevo reloj con los minutos restados

        FUNCION aTexto():
            DEVOLVER formatear(horaNormalizada, "2 dígitos") + ":" + formatear(minutoNormalizado, "2 dígitos")
            └── Ej: "09:05"

        FUNCION esIgual(otro):
            SI otro ES Reloj Y
               horaNormalizada == otro.horaNormalizada Y
               minutoNormalizado == otro.minutoNormalizado:
                DEVOLVER verdadero
            SINO:
                DEVOLVER falso

        FUNCION codigoHash():
            DEVOLVER 31 * horaNormalizada + minutoNormalizado

    ───────────────────────────────────────────────────────────────────────────

    PROGRAMA PRINCIPAL:
        1. reloj = nuevo Reloj(10, 30)
        2. imprimir(reloj)                    → "10:30"
        3. sumado = reloj.sumar(45)
        4. imprimir(sumado)                   → "11:15"
        5. restado = reloj.restar(60)
        6. imprimir(restado)                  → "09:30"
        7. imprimir(Reloj(10,30) == Reloj(10,30))  → verdadero
        8. imprimir(Reloj(10,30) == Reloj(10,31))  → falso

──────────────────────────────────────────────────────────────────────────────

┌─────────────────────────────────────────────────────────────────────────────┐
│ 5. EJEMPLOS TRABAJADOS                                                      │
└─────────────────────────────────────────────────────────────────────────────┘

    EJEMPLO 1: Clock(25, -30)  — valores fuera de rango

        Entrada:  hora = 25, minuto = -30
        Proceso:
          totalMinutos = 25 * 60 + (-30) = 1470
          ajustado     = floorMod(1470, 1440) = 30    ← 1470 - 1440 = 30
          horaNorm     = 30 / 60 = 0
          minNorm      = 30 % 60 = 30
        Resultado: "00:30"
        └── 25:30 - 30 min = medianoche + 30 min = 00:30. Correcto.

    EJEMPLO 2: Clock(0, -5)  — minutos negativos

        Entrada:  hora = 0, minuto = -5
        Proceso:
          totalMinutos = 0 * 60 + (-5) = -5
          ajustado     = floorMod(-5, 1440) = 1435    ← -5 + 1440 = 1435
          horaNorm     = 1435 / 60 = 23
          minNorm      = 1435 % 60 = 55
        Resultado: "23:55"
        └── 5 minutos antes de la medianoche son las 23:55 del día anterior. Correcto.

    EJEMPLO 3: Clock(10, 30).add(45)  — suma que cruza la hora

        Entrada:  reloj base = 10:30, sumar 45 minutos
        Proceso:
          add(45) crea Clock(10, 30 + 45) = Clock(10, 75)
          El constructor normaliza:
          totalMinutos = 10 * 60 + 75 = 675
          ajustado     = floorMod(675, 1440) = 675   ← ya está en rango
          horaNorm     = 675 / 60 = 11
          minNorm      = 675 % 60 = 15
        Resultado: "11:15"
        └── 10:30 + 45 min = 11:15. Correcto.

    NOTA: En todos los casos, add() y subtract() NO modifican el reloj original.
          clock sigue siendo 10:30 después de las operaciones.
*/