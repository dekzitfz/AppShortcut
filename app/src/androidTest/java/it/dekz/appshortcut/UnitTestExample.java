package it.dekz.appshortcut;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class UnitTestExample extends TestCase {
    @Test
    public void test2() throws Exception{
        MainActivity mainActivity = new MainActivity();
        assertEquals(1,mainActivity.cobatest());
    }
}
