
    public class LinkedListDeque_2<T> {
        private int size;
    
        private class node {
            public T item;
            public node next;
            public node last;
    
            public node(node l, T i, node n) {
                last = l;
                next = n;
                item = i;
            }
    
        }
    
        private node sentinel;
        private node sentinelLast;
    
        private node value = sentinel;
    
        //
        public LinkedListDeque_2() {
            sentinel = new node(null, null, null);
            sentinelLast = new node(null, null, null);
            sentinel.next = sentinelLast;
            sentinelLast.last = sentinel;
    
            size = 0;
        }
    
        public void addFirst(T item) {
            node n = new node(sentinel, item, sentinel.next);
            sentinel.next = n;
            n.next.last = n;
    
            size = size + 1;
        }
    
        public void addLast(T item) {
            node l = new node(sentinelLast.last, item, sentinelLast);
            sentinelLast.last = l;
            l.last.next = l;
            size = size + 1;
    
        }
    
        public boolean isEmpty() {
            return (size == 0);
        }
    
        public int size() {
            return size;
        }
    
        public void printDeque() {
            node value = sentinel.next;
            while (value != sentinelLast) {
                System.out.print(value.item + " ");
                value = value.next;
    
            }
    
        }
    
        public T removeFirst() {
            if (sentinel.next == sentinelLast) {
                return null;
            }
            T item = sentinel.next.item;
            sentinel.next.next.last = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return item;
        }
    
        public T removeLast() {
            if (sentinelLast.last == sentinel) {
                return null;
            }
            T item = sentinelLast.last.item;
            sentinelLast.last.last.next = sentinelLast;
            sentinelLast.last = sentinelLast.last.last;
            size -= 1;
            return item;
        }
    
        public T get(int index) {
            node value;
            if (index<size/2.0){
            value = sentinel;
            while (index > 0) {
                value = value.next;
                index -= 1;
            }
        }
            else {
                value = sentinelLast;
            while (index > 0) {
                value = value.last;
                index -= 1;
            }

            }
    
            return value.item;
        }
    
        public T getRecursive(int index) {
    
            if (index == 0) {
                T item = value.next.item;
                value = sentinel;
                return item;
            } else {
                value = value.next;
                return getRecursive(index - 1);
            }
    
        }
    }
    
