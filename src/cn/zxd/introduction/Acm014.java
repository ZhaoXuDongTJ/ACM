package cn.zxd.introduction;

import java.nio.Buffer;
import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Good mind:修剪钻石法
 */
public class Acm014 {
    /**
     * String 使用错误。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null){
            return "";
        }
        int index =strs[0].length();
        String me = strs[0];
        for(int j=1;j<strs.length;j++){
            if(index > strs[j].length()){
                index = strs[j].length();
                me = strs[j];
            }
        }
        if(me==""){
            return "";
        }
       // System.out.println(index);
        for(int i=0 ; i<strs.length ; i++){
            if(strs[i].indexOf(me.substring(0,index-1)) !=0 ){
                if(index!=0){
                    index--;
                }else{
                    return "";
                }
            }
        }
        return me.substring(0,index);
    }

    /**
     * Best code
     * 1.特殊情况，特别对待
     * 2.indexOf 来定位，然后一直截切;
     * 利用了字符串的indexOf方法，通过返回位置是不是0判断是不是公共前缀，如果返回值不是0，
     * 就将这个临时公共前缀删除最后一个字符，在进行尝试，直到返回值为0为止
     * @param strs
     * @return
     */
    public String longestCommonPrefixOne(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        int currStrIndex = 1;
        while (currStrIndex < strs.length) {
            String currStr = strs[currStrIndex];
            while (currStr.indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
            currStrIndex++;
        }
        return prefix;
    }

    //挺有意思的直接放代码

    /**
     * “Sort the array first, and then you can simply compare the first and last elements in the sorted array.”
     * @param strs
     * @return
     */
    public String longestCommonPrefixTwo(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs!= null && strs.length > 0){

            Arrays.sort(strs);

            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();

            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }

        }
        return result.toString();
    }

}

