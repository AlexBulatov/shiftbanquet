package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Expense;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.payloads.ExpenseRequestPostPayload;
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.ExpenseRepo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private EventRepo eventRepo;

    @PutMapping("api/events/{event_id}/expenses/{expense_id}")
    public Wrapper<Expense> editExpense(@PathVariable long event_id, @PathVariable long expense_id) {
        throw new NotImplementedException();
    }

    @DeleteMapping("api/events/{event_id}/expenses/{expense_id}")
    public Wrapper<Expense> deleteExpense(@PathVariable long event_id, @PathVariable long expense_id) {
        throw new NotImplementedException();
    }

    @PostMapping("api/events/{event_id}/expenses")
    public Wrapper<Expense> addExpense(@PathVariable long event_id, @RequestBody Wrapper<ExpenseRequestPostPayload> payload) {
        ExpenseRequestPostPayload data = payload.getData();
        Event event = eventRepo.findEventById(data.getEventId());
        Expense expense = new Expense();
        expense.setEvent(event);
        expense.setCost(data.getCost());
        expense.setName(data.getName());
        expenseRepo.save(expense);
        return new Wrapper<>("OK", null);
    }

    @GetMapping("api/events/{event_id}/expenses")
    public Wrapper<List<Expense>> getExpenses(@PathVariable long event_id) {
        Event event = eventRepo.findEventById(event_id);
        return new Wrapper<>("OK", expenseRepo.findExpensesByEvent(event));
    }

    @GetMapping("api/events/{event_id}/expanses/{expense_id}")
    public Wrapper<Expense> getExpenses(@PathVariable long event_id, @PathVariable long expense_id) {
        Event event = eventRepo.findEventById(event_id);
        return new Wrapper<>("OK", expenseRepo.findExpenseByIdAndEvent(expense_id, event));
    }
}
