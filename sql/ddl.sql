drop table if exists board;
drop sequence if exists hibernate_sequence;

create table board (
   id bigint not null,
    title varchar(255),
    writer varchar(255),
    content CLOB(20K),
    reg_date timestamp,
    primary key (id)
);