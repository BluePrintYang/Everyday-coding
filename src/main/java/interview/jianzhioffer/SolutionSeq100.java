package interview.jianzhioffer;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class SolutionSeq100 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < (sum+1)/2; i++) {
            int s = i;
            int end = i+1;
            while (s<sum){
                s+=end;
                end++;
                if (s==sum){
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = i; j < end; j++) {
                        list.add(j);
                    }
                    lists.add(list);
                    break;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(3));
    }
}
