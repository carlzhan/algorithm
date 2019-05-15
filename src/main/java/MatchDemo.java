public class MatchDemo {
    public static void main(String args[]) {
        String str = "aaa";
        String pattern = "a.*.";
        if (str == null || pattern == null) {
            return;
        }
        char[] strArr = str.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int strIndex = 0;
        int patternIndex = 0;
        System.out.println(match(strArr, strIndex, patternArr, patternIndex));
    }

    private static boolean match(char[] strArr, int strIndex, char[] patternArr, int patternIndex) {
        if (strIndex == strArr.length && patternIndex == patternArr.length) return true;

        // 如果模式到尾 字符串没到尾 返回false
        if (strIndex != strArr.length && patternIndex == patternArr.length) return false;

        // 模式第二个为'*'
        if ((patternIndex + 1 < patternArr.length) && patternArr[patternIndex + 1] == '*') {
            if ((strIndex != strArr.length && (strArr[strIndex] == patternArr[patternIndex]) || (strIndex != strArr.length && patternArr[patternIndex] == '.'))) {
                return match(strArr, strIndex, patternArr, patternIndex + 2)
                        || match(strArr, strIndex + 1, patternArr, patternIndex + 2)
                        || match(strArr, strIndex, patternArr, patternIndex);
            }else {
                return match(strArr, strIndex, patternArr, patternIndex + 2);
            }
        }

        // 当前匹配 或 模式为'.'
        if (strIndex != strArr.length && (strArr[strIndex] == patternArr[patternIndex] || patternArr[patternIndex] == '.')) {
            return match(strArr, strIndex + 1, patternArr, patternIndex + 1);
        } else {
            return false;
        }
    }
}
