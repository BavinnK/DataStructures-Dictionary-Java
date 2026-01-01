import java.util.Scanner;
import java.util.Set;
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
     * would say 'Not Found' Also, when sorting, all Uppercase words (A-Z) would
     * come before all lowercase words (a-z) this is a problem when not using that comparator.
     * with it this is a 'comparator'' it tells the TreeMap: Hey, when you're
     * sorting these words or looking them up, treat 'A' and 'a' as the exact same
     * thing.
     */
    public TreeMap<String, String> data = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    //add word and with its definition
    public void addWord(String word, String def) {
        if (word == null || def == null) {
            System.out.println(" please fill out both word and definition. ");
            return;
        }
        else{
        data.put(word, def);
        System.out.println(" data added successfully! ");
        }
    }
    //delete a word
    public void deleteWord(String word){
        if(word==null){
            System.out.println("Please enter a word to delete! ");
            return;
        }
        else{
            if (data.containsKey(word)) {
                data.remove(word);
                System.out.println("data removed successfully");
                
            }
            else{
                System.out.println("data not found try again");
            }
        }
    }

    public void searchWord(int pos,String letter){
        String lett=letter.toLowerCase();
        boolean found=false;

        //utlizing a set for search
        Set<String> wordset=data.keySet();
        System.out.println("---------------------------------------------------");
        System.out.println("result of the search !");
        System.out.println("---------------------------------------------------");
        for(String word: wordset){
            String lowWord=word.toLowerCase();
            boolean isMatch=false;
            if(pos==1){//at the beggining of the word
                if(lowWord.startsWith(lett)){
                    isMatch=true;
                }

            }  
            else if(pos==2){//in the middle of the word

                if(word.contains(lett)&&(!word.startsWith(lett))&&(!word.endsWith(lett))){
                    isMatch=true;
                }

            } 
            else if(pos==3){
                if (lowWord.endsWith(lett)) {
                    isMatch=true;
                }
            }

            else{
                System.out.println("please enter 1 to 3 for position ");
                return;
            }

            if (isMatch==true) {
               System.out.println("[" + word + "]: " + data.get(word));
                found = true;
            }
           
        }
         if (found==false) {
                System.out.println("Fatal: no words matches that criteria! ");
            }
    }
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Dictionary dict=new Dictionary();
        dict.addWord("Bavin", "Embedded systems engineer");
        dict.addWord("house", "place to live in");
        dict.addWord("banana", "a yellow fruit");
        dict.addWord("car", "gets you almost everywhere");
        dict.addWord("bat", "a flying mammal");
        dict.addWord("data", "information");
        dict.addWord("earth", "the blue and green planet");
        dict.addWord("mobile", "you use it everyday");
        dict.addWord("Lion", "king of the forest");

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("\n--- DICTIONARY MENU ---");
            System.out.println("1. Search for a Word");
            System.out.println("2. Add a New Word");
            System.out.println("3. Delete a Word");
            System.out.println("4. View All Words");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int op=input.nextInt();
            System.out.println("----------------------------------");

            if(op==1){
                System.out.println("enter a letter too search: ");
                String lett=input.nextLine();
                System.out.println("position of the search 1:Start, 2:Middle, 3:End ");
                int po=input.nextInt();
                dict.searchWord(po, lett);
            }
            else if(op==2){}
        }
        
    }
}