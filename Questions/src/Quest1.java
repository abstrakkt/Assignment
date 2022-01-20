import util.Node;

public class Quest1 {
    public static void main(String[] args) {
        Node node1 = new Node(9);
        node1.left = new Node(3);
        node1.right = new Node(6);

        Node node2 = new Node(9);
        node2.left = new Node(3);
        node2.right = new Node(6);

        System.out.println(isIdentical(node1, node2));
    }

    public static boolean isIdentical(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return (first.data == second.data && isIdentical(first.left, second.left) && isIdentical(first.right, second.right));

        return false;
    }
}