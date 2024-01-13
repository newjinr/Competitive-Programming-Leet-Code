package RemoveDuplicatesFromSortedListII;


public class RemoveDuplicatesFromSortedListII
{
    public RemoveDuplicatesFromSortedListII()
    {
        ListNode node = new ListNode(0);
        ListNode head = node;
        node.next = new ListNode(0);
        node = node.next;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
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

        deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null && cur.next != null)
        {
            if(cur.val != cur.next.val)
            {
                pre = cur;
                cur = cur.next;
            }
            else
            {
                while(cur.next != null && cur.next.val == cur.val)
                    cur = cur.next;

                if(pre != null)
                    pre.next = cur.next;
                else
                    head = cur.next;
                cur = cur.next;
            }
        }
        return head;
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
