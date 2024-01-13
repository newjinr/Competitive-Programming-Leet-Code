package MergeTwoSortedList;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList
{
    public MergeTwoSortedList()
    {
        ListNode head = new ListNode(1);
        ListNode list1 = head;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);

        ListNode head2 = new ListNode(2);
        ListNode list2 = head2;
        head2.next = new ListNode(5);
        head2 = head2.next;
        head2.next = new ListNode(6);

        ListNode ans = mergeTwoLists(new ListNode(), new ListNode());

        while(ans != null)
        {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode result = null;
        ListNode head = null;

        while(list1 != null || list2 != null)
        {
            if(list1 != null && list2 != null)
            {
                if(list1.val < list2.val)
                {
                    if(head == null)
                    {
                        head = new ListNode(list1.val);
                        result = head;
                    }
                    else
                    {
                        result.next = new ListNode(list1.val);
                        result = result.next;
                    }
                    list1 = list1.next;
                }
                else
                {
                    if(head == null)
                    {
                        head = new ListNode(list2.val);
                        result = head;
                    }
                    else
                    {
                        result.next = new ListNode(list2.val);
                        result = result.next;
                    }
                    list2 = list2.next;
                }
                continue;
            }

            while (list1 != null)
            {
                if(head == null)
                {
                    head = new ListNode(list1.val);
                    result = head;
                }
                else
                {
                    result.next = new ListNode(list1.val);
                    result = result.next;
                }
                list1 = list1.next;

            }

            while(list2 != null)
            {
                if(head == null)
                {
                    head = new ListNode(list2.val);
                    result = head;
                }
                else
                {
                    result.next = new ListNode(list2.val);
                    result = result.next;
                }
                list2 = list2.next;
            }
        }

        return head;
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
          this.val = val; this.next = next;
      }
  }
}
