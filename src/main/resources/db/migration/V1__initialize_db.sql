create table users(
    id serial primary key ,
    email varchar(255),
    password varchar(255)
);

create table products(
    id serial primary key ,
    name varchar(255),
    description varchar(2000),
    price float
);
insert into products(id, name, description, price) VALUES (1, 'test1','tested description', 23.17);
insert into products(id , name, description, price) VALUES (2, 'test2','tested description12qwAF', 2.1);
