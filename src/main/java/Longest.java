/**
 * @author sby
 * @Title: Longest
 * @Description: TODO
 * @date 2019/4/24 10:45
 */
public class Longest {

    public static void main(String[] args) {
        //String s = "aa aa aaaa aaa a a a aa aa a";
        //String s = "aa aaaaaa aaaa  aaa a a aaaaaaa aa aa a";
        String s = "aaaaaaaa aa aaaa aaa a aaaa a aa aa aaaaaaa";

        int subStringlength = getLongestlength(s);

        System.out.println(subStringlength);
    }

    private static int getLongestlength(String s) {

        int length = 0;
        int tempLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {

                if (tempLength > length) {
                    length = tempLength;
                }

                tempLength = 0;
                continue;
            }

            tempLength++;

            if (i == s.length() - 1 && tempLength > length) {
                length = tempLength;
            }
        }

        return length;
    }
}
