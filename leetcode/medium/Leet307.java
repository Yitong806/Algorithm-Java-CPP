package leetcode.medium;

public class Leet307 {

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{1,2,3,4,5,6});
        System.out.println(na.sumRange(0,2));
        na.update(3,99);
        System.out.println(na.sumRange(0,4));
    }

    private static class NumArray {

        SegmentTreeNode root;

        public NumArray(int[] nums) {
            this.root = new SegmentTreeNode(0, nums.length - 1, nums);
        }

        public void update(int index, int val) {
            this.root.update(index, val);
        }

        public int sumRange(int left, int right) {
            return this.root.sumRange(left, right);
        }

        private static class SegmentTreeNode {
            SegmentTreeNode father;
            SegmentTreeNode leftChild;
            SegmentTreeNode rightChild;
            int leftBound;
            int rightBound;
            int sumValue;

            public SegmentTreeNode(int leftBound, int rightBound, int[] array) {
                this.leftBound = leftBound;
                this.rightBound = rightBound;
                if (leftBound == rightBound) {
                    this.leftChild = null;
                    this.rightChild = null;
                    this.sumValue = array[leftBound];
                } else {
                    int split = (leftBound + rightBound) / 2;
                    this.leftChild = new SegmentTreeNode(leftBound, split, array);
                    this.rightChild = new SegmentTreeNode(split + 1, rightBound, array);
                    this.leftChild.father = this;
                    this.rightChild.father = this;
                    this.sumValue = leftChild.sumValue + rightChild.sumValue;
                }
            }

            public static boolean insideIndex(SegmentTreeNode node, int index) {
                return node != null && (node.leftBound <= index && index <= node.rightBound);
            }

            public void update(int index, int val) {
                SegmentTreeNode lastTreeNode = this;
                while (insideIndex(lastTreeNode, index)) {
                    if (insideIndex(lastTreeNode.leftChild, index)) {
                        lastTreeNode = lastTreeNode.leftChild;
                    } else if(lastTreeNode.rightChild != null){
                        lastTreeNode = lastTreeNode.rightChild;
                    }else {
                        break;
                    }
                }

                int changed = val - lastTreeNode.sumValue;

                while (lastTreeNode != null) {
                    lastTreeNode.sumValue += changed;
                    lastTreeNode = lastTreeNode.father;
                }
            }

            public int sumRange(int left, int right) {
                int sum = 0;
                if (left == this.leftBound && right == this.rightBound) {
                    return this.sumValue;
                } else if (insideIndex(this.leftChild, left) && insideIndex(this.rightChild, right)) {
                    return this.leftChild.sumRange(left, this.leftChild.rightBound)
                            + this.rightChild.sumRange(this.rightChild.leftBound, right);
                } else if (insideIndex(this.leftChild, left) && insideIndex(this.leftChild, right)) {
                    return this.leftChild.sumRange(left, right);
                } else {
                    return this.rightChild.sumRange(left, right);
                }

            }
        }
    }

}
