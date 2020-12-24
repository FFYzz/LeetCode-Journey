/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/12/24
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int countOfCapital = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                ++countOfCapital;
            }
        }
        return countOfCapital == 0
                || (countOfCapital == 1 && !Character.isLowerCase(word.charAt(0)))
                || len == countOfCapital;
    }

}
