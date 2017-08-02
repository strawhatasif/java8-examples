package com.fun.streamfilter;

import java.util.Arrays;
import java.util.List;

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

        Customer customer1 = getCustomerByName(customers, "Samantha");

        System.out.println("Customer Name: " + customer1.getCustomerName()
                + " -- Customer Age: " + customer1.getAge());
    }

    private static Customer getCustomerByNameBeforeJava8(List<Customer> customers, String name)
    {
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

    private static Customer getCustomerByName(List<Customer> customers, String name)
    {
        Customer customer = customers.stream().filter(x -> name.equals(x.getCustomerName()))
                .findAny()
                .orElse(null);

        return customer;
    }
}
