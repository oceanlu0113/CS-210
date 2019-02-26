package test;

public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag "
                    + "whose capacity exceeds "
                    + "allowed maximum.");
        }

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        if (numberOfEntries == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        if (numberOfEntries == bag.length) {
            return false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal. was successful, or
     * null.
     */
    public T remove() {
        if (numberOfEntries == 0) {
            return null;
        } else {
            T temp = bag[numberOfEntries];
            bag[numberOfEntries] = null;
            numberOfEntries--;
            return temp;
        }
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        int temp = 0;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i].equals(anEntry)) {
                temp = i;
            } else {
                temp = -1;
            }
        }
        if (temp == -1) {
            return false;
        } else {
            bag[temp] = null;
            return true;
        }
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        for (int i = 0; i < bag.length; i++) {
            bag[i] = null;
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i].equals(anEntry)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        boolean t = false;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i].equals(anEntry)) {
                t = true;
            }
        }
        return t;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag. Note: If
     * the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        T[] array = (T[]) new Object[bag.length];
        for (int i = 0; i < bag.length; i++) {
            array[i] = bag[i];
        }
        this.clear();
        return array;
    }
}
