package ru.ds.education.currency.core.mapper;

import lombok.extern.apachecommons.CommonsLog;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.ds.education.currency.core.model.CursDto;
import ru.ds.education.currency.core.model.CursEnum;
import ru.ds.education.currency.db.entity.Curs;

import java.util.Date;

@Component
public class CursMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Curs.class, CursDto.class)
                .byDefault()
                .register();
    }
}
