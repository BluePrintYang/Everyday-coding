package interview.bytedance5_11;

import java.util.Scanner;
import java.util.Stack;

/**
 * 文本编辑器
 * 输入：
 * 第一行 N N个命令
 * 每一行一个命令
 * 1 xx 追加xx到内容后面
 * 2 k  删除最后k个字符
 * 3 k  输出S的第k个字符
 * 4 回滚上一步对S的操作，只有1和2
 * <p>
 * 8
 * 1 abc
 * 3 3
 * 2 3
 * 1 xy
 * 3 2
 * 4
 * 4
 * 3 1
 */
public class Main1 {

    private static Stack<Integer> stack;//保存操作，方便回滚（只保存1，2）
    private static int[] command;//命令数组
    private static String[] val;//命令对应的值的数组
    private static StringBuilder str;//文本框中的内容
    private static Stack<String> del;//删除操作删除的字符串

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        str = new StringBuilder();
        int N = s.nextInt();
        command = new int[N];
        val = new String[N];
        for (int i = 0; i < N; i++) {
            command[i] = s.nextInt();
            val[i] = s.nextLine();
        }
        //去除输入的空格
        for (int i = 0; i < val.length; i++) {
            if (!val[i].equals("")) {
                StringBuilder ss = new StringBuilder(val[i]);
                ss.deleteCharAt(0);
                val[i] = String.valueOf(ss);
            }
        }

        stack = new Stack<>();
        del = new Stack<>();

        //遍历命令字符串数组，依次执行命令
        for (int i = 0; i < N; i++) {
            //命令1，追加字符串
            if (command[i] == 1) str.append(val[i]);
            //命令2，删除字符串
            if (command[i] == 2) {
                //将删除的字符串存入del栈中，方便回滚
                if (Integer.parseInt(val[i]) >= str.length()) del.push(String.valueOf(str));
                else del.push(str.substring(str.length() - Integer.parseInt(val[i]), str.length()));
                //删除字符串
                if (Integer.parseInt(val[i]) >= str.length()) str.delete(0, str.length());
                else str.delete(str.length() - Integer.parseInt(val[i]), str.length());
            }
            //命令3，输出字符
            if (command[i] == 3) {
                int index = Integer.parseInt(String.valueOf(val[i])) - 1;
                System.out.println(str.charAt(index));
            }
            //命令4，回滚
            if (command[i] == 4) rollback();
            //命令1，2依次入栈，存储的是数组的索引
            if (command[i] != 4 && command[i] != 3) stack.push(i);
        }
    }

    //回滚函数
    private static void rollback() {
        int index = stack.pop();//获取栈顶元素，即上一次执行的操作的数组索引
        int cmd = command[index];//根据索引获取命令
        String value = val[index];//根据索引获取命令对应的值
        //上次命令为1，追加字符串，回滚则删除追加的字符串
        if (cmd == 1) {
            int len = value.length();
            str.delete(str.length() - len, str.length());
        }
        //上次命令为2，删除字符串，回滚则追加删除的字符串
        if (cmd == 2) str.append(del.pop());
    }

}

