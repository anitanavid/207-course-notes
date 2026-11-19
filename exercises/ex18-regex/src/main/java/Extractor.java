
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise (Chapter 14: Regular Expressions).
 * Extracts course codes, course numbers, and masks emails.
 */
public class Extractor {

  private static final Pattern COURSE_CODE =
          Pattern.compile("[A-Z]{3}(\\d{3})[A-Z]\\d[A-Z]");

  private static final Pattern EMAIL =
          Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

  private static final String MASK = "***";

  /**
   * Finds all course codes in the given text.
   *
   * @param text text to search
   * @return list of course codes
   */
  public static List<String> findCourseCodes(String text) {
    List<String> results = new ArrayList<>();

    Matcher matcher = COURSE_CODE.matcher(text);

    while (matcher.find()) {
      results.add(matcher.group());
    }

    return results;
  }

  /**
   * Finds the three-digit numbers from course codes.
   *
   * @param text text to search
   * @return list of course numbers
   */
  public static List<String> findCourseNumbers(String text) {
    List<String> results = new ArrayList<>();

    Matcher matcher = COURSE_CODE.matcher(text);

    while (matcher.find()) {
      results.add(matcher.group(1));
    }

    return results;
  }

  /**
   * Replaces all email addresses with "***".
   *
   * @param text text to search
   * @return text with email addresses masked
   */
  public static String maskEmails(String text) {
    Matcher matcher = EMAIL.matcher(text);
    return matcher.replaceAll(MASK);
  }
}
