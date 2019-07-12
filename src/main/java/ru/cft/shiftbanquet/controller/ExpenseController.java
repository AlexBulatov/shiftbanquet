package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Api(description = "Запросы для работы с расходами")
@RestController
public class ExpenseController {

    @ApiOperation(value = "Редактировать расходы")
    @PutMapping("api/events/{event_id}/expanses/{expanse_id}")
    public String editExpanse() {
        throw new NotImplementedException();
    }

    @ApiOperation(value = "Удалить расходы")
    @DeleteMapping("api/events/{event_id}/expanses/{expanse_id}")
    public String deleteExpanse() {
        throw new NotImplementedException();
    }

    @ApiOperation(value = "Добавить расходы")
    @PostMapping("api/events/{event_id}/expanses")
    public String addExpanse() {
        throw new NotImplementedException();
    }

    @ApiOperation(value = "Получит расходы")
    @GetMapping("api/events/{event_id}/expanses")
    public String getExpanses(@PathVariable(value = "event_id") long id) {
        throw new NotImplementedException();
    }
}
