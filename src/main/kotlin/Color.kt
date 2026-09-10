
enum class Color { BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE }

/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      Definir los 10 colores de bandas de resistencias como un enum,
 *      donde el orden de declaración coincide con su valor numérico
 *      (0-9), para reutilizarlo en ResistorColorDuo y ResistorColorTrio.
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      I.   Declarar un enum class con las 10 constantes en el orden
 *           exacto de la codificación estándar (black=0 ... white=9).
 *      II.  Al no asignar valores explícitos, Kotlin usa el .ordinal
 *           de cada constante (su posición, empezando en 0) como
 *           valor numérico implícito.
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      →  enum class Color { BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE }
 *      ①  enum class define un conjunto fijo y ordenado de constantes.
 *      ②  BLACK es la primera constante → .ordinal = 0; BROWN → 1;
 *          y así sucesivamente hasta WHITE → 9, coincidiendo con el
 *          valor real de cada color en el código de resistencias.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  enum class Color(val value: Int) { BLACK(0), BROWN(1), ... }
 *          — asignar el valor explícitamente en vez de depender del
 *          orden de declaración (más seguro ante reordenamientos).
 *      B)  Usar una lista de Strings (como en ResistorColor.kt) en
 *          vez de un enum, si no se necesita seguridad de tipos.
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      ENUMERACIÓN Color
 *          NEGRO=0, MARRON=1, ROJO=2, NARANJA=3, AMARILLO=4,
 *          VERDE=5, AZUL=6, VIOLETA=7, GRIS=8, BLANCO=9
 *      FIN ENUMERACIÓN
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "Color.BLACK.ordinal"
 *      ─────────────────────────────────────────────────────────
 *      BLACK es la primera constante declarada
 *      Resultado: 0
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 2: "Color.VIOLET.ordinal"
 *      ─────────────────────────────────────────────────────────
 *      VIOLET es la octava constante (índice 7, empezando en 0)
 *      Resultado: 7
 *
 *  ================================================================
 */
