package com.fun.streamfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexFilter
{
    public static void main (String[] args)
    {
        List<Customer> customers = Arrays.asList(
                new Customer("Karen", 29),
                new Customer("David", 40),
                new Customer("Jenny", 21),
                new Customer("Collin", 18),
                new Customer("Patricia", 65),
                new Customer("Alice", 33)
        );

        Customer customer = getCustomerByNameBeforeJava8(customers, "Patricia");

        System.out.println("Customer Name: " + customer.getCustomerName()
                + " -- Customer Age: " + customer.getAge());

        Customer customer1 = getCustomerByName(customers, "Jenny");

        if (customer1 != null)
        {
            System.out.println("Customer Name: " + customer1.getCustomerName()
                    + " -- Customer Age: " + customer1.getAge());
        }

        Customer customer2 = getCustomerByNameAndAgeBeforeJava8(customers, "Jenny");

        System.out.println("Customer Name: " + customer2.getCustomerName()
                + " -- Customer Age: " + customer2.getAge());

        Customer customer3 = getCustomerByNameAndAge(customers, "Jenny");

        System.out.println("Customer Name: " + customer3.getCustomerName()
                + " -- Customer Age: " + customer3.getAge());

        isolateCustomerNamesAndPrintThemBeforeJava8(customers);
        isolateCustomerNamesAndPrintThem(customers);
    }

    /**
     * Demonstrates retrieving a single customer by a single condition before Java 8
     *
     * @param customers
     * @param name
     * @return
     */
    private static Customer getCustomerByNameBeforeJava8(List<Customer> customers, String name)
    {
        System.out.println("******getCustomerByNameBeforeJava8*****");
        Customer result = null;

        for (Customer customer: customers)
        {
            if (name.equals(customer.getCustomerName()))
            {
                result = customer;
            }
        }

        return result;
    }

    /**
     * Demonstrates retrieving a single customer by a single condition leveraging Java 8
     *
     * Note: this uses filtering to go through each customer on the list
     *
     * @param customers
     * @param name
     * @return
     */
    private static Customer getCustomerByName(List<Customer> customers, String name)
    {
        System.out.println("******getCustomerByName*****");
        Customer customer = customers.stream().filter(x -> name.equals(x.getCustomerName()))
                .findAny()
                .orElse(null);

        return customer;
    }

    /**
     * Demonstrates retrieving a single customer by multiple conditions before Java 8
     *
     * @param customers
     * @param name
     * @return
     */
    private static Customer getCustomerByNameAndAgeBeforeJava8(List<Customer> customers, String name)
    {
        System.out.println("******getCustomerByNameAndAgeBeforeJava8*****");
        Customer result = null;

        for (Customer customer: customers)
        {
            if (name.equals(customer.getCustomerName()) && 21 == customer.getAge())
            {
                result = customer;
            }
        }
        return result;
    }

    /**
     * In this example, we are providing multiple conditions to the filter in order to find our customer
     * @param customers
     * @param name
     * @return
     */
    private static Customer getCustomerByNameAndAge(List<Customer> customers, String name)
    {
        System.out.println("******getCustomerByNameAndAge*****");
        Customer customer = customers.stream().filter(x -> name.equals(x.getCustomerName()) && 21 == x.getAge())
                .findAny().orElse(null);

        return customer;
    }

    /**
     * So this is a little overkill, but here is the problem:
     *  * you have a requirement to create a new object (in this example a List of Strings) that ONLY contains customer names
     *  * you then need to print each customers name.
     *
     * What is example illustrates is that you need to loop twice to achieve said result
     * @param customers
     */
    private static void isolateCustomerNamesAndPrintThemBeforeJava8(List<Customer> customers)
    {
        System.out.println("******isolateCustomerNamesAndPrintThemBeforeJava8*****");
        List<String> names = new ArrayList<>();

        for (int i=0; i < customers.size(); i++)
        {
            Customer customer = customers.get(i);

            names.add(customer.getCustomerName());
        }

        for (String name: names)
        {
            System.out.println(name);
        }
    }

    /**
     * For each customer name, the result is mapped before being converted to a list. 
     * @param customers
     */
    private static void isolateCustomerNamesAndPrintThem(List<Customer> customers)
    {
        System.out.println("******isolateCustomerNamesAndPrintThem*****");
        List<String> collection = customers.stream().map(Customer::getCustomerName).collect(Collectors.toList());

        collection.forEach(System.out::println);
    }
}
