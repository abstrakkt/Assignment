import util.Node;

public class Quest3 {
    static int product = 1;
    static int sum = 0;

    public static void main(String[] args) {
        Node node = new Node(9);
        node.left = new Node(6);
        node.right = new Node(3);
        node.right.left = new Node(2);
        node.right.right = new Node(7);
        node.right.left.left = new Node(3);
        node.right.left.right = new Node(5);

        mirrorTree(node);
        findLeafNodeProduct(node);
        findChildNodeSum(node);

        System.out.println("product: " + product);

        //subtract parent node data to get all child node sum
        System.out.println("Sum: " + (sum - node.data));
    }

    public static Node mirrorTree(Node node) {
        if (node == null)
            return node;

        Node left = mirrorTree(node.left);
        Node right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    public static void findLeafNodeProduct(Node node) {
        if (node.left == null && node.right == null) {
            product = product * node.data;
            return;
        }

        findLeafNodeProduct(node.left);
        findLeafNodeProduct(node.right);
    }

    public static void findChildNodeSum(Node node) {
        if (node == null)
            return;
        sum = sum + node.data;
        findChildNodeSum(node.left);
        findChildNodeSum(node.right);
    }
}
