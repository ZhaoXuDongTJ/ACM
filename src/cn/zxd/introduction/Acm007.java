package cn.zxd.introduction;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 7. Reverse Integer
 * this is my code
 * Error
 */
public class Acm007 {
    public int reverse(int x) {
        boolean symbol = true;
        int num = x;
        if(x<0) {
            symbol = false;
            num = -x;
        }

        int bit=0;
        int numtemp = num;
        do{
            numtemp/=10;
            bit++;
        }while (numtemp != 0);
        int[] lis = new int[bit];
        int temp,i=0;
        do{
            temp =num %10;
            lis[i++] = temp;
            num/=10;
        }while (num != 0);
        int dec=1;
        for(int m=lis.length-1;m>=0;m--,dec*=10){
            num += lis[m]*dec;
        }

        if(symbol){
            return num;
        }else{
            return -num;
        }

    }

    /**
     *  true way one
      * @param x
     * @return
     */
    public int reverseOne(int x) {
        int y = 0;

        while(x != 0) {
            int yy = y*10 + x%10;

            if ((yy - x%10)/10 != y) return 0;
            else y = yy;

            x = x/10;
        }
        return y;

    }

    /**
     * 上面算法的 优化 可以看懂
     * @param x
     * @return
     */
    int reverseTwo(int x) {
        int ans = 0;
        while (x!=0) {
            int temp = ans * 10 + x % 10;
            if (temp / 10 != ans)
                return 0;
            ans = temp;
            x /= 10;
        }
        return ans;
    }


}
