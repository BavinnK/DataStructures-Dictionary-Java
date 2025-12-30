import java.util.TreeMap;

public class Dictionary {
    /*
     * first we will use TreeMap, bc TreeMap is going to sort everything in
     * alphabetic order, so we dont have to worry about that.
     * second we will save two things in each node a key which is the word that we
     * saved, and a value which is a definition of the word or the Key.
     * third i used a comparator which is 'String.CASE_INSENSITIVE_ORDER' what does
     * this do ?
     * without it if you added 'Apple' and then searched for 'apple' the program
     * would say 'Not Found.'' Also, when sorting, all Uppercase words (A-Z) would
     * come before all lowercase words (a-z).
     * with it this is a 'comparator'' it tells the TreeMap: Hey, when you're
     * sorting these words or looking them up, treat 'A' and 'a' as the exact same
     * thing.
     */
    public TreeMap<String, String> data = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void addWord(String word, String def) {
        if (word == null || def == null) {
            System.out.println(" please fill out both word and definition. ");
            return;
        }

        data.put(word, def);
        System.out.println(" data added successfully! ");
    }

    public static void main(String[] args) {
        Dictionary dict=new Dictionary();
        dict.addWord("Bavin", "Embedded systems engineer");
    }
}