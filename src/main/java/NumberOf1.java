public class NumberOf1 {
    public static void main(String args[]) {
        System.out.println(numberOf2(11));
    }

    /**
     * 通过不断将1左移，并和num进行与操作得到的结果不等于0，则count++
     * @param num
     * @return
     */
    private static int numberOf1(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示
     * 中最右边的1变成0。直到将改数为0，循环结束
     * @param num
     * @return
     */
    private static int numberOf2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }
}
