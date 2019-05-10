public class MaxProductAfterCutting {
    public static void main(String args[]) {
        int cutting = maxProductWithGreedy(5);
        System.out.println(cutting);
    }

    private static int getMaxProductAfterCutting(int len) {
        int max = 0;
        if (len < 2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        //存储长度从 0-len 的最大结果
        int[] products = new int[len + 1];// 将最优解存储在数组中
        // 数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //自底向上开始求解
        for (int i = 4; i <= len; i++) { //i表示长度
            for (int j = 1; j <= len / 2; j++) {//由于长度i存在（1，i-1）和（i-1，1）的重复，所以只需要考虑前一种
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
            }
            products[i] = max;
        }
        max = products[len];
        return max;
    }

    public static int maxProductWithGreedy(int len) {
        if (len < 2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;
        //啥也不管,先尽可能减去长度为3的段
        int timeOfThree = len / 3;

        //判断还剩下多少，再进行处理
        if (len - timeOfThree * 3 == 1)
            timeOfThree -= 1;
        int timeOfTwo = (len - timeOfThree * 3) / 2;

        return (int) ((Math.pow(3, timeOfThree)) * (Math.pow(2, timeOfTwo)));
    }

}
