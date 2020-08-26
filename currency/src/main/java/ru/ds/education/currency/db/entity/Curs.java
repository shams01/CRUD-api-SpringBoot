package ru.ds.education.currency.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ds.education.currency.core.model.CursEnum;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="curs_data")
public class Curs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CursEnum currency;

    @Column(name = "curs")
    private Double cursNumber;

    @Column(name = "curs_date")
    @Temporal(TemporalType.DATE)
    private Date curs_date;
}
