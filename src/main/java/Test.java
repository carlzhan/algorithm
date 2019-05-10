public class Test {
    public static void main(String args[]) {
//        int arr[] = {2, 5, 12, 7, 17, 25, 19, 36, 99, 22, 28, 46, 92};
        char arr[] = {'{', '{', '{', '}', '}', '}', '{', '{'};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println(checkarith("--+123-13*8"));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static boolean checkarith(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        int count = 0;
        if (isArith(chars[index])) {
            return false;
        }
        while (index < chars.length) {

            if (isArith(chars[index])) {
                count++;
            } else {
                count--;
            }
            index++;
            if (count < 0) {
                count = 0;
            } else if (count > 1) {
                return false;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isArith(char aChar) {
        return aChar == '+' || aChar == '-' || aChar == '*' || aChar == '/';
    }

    private static void checkhuiwen(char[] arr) {
        int top = 0;
        int index = 0;
        while (index < arr.length) {
            if (top == 0 && arr[index] == '}') return;
            if (arr[index] == '{') {
                top++;
            } else {
                top--;
            }
            index++;
        }
        if (top == 0) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

    private static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private static void heapSort(int[] arr) {
        int temp;
        int len = arr.length - 1;
        while (len >= 0) {
            temp = arr[0];
            arr[0] = arr[len];
            arr[len] = temp;
            siftDown(0, arr, len);
            len--;
        }
    }

    private static void create(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            siftDown(i, arr, len);
        }
    }

    private static void siftDown(int i, int arr[], int len) {
        int t, flag = 0, temp;
        while (2 * i + 1 < len && flag == 0) { // 有左节点
            if (arr[i] > arr[2 * i + 1]) {
                t = 2 * i + 1;
            } else {
                t = i;
            }
            if (2 * i + 2 < len) {   //  有右节点
                if (arr[t] > arr[2 * i + 2]) {    //    判断右节点大小
                    t = 2 * i + 2;
                }
            }

            if (t != i) {
                temp = arr[t];
                arr[t] = arr[i];
                arr[i] = temp;
                i = t;  //  重置起点
            } else {
                flag = 1;
            }
        }
    }

    private static void insertLink(int[] arr, int insert) {

        int right[] = new int[arr.length];  // 1,2,3,4,5,6,7,8
        for (int i = 0; i < arr.length; i++) {
            right[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[right[i]] > insert) {  //获取到当前值得下一个数

            }
        }

    }

    public static void quiteSort(int[] arr, int left, int right) {
        int temp, i, j, t;
        if (left > right) {
            return;
        }
        temp = arr[left];
        i = left;
        j = right;
        while (i != j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quiteSort(arr, left, i - 1);
        quiteSort(arr, i + 1, right);
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void queue(int[] arr, int len) {
        int head = 0;
        int tail = 8;
        while (head < tail) {
            System.out.print(arr[head]);
            head++;
            arr[tail] = arr[head];
            head++;
            tail++;
        }
    }

    static int[] a = new int[10];
    static int[] book = new int[10];
    static int n = 3; // _ _ _ + _ _ _ = _ _ _
    static int count = 0;

    public static void dfs(int step) {
        if (step == n + 1) {
//            if (_ _ _ + _ _ _ = _ _ _)
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("_________" + ++count);
            return;
        }
        // 遍历出所有情况
        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                a[step] = i;
                book[i] = 1;
                dfs(step + 1);
                book[i] = 0;
            }
        }
        return;
    }

    public static void siftDown1(int i) {
        int arr[] = {23, 2, 5, 12, 7, 17, 25, 19, 36, 99, 22, 28, 46, 92};

        int t, flag = 0;
        int len = arr.length;
        int temp;
        // 至少有左节点,是二叉树
        while (i * 2 + 1 < len && flag == 0) {
            if (arr[i] > arr[i * 2 + 1]) {
                t = i * 2 + 1;
            } else {
                t = i;
            }
            // 如果有右子树
            if (i * 2 + 2 <= len) {
                if (arr[t] > arr[i * 2 + 2]) {
                    t = i * 2 + 2;
                }
            }
            if (t != i) {
                temp = arr[t];
                arr[t] = arr[i];
                arr[i] = temp;
                i = t;
            } else {
                flag = 1;
            }
        }
        for (int j = 0; j < len; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    private static void swap(int t, int i) {


    }
}
