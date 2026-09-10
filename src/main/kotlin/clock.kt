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
// ▶ class Clock(private val hours: Int = 0, private val minutes: Int = 0) {
//   └▶ ① parámetros del constructor con valor por defecto 0; private → no
//           son accesibles desde fuera de la clase.
class Clock(private val hours: Int = 0, private val minutes: Int = 0) {
    // ▶ private var h: Int = 0
    // ▶ private var m: Int = 0
    //   └▶ ② campos mutables internos: la hora y el minuto ya normalizados.
    private var h: Int = 0
    private var m: Int = 0

    // ▶ init { normalize(hours, minutes) }
    //   └▶ ③ al construir el objeto se normalizan los valores recibidos.
    init {
        normalize(hours, minutes)
    }

    // ▶ private fun normalize(hours: Int, minutes: Int) {
    //   └▶ ④ lleva cualquier par (horas, minutos) al rango 00:00–23:59.
    private fun normalize(hours: Int, minutes: Int) {
        // ▶ this.h = ((hours + minutes / 60) % 24)
        //   ├▶ ⑤ hours + minutes/60 → suma las horas completas contenidas
        //   │       en los minutos.
        //   └▶ ⑥ % 24 → mantiene el resultado dentro de un día.
        this.h = ((hours + minutes / 60) % 24)
            // ▶ .let { if (minutes % 60 < 0) it - 1 else it }
            //   └▶ ⑦ si el resto de minutos es negativo, la división truncó
            //           hacia arriba: se resta 1 hora para compensar.
            .let { if (minutes % 60 < 0) it - 1 else it }
            // ▶ .let { if (it < 0) it + 24 else it }
            //   └▶ ⑧ si la hora quedó negativa, se le suma 24 para llevarla a [0,23].
            .let { if (it < 0) it + 24 else it }
        // ▶ this.m = (minutes % 60).let { if (it < 0) it + 60 else it }
        //   └▶ ⑨ minutes % 60 puede ser negativo; sumar 60 lo lleva a [0,59].
        this.m = (minutes % 60)
            .let { if (it < 0) it + 60 else it }
    }

    // ▶ override fun equals(other: Any?): Boolean = other is Clock && h == other.h && m == other.m
    //   └▶ ⑩ dos relojes son iguales si el otro es un Clock y coinciden h y m.
    @Override
    override fun equals(other: Any?): Boolean = other is Clock && h == other.h && m == other.m

    // ▶ private fun Int.padZeroChars() = toString().padStart(length = 2, padChar = '0')
    //   └▶ ⑪ función de extensión: convierte un Int a texto de 2 dígitos
    //           rellenando con '0' a la izquierda (7 → "07").
    private fun Int.padZeroChars() = toString().padStart(length = 2, padChar = '0')

    // ▶ override fun toString() = "${h.padZeroChars()}:${m.padZeroChars()}"
    //   └▶ ⑫ formatea el reloj como "HH:MM".
    override fun toString() = "${h.padZeroChars()}:${m.padZeroChars()}"

    // ▶ fun subtract(minutes: Int) { m -= minutes; normalize(h, m) }
    //   └▶ ⑬ resta minutos al campo m y vuelve a normalizar.
    fun subtract(minutes: Int) {
        m -= minutes
        normalize(h, m)
    }

    // ▶ fun add(minutes: Int) { m += minutes; normalize(h, m) }
    //   └▶ ⑭ suma minutos al campo m y vuelve a normalizar para corregir
    //           desbordamientos.
    fun add(minutes: Int) {
        m += minutes
        normalize(h, m)
    }
}

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Implementar un reloj sin fechas que permita sumar y restar
 *      minutos, normalizando siempre la hora al rango 00:00-23:59 y
 *      comparando relojes por igualdad de hora y minuto.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  Versión inmutable: add/subtract devuelven un nuevo Clock en
 *          vez de modificar el objeto actual (más seguro en concurrencia).
 *      B)  Usar Math.floorMod(hours * 60 + minutes, 24 * 60) para
 *          normalizar en un solo paso, sin .let encadenados.
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Clock(10, 30).add(45)"
 *      ─────────────────────────────────────────────────────────
 *      m = 30+45 = 75 → normalize(10, 75)
 *      75/60=1 → (10+1)%24=11; 75%60=15
 *      Resultado: "11:15"
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "Clock(0, -5)"
 *      ─────────────────────────────────────────────────────────
 *      -5/60=0 → (0+0)%24=0; -5%60=-5<0 → h=0-1=-1 → h=-1+24=23
 *      m=-5<0 → m=-5+60=55
 *      Resultado: "23:55"
 *
 *  ================================================================
 */
