package swappair;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class Solution {
    public static class ListNode {
        Integer val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head.val == 0) return new ListNode();
        if (head.next == null) return head;
        ListNode tmp = head;
        ListNode tmp2 ;
        ListNode res = tmp.next;
        while(tmp != null){
            if(tmp.next != null && tmp.next.next != null) tmp2 = tmp.next.next;
            else tmp2 = null;
            if(tmp2 != null) {
                ListNode next = tmp.next;
                if(next.next.next != null) tmp.next = next.next.next;
                else tmp.next = next.next;
                next.next = tmp;
            }else{
                ListNode next = tmp.next;
                tmp.next = null;
                if(next != null) next.next = tmp;
                else break;
            }
            tmp = tmp2;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
