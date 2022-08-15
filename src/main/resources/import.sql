INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);

INSERT INTO tb_category (name) VALUES ('Action');
INSERT INTO tb_category (name) VALUES ('Fiction');
INSERT INTO tb_category (name) VALUES ('Romance');

INSERT INTO tb_author (name) VALUES ('JK Rowling');
INSERT INTO tb_author (name) VALUES ('Machado De Assis');
INSERT INTO tb_author (name) VALUES ('Monteiro Lobato');

INSERT INTO tb_book (name,publishing_company,author_id) VALUES ('Harry Potter e a Pedra Filosofal','Rocco',1);
INSERT INTO tb_book (name,publishing_company,author_id) VALUES ('Harry Potter e a Camara Secreta','Rocco',1);
INSERT INTO tb_book (name,publishing_company,author_id) VALUES ('Dom Casmurro','Saraiva',2);
INSERT INTO tb_book (name,publishing_company,author_id) VALUES ('Sitio Do PicaPau Amarelo','Saraiva',3);

INSERT INTO tb_book_category (book_id, category_id) VALUES (1, 1);
INSERT INTO tb_book_category (book_id, category_id) VALUES (1, 2);
INSERT INTO tb_book_category (book_id, category_id) VALUES (2, 1);
INSERT INTO tb_book_category (book_id, category_id) VALUES (2, 3);
INSERT INTO tb_book_category (book_id, category_id) VALUES (3, 3);

INSERT INTO tb_loan (delivery_date,return_date,user_id) VALUES ('2022-08-08','2022-08-25',1);

INSERT INTO tb_loan_book(loan_id,book_id) VALUES(1,1); 
INSERT INTO tb_loan_book(loan_id,book_id) VALUES(1,2);
