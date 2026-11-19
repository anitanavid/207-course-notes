
import java.util.Locale;

/**
 * Exercise (Chapter 13: Refactoring Techniques) — cleaning up a long method.
 */
public class OrderSummary {

    private static final double TAX_RATE = 0.13;
    private static final double DISCOUNT_THRESHOLD = 200.0;
    private static final double DISCOUNT_RATE = 0.10;
    private static final double PREMIUM_THRESHOLD = 100.0;

    /**
     * Builds a human-readable, multi-line summary of an order.
     *
     * @param customer the customer's name
     * @param itemNames the name of each item, in order
     * @param itemPrices the price of each item
     * @return the formatted order summary
     */
    public static String summarize(String customer, String[] itemNames,
                                   double[] itemPrices) {

        double subtotal = calculateSubtotal(itemPrices);
        int premiumCount = countPremiumItems(itemPrices);

        double discount = 0.0;
        if (subtotal > DISCOUNT_THRESHOLD) {
            discount = subtotal * DISCOUNT_RATE;
        }

        double taxable = subtotal - discount;
        double tax = taxable * TAX_RATE;
        double total = taxable + tax;

        return buildReport(customer, itemNames, itemPrices, premiumCount,
                subtotal, discount, tax, total);
    }

    private static double calculateSubtotal(double[] itemPrices) {
        double subtotal = 0.0;

        for (int i = 0; i < itemPrices.length; i++) {
            subtotal += itemPrices[i];
        }

        return subtotal;
    }

    private static int countPremiumItems(double[] itemPrices) {
        int premiumCount = 0;

        for (int i = 0; i < itemPrices.length; i++) {
            if (itemPrices[i] >= PREMIUM_THRESHOLD) {
                premiumCount++;
            }
        }

        return premiumCount;
    }

    private static String formatItem(String name, double price) {
        return String.format(Locale.US, "%s: $%.2f\n", name, price);
    }

    private static String buildReport(String customer, String[] itemNames,
                                      double[] itemPrices, int premiumCount,
                                      double subtotal, double discount,
                                      double tax, double total) {

        StringBuilder report = new StringBuilder();

        report.append("Order summary for ").append(customer).append("\n");
        report.append("----------------------\n");

        for (int i = 0; i < itemNames.length; i++) {
            report.append(formatItem(itemNames[i], itemPrices[i]));
        }

        report.append(String.format(Locale.US, "Items: %d\n", itemNames.length));
        report.append(String.format(Locale.US, "Premium items: %d\n", premiumCount));
        report.append(String.format(Locale.US, "Subtotal: $%.2f\n", subtotal));
        report.append(String.format(Locale.US, "Discount: $%.2f\n", discount));
        report.append(String.format(Locale.US, "Tax: $%.2f\n", tax));
        report.append(String.format(Locale.US, "Total: $%.2f", total));

        return report.toString();
    }
}
