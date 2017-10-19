package cn.zxd.introduction;

/**
 * Implement strStr()
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Acm028 {
    /**
     * my code ; 太垃圾，对String的原生方法 不理解
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0 && needle.length()==0){
            return 0;
        }
        if(haystack!=""&&needle.length()==0){
            return 0;
        }
        if(haystack==""&&needle!=""){
            return -1;
        }
        int i =haystack.indexOf(needle);
        return i!=-1?-1:i;
    }

    /**
     * So Easy
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrOne(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


}
