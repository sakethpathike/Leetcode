package linkedlist

class `61` {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        if (k == 0) return head

        var lengthOfThisLinkedList = 0
        var refHead = head
        while (refHead != null) {
            ++lengthOfThisLinkedList
            refHead = refHead.next
        }

        if (lengthOfThisLinkedList == k || k % lengthOfThisLinkedList == 0) {
            return head
        }

        val reminder = k % lengthOfThisLinkedList
        var counter = 0
        val dummyNode = ListNode(0)
        dummyNode.next = head
        var refNode = head
        while (true) {
            while (refNode?.next?.next != null) {
                refNode = refNode.next
            }
            val endNode = refNode?.next
            refNode?.next = null
            endNode?.next = dummyNode.next
            dummyNode.next = endNode
            refNode = dummyNode.next
            counter++
            if (counter == reminder) {
                break
            }
        }
        return dummyNode.next
    }
}

/*
fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    val l6 = ListNode(6)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5
    l5.next = l6
    l6.next = null

    var newList = `61`().rotateRight(l1, 600001)
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}*/
