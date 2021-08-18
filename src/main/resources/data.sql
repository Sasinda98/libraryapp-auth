INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information)
VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'book,user', 'authorization_code,password,refresh_token,implicit', '{}');

INSERT INTO PERMISSION (id, NAME) VALUES
(1, 'borrow_book'),
(2, 'return_book'),
(3, 'update_book'),
(4, 'delete_book'),
(5, 'list_users_for_book'),
(6, 'list_books_for_user');


INSERT INTO role (id, NAME) VALUES
(1, 'ROLE_librarian'),
(2, 'ROLE_teacher'),
(3, 'ROLE_student');

INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
(1,1), /* borrow_book -> ROLE_librarian */
(2,1), /* return_book -> ROLE_librarian */
(3,1), /* update_book -> ROLE_librarian */
(4,1), /* delete_book -> ROLE_librarian */
(5,1), /* list_users_for_book -> ROLE_librarian */
(6,1), /* list_books_for_user -> ROLE_librarian */

(1,2), /* borrow_book -> ROLE_teacher */
(2,2), /* return_book -> ROLE_teacher */
(5,2), /* list_users_for_book -> ROLE_teacher */
(6,2), /* list_books_for_user -> ROLE_teacher */

(1,3), /* borrow_book -> ROLE_student */
(2,3); /* return_book -> ROLE_student */

insert into muser (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked)
VALUES ('1', 'gayal_the_librarian','{bcrypt}$2a$10$ODGwrk2ufy5d7T6afmACwOA/6j6rvXiP5amAMt1YjOQSdEw44QdqG', 'gayal@domain.com', '1', '1', '1', '1');

insert into  muser (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked)
VALUES ('2', 'lewis_the_teacher', '{bcrypt}$2a$10$ODGwrk2ufy5d7T6afmACwOA/6j6rvXiP5amAMt1YjOQSdEw44QdqG','lewis@domain.com', '1', '1', '1', '1');

insert into  muser (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked)
VALUES ('3', 'john_the_student', '{bcrypt}$2a$10$ODGwrk2ufy5d7T6afmACwOA/6j6rvXiP5amAMt1YjOQSdEw44QdqG','john@domain.com', '1', '1', '1', '1');

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
VALUES
(1, 1) /* gayal --> librarian*/,
(2, 2) /* lewis --> teacher */,
(3,3) /* john --> student */ ;