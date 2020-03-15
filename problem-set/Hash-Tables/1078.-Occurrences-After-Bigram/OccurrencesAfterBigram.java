import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 1078. Occurrences After Bigram
 * @Author: FFYzz
 * @Mail: cryptochen95@gmail.com
 * @Date: 2020/3/15
 */
public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index + 2 < strs.length){
            if (strs[index].equals(first) && strs[index + 1].equals(second)) {
                res.add(strs[index + 2]);
            }
            ++index;
        }
        return res.stream().toArray(String[]::new);
    }

    public String[] findOcurrences2(String text, String first, String second) {
        return null;
    }

}
