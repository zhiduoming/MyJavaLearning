public class LC_005_longestPalindrome {
    public static void main(String[] args) {
        String s = "bacbcbcad";
        System.out.println(longestPalindrome2(s));

    }

    /*public static String longestPalindrome1(String s) {
        int n = s.length();
        if (n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        //定义起始索引和最大长度
        int start = 0;
        int maxlen = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //两端相同而且总长度还在3以内或者其子串是回文的
                    if (j - i < 3 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        //更新最大长度
                        int len = j - i + 1;
                        if (len > maxlen) {
                            maxlen = len;
                            start = i;
                        }
                    }

                }
            }
        }
        return s.substring(start, start + maxlen);
    }*/

    //中心扩展
    public static String longestPalindrome2(String s) {
        //判断特殊情况
        if (s == null || s.length() < 2) return s;
        int start=0,maxlen=1;
        for (int i = 0; i < s.length(); i++) {
            //回文长度为奇数时
            int len1=expandAroundCenter(s,i,i);
            //回文长度为偶数时
            int len2=expandAroundCenter(s,i,i+1);
            //更新索引
            int len=Math.max(len1,len2);
            if (len>maxlen) {
                maxlen=len;
                start=i-(len-1)/2;
            }
        }
        return s.substring(start,start+maxlen);
    }

    public static int expandAroundCenter(String s, int left, int right) {

        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //原来长度应该为right-left+1,但是由于出循环left和right都多走了一步,所以需要给原来长度-2,即:right-left-1;
        return right-left-1;
    }

}
