package ru.ds.education.currency.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ds.education.currency.core.mapper.CursMapper;
import ru.ds.education.currency.core.model.CursDto;
import ru.ds.education.currency.core.model.CursEnum;
import ru.ds.education.currency.db.entity.Curs;
import ru.ds.education.currency.db.repository.CurrencyRepository;

import java.util.Date;
import java.util.List;


@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CursMapper cursMapper;

    //////////////////////////////////////POST(ADD)/////////////////////////////////////////////////////
    public CursDto addCurs(CursDto cursDto){
        Curs cursNew = cursMapper.map(cursDto, Curs.class);
        cursNew = currencyRepository.save(cursNew);
        cursDto = cursMapper.map(cursNew, CursDto.class);
        return cursDto;
    }

    //////////////////////////////////////GET/////////////////////////////////////////////////////

    public CursDto getCurs(Long id){
        Curs curs = currencyRepository.getOne(id);
        //другой вариант
//        CursDto cursDto = cursMapper.map(curs, CursDto.class);
//        return cursDto;
        //или
        return cursMapper.map(curs, CursDto.class);
    }

    //////////////////////////////////////PUT(UPDATE)/////////////////////////////////////////////////////
    //Старый вариант
//    public void updateCurs(Curs curs, Long id){
//        ru.ds.education.currency.db.entity.Curs cursDel = currencyRepository.getOne(id);
//
//        cursDel.setCurrency(curs.getCurrency());
//        cursDel.setCursNumber(curs.getCursNumber());
//        cursDel.setCurs_date(curs.getCurs_date());
//
//        currencyRepository.save(cursDel);
//    }

    //Новый вариант с маппером
        public void updateCurs(CursDto cursDto){
//        Curs cursDel = currencyRepository.getOne(id);
        Curs cursDel = cursMapper.map(cursDto, Curs.class);
        currencyRepository.save(cursDel);
    }

    //////////////////////////////////////DELETE/////////////////////////////////////////////////////
    //1 ВАРИАНТ
//    public void deleteById(Long id){
//        currencyRepository.deleteById(id);
//    }

    //2 ВАРИАНТ
    public void deleteByCurrencyDate(CursEnum currency, Date curs_date){
        Curs cursDel = currencyRepository.findBy(currency, curs_date);
        currencyRepository.deleteById(cursDel.getId());
    }


    /////////////////////////////////////////////LIST//////////////////////////////////////////
    //1.1 ВАРИАНТ
//    public List<Curs> getByCurrency(CursEnum currency){
//        List<ru.ds.education.currency.db.entity.Curs> cursList =
//                currencyRepository.findByCurrency(currency);
//        List<Curs> result = new ArrayList<>();
//        for(ru.ds.education.currency.db.entity.Curs curs : cursList){
//            result.add(new Curs(curs.getId(), curs.getCurrency(), curs.getCursNumber(), curs.getCurs_date()));
//        }
//        return result;
//    }

    //ИЛИ
    //1.2 ВАРИАНТ
//    public List<Curs> getByDate(Date curs_date){
//        List<ru.ds.education.currency.db.entity.Curs> dateList = currencyRepository.findByDate(curs_date);
//        List<Curs> resultDate = new ArrayList<>();
//        for(ru.ds.education.currency.db.entity.Curs curs : dateList){
//            resultDate.add(new Curs(curs.getId(), curs.getCurrency(), curs.getCursNumber(), curs.getCurs_date()));
//        }
//        return resultDate;
//    }

    //2 ВАРИАНТ
    public List<CursDto> getByCurrencyByDate(CursEnum currency, Date curs_date){
        List<Curs> cursDateList = currencyRepository.findByCurrencyByDate(currency, curs_date);
        //другой вариант
        List<CursDto> resultCurrencyDate = cursMapper.mapAsList(cursDateList, CursDto.class);

        //или мой вариант
//        List<CursDto> resultCurrencyDate = new ArrayList<>();
//        for(Curs curs : cursDateList){
//            resultCurrencyDate.add(cursMapper.map(curs, CursDto.class));
//        }
        return resultCurrencyDate;
    }

//    //3 ВАРИАНТ Получение одной валюты
//    public CursDto getCurs(CursEnum currency, Date curs_date){
//        Curs curs = currencyRepository.findByGet(currency, curs_date);
//        CursDto cursDto = cursMapper.map(curs, CursDto.class);
//        return cursDto;
//    }
}
