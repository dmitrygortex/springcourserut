package org.example.services.impl;

import org.example.entities.Booking;
import org.example.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    // попробовать добавить скидки для пользователей
    // которые уже совершали сколько то бронирований за этот месяц

    // Добавить подключение к бд через PaymentRepository
    @Override
    public boolean processPayment(Booking booking, String paymentDetails) {
        boolean paymentInitiated = initiatePayment(booking, paymentDetails);
        if (!paymentInitiated) {
            return false;
        }
        String paymentConfirmationDetails = "";
        return confirmPayment(booking, paymentConfirmationDetails);
    }

    @Override
    public boolean initiatePayment(Booking booking, String paymentDetails) {
        return true;
    }

    @Override
    public boolean confirmPayment(Booking booking, String paymentConfirmationDetails) {
        return true;
    }
}
