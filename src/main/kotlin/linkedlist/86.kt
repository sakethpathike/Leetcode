@file:Suppress("DuplicatedCode")

package linkedlist

class `86` {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null
        if (x < 0) return head
        var refHead: ListNode? = head
        val refList = mutableListOf<Int>()

        val newList = mutableListOf<Int>()

        while (refHead != null) {
            refList.add(refHead.`val`)
            refHead = refHead.next
        }

        refList.filter { it < x }.forEach { newList.add(it) }
        val finalList = newList + refList.filterNot { newList.contains(it) }
        val newListNode = ListNode(0)
        var refNewListNode: ListNode? = newListNode
        finalList.forEachIndexed { index, it ->
            refNewListNode?.`val` = it
            if (index != finalList.size - 1) {
                refNewListNode?.next = ListNode(0)
            }
            refNewListNode = refNewListNode?.next
        }
        return newListNode
    }
}

/*
fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(4)
    val l3 = ListNode(3)
    val l4 = ListNode(0)
    val l5 = ListNode(5)
    val l6 = ListNode(2)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6
    l6.next = null
    measureTime {
        `86`().partition(l1, 2)
    }.let {
        println(it.inWholeMilliseconds)
    }
    var newList = `86`().partition(l1, 2)
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}*/
