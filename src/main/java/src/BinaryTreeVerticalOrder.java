/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            result.add(temp);
            return result;
        }

        Map<Integer, ArrayList> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        int column = 0;
        q.offer(new Pair(root, column));
        while(!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            root= p.getKey();
            column = p.getValue();

            if (root != null) {
                if(!columnMap.containsKey(column)) {
                    columnMap.put(column, new ArrayList<>());
                }
                columnMap.get(column).add(root.val);

                q.offer(new Pair(root.left, column-1));
                q.offer(new Pair(root.right, column+1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(columnMap.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
        result.add(columnMap.get(k));
        }
        return result;
    }
}
