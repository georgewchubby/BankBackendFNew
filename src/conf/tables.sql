drop table transfers;
drop table accounts;
drop table persons;
drop table postals;

create table Postals (
postalCode int primary key,
postalDistrict varchar(40)
);

create table Persons (
cpr varchar(11) primary key,
title varchar(80),
firstName varchar(80) not null,
lastName varchar(80) not null,
street varchar(80),
postalCode int references Postals(postalCode),
phone varchar(8), 
email varchar(80),
password varchar(255),
dtype varchar(30) not null
);

create table Accounts (
accountNumber varchar(10) primary key,
balance decimal,
interest decimal,
owner varchar(11) references Persons(cpr),
dtype varchar(30) not null
);

create table Transfers (
id int primary key,
amount decimal,
transferDate date,
sourceAccount varchar(10) references Accounts(accountNumber),
targetAccount varchar(10) references Accounts(accountNumber)
);
