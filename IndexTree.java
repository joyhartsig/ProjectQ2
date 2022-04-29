import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IndexTree {

    private BinarySearchTree<Word> index = new BinarySearchTree<Word>();

    public IndexTree(String filename) throws FileNotFoundException{
        super();

        int count = 0;
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            count++;
            StringTokenizer st = new StringTokenizer(line,"\n");
            
            while(st.hasMoreTokens()){
                Word w = new Word(st.nextToken().toLowerCase(), count);
                index.add(w);
            }
            
        }
        sc.close();
    }

    public void addRecord(Word w, int line) {
        if(index.contains(w)) {
            Word wd = index.find(w);
            wd.addOccurance(line);
        }
        else {
            index.add(w);
        }
    }
    
    public void printIndex() {
        index.printOrderedData();
    }
}