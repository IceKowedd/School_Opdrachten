import java.util.HashMap;


public class Opdracht_1 {


  public static void main(String[] args) {
    // Main Function/Method > number array is created > even and un-even hashmap created.
    System.out.println("Hello and welcome!");
    int[] myNumbers = {42, 67, 35, 89, 24, 76, 58, 93, 7, 30, 83, 46, 13, 25, 98, 53, 17, 79, 57, 8};
    HashMap<String, Integer> countUnEven = new HashMap<>();
    countUnEven.put("even", 0);
    countUnEven.put("uneven", 0);

    // Loops over myNumbers array > checks and prints if even or un-even number and increments even/un-even hashmap. > prints total in the end.
    for (int i = 0; i < myNumbers.length; i++) {
      System.out.print("getal op Index " + i);
      if (myNumbers[i] % 2 == 0) {
        countUnEven.put("even", countUnEven.get("even") + 1);
        if (countUnEven.get("even") >= 2) {
        System.out.println(": " + myNumbers[i] + " is een even getal, we hebben nu " + countUnEven.get("even") + " even getallen");
      } else {
        System.out.println(": " + myNumbers[i] + " is een even getal, we hebben nu " + countUnEven.get("even") + " even getal");
      }
    } else {
        countUnEven.put("uneven", countUnEven.get("uneven") + 1);
        if (countUnEven.get("uneven") >= 2) {
          System.out.println(": " + myNumbers[i] + " is een oneven getal, we hebben nu " + countUnEven.get("uneven") + " oneven getallen");
        } else {
          System.out.println(": " + myNumbers[i] + " is een oneven getal, we hebben nu " + countUnEven.get("uneven") + " oneven getal");
        }
      }
    }
    System.out.println();
    System.out.println("we hebben dus totaal " + countUnEven.get("even") + " even getallen en " + countUnEven.get("uneven") + " oneven getallen");}
}