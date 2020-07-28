package datastructure.tiba;

public class _神奇的数字 {

    public static String change(String number) {
        // write code here
        if (number.length() == 0 || number.trim().equals("")) return number;
        char[] c = number.toCharArray();
        int start = 0;
        int end = number.length() - 1;
        while (start < end) {
            if (Integer.parseInt(String.valueOf(c[start])) % 2 != 0) {
                start++;
                continue;
            }
            if (Integer.parseInt(String.valueOf(number.charAt(end))) % 2 != 0) {
                end--;
                continue;
            }
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(change(" "));
    }
}
