package leetcode;


/**
 * 2020.3.5
 * 分糖果II
 * 示例 1：
 *
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 */
public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] array=new int[num_people];
        int rest = candies;
        int last = 1;
        int index = 0;
        while (rest>0){
            array[index%num_people]+=last;
            rest-=last;
            last++;
            index++;
            if(last>=rest){
                array[index%num_people]+=rest;
                break;
            }
        }
        return array;
    }
}
