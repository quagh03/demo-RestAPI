drop database shop;

create database shop;
use shop;

create table categories(
	cid int primary key not null auto_increment,
    cname varchar(255) not null,
    cdesc varchar(255) not null,
    cstatus int not null
);

create table product(
	pid int primary key not null auto_increment,
    pname varchar(255) not null,
    pdesc varchar(255) not null,
    cid int not null,
    pstatus int not null,
    foreign key (cid) references categories(cid)
);


insert into categories(cname, cdesc, cstatus) values ("Giày", "Danh mục giày", 1);
insert into categories(cname, cdesc, cstatus) values ("Quần", "Danh mục quần", 1);

insert into product(pname, pdesc, cid, pstatus) values("Nike AF1", "Không Lực 1 của Nike", 1, 1);
insert into product(pname, pdesc, cid, pstatus) values("Uniqlo SlimFit Blue", "Quần SlimFit màu xanh của Uniqlo", 2, 1);