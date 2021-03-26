drop table if exists board;

create table board (
   id bigint not null auto_increment,
   title varchar(255),
   writer varchar(255),
   content BLOB,
   reg_date timestamp,
   primary key (id)
);