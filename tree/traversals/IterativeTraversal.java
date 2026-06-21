package tree.traversals;

import java.util.Stack;

import tree.TreeNode;

public class IterativeTraversal {
    /*
     * Preorder Traversal
     * ROOT, LEFT, RIGHT
     * Tc: O(n), Sc: O(h)
     */
    public static void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode front = stack.pop();
            System.out.print(front.data + " ");
            if (front.right != null)
                stack.push(front.right);
            if (front.left != null)
                stack.push(front.left);
        }
    }

    /*
     * Inorder Traversal
     * LEFT, ROOT, RIGHT
     * Tc: O(n), Sc: O(h)
     */
    public static void inorder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty())
                    break;
                TreeNode top = stack.pop();
                System.out.print(top.data + " ");
                cur = top.right;
            }
        }
    }

    /*
     * Postorder Traversal
     * LEFT, RIGHT, ROOT
     * Tc: O(n), Sc: O(h)
     */
    public static void postorder(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty())
                    break;
                TreeNode top = stack.peek();
                TreeNode right = top.right;
                /*
                 * right == null => Meaning there is no right subtree to visit
                 * right == prev => Meaning the right subtree is visited completely
                 * time to process the root.
                 */
                if (right == null || right == prev) {
                    System.out.print(top.data + " ");
                    prev = stack.pop();
                    cur = null;
                } else {
                    cur = right;
                }
            }
        }
    }
}
