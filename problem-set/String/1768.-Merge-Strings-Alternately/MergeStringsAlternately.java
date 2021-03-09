/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/3/9
 * @Description:
 */
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index1 = 0, index2 = 0;
        boolean flag = true;
        while (index1 < word1.length() && index2 < word2.length()) {
            if (flag) {
                sb.append(word1.charAt(index1++));
            } else {
                sb.append(word2.charAt(index2++));
            }
            flag = !flag;
        }
        if (index1 < word1.length()) {
            sb.append(word1.substring(index1));
        }
        if (index2 < word2.length()) {
            sb.append(word2.substring(index2));
        }
        return sb.toString();
    }

}
