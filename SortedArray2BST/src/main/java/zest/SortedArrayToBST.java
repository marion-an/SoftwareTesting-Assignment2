package zest;
import java.util.*;

class TreeNode {
    int val;
    zest.TreeNode left;
    zest.TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SortedArrayToBST {

    private int[] nums;

    private boolean containsNoDuplicates(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSorted(int[] nums){
        for(int i = 1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }

    private int count(TreeNode head){
        if(head == null){
            return 0;
        }
        int countLeft = count(head.left);
        int countRight = count(head.right);
        return 1 + countLeft + countRight;
    }

    public boolean validBST(TreeNode head) {
        if (head == null) {
            return true;
        }

        int leftHeight = height(head.left);
        int rightHeight = height(head.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return validBST(head.left) && validBST(head.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void fillNums(int[] nums){
        for(int i = 0; i<nums.length; i++){
            this.nums[i] = nums[i];
        }
    }

    public zest.TreeNode sortedArrayToBST(int[] nums) {
        assert nums.length <= 10000;
        assert containsNoDuplicates(nums);
        assert isSorted(nums);
        this.nums = new int[nums.length];
        this.fillNums(nums);
        TreeNode head = constructBSTRecursive(nums, 0, nums.length - 1);
        assert count(head) == nums.length;
        assert validBST(head);
        return head;
    }

    private zest.TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        zest.TreeNode node = new zest.TreeNode(nums[mid]);
        node.left = constructBSTRecursive(nums, left, mid - 1);
        node.right = constructBSTRecursive(nums, mid + 1, right);
        assert Arrays.equals(nums, this.nums);
        return node;
    }

    public List<Integer> levelOrderTraversal(zest.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<zest.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            zest.TreeNode current = queue.poll();
            result.add(current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }
}
