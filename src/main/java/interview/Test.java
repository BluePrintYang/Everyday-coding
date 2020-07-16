package interview;


/**
 * @Author: yangllong
 * @DATE: 2020/7/4 15:18
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ComputerStore store = new ComputerStore();
        int pcCount = 500;
        int noteCount = 500;
        for (int i = 1; i <= pcCount + noteCount; i++) {
            final int temp = i;
//            new Thread(()->{
            if (temp <= pcCount)
                store.storeComputer(new ComputerStore.PC("pc" + temp));
            else store.storeComputer(new ComputerStore.Note("note" + temp));
//            }).start();
        }

//        TimeUnit.SECONDS.sleep(5);
        int pc = 0;
        int note = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && pc <= 500) {
                /*if (pc!=500)*/
                pc++;
                System.out.println("第" + i + "次请求获取电脑，类型为PC。结果：" + store.getPC() + "还剩PC：" + (pcCount - pc));
            } else if (i % 3 == 1 && note <= 500) {
                /*if (note!=500)*/
                note++;
                System.out.println("第" + i + "次请求获取电脑，类型为Note。结果：" + store.getNote() + "还剩Note：" + (noteCount - note));
            } else {
                ComputerStore.Computer computer = store.getRandom();
                if (computer instanceof ComputerStore.PC) pc++;
                else note++;
                System.out.println("第" + i + "次请求获取电脑，类型为Random。结果：" + computer + "还剩PC：" + (pcCount - pc) + " " + "还剩Note：" + (noteCount - note));

            }
        }

//        store.storeComputer(new ComputerStore.PC("pc1"));
//        store.storeComputer(new ComputerStore.PC("pc2"));
//        store.storeComputer(new ComputerStore.Note("note1"));
//        store.storeComputer(new ComputerStore.Note("note2"));
//        System.out.println(store.getPC());
//        System.out.println(store.getPC());
//        System.out.println(store.getRandom());
//        System.out.println(store.getNote());
//        System.out.println(store.getNote());


    }
}