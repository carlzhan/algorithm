/*
根据条件分割数组
 */
public class SplitByStr {
    public static void main(String args[]) {
        int[] arr = {5, 2, -1, -3, 4, 10, 8, -2, 0};
        print(arr);
        splitByNum(0, arr);
        print(arr);
    }

    private static void splitByNum(int num, int[] arr) {
        int i = 0, j = arr.length - 1;
        int temp;
        while (i < j) {
            while (arr[i] < 0) {
                i++;
            }
            while (arr[j] > 0) {
                j--;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
