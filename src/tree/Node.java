package tree;

/**
 * TODO
 * @author sby
 * @date 2021/7/28 15:12
 */
public class Node<T> {

    private Node<T> left;
    private Node<T> right;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public T getData() {
        return this.data;
    }
}
