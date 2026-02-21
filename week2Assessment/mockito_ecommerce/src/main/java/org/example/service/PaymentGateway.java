package org.example.service;

public interface PaymentGateway {
	boolean processPayment(double amount);
}
