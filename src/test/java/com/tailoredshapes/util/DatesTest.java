package com.tailoredshapes.util;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.tailoredshapes.util.Dates.*;


/**
 * Created by tmarsh on 10/24/16.
 */
public class DatesTest {
    @Test
    public void dateReturnsANewDate() throws Exception {
        DateTime dateTime = new DateTime("1979-10-10");
        assertEquals(dateTime, date("1979-10-10"));
    }

    @Test
    public void isoDateStringReturnsAISOFormatedString() throws Exception {
        assertEquals("1979-10-10T00:00:00.000-04:00", isoString(date("1979-10-10")));
    }
}