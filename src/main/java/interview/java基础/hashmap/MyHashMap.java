package interview.java基础.hashmap;


public class MyHashMap<K, V> implements MyMap<K, V> {

    //数组加链表
    private Entry<K, V>[] table;
    private int size = 0;
    private static int defaultLength = 16;

    public MyHashMap() {
        table = new Entry[defaultLength];
    }

    @Override
    public V put(K k, V v) {
        //1.key进行hash  2.对应数组下标  3.如果是null  4.是否可以存储
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (null == entry) {
            table[index] = new Entry<>(k, v, null, index);
        } else {
            table[index] = new Entry<>(k, v, entry, index);
        }
        size++;

        return table[index].getValue();
    }

    private int hash(K k) {
        int index = k.hashCode() % (defaultLength - 1);
        return Math.abs(index);
    }

    @Override
    public V get(K k) {

        if (size == 0) {
            return null;
        }
        //hash出来的index  获取到当前Entry对象  判断对象有没有值  比较 在继续查找直到  key  hashcode
        int index = hash(k);

        Entry<K, V> entry = getEntry(k, index);

        return entry == null ? null : entry.getValue();
    }

    private Entry<K, V> getEntry(K k, int index) {
        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.hash == index && (k == entry.getKey() || k.equals(entry.getKey()))) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    static class Entry<K, V> implements  MyMap.Entry<K, V> {

        K k;
        V v;
        MyHashMap.Entry<K, V> next;
        int hash;

        public Entry(K k, V v, MyHashMap.Entry<K, V> next, int hash) {
            this.k = k;
            this.v = v;
            this.next = next;
            this.hash = hash;
        }


        @Override
        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }
    }
}
