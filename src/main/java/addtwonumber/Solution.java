package addtwonumber;

class Solution {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }
        return prev;
    }

    public String getNumber(ListNode head) {
        ListNode p = head;
        StringBuilder s = new StringBuilder();
        while (p != null) {
            s.append(p.val);
            p = p.next;
        }
        return s.toString();
    }

    public static String addTwoString(String s1, String s2){
        StringBuilder r = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();
        String farr ;
        String arr;
        if(n1 > n2){
            farr = s1;
            arr = s2;
        }else{
            farr = s2;
            arr = s1;
        }
        int carry = 0;
        for(int i = 0; i < farr.length();i++){
            int fx = 0, x = 0;
            fx = Integer.parseInt(Character.toString(farr.charAt(farr.length() -1 - i)));
            if(i < arr.length())
                x = Integer.parseInt(Character.toString(arr.charAt(arr.length() -1 - i)));
            int tsum = fx + x + carry;
            if(tsum < 10){
                r.insert(0, tsum);
                carry = 0;
            }
            else if(tsum == 10){
                if(i == farr.length() -1){
                    r.insert(0,"10");
                    carry = 0;
                }else{
                    carry = 1;
                    r.insert(0, "0");
                }
            }else {
                if(i == farr.length() -1){
                    r.insert(0, tsum);
                    carry = 0;
                }else{
                    r.insert(0, tsum - 10);
                    carry = 1;
                }
            }
        }
        return  r.toString();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode prev = null;

        String str = addTwoString(getNumber(r1), getNumber(r2));

        for(int i = 0; i < str.length() ; i++ ){
            prev = new ListNode(Integer.parseInt(Character.toString(str.charAt(i))),  prev);
        }

        return prev;
    }
}
