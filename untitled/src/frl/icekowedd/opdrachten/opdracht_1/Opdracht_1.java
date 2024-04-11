package frl.icekowedd.opdrachten.opdracht_1;

import frl.icekowedd.opdrachten.opdracht_3.Opdracht_3;
import java.util.HashMap;
import java.util.logging.Logger;


public class Opdracht_1 {


  public static void main(String[] args) {

    // Main Function/Method > number array is created > even and un-even hashmap created.
    Logger logger = Logger.getLogger(Opdracht_3.class.getName());
    logger.info("Hello and welcome!");
    int[] myNumbers = {42, 67, 35, 89, 24, 76, 58, 93, 7, 30, 83, 46, 13, 25, 98, 53, 17, 79, 57, 8};
      HashMap<String, Integer> countUnEven = new HashMap<>();
      String even = "even"; countUnEven.put(even, 0);
      String unEven = "unEven"; countUnEven.put(unEven, 0);

    // Loops over myNumbers array > checks and prints if even or un-even number and increments even/un-even hashmap. > prints total in the end.
    for (int i = 0; i < myNumbers.length; i++) {
      String message = String.format("getal op Index %d", i);
      String evensMessage = String.format(": %d is een even getal, we hebben nu %d even getallen", myNumbers[i], countUnEven.get(even));
      String evenMessage = String.format(": %d is een even getal, we hebben nu %d even getal", myNumbers[i], countUnEven.get(even));
      String unEvensMessage = String.format(": %d is een oneven getal, we hebben nu %d oneven getallen", myNumbers[i], countUnEven.get(unEven));
      String unEvenMessage = String.format(": %d is een oneven getal, we hebben nu %d oneven getal", myNumbers[i], countUnEven.get(unEven));
      logger.info(message);
      if (myNumbers[i] % 2 == 0) {

        countUnEven.put(even, countUnEven.get(even) + 1);
        if (countUnEven.get(even) >= 2) {
        logger.info(evensMessage);
      } else {
        logger.info(evenMessage);
      }
    } else {
        countUnEven.put(unEven, countUnEven.get(unEven) + 1);
        if (countUnEven.get(unEven) >= 2) {
          logger.info(unEvensMessage);
        } else {
          logger.info(unEvenMessage);
        }
      }
    }
    logger.info("%n");
    String totalMessage = String.format("We hebben dus totaal %d even getallen en %d oneven getallen", countUnEven.get(even), countUnEven.get(unEven));
    logger.info(totalMessage);}
}