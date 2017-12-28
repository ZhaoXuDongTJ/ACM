package cn.zxd.introduction;

/**
 * title: Maximum Sub array
 */
public class Acm053 {
    /**
     *  Way one: 三次for循环
     *  Way two： 两次for循环
     */
    /**
     * 二分法
     * @param A
     * @param left
     * @param right
     * @return
     */
    public static int MaxSubSum(int[] A,int left,int right){
        if(left==right)
            if(A[left]>0)
                return A[left];
            else
                return 0;
        int center = left + (right-left)/2;
        int maxLeft = MaxSubSum(A,left,center);
        int maxRight = MaxSubSum(A,center+1,right);

        int maxLeftBorder =0;
        int LeftBorder =0;
        for(int i=center;i>=left;i--){
            LeftBorder+=A[i];
            if(LeftBorder>maxLeftBorder)
                maxLeftBorder=LeftBorder;
        }

        int maxRightBorder =0;
        int RightBorder =0;
        for (int i=center+1;i<=right;i++){
            RightBorder+=A[i];
            if(RightBorder>maxRightBorder)
                maxRightBorder=RightBorder;
        }

        return Math.max(Math.max(maxLeft,maxRight),Math.max(maxRight,maxLeftBorder+maxRightBorder));

    }
    public static int MaxSubSequenceSum(int[] A){
        return MaxSubSum(A,0,A.length);
    }

    /**
     * 联机算法
     * 遍历一次即可
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int max_sum = Integer.MIN_VALUE;
        int cur = 0;

        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            max_sum = Math.max(max_sum, cur);
            if(cur < 0){
                cur = 0;
            }
        }

        return max_sum;
    }
}
