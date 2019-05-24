public class ReverseLinkedList {

    private static ListNode reverseLinkedList(ListNode pHead) {
        ListNode pre = null;
        ListNode cur = pHead;
        ListNode pReverseHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                pReverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pReverseHead;
    }


    public static class ListNode {
        ListNode next = null;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }


    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = null;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printLinkedList(node1);
        System.out.println(reverseLinkedList(node1).data);
        printLinkedList((node4));
    }

    private static void printLinkedList(ListNode head) {
        if (head != null) {
            System.out.print(head.data + "->");
        }
        while (head.next != null) {
            head = head.next;
            System.out.print(head.data + "->");
        }
        System.out.println();
    }


}
