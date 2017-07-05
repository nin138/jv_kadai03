DROP TABLE IF EXISTS t_order_detail;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_order;

CREATE TABLE t_user(
  id int PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20),
  address VARCHAR(255)
);

CREATE TABLE t_order(
  id int PRIMARY KEY AUTO_INCREMENT ,
  user_id int,
  order_datetime DATETIME
);
CREATE TABLE t_order_detail(
  order_id int,
  product_id VARCHAR(20),
  qty int,
  PRIMARY KEY (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES t_order(id)
);

INSERT INTO t_user(name, address) VALUES('name1', 'Tokyo'),('name2', 'Kanagawa');

INSERT INTO t_order(user_id, order_datetime) VALUES (2, now()),(1, now()), (1, now());

INSERT INTO t_order_detail VALUES (1, '1A', 5),(1, '3V', 2),(2,'2F',5),(3,'4G',20),(3,'4R',9);


SELECT id,user_id,order_datetime,product_id,qty FROM t_order JOIN t_order_detail ON t_order.id = t_order_detail.order_id ORDER BY id ASC;