package RemoveNthNode;

public class RemoveNthNode
{
    public RemoveNthNode()
    {
        int[] num = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = null;
        ListNode temp = null;

        for(int i=0; i< num.length; ++i)
        {
            if(listNode == null)
            {
                listNode = new ListNode(num[i]);
                temp = listNode;
                continue;
            }
            temp.next = new ListNode(num[i]);
            temp = temp.next;
        }
        System.out.println(removeNthFromEnd(listNode, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode ans = head;
        ListNode nthNode = head;
        ListNode prevNode = null;

        while (head != null)
        {
            if(n-- > 0)
            {
                head = head.next;
                continue;
            }

            prevNode = nthNode;
            nthNode = nthNode.next;
            head = head.next;
        }

        if(prevNode == null) return ans.next;
        prevNode.next = nthNode.next;
        return ans;
    }

    public class ListNode
    {
      int val;
      ListNode next;
      ListNode()
      {

      }
      ListNode(int val)
      {
          this.val = val;
      }
      ListNode(int val, ListNode next)
      {
          this.val = val;
          this.next = next;
      }
    }
}
