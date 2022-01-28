package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Leet1350 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> es1 = new LinkedList<>(), es2 = new LinkedList<>();
        dfs(root1, es1);
        dfs(root2, es2);
        return mergeList(es1, es2);
    }

    private void dfs(TreeNode tn, List<Integer> elements){
        if(tn == null){
            return;
        }

        dfs(tn.left, elements);
        elements.add(tn.val);
        dfs(tn.right, elements);
    }

    private List<Integer> mergeList(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new LinkedList<>();
        while (!list1.isEmpty() && ! list2.isEmpty()){
            int first1 = list1.get(0), first2 = list2.get(0);

            if(first1 < first2){
                result.add(list1.remove(0));
            }else {
                result.add(list2.remove(0));
            }
        }

        while (!list1.isEmpty()){
            result.add(list1.remove(0));
        }

        while (!list2.isEmpty()){
            result.add(list2.remove(0));
        }

        return result;
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
