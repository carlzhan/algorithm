public class IsSymmetrical {
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        BinaryTreeNode treeNode1 = new BinaryTreeNode(8);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(6);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(6);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(7);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(7);
        BinaryTreeNode treeNode7 = new BinaryTreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(isSymmetrical(treeNode1, treeNode1));
    }

    private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) return true; // 注意这个判断条件要在前面
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) { // 判断val不相等的话则返回false
            return false;
        }
        // 递归遍历原二叉树与镜像二叉树
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);

    }
}
