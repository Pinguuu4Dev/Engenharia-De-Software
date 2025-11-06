public class Window {
    public static void main(String[] args) {
        BinaryTree mainTree = new BinaryTree();
        mainTree.insertNode(8);
        mainTree.insertNode(3);
        mainTree.insertNode(10);
        mainTree.insertNode(1);
        mainTree.insertNode(6);
        mainTree.insertNode(14);
        mainTree.insertNode(4);
        mainTree.insertNode(7);
        mainTree.insertNode(13);

        for (BinaryTree it = mainTree; it.hasNext(); ) {
            System.out.println(it.next().value + " ");
        }
    }
}
