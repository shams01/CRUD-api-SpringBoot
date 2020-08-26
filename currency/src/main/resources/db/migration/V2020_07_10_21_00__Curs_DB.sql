create table public.curs_data(
    id bigserial primary key not null,
    currency varchar(3),
    curs numeric(5,2),
    curs_date date
);

