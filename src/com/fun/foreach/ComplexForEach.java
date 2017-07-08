package com.fun.foreach;

import java.util.Arrays;
import java.util.List;

public class ComplexForEach
{
    static private List<StickyNotes> stickyNotesList = Arrays.asList(
            new StickyNotes("you rock!"),
            new StickyNotes("Catherine is amazing!"),
            new StickyNotes("Jennifer called this morning"),
            new StickyNotes("Laura said she likes you!!!"),
            new StickyNotes("REMINDER! You have a date with Laura at 3 p.m. Saturday!"));

    public static void main (String[] args)
    {
        stickyNotesPrinterBeforeJava8();
        stickyNotesPrinter();
        stickyNotesPrinterFilterBeforeJava8();
        stickyNotesPrinterFilter();
    }

    /**
     * This is how one would loop through a List before Java 8 and invoke a function on
     * a particular class
     *
     */
    private static void stickyNotesPrinterBeforeJava8()
    {
        //In this example we are calling printMessage on each sticky note
        for (StickyNotes stickyNote: stickyNotesList)
        {
            stickyNote.printMessage();
        }
    }

    /**
     * This is how one can loop through a List using Java 8 and invoke a function on
     * a particular class
     *
     */
    private static void stickyNotesPrinter()
    {
        //for each sticky note - call the printMessage on the StickyNotes class
        stickyNotesList.forEach(StickyNotes::printMessage);
    }

    /**
     * This is how one would loop through a List before Java 8 and invoke a function on
     * a particular class
     *
     * Caveat: we are also going to filter any messages that contain "Laura"
     *
     */
    private static void stickyNotesPrinterFilterBeforeJava8()
    {
        //In this example we are calling printMessage on each sticky note
        //that DOES NOT contain "Laura"
        for (StickyNotes stickyNote: stickyNotesList)
        {
            if (!stickyNote.message.contains("Laura"))
            {
                stickyNote.printMessage();
            }
        }
    }

    /**
     * This is how one can loop through a List using Java 8 and invoke a function on
     * a particular class
     *
     * Caveat: we are also going to filter any messages that contain "Laura"
     */
    private static void stickyNotesPrinterFilter()
    {
        //for each sticky note that DOES NOT contain Laura
        //call the printMessage on the StickyNotes class

        //NOTE - we are using a Stream to first filter out any sticky notes that contain "Laura"
        //BEFORE we call printMessage
        stickyNotesList.stream().filter(stickyNote -> !stickyNote.message.contains("Laura")).forEach(StickyNotes::printMessage);
    }
}
