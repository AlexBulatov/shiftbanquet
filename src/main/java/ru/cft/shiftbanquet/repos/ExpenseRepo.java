package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Expense;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findExpensesByEvent(Event event);

    Expense findExpenseByIdAndEvent(Long id, Event event);
}
