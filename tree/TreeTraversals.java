package tree;

import tree.traversals.IterativeTraversal;
import tree.traversals.MorrisTraversal;
import tree.traversals.RecursiveTraversal;

public class TreeTraversals {
    public static void main(String[] args) {
        TreeNode root = Tree.getTree();
        RecursiveTraversal.preorder(root);
        System.out.println();
        RecursiveTraversal.inorder(root);
        System.out.println();
        RecursiveTraversal.postorder(root);
        System.out.println();

        IterativeTraversal.preorder(root);
        System.out.println();
        IterativeTraversal.inorder(root);
        System.out.println();
        IterativeTraversal.postorder(root);
        System.out.println();

        MorrisTraversal.preorder(root);
        System.out.println();
        MorrisTraversal.inorder(root);
        System.out.println();
        MorrisTraversal.postorder(root);
        System.out.println();
    }
}
