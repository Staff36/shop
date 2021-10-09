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


create table carts(
    id serial primary key,
    user_id integer references users (id)

);

create table carts2products(
   carts_id    bigint not null,
   products_id    int not null,
   primary key (carts_id, products_id),
   foreign key (carts_id) references carts (id),
   foreign key (products_id) references products (id)
);

create table orders(
   id serial primary key ,
   cart_id integer references carts (id),
   user_id integer references users (id),
   created_at  timestamp default now()
);
insert into users(id , email , password) VALUES (1, 'user1','123');
insert into users(id , email , password) VALUES (2, 'user2','123');
