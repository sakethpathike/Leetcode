package linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Ref = l1
        var l2Ref = l2
        val newList = ListNode(0)
        var refList: ListNode? = newList
        var carry = 0
        while (l1Ref != null || l2Ref != null || carry != 0) {
            val v1 = l1Ref?.`val` ?: 0
            val v2 = l2Ref?.`val` ?: 0
            val nodeSum = v1 + v2 + carry
            carry = nodeSum / 10
            val newNode = ListNode(nodeSum % 10)
            refList?.next = newNode
            refList = refList?.next
            l1Ref = l1Ref?.next
            l2Ref = l2Ref?.next
        }
        return newList.next
    }
}