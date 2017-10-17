package cn.zxd.introduction;

public class Acm021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){    // 初始化输入。可能 l1 l2 是空指针
            if(l1!=null){
                return l1;
            }else {
                return l2;
            }
        }
        int init = 0;
        if(l1.val<l2.val){
            init = l1.val;
            l1 = l1.next;
        }else {
            init = l2.val;
            l2 = l2.next;
        }
        ListNode l3 = new ListNode(init);
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    l3.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else {
                    l3.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }else if(l1==null&&l2!=null){
                l3.next = l2;
            }else if(l1!=null&&l2==null){
                l3.next = l1;
            }
        }
        return l3;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
