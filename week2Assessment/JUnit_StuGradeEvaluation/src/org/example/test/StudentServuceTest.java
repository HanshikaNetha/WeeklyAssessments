package org.example.test;
import org.junit.jupiter.api.Test;
import org.example.service.*;
import static org.junit.jupiter.api.Assertions.*;
public class StudentServuceTest {
	StudentService service = new StudentService();
    @Test
    public void testCalculateGrade_Distinction() {
        assertEquals("Distinction", service.calculateGrade(80));
    }
    @Test
    public void testCalculateGrade_FirstClass() {
        assertEquals("First Class", service.calculateGrade(65));
    }
    @Test
    public void testCalculateGrade_SecondClass() {
        assertEquals("Second Class", service.calculateGrade(55));
    }
    @Test
    public void testCalculateGrade_Fail() {
        assertEquals("Fail", service.calculateGrade(40));
    }
    
    @Test
    public void testIsPassed_True() {
        assertTrue(service.isPassed(75));
    }

    @Test
    public void testIsPassed_False() {
        assertFalse(service.isPassed(44));
    }

    @Test
    public void testCalculateGrade_InvalidNegativeMarks() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateGrade(-10);
        });
    }
    @Test
    public void testCalculateGrade_InvalidAboveHundredMarks() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateGrade(120);
        });
    }

    @Test
    public void testCalculateGrade_NotNull() {
        String result = service.calculateGrade(70);
        assertNotNull(result);
    }
}
