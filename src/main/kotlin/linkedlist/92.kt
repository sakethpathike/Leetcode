package linkedlist

import kotlin.time.measureTimedValue

class `92` {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null) return null
        val refList = mutableListOf<Int>()
        var refHead = head
        while (refHead != null) {
            refList.add(refHead.`val`)
            refHead = refHead.next
        }
        val reversedSubList = refList.subList(left - 1, right).reversed()
        val finalList = refList.subList(0, left - 1) + reversedSubList + refList.subList(right, refList.size)
        val finalNewListNode = ListNode(0)
        var refFinalListNode: ListNode? = finalNewListNode
        finalList.forEachIndexed { index, intValue ->
            refFinalListNode?.`val` = intValue
            if (index != finalList.size - 1) {
                refFinalListNode?.next = ListNode(0)
            }
            refFinalListNode = refFinalListNode?.next
        }
        return finalNewListNode
    }
}

/*
fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    val l6 = ListNode(2)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = null
    l5.next = null
    l6.next = null
    measureTimedValue {
        `92`().reverseBetween(l1, 1, 4)
    }.let {
        println(it.duration)
    }
    var newList = `92`().reverseBetween(l1, 1, 4)
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}*/
