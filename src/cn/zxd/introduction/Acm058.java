package cn.zxd.introduction;

/**
 * title:  Length of Last Word
 */
public class Acm058 {
    /**
     * My code : run Error;
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int sum=0;
        for (int i=0;i<s.length();i++ ) {
            sum++;
            if(s.charAt(i)==' '){
                sum=0;
                continue;
            }
        }
        return sum;
    }

    /**
     * 底层实现；说明了意思；
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        if(s==null || s.length()==0)
            return 0;
        int idx = s.length()-1;
        while(idx>=0 && s.charAt(idx)==' ') idx--;
        int idx2 = idx;
        while(idx2>=0 && s.charAt(idx2)!=' ') idx2--;
        return idx-idx2;
    }

    /**
     * 大神写法；
     * 用到了String的函数；
     * @param s
     * @return
     */
    public int lengthOfLastWord3(String s) {
        if(s == null)
            return 0;
        return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    }
}
