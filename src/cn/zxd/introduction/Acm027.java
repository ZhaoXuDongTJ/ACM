package cn.zxd.introduction;

/**
 *  title :  Remove Element
 *  Given an array and a value, remove all instances of that value in place and return the new length.
 *  Do not allocate extra space for another array, you must do this in place with constant memory.
 *  The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Acm027 {
    /**
     * My code Accepted
     * easy
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int j =0;
        for(int i =0;i<len;i++){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
    /**
     *  if (nums == null || nums.length < 1) return 0;
     *  this is first code ;
     */



}
