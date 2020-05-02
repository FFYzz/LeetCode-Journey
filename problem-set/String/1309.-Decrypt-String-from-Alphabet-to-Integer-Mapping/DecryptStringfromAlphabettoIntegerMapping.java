/**
 * @Title: 1309. Decrypt String from Alphabet to Integer Mapping
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/2
 */
public class DecryptStringfromAlphabettoIntegerMapping {

    /**
     * 从后往前处理
     *
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; ) {
            if (s.charAt(i) == '#') {
                if (i - 2 >= 0 && Character.isDigit(s.charAt(i - 2))) {
                    int intValue = s.charAt(i - 1) - '0' + 10 * (s.charAt(i - 2) - '0');
                    if (intValue <= 26) {
                        sb.insert(0, (char) ('a' + intValue - 1));
                    }
                    i -= 3;
                    continue;
                }
            }
            sb.insert(0, (char) ('a' + (s.charAt(i) - '0') - 1));
            --i;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new DecryptStringfromAlphabettoIntegerMapping().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
    }

}
