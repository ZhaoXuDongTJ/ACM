package cn.zxd.introduction;

/**
 * Palindrome Number
 * @author 921982
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Acm009 {
    /**
     * my code
     * question:  i don`t know what is palindrome
      * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int cx = x;
        int num=0;
        while(cx!=0){
            num = num*10 + cx%10;
            cx/=10;
        }
        if(x>0){
            if(num==x){
                return true;
            }else{
                return false;
            }
        }else{
            if(-num == x){
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * Best answer
     * if you know what is palindrome , you will use x>0 .
     * @param x
     * @return
     */
    public boolean isPalindromeOne(int x) {
        int y=0;
        int z=x;
        while(z>0){
            y=y*10+z%10;
            z=z/10;
        }
        if(x==y)
            return true;
        return false;
    }

    /**
     * way two;
     * this is a not very good mind,but still need to learn;
     * @param x
     * @return
     */
    public boolean isPalindromeTwo(int x) {
        String num = Integer.toString(x);
        int length = num.length();
        for (int i = 0; i <= length/2; i++) {
            if (num.charAt(i) != num.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }


}
