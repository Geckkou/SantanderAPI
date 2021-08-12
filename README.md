create TABLE if not exists tb_stock (

  id NUMERIC(9) not NULL,

  "date" DATE NOT NULL,

  "name" VARCHAR(100) NOT NULL,

  price NUMERIC(8,2) NOT NULL,

  variation NUMERIC(5,2) not NULL,

  constraint tb_stock_pk PRIMARY KEY (id)  

);



CREATE sequence hibernate_sequence start 1;



SELECT * from tb_stock;