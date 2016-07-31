INSERT INTO Category(id,name)VALUES(1, 'Sports');
INSERT INTO Category(id,name)VALUES(2, 'News');
INSERT INTO Category(id,name)VALUES(3, 'General');

INSERT INTO UserStatus(id,name)VALUES(0, 'Not Active');  --user is not active
INSERT INTO UserStatus(id,name)VALUES(1, 'Active'); -- user is active but may be logged out
INSERT INTO UserStatus(id,name)VALUES(2, 'Loggedin');  --user is active and logged in

INSERT INTO Users(id,name,status)VALUES(1, 'User1', 1);  --active user and has category 1 and 2
INSERT INTO Users(id,name,status)VALUES(2, 'User2', 1);  --active user and has category 3 and 2
INSERT INTO Users(id,name,status)VALUES(3, 'User3', 1);  --active user and has category 3
INSERT INTO Users(id,name,status)VALUES(4, 'User4', 2);  --logedin user and has category 1, 2 and 3
INSERT INTO Users(id,name)VALUES(5, 'User5');  --inactive user and has category 1, 2 and 3.
INSERT INTO Users(id,name)VALUES(6, 'User6');  --inactive user and has category 1, 2 and 3.

INSERT INTO UserCategories(userId,categoryId)VALUES(1, 1);
INSERT INTO UserCategories(userId,categoryId)VALUES(1, 2);
INSERT INTO UserCategories(userId,categoryId)VALUES(2, 2);
INSERT INTO UserCategories(userId,categoryId)VALUES(2, 3);
INSERT INTO UserCategories(userId,categoryId)VALUES(3, 3);

INSERT INTO UserCategories(userId,categoryId)VALUES(4, 1);
INSERT INTO UserCategories(userId,categoryId)VALUES(4, 2);
INSERT INTO UserCategories(userId,categoryId)VALUES(4, 3);

INSERT INTO UserCategories(userId,categoryId)VALUES(5, 1);
INSERT INTO UserCategories(userId,categoryId)VALUES(5, 2);
INSERT INTO UserCategories(userId,categoryId)VALUES(5, 3);

INSERT INTO UserCategories(userId,categoryId)VALUES(6, 1);
INSERT INTO UserCategories(userId,categoryId)VALUES(6, 2);
INSERT INTO UserCategories(userId,categoryId)VALUES(6, 3);

INSERT INTO UserNewsDeliveryStatus(id,name)VALUES(1, 'created');
INSERT INTO UserNewsDeliveryStatus(id,name)VALUES(2, 'send to notify');
INSERT INTO UserNewsDeliveryStatus(id,name)VALUES(3, 'notifying');
INSERT INTO UserNewsDeliveryStatus(id,name)VALUES(4, 'delivered');

