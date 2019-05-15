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

    public static ListNode delRepetition(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.data.equals(pNode.data))
                needDelete = true;
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.data;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.data == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                if (pPreNode == null)
                    pHead = pNext;
                else
                    pPreNode.next = pNext;
                pNode = pNext;
            }
        }
        return pHead;

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

    public static ListNode deleteDuplication_1(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode preNode = null;
        ListNode node = pHead;
        ListNode postNode = null;
        boolean needDel = false;

        while (node != null) {
            // 如果node不是最后一个节点
            if (node.next != null) {
                postNode = node.next;
                //postNode为null或者val与node.val不同的第一个节点
                while (postNode != null && postNode.data == node.data) {
                    postNode = postNode.next;
                    needDel = true;
                }
            } else
                //到链表结尾
                postNode = null;
            // 如果node和postNode不同，即不需要进行删除操作
            if (!needDel) {
                //如果第一个元素为空
                if (preNode == null) {
                    preNode = node;
                    pHead = preNode;
                } else {
                    preNode.next = node;
                    preNode = node;
                }
                node = postNode;
            } else {
                node = postNode;
                needDel = false;
                if (postNode == null && preNode != null)
                    preNode.next = null;
            }
        }
        return preNode == null ? null : pHead;
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(6);
        ListNode node7 = null;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        printListNode(node1);
        System.out.println(deleteDuplication_1(node1));
        printListNode(node1);
    }

}
