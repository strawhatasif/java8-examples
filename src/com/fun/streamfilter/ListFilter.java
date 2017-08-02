package com.fun.streamfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListFilter
{
    public static void main(String[] args)
    {
        List<String> colors = Arrays.asList("black", "blue", "green", "pink", "yellow");

        getFilteredOutputBeforeJava8(colors, "yellow");

        getFilteredOutput(colors, "green");
    }

    /**
     * This is how one would filter a list before Java 8.
     *
     * Basically, we are only adding colors that don't equal the one we want to remove.
     *
     * @param colors
     * @param colorToRemove
     * @return
     */
    public static void getFilteredOutputBeforeJava8(List<String> colors, String colorToRemove)
    {
        List<String> resultList = new ArrayList<>();

        for (String color: colors)
        {
            if (!colorToRemove.equalsIgnoreCase(color))
            {
                resultList.add(color);
            }
        }

        //RESULTS OUTPUT
        for (String color: resultList)
        {
            System.out.println("Color? " + color);
        }
    }

    /**
     * Using Java8 - we return a filtered list
     *
     * Step 1: convert the list to a Stream
     * Step 2: on each color in the Stream, filter those that don't equal the color we want to remove
     * Step 3: use the collect function to convert the Stream back to a List
     *
     * @param colors
     * @param colorToRemove
     */
    public static void getFilteredOutput(List<String> colors, String colorToRemove)
    {
        List<String> result = colors.stream()
                .filter(color -> !colorToRemove.equals(color))
                .collect(Collectors.toList());

        //RESULTS OUTPUT
        result.forEach(System.out::println);
    }
}
