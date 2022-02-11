struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(): val(0), left(nullptr), right(nullptr){}
    explicit TreeNode(int val): val(val), left(nullptr), right(nullptr){}
    TreeNode(int val, TreeNode* left, TreeNode* right): val(val), left(left), right(right){}
};

class Solution {
public:
    int sum = 0;
    int sumRootToLeaf(TreeNode* root) {
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode* root, int currentValue){
        if(root == nullptr){
            return;
        }

        currentValue += root->val;

        if(root->left == nullptr && root->right == nullptr){
            sum += currentValue;
            return;
        }

        currentValue <<= 1;

        dfs(root->left, currentValue);
        dfs(root->right, currentValue);
    }
};

