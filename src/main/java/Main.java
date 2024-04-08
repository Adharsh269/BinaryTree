public class Main {
  public static void main(String[] args) {
    BinaryTree tree=new BinaryTree();
    tree.insert("a1");
    tree.insert("a2");
    tree.insert("a3");
    tree.insert("a4");
    tree.insert("a5");
    tree.insert("a6");
    tree.insert("a7");
    tree.insert("a8");

    tree.levelOrder();
    System.out.println();
    tree.deleteNode("a1");
    tree.levelOrder();
  } 
}