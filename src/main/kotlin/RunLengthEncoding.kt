@file:Suppress("SpellCheckingInspection")


/**
 * Instructions
 * Implement run-length encoding and decoding.
 *
 * Run-length encoding (RLE) is a simple form of data compression, where
 * runs (consecutive data elements) are replaced by just one data value
 * and count.
 *
 * For example we can represent the original 53 characters with only 13.
 *
 *     "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"
 *         ->  "12WB12W3B24WB"
 *
 * RLE allows the original data to be perfectly reconstructed from the
 * compressed data, which makes it a lossless data compression.
 *
 *     "AABCCCDEEEE"  ->  "2AB3CD4E"  ->  "AABCCCDEEEE"
 *
 * For simplicity, you can assume that the unencoded string will only
 * contain the letters A through Z (either lower or upper case) and
 * whitespace. This way data to be encoded will never contain any
 * numbers and numbers inside data to be decoded always represent
 * the count for the following character.
 */



object RunLengthEncoding {

    fun encode(input: String): String {
        var count = 1
        var currentChar = input[0]
        val result = StringBuilder()

        for (i in 1 until input.length) {
            if (input[i] == currentChar) {
                count++
            } else {
                // aquí agregas al result y reseteas
            }
        }
// aquí agregas el último grupo
    }

    fun decode(input: String): String {
        TODO("Implement this to complete the task")
    }
}