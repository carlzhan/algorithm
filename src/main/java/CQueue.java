import java.util.Stack;

/**
 * 两个栈实现队列
 * 添加队尾，输出队头
 */
public class CQueue {
    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();

    public static void main(String args[]) {
        appendTail(2);
        appendTail(5);
        appendTail(3);
        deleteHead();
        appendTail(6);
        deleteHead();
    }

    private static void appendTail(int element) {
        stack1.push(element);
    }

    private static Integer deleteHead() {
        Integer head = null;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer top = stack1.peek();
                stack1.pop();
                stack2.push(top);
            }
        }
        head = stack2.peek();
        stack2.pop();
        return head;
    }
}
