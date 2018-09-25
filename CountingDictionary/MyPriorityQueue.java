import java.util.Vector;
public class MyPriorityQueue<V extends Comparable> implements CS211PriorityQueueInterface<V> {
  private Comparable[] theQ;
  private int count;
  private boolean min;

  public MyPriorityQueue(boolean m) {
    theQ = new Comparable[400];
    theQ[0] = null;
    count = 0;
    min = m;
  }

  public void insert(V w) {
    if ( w == null) {

    }
    else {
      theQ[count + 1] = w;
      count++;
      if (min) {
        bubbleUpMin(count);
      }
      else {
        bubbleUpMax(count);
      }
    }

  }

  public void bubbleUpMin(int num) {
     V w = (V) theQ[num];
     int n = num;
     V parent = (V) theQ[(n/2)]; //problem is here you don't know if its a V
     if ( parent != null && w.compareTo(parent) < 0) {
        theQ[(n/2)] = w;
        theQ[n] = parent;
        bubbleUpMin(n/2);
     }
  }

  public void bubbleUpMax(int num) {
     int n = num;
     V w = (V) theQ[n];
     V parent = (V)theQ[(n/2)];
     if ( parent != null && w.compareTo(parent) > 0) {
        theQ[(n/2)] = w;
        theQ[n] = parent;
        bubbleUpMax(n/2);
     }
  }

  public V peek() {
    if (count == 0) {
      return null;
    }
    else {
      return (V)theQ[1];
    }
  }

  public V remove() {
    if (count == 0) {
      return null;
    }
      V toRemove = (V)theQ[1];
      V toChange = (V)theQ[count]; //last in array
      theQ[count] = null;
      theQ[1] = toChange;
      count--;
      if (min) {
        bubbleDownMin(1);
      }
      else {
        bubbleDownMax(1);
      }
      return toRemove;
  }

  public void bubbleDownMin(int n) {
    V toChange = (V) theQ[n];
    V leftChild = (V)theQ[(2 * n)];
    V rightChild = (V)theQ[((2 * n) + 1)];
    if ((2*n) < count + 1 && (2*n) + 1 < count + 1) {
      if (leftChild.compareTo(rightChild) < 0 && toChange.compareTo(leftChild) > 0) {
        theQ[n] = leftChild;
        theQ[(2 * n)] = toChange;
        bubbleDownMin( 2 * n);
      }
      else if (rightChild.compareTo(leftChild) < 0 && toChange.compareTo(rightChild) > 0) {
        theQ[n] = rightChild;
        theQ[((2 * n) + 1)] = toChange;
        bubbleDownMin((2*n) + 1);
      }
    }
    else if ((2*n) < count + 1 && toChange.compareTo(leftChild) > 0) {
      theQ[n] = leftChild;
      theQ[(2 * n)] = toChange;
      bubbleDownMin(2 * n);
    }
    else {

    }
  }

  public void bubbleDownMax(int n){
    V toChange = (V) theQ[n];
    V leftChild = (V)theQ[(2 * n)];
    V rightChild = (V)theQ[((2 * n) + 1)];
    if ((2*n) < count + 1 && (2*n) + 1 < count + 1) {
      if (leftChild.compareTo(rightChild) > 0 && toChange.compareTo(leftChild) < 0) {
        theQ[n] = leftChild;
        theQ[(2 * n)] = toChange;
        bubbleDownMax(2 * n);
      }
      else if (rightChild.compareTo(leftChild) > 0 && toChange.compareTo(rightChild) < 0) {
        theQ[n] = rightChild;
        theQ[((2 * n) + 1)] = toChange;
        bubbleDownMax((2*n) + 1);
      }
    }
    else if ( (2*n) < count + 1 && toChange.compareTo(leftChild) < 0) {
      theQ[n] = leftChild;
      theQ[(2 * n)] = toChange;
      bubbleDownMax(2 * n);
    }
    else {

    }


  }

  public void build(Vector<V> words) {
    if (words == null) {

    }
    else {
      for (int i = 1; i < words.size() + 1; i++) {
        theQ[i] = words.get(i - 1);
        //System.out.println((V)theQ[i]);
      }
      count = words.size();
      int n = words.size();
      //wrong here
      for (int i = n/2; i > 0; i--){
        if (min){
          bubbleDownMin(i);
        }
        else {
          bubbleDownMax(i);
        }
      }
    }

  }

  public boolean isEmpty() {
    if (count == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  public Vector<V> firstTen() {
    Vector<V> words = new Vector<V>();
    for (int i = 0; i < 10; i++) {
      words.add((V)remove());
    }
    return words;
  }

}
