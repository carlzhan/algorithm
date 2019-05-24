public class FindKTotail {
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
        int data;
        ListNode kToTail = findKToTail(0, node1);
        if (kToTail != null) {
            data = kToTail.data;
            System.out.print(data);
        } else {
            System.out.println("can not find k");
        }
    }

    private static ListNode findKToTail(int k, ListNode head) {
        if (head == null || k == 0) {   // 边界值
            return null;
        }
        ListNode pAhead = head;
        ListNode pBhead = head;
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null) {   // 边界值
                pAhead = pAhead.next;
            } else {
                return null; // 边界值
            }
        }
        while (pAhead.next != null) {
            pBhead = pBhead.next;
            pAhead = pAhead.next;
        }
        return pBhead;
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
