public class BinaryTree {
    Node root;

    public void insertNode(int value){
        Node newNode = new Node(value);

        if (this.root == null){
            root = newNode;
        }

        Node current = root;
        Node parent = null;

        while(current != null){
            if (value < current.value){
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }
}
