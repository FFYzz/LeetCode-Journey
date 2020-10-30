import java.util.*;

/**
 * @Title:
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/10/22
 */
public class WordLadder {

    /**
     * TLE
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthTLE(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < beginWord.length(); ++i) {
            list.add(new HashSet<>());
        }
        for (int i = 0; i < wordList.size(); ++i) {
            for (int j = 0; j < wordList.get(i).length(); ++j) {
                list.get(j).add(wordList.get(i).charAt(j));
            }
        }
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String pollString = queue.poll();
                if (pollString.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < pollString.length(); ++j) {
                    final int start = j;
                    list.get(j).forEach(x -> {
                        String tmpStr = pollString.substring(0, start) + x + pollString.substring(start + 1);
                        if (wordList.contains(tmpStr) && !set.contains(tmpStr)) {
                            set.add(tmpStr);
                            queue.offer(tmpStr);
                        }
                    });
                }
            }
            ++count;
        }
        return 0;
    }


    /**
     * AC
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String pollString = queue.poll();
                char[] sourceChars = pollString.toCharArray();
                if (pollString.equals(endWord)) {
                    return count;
                }
                set.remove(pollString);
                for (int j = 0; j < pollString.length(); ++j) {
                    char c = sourceChars[j];
                    final int start = j;
                    for (int k = 0; k < 26; ++k) {
                        char midChar = (char) ('a' + k);
                        sourceChars[j] = midChar;
                        if (set.contains(new String(sourceChars))) {
                            queue.offer(new String(sourceChars));
                        }
                    }
                    sourceChars[j] = c;
                }
            }
            ++count;
        }
        return 0;
    }


}
