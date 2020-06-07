/**
 * @Title: 151. Reverse Words in a String
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/6/7
 */
public class ReverseWordsinaString {

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        int startPosition = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (flag == false && s.charAt(i) == ' ' || (flag == true && s.charAt(i) != ' ')) {
                continue;
            }
            if (flag == false) {
                flag = true;
                startPosition = i;
            } else {
                res.insert(0, " " + s.substring(startPosition, i));
                flag = false;
            }
        }
        if (flag == true) {
            res.insert(0, " " + s.substring(startPosition));
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        new ReverseWordsinaString().reverseWords("a  b c");
    }

}
