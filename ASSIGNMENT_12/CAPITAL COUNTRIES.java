CAPITAL COUNTRIES


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Country {
    private Map<String, String> countryMap;

    public Country() {
        this.countryMap = new HashMap<>();
    }

    public Map<String, String> getCountryMap() {
        return countryMap;
    }

    public void add(String country, String capital) {
        countryMap.put(country.toLowerCase(), capital);
    }

    public String search(String country) {
        return countryMap.getOrDefault(country.toLowerCase(), "Data not found");
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Country country = new Country();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add country and capital");
            System.out.println("2. Search capital of a country");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter country name: ");
                    String countryName = scanner.next();
                    System.out.print("Enter capital name: ");
                    String capitalName = scanner.next();
                    country.add(countryName, capitalName);
                    System.out.println("Country and capital added successfully.");
                    break;
                case 2:
                    System.out.print("Enter country name to search capital: ");
                    String searchCountry = scanner.next();
                    String capital = country.search(searchCountry);
                    if (capital.equals("Data not found")) {
                        System.out.println("Data not found");
                    } else {
                        System.out.println("Capital of " + searchCountry + " is: " + capital);
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
