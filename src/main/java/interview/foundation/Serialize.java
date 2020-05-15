package interview.foundation;

import java.io.*;

public class Serialize implements Serializable {

    private static final long serialVersionUID = -5211389707739541364L;
    public int num = 1390;

    public void serialized()
    {
        try {
            FileOutputStream fos = new FileOutputStream("serialize.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Serialize serialize = new Serialize();
            oos.writeObject(serialize);
            oos.flush();
            oos.close();//只是为了方便简洁的做个例子，真实编程要放到finally下，懂的人你懂的。
            fos.close();
            System.out.println("序列化结束");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialized()
    {
        Serialize serialize = null;
        try
        {
            FileInputStream fis = new FileInputStream("serialize.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);

            serialize = (Serialize) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("反序列化结束");
        }
        catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(serialize.num);
    }

    public static void main(String[] args)
    {
        Serialize serialize = new Serialize();
        serialize.serialized();
        serialize.deserialized();
    }
}
