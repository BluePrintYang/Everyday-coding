package interview.bytedance5_11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入：
 * 第一行表示文章，长度不超过50000
 * 第二行，正整数[2,50000]，字典单词
 * N行，每行一个单词
 *
 * 输出:
 * 文章翻译种数对835672545取余
 * 无法翻译输出0
 *
 * 示例：
 * abcba
 * 5
 * ab
 * cb
 * bc
 * ba
 * a
 *
 * 输出
 * 2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String article = s.nextLine();
        int N = s.nextInt();
        Set<String> set = new HashSet<>();
        s.nextLine();
        while (N>0){
            set.add(s.nextLine());
            N--;
        }



    }
}

