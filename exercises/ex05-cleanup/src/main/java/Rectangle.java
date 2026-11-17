/**
 * Represents a rectangle with a width and height.
 */
public class Rectangle {
  private double width;
  private double height;

  /**
   * Creates a rectangle with the given dimensions.
   *
   * @param w  the width of the rectangle
   * @param h the height of the rectangle
   */
  public Rectangle(double w, double h) {
    this.width = w;
    this.height = h;
  }

  /**
   * Calculates the area of the rectangle.
   *
   * @return the area of the rectangle
   */
  public double area() {
    return width * height;
  }

  /**
   * Scales the rectangle's dimensions by the given factor.
   *
   * @param factor the amount to scale by
   */
  public void scale(double factor) {
    width = width * factor;
    height = height * factor;
  }

  /**
   * Checks whether this rectangle has a larger area than another rectangle.
   *
   * @param other the rectangle to compare against
   * @return true if this rectangle has a larger area, false otherwise
   */
  public boolean isLargerThan(Rectangle other) {
    if (area() > other.area()) {
      return true;
    } else {
      return false;
    }
  }
}
