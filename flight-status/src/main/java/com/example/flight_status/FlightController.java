package com.example.flight_status;

import com.example.flight_status.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public String showFlightStatus(Model model) {
        model.addAttribute("flights", flightRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddFlightPage() {
        return "add-flight";
    }

    @PostMapping("/add")
    public String addFlight(@RequestParam("number") String number,
                            @RequestParam("status") String status,
                            @RequestParam("gate") String gate) {
        Flight flight = new Flight();
        flight.setNumber(number);
        flight.setStatus(status);
        flight.setGate(gate);
        flightRepository.save(flight);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteFlight(@RequestParam("id") Long id) {
        flightRepository.deleteById(id);
        return "redirect:/";
    }
}
