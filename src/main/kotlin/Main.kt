import kotlin.math.abs

fun main() {
    while (true) {
        when (getString("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ")) {
            "/from" -> decimalToBase(getDecimal(), getBase("Enter the target base: "))
            "/to" -> baseToDecimal(getString("Enter source number: "), getBase("Enter source base: "))
            "/exit" -> return
            else -> continue
        }
        println()
    }
}

fun getDecimal(message: String = "Enter a number in decimal system: "): Int {
    return getString(message).toIntOrNull() ?: getDecimal("Please enter a valid number: ")
}

fun getBase(message: String): Int {
    val bases = listOf(2, 8, 16)
    val base = getDecimal(message)

    return if (base in bases) base else getBase("Please enter a valid base $bases: ")
}

fun decimalToBase(number: Int, base: Int) {
    var result = ""
    var quotient = abs(number)

    while (quotient >= base) {
        result = getBaseConversion(quotient % base) + result
        quotient /= base
    }
    println("Conversion result: " + (if (number < 0) "-" else "") + getBaseConversion(quotient) + result)
}

fun getBaseConversion(remainder: Int) = (if (remainder >= 10) 'a' + remainder - 10 else remainder).toString()

fun baseToDecimal(number: String, base: Int) {
    val negative = number.startsWith("-")
    val abs = if (negative) number.substring(1) else number
    val valid = abs.isNotEmpty() && abs.all { it.isLetterOrDigit() }
    val list = if (valid) abs.reversed().lowercase().toCharArray().map { getDecimalConversion(it) } else emptyList()
    val result = if (list.isEmpty() || list.any { it >= base }) "$number is invalid for base $base" else {
        var multiply = 1
        val sum = list.sumOf { it * multiply.also { multiply *= base } }
        "Conversion to decimal result: " + if (negative) -sum else sum
    }

    println(result)
}

fun getDecimalConversion(number: Char) = (if (number.isLetter()) number.code - 87 else number.digitToInt())

fun getString(message: String): String {
    print(message)
    return readLine()!!
}