/**
 * 搜索二叉树转换双向链表的重点在于：
 * 1、将二叉树分成3部分：左子树，根，右子树
 * 2、将根的左指针指向左子树的lastNode
 * 3、左子树的lastNode的右指针指向根节点
 * 4、lastNode更新为根节点
 * 5、从根节点的右节点再次递归
 */
public class BinaryTreeToLink {
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        BinaryTreeNode treeNode1 = new BinaryTreeNode(10);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(6);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(14);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(8);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(12);
        BinaryTreeNode treeNode7 = new BinaryTreeNode(16);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = null;
        treeNode4.right = null;
        treeNode5.left = null;
        treeNode5.right = null;
        treeNode6.left = null;
        treeNode6.right = null;
        treeNode7.left = null;
        treeNode7.right = null;

        BinaryTreeNode lastNode = binaryTreeToLink(treeNode1,null);
        printLink(lastNode);
    }

    private static void printLink(BinaryTreeNode lastNode) {
        while (lastNode != null && lastNode.left != null) {
            System.out.println(lastNode.val);
            lastNode = lastNode.left;
        }
    }

    private static BinaryTreeNode binaryTreeToLink(BinaryTreeNode rootNode, BinaryTreeNode lastNode) {
        if (rootNode == null) {
            return lastNode;
        }
        if (rootNode.left != null) {
            lastNode = binaryTreeToLink(rootNode.left, lastNode);
        }
        rootNode.left = lastNode;
        if (lastNode != null) {
            lastNode.right = rootNode;
        }
        lastNode = rootNode;
        if (rootNode.right != null) {
            lastNode = binaryTreeToLink(rootNode.right, lastNode);
        }
        return lastNode;
    }
}
