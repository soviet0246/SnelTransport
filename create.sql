create sequence hibernate_sequence start 1 increment 1
create table article (article_id varchar(255) not null, article_color varchar(255), article_name varchar(255) not null, article_price float8, article_type varchar(255) not null, article_warehouse_location varchar(255) not null, primary key (article_id))
create table customer (customer_id int4 not null, customer_city varchar(255) not null, customer_fax_number varchar(255), customer_housenumber varchar(255) not null, customer_name varchar(255) not null, customer_postcode varchar(255) not null, customer_street varchar(255) not null, customer_tel_number varchar(255) not null, primary key (customer_id))
create table order_detail (order_detail_id  serial not null, quantity int4, article_article_id varchar(255) not null, order_order_id int4, order_id int4 not null, primary key (order_detail_id))
create table orders (order_id int4 not null, customer_id int4, order_status boolean not null, order_type varchar(255) not null, primary key (order_id))
alter table order_detail add constraint FKsxg1xkqcagua6dq8gg60g6jtu foreign key (article_article_id) references article
alter table order_detail add constraint FKjey3jevxw98cweb4o1ww6vrym foreign key (order_order_id) references orders
alter table order_detail add constraint FKrws2q0si6oyd6il8gqe2aennc foreign key (order_id) references orders
