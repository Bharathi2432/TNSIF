NUMBER CATEGORY

import java.util.function.Function;


interface NumberCategory {
    boolean checkNumberCategory(int number1, int number2);
}

public class NumberCategoryUtility {
    public static NumberCategory checkAmicable() {
        return (number1, number2) -> {
            int sum1 = getDivisorsSum(number1);
            int sum2 = getDivisorsSum(number2);
            return sum1 == number2 && sum2 == number1;
        };
    }

    private static int getDivisorsSum(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class UserInterface {
    public static void main(String[] args) {
        int number1 = 220;
        int number2 = 284;

        NumberCategory amicableCheck = NumberCategoryUtility.checkAmicable();
        boolean areAmicable = amicableCheck.checkNumberCategory(number1, number2);

        if (areAmicable) {
            System.out.println("The numbers are amicable.");
        } else {
            System.out.println("The numbers are not amicable.");
        }
    }
}
