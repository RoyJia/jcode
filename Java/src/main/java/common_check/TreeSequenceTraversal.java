package common_check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeSequenceTraversal {
    static List<List<Integer>> list = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(bestWay(root).toString());

        System.out.println("------------------------");

        System.out.println(levelOrder(root).toString());

        System.out.println("------------------------");

        TreeNode var = root;

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(var.val));
        printChildNode(var, map, 1);

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        System.out.println("------------------------");
        System.out.println(result.toString());
    }

    static void printChildNode(TreeNode node, Map<Integer, List<Integer>> map, int index) {
        if (node == null) return;
        
        if (node.left != null) {
            if (!map.containsKey(index)) map.put(index, new ArrayList<>());
            System.out.println(node.left.val);
            map.get(index).add(node.left.val);
        }
        
        if (node.right != null) {
            if (!map.containsKey(index)) map.put(index, new ArrayList<>());
            System.out.println(node.right.val);
            map.get(index).add(node.right.val);
        }
        index++;

        if (node.left != null && (node.left.left != null || node.left.right != null)) printChildNode(node.left, map, index);
        if (node.right != null && (node.right.left != null || node.right.right != null)) printChildNode(node.right, map, index);
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> currentList = new ArrayList<>();
            for (int i=0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                currentList.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentList);
        }

        return result;
    }

    // the best way I think
    static List<List<Integer>> bestWay(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        
        return list;
    }

    static void helper(List<List<Integer>> result, TreeNode node, int depth) {
        if (node == null) return;
        
        if (list.size() == depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth).add(node.val);

        if (node.left != null) helper(result, node.left, depth+1);
        if (node.right != null) helper(result, node.right, depth+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}