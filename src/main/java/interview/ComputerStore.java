package interview;

/**
 * @Author: yangllong
 * @DATE: 2020/7/4 14:15
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 来，做道题
 * 需求：
 * 电脑仓库进出管理
 * 仓库会进两种类型电脑(computer)：台式机(pc)或笔记本(note)，员工来领用电脑时，有可能指定类型，也有可能随意
 * 仓库出货原则是：老设备优先出。
 * 如果你要台式机(pc)，我把最早进来的台式机给你，
 * 如果你要笔记本(note)，我把最早进来的笔记本给你，
 * 如果你随意，我就把最早进来的电脑(computer)给你
 * 要求：
 * 写一个仓库类，供其它程序调用，由你来设计该类有哪些方法，以及这些方法内部如何实现。
 * 因为是示例程序，允许程序启动后创建新仓库，程序中止仓库就销毁，所以数据放在内存中，不用数据库。
 * 注：
 * 本题首先考察程序员设计思路，能否给其它程序提供合理的调用方法，
 * 其次再看方法函数中代码是不是合理，运行效率高不高，代码是否清晰，程序员有没有好的编程习惯，有没有BUG。本题中算法不是考察重点。
 */
public class ComputerStore {

    Queue<PC> pcStore = new LinkedList<>();//存放pc的队列
    Queue<Note> noteStore = new LinkedList<>();//存放note的队列
    LinkedList<Integer> type = new LinkedList<>();//所有库存，按顺序存放类型

    interface Computer {
    }

    public static class PC implements Computer {
        String name;

        public PC(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PC{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Note implements Computer {
        String name;

        public Note(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Note{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    interface ComputerFactory {
        Computer get(Queue<? extends Computer> store);
    }

    class PCService implements ComputerFactory {

        @Override
        public Computer get(Queue<? extends Computer> store) {
            return store.poll();
        }
    }

    class NoteService implements ComputerFactory {

        @Override
        public Computer get(Queue<? extends Computer> store) {
            return store.poll();
        }
    }


    public synchronized void storeComputer(Computer computer) {
        if (computer instanceof PC) {
            pcStore.offer((PC) computer);
            type.offer(1);//1代表PC
        } else {
            noteStore.offer((Note) computer);
            type.offer(2);//2代表note
        }
    }

    public PC getPC() throws Exception {
        if (type.isEmpty()) throw new Exception("库存为空");
        PCService service = new PCService();
        if (type.peek() == 1) type.poll();
        else for (Iterator<Integer> dd = type.iterator(); dd.hasNext(); ) {
            int str = dd.next();
            if (str == 1) {
                dd.remove();
                break;
            }
        }
        return (PC) service.get(pcStore);
    }

    public Note getNote() throws Exception {
        if (type.isEmpty()) throw new Exception("库存为空");
        NoteService service = new NoteService();
        if (type.peek() == 2) type.poll();
        else for (Iterator<Integer> dd = type.iterator(); dd.hasNext(); ) {
            int str = dd.next();
            if (str == 2) {
                dd.remove();
                break;
            }
        }
        return (Note) service.get(noteStore);
    }

    public Computer getRandom() throws Exception {
        if (type.isEmpty()) throw new Exception("库存为空");
        int pcType = type.peek();
        if (pcType == 1) return getPC();
        return getNote();
    }
}
