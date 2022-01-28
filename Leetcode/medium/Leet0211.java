package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Leet0211 {

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("ba");
        System.out.println(wd.search("."));
    }

    private static class WordDictionary {
        TreeNode root;

        public WordDictionary() {
            this.root = new TreeNode('\0');
        }

        public void addWord(String word) {
            this.root.addTreeNode(word, -1);
        }

        public boolean search(String word) {
            return this.root.searchTreeNode(word, -1);
        }

        private static class TreeNode {
            Map<Character, TreeNode> nextTreeNodeChildren;
            char value;
            boolean isFinalCharacter;

            public TreeNode(char value) {
                this.value = value;
                this.isFinalCharacter = false;
                this.nextTreeNodeChildren = new HashMap<>();
            }

            public void addTreeNode(String s, int index) {
                if (index + 1 >= s.length()) {
                    this.isFinalCharacter = true;
                    return;
                }

                if (!nextTreeNodeChildren.containsKey(s.charAt(index + 1))) {
                    nextTreeNodeChildren.put(s.charAt(index + 1), new TreeNode(s.charAt(index + 1)));
                }
                nextTreeNodeChildren.get(s.charAt(index + 1)).addTreeNode(s, index + 1);
            }

            public boolean searchTreeNode(String s, int index) {
                if (index == s.length() - 1 && (s.charAt(index) == value || s.charAt(index) == '.')) {
                    return isFinalCharacter;
                }

                if(index >= 0 && s.charAt(index) != value && s.charAt(index) != '.'){
                    return false;
                }

                if (s.charAt(index + 1) == '.') {
                    boolean isOK = false;

                    for (char c:nextTreeNodeChildren.keySet()){
                        isOK |= nextTreeNodeChildren.get(c).searchTreeNode(s, index + 1);
                    }

                    return isOK;
                }

                if (nextTreeNodeChildren.containsKey(s.charAt(index + 1))) {
                    return nextTreeNodeChildren.get(s.charAt(index + 1)).searchTreeNode(s, index + 1);
                }

                return false;
            }

        }
    }
}
