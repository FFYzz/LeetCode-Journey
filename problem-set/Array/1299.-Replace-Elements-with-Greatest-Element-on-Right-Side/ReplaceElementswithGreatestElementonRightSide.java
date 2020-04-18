/**
 * @Title: 1299. Replace Elements with Greatest Element on Right Side
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/18
 */
public class ReplaceElementswithGreatestElementonRightSide {

    //[17,18,5,4,6,1]

    public int[] replaceElements(int[] arr) {
        int maxValue = -1;
        int pre = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            maxValue = Math.max(pre, maxValue);
            pre = arr[i];
            arr[i] = maxValue;
        }
        return arr;
    }

}
