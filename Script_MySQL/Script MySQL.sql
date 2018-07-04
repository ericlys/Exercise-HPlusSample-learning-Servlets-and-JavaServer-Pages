create table products( product_id integer primary key, product_name varchar(50), image_path varchar(100));

create table users( username varchar(50) primary key not null, password varchar(50),
    first_name varchar(50), last_name varchar(50), age integer, activity varchar(100));
    
create table orders( order_id int primary key auto_increment, product_name varchar(50), image_path varchar(50), order_date date, user_name varchar (50),
foreign key (user_name) references users (username));

insert into products values(1, 'mineralwater-blueberry', '../images/products/mineralwater-blueberry.jpg');
insert into products values(2, 'mineralwater-lemonlime', '../images/mineralwater-lemonlime.jpg');
insert into products values(3, 'mineralwater-orange', '../images/mineralwater-orange.jpg');
insert into products values(4, 'mineralwater-strawberry', '../images/mineralwater-strawberry.jpg');
insert into products values(5, 'mineralwater-peach', '../images/mineralwater-peach.jpg');
insert into products values(6, 'mineralwater-raspberry', '../images/mineralwater-raspberry.jpg');

select * from users