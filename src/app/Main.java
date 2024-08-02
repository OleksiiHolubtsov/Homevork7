package app;

public class Main {


    public static void main(String[] args) {


        int[] numbers = {36, 15, 26, -42, 88, 9, 5, -19, 22, -36, 81, 0, -12, 13, 83, -2, 35, 21, 97, -7};
        int result = calculateSum(numbers);
        int evenCount = countEvenNumbers(numbers);
        int oddCount = countOddNumbers(numbers);
        int[] smallestElementAndIndex = findSmallestElement(numbers);
        int[] largestElementAndIndex = findLargestElement(numbers);
        Double averageAfterFirstNegative = calculateAverageAfterFirstNegative(numbers);

        System.out.println("Сума від'ємних чисел: " + result);
        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
        System.out.println("Найменший елемент: " + smallestElementAndIndex[0] +
                " (з індексом " + smallestElementAndIndex[1] + ")");
        System.out.println("Найбільший елемент: " + largestElementAndIndex[0] +
                " (з індексом " + largestElementAndIndex[1] + ")");
        if (averageAfterFirstNegative != null) {
            double roundedAverage = roundToTwoDecimalPlaces(averageAfterFirstNegative);
            System.out.println("Середнє арифметичне чисел після першого від'ємного числа: "
                    + roundedAverage);
        } else {
            System.out.println("Від'ємних чисел немає в масиві.");
        }

    }

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static int countEvenNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countOddNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    public static int[] findSmallestElement(int[] array) {
        int minElement = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                minIndex = i;
            }
        }
        return new int[]{minElement, minIndex};
    }
    public static int[] findLargestElement(int[] array) {
        int maxElement = array[0];
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                maxIndex = i;
            }
        }
        return new int[]{maxElement, maxIndex};
    }
    public static Double calculateAverageAfterFirstNegative(int[] array) {
        int sum = 0;
        int count = 0;
        boolean foundFirstNegative = false;

        for (int num : array) {
            if (foundFirstNegative) {
                sum += num;
                count++;
            } else if (num < 0) {
                foundFirstNegative = true;
            }
        }

        if (count > 0) {
            return (double) sum / count;
        } else {
            return null;
        }
    }
    public static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}





