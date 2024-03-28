import java.util.HashMap;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Opdracht_1 {

  public static void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("Hello and welcome!");
    int[] mijnNummers = {42, 67, 35, 89, 24, 76, 58, 93, 7, 30, 83, 46, 13, 25, 98, 53, 17, 79, 57, 8};

    HashMap<String, Integer> tellerEvenOneven = new HashMap<>();
    tellerEvenOneven.put("even", 0);
    tellerEvenOneven.put("oneven", 0);

    for (int i = 0; i < mijnNummers.length; i++) {
      //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
      // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
      System.out.print("getal op Index " + i);
      if (mijnNummers[i] % 2 == 0) {
        tellerEvenOneven.put("even", tellerEvenOneven.get("even") + 1);
        if (tellerEvenOneven.get("even") >= 2) {
        System.out.println(": " + mijnNummers[i] + " is een even getal, we hebben nu " + tellerEvenOneven.get("even") + " even getallen");
      } else {
        System.out.println(": " + mijnNummers[i] + " is een even getal, we hebben nu " + tellerEvenOneven.get("even") + " even getal");
      }
    } else {
        tellerEvenOneven.put("oneven", tellerEvenOneven.get("oneven") + 1);
        if (tellerEvenOneven.get("oneven") >= 2) {
          System.out.println(": " + mijnNummers[i] + " is een oneven getal, we hebben nu " + tellerEvenOneven.get("oneven") + " oneven getallen");
        } else {
          System.out.println(": " + mijnNummers[i] + " is een oneven getal, we hebben nu " + tellerEvenOneven.get("oneven") + " oneven getal");
        }
      }
    }
    System.out.println();
    System.out.println("we hebben dus totaal " + tellerEvenOneven.get("even") + " even getallen en " + tellerEvenOneven.get("oneven") + " on even getallen");}
}