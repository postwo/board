-- 123 게시글
insert into article (user_id, title, content, created_by, modified_by, created_at, modified_at) values
                                                                                                    ('uno2', 'Quisque ut erat.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.

#yellow', 'Tessy', 'Nan', '2021-10-07 20:30:36', '2021-03-06 01:51:12'),
('uno', 'Nulla justo.', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 'Babette', 'Dudley', '2021-02-05 15:19:07', '2021-04-01 14:46:59'),
('uno', 'Aenean lectus.', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.

Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.

Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

#yellow', 'Hoyt', 'Austina', '2021-06-26 18:20:38', '2021-02-20 16:09:49'),
('uno', 'Ut tellus.', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.

Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 'Wilmer', 'Ingra', '2021-07-19 14:18:17', '2022-01-23 17:29:54')
;



-- 300 댓글
insert into article_comment (article_id, user_id, parent_comment_id, content, created_at, modified_at, created_by, modified_by) values
                                                                                                                                    (49, 'uno', null, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2021-03-02 22:40:04', '2021-04-27 15:38:09', 'Lind', 'Orv'),
                                                                                                                                    (108, 'uno', null, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2021-06-08 04:36:02', '2022-01-25 15:35:42', 'Trstram', 'Loy'),
                                                                                                                                    (31, 'uno2', null, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', '2021-04-10 00:47:10', '2021-02-06 20:58:04', 'Duff', 'Early'),
                                                                                                                                    (120, 'uno2', null, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', '2021-08-21 08:39:39', '2021-11-17 22:47:35', 'Sydney', 'Boony'),
(97, 'uno', null, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', '2021-07-18 10:42:20', '2021-12-25 13:59:02', 'Richmound', 'Wilmar'),
(6, 'uno', null, 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', '2021-02-08 10:45:24', '2021-04-04 03:18:49', 'Rees', 'Kerk'),
(106, 'uno', null, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2021-02-12 12:56:15', '2021-06-19 00:23:26', 'Kiley', 'Keenan'),
(77, 'uno', null, 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2022-01-08 02:32:10', '2021-07-23 12:21:01', 'Harlen', 'Zacharia'),
(56, 'uno', null, 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', '2021-11-18 01:32:48', '2021-06-06 01:59:25', 'Vittorio', 'Milty'),
(19, 'uno', null, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', '2021-05-07 23:57:29', '2021-04-03 21:55:11', 'Oliver', 'Graehme')
;



-- 대댓글
insert into article_comment (article_id, user_id, parent_comment_id, content, created_at, modified_at, created_by, modified_by) values
                                                                                                                                    (49, 'uno', 1, '퍼가요~', '2021-03-02 22:40:04', '2021-04-27 15:38:09', 'Uno', 'Uno'),
                                                                                                                                    (49, 'uno2', 1, '퍼가요~', '2021-03-03 22:40:04', '2021-04-27 15:38:09', 'Uno2', 'Uno2'),
                                                                                                                                    (49, 'uno', 1, '또 퍼가요~', '2021-03-04 22:40:04', '2021-04-27 15:38:09', 'Uno', 'Uno'),
                                                                                                                                    (49, 'uno', 1, '또또 퍼가요~', '2021-03-05 22:40:04', '2021-04-27 15:38:09', 'Uno', 'Uno')
;



insert into hashtag (hashtag_name, created_at, modified_at, created_by, modified_by) values
                                                                                         ('blue', now(), now(), 'uno', 'uno'),
                                                                                         ('crimson', now(), now(), 'uno', 'uno'),
                                                                                         ('fuscia', now(), now(), 'uno', 'uno'),
                                                                                         ('goldenrod', now(), now(), 'uno', 'uno'),
                                                                                         ('green', now(), now(), 'uno', 'uno'),
                                                                                         ('indigo', now(), now(), 'uno', 'uno'),
                                                                                         ('khaki', now(), now(), 'uno', 'uno'),
                                                                                         ('maroon', now(), now(), 'uno', 'uno'),
                                                                                         ('mauv', now(), now(), 'uno', 'uno'),
                                                                                         ('orange', now(), now(), 'uno', 'uno'),
                                                                                         ('pink', now(), now(), 'uno', 'uno'),
                                                                                         ('puce', now(), now(), 'uno', 'uno'),
                                                                                         ('purple', now(), now(), 'uno', 'uno'),
                                                                                         ('red', now(), now(), 'uno', 'uno'),
                                                                                         ('teal', now(), now(), 'uno', 'uno'),
                                                                                         ('turquoise', now(), now(), 'uno', 'uno'),
                                                                                         ('violet', now(), now(), 'uno', 'uno'),
                                                                                         ('yellow', now(), now(), 'uno', 'uno'),
                                                                                         ('white', now(), now(), 'uno', 'uno')
;



insert into article_hashtag (article_id, hashtag_id) values
                                                         (1, 11),
                                                         (2, 13),
                                                         (3, 13),
                                                         (4, 9),
                                                         (5, 5),
                                                         (6, 8),
                                                         (7, 10),
                                                         (8, 15),
                                                         (9, 7),
                                                         (10, 12),
                                                         (11, 10),
                                                         (12, 13),
                                                         (13, 8),
                                                         (15, 7),
                                                         (18, 4),
                                                         (19, 18),
                                                         (20, 10),
                                                         (21, 3),
                                                         (22, 12),
                                                         (24, 15),
                                                         (25, 3),
                                                         (26, 8),
                                                         (27, 15),
                                                         (28, 16),
                                                         (29, 3),
                                                         (31, 1),
                                                         (32, 18),
                                                         (33, 11),
                                                         (34, 4),
                                                         (35, 1),
                                                         (37, 13),
                                                         (38, 5),
                                                         (40, 16),
                                                         (42, 3),
                                                         (43, 17),
                                                         (45, 14),
                                                         (45, 19),
                                                         (47, 13),
                                                         (48, 2),
                                                         (49, 6),
                                                         (50, 7),
                                                         (52, 16),
                                                         (54, 11),
                                                         (55, 10),
                                                         (57, 10),
                                                         (58, 11),
                                                         (59, 2),
                                                         (60, 2),
                                                         (61, 15),
                                                         (63, 17),
                                                         (64, 17),
                                                         (65, 17),
                                                         (66, 16),
                                                         (67, 12),
                                                         (68, 3),
                                                         (70, 12),
                                                         (71, 11),
                                                         (72, 3),
                                                         (73, 14),
                                                         (75, 16),
                                                         (76, 1),
                                                         (77, 11),
                                                         (80, 13),
                                                         (81, 17),
                                                         (82, 16),
                                                         (83, 13),
                                                         (84, 2),
                                                         (85, 15),
                                                         (86, 14),
                                                         (88, 17),
                                                         (90, 7),
                                                         (91, 10),
                                                         (92, 13),
                                                         (93, 16),
                                                         (94, 16),
                                                         (95, 3),
                                                         (96, 8),
                                                         (97, 18),
                                                         (98, 10),
                                                         (99, 17),
                                                         (100, 2),
                                                         (102, 12),
                                                         (103, 14),
                                                         (104, 7),
                                                         (105, 16),
                                                         (106, 14),
                                                         (107, 1),
                                                         (111, 18),
                                                         (112, 6),
                                                         (113, 9),
                                                         (114, 2),
                                                         (116, 16),
                                                         (117, 14),
                                                         (119, 12),
                                                         (120, 18),
                                                         (122, 18)
;