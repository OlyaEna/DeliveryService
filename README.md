Задача. Интернет-кафе.

Необходимо написать интернет-кафе - сайт, на котором каждый желающий может
заказать себе чашечку (или несколько) кофе на любой вкус.

Пользователь зайдя на сайт, может выбрать сорта кофе, которые он хочет
заказать, отметив соответствующие строки в списке возможных сортов.
Список сортов храниться в базе данных. В списке на UI не показываются
сорта с disabled='Y'.
Для каждого сорта кофе пользователь может ввести количество чашек.

После того как пользователь определился с выбором, он нажимает кнопку
"заказать" и вводит в появившейся странице свой адрес, на который
необходимо доставить заказ и имя. После окончательного подтверждения,
информация о заказе сохраняется в БД.

Правило подсчёта цены заказа:
  1. каждая n чашка кофе одного сорта бесплатна.
     Пример (n=5):
       2 чашки чёрного кофе по 1 TGR и 4 чашки со сливками по 2 TGR в
       сумме стоят 10 TGR
       но 6 чашек чёрного кофе по 1 TGR стоят 5 TGR, потому что 5 чашка
       бесплатная.
  2. если заказ был сделан более чем на x TGR, то доставка бесплатна,
     в противном случае стоимость доставки = m TGR

3. Значения для n, x, m задаются в базе данных в таблице Configuration:
 id = 'n', id = 'x' и id = 'm' соответственно. Значения по умолчанию:
 n = 5, x = 10, m = 2

Магазин может время от времени менять правила подсчёта цены заказа, поэтому
необходимо облегчить эту процедуру, сделав необходимые изменения в коде
для смены алгоритма минимальными. В идеальном случае они не должны требовать
перекомпиляции приложения :).
Одно из решений использовать скриптовый язык (bsh, groovy, jython) для этой
цели, но в реализации данного тестого задания это решение использовать нельзя.

Требования к пользовательскому интерфейсу:
  1. интерфейс на 2-х языках (русский и английский).
  2. интернационализация i18n c языком по умолчанию - английским.
  3. Валидация (client side + server side).
  
Требования к реализации:
  1. Приложение должно работать на MySQL, MSSQL server, Oracle, PostgreSQL.
     Проверять все эти БД не обязательно, но задуматься стоит над тем, что
     и как стоит применить для работы с БД.
  2. Запускается или путем разворачивания на сервере приложения типа Tomcat
     или как независимое приложение (например, используя Spring Boot).
     
Используемые технологии:
Java, Spring (Boot, MVC, Security), Hibernate, HTML, CSS, Maven, MySQL, Thymeleaf,
Flyway, JUnit, Mockito.

Главная страница:
- для администратора (EN)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/mainAdminEN.JPG)
- для неавторизованного пользователя (РУС) 
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/mainPageNotAuthorizedRU.JPG)
- для авторизованного пользователя (EN) 
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/mainPageAuthorizedEN.JPG)

Корзина: 
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/cartEN.JPG)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/cartRU.JPG)

Заказы:
- нет заказов
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/UserNoOrdersEN.JPG)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/userNoOrdersRu.JPG)
- все заказы на странице администратора (EN)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/adminOrdersEN.JPG)
- все заказы на странице пользователя (РУС)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/ordersRU.JPG)
- детали заказа (EN)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/OrderDetailsEN.JPG)

Логин: 
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/loginRU.JPG)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/logoutEN.JPG)

Валидация: 
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/validationRU.JPG)
![image](https://github.com/OlyaEna/DeliveryService/blob/master/src/main/resources/static/images/registerValidRU.JPG)
