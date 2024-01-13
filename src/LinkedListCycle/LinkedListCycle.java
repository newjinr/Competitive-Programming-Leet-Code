package LinkedListCycle;

public class LinkedListCycle
{
    public LinkedListCycle()
    {
        ListNode head;
        ListNode cycleNode;
        ListNode listNode = new ListNode(3);
        head = listNode;
//        ListNode currentNode = head;
//        listNode = new ListNode(2);
//        currentNode.next = listNode;
        cycleNode = listNode;
//        currentNode = listNode;
//        listNode = new ListNode(0);
//        currentNode.next = listNode;
//        currentNode = listNode;
//        listNode = new ListNode(-4);
//        currentNode.next = listNode;
        listNode.next = cycleNode;

        System.out.println(hasCycle(head));
    }

    public boolean hasCycle(ListNode head)
    {
        ListNode tortoise = head;
        while(head != null && head.next != null)
        {
            if(head.next.next != null && tortoise.next == head.next.next)
                return true;
            tortoise = tortoise.next;
            head = head.next.next;
        }
        return false;
    }

    class ListNode
    {
      int val;
      ListNode next;
      ListNode(int x)
      {
          val = x;
          next = null;
      }
  }
}
