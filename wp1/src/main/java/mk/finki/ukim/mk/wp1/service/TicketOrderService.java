package mk.finki.ukim.mk.wp1.service;

import mk.finki.ukim.mk.wp1.model.TicketOrder;
import org.springframework.stereotype.Service;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);
}
