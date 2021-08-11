/*INSERT tipos de productos*/

INSERT INTO tipos_productos (tipo,descripcion) VALUES ('Full cobertura','incrementa su precio a medida que pasa el tiempo');
INSERT INTO tipos_productos (tipo,descripcion) VALUES ('Full cobertura Super duper',' tal como el Full Cobertura, incrementa su precio a medida que se acerca su fecha de vencimiento');
INSERT INTO tipos_productos (tipo,descripcion) VALUES ('Super avance','dismuniye su precio el doble de rapido que un producto normal');
INSERT INTO tipos_productos (tipo,descripcion) VALUES ('Mega cobertura','nunca vence para vender y nunca disminuye su precio y tiene un precio fijo de 180.');
INSERT INTO tipos_productos (tipo,descripcion) VALUES ('Cobertura','producto normal');
INSERT INTO tipos_productos (tipo,descripcion) VALUES ('Baja cobertura','producto que no cubre todo');

/*INSERT productos*/

INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Tv Lg',20,10,200,'2021-07-26','Corresponde a televisores de marca LG',5);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Computador Acer',0,2,500,'2021-07-26','Corresponde a televisores de marca LG',1);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Asus Notebook',7,5,150,'2021-07-26','Corresponde a televisores de marca LG',6);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Lavadora LG',80,0,80,'2021-07-26','Corresponde a televisores de marca LG',4);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Hp Notebook',80,-1,90,'2021-07-26','Corresponde a televisores de marca LG',4);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Hp teclado Lg',20,15,175,'2021-07-26','Corresponde a televisores de marca LG',2);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Refrigerador Daewoo',49,10,20,'2021-07-26','Corresponde a televisores de marca LG',2);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Impresora HP',49,5,45,'2021-07-26','Corresponde a televisores de marca LG',2);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Acer Notebook Nitro 5',6,3,41,'2021-07-26','Corresponde a televisores de marca LG',3);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('TV Master-G',20,10,100,'2021-07-26','Corresponde a televisores de marca LG',5);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Notebook Dell',20,10,200,'2021-07-26','Corresponde a televisores de marca LG',5);
INSERT INTO productos (nombre,price, sell_in,stock,fecha_ingreso,descripcion,tipo_id) VALUES ('Lavadora mademsa ubuntu',20,10,70,'2021-07-26','Corresponde a televisores de marca LG',5);


/*INSERT registros de ventas*/

INSERT INTO registros_vendidos (descripcion,fecha_venta,producto_id) VALUES ('Se vendio una lavadora','2021-08-13',4);
INSERT INTO registros_vendidos (descripcion,fecha_venta,producto_id) VALUES ('Se vendio un notebook HP','2021-08-14',5);
INSERT INTO registros_vendidos (descripcion,fecha_venta,producto_id) VALUES ('Se vendio un Tv Lg','2021-08-11',1);
INSERT INTO registros_vendidos (descripcion,fecha_venta,producto_id) VALUES ('Se vendio un Acer notebook nitro','2021-08-25',9);





