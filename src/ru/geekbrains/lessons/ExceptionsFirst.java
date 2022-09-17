package ru.geekbrains.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsFirst {

    public static void main(String[] args) throws FileNotFoundException {
        //Первое задание
        fileNotFound();

        int[] array = {11, 17};
        arrayIndexOut(array);

        String[] str = {"1", "3", "five"};
        numberFormat(str);

        //Второе задание
        sum2d(new String[][]{{"1", "3"}, {"street"}});

        //Третье задание
        int[] diffArray = differenceNum(new int[] {11, 25}, new int[] {30});
        for (int arr: diffArray) {
            System.out.print(arr + " ");
        }

        //Четвертое задание
        int[] divArray = divideArray(new int[] {15, 121}, new int[] {3, 11});
        for (int arr: divArray) {
            System.out.print(arr + " ");
        }
    }


    // Первое задание
    private static void fileNotFound() throws FileNotFoundException {
        File file = new File("C://user/desc.txt");
        FileReader fileReader = new FileReader(file);
    }

    private static void arrayIndexOut(int[] array) {
        if (array[5] == 2) {
            System.out.println("hi");
        }
    }

    private static void numberFormat(String[] str) {
        int[] num = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
    }

    // Второе задание
    public static int sum2d(String[][] arr) { // Если будут передавать массив со значением null, то ошибка будет NullPointerException
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) { // Длина второго вложенного массива может быть меньше 5 ArrayIndexOutOfBoundsException
                int val = Integer.parseInt(arr[i][j]); // Так как массив типа String, то
                                                       // может быть такое, что вместо цифры в строке будет слово, тогда
                                                       // будет ошибка типа NumberFormatException
                sum += val;
            }
        }
        return sum;
    }

    // Третье задание
    private static int[] differenceNum(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Different length in arrays");

        }

        int[] newArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i] - array2[i];
        }

        return newArray;
    }

    // Четвертое задание
    private static int[] divideArray(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Different length in arrays");
        }

        for (int num: array2) {
            if (num == 0) {
                throw new RuntimeException("/ by zero");
            }
        }

        int[] newArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i] / array2[i];
        }

        return newArray;
    }
}
