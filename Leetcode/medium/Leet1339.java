import java.util.HashMap;
import java.util.Map;

public class Leet1339 {
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> subTreeSumMapping = new HashMap<>();
        long sum = postCalculateSum(root, subTreeSumMapping);

        long maxProduct = 0;
        for (Map.Entry<TreeNode, Long> entry: subTreeSumMapping.entrySet()){
            long subTreeSum = entry.getValue();
            maxProduct = Math.max(maxProduct, subTreeSum * (sum - subTreeSum));
        }

        return (int) (maxProduct % 1000000007);

    }

    private long postCalculateSum(TreeNode root, Map<TreeNode, Long> subTreeSumMapping){
        if(root == null){
            return 0;
        }

        long left = postCalculateSum(root.left, subTreeSumMapping);
        long right = postCalculateSum(root.right, subTreeSumMapping);
        long sum = (left + root.val + right);
        subTreeSumMapping.put(root, sum);

        return sum;

    }
}
