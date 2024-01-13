package ReverseLinkedListII;


public class ReverseLinkedListII
{
    public ReverseLinkedListII()
    {
        ListNode node = new ListNode(3);
        ListNode head = node;
        node.next = new ListNode(5);
//        node = node.next;
//        node.next = new ListNode(3);
//        node = node.next;
//        node.next = new ListNode(4);
//        node = node.next;
//        node.next = new ListNode(5);
//        node = node.next;
//        node.next = new ListNode(6);

        reverseBetween(head, 1, 2);
    }

    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        if(head.next == null) return head;
        int i = 1;
        ListNode currentNode = head;
        ListNode previousNode = null;
        while (currentNode != null && i != left)
        {
            previousNode = currentNode;
            currentNode = currentNode.next;
            ++i;
        }

        if(currentNode == null) return head;

        if(i == right) return head;

        ListNode leftNode = currentNode;
        ListNode nextReversibleNode = currentNode;
        currentNode = currentNode.next;

        while(currentNode!=null)
        {
            ListNode tempNode = currentNode.next;
            currentNode.next = nextReversibleNode;
            nextReversibleNode = currentNode;
            leftNode.next = tempNode;
            if(++i == right) break;
            currentNode = tempNode;
        }

        if(previousNode!=null)
        {
            previousNode.next = nextReversibleNode;
            return head;
        }

        return nextReversibleNode;
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
