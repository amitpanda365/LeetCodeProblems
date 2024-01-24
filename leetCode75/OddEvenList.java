/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *     Input: head = [2,1,3,5,6,4,7]
 *     Output: [2,3,6,7,1,5,4]
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ArrayList<ListNode> al = new ArrayList<ListNode>();
        ListNode p = head;
        int size = 0;
        while(p != null){
            al.add(p);
            p = p.next;
            size++;
        }
        p = head;
        for(int i=1; i<size; i++){
            if(i%2 == 0){
                p.next = al.get(i);
                p = p.next;
            }
        }
        int e = 1;
        for(int i=size/2+1; i<size; i++){
            p.next = al.get(e);
            p = p.next;
            e +=2;
        }
        if(size%2 == 0){
            p.next = al.get(e);
            p = p.next;
        }
        p.next = null;
        return head;
    }
}
