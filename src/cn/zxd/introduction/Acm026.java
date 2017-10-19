package cn.zxd.introduction;

/** title : Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class Acm026 {
    /**
     * my code . Accepted
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = 0,now = 0;
        if(nums.length!=0){
            now=nums[0];
        }
        for(int i = 0;i<nums.length;i++){
            if (nums[i]>now){
                 len++;
                 now = nums[i];
                 nums[len] = nums[i];
            }
        }
        return len+1;
    }

    /**
     * better code
     * @param nums
     * @return
     */
    public int removeDuplicatesOne(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1)
            return n;

        int j=0;
        for(int i=0;i<n-1;i++)
            if(nums[i]!=nums[i+1])
                nums[j++] = nums[i];
        nums[j++] = nums[n-1];

        return j;
    }

}
