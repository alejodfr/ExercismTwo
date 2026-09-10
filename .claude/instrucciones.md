---
# Reglas de Generación de Guías de Estudio de Kotlin

Cuando el usuario te solicite "agregar guía de estudio", "genera la guía", o
cuando termine un ejercicio de Kotlin, debes documentar el archivo `.kt`
correspondiente con el formato de abajo, SIN modificar la lógica de la
solución resuelta (solo se añaden comentarios y, opcionalmente, un bloque
final reducido).

Cuando en el texto que generes aparezca la secuencia de letras "todo" (ya sea
como palabra independiente o formando parte de otra palabra, por ejemplo
dentro de "método"), elimina la primera "o" de esa secuencia para que el IDE
no la resalte como comentario TODO. Así:

- "todo" → "tdo"
- "método" → "metdo"
- "todos" → "tdos"

## Estructura del archivo

1. `@file:Suppress("SpellCheckingInspection")` en la primera línea (evita que
   el IDE subraye el español de los comentarios).
2. El enunciado original del ejercicio en un bloque `/** Instructions ... */`
   (tal cual lo entrega Exercism). NUNCA se elimina.
3. El código real de la solución, anotado con la EXPLICACIÓN PASO A PASO
   integrada como comentarios `//` con flechas (ver abajo).
4. Opcionalmente, una función `main()` de demostración con ejemplos.
5. Un bloque final reducido `/* GUÍA DE ESTUDIO */` con solo tres secciones:
   OBJETIVO, ENFOQUES ALTERNATIVOS y EJEMPLOS TRABAJADOS.

## EXPLICACIÓN PASO A PASO (integrada en el código)

La explicación va DENTRO del código real, no en un bloque aparte:

- Justo encima de cada línea de código, escribe un comentario `// ▶` que
  repite esa línea (respetando su indentación).
- Debajo, cuelga la explicación de cada una de sus palabras con las flechas
  `├▶` (cuando hay más) y `└▶` (la última), alineadas bajo el `▶`.
- Numera cada explicación con su propio icono (`①`, `②`, `③`, ...).
- Usa el formato   `palabra → qué hace`.
- El código real se deja intacto debajo de sus comentarios.

Ejemplo:

```kotlin
    // ▶ fun isAllergicTo(allergen: Allergen): Boolean {
    //   ├▶ ① allergen: Allergen → recibe el alérgeno a consultar.
    //   └▶ ② : Boolean → devuelve true o false.
    fun isAllergicTo(allergen: Allergen): Boolean {
        // ▶ return score and allergen.score != 0
        //   ├▶ ③ score → puntaje total de la persona.
        //   ├▶ ④ and → AND bit a bit entre los dos puntajes.
        //   └▶ ⑤ != 0 → true si quedó algún bit en común.
        return score and allergen.score != 0
    }
```

## Bloque final reducido

Va después de todo el código (incluida `main()` si existe). Formato estricto
en español:

```
/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      <explicación breve del objetivo del ejercicio>
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  <enfoque 1>
 *      B)  <enfoque 2>
 *
 *  -----------------------------------------------------------------
 *  🧪  EJEMPLOS TRABAJADOS
 *
 *      ─────────────────────────────────────────────────────────
 *      Ejemplo 1: "<entrada>"
 *      ─────────────────────────────────────────────────────────
 *      <verificación paso a paso>
 *      Resultado: <resultado esperado>
 *
 *  ================================================================
 */
```
