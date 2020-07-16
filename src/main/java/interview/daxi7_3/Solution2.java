package interview.daxi7_3;

/**
 * @Author: yangllong
 * @DATE: 2020/7/3 19:17
 * 杭州达西公司笔试题目2
 * 缩写校验
 */
public class Solution2 {
    boolean valid(String word, String abbr) {
        //缩写为空，直接返回false
        if (abbr.length() == 0) return false;
        //获取word长度
        int len = word.length();
        //记录当前abbr已经成功匹配的长度
        int count = 0;
        //遍历abbr
        for (int i = 0; i < abbr.length(); i++) {
            //abbr当前位置为字母
            if (abbr.charAt(i) >= 'a' && abbr.charAt(i) <= 'z') {
                //与word不匹配，返回false
                if (word.charAt(count) != abbr.charAt(i)) return false;
                //匹配成功，count+1
                count++;
            } else {//abbr当前位置为数字
                //数字的大小
                int num = 0;
                //标志是否是第一次进入while循环
                boolean first = true;
                //依次往下读取，直到不为数字
                while (i < abbr.length() && abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                    //第一次进入while循环，num+当前字符的数值
                    if (first) num += abbr.charAt(i) - '0';
                        //不是第一次进入，num*10+当前字符的数值
                    else num = num * 10 + (abbr.charAt(i) - '0');
                    //修改标志位
                    first = false;
                    //判断下一位字符是否为数字
                    i++;
                }
                //能成功匹配的位数
                count += num;
                //长度超过，直接返回false
                if (count > len) return false;
                //while循环判断多加了一次
                i--;
            }
        }
        return len == count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.valid("internationalization", "i12iz4n"));
        System.out.println(solution2.valid("apple", "a2le"));
        System.out.println(solution2.valid("aaaa", "2a1"));
    }
}
