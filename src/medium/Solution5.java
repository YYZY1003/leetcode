package medium;

import java.util.LinkedHashSet;

/**
 * @Description 5. ������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�
 * ����ַ����ķ�����ԭʼ�ַ�����ͬ������ַ�����Ϊ�����ַ�����
 * @ClassName Solution5
 * @Path medium
 * @Author YY
 * @Date 2024/4/25 16:52
 * @Version 1.0
 */
public class Solution5 {
    public static void main(String[] args) {
        String string = longestPalindrome("aaaabcbdfdjsfjashajfasdfasdfsadfcasdfgabcdefjhijklmnopqrstuvwasdgadsfasdfAAdsfasfasebdsvadgfasdfewyrrtjhgfnbvxnsddfgaesethuujuijgjhghghjga");
        System.out.println("string = " + string);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] ��ʾ s[i..j] �Ƿ��ǻ��Ĵ�
        boolean[][] dp = new boolean[len][len];
        // ��ʼ�������г���Ϊ 1 ���Ӵ����ǻ��Ĵ�
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // ���ƿ�ʼ
        // ��ö���Ӵ�����
        for (int L = 2; L <= len; L++) {
            // ö����߽磬��߽���������ÿ��Կ���һЩ
            for (int i = 0; i < len; i++) {
                // �� L �� i ����ȷ���ұ߽磬�� j - i + 1 = L ��
                int j = L + i - 1;
                // ����ұ߽�Խ�磬�Ϳ����˳���ǰѭ��
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // ֻҪ dp[i][L] == true �������ͱ�ʾ�Ӵ� s[i..L] �ǻ��ģ���ʱ��¼���ĳ��Ⱥ���ʼλ��
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}