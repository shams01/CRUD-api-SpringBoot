package ru.ds.education.currency.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ds.education.currency.core.model.CursDto;
import ru.ds.education.currency.core.model.CursEnum;
import ru.ds.education.currency.db.entity.Curs;

import java.util.Date;
import java.util.List;


public interface CurrencyRepository extends JpaRepository<Curs, Long> {

    //////////////////////////////////////DELETE/////////////////////////////////////////////////////
    //1 ВАРИАНТ
    @Query(value = "Select c from Curs c where c.currency = :currency and c.curs_date = :curs_date")
    Curs findBy(@Param("currency")CursEnum currency, @Param("curs_date")Date curs_date);
    //1-2 ВАРИАНТ
    void deleteById(@Param("id") Long id);

    /////////////////////////////////////////////LIST//////////////////////////////////////////
    //1 ВАРИАНТ
    //    @Query(value = "Select c from Curs c where c.currency = :currency")
    //    List<Curs> findByCurrency(@Param("currency")CursEnum currency);

    //2 ВАРИАНТ
    //    @Query(value = "Select c from Curs c where c.curs_date = :curs_date")
    //    List<Curs> findByDate(@Param("curs_date")Date curs_date);

    //3 ВАРИАНТ (получения одной или списка валют
    @Query(value = "Select c from Curs c where c.currency = :currency and c.curs_date = :curs_date")
    List<Curs> findByCurrencyByDate(@Param("currency")CursEnum currency, @Param("curs_date")Date curs_date);

//    // Получение одной валюты
//    @Query(value = "Select c from Curs c where c.currency = :currency and c.curs_date = :curs_date")
//    Curs findByGet(@Param("currency")CursEnum currency, @Param("curs_date")Date curs_date);

}
