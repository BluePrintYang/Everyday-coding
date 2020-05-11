import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        while(n-->0){
            String str1 = s.nextLine();
            int len = str1.length();
            if(len<3)System.out.println(str1);
            if(len==3){
                if(str1.charAt(0)==str1.charAt(1)&&str1.charAt(1)==str1.charAt(2))
                    System.out.println(""+str1.charAt(0)+str1.charAt(1));
                else  System.out.println(str1);
            }
            if(len>3){
                System.out.print(str1.charAt(0));
                System.out.print(str1.charAt(1));
                if (str1.charAt(2)==str1.charAt(1)&&str1.charAt(1)==str1.charAt(0));
                else System.out.print(str1.charAt(2));
                for (int i = 3;i<len;i++){
                    if (str1.charAt(i)==str1.charAt(i-1)&&str1.charAt(i)==str1.charAt(i-2))
                        continue;
                    if (str1.charAt(i)==str1.charAt(i-1)&&str1.charAt(i)!=str1.charAt(i-2)&&str1.charAt(i-2)==str1.charAt(i-3))
                        continue;
                    else System.out.print(str1.charAt(i));
                }
                System.out.println();
            }


        }
    }
}