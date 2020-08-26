import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrsMatch {
    /**
     * STR= "abc def hig efi"
     * arrays = [abc, hig, efi, def]
     * find match的索引
     */
    public static void main(String[] args) {
        String s = "abcdefhigefidef";
        String[] words = new String[]{"def", "hig", "efi"};
        Solution solution = new Solution();
        List<Integer> res = solution.findMatch(s, words);
        System.out.println(res);
    }

}
class Solution{
    public List<Integer> findMatch(String s, String[] words){
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || s.length() == 0){
            return res;
        }
        Map<String, Integer> wordCount = generateCount(words);
        int wordLen = words[0].length();
        int alphaLen = words.length;
        int sLen = s.length();
        for(int i = 0;i < wordLen; i++){
            Map<String, Integer> window = new HashMap<>();
            int left = i;
            int right = i;
            while(right <= sLen - wordLen && left <= sLen - wordLen * alphaLen){
                String curStr = s.substring(right, right + wordLen);
                if(!wordCount.containsKey(curStr)){
                    window.clear();
                    right = right + wordLen;
                    left = right;
                    continue;
                }
                incre(window, curStr);
                while(window.get(curStr) > wordCount.get(curStr) && left <= sLen - wordLen * alphaLen){
                    String initStr = s.substring(left, left + wordLen);
                    decre(window, initStr);
                    left += wordLen;
                }
                right += wordLen;
                if(right - left == alphaLen * wordLen){
                    res.add(left);
                }
            }
        }
        return res;

    }

    private Map<String, Integer> generateCount(String[] words){
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word: words){
            wordCount.put(word,
                    wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
    private void incre(Map<String, Integer> m, String key){
        m.put(key, m.getOrDefault(key, 0) + 1);
    }
    private void decre(Map<String, Integer> m, String key){
        if(m.get(key) > 1){
            m.put(key, m.get(key) - 1);
        }
        else{
            m.remove(key);
        }
    }

}
