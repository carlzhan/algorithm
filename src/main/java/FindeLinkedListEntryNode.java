public class FindeLinkedListEntryNode {
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
        node4.next = node3;
//        printLinkedList(node1);
        System.out.println(EntryNodeOfLoop(node1).data);
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

    private static ListNode meetingNode(ListNode head) {
        if (head == null) return null;
        ListNode slowNode = head;
        ListNode fastNode = slowNode.next;
        if (fastNode == null) return null;
        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }

        return null;
    }
    private static ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode==null){
            return null;
        }
        int nodeNum = 1;
        ListNode pNode1= meetingNode;
        while (pNode1.next!=null && pNode1.next!=meetingNode){
            nodeNum++;
            pNode1 = pNode1.next;
        }
        // 算出环节点个数 nodeNum
        System.out.println("环节点个数："+nodeNum);
        pNode1 = pHead;
        for (int i = 0; i < nodeNum; i++) {
            pNode1 = pNode1.next;
        }
        ListNode pNode2 = pHead;
        while (pNode1!=pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}
