insert into Article(id, publication_date, publication_time, creation_date_time, title) values(1, TO_DATE('01/01/2018', 'DD/MM/YYYY'), TO_DATE('15:00', 'HH24:MI'), TO_DATE('31/12/2017 07:30', 'DD/MM/YYYY HH24:MI'), 'Lorem ipsum solos cartos');
insert into Article(id, publication_date, publication_time, creation_date_time, title) values(2, TO_DATE('01/01/2018', 'DD/MM/YYYY'), TO_DATE('15:30', 'HH24:MI'), TO_DATE('15/12/2017 08:00', 'DD/MM/YYYY HH24:MI'), 'The Science of Reasoning With Unreasonable People');
insert into Article(id, publication_date, publication_time, creation_date_time, title) values(3, TO_DATE('15/12/2017', 'DD/MM/YYYY'), TO_DATE('16:00', 'HH24:MI'), TO_DATE('01/12/2017 13:45', 'DD/MM/YYYY HH24:MI'), 'A Dog’s Place Is at the White House');
insert into Article(id, publication_date, publication_time, creation_date_time, title) values(4, TO_DATE('28/02/2019', 'DD/MM/YYYY'), TO_DATE('11:00', 'HH24:MI'), TO_DATE('15/03/2018 08:00', 'DD/MM/YYYY HH24:MI'), 'U.S. Vaccination Rollout Gathers Speed, as Threat of Variants Grows');
insert into Article(id, publication_date, publication_time, creation_date_time, title) values(5, null, null, TO_DATE('31/03/2018 11:10', 'DD/MM/YYYY HH24:MI'), 'How the Stock Market’s Relentless Rise Saved Companies');

insert into Author(id, first_Name, last_Name) values(1, 'Bill', 'Clinton');
insert into Author(id, first_Name, last_Name) values(2, 'Barrack', 'Obama');
insert into Author(id, first_Name, last_Name) values(3, 'Geoffery', 'Ho');
insert into Author(id, first_Name, last_Name) values(4, 'Lisa', 'Ray');
insert into Author(id, first_Name, last_Name) values(5, 'Anupam', 'Kher');

insert into Webuser(id, first_Name, last_Name, username) values(1, 'Tim', 'Collins', 'tcollins');
insert into Webuser(id, first_Name, last_Name, username) values(2, 'Brain', 'Temple', 'btemple');
insert into Webuser(id, first_Name, last_Name, username) values(3, 'David', 'Graham', 'dgraham');

insert into Article_Author(article_id, author_id) values(1,4);
insert into Article_Author(article_id, author_id) values(2,3);
insert into Article_Author(article_id, author_id) values(3,2);
insert into Article_Author(article_id, author_id) values(4,1);
insert into Article_Author(article_id, author_id) values(5,4);
insert into Article_Author(article_id, author_id) values(5,5);
insert into Article_Author(article_id, author_id) values(5,1);

insert into Article_Rating(article_id, webuser_id, rating) values(1,1,4);
insert into Article_Rating(article_id, webuser_id, rating) values(3,1,5);
insert into Article_Rating(article_id, webuser_id, rating) values(5,2,3);
insert into Article_Rating(article_id, webuser_id, rating) values(1,2,3);

insert into Article_Comment(id, article_id, webuser_id, text) values(1,1,1,'Great Article!');
insert into Article_Comment(id, article_id, webuser_id, text) values(2,2,1,'Well written and edited. Interesting take.');
insert into Article_Comment(id, article_id, webuser_id, text) values(3,3,2,'Interesting read. Barrack style is plain, simple and direct');
insert into Article_Comment(id, article_id, webuser_id, text) values(4,3,3,'Bestseller. Must read.');
insert into Article_Comment(id, article_id, webuser_id, text) values(5,3,2,'I agree with the approach and the authors take.');
