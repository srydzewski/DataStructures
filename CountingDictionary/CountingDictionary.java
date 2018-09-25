import java.util.Vector;
public class CountingDictionary implements CS211CountingDictionaryInterface {
  private Node root;

  public CountingDictionary() {
    root = null;
  }

  public Node getRoot() {
    return root;
  }

  public void insert(String key) {
    Node toInsert;
    if (root == null) {
      root = new Node(key, 1);
    }
    else {
      boolean placed = false;
      toInsert = new Node(key, 1);
      Node current = root;
      Node parent = null;
      while(placed == false) {
        parent = current;
        //check to see if I found the Node
        if (toInsert.getKey().compareTo(current.getKey()) == 0) {
          current.setValue(current.getValue().getCount() + 1);
          placed = true;
        }
        //Checking left side
        else if (toInsert.getKey().compareTo(current.getKey()) < 0) {
          current = current.getLeftChild();
          if (current == null){
            parent.setLeftChild(toInsert);
            placed = true;
          }

        }
        //checking right side
        else {
          current = current.getRightChild();
          if (current == null) {
            parent.setRightChild(toInsert);
            placed = true;
          }
        }
      }
    }
  }
  public boolean delete(String key) {
    return true;
    //BST so I dont need to implement delete
  }

  public int find(String key){
    String word = key.toLowerCase();
    Node current = root;
    if (root == null) {
      return -1;
    }
    while (true) {
      //check to see if you found the word
      if(current.getKey().compareTo(word) == 0) {
        return current.getValue().getCount();
      }
      //move down the tree on the left
      else if (word.compareTo(current.getKey()) < 0 ) {
        current = current.getLeftChild();
        if (current == null) {
          return -1;
        }
      }
      //move down the tree on the right
      else {
        current = current.getRightChild();
        if (current == null) {
          return -1;
        }
      }
    }
  }

  public Vector<Word> allKeyValue() {
    if (root == null) {
      return null;
    }
    else {
      Vector<Word> list = new Vector<Word>();
      root.traverse(list);
      return list;
    }

  }

  public void printDict() {
    Vector<Word> list = allKeyValue();
    if (list != null) {
      for (Word w : list) {
        System.out.println(w.getWord() + " count: " + w.getCount());
      }
    }
  }

  public Vector<Word> leastCommon() {
    MyPriorityQueue<Word> myQ = new MyPriorityQueue<Word>(true);
    myQ.build(allKeyValue());
    return myQ.firstTen();
  }

  public Vector<Word> mostCommon() {
    MyPriorityQueue<Word> myQ = new MyPriorityQueue<Word>(false);
    myQ.build(allKeyValue());
    return myQ.firstTen();
  }
}
