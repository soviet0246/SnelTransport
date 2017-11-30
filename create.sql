create sequence hibernate_sequence start 1 increment 1
create table orders (order_id int4 not null, date_and_time_of_order_made bytea not null, order_type varchar(255) not null, primary key (order_id))
