package test1.strings;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        strings_Solution s_sol = new strings_Solution();

//        String s = "anagram", t = "nagaram";
//        String s = "A man, a plan, a canal: Panama";
        String s = "-";
//        String s = "rat", t = "rat";


//        System.out.println(s_sol.myAtoi(s));

//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "hello", needle = "ll";
//        String haystack = "", needle = "";
        String haystack = "mississippi", needle = "issip";

//        System.out.println(haystack.indexOf(needle));
//
        System.out.println(s_sol.strStr(haystack, needle));

    }
}

class strings_Solution {
    /**
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int n = s.length;

        int i = 0;
        while (i < n / 2) {
            char c = s[n - 1 - i];
            s[n - 1 - i] = s[i];
            s[i] = c;


            ++i;
        }
    }

    /**
     * 整数反转
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long res = 0;
        int i = 0;

        if (x >= 0) {
            char[] s = Integer.toString(x).toCharArray();
            int n = s.length;

            while (i < n / 2) {
                char c = s[n - 1 - i];
                s[n - 1 - i] = s[i];
                s[i] = c;

                ++i;
            }
            res = Long.valueOf(String.valueOf(s));

        } else {

            char[] s = Integer.toString(x).toCharArray();
            char[] res_c = new char[s.length - 1];
            System.arraycopy(s, 1, res_c, 0, s.length - 1);
            int n = res_c.length;
            while (i < n / 2) {
                char c = res_c[n - 1 - i];
                res_c[n - 1 - i] = res_c[i];
                res_c[i] = c;

                ++i;
            }
            res = -Long.valueOf(String.valueOf(res_c));

        }

        if (res >= Math.pow(-2, 31) && res <= (Math.pow(2, 31) - 1)) {
            x = (int) res;
        } else {
            x = 0;
        }

        return x;
    }

    /**
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //  判断字符串长度
        if (s.length() != t.length()) {
            return false;
        }

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);

        return Arrays.equals(s_chars, t_chars);
    }

    /**
     * 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] s_chars = s.toCharArray();

        char[] res_chars = new char[s_chars.length];

        int i = 0;
        while (i < s_chars.length) {
            res_chars[i] = s_chars[s_chars.length - 1 - i];
            ++i;
        }

        return Arrays.equals(res_chars, s_chars);
    }

    /**
     * 字符串转换整数
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * <p>
     * 函数 myAtoi(string s) 的算法如下：
     * 1、读入字符串并丢弃无用的前导空格
     * 2、检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
     * 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 3、读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 4、将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
     * 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 5、如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。
     * 具体来说，小于 −231 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
     * 6、返回整数作为最终结果。
     * <p>
     * 注意：
     * 1、本题中的空白字符只包括空格字符 ' ' 。
     * 2、除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {

        boolean have_minus = false;
        //  1、读入字符串并丢弃无用的前导空格
        if (s.indexOf(" ") == 0) {
            s = s.trim();
        }
        if (s.length() == 0 || s.equals("-") || s.equals("+")) {
            return 0;
        }

        //  2、检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
        if (s.indexOf("-") == 0) {
            s = s.substring(1);
            have_minus = true;
        } else if (s.indexOf("+") == 0) {
            s = s.substring(1);
        }

        // 3、读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        double res = 0;
        int i = 0;
        char[] s_chars = s.toCharArray();

        if (Character.isDigit(s_chars[0])) {
            while (i < s_chars.length) {
                if (Character.isDigit(s_chars[i])) {
                    res += Integer.parseInt(String.valueOf(s_chars[i])) * Math.pow(10, s_chars.length - 1 - i);
                } else {
                    break;
                }
                ++i;
            }
        } else {
            return 0;
        }

        res = res / Math.pow(10, s_chars.length - i);

        if (have_minus) {
            res = -res;
        }

        if (res >= Math.pow(-2, 31)) {
            if (res <= Math.pow(2, 31) - 1) {
                return new Double(res).intValue();
            } else {
                return new Double((Math.pow(2, 31) - 1)).intValue();
            }
        } else {
            return new Double(Math.pow(-2, 31)).intValue();
        }
    }


    /**
     * 实现 strStr()
     * <p>
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
     * 如果不存在，则返回 -1 。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int i = 0;
        char[] h_chars = haystack.toCharArray();
        char[] n_chars = needle.toCharArray();

        int h = h_chars.length;
        int n = n_chars.length;
        while (i <= h - n) {
            if (h_chars[i] == n_chars[0]) {
                int j = 0;
                while (j < n) {
                    if (h_chars[i + j] == n_chars[j]) {
                        ++j;
                    } else {
                        break;
                    }
                }

                if (j == n) {
                    return i;
                }
            }
            ++i;
        }

        return -1;
    }
}
