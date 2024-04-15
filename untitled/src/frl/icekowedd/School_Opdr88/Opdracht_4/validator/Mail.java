package frl.icekowedd.School_Opdr88.Opdracht_4.validator;

// mail validator
public class Mail {

  private static final String validmail = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

  private Mail () {

  }

  public static boolean isValidEmail(String email) {
    return !email.matches(validmail);
  }
}