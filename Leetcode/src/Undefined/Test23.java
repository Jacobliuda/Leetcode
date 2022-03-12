package Undefined;

/**
 * @author Jacob
 * @creator 2022/3/12-20:41
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Test23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)   return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        if(lists.length == 0)   return null;
        for(ListNode node: lists){
            if(node != null)
                heap.offer(node);
        }

        while(heap!=null){
            ListNode poll = heap.poll();
            curr.next = poll;
            curr = curr.next;
            if(poll.next!=null)
                heap.offer(poll.next);
        }

        return dummyNode.next;


    }
}
