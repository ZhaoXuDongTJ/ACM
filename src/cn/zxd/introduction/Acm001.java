package cn.zxd.introduction;

import java.util.Arrays;
import java.util.HashMap;
/**
 * Two Sum
 * @author 92198
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 */
public class Acm001 {
/**
 * 我的代码
 * @param nums
 * @param target
 * @return
 */
	 public int[] twoSumMy(int[] nums, int target) {
	        int []a = {0,0};
	        for(int i =0;i<nums.length;i++){
	            for(int j=i+1;j<nums.length;j++){
	                if(nums[i]+nums[j]==target){
	                    a[0]=i;
	                    a[1]=j;
	                    return a;
	                }
	            }
	        }
	        return a;
	    }
	 
/**
 *  这里使用的方法
 *  把一个的差值在哈希map里面找是否存在 ;
 *  优势：单次循环，次数减少；
 * @param nums
 * @param target
 * @return
 */
	public int[] twoSumOne(int[] nums, int target) {
	       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int i = 0; i < nums.length; i++){
					if ( map.containsKey( target - nums[i] )){
						return new int[] {i, map.get(target - nums[i])};
					} else {
						map.put(nums[i], i);
					}
				}
				return new int[]{}; 
		}
/**
 *  相比较 第二个，这个的代码 更容易懂，明白
 * @param nums
 * @param target
 * @return
 */
	public int[] twoSumThree(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
    
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            } 
            map.put(nums[i], i);
        }
        
        
        return res;
    }

/**
 *  思维：第一个和最后一个相加，找到最终等于需要的结果，把这两个数字记录下来
 *     最后找出这两个数字的下标
 * @param nums
 * @param target
 * @return
 */
public int[] twoSumTwo(int[] nums, int target) {
        if (nums.length == 0)   return null;
   
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int[] index = new int[2];
        int start = 0, end = nums.length - 1;
        
        while (start < end){
            int sum = copy[start] + copy[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else{
                index[0] = copy[start];
                index[1] = copy[end];
                break;
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == index[0]){
                index[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >=0 ; i--){
            if (nums[i] == index[1]){
                index[1] = i;
                break;
            }
        }
        return index;
    }
	
	
}
