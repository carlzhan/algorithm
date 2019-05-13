public class DeleteListNode {
    static class ListNode {
        public Integer data;
        public ListNode next;

        ListNode(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    // 时间复杂度为O(1)的方式
    public static void delNode(ListNode headNode, ListNode delNode) {
        if (headNode == null || delNode == null) {
            return;
        }
        if (delNode.next != null) {    //  如果不是尾节点
            ListNode nextNode = delNode.next;
            delNode.data = nextNode.data;
            delNode.next = nextNode.next;
        } else if (delNode == headNode) {     //  如果只有一个节点
            headNode.setData(null);
            delNode.setData(null);
        } else {     //  如果是尾节点
            ListNode node = headNode;
            while (node.next != delNode) {
                node = node.next;
            }
            node.next = null;
        }
    }

    public static void printListNode(ListNode headNode) {
        ListNode node = headNode;
        while (node != null && node.getData() != null) {
            System.out.print(node.data + "->");
            if (node.next == null)
                System.out.print("null");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = null;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        printListNode(node1);
        delNode(node1, node3);
        printListNode(node1);
    }

}
