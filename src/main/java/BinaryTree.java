import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree{
  BinaryNode root;
  BinaryTree(){
    root=null;
  }
  public void insert(String data){
    BinaryNode newNode=new BinaryNode();
    newNode.data=data;
    if(root==null){
      root=newNode;
      System.out.println("Root element is successfully inserted.");
      return;
    }
    Queue<BinaryNode> qu=new LinkedList<BinaryNode>();
    qu.add(root);
    while(!qu.isEmpty()){
      BinaryNode pNode=qu.remove();
      if(pNode.left==null){
         pNode.left=newNode;
        System.out.println("Node is successfullt inserted.");
        break;
      }else if(pNode.right==null){
        pNode.right=newNode;
        System.out.println("Node is successfullt inserted.");
        break;
      }else{
        qu.add(pNode.left);
        qu.add(pNode.right);
      }
    }
  }

  public void levelOrder(){
    Queue<BinaryNode> q=new LinkedList<BinaryNode>();
    q.add(root);
    while(!q.isEmpty()){
      BinaryNode pNode=q.remove();
      System.out.print(pNode.data+" ");
      if(pNode.left!=null){
        q.add(pNode.left);
      }
      if(pNode.right!=null){
        q.add(pNode.right);
      }

    }
  }

  public void preOrder(BinaryNode node){
    if(node==null) return;
    System.out.print(node.data+" ");
    preOrder(node.left);
    preOrder(node.right);
  }
  public void inOrder(BinaryNode node){
    if(node==null) return;
    inOrder(node.left);
    System.out.print(node.data+" ");
    inOrder(node.right);
  }
  public void postOrder(BinaryNode node){
    if(node==null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data+" ");
  }

  public BinaryNode search(String data){
    Queue<BinaryNode> qq=new LinkedList<BinaryNode>();
    qq.add(root);
    while(!qq.isEmpty()){
      BinaryNode presentNode=qq.remove();
      if(presentNode.data==data){
        System.out.println("Value found");
        return presentNode;
      }else{
        if(presentNode.left!=null){
          qq.add(presentNode.left);
        }
        if(presentNode.right!=null){
           qq.add(presentNode.right);
        }
      }
    }
    System.out.println("Value not found");
    return null;
  }

  //get deepest node
  public BinaryNode getDeepestNode(){
    Queue<BinaryNode> qq=new LinkedList<BinaryNode>();
    qq.add(root);
    BinaryNode presentNode=null;
    while(!qq.isEmpty()){
      presentNode=qq.remove();
      if(presentNode.left!=null){
        qq.add(presentNode.left);
      }
      if(presentNode.right!=null){
        qq.add(presentNode.right);
      }
    }
    return presentNode;
  }

  //delete deepestnode
  public void deleteDeepestNode(){
    Queue<BinaryNode> qq=new LinkedList<BinaryNode>();
    qq.add(root);
    BinaryNode prevNode,presentNode=null;
    while(!qq.isEmpty()){
      prevNode=presentNode;
      presentNode=qq.remove();
      if(presentNode.left==null){
        prevNode.right=null;
        return;
      }else if(presentNode.right==null){
        presentNode.left=null;
        return;
      }else{
        qq.add(presentNode.left);
        qq.add(presentNode.right);
      }
    }
  }

  //delete node
  public void deleteNode(String value){
    if(root==null){
      System.out.println("Binary tree does not exist");
      return;
    }
    Queue<BinaryNode> queue=new LinkedList<BinaryNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryNode presentNode=queue.remove();
      if(presentNode.data==value){
        presentNode.data=getDeepestNode().data;
        deleteDeepestNode();
        return;
      }else{
        if(presentNode.left!=null){
          queue.add(presentNode.left);
        }
        if(presentNode.right!=null){
          queue.add(presentNode.right);
        }
      }
    }
    System.out.println("Value does not exist");
  }

  //delete binary tree
  public void delete(){
    if(root==null){
      System.out.println("Binary tree does not exist");
      return;
    }
    root=null;
    System.out.println("Binary Tree is deleted.");
  }
}