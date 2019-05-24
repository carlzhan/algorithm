public class MergeLinkedList {
    public static class ListNode {
        ListNode next = null;
        int val;

        private ListNode(int data) {
            this.val = data;
        }
    }


    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.val < head2.val){
            mergeHead = head1;
            mergeHead.next = merge(head1.next,head2);
        }else {
            mergeHead = head2;
            mergeHead.next = merge(head1,head2.next);
        }
        return mergeHead;
    }


    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = null;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printLinkedList(node1);

        ListNode node01 = new ListNode(2);
        ListNode node02 = new ListNode(4);
        ListNode node03 = new ListNode(6);
        ListNode node04 = new ListNode(8);
        ListNode node05 = null;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        printLinkedList(node01);

        printLinkedList(merge(node1,node01));

    }

    private static void printLinkedList(ListNode head) {
        if (head != null) {
            System.out.print(head.val + "->");
        }
        while (head.next != null) {
            head = head.next;
            System.out.print(head.val + "->");
        }
        System.out.println();
    }
}
