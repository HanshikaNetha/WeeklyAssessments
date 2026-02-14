package test.com.cap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.com.cap.*;
public class LoanServiceTest {
	LoanService service = new LoanService();
    @Test
    void testValidEligibility() {
        assertTrue(service.isEligible(30, 40000));
    }
    @Test
    void testInvalidAgeBelow() {
        assertFalse(service.isEligible(20, 40000));
    }
    @Test
    void testInvalidAgeAbove() {
        assertFalse(service.isEligible(61, 40000));
    }
    @Test
    void testInvalidSalary() {
        assertFalse(service.isEligible(30, 20000));
    }
    @Test
    void testBoundaryValues() {
        assertTrue(service.isEligible(21, 25000));
        assertTrue(service.isEligible(60, 25000));
    }
    @Test
    void testValidEMI() {
        double emi = service.calculateEMI(120000, 2);
        assertEquals(5000, emi);
    }
    @Test
    void testInvalidLoanAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateEMI(0, 2);
        });
    }
    @Test
    void testInvalidTenure() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateEMI(100000, 0);
        });
    }
    @Test
    void testPremiumCategory() {
        assertEquals("Premium", service.getLoanCategory(800));
    }
    @Test
    void testStandardCategory() {
        assertEquals("Standard", service.getLoanCategory(700));
    }
    @Test
    void testHighRiskCategory() {
        assertEquals("High Risk", service.getLoanCategory(500));
    }
    @Test
    void testGroupedAssertions() {
        assertAll("Loan Service Multiple Tests",
                () -> assertTrue(service.isEligible(25, 30000)),
                () -> assertEquals("Premium", service.getLoanCategory(760)),
                () -> assertNotNull(service.calculateEMI(100000, 5))
        );
    }
}



