package algorithm.queue;

/**
 * @author sby
 * @Title: LInkedQueue
 * @Description: 用数组实现的队列(链式队列)
 * @date 2018/11/1 13:47
 */
public class LinkedQueue {

    private Node head;
    private Node tail;

    // 入队
    public boolean enqueue(String item) {

        Node node = new Node(item, null);

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }

        return true;
    }


    // 出队
    public String dequeue() {

        if (head == null) {
            return null;
        }


        String retNode = head.getData();

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        return retNode;
    }


    public class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

}
