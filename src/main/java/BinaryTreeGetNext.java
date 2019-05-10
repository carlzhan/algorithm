public class BinaryTreeGetNext {
    public static void main(String args[]) {
        getNext(new BinaryTreeNode(3));
    }

    private static BinaryTreeNode getNext(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        BinaryTreeNode mNext = null;
        // 有右子树
        if (treeNode.right != null) {
            BinaryTreeNode mRight = treeNode.right;
            while (mRight.left != null) {
                mRight = mRight.left;
            }
            mNext = mRight;
        }
        // 没有右子树
        else if (treeNode.parent != null) {
            BinaryTreeNode mCurNode = treeNode;
            BinaryTreeNode mParNode = mCurNode.parent;
            while (mParNode != null && mCurNode == mParNode.right) {
                mCurNode = mParNode;
                mParNode = mParNode.parent;
            }
            mNext = mParNode;
        }
        return mNext;
    }

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }
}
