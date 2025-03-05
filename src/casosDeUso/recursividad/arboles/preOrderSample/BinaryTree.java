package arboles.preOrderSample;

class BinaryTree {

    Node root;

    BinaryTree() {
        root = null;
    }

    void printPreorder(Node node) {
        if (node == null){
            return;
        }

        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
