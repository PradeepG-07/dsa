package tree.traversals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.TreeNode;

public class MorrisTraversal {
    /*
     * Preorder Traversal
     * ROOT, LEFT, RIGHT
     * Tc: O(n), Sc: O(1)
     */
    public static void preorder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                System.out.print(cur.data + " ");
                cur = cur.right;
                continue;
            }

            TreeNode leftSubTreeRightMost = left;
            while (leftSubTreeRightMost.right != null && leftSubTreeRightMost.right != cur) {
                leftSubTreeRightMost = leftSubTreeRightMost.right;
            }

            // No Thread found, so create one thread and start traversing left sub tree
            if (leftSubTreeRightMost.right == null) {
                System.out.print(cur.data + " ");
                leftSubTreeRightMost.right = cur;
                cur = cur.left;
            }

            // Thread already exists, meaning left subtree is traversed completely,
            // break the thread and start traversing right subtree
            if (leftSubTreeRightMost.right == cur) {
                leftSubTreeRightMost.right = null;
                cur = cur.right;
            }
        }
    }

    /*
     * Inorder Traversal
     * LEFT, ROOT, RIGHT
     * Tc: O(n), Sc: O(1)
     */
    public static void inorder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                System.out.print(cur.data + " ");
                cur = cur.right;
                continue;
            }

            TreeNode leftSubTreeRightMost = left;
            while (leftSubTreeRightMost.right != null && leftSubTreeRightMost.right != cur) {
                leftSubTreeRightMost = leftSubTreeRightMost.right;
            }

            // No Thread found, so create one thread and start traversing left sub tree
            if (leftSubTreeRightMost.right == null) {
                leftSubTreeRightMost.right = cur;
                cur = cur.left;
            }

            // Thread already exists, meaning left subtree is traversed completely,
            // break the thread and start traversing right subtree
            if (leftSubTreeRightMost.right == cur) {
                System.out.print(cur.data + " ");
                leftSubTreeRightMost.right = null;
                cur = cur.right;
            }
        }
    }

    /*
     * Postorder Traversal
     * It is difficult to implement the postorder traversal directly
     * in morris traversal. So we can do traversal for ROOT, RIGHT, LEFT
     * and reverse the result such that we get LEFT, RIGHT, ROOT
     * LEFT, RIGHT, ROOT
     * Tc: O(n), Sc: O(1)
     */
    public static void postorder(TreeNode root) {
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<>();
        while (cur != null) {
            TreeNode right = cur.right;
            if (right == null) {
                ans.add(cur.data);
                cur = cur.left;
                continue;
            }

            TreeNode rightSubTreeLeftMost = right;
            while (rightSubTreeLeftMost.left != null && rightSubTreeLeftMost.left != cur) {
                rightSubTreeLeftMost = rightSubTreeLeftMost.left;
            }

            // No Thread found, so create one thread and start traversing left sub tree
            if (rightSubTreeLeftMost.left == null) {
                ans.add(cur.data);
                rightSubTreeLeftMost.left = cur;
                cur = cur.right;
            }

            // Thread already exists, meaning left subtree is traversed completely,
            // break the thread and start traversing right subtree
            if (rightSubTreeLeftMost.left == cur) {
                rightSubTreeLeftMost.left = null;
                cur = cur.left;
            }
        }
        Collections.reverse(ans);
        ans.stream().forEach(x -> System.out.print(x+" "));
    }
}
