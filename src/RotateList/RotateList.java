package RotateList;


public class RotateList
{
    public RotateList()
    {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
//        node = node.next;
//        node.next = new ListNode(6);
//        node = node.next;
//        node.next = new ListNode(7);
//        node = node.next;
//        node.next = new ListNode(8);
//        node = node.next;
//        node.next = new ListNode(9);
//        node = node.next;
//        node.next = new ListNode(10);
//        node = node.next;
//        node.next = new ListNode(11);
//        node = node.next;
//        node.next = new ListNode(12);
        rotateRight(head, 7);
    }

    public ListNode rotateRight(ListNode head, int k)
    {
        if(head == null || head.next == null) return head;

        ListNode headNode = head;
        int count = 0;

        while(headNode != null)
        {
            count++;
            headNode = headNode.next;
        }

        if(k == count) return head;

        count = count - k%count;
        headNode = head;
        ListNode startNode = head;
        ListNode endNode;

        while (--count > 0) headNode = headNode.next;
        endNode = headNode;
        while (headNode.next != null) headNode = headNode.next;

        headNode.next = startNode;
        startNode = endNode.next;
        endNode.next = null;
        return startNode;
    }

    public class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
