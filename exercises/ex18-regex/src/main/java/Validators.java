
/**
 * Exercise (Chapter 14: Regular Expressions) — writing patterns and matching.
 */
public class Validators {

  /**
   * Checks whether a string is a valid email address.
   *
   * @param input the string to test
   * @return true if the input matches the email pattern
   */
  public static boolean isEmail(String input) {
    return input.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
  }

  /**
   * Checks whether a string matches NNN-NNN-NNNN.
   *
   * @param input the string to test
   * @return true if the input matches the phone number pattern
   */
  public static boolean isPhoneNumber(String input) {
    return input.matches("\\d{3}-\\d{3}-\\d{4}");
  }

  /**
   * Checks whether a string is a valid Java variable name
   * according to the exercise's specified pattern.
   *
   * @param input the string to test
   * @return true if the input matches the identifier pattern
   */
  public static boolean isJavaVariableName(String input) {
    return input.matches("[A-Za-z_$][A-Za-z0-9_$]*");
  }
}
