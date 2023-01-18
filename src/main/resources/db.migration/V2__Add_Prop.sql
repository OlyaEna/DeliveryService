insert into roles (id, name)
values (1, 'ROLE_ADMIN');
insert into roles (id, name)
values (2, 'ROLE_USER');

insert into configuration values ('n', 5);
insert into configuration values ('x', 10);
insert into configuration values ('m', 2);

insert into coffee_type values (1, 'Y', 'Cappuccino','Капучино', 2.0 );
insert into coffee_type values (2, 'N', 'Flat white','Флэт Уайт', 4.0 );
insert into coffee_type values (3, 'N', 'Espresso','Эспрессо', 1.0 );
insert into coffee_type values (4, 'N', 'Latte','Латте', 3.0 );
insert into coffee_type values (5, 'N', 'Americano','Американо', 1.0 );

# пароль - user
insert into users values (12, 'user@user.ru','$2a$12$WiAuLPPJc9Z/aSsMZ8Vo7.jn1RapLVMcoXuUVSdpHWvxbs4YC6kBC');
insert into users_roles values (12, 2);

# пароль - admin
insert into users values (13, 'admin@admin.com','$2a$12$JZ2g4gw3CsvHxil0Si1WyOCEL6oFBX.pnDENxc9KRiwBoCJ8AmVNG');
insert into users_roles values (13, 1);
