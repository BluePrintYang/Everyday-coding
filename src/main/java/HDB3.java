import java.util.Scanner;

public class HDB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info1 = scanner.nextLine();//信息码
        StringBuilder info = new StringBuilder(info1);
        int index = 0;//位置指针
        boolean flag = false;
        //检查输入是否合法
        for (int i = 0; i < info1.length(); i++) {
            if (info1.charAt(i) != '0' && info1.charAt(i) != '1') {
                System.out.println("输入有误");
                break;
            }
        }
        //将有连续4个0的部分替换为V
        for (int i = 3; i < info1.length(); i++) {
            if (info.charAt(i-3) == '0' && info.charAt(i - 2) == '0' && info.charAt(i - 1) == '0' && info.charAt(i) == '0') {
                info.replace(i, i + 1, "V");
            }
        }

        //info1也改为有V
        info1 = ""+info;

        for (int i=0;i<info1.length();i++){
            if (info1.charAt(i)!='0'){
                //1的处理
                if (info1.charAt(i)=='1'){
                    if (flag)info.replace(i+index,i+1+index,"-1");
                    else info.replace(i+index,i+1+index,"+1");
                    index++;
                    flag=!flag;
                }
                //V的处理
                if (info1.charAt(i)=='V'){
                    if (flag)info.replace(i+index,i+1+index,"+V");
                    else info.replace(i+index,i+1+index,"-V");
                    index++;
                    flag=!flag;
                }
            }
        }
        System.out.println(info1);
        System.out.println(info);
    }
}
