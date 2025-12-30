import java.util.*;

public class SimpsonDictionary {
    // Public data structure: TreeMap keeps it sorted, keySet() is our Set
    public TreeMap<String, String> data = new TreeMap<>();

    // Add a new word and definition
    public void addWord(String word, String definition) {
        data.put(word, definition);
        System.out.println("Word added successfully!");
    }

    // Delete a word
    public void deleteWord(String word) {
        if (data.containsKey(word)) {
            data.remove(word);
            System.out.println("Word deleted.");
        } else {
            System.out.println("Word not found.");
        }
    }

    // The search logic you described
    public void search(String letter, int pos) {
        String l = letter.toLowerCase();
        boolean found = false;

        // We explicitly use the Set of words for searching
        Set<String> allWords = data.keySet();

        System.out.println("\n--- Results ---");
        for (String word : allWords) {
            String lowWord = word.toLowerCase();
            boolean match = false;

            if (pos == 1 && lowWord.startsWith(l)) match = true;
            if (pos == 2 && lowWord.endsWith(l)) match = true;
            if (pos == 3 && lowWord.contains(l) && !lowWord.startsWith(l) && !lowWord.endsWith(l)) match = true;

            if (match) {
                System.out.println("[" + word + "]: " + data.get(word));
                found = true;
            }
        }
        if (!found) System.out.println("No matches found for '" + letter + "'.");
    }

    public static void main(String[] args) {
        SimpsonDictionary dict = new SimpsonDictionary();
        Scanner sc = new Scanner(System.in);

        // Pre-filling some words for the demo
        dict.addWord("Apple", "A common round fruit.");
        dict.addWord("Banana", "A long yellow fruit.");
        dict.addWord("Cat", "A small feline.");
        dict.addWord("Area", "A specific region or space.");
        dict.addWord("Bat", "A nocturnal flying mammal.");

        while (true) {
            System.out.println("\n--- SIMPSON DICTIONARY MENU ---");
            System.out.println("1. Search for a Word");
            System.out.println("2. Add a New Word");
            System.out.println("3. Delete a Word");
            System.out.println("4. View All Words");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter letter to search: ");
                String letter = sc.nextLine();
                System.out.print("Position (1=Start, 2=End, 3=Middle): ");
                int pos = sc.nextInt();
                dict.search(letter, pos);

            } else if (choice == 2) {
                System.out.print("Enter word: ");
                String w = sc.nextLine();
                System.out.print("Enter definition: ");
                String d = sc.nextLine();
                dict.addWord(w, d);

            } else if (choice == 3) {
                System.out.print("Enter word to delete: ");
                String w = sc.nextLine();
                dict.deleteWord(w);

            } else if (choice == 4) {
                System.out.println("\nEntire Dictionary:");
                for(String key : dict.data.keySet()) {
                    System.out.println(key + " - " + dict.data.get(key));
                }

            } else if (choice == 5) {
                System.out.println("Exiting... Goodbye!");
                break;
            }
        }
        sc.close();
    }
}