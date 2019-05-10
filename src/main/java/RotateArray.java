public class RotateArray {
    public static void main(String args[]) {
        int[] arr = {3, 5, 6, 1, 2};
        int num = getMinFromRotateArray(arr);
        System.out.println(num + " __ ");
    }

    private static int getMinFromRotateArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (arr[left] >= arr[right] && right - left != 1) {

            int minIndex = (left + right) / 2;
            if (arr[minIndex] >= arr[left]) {
                left = minIndex;
            } else if (arr[minIndex] <= arr[right]) {
                right = minIndex;
            }
        }


        return arr[right];
    }
}
