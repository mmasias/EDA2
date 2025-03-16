package arboles.postOrderSample;

class BinaryTree {

    Node root;

    BinaryTree() {
        root = null;
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }
}
