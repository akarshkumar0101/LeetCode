

import java.util.*;

public class Test {
    public static void main(String... args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));

//        List<List<Integer>> perms = new Test().permute(new int[]{1,2,3});
//
//        for(List<Integer> list:perms){
//            for(int i:list){
//                System.out.print(i+ ", ");
//            }
//            System.out.println();
//        }
    }



    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (n <= 0 || n < k)
            return result;

        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1

        return result;
    }

    private void dfs(int n, int k, int start, ArrayList<Integer> item,
                     ArrayList<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i:nums){
            list.add(i);
        }
        return permute(list);
    }

    public ArrayList<List<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<List<Integer>> perms = new ArrayList<List<Integer>>();

        if(nums.size()<=1){
            if(nums.size()==1){
                perms.add((List<Integer>) nums.clone());
            }
            return perms;
        }



        for(int i=0; i <nums.size();i++){
            //ArrayList<Integer> newNums = (ArrayList<Integer>) nums.clone();
            int numChosen = nums.remove(i);

            ArrayList<List<Integer>> subPerms = permute(nums);

            for(List<Integer> x: subPerms){
                x.add(0,numChosen);
            }
            perms.addAll(subPerms);

            nums.add(i,numChosen);
        }


        return perms;
    }

}
class Trie {
    private Character c;
    private List<Trie> children;
    private boolean isWord;


    /** Initialize your data structure here. */
    public Trie() {
        c = null;
        children = new ArrayList<Trie>();
        isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.isEmpty()){
            isWord = true;
            return;
        }
        char start = word.charAt(0);
        String childString = word.substring(1,word.length());
        for(Trie child:children){
            if(child.c == start){
                child.insert(childString);
                return;
            }
        }
        //no children
        Trie newChild = new Trie();
        newChild.c = start;
        children.add(newChild);
        newChild.insert(childString);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word,true);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(prefix,false);
    }

    private boolean search(String word, boolean exactWord) {
        if(word.isEmpty()){
            return (!exactWord) || (isWord);
        }
        char start = word.charAt(0);
        String wordForChildren = word.substring(1,word.length());

        for(Trie child:children){
            if(child.c == start){
                return child.search(wordForChildren, exactWord);
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */