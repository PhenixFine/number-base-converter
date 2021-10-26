fun main() {
    val result = convertToBase(getNum(), getBase())

    println("Conversion result: $result")
}

fun getNum(message: String = "Enter number in decimal system: "): Int {
    return getString(message).toIntOrNull() ?: getNum("Please enter a valid number: ")
}

fun getBase(message: String = "Enter target base: "): Int {
    val bases = listOf(2, 8, 16)
    val base = getNum(message)

    return if (base in bases) base else getBase("Please enter a valid base $bases: ")
}

fun convertToBase(number: Int, base: Int): String {
    var result = ""
    var quotient = number

    while (quotient >= base) {
        result = getConversion(quotient % base) + result
        quotient /= base
    }
    return getConversion(quotient) + result
}

fun getConversion(remainder: Int) = (if (remainder >= 10) 'A' + remainder - 10 else remainder).toString()

fun getString(message: String): String {
    print(message)
    return readLine()!!
}