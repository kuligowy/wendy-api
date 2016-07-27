INSERT INTO role(id,name) values(1,'USER');
INSERT INTO role(id,name) values(2,'MANAGER');
INSERT INTO role(id,name) values(3,'ADMIN');

INSERT INTO user(id,login,role_id) VALUES (1,'coolig',1);
INSERT INTO user(id,login,role_id) VALUES (2,'manager',2);
INSERT INTO user(id,login,role_id) VALUES (3,'test user',3);
INSERT INTO user(id,login,role_id) VALUES (4,'magazynier',2);

INSERT INTO permission(id,name) values(1,'podglad-user-open');
INSERT INTO permission(id,name) values(2,'podglad-user-closed');
INSERT INTO permission(id,name) values(3,'podglad-user-printed');
--
INSERT INTO permission(id,name) values(4,'podglad-manager-open');
INSERT INTO permission(id,name) values(5,'podglad-manager-closed');
--
INSERT INTO permission(id,name) values(6,'podglad-magazynier open');
INSERT INTO permission(id,name) values(7,'podglad-magazynier closed');
INSERT INTO permission(id,name) values(8,'podglad-magazynier printed');

INSERT INTO permission(id,name) values(9,'10-close');
INSERT INTO permission(id,name) values(10,'10-delete');


--user
INSERT INTO role_permission(permission_id,role_id) VALUES(1,1);
INSERT INTO role_permission(permission_id,role_id) VALUES(2,1);
INSERT INTO role_permission(permission_id,role_id) VALUES(3,1);
INSERT INTO role_permission(permission_id,role_id) VALUES(9,1);
--INSERT INTO role_permission(permission_id,role_id) VALUES(10,1);
--manager
INSERT INTO role_permission(permission_id,role_id) VALUES(4,2);
INSERT INTO role_permission(permission_id,role_id) VALUES(5,2);
--admin
INSERT INTO role_permission(permission_id,role_id) VALUES(1,3);
INSERT INTO role_permission(permission_id,role_id) VALUES(2,3);
INSERT INTO role_permission(permission_id,role_id) VALUES(3,3);
INSERT INTO role_permission(permission_id,role_id) VALUES(4,3);
INSERT INTO role_permission(permission_id,role_id) VALUES(5,3);

INSERT INTO user_permission(permission_id,user_id) VALUES(6,4);
INSERT INTO user_permission(permission_id,user_id) VALUES(7,4);
INSERT INTO user_permission(permission_id,user_id) VALUES(8,4);

INSERT INTO menu_block(id,title,sort) VALUES (1,'USER',10);
INSERT INTO menu_block(id,title,sort) VALUES (2,'MANAGER',20);
INSERT INTO menu_block(id,title,sort) VALUES (3,'MAGAZYNIER',10);
--user
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (1,'open',10,1,1,10);
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (2,'closed',20,1,2,20);
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (3,'printed',30,1,3,30);
--manager
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (4,'open',40,2,4,10);
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (5,'closed',50,2,5,20);
--USER/magazynier
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (6,'open',10,3,6,10);
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (7,'closed',20,3,7,20);
INSERT INTO menu_block_item(id,title,status_id,menu_block_id,permission_id,sort) VALUES (8,'printed',30,3,8,30);

INSERT INTO supplier(id,title,address) values(1,'dostawca A','fordonska');
INSERT INTO supplier(id,title,address) values(2,'dostawca B','gdańska');
INSERT INTO supplier(id,title,address) values(3,'dostawca C','focha');
INSERT INTO supplier(id,title,address) values(4,'dostawca D','toruńska');

insert into product(id,title) values(1,'mydlo');
insert into product(id,title) values(2,'pasta');
insert into product(id,title) values(3,'gąbka');
insert into product(id,title) values(4,'szczotka');
insert into product(id,title) values(5,'ręcznik');

insert into worder_status(id,title) values (10,'open 10');
insert into worder_status(id,title) values (20,'open 20 ');
insert into worder_status(id,title) values (30,'open 30 ');
insert into worder_status(id,title) values (40,'open 40');
insert into worder_status(id,title) values (50,'open 50 ');

insert into worder (id,timeoforder,description,owner_id,status_id) values(1,now(),'test 10',1,10);
insert into worder (id,timeoforder,description,owner_id,status_id) values(2,now(),'test 10 - 2',1,10);
insert into worder (id,timeoforder,description,owner_id,status_id) values(3,now(),'test 220',1,20);
insert into worder (id,timeoforder,description,owner_id,status_id) values(4,now(),'test 40',1,30);
insert into worder (id,timeoforder,description,owner_id,status_id) values(5,now(),'test 50',1,30);

insert into worder_item(id,price,quantity,product_id,supplier_id,worder_id) values(1,10,10,1,1,1);
insert into worder_item(id,price,quantity,product_id,supplier_id,worder_id) values(2,11,9,2,3,2);
insert into worder_item(id,price,quantity,product_id,supplier_id,worder_id) values(3,12,8,3,2,3);
insert into worder_item(id,price,quantity,product_id,supplier_id,worder_id) values(4,13,7,4,4,4);
insert into worder_item(id,price,quantity,product_id,supplier_id,worder_id) values(5,14,6,5,3,5);

