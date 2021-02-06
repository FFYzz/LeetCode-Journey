import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2021/2/6
 * @Description:
 */
public class FindDuplicateFileinSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; ++i) {
            String[] splitStr = paths[i].split("\\s");
            String rootPath = splitStr[0];
            for (int j = 1; j < splitStr.length; ++j) {
                String content = splitStr[j].substring(splitStr[j].indexOf('(') + 1, splitStr[j].lastIndexOf(')'));
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(rootPath + "/" + splitStr[j].substring(0, splitStr[j].indexOf('(')));
            }
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((x, y) -> {
            if (y.size() >= 2) {
                res.add(y);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        new FindDuplicateFileinSystem().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
    }

}
