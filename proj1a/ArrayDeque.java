
public class ArrayDeque<T> {
    public int size;
    public int front;
    public T[] items;
    public int factor = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = -1;
    }

    public ArrayDeque(int x) {
        items = (T[]) new Object[x];
        size = 0;
        front = -1;
    }
    public int size() {
        return size;
    }

    public void addFirst(T item) {
        // init 判断
        if (size == 0) {
            size += 1;
            items[0] = item;
            front = 0;
        }
        // resize判断
        if (size >= items.length + 1) {
            resize(size * factor);
        }
        // 位置判断
        front -= 1;
        if (front == -1) {
            front = items.length - 1;
            ;
        }
        items[front] = item;
        size += 1;

    }

    public void addLast(T item) {
        // init 判断
        if (size == 0) {
            size += 1;
            items[0] = item;
            front = 0;
        }
        // resize判断
        if (size >= items.length + 1) {
            resize(size * factor);

        }
        // 位置判断
        if (front + size - 1 < items.length) {
            items[front + size - 1] = item;
        } else {
            items[front + size - 1 - items.length] = item;
        }
        size += 1;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void resize(int capacity) {
        T[] resizeCopy = (T[]) new Object[capacity];
        System.arraycopy(items, front, resizeCopy, front, size);
        items = resizeCopy;

    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            if (front + i < items.length) {
                System.out.println(items[front + i]);
            } else {
                System.out.println(items[front + i - items.length]);
            }
        }
    }

    public T removeFirst() {
        T result = items[front];
        items[front] = null;
        front += 1;
        size -= 1;
        if (front == items.length) {
            front = 0;
        }
        return result;
    }

    public T removeLast() {
        T result;
        if (front + size - 1 < items.length) {
            result = items[front + size - 1];
            items[front + size - 1] = null;

        } else {
            result = items[front + size - 1 - items.length];
            items[front + size - 1 - items.length] = null;
        }
        return result;
    }

    public T get(int index) {
        T result;
        if (front + index < items.length) {
            result = items[front + index];

        } else {
            result = items[front + index - items.length];

        }
        return result;

    }
}