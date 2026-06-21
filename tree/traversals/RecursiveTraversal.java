package tree.traversals;

import tree.TreeNode;

public class RecursiveTraversal {
    // ROOT, LEFT, RIGHT
    // Tc: O(n), Sc: O(h)
    public static void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // LEFT, ROOT, RIGHT
    // Tc: O(n), Sc: O(h)
    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // LEFT, RIGHT, ROOT
    // Tc: O(n), Sc: O(h)
    public static void postorder(TreeNode root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}