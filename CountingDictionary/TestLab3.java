import java.util.Vector;
public class TestLab3 {
  public static void main(String args[]) {
    ReadFile reader = new ReadFile("TextFile1.txt");
    CountingDictionary dict = new CountingDictionary();
    reader.addFileToDict(dict);
    dict.printDict();
    //MyPriorityQueue<Word> myQ = new MyPriorityQueue<Word>(true);
    //myQ.insert(new Word("hello" , 3));
    //myQ.insert(new Word("sarah", 1));
    //myQ.insert(new Word("samantha", 1));
    //myQ.insert(new Word("hi", 7));
    /* Vector<Word> words = new Vector<Word>();
    words.add(new Word("Samantha", 1));
    words.add(new Word("hi", 7));
    words.add(new Word("hello", 3));
    words.add(new Word("sarah", 1));
    words.add(new Word("Ashira", 3));
    words.add(new Word(" ", 2));
    myQ.build(words);
    System.out.println(myQ.remove());
    System.out.println(myQ.remove());
    System.out.println(myQ.remove());
    System.out.println(myQ.remove());
    System.out.println(myQ.remove());
    System.out.println(myQ.remove()); */
    System.out.println(dict.leastCommon());
    System.out.println(dict.mostCommon());

    ReadFile readerTwo = new ReadFile("TextFile2.txt");
    CountingDictionary dictTwo = new CountingDictionary();

    ReadFile readerCommon = new ReadFile("CommonWords.txt");
    CountingDictionary common = new CountingDictionary();
    readerCommon.addFileToDict(common);

    readerTwo.addFileToDict(dictTwo, common);
     dictTwo.printDict();

  }
}
