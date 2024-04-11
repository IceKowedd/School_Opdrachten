package frl.icekowedd.opdrachten.opdracht_4.validator;

public class mail {

  private static final String validmail = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

  public static boolean isValidEmail(String email) {
    return email.matches(validmail);
  }
}
