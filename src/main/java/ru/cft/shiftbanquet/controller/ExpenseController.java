package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Expense;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.payloads.ExpenseRequestPostPayload;
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.ExpenseRepo;
import ru.cft.shiftbanquet.service.CheckAccessHelper;

import java.util.List;

@Api(description = "Запросы для работы с расходами")
@RestController
public class ExpenseController {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private CheckAccessHelper accessHelper;

    @ApiOperation(value = "Редактировать расходы")
    @PutMapping("api/events/{event_id}/expenses/{expense_id}")
    public Wrapper<Expense> editExpense(@PathVariable long event_id, @PathVariable long expense_id, @RequestBody Wrapper<ExpenseRequestPostPayload> payload) {
        Event event = eventRepo.findEventById(event_id);

        if (accessHelper.checkAccess(event)){
            return new Wrapper<>("NO ACCESS", null);
        }

        Expense expense = expenseRepo.findExpenseByIdAndEvent(expense_id, event);
        expense.setExpense(payload.getData());
        expenseRepo.save(expense);
        return new Wrapper<>("OK", null);
    }

    @ApiOperation(value = "Удалить расходы")
    @DeleteMapping("api/events/{event_id}/expenses/{expense_id}")
    public Wrapper<Expense> deleteExpense(@PathVariable long event_id, @PathVariable long expense_id) {

        Event event = eventRepo.findEventById(event_id);
        Expense expense = expenseRepo.findExpenseByIdAndEvent(expense_id, event);

        if (accessHelper.checkAccess(event)){
            return new Wrapper<>("NO ACCESS", null);
        }

        if(expense != null) {
            expenseRepo.delete(expense);
            return new Wrapper<> ("OK", null);
        }
        else {
            return new Wrapper<>("FAIL", null);
        }
    }

    @ApiOperation(value = "Добавить расходы")
    @PostMapping("api/events/{event_id}/expenses")
    public Wrapper<Expense> addExpense(@PathVariable long event_id, @RequestBody Wrapper<ExpenseRequestPostPayload> payload) {
        ExpenseRequestPostPayload data = payload.getData();
        Event event = eventRepo.findEventById(event_id);

        if (accessHelper.checkAccess(event)){
            return new Wrapper<>("NO ACCESS", null);
        }

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

    @ApiOperation(value = "Получить расходы")
    @GetMapping("api/events/{event_id}/expanses/{expense_id}")
    public Wrapper<Expense> getExpenses(@PathVariable long event_id, @PathVariable long expense_id) {
        Event event = eventRepo.findEventById(event_id);
        return new Wrapper<>("OK", expenseRepo.findExpenseByIdAndEvent(expense_id, event));
    }

}
