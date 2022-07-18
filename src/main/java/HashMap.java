public class HashMap<K, D> {
    private Object[] keys;
    private Object[] datas;
    int size;

    HashMap() {
        size = 0;
        keys = new Object[100];
        datas = new Object[100];
    }

    private int indexOfkey(K key) {
        for(int i=0; i<size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    public void put(K key, D data) {
        int index = indexOfkey(key);

        if(index != -1) {
            datas[index] = data;
            return ;
        }

        keys[size] = key;
        datas[size] = data;
        size++;
    }

    public D get(K key) {
        int index = indexOfkey(key);
        if(index == -1) {
            return null;
        }
        return (D) datas[index];
    }
}
