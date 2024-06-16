package recursion

class `224` {
    fun calculate(s: String): Int {
        return basicCalculator(0, s.trim(), 0, '+')
    }

    private fun basicCalculator(index: Int, string: String, currentSum: Int, sign: Char): Int {
        if (index >= string.length) {
            return currentSum
        }
        var num = ""
        var currentIndex = index

        while (currentIndex < string.length && string[currentIndex].isDigit()) {
            num += string[currentIndex]
            currentIndex++
        }
        var resultSum = currentSum
        val parsedNum = if (num.isNotEmpty()) num.toInt() else 0

        if (currentIndex >= string.length) {
            return if (sign == '+') {
                currentSum + parsedNum
            } else {
                currentSum - parsedNum
            }
        }
        if (sign == '+') {
            resultSum += parsedNum
        } else if (sign == '-') {
            resultSum -= parsedNum
        }
        return basicCalculator(++currentIndex, string, resultSum, string[currentIndex - 1])
    }

}

fun main() {
    println(`224`().calculate("1+4+5+2+3+6+8")) // 23
}