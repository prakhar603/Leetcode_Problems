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

/*
* For an even size linked list, if you want to halt at 1st occurance of middle, take fast.next != null && fast.next.next != null
* For an even size linked list, if you want to halt at 2nd occurance of middle, take fast != null && fast.next != null
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) return true ; 
        
        ListNode slow = head ; 
        ListNode fast = head ; 
        
       // ListNode temp = null ; 
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        
        ListNode rev = reverse(slow.next) ;  
        
        ListNode node = head ; 
        
     //  System.out.println(rev.val) ; 
        
        while(rev!=null) {
            
          //  System.out.println("Executing....") ; 
            
            if(node.val != rev.val) {
                return false ; 
            }
            rev = rev.next ; 
            node = node.next ; 
        }
        return true ; 
    }
    public ListNode reverse(ListNode node) {
        
        ListNode prev = null ; 
        ListNode curr = node ; 
        
        while(curr != null) {
            ListNode next = curr.next ; 
            curr.next = prev ; 
            prev = curr ; 
            curr = next ; 
        }
        return prev ; 
    }
}