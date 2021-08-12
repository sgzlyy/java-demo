package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 * @author sby
 * @date 2021/7/29 15:18
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        int res = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                char c1 = s.charAt(j++);
                set.remove(c1);
            }
            set.add(c);
            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbbcbb"));
    }


}
