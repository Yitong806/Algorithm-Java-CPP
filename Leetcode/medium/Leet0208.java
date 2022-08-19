import java.util.HashMap;
import java.util.Map;

public class Leet0208 {

    public static class Trie {
        private final TrieNode root = new TrieNode('\0');

        public Trie() {

        }

        public void insert(String word) {
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                curr.addChild(c);
                curr = curr.getChild(c);
            }

            curr.isTerminated = false;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                curr = curr.getChild(c);
                if(curr == null){
                    return false;
                }
            }

            return curr.isTerminated;

        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char c: prefix.toCharArray()){
                curr = curr.getChild(c);
                if(curr == null){
                    return false;
                }
            }

            return true;

        }

        private static class TrieNode{
            private boolean isTerminated = false;
            private final char value;
            private final Map<Character, TrieNode> childrenMapping = new HashMap<>();

            public TrieNode(char c){
                this.value = c;
            }

            public void addChild(char c){
                childrenMapping.putIfAbsent(c, new TrieNode(c));
            }

            public TrieNode getChild(char c){
                return childrenMapping.get(c);
            }
        }
    }

}
