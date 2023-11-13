package mk.finki.ukim.mk.wp1.service.impl;

import mk.finki.ukim.mk.wp1.model.TicketOrder;
import mk.finki.ukim.mk.wp1.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {
    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return new TicketOrder(movieTitle, clientName, address, (long) numberOfTickets);
    }
}
