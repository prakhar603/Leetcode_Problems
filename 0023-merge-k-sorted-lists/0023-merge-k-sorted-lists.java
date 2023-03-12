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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
       return partion(lists,0,lists.length-1);
}
    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }
    public static ListNode merge(ListNode node1, ListNode node2) {
        
        // ListNode h1 = node1 ; 
        // ListNode h2 = node2 ; 
        
        ListNode dummy = new ListNode(-1) ; 
        ListNode temp = dummy ; 
        
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                temp.next = new ListNode(node1.val) ; 
                temp = temp.next ; 
                node1 = node1.next ; 
            }
            else {
                temp.next = new ListNode(node2.val) ; 
                temp = temp.next ; 
                node2 = node2.next ; 
            }
        }
        if(node1 != null) {
            temp.next = node1 ; 
        }
        if(node2 != null) {
            temp.next = node2 ; 
        }
        return dummy.next ; 
    }
}