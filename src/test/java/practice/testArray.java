package practice;

public class testArray {

    public static void main(String[] args) {

        double[] list = {1.9, 2.9, 3.4, 3.5};

        for (int i = 0; i < list.length; i++) {

            //printing all the arrays*********************************************************
            System.out.println(list[i] + " ");

        }
        //summing all element**************************************************************
        double total = 0;

        for (int i = 0; i < list.length; i++) {
            total += list[i];
        }
        System.out.println(total);

        //finding the largest element******************************************************
        double max = list[0];

        for (int i = 1; i < list.length; i++) {

            if (list[i] > max) max = list[i];
        }
        System.out.println(max);

        //finding the min ******************************************************************

        double min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) min = list[i];
        }
        System.out.println(min);


        //printing all the elements*********************************************************

        for (double element : list) {

            System.out.println(element);
        }

    }
}