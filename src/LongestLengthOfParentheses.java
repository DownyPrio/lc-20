public class LongestLengthOfParentheses {
    public static void main(String[] args){
        String s = "(((()))())))";
        Solution1 solution1 = new Solution1();
        int res = solution1.findLongestLengthOfParentheses(s);
        System.out.println(res);

    }
}

class Solution1{
    public int findLongestLengthOfParentheses(String s){
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = 0;
        for(int i = s.length() - 2; i >= 0; i --){
            if(s.charAt(i) == '(' && i + 1 + dp[i + 1] < s.length() && s.charAt(i + 1 + dp[i + 1]) == ')'){
                dp[i] = dp[i + 1] + 2;
                if(i + 1 + dp[i + 1] < s.length() - 1) {
                    dp[i] += dp[i + 1 + dp[i + 1] + 1];
                }
            }
            else {
                dp[i] = 0;
            }
        }
        int max = 0;
        for(int each: dp){
            max = max > each ? max:each;
        }
        return max;

    }

}
