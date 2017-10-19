package cn.zxd.introduction;

/**
 * title : 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 */
public class Acm035 {
    /**
     * my code ;
     * 思维： 排序数组，阶梯思维；考虑头尾特殊情况；
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if(nums==null)
            return 0;
        for(int i=0;i<nums.length;i++){
            if(target<=nums[i]){
                if(target==nums[i]){
                    return i;
                }else {
                    if(i==0){
                        return 0;
                    }else {
                        return i;
                    }
                }
            }
        }
        return nums.length;
    }

    /**
     * Best code
     * 二分查找算法，给个👍；
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertOne(int[] nums, int target) {
        int start = 0;
        int stop = nums.length-1;

        while(start <= stop){
            int mid = start+(stop-start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid+1;
            }else {
                stop = mid-1;
            }
        }
        return start;
    }

    /**
     *  牛逼 我使用<= 然后在< he == 再次判断。
     *  这里使用了 >  和 == 分别使用if
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertTwo(int[] nums, int target) {
        int len = nums.length;
        int i;
        for(i=0;i<len;i++){
            if(nums[i]==target)return i;
            if(nums[i]>target)return i;
        }
        return i;
    }

    /**
     * this is my mind ,i can`t write it
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertThree(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (target <= nums[i]) {
                return i;
            }
            i++;
        }
        return i;
    }
}
