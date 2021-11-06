import java.math.BigInteger

val BASES = 2..36

fun main() {
    val message = "Enter two numbers in format: {source base} {target base} (To quit type /exit) "

    while (true) {
        when (val command = getString(message)) {
            "/exit" -> return
            else -> baseToBase(command.split(" "))
        }
        println()
    }
}

fun baseToBase(stringBases: List<String>) {
    if (stringBases.size == 2 && stringBases[0] != stringBases[1]) {
        val source = getBase(stringBases[0]) ?: return
        val target = getBase(stringBases[1]) ?: return
        val message = "Enter number in base $source to convert to base $target (To go back type /back) "
        var command = getString(message)

        while (command != "/back") {
            val result = getConversion(source, target, command)
            println(if (result != null) "Conversion result: $result" else "$command is invalid for base $source")
            command = getString("\n" + message)
        }
    } else println("Please enter two numbers within ($BASES), that are not equal to each other")
}

fun getConversion(source: BigInteger, target: BigInteger, number: String): String? {
    val decimal = (if (source == BigInteger.TEN) number.toBigIntegerOrNull() else
        (baseToDecimal(number, source))) ?: return null

    return if (target == BigInteger.TEN) decimal.toString() else decimalToBase(decimal, target)
}

fun getBase(number: String): BigInteger? {
    val base = number.toIntOrNull()

    return if (base == null || base !in BASES) {
        println("$number is not a valid base ($BASES)")
        null
    } else base.toBigInteger()
}

fun decimalToBase(number: BigInteger, base: BigInteger): String {
    var result = ""
    var quotient = number.abs()

    while (quotient >= base) {
        result = getBaseConversion(quotient.remainder(base).toInt()) + result
        quotient /= base
    }
    return (if (number < BigInteger.ZERO) "-" else "") + getBaseConversion(quotient.toInt()) + result
}

fun getBaseConversion(remainder: Int) = (if (remainder >= 10) 'a' + remainder - 10 else remainder).toString()

fun baseToDecimal(number: String, base: BigInteger): BigInteger? {
    val negative = number.startsWith("-")
    val abs = if (negative) number.substring(1) else number
    val valid = abs.isNotEmpty() && abs.all { it.isLetterOrDigit() }
    val list = if (valid) abs.reversed().lowercase().toCharArray()
        .map { getDecimalConversion(it).toBigInteger() } else emptyList()

    return if (list.isEmpty() || list.any { it >= base }) null else {
        var multiply = BigInteger.ONE
        val sum = list.sumOf { it * multiply.also { multiply *= base } }
        if (negative) -sum else sum
    }
}

fun getDecimalConversion(number: Char) = if (number.isLetter()) number.code - 87 else number.digitToInt()

fun getString(message: String): String {
    print(message)
    return readLine()!!
}