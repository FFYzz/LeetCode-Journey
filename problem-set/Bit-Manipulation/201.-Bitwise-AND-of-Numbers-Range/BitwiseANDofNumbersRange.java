/**
 * @Title: 201. Bitwise AND of Numbers Range
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/24
 */
public class BitwiseANDofNumbersRange {

    /**
     * 找到 m 和 n 二进制表示的相同前缀
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++count;
        }
        return m << count;
    }

    public static void main(String[] args) {
        //0
        //2147483647
        new BitwiseANDofNumbersRange().rangeBitwiseAnd(0, 2147483647);
    }

}
