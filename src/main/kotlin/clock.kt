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
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Implementar un reloj sin fechas que permita sumar y restar
 *      minutos, normalizando siempre la hora al rango 00:00-23:59 y
 *      comparando relojes por igualdad de hora y minuto.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Guardar horas y minutos en campos mutables internos (h, m)
 *           inicializados en el bloque init llamando a normalize.
 *      II.  normalize calcula la hora base con (hours + minutes/60) %
 *           24 y ajusta signos negativos sumando 24 o 60 cuando
 *           corresponde.
 *      III. add/subtract modifican m y vuelven a llamar a normalize.
 *      IV.  toString formatea h y m con dos dígitos; equals compara
 *           ambos campos.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  private fun normalize(hours: Int, minutes: Int) {
 *      →      this.h = ((hours + minutes / 60) % 24)
 *      ①  hours + minutes/60 suma las horas completas contenidas en
 *          los minutos; % 24 mantiene el resultado en rango de un día.
 *
 *      →          .let { if (minutes % 60 < 0) it - 1 else it }
 *      ②  Si el residuo de minutos es negativo, la división truncó
 *          hacia arriba: se resta 1 hora para compensar.
 *
 *      →          .let { if (it < 0) it + 24 else it }
 *      ③  Si la hora quedó negativa, se suma 24 para llevarla a [0,23].
 *
 *      →      this.m = (minutes % 60)
 *      →          .let { if (it < 0) it + 60 else it }
 *      ④  El residuo de minutes % 60 puede ser negativo; sumar 60 lo
 *          lleva a [0, 59].
 *      →  }
 *
 *      →  fun add(minutes: Int) {
 *      →      m += minutes
 *      →      normalize(h, m)
 *      ⑤  Suma minutos al campo m y vuelve a normalizar para corregir
 *          desbordamientos.
 *      →  }
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
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      CLASE Reloj(horas=0, minutos=0)
 *          FUNCIÓN normalizar(horas, minutos):
 *              h ← (horas + minutos/60) % 24
 *              SI (minutos % 60) < 0: h ← h - 1
 *              SI h < 0: h ← h + 24
 *              m ← minutos % 60
 *              SI m < 0: m ← m + 60
 *
 *          FUNCIÓN sumar(minutos): m ← m + minutos; normalizar(h, m)
 *          FUNCIÓN restar(minutos): m ← m - minutos; normalizar(h, m)
 *      FIN CLASE
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
