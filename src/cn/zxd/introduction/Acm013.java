package cn.zxd.introduction;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author 921982
 * i can`t do it
 */
public class Acm013 {
    /**good
     * 1.use map to make roman turn to int;
     * 2.still use string.
     * 3.from tail to head compare it;
     * bad
     * 1.性能
     * 2.函数使用的多
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Map<Character,Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int len = s.length();
        int num = m.get(s.charAt(len-1));
        for(int i=len-2;i>=0;i--){
            if(m.get(s.charAt(i))>=m.get(s.charAt(i+1))){
                num += m.get(s.charAt(i));
            }else {
                num -= m.get(s.charAt(i));
            }
        }
        return num;
    }

    /**
     * Best answer
     * good
     * 1.let string turn to char[]
     * 思路: 按照字母代表的值，先把字母全换成数字的值，然后比较数字的值，我猜测数字比较大小效率更高。
     * @param s
     * @return
     */
    public int romanToIntOne(String s) {
        int[] chs = new int[s.length()];
        int result = 0;

        for (int i = 0; i < chs.length; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    chs[i] = 1; break;
                case 'V':
                    chs[i] = 5; break;
                case 'X':
                    chs[i] = 10; break;
                case 'L':
                    chs[i] = 50; break;
                case 'C':
                    chs[i] = 100; break;
                case 'D':
                    chs[i] = 500; break;
                case 'M':
                    chs[i] = 1000; break;
            }
        }
        for (int i = 0; i < chs.length; i++){
            if ( i == chs.length - 1){
                result += chs[i];
            } else if (chs[i] < chs [i + 1]){
                result = result - chs [i] ;
            } else result += chs[i];

        }
        return result;
    }

    /**
     * 这种解答 应该是 深度了解他们之间的特性后写出来的。
     *
     * @param s
     * @return
     */
    public int romanToIntTwo(String s) {
        int sum=0;

        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            switch (c[count]){
                case 'M':sum+=1000;break;
                case 'D':sum+=500;break;
                case 'C':sum+=100;break;
                case 'L':sum+=50;break;
                case 'X':sum+=10;break;
                case 'V':sum+=5;break;
                case 'I':sum+=1;break;
                default:break;
            }
        }
        return sum;
    }
    /**
     * 罗马数字转阿拉伯数字规则（仅限于3999以内）：
     从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数.
     下面的解法 和上面的 一个思路把；但上一个人 对这个规则更加了解
     */
    public int romanToIntThree(String s) {
        int i, cur;
        int total = charToInt(s.charAt(0));
        int pre = total;
        for (i = 1; i < s.length(); i++) {
            cur = charToInt(s.charAt(i));
            if (cur <= pre) {
                total += cur;
            } else {
                total += cur - pre * 2;
            }
            pre = cur;
        }
        return total;
    }
    public int charToInt(char c) {
        int data = 0;
        switch (c) {
            case 'I': data = 1;break;
            case 'V': data = 5;break;
            case 'X': data = 10;break;
            case 'L': data = 50;break;
            case 'C': data = 100;break;
            case 'D': data = 500;break;
            case 'M': data = 1000;break;
        }
        return data;
    }

    /**
     * 这个就属于看着优美的代码了；
     * 依旧是对规则十分熟悉的；
     * @param s
     * @return
     */
    public int romanToIntFour(String s) {
        int num = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            int val = v(s.charAt(i));
            if(num > val * 3){
                num -= val;
            }else{
                num += val;
            }
        }

        return num;
    }
    public int v (char c){
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;
    }
    /**
     * 其他思路：
     * 1.采用循环。把本次的记录下来，获得下次的，然后比较，继续取值:
     */
}
