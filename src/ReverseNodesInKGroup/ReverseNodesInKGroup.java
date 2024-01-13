package ReverseNodesInKGroup;

public class ReverseNodesInKGroup
{
    public ReverseNodesInKGroup()
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

        reverseKGroup(head, 1);
    }

    public ListNode reverseKGroup(ListNode head, int k)
    {
        if(k==1) return head;
        ListNode headNode = head;
        ListNode nodeToJoin = null;

        int count = 0;
        while (headNode != null)
        {
            count++;
            headNode = headNode.next;
        }

        count = count/k;
        headNode = head;

        while(count-- > 0)
        {
            int n = k;
            ListNode leftNode = head;
            ListNode previousNode = null;

            while(n-- > 0)
            {
                if(previousNode == null)
                {
                    previousNode = head;
                    head = head.next;
                }
                else
                {
                    if(head != null)
                    {
                        ListNode tempNode = head.next;
                        head.next = previousNode;
                        previousNode = head;
                        leftNode.next = tempNode;
                        head = tempNode;
                    }
                    else
                    {
                        head = previousNode;
                        leftNode = head;
                        previousNode = null;
                        n = k-n-1;
                    }
                }

                if(nodeToJoin == null)
                    headNode = previousNode;
                else
                    nodeToJoin.next = previousNode;
            }

            nodeToJoin = leftNode;
        }


        return headNode;
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
