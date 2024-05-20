package linkedlist

import kotlin.time.measureTime

class `82` {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var refHead = head
        val newLinkedList = ListNode(0)
        var refNewLinkedList: ListNode? = newLinkedList
        val existingNodes = mutableListOf<Int>()
        while (refHead != null) {
            existingNodes.add(refHead.`val`)
            refHead = refHead.next
        }

        val nonDuplicatedList = existingNodes.distinct().toMutableList()


        existingNodes.forEach { value ->
            if (existingNodes.count { it == value } > 1) {
                nonDuplicatedList.remove(value)
            }
        }

        if (nonDuplicatedList.isEmpty()) return null

        nonDuplicatedList.sorted().forEachIndexed { index, i ->
            refNewLinkedList?.`val` = i
            if (index != nonDuplicatedList.size - 1) {
                refNewLinkedList?.next = ListNode(0)
            }
            refNewLinkedList = refNewLinkedList?.next
        }
        return newLinkedList
    }
}

fun main() {
    //[1,2,3,3,4,4,5]
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(3)
    val l5 = ListNode(4)
    val l6 = ListNode(4)
    val l7 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6
    l6.next = l7
    l7.next = null
    measureTime {
        `82`().deleteDuplicates(l1)
    }.let {
        println(it.inWholeMilliseconds)
    }
    var newList = `82`().deleteDuplicates(l1)
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}