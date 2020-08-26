public class WatchArray {
    public static void main(String[] args){

        int n = 4;
        SolutionWA solutionWA = new SolutionWA();
        System.out.println(solutionWA.findWA(n));
    }
}

/**
 * 1: 1
 * 2: 11
 * 3: 21
 * 4: 1211
 * 5: 111221
 * n-1: cur:1
 * ==cur:
 * curCnt ++
 * !=cur
 * (0~cnt) s += cur
 * cur = i
 * cnt = 1
 */
class SolutionWA{
    public String findWA(int n){
        String s1 = "1";
        for(int i = 0; i < n - 1; i++){
            s1 = generateStr(s1);
        }
        return s1;


    }

    private String generateStr(String pre){
        char cur = pre.charAt(0);
        int cnt = 1;
        String res = "";
        for(int index = 1; index < pre.length(); index ++){
            if(pre.charAt(index) == cur){
                cnt += 1;
            }
            else{
                res = res + cnt + cur;
                cur = pre.charAt(index);
                cnt = 1;
            }
        }
        res = res + cnt + cur;

        return res;
    }
}
