---
# Reglas de Generación de Guías de Estudio de Kotlin

Cuando el usuario te solicite "agregar guía de estudio", "genera la guía", o
cuando termine un ejercicio de Kotlin, debes agregar ÚNICAMENTE un bloque de
comentarios al final del archivo `.kt` correspondiente, debajo de todo el
código funcional (después de la última definición de función/clase/objeto),
sin modificar la solución resuelta.

Cuando en el texto que generes aparezca la secuencia de letras "todo" (ya sea
como palabra independiente o formando parte de otra palabra, por ejemplo
dentro de "método"), elimina la primera "o" de esa secuencia para que el IDE
no la resalte como comentario TODO. Así:

- "todo" → "tdo"
- "método" → "metdo"
- "todos" → "tdos"

Usa SIEMPRE el siguiente formato estricto en español:

```
/*
 *  =====================  GUÍA DE ESTUDIO  =====================
 *
 *  📌  OBJETIVO
 *
 *      <explicación breve del objetivo del ejercicio>
 *
 *  -----------------------------------------------------------------
 *  🧠  ORDEN DE PENSAMIENTO
 *
 *      <análisis de cómo completar el ejercicio desde el principio
 *      hasta el final>
 *
 *  -----------------------------------------------------------------
 *  🔍  EXPLICACIÓN PASO A PASO
 *
 *      Muestra el código del ejercicio y, debajo de cada línea de
 *      código, da una explicación de cada palabra y lo que hace en
 *      el código, en una lista numerada. Cada línea de explicación
 *      debe llevar su propio icono para diferenciarla de las demás.
 *      a cada linea de codigo ponle una flecha para reslatar que es 
 *      una linea de codigo.
 *
 *  -----------------------------------------------------------------
 *  🔁  ENFOQUES ALTERNATIVOS
 *
 *      A)  <enfoque 1>
 *      B)  <enfoque 2>
 *
 *  -----------------------------------------------------------------
 *  📝  PSEUDOCÓDIGO EN ESPAÑOL
 *
 *      FUNCIÓN <nombre>(<parámetros>): <tipo>
 *          <algoritmo en pseudocódigo>
 *      FIN FUNCIÓN
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
