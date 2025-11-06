import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Iterator<Integer> {
    Node root;

    public void insertNode(int value){
        Node newNode = new Node(value);

        if (this.root == null){
            root = newNode;
        }

        Node current = root;
        Node parent = null;

        while(current != null){
            parent = current;

            if (value < current.value){
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (value < parent.value){
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public Iterator<Integer> iterator(){
        return new newIterator(this.root);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return 0;
    }

    private static class newIterator implements Iterator<Integer>{
        private Queue<Node> queue = new LinkedList<>();
        public newIterator(Node _root){
            queue.add(_root);
        }

        @Override
        public boolean hasNext(){
            return !queue.isEmpty();
        }

        @Override
        public Integer next(){
            Node node = queue.remove();
            int nodeValue = node.value;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            return nodeValue;
        }
    }
}
