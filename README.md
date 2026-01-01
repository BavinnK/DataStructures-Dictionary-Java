#  Dictionary Simulation

A Java-based dictionary application that simulates an English-to-English dictionary. This project was built to demonstrate the efficient use of data structures like `TreeMap` and `Set` for high-performance searching and data management.

##  Features
- **Add Words:** Quickly add words and their definitions.
- **Delete Words:** Remove entries from the dictionary with ease.
- **Advanced Search:** Find words based on a specific letter's position:
  - **Beginning:** Words that start with the letter.
  - **Middle:** Words that contain the letter, but not at the start or end.
  - **End:** Words that end with the letter.
- **Alphabetical Sorting:** Automatically keeps all entries in alphabetical order.

## Data Structures Used
This project prioritizes efficiency by using:
- **TreeMap<String, String>:** Used for the main dictionary storage. This ensures that words are always sorted and provides $O(\log n)$ search time for specific keys.
- **Set<String>:** Utilized via the `keySet()` method. This allows for a "lean" search process, iterating only through unique words without the overhead of their definitions.

## How It Works
The search logic is the core of this simulation. By extracting the `keySet()` of the `TreeMap`, we obtain a `Set` of all words. The application then filters this `Set` based on the user's criteria (Beginning, Middle, or End) and only retrieves the full definition once a match is confirmed.
