package ru.ds.education.currency.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.ds.education.currency.core.mapper.CursMapper;
import ru.ds.education.currency.core.model.CursDto;
import ru.ds.education.currency.core.model.CursEnum;
import ru.ds.education.currency.core.service.CurrencyService;
import ru.ds.education.currency.db.entity.Curs;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/curs")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    //////////////////////////////////////POST(ADD)/////////////////////////////////////////////////////
    @ApiOperation(
            value = "Добавление новой валюты"
    )
    @PostMapping
    public CursDto addCurs(@RequestBody CursDto cursDto){
        return currencyService.addCurs(cursDto);
    }

    //////////////////////////////////////GET/////////////////////////////////////////////////////

        @ApiOperation(
            value = "Получение валюты по id"
    )
    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public CursDto getCurs(@PathVariable("id") Long id){
        return currencyService.getCurs(id);
    }

    //////////////////////////////////////PUT(UPDATE)/////////////////////////////////////////////////////
    //1 ВАРИАНТ
//    @PutMapping(value = "/{id}") // в postman не будет показывать изменения.
//    public void updateCurs(@RequestBody Curs curs, @PathVariable("id") Long id){
//        currencyService.updateCurs(curs, id);
//    }

    //2 ВАРИАНТ
    @ApiOperation(
            value = "Изменение валюты"
    )
//    @RequestMapping(value = {"{id}"}, method = RequestMethod.PUT) // в postman показывает изменения.
    @PutMapping // нужно в потсмане менять Body, в строке url оставить "/api/curs"
    public void updateCurs(@RequestBody CursDto cursDto){
         currencyService.updateCurs(cursDto);
    }
    //3 ВАРИАНТ
//    @RequestMapping(value = {"{id}"}, method = RequestMethod.PUT) // в postman показывает изменения.
//    public void updateCurs(@RequestBody Curs curs, @PathVariable("id") Long id){
//        currencyService.updateCurs(curs, id);
//    }

//////////////////////////////////////DELETE/////////////////////////////////////////////////////
    //1 ВАРИАНТ
//    @ApiOperation(
//            value = "Удаление валюты по id"
//    )
//    //    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
//    @DeleteMapping(value = "/{id}")
//    public void deleteCurs(@PathVariable("id")  Long id){
//        currencyService.deleteById(id);
//    }

    //2 ВАРИАНТ
        @ApiOperation(
            value = "Удаление по валюте и дате"
        )
    //    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
        @DeleteMapping
        public void deleteCurs(@RequestParam("currency") CursEnum currency,
                               @RequestParam("curs_date") @DateTimeFormat(pattern="yyyy-MM-dd")
                                       Date curs_date){
         currencyService.deleteByCurrencyDate(currency, curs_date);
}

/////////////////////////////////////////////LIST//////////////////////////////////////////
    //1.1 ВАРИАНТ
//    @GetMapping //получение по валюте
//    public List<Curs> getByCurrency(@RequestParam CursEnum currency){
//        return currencyService.getByCurrency(currency);
//    }
    //ИЛИ
    //1.2 ВАРИАНТ
//    @GetMapping //получение по дате
//    public List<Curs> getByDate(@RequestParam("curs_date") @DateTimeFormat(pattern="yyyy-MM-dd") Date curs_date){
//        return currencyService.getByDate(curs_date);
//    }

    //2 ВАРИАНТ
    @ApiOperation(
            value = "Получение списка всех валют по валюте и дате"
    )
    @GetMapping //получение по валюте и по дате
    public List<CursDto> getByCurrencyByDate(@RequestParam CursEnum currency,
                                             @RequestParam("curs_date") @DateTimeFormat(pattern="yyyy-MM-dd")
                                                     Date curs_date){
        return currencyService.getByCurrencyByDate(currency, curs_date);
    }

//    //3 ВАРИАНТ Получение одной валюты
//    @ApiOperation(
//            value = "Получение по валюте и дате"
//    )
//    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
//    public CursDto getCurs(@RequestParam("currency") CursEnum currency,
//                           @RequestParam("curs_date") @DateTimeFormat(pattern="yyyy-MM-dd")
//                                   Date curs_date){
//        return currencyService.getCurs(currency, curs_date);
//    }
}
