public class LDeque<T> implements DequeInterface<T> {

    private DLNode first;
    private DLNode last;

    private static class EmptyQueueException extends Exception {

        private EmptyQueueException() {
            this("EmptyQueueException");
        }

        private EmptyQueueException(String msg) {
            super(msg);
        }
    }

    private class DLNode {

        private T element; //element stored in this node
        private DLNode prev;    //previous node in list
        private DLNode next;    //next node in list

        private DLNode() { //default constructor
            this(null, null, null);
        }

        private DLNode(T element, DLNode prev, DLNode next) { //specific constructor
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        private T getElement() { //gets data
            return element;
        }

        private void setElement(T element) { //sets data
            this.element = element;
        }

        private DLNode getNext() { //gets next node
            return next;
        }

        private void setNext(DLNode next) { //sets next node
            this.next = next;
        }

        private DLNode getPrev() { //get previous node
            return prev;
        }

        private void setPrev(DLNode prev) { //set pervious node
            this.prev = prev;
        }
    }

    public void addToFront(T newEntry) {
        DLNode node = new DLNode(newEntry, first, last); //(T element, DLNode prev, DLNode next)
        if (isEmpty()) {
            last = node;
        } else {
            first.setPrev(node);
        }
        first = node;
    }

    public void addToBack(T newEntry) {
        DLNode node = new DLNode(newEntry, last, first); //(T element, DLNode prev, DLNode next)
        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node);
        }
        last = node;
    }

    public T removeFront() {
        T front = getFront();
        if (front.equals(null)) {
            try {
                throw new EmptyQueueException();
            } catch (EmptyQueueException e) {
                System.out.print(e);
            }
        }
        first = first.getNext();
        if (first == null) {
            last = null;
        } else {
            first.setPrev(null);
        }
        return front;
    }

    public T removeBack() {
        T back = getBack();
        if (back.equals(null)) {
            try {
                throw new EmptyQueueException();
            } catch (EmptyQueueException e) {
                System.out.print(e);
            }
        }
        last = last.getPrev();
        if (last == null) {
            first = null;
        } else {
            last.setNext(null);
        }
        return back;
    }

    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = first.getElement();
        }
        return front;
    }

    public T getBack() {
        T back = null;
        if (!isEmpty()) {
            back = last.getElement();
        }
        return back;
    }

    public boolean isEmpty() {
        if (first == null && last == null) {
            return true;
        }
        return false;
    }

    public void clear() {
        first = null;
        last = null;
    }
}
