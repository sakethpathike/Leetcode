class `78` {
    fun subsets(nums: IntArray): List<List<Int>> {
        return subSets(intArray = nums.toList(), listOf())
    }

    private fun subSets(intArray: List<Int>, consideredValue: List<Int>): List<List<Int>> {
        if (intArray.isEmpty()) {
            return listOf(consideredValue)
        }
        val firstElement = intArray[0]
        val remainingElements = intArray.subList(1, intArray.size)
        return (subSets(remainingElements, consideredValue + firstElement)).plus(
            (subSets(
                remainingElements,
                consideredValue
            ))
        )
    }
}

/*
fun main() {
    println(`78`().subsets(listOf(1, 2, 3).toIntArray()))
}*/
