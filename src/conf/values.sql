delete from transfers;
delete from accounts;
delete from persons;


insert into Persons values ('121256-0555','Hr', 'Kurt','Hansen', 'Solvej 8', 5320,'01234567', 'kurt@mail.dk', 'test','Person');
insert into Persons values ('111190-0444','Fr', 'Sonja','Jensen', 'Månegade 8', 5320,'76543210', 'sonja@mail.dk', 'test','Person');
insert into Persons values ('010256-0777','Hr', 'James','Bond', 'Mars Alle 17', 5320,'20007007', 'james@bond.dk', 'test','Person');
insert into Persons values ('121256-0255','Hr','Hans','Hansen','Balevej 9',5320,'42424252','Hans@email.dk','test','Person');
insert into Persons values ('140590-3333','Hr','Jan','Jansen','JansenVej 10',5320,'67262819','Jan@email.dk','test','Person');
insert into Persons values ('151044-2323','Fr','Julie','Julisen','JuleVej 11',5320,'28329832','Julie@email.dk','test','Person');
insert into Persons values ('120990-3232','Fr','Anna','Annasen','AndVej 13',5320,'75927191','Anne@email.dk','test','Person');
insert into Persons values ('140639-9999','Hr','Lars','Larsen','Landvejen 42',5320,'92327151','Lars@email.dk','test','Person');


insert into accounts values ('4711-1001',1000.00,0.08,'121256-0555','CheckingAccount');
insert into accounts values ('4711-1002',1000.00,0.025,'121256-0555','CheckingAccount');
insert into accounts values ('4711-1003',1000.00,0.035,'121256-0555','CheckingAccount');
insert into accounts values ('4711-1004',1000.00,0.026,'121256-0555','CheckingAccount');
insert into accounts values ('4711-1005',1000.00,0.1,'111190-0444','CheckingAccount');
insert into accounts values ('4711-1006',1000.00,0.01,'111190-0444','CheckingAccount');
insert into accounts values ('4711-1007',1000.00,0.25,'010256-0777','CheckingAccount');

insert into transfers values (1, 10000, '2014-01-01', '4711-1001', '4711-1007');
insert into transfers values (2, 12345, '2014-01-01', '4711-1005', '4711-1007');
insert into transfers values (3, 5000, '2014-01-01', '4711-1001', '4711-1005');