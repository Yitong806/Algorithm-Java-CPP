#include "cmath"

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int currentMaxDepth;

    int maxDepth(TreeNode *root) {
        return dfs(root);
    }

    int dfs(TreeNode *root) {
        if (root == nullptr) {
            return 0;
        }

        int leftDepth = dfs(root->left);
        int rightDepth = dfs(root->right);
        currentMaxDepth = max(currentMaxDepth, max(leftDepth, rightDepth) + 1);

        return max(leftDepth, rightDepth) + 1;
    }
};