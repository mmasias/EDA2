package arboles.inOrderSample;

class BinaryTree {

	Node root;

	BinaryTree() { 
        root = null; 
    }

	void printInorder(Node node){
		if (node == null){
			return;
        }

		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}


}
