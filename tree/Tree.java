package tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {
    public static TreeNode buildTree(int root, Map<Integer, List<Integer>> tree) {
        List<Integer> children = tree.get(root);
        TreeNode newNode = new TreeNode(root);
        if (children == null || children.size() == 0)
            return newNode;

        newNode.left = buildTree(children.get(0), tree);
        newNode.right = buildTree(children.get(1), tree);
        return newNode;
    }

    public static TreeNode getTree(){
        Map<Integer,List<Integer>> tree = new HashMap<Integer,List<Integer>>();
        tree.put(1, List.of(2,3));
        tree.put(2, List.of(4,5));
        return buildTree(1, tree);
    }
}
