package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * @author sby
 * @date 2021/7/28 15:13
 */
public class BinTree {

    private Node<Integer> root;

    private void create(int[] objs) {

        List<Node<Integer>> list = new ArrayList<>();

        for (int obj : objs) {
            list.add(new Node<>(obj));
        }

        root = list.get(0);

        for (int i = 0; i < list.size() / 2; i++) {
            Node<Integer> node = list.get(i);
            node.setLeft(list.get(i * 2 + 1));
            if (i * 2 + 2 < list.size()) {
                node.setRight(list.get(i * 2 + 2));
            }
        }
    }

    public static void preOrder(Node<Integer> node) {
        if (node != null) {
            preOrder(node.getLeft());
            System.out.println(node.getData());
            preOrder(node.getRight());
        }
    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        int[] a = {7, 4, 9, 2, 6, 8, 10, 1, 3, 5};
        binTree.create(a);
        preOrder(binTree.root);
    }
}
