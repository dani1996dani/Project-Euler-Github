package solutions;

import solutions.problem12.MyLinkedList;

import java.util.LinkedList;

public class MyMath {


    public static int triangleNumber(int index) {
        int result = (index * 2 + index * (index - 1)) / 2;
        return result;
    }

    public static int amountOfFactors(MyLinkedList prime_factor_list) {
        return prime_factor_list.productOfPowers();
    }

    public static MyLinkedList amountofPrimeFactors(int number){
        MyLinkedList prime_factor_list = new MyLinkedList();
        while(number%2==0){
            if(prime_factor_list.indexOf(2)==-1)
                prime_factor_list.add(2);
            else{
                prime_factor_list.incrementPower(prime_factor_list.indexOf(2));
            }
            number/=2;
        }

        for (int i = 3; i < Math.sqrt(number); i+=2) {
            while(number%i == 0){
                if(prime_factor_list.indexOf(i)==-1)
                    prime_factor_list.add(i);
                else{
                    prime_factor_list.incrementPower(prime_factor_list.indexOf(i));
                }
                number/=i;
            }
        }

        if(number > 2) {
            if (prime_factor_list.indexOf(number) == -1)
                prime_factor_list.add(number);
            else {
                prime_factor_list.incrementPower(prime_factor_list.indexOf(number));
            }
        }
        return prime_factor_list;
//        return prime_factor_list.productOfPowers();
    }

}

