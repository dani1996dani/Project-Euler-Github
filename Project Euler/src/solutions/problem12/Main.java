package solutions.problem12;

import solutions.MyMath;

public class Main {


    public static void main(String[] args) {
        //12102
        int index = 1;
//        System.out.println(MyMath.triangleNumber(index));
//        System.out.println(MyMath.amountofPrimeFactors(MyMath.triangleNumber(index)));
        MyLinkedList prime_list = MyMath.amountofPrimeFactors(MyMath.triangleNumber(index));
        while(MyMath.amountOfFactors(prime_list) < 500){
            index++;
            prime_list = MyMath.amountofPrimeFactors(MyMath.triangleNumber(index));
            System.out.println(index);
        }
        System.out.println("Result: "+MyMath.triangleNumber(index));
//        int x = MyMath.triangleNumber(7);
//        System.out.println(x);
    }
}
