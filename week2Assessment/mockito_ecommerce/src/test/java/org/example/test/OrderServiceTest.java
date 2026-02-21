package org.example.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.service.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	@Mock
    private PaymentGateway paymentGateway;
    @InjectMocks
    private OrderService orderService;
    @Test
    void testSuccessfulPayment() {
        when(paymentGateway.processPayment(2000)).thenReturn(true);
        String result = orderService.placeOrder(2000);
        assertEquals("Order Confirmed", result);
        verify(paymentGateway, times(1)).processPayment(2000);
    }
    @Test
    void testPaymentFailure() {
        when(paymentGateway.processPayment(1500)).thenReturn(false);
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> orderService.placeOrder(1500)
        );
        assertEquals("Payment Failed", exception.getMessage());
        verify(paymentGateway, times(1)).processPayment(1500);
    }
    @Test
    void testInvalidOrderAmount() {
    	IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> orderService.placeOrder(0)
        );
        assertEquals("Invalid Order Amount", exception.getMessage());
        verify(paymentGateway, never()).processPayment(anyDouble());

    }
    
}
