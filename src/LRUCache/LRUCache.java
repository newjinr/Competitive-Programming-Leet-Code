package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    private int capacity = 0;
    private int currentSize = 0;
    ListNode rightNode = null;
    ListNode leftNode = null;
    Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if(map.containsKey(key))
        {
            ListNode currentNode = map.get(key);
            performLRUswap(currentNode);
            return currentNode.val;
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            ListNode currentNode = map.get(key);
            currentNode.val = value;
            performLRUswap(currentNode);
        }
        else
        {
            if(capacity == currentSize)
            {
                map.remove(leftNode.key);
                leftNode = leftNode.next;
                if(leftNode != null) leftNode.prev = null;
                addNewNode(key, value);
            }
            else
            {
                addNewNode(key, value);
                currentSize++;
            }
        }
    }

    private void addNewNode(int key, int value)
    {
        if(leftNode == null)
        {
            leftNode = new ListNode(key, value);
            rightNode = leftNode;
        }
        else
        {
            rightNode.next = new ListNode(key, value);
            rightNode.next.prev = rightNode;
            rightNode = rightNode.next;
        }
        map.put(key, rightNode);
    }

    private void performLRUswap(ListNode currentNode)
    {
        if(currentNode.next == null) return;
        if(currentNode.prev == null)
        {
            currentNode.next.prev = null;
            leftNode = currentNode.next;
        }
        else
        {
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
        }
        rightNode.next = currentNode;
        currentNode.prev = rightNode;
        currentNode.next = null;
        rightNode = currentNode;
    }

    class ListNode
    {
        int val;
        int key;
        ListNode next = null;
        ListNode prev = null;

        ListNode(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
}
