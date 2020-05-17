package thread.bilibili4_13;

public class SingletonTest {
    public static void main(String[] args) {

        Runnable r = Boss::getBoss;

        for (int i = 0; i < 100; i++) {
            new Thread(r).start();
        }


    }
}

class Boss {
    private Boss() {
        System.out.println("1个Boss对象被实例化了");
    }

    private static Boss instance = null;

    /*
    public static Boss getBoss(){
        synchronized (""){
            if (instance==null){
                instance = new Boss();
            }
        }
        return instance;
    }
*/
    public static synchronized Boss getBoss() {
        if (instance == null) instance=new Boss();
        return instance;
    }
}
