drop table if exists news_data;
drop table if exists main_news;

create table news_data(
  id int not null AUTO_INCREMENT,
  key text,
  value text,
  main_news_id int not null,
  PRIMARY KEY (id)
);

CREATE TABLE main_news (
  id int not null,
  file_name VARCHAR(512),
  file_path VARCHAR(512),
  is_file tinyint(1),
  PRIMARY KEY (id)
);