package com.fun.foreach;


import java.util.Arrays;
import java.util.List;

public class SimpleForEach
{
    static private List<String> names = Arrays.asList("Laura", "Katherine", "Catherine", "Jessica");

    public static void main(String[] args)
    {
        printNamesBeforeJava8();
        printNames();
    }

    /**
     * This is how one may loop before Java 8
     * Note: this example uses an enhanced for loop and does not maintain a counter
     */
    private static void printNamesBeforeJava8()
    {

        for(String name: names)
        {
            System.out.println("The name is: " + name);
        }
    }

    /**
     * This is how one may loop using Java 8 using the forEach method on a Collection
     *
     */
    private static void printNames()
    {
        //For each item in the names list, assign each instance to the name variable
        //Then, print it out
        names.forEach(name -> System.out.println("The name is: " + name));
    }
}
