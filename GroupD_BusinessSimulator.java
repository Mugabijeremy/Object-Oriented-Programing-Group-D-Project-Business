
public class GroupD_BusinessSimulator {
    public static void main(String[] args) {
        // Parallel arrays for item names and prices
        String[] items = {
            "Paracetamol (pack)", 
            "Cough Syrup", 
            "Bandages", 
            "Vitamins"
        };
        double[] prices = {1500.0, 6000.0, 2500.0, 20000.0};

        // Quantities set directly for testing (5, 2, 3, 2)
        int[] quantities = {5, 2, 3, 2};

        // Display price list using loop method
        displayPriceList(items, prices);

        // Print itemized receipt and calculate grand total
        System.out.println("==== RECEIPT ====");
        double grandTotal = 0.0;

        for (int i = 0; i < items.length; i++) {
            // Calculate discounted subtotal using custom method
            double itemSubtotal = calculateSubtotal(i, prices[i], quantities[i]);
            
            // Get discount status note
            String discountNote = getDiscountNote(i, quantities[i]);

            // Accumulate grand total
            grandTotal += itemSubtotal;

            // Output receipt line item
            System.out.printf("%-20s x%d = UGX %.2f %s%n", // the "%-20s" formats the item name to be left-aligned in a field of 20 characters
                items[i], quantities[i], itemSubtotal, discountNote);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL               = UGX %.2f%n", grandTotal);
    }
    // Custom Method 1: Iterates through arrays using a loop to display the price list
    public static void displayPriceList(String[] names, double[] prices) {
        System.out.println("==== CITYCARE PHARMACY ====");
        for (int i = 0; i < names.length; i++) {   // names.length is used to determine the no. of items in the array and enables flexibility in case of future changes.
            System.out.printf("%d. %-20s UGX %.2f%n", (i + 1), names[i], prices[i]);
        }
        System.out.println();
    }
    // Custom Method 2: Computes item subtotal based on specific group rules
    public static double calculateSubtotal(int itemIndex, double price, int quantity) {
        double totalBeforeDiscount = price * quantity;

        // Rule 0: Paracetamol — 5% off if buying 6 or more
        if (itemIndex == 0) {
            if (quantity >= 6) {
                return totalBeforeDiscount * 0.95;
            }
        } 
        // Rule 1: Cough Syrup — Never discounted
        else if (itemIndex == 1) {
            return totalBeforeDiscount;
        } 
        // Rule 2: Bandages — UGX 1,000 off total if buying 4 or more
        else if (itemIndex == 2) {
            if (quantity >= 4) {
                return totalBeforeDiscount - 1000.0;
            }
        } 
        // Rule 3: Vitamins — 10% off if buying 2 or more
        else if (itemIndex == 3) {
            if (quantity >= 2) {
                return totalBeforeDiscount * 0.90;
            }
        }
        return totalBeforeDiscount;
    }
      // Custom Method 3:
    // Returns a message describing whether a discount was applied.
    public static String getDiscountNote(int itemIndex,int quantity) {
        // Implemented the use of ternary operators to reduce lines of code and improve readability
        if(itemIndex == 0){
            return(quantity>=6) ? "(5% discount presnt)" : "(no discount - fewer than 6)";
        }
        else if(itemIndex == 1){
            return "(no discount)";
        }
        else if(itemIndex == 2){
            return(quantity>=4)? "(UCX 1000 discount applied)":"(no discount-fewer than 4)";
        }
        else if(itemIndex == 3){
            return(quantity>=2)? "(10% discount applied)":"(no discount-fewer than 2)";
        }
        return "";
    }
}
