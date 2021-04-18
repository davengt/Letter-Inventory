//Daven Giftian Tejalaksana
//Thursday, 01 April 2021
//CSE 143
//Instructor: Stuart Reges
//TA: Andrew Cheng
//Assignment #1
//This program will keep track of an inventory of letters of the alphabet of the given String.

public class LetterInventory {
   private int[] elementData; //Array storing the inventory of letters
   private int size; //Total amount of letters in the inventory.
   
   public static final int DEFAULT_CAPACITY = 26; //total amount of letters in the alphabet.
   
   //Constructs an inventory (a count) of the alphabetic letters in the given string (data).
   //The inventory ignores the case of letters and any non-alphabetic characters.
   public LetterInventory(String data) {
      elementData = new int[DEFAULT_CAPACITY];
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         if (Character.isLetter(data.charAt(i))) {
            elementData[data.charAt(i) - 'a']++;
            size++;
         }
      }
   
   }
   
   //Returns the total number of characters (sum of counts) in this inventory.
   public int size() {
      return size;
   }
   
   //Pre: letter should be alphabetic letter (throws IllegalArgumentException if not)
   //Returns a count of how many of letter are in the inventory.
   public int get(char letter) {
      if (!(Character.isLetter(letter))) {
         throw new IllegalArgumentException(letter + " is a nonalphabetic letter.");
      }
      return elementData[Character.toLowerCase(letter) - 'a'];
   }
   
   //Returns true if this inventory is empty(all counts are 0).
   //Otherwise, returns false.
   public boolean isEmpty() {
      return size == 0;
   }
   
   //Returns a String representation of the inventory with lowercase letters in sorted order.
   //The letters will be surrounded by square brackets.
   public String toString() {
      String result = "[";
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         for (int j = 0; j < elementData[i]; j++) {
            result += (char) ('a' + i);
         }
      }
      return result + "]";     
   }
   
   //Pre: letter should be an alphabetic character AND value should be positive. 
      //(throws IllegalArgumentException if not).
   //Sets the count for the letter to the given value.
   public void set(char letter, int value) {
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException(letter + " is not an alphabetic character or " + 
                                            value + " is lesser than 0.");
      }
      size += value - elementData[Character.toLowerCase(letter) - 'a'];
      elementData[Character.toLowerCase(letter) - 'a'] = value;
   }

   //Constructs and returns a new LetterInventory object.
   //The new object represents sum of this letter inventory and "other" letter inventory.
   public LetterInventory add(LetterInventory other) {
      LetterInventory sum = new LetterInventory("");
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         sum.elementData[i] = this.elementData[i] + other.elementData[i];
      }
      sum.size = this.size + other.size;
      return sum;
   }
   
   //Constructs and returns a new LetterInventory object.
   //The new object represents the result of subtracting "other" inventory from this inventory.
   //If any resulting count would be negative, the method returns null.
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory difference = new LetterInventory("");
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         difference.elementData[i] = this.elementData[i] - other.elementData[i];
         if (difference.elementData[i] < 0) {
            return null;
         } 
      }
      difference.size = this.size - other.size;
      return difference;
   }
}