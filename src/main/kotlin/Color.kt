@file:Suppress("SpellCheckingInspection")

// ▶ enum class Color { BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE }
//   ├▶ ① enum class → conjunto fijo y ordenado de constantes con nombre.
//   └▶ ② sin valores explícitos: Kotlin usa el .ordinal de cada constante
//           (su posición, empezando en 0) como valor. BLACK → 0, BROWN → 1,
//           ... WHITE → 9, que es justo el código real de cada color.
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
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  enum class Color(val value: Int) { BLACK(0), BROWN(1), ... }
 *          — asignar el valor explícitamente en vez de depender del
 *          orden de declaración (más seguro ante reordenamientos).
 *      B)  Usar una lista de Strings (como en ResistorColor.kt) en
 *          vez de un enum, si no se necesita seguridad de tipos.
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
