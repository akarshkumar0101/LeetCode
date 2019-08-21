public class Problem44 {
    public static void main(String... args) {
        /*
        Input:
        s = "aa"
        p = "a"
        Output: false

        Input:
        s = "aa"
        p = "*"
        Output: true

        Input:
        s = "cb"
        p = "?a"
        Output: false

        Input:
        s = "adceb"
        p = "*a*b"
        Output: true

        Input:
        s = "acdcb"
        p = "a*c?b"
        Output: false

        "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
        "a*******b"

        "bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa"
        "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****"
         */

        Solution sol = new Problem44().new Solution();

        String str = "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****";
        System.out.println(str.replaceAll("\\*+","*"));

        System.out.println(sol.isMatch("bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa","******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****"));

    }

    class Solution {
        public boolean isMatch(String s, String p) {
            p = p.replaceAll("\\*+","*");
            if(s.isEmpty()&&p.isEmpty()){
                return true;
            }
            if(p.isEmpty()){
                //s still has stuff and pattern is empty
                return false;
            }

            char firstP = p.charAt(0);
            if(firstP=='*'){
                for(int i=0;i<=s.length();i++){
                    if(isMatch(s.substring(i,s.length()),p.substring(1,p.length()))){
                        return true;
                    }
                }
                return false;
            }
            else{//firstP is either character or '?'
                if(s.isEmpty()){
                    return false;
                }
                char firstS = s.charAt(0);
                if(firstP!='?' && firstS!=firstP){//if is character and not matching
                    return false;
                }
                return isMatch(s.substring(1,s.length()),p.substring(1,p.length()));
            }

        }
    }
}
