INSERT INTO role(id,name) values(1,'USER');
INSERT INTO role(id,name) values(2,'MANAGER');
INSERT INTO role(id,name) values(3,'ADMIN');

INSERT INTO user(id,login,role_id) VALUES (1,'coolig',1);
INSERT INTO user(id,login,role_id) VALUES (2,'manager',2);
INSERT INTO user(id,login,role_id) VALUES (3,'testratownik',3);

INSERT INTO permission(id,name) values(1,'podglad user-open');
INSERT INTO permission(id,name) values(2,'podglad user-closed');
INSERT INTO permission(id,name) values(3,'podglad user-printed');
INSERT INTO permission(id,name) values(4,'podglad manager-open');
INSERT INTO permission(id,name) values(5,'podglad manager-closed');

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


INSERT INTO menu(id,title,position) VALUES (1,'USER',1);
INSERT INTO menu(id,title,position) VALUES (2,'MANAGER',2);
--user
INSERT INTO menu_item(id,name,status_id,menu_block_id) VALUES (1,'open',10,1);
INSERT INTO menu_item(id,name,status_id,menu_block_id) VALUES (2,'closed',20,1);
INSERT INTO menu_item(id,name,status_id,menu_block_id) VALUES (3,'printed',30,1);
--manager
INSERT INTO menu_item(id,name,status_id,menu_block_id) VALUES (4,'open',40,2);
INSERT INTO menu_item(id,name,status_id,menu_block_id) VALUES (5,'closed',50,2);


INSERT INTO menu_item_permission(id,permission_id,menu_block_item_id) VALUES(1,1,1);
INSERT INTO menu_item_permission(id,permission_id,menu_block_item_id) VALUES(2,2,2);
INSERT INTO menu_item_permission(id,permission_id,menu_block_item_id) VALUES(3,3,3);
INSERT INTO menu_item_permission(id,permission_id,menu_block_item_id) VALUES(4,4,4);
INSERT INTO menu_item_permission(id,permission_id,menu_block_item_id) VALUES(5,5,5);