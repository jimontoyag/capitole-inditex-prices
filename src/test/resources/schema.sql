create table prices (
    id int not null,
    brand_id int not null,
    product_id int not null,
    start_date timestamp not null,
    end_date timestamp not null,
    price decimal(5,2) not null,
    currency varchar(3) not null,
    priority int not null,
    PRIMARY KEY(id)
);