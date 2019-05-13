public class Print1ToMax {
    public static void main(String args[]) {
        print1ToMaxOfNDigits(3);

    }

    private static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }
        // 第一种，判断自增是否越界打印
        while (!increment(num)) {
            printNum(num);
        }
        // 第二种，递归遍历每一个数
        for (int i = 0; i < 10; i++) {
            num[0] = (char) ('0' + i);
            print1ToMaxOfNDigits2(num, n, 0);
        }
    }

    private static void print1ToMaxOfNDigits2(char[] num, int n, int index) {
        if (index == n - 1) {
            printNum(num);
            // 注意: 打印结束后要return
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index + 1] = (char) ('0' + i);
            print1ToMaxOfNDigits2(num, n, index + 1);
        }
    }

    private static void printToMaxOfNDigitsRecursively(char[] num, int n, int index) {
        if (index == n - 1) {
            printNum(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(num, n, index + 1);
        }
    }

    private static void printNum(char[] num) {
        // 打印注意不打印0开头的无效数字
        boolean isBegin = true;
        int len = num.length;
        for (int i = 0; i < len; i++) {
            if (isBegin && num[i] != '0') {
                isBegin = false;
            }
            if (!isBegin) {
                System.out.print(num[i]);
            }
        }
        System.out.println();
    }

    private static boolean increment(char[] num) {
        boolean isOverflow = false; // 是否超过最大数
        int mTakeOver = 0;  // 进位值
        for (int i = num.length - 1; i >= 0; i--) {
            // 如果末位上的数值自加1并加上进位置 的和不小于10，那么需要循环进位，原位上的值为sum-10
            int sum = num[i] - '0' + mTakeOver;
            if (i == num.length - 1) {       //  末位上的数值自加1
                sum++;
            }
            // 判断每位数值是否不小于10
            if (sum >= 10) {
                if (i == 0) {        // 最高位如果大于10 则超过最大值
                    isOverflow = true;
                } else {
                    sum -= 10;
                    mTakeOver = 1;
                    num[i] = (char) ('0' + sum);
                }
            } else {
                num[i] = (char) ('0' + sum);
                break;
            }
        }
        return isOverflow;
    }
}
