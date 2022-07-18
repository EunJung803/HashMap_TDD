import java.util.ArrayList;
import java.util.List;

public class HashMap<K, D> {
    private Object[] keys;
    private Object[] datas;
    int size;

    HashMap() {
        size = 0;
        keys = new Object[2];
        datas = new Object[keys.length];
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

        sizeUpArrWhenFull();

        keys[size] = key;
        datas[size] = data;
        size++;
    }

    private void sizeUpArrWhenFull() {
        if (isFull()) {
            sizeUpArr();
        }
    }

    private void sizeUpArr() {
        keys = Util.arr.sizeUp(keys);
        datas = Util.arr.sizeUp(datas);
    }

    private boolean isFull() {
        return size == keys.length;
    }

    public D get(K key) {
        int index = indexOfkey(key);
        if(index == -1) {
            return null;
        }
        return (D) datas[index];
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        int index = indexOfkey(key);

        if(index == -1) {
            return ;
        }

//        for(int i=index; i<size; i++) {
//            keys[i] = keys[i+1];
//            datas[i] = datas[i+1];
//        }
        Util.arr.moveLeft(keys, index + 1, size - 1);
        Util.arr.moveLeft(datas, index + 1, size - 1);

        size--;
    }

    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();

        for(int i=0; i<size; i++) {
            keySet.add((K)keys[i]);
        }

        return keySet;
    }
}
