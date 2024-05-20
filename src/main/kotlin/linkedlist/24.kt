package linkedlist

class `24` {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        val dummyNode = ListNode(0)
        var prevNode = dummyNode
        var currentNode = head
        while (currentNode?.next != null) {
            val nextPair = currentNode.next?.next
            val tempNode = currentNode.next

            currentNode.next = nextPair
            tempNode?.next = currentNode
            prevNode.next = tempNode

            prevNode = currentNode
            currentNode = nextPair
        }
        return dummyNode.next
    }
}

/*
fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(4)
    val l3 = ListNode(5)
    l1.next = l2
    l2.next = l3
    l3.next = null

    var newList = `24`().swapPairs(l1)
    while (newList != null) {
        print("${newList.`val`} ")
        newList = newList.next
    }
}*/
