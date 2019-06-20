package divideAndConquer;

/**
 * 字符串排列
 * 打印结果：
 * acb
 * bac
 * bca
 * cba
 * cab
 */
public class StringArrangement {
    public static void main(String args[]) {
        String str = "abc";
        char[] chars = str.toCharArray();
        int mBegin = 0;
        stringArrangement(chars, mBegin);
    }

    private static void stringArrangement(char[] chars, int mBegin) {
        if (chars == null || chars.length <= 0) {
            return;
        }
        if (mBegin >= chars.length) {
            return;
        }
        for (int i = mBegin; i < chars.length; i++) {
            char temp = chars[mBegin];
            chars[mBegin] = chars[i];
            chars[i] = temp;

            if (chars[mBegin] != chars[i]){
                for (int j = 0; j < chars.length; j++) {
                    System.out.print(chars[j]);
                }
                System.out.println();
            }
            stringArrangement(chars, mBegin + 1);

            temp = chars[mBegin];
            chars[mBegin] = chars[i];
            chars[i] = temp;
        }

    }
}
