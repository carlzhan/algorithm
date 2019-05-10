import java.util.Stack;

public class LinkListTest {
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
        addNode(node1, 6);
        addNode(node1, 7);
        printLinkedList(node1);
//        printListFromTailToHead(node1);
        printListFromTailToHeadByStack(node1);
    }

    /**
     * 栈实现 先入后出
     * @param head
     */
    private static void printListFromTailToHeadByStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.data);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    /**
     * 递归遍历逆序打印
     *
     * @param head
     */
    private static void printListFromTailToHead(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                printListFromTailToHead(head.next);
            }
            System.out.print(head.data);
        } else {

        }
    }

    private static void addNode(ListNode head, int data) {
        if (head == null) {
            return;
        }
        ListNode newNode = new ListNode(data);
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
    }

    private static void printLinkedList(ListNode head) {
        if (head != null) {
            System.out.print(head.data + "->");
        }
        while (head.next != null) {
            head = head.next;
            System.out.print(head.data + "->");
        }
    }

}
