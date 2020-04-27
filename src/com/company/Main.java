package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        /*Creating an anonymous thread by creating an anonymous class which has implemented Runnable interface
        its run() method.*/

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };
        // Rewriting the thread with Lambda Expression
        Runnable runnable1=()->{
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        //Defining UpperConcat.uppCon() method with lambda expression.
        UpperConcat func=((one, two) -> one.toUpperCase()+two.toUpperCase());
        //System.out.println(sillyString(func,"Java","lambda"));


        //Because Predicate<T> is a functional interface it can be used with lambda expressions.
        //We want to create a method to print the numbers in the list that only bigger than a certain value
        List<Integer> numbers= Arrays.asList(85,69,20,14,5,63,98,12,5,36,47);
        Predicate<Integer> condition=number-> number>50;
        //printByValue(numbers,condition);

        //Comparator<T> interface is functional and has only compare() method to implement.
        //We can use it with lambda expression
        //Sorting numbers in decreasing order
      Collections.sort(numbers,(number1,number2)->{
          return number2-number1;
      });
       // numbers.forEach(n-> System.out.println(n));

        List<String> topNames= Arrays.asList("Luna", "Aurora",
                "Maeve", "olivia", "Isla", "Ava", "Charlotte",
                "Ophelia","Eloise", "eleanor" );
        //This stream makes the first letters of each name big and print them in sorted way.
        topNames.stream()
                .map(n->n.substring(0,1).toUpperCase()+n.subSequence(1,n.length()))
                .sorted()
                .forEach(name-> System.out.print(name+", "));

        //This stream counts the names that starts with 'A'
        long count=topNames.stream()
                .filter(s->s.charAt(0)=='A')
                .count();




    }
    //Creating a static method that takes a Functional interface as parameter.
    public static String sillyString(UpperConcat func,String one,String two){
        return func.uppCon(one,two);
    }

    //Creating method to print only the numbers that are bigger than a given value
    public static void printByValue(List<Integer> numbers, Predicate<Integer> valueCondition){
        for (Integer number : numbers){
            if (valueCondition.test(number)){
                System.out.println(number);
            }
        }

    }

}
/*Defining a functional interface.
//This functional interface has only one method to implement so that it can be used with
lambda expression.*/
interface UpperConcat{
    String uppCon(String one,String two);
}
