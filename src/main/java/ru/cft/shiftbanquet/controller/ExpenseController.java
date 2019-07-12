package ru.cft.shiftbanquet.controller;

import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class ExpenseController {

    @PutMapping("/events/{event_id}/expanses/{expanse_id}")
    public String editExpanse() {
        throw new NotImplementedException();
    }

    @DeleteMapping("/events/{event_id}/expanses/{expanse_id}")
    public String deleteExpanse() {
        throw new NotImplementedException();
    }

    @PostMapping("/events/{event_id}/expanses")
    public String addExpanse() {
        throw new NotImplementedException();
    }

    @GetMapping("/events/{event_id}/expanses")
    public String getExpanses(@PathVariable(value = "event_id") long id) {
        throw new NotImplementedException();
    }
}
