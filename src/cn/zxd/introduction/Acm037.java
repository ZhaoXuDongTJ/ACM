package cn.zxd.introduction;

import java.util.ArrayList;

/**
 * title : Count and Say
 * 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.
 */
public class Acm037 {
    /**
     * My code Accepted
     * 思维：递归 里外 缓冲区；
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if(n==0)
            return "0";
        if(n==1)
            return "1";
        ArrayList<Integer> buff=new ArrayList<Integer>();
        buff.add(1);buff.add(1);
        for (int i = 2; i < n ; i++) {
            ArrayList<Integer> tem  = new ArrayList<Integer>();
            int len = 1;

            for(int j=0;j<buff.size()-1;j++){
                if(buff.get(j)==buff.get(j+1)){
                    len++;
                }else {
                    tem.add(len);
                    tem.add(buff.get(j));
                    len = 1;
                }

            }
            tem.add(len);
            tem.add(buff.get(buff.size()-1));
            len = 1;
            buff = tem;
        }
        String m = "";
        for(int x=0;x<buff.size();x++)
            m +=buff.get(x);
        return m;
    }

    /**
     * 最快代码；
     * 思路： 递归。  外函数。  按照题意，直接字符串buffer
     *      ||  巧妙利用； || 有断路的作用。
     *      第二个条件在不符合条件的时候其实也不会执行，第一个条件符合条件。
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        String result = "1";
        for (int i = 1 ; i < n ; i++) {
            result = convertUtil(result);
        }
        return result;
    }

    public String convertUtil(String input) {
        int j = 0;
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < input.length() ; i++) {
            ++counter;
            if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
                builder.append(counter);
                builder.append(input.charAt(i));
                counter = 0;
            }
        }

        return builder.toString();
    }

    /**
     * 1 简短 巧妙
     * ①：rs
     * ②：while用的好
     * @param n
     * @return
     */
    public String countAndSay3(int n) {
        String rs = "1";

        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            int acc = 1;
            char cur = rs.charAt(0);
            for (int i = 1; i < rs.length(); i++) {
                if (rs.charAt(i) == cur) {
                    acc++;
                } else {
                    sb.append(acc);
                    sb.append(cur);

                    cur = rs.charAt(i);
                    acc = 1;
                }
            }
            sb.append(acc);
            sb.append(cur);

            rs = sb.toString();
            n--;
        }

        return rs;
    }

}
