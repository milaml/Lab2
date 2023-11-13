package mk.finki.ukim.mk.wp1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    @PostMapping
    public String submitOrder(@RequestParam String selectedMovie,
                              @RequestParam int numOfTickets,
                              Model model){
        model.addAttribute("selectedMovie",selectedMovie);
        model.addAttribute("numOfTickets",numOfTickets);

        return "orderConfirmation";
    }
}