package com.strings;



public class ReverseALinkedList {
public ListNode reverseList(ListNode head) {
        
        if(head == null)
            return null;
        
        ListNode temp = head;
        
        ListNode temp1= null;
        
        ListNode temp2 = null;
        
        
        while(temp != null){
       
            temp1 = new ListNode(temp.val);
              if(temp2 == null)
                  temp2 = temp1;
            else{
                temp1.next = temp2;
                temp2 = temp1;
            }
            temp = temp.next;
            
        }
   return temp1;     
    }
}
