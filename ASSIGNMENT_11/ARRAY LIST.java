ARRAY LIST
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Products {
    private List<String> productList;

    public Products() {
        this.productList = new ArrayList<>();
    }

    public List<String> getProductList() {
        return productList;
    }

    public void addProductToList(String product) {
        productList.add(product);
    }

    public void sortProductList() {
        Collections.sort(productList);
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Products products = new Products();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add product");
            System.out.println("2. Display products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    scanner.nextLine(); // Consume newline
                    String product = scanner.nextLine();
                    products.addProductToList(product);
                    System.out.println("Product added successfully.");
                    break;
                case 2:
                    List<String> productList = products.getProductList();
                    if (productList.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.println("Products in alphabetical order:");
                        for (String item : productList) {
                            System.out.println(item);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}
