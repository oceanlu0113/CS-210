public class LList<T> implements ListInterface<T> {

    private T[] list;
    private int entries;

    public LList() {
        this(25);
    }

    public LList(int capacity) {
        list = (T[]) new Object[capacity];
        entries = 0;
    }

    public void add(T newEntry) {
        if (entries >= 1 && entries <= list.length) {
            list = newDeck();
            list[entries] = newEntry;
            entries++;
        }
    }

    public void add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition <= entries + 1) {
            if (newPosition <= entries) {
                addMore(newPosition);
                list[newPosition] = newEntry;
                entries++;
            } else {
                throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
            }
        }
    }

    public T remove(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= entries)) {
            T element = list[givenPosition];
            if (givenPosition < entries) {
                cut(givenPosition);
            }
            entries--;
            return element;
        } else {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
    }

    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
        entries = 0;
    }

    public T replace(int givenPosition, T newEntry) {
        T element = list[givenPosition];
        list[givenPosition] = newEntry;
        return element;
    }

    public T getEntry(int givenPosition) {
        return list[givenPosition];
    }

    public boolean contains(T anEntry) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return entries;
    }

    public boolean isEmpty() {
        if (entries == 0) {
            return true;
        }
        return false;
    }

    private T[] newDeck() {
        int newCap = 2 * list.length;
        T[] tempList = (T[]) new Object[newCap];
        for (int i = 0; i < tempList.length; i++) {
            tempList[i] = list[i];
        }
        return tempList;
    }

    private void addMore(int position) {
        if (entries == list.length) {
            list = newDeck();
        }
        for (int i = entries; i >= position; i--) {
            list[i + 1] = list[i];
        }
    }

    private void cut(int position) {
        for (int i = position; i < entries; i++) {
            list[i] = list[i + 1];
        }
    }
}
