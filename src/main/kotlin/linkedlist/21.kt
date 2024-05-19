package linkedlist

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null && list2 == null) {
        return null
    }
    var refList1 = list1
    var refList2 = list2
    val newList = mutableListOf<Int>()
    while (refList1 != null || refList2 != null) {
        if (refList1 != null) {
            newList.add(refList1.`val`)
        }
        if (refList2 != null) {
            newList.add(refList2.`val`)
        }
        refList1 = refList1?.next
        refList2 = refList2?.next
    }
    val sortedNewList = mergeSort(newList)
    val newSortedListNode = ListNode(0)
    var referListNode: ListNode? = newSortedListNode
    sortedNewList.forEachIndexed { index, intValue ->
        referListNode?.`val` = intValue
        if (index != sortedNewList.size - 1) {
            referListNode?.next = ListNode(0)
        }
        referListNode = referListNode?.next
    }
    return newSortedListNode
}

private fun mergeSort(list: List<Int>): MutableList<Int> {
    if (list.size <= 1) return list.toMutableList()
    val middleIndex = list.size / 2
    val firstList = list.subList(0, middleIndex)
    val secondList = list.subList(middleIndex, list.size)

    val sortedFirstList = mergeSort(firstList)
    val sortedSecondList = mergeSort(secondList)

    return merge(sortedFirstList, sortedSecondList)
}

private fun merge(firstList: List<Int>, secondList: List<Int>): MutableList<Int> {
    val newList = mutableListOf<Int>()
    var firstListIndex = 0
    var secondListIndex = 0

    while (firstListIndex < firstList.size && secondListIndex < secondList.size) {
        if (firstList[firstListIndex] <= secondList[secondListIndex]) {
            newList.add(firstList[firstListIndex])
            firstListIndex++
        } else {
            newList.add(secondList[secondListIndex])
            secondListIndex++
        }
    }
    while (firstListIndex < firstList.size) {
        newList.add(firstList[firstListIndex])
        firstListIndex++
    }
    while (secondListIndex < secondList.size) {
        newList.add(secondList[secondListIndex])
        secondListIndex++
    }
    return newList
}

fun main() {
    val l1 = ListNode(7)
    val l2 = ListNode(8)
    val l3 = ListNode(10)
    val l4 = ListNode(14)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = null

    val l5 = ListNode(5)
    val l6 = ListNode(7)
    val l7 = ListNode(9)
    val l8 = ListNode(123)
    l5.next = l6
    l6.next = l7
    l7.next = l8
    l8.next = null

    var newList = mergeTwoLists(l1, l5)
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}