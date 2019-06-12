public class BinaryTreeMirror {
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
        BinaryTreeNode treeNode3 = new BinaryTreeNode(10);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(7);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(9);
        BinaryTreeNode treeNode7 = new BinaryTreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        mirrorTree(treeNode1);
    }

    private static void mirrorTree(BinaryTreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        System.out.println(node.left.val+"   "+node.right.val);
        // 递归的方式遍历交换节点的子节点
        if (node.left != null)
            mirrorTree(node.left);
        if (node.right != null)
            mirrorTree(node.right);
    }
}
