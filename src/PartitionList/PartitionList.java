package PartitionList;

public class PartitionList
{
    public PartitionList()
    {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(1);
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
        partition(head, 3);
    }

    public ListNode partition(ListNode head, int x)
    {
        if(head == null || head.next == null) return head;

        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode tempNode = null;

        while(currNode != null)
        {
            if(nextNode != null)
            {
                if(currNode.val < x)
                {
                    if(nextNode.next != currNode)
                    {
                        tempNode = currNode.next;
                        prevNode.next = tempNode;
                        tempNode = nextNode.next;
                        nextNode.next = currNode;
                        nextNode = currNode;
                        currNode.next = tempNode;
                        currNode = prevNode;
                    }
                    else
                        nextNode = currNode;
                }
            }
            else if(currNode.val < x)
            {
                if(prevNode != null)
                {
                    tempNode = currNode.next;
                    currNode.next = head;
                    head = currNode;
                    prevNode.next = tempNode;
                    currNode = prevNode;
                    nextNode = head;
                }
                else
                {
                    nextNode = currNode;
                }
            }

            prevNode = currNode;
            currNode = currNode.next;
        }
        return head;
    }

    class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
