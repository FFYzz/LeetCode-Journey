/**
 * @Title: 14. Longest Common Prefix
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/3
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String preStr = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            StringBuilder res = new StringBuilder();
            String str = strs[i];
            int index1 = 0, index2 = 0;
            while (index1 < preStr.length() && index2 < str.length()) {
                if (preStr.charAt(index1++) != str.charAt(index2++)) {
                    break;
                }
                res.append(preStr.charAt(index1 - 1));
            }
            if (res.length() == 0) {
                return "";
            }
            preStr = res.toString();
        }
        return preStr;
    }

    /**
     * concise solution
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String preStr = strs[0];
        for (int i = 0; i < strs.length; ++i) {
            while (strs[i].indexOf(preStr) != 0) {
                preStr = preStr.substring(0, preStr.length() - 1);
            }
        }
        return preStr;
    }

    //["flower","flow","flight"]

}
