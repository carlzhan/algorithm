public class IsNumeric {
    public static void main(String args[]) {
        String str = "2.0E1";
        System.out.println(isNumeric(str.toCharArray()));

    }

    /**
     * A.B e/E A
     * @param nums
     * @return
     */
    private static boolean isNumeric(char[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 记录nums的下标值
        int[] index = new int[1];
        //  判断A部分是否为整数
        boolean isNumeric = isInteger(nums, index);
        //  判断B部分
        if (index[0] < nums.length && nums[index[0]] == '.') {
            index[0]++;
            isNumeric = isUnsignedInteger(nums, index) || isNumeric;
        }
        // 判断e/E后面的A 部分
        if (index[0] < nums.length && (nums[index[0]] == 'e' || nums[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(nums, index) && isNumeric;
        }
        if (isNumeric && index[0] == nums.length) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isInteger(char[] nums, int[] index) {
        if (index[0] < nums.length && (nums[index[0]] == '+' || nums[index[0]] == '-')) {
            index[0]++;
        }
        return isUnsignedInteger(nums, index);
    }

    private static boolean isUnsignedInteger(char[] nums, int[] index) {
        int lastIndex = index[0];
        while (index[0] < nums.length && (nums[index[0]] - '0' >= 0 && nums[index[0]] - '0' <= 9)) {
            index[0]++;
        }
        return lastIndex < index[0];
    }


}
