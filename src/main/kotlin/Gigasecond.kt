@file:Suppress("SpellCheckingInspection")
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Introduction
 *
 * The way we measure time is kind of messy. We have 60 seconds in a
 * minute, and 60 minutes in an hour. This comes from ancient Babylon,
 * where they used 60 as the basis for their number system. We have 24
 * hours in a day, 7 days in a week, and how many days in a month?
 * Well, for days in a month it depends not only on which month it is,
 * but also on what type of calendar is used in the country you live in.
 *
 * What if, instead, we only use seconds to express time intervals?
 * Then we can use metric system prefixes for writing large numbers of
 * seconds in more easily comprehensible quantities.
 *
 *   - A food recipe might explain that you need to let the brownies
 *     cook in the oven for two kiloseconds (two thousand seconds).
 *   - Perhaps you and your family would travel to somewhere exotic
 *     for two megaseconds (two million seconds).
 *   - And if you and your spouse were married for a thousand million
 *     seconds, you would celebrate your one gigasecond anniversary.
 *
 * Note
 *
 * If we ever colonize Mars or some other planet, measuring time is
 * going to get even messier. If someone says "year" do they mean a
 * year on Earth or a year on Mars?
 *
 * The idea for this exercise came from the science fiction novel
 * "A Deepness in the Sky" by author Vernor Vinge. In it he uses the
 * metric system as the basis for time measurements.
 *
 * Instructions
 *
 * Your task is to determine the date and time one gigasecond after a
 * certain date.
 *
 * A gigasecond is one thousand million seconds. That is a one with
 * nine zeros after it.
 *
 * If you were born on January 24th, 2015 at 22:00 (10:00:00pm), then
 * you would be a gigasecond old on October 2nd, 2046 at 23:46:40
 * (11:46:40pm).
 */




class Gigasecond(val birthDate: LocalDateTime) { // * <- Constructor Primario

    // ? Constructor secundario: Si nos pasan solo un LocalDate,
    // ? lo convertimos a LocalDateTime a las 00:00:00 y se lo enviamos al constructor principal
    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay())

    // Calculamos la nueva fecha sumando el gigasegundo
    val date: LocalDateTime = birthDate.plusSeconds(1_000_000_000)
}

// ============================================================
//  1. INSTRUCCIONES
// ============================================================
//
// Dada una fecha (LocalDateTime o LocalDate), calcular el
// momento exacto un gigasegundo (1.000.000.000 segundos) después.
//
// Objetivos:
//  - Aceptar tanto LocalDate como LocalDateTime.
//  - Si se recibe LocalDate, convertirlo al inicio de ese dia
//    (00:00:00) antes de operar.
//  - Usar el metdo plusSeconds de la API de java.time.
//  - Almacenar el resultado en una propiedad calculada date.

// ============================================================
//  2. ORDEN DE PENSAMIENTO
// ============================================================
//
//  2.1 Analisis de la entrada
//   - La fecha puede venir como LocalDate (solo dia) o como
//     LocalDateTime (dia + hora).
//   - Si es LocalDate, debemos interpretarla como las 00:00:00
//     de ese dia.
//
//  2.2 Conversion al tipo unificado
//   - Creamos un constructor secundario que reciba LocalDate,
//     lo convierta con atStartOfDay() y delegue en el constructor
//     primario (this).
//
//  2.3 Calculo del gigasegundo
//   - Un gigasegundo = 1_000_000_000 segundos.
//   - Usamos plusSeconds() sobre el LocalDateTime unificado.
//   - Guardamos el resultado en una propiedad val date.
//
//  2.4 Propiedad calculada
//   - val date: LocalDateTime se inicializa directamente en el
//     cuerpo de la clase, sin necesidad de un bloque init.

// ============================================================
//  3. SINTAXIS DEL CODIGO
// ============================================================
//
// +----------------+------------------------------------------+--------------------------------------+
// | Palabra clave  | Significado                              | Analogia                             |
// +----------------+------------------------------------------+--------------------------------------+
// | class          | Define un nuevo tipo de dato.            | Como un molde para crear objetos.    |
// | val            | Declara una propiedad de solo lectura.   | Una etiqueta permanente que no       |
// |                |                                          | cambia de valor.                     |
// | constructor    | Metdo especial para construir objetos.  | La puerta de entrada al objeto.      |
// | this           | Referencia al objeto actual.             | "Yo mismo" dentro de la clase.       |
// | :              | Indica herencia, delegacion o tipo.     | "Es un" o "delega en".               |
// | atStartOfDay   | Convierte LocalDate a LocalDateTime      | Pone el reloj a medianoche.          |
// |                | a las 00:00:00.                          |                                      |
// | plusSeconds    | Suma una cantidad de segundos.           | Avanzar el cronometro.               |
// | LocalDateTime  | Fecha y hora sin zona horaria.           | Un instante en el calendario y       |
// |                |                                          | reloj de pared.                      |
// +----------------+------------------------------------------+--------------------------------------+

// ============================================================
//  4. PSEUDOCODIGO
// ============================================================
//
// Clase Gigasecond:
//     Constructor primario( fechaNacimiento: LocalDateTime )
//         propiedad date := fechaNacimiento + 1_000_000_000 segundos
//
//     Constructor secundario( fechaNacimiento: LocalDate )
//         Llama al constructor primario con fechaNacimiento a las 00:00:00
//
//     Propiedad date: LocalDateTime (se calcula automaticamente)

// ============================================================
//  5. EJEMPLOS TRABAJADOS
// ============================================================
//
// Ejemplo 1:
//   Entrada: LocalDate.of(2015, 1, 24)
//   Proceso: Se convierte a 2015-01-24T00:00, se suman
//            1_000_000_000 segundos.
//   Resultado: 2046-10-02T23:46:40
//
// Ejemplo 2:
//   Entrada: LocalDateTime.of(2020, 6, 1, 12, 0, 0)
//   Proceso: Se suma 1_000_000_000 segundos directamente.
//   Resultado: 2052-02-07T11:46:40
//
// Ejemplo 3:
//   Entrada: LocalDate.of(2000, 1, 1)
//   Proceso: Se convierte a 2000-01-01T00:00, se suman
//            1_000_000_000 segundos.
//   Resultado: 2031-09-09T23:46:40
//