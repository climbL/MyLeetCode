public class _437_路径总和III {

    public class TreeNode {
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

    /**
     * dfs搜索，复杂度O(n^2)
     */
    class Solution {
        public int ans = 0;
        public int targetSum;

        public int pathSum(TreeNode root, int _targetSum) {
            targetSum = _targetSum;
            dfs1(root);
            return ans;
        }

        public void dfs1(TreeNode root) {       // 遍历所有节点
            if (root == null) {
                return;
            }
            dfs2(root, root.val);
            dfs1(root.left);
            dfs1(root.right);
        }

        public void dfs2(TreeNode root, int val) {  // 对于该节点，计算该节点下所有的路径和，如果路径和等于target，ans++
            if (val == targetSum) {
                ans++;
            }
            if (root.left != null) {
                dfs2(root.left, val + root.left.val);
            }
            if (root.right != null) {
                dfs2(root.right, val + root.right.val);
            }
        }
    }

    /**
     * 前缀和
     */


}
