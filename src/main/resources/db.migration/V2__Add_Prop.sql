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

# пароль - user
insert into users values (14, 'user@gmail.com','$2a$12$HCVz.Usb.uaaxy.trCedEusSn4zgmT28ueW8EKVgnly798Qu6IqiG');
insert into users_roles values (14, 2);

insert into coffee_order values (4, 'Улица дорожная, 18', 25, 'Оля','2023-01-18 20:52:28.809218', 12);
insert into coffee_order_item values (11, 5, 20, 4, 2);
insert into coffee_order_item values (12, 1, 1, 4, 5 );
insert into coffee_order_item values (13, 6, 6, 4, 3 );
insert into coffee_order_item values (14, 1, 3, 4, 4 );

insert into coffee_order values (5, 'Проспект Пушкина, 7, квартира 90', 11, 'Инна','2023-01-18 20:52:28.809218', 14);
insert into coffee_order_item values (15, 5, 5, 5, 3 );
insert into coffee_order_item values (16, 1, 3, 5, 4 );
insert into coffee_order_item values (17, 1, 4, 5, 2 );

insert into coffee_order values (6, 'Проспект Пушкина, 34', 11, 'User', '2023-01-19 16:59:21.940376', 12);
insert into coffee_order_item values (18, 1, 4, 6, 2 );
insert into coffee_order_item values (19, 1, 1, 6, 3 );
insert into coffee_order_item values (20, 1, 3, 6, 4 );
insert into coffee_order_item values (21, 1, 1, 6, 5 );


