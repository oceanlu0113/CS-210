public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack;
    private int topIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    }

    private T[] copyOf(T[] stackData, int length) {
        T[] newStack = (T[]) new Object[length];
        for (int i = 0; i < stackData.length; i++) {
            newStack[i] = stackData[i];
        }
        return newStack;
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag whose " + "capacity exeeds allowed " + "maximum of " + MAX_CAPACITY);
        }
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("ArrayBag object is not initialized properly.");
        }
    }

    public void push(T newEntry) {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    private void ensureCapacity() {
        if (topIndex == stack.length - 1) {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = copyOf(stack, newLength);
        }
    }

    public T peek() {
        checkInitialization();
        if (isEmpty()) {
            throw new InvalidExpressionException("EmptyStackException Error.");
        } else {
            return stack[topIndex];
        }
    }

    public T pop() {
        checkInitialization();
        if (isEmpty()) {
            throw new InvalidExpressionException("EmptyStackException.");
        } else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public void clear() {
        while (topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        }
    }
}
