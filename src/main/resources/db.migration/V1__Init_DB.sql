create table coffee_order
(
    id               bigint    not null auto_increment,
    delivery_address varchar(50),
    cost             double not null,
    customer_name    varchar(50),
    order_date       datetime(6),
    user_id          bigint,
    primary key (id)
) engine = InnoDB;

create table coffee_order_item
(
    id          bigint    not null auto_increment,
    quantity    integer   not null,
    total_price double not null,
    order_id    bigint,
    type_id     bigint,
    primary key (id)
) engine = InnoDB;

create table coffee_type
(
    id        bigint    not null auto_increment,
    disabled  char(1)   not null,
    type_name varchar(200),
    name_ru   varchar(255),
    price     double not null,
    primary key (id)
) engine = InnoDB;

create table configuration
(
    id    varchar(20) not null,
    value double,
    primary key (id)
) engine = InnoDB;

create table roles
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
) engine = InnoDB;

create table users
(
    id       bigint not null auto_increment,
    email    varchar(255),
    password varchar(255),
    primary key (id)
) engine = InnoDB;

create table users_roles
(
    user_id bigint not null,
    role_id bigint not null
) engine = InnoDB;

alter table users
drop index UK_6dotkott2kjsp8vw4d0m25fb7;

alter table users
    add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

alter table coffee_order
    add constraint FK6tc52hblpe9h0is632lulk2x4 foreign key (user_id) references users (id);

alter table coffee_order_item
    add constraint FKegobmd3kqy1lfjw73edyr3fxt foreign key (order_id) references coffee_order (id);

alter table coffee_order_item
    add constraint FK2ncy2882vpjewaih8dc9cp7o9 foreign key (type_id) references coffee_type (id);

alter table users_roles
    add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id);

alter table users_roles
    add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id);