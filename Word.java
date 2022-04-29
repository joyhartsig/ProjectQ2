import java.lang.reflect.Array;
import java.util.ArrayList;

public class Word implements Comparable<Word> {
    private String w;
    private int count;

    private ArrayList<Integer> lines = new ArrayList<Integer>();

    public Word(String w, int line) {
        super();
        this.w = w;
        this.count = 1;
        
        lines.add(line);

    }

    public void addOccurance(int line) {
        if(!lines.contains(line)){
            lines.add(line);
            count++;
        }
        lines.add(line);
        count++;
    }

    @Override
    public String toString() {        
        String s = w + "(" + count + "):";

        int i=0;

        for(i=0;i<lines.size()-1;i++) {

            s += lines.get(i) + ", ";

        }

        s += lines.get(i) + "\n";
        //System.out.println(lines);
        return s;

    }

    @Override

    public int compareTo(Word o) {

        // TODO Auto-generated method stub

        return this.w.compareTo(o.w);

    }

}