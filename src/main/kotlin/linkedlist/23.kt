@file:Suppress("DuplicatedCode")

package linkedlist

class `23` {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty() || lists.filterNotNull().isEmpty()) return null
        val filteredList = lists.filterNotNull()
        val newValueList = mutableListOf<Int>()
        filteredList.forEach {
            var currentListNode: ListNode? = it
            while (currentListNode != null) {
                newValueList.add(currentListNode.`val`)
                currentListNode = currentListNode.next
            }
        }
        val newListNode = ListNode(0)
        var refNode: ListNode? = newListNode
        mergeSort(newValueList).forEachIndexed { index, it ->
            refNode?.`val` = it
            if (index != newValueList.size - 1) {
                refNode?.next = ListNode(0)
            }
            refNode = refNode?.next
        }
        return newListNode
    }

    private fun mergeSort(list: List<Int>): MutableList<Int> {
        if (list.size <= 1) return list.toMutableList()
        val halfIndex = list.size / 2
        val leftList = list.subList(0, halfIndex)
        val rightList = list.subList(halfIndex, list.size)

        val sortedLeftList = mergeSort(leftList)
        val sortedRightList = mergeSort(rightList)
        return mergeImpl(sortedLeftList, sortedRightList)
    }

    private fun mergeImpl(leftList: List<Int>, rightList: List<Int>): MutableList<Int> {
        var leftIndex = 0
        var rightIndex = 0
        val newList = mutableListOf<Int>()
        while (leftIndex < leftList.size && rightIndex < rightList.size) {
            if (leftList[leftIndex] <= rightList[rightIndex]) {
                newList.add(leftList[leftIndex])
                leftIndex++
            } else {
                newList.add(rightList[rightIndex])
                rightIndex++
            }
        }
        while (leftIndex < leftList.size) {
            newList.add(leftList[leftIndex])
            leftIndex++
        }
        while (rightIndex < rightList.size) {
            newList.add(rightList[rightIndex])
            rightIndex++
        }
        return newList
    }
}

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(4)
    val l3 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = null

    val l5 = ListNode(1)
    val l6 = ListNode(3)
    val l7 = ListNode(4)
    l5.next = l6
    l6.next = l7
    l7.next = null

    val l8 = ListNode(2)
    val l9 = ListNode(6)
    l8.next = l9
    l9.next = null

    var newList = `23`().mergeKLists(arrayOf(null, l9))
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}