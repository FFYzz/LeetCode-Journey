/**
 * @Title: 1332. Remove Palindromic Subsequences
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/16
 */
public class RemovePalindromicSubsequences {

    /**
     * 三种情况：
     * 1. 字符串为空 返回 0
     * 2. 整个字符串为回文串 返回 1
     * 3. 返回 2
     * 因为 Subsequences 不要求连续，所以第一次删除所有的 a ，第二次删除所有的 b 即可。
     *
     * @param s
     * @return
     */
    public int removePalindromeSub(String s) {
        return s.length() == 0 ? 0 : isPalindrome(s) ? 1 : 2;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
