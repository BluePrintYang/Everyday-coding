package interview.lanqiao.java2013a;

public class _10大臣的旅费 {

    static int dis2money(int dis){
        return 11*dis+dis*(dis-1)/2;
    }

    public static void main(String[] args) {
        System.out.println(dis2money(9));
    }
}
