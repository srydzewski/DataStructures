import java.util.Vector;
public class Node {

private String key;
private Word value;
private Node leftChild;
private Node rightChild;

public Node(String k, int v) {
  key = k.toLowerCase();
  value = new Word(key, v);
  leftChild = null;
  rightChild = null;

}

public String getKey() {
  return key;
}

public void setKey(String k) {
  key = k;
}

public Word getValue() {
  return value;
}

public void setValue(int v) {
  value = new Word(key,v);
}

public void setLeftChild(Node l) {
  leftChild = l;
}

public Node getLeftChild() {
  return leftChild;
}

public void setRightChild(Node r) {
  rightChild = r;
}

public Node getRightChild() {
  return rightChild;
}

public void traverse(Vector<Word> list) {
  if (leftChild != null) {
    leftChild.traverse(list);
  }
  list.add(value);
  if (rightChild != null) {
    rightChild.traverse(list);
  }

}
}
