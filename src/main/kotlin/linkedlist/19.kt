package linkedlist

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var delNode = head
    var currentNode = head
    var currentIteration = 1

    while (currentNode != null) {
        if (currentIteration > n + 1) {
            delNode = delNode?.next
        }
        currentNode = currentNode.next
        currentIteration++
    }
    if (delNode == head && currentIteration == n + 1) {
        return head?.next
    }
    delNode?.next = delNode?.next?.next
    return head
}