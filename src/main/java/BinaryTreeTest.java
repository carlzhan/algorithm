
public class BinaryTreeTest {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode mRootNode = new TreeNode(pre[preLeft]);
        for (int i = inLeft; i <= inRight; i++) {
            if (pre[preLeft] == in[i]) {
                mRootNode.left = reConstructBinaryTree(pre, preLeft + 1, preLeft + i, in, inLeft, i - 1);
                mRootNode.right = reConstructBinaryTree(pre, preLeft + 1 + i - inLeft, preRight, in, i + 1, inRight);
            }
        }
        System.out.print(mRootNode.val + " ");
        return mRootNode;
    }
}
