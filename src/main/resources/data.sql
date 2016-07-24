INSERT INTO role(id,name) values(1,'USER');
INSERT INTO role(id,name) values(2,'MANAGER');
INSERT INTO role(id,name) values(3,'ADMIN');

INSERT INTO user(id,login,role_id) VALUES (1,'coolig',1);
INSERT INTO user(id,login,role_id) VALUES (2,'manager',2);
INSERT INTO user(id,login,role_id) VALUES (3,'test user',3);
INSERT INTO user(id,login,role_id) VALUES (4,'magazynier',2);

INSERT INTO permission(id,name) values(1,'podglad user-open');
INSERT INTO permission(id,name) values(2,'podglad user-closed');
INSERT INTO permission(id,name) values(3,'podglad user-printed');
--
INSERT INTO permission(id,name) values(4,'podglad manager-open');
INSERT INTO permission(id,name) values(5,'podglad manager-closed');
--
INSERT INTO permission(id,name) values(6,'podglad magazynier open');
INSERT INTO permission(id,name) values(7,'podglad magazynier closed');
INSERT INTO permission(id,name) values(8,'podglad magazynier printed');


--user
INSERT INTO role_permission(permission_id,role_id) VALUES(1,1);
INSERT INTO role_permission(permission_id,role_id) VALUES(2,1);
INSERT INTO role_permission(permission_id,role_id) VALUES(3,1);
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

--INSERT INTO menu_block_item_permission(id,permission_id,menu_block_item_id) VALUES(1,1,1);
--INSERT INTO menu_block_item_permission(id,permission_id,menu_block_item_id) VALUES(2,2,2);
--INSERT INTO menu_block_item_permission(id,permission_id,menu_block_item_id) VALUES(3,3,3);
--INSERT INTO menu_block_item_permission(id,permission_id,menu_block_item_id) VALUES(4,4,4);
--INSERT INTO menu_block_item_permission(id,permission_id,menu_block_item_id) VALUES(5,5,5);