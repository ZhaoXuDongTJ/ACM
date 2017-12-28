package cn.zxd.introduction;

public class Acm066 {

    /**
     *  Error code
     *  没审题
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] n = new int[digits.length];
        for(int i =0;i<digits.length;i++){
            n[digits.length-i-1]=digits[i];
        }
        int[] tem=new int[digits.length+1];
        int m = n[0]+1;
        for(int j=0;j<tem.length;j++){
            if(m>=10&&j<n.length){
                tem[j]=m%10;
                m=n[j+1]+1;
            }else {
                tem[j]=m;
                for (int q=j+1;q<n.length;q++)
                    tem[q]=n[q];
                int[] w=new int[n.length];
                for(int e=0;e<n.length;e++)
                    w[w.length-1-e]=tem[e];
                return w;
            }
        }
        int[] ee= new int[tem.length];
        for(int i =0;i<tem.length;i++)
            ee[ee.length-1-i]=tem[i];
        return ee;
    }

    /**
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    /**
     *
     * @param digits
     * @return
     */
    public int[] plusOne3(int[] digits) {
        if (digits.length == 0) return digits;
        int carry = 1, n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (carry == 0) return digits;
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return carry == 0 ? digits : res;
    }
}
