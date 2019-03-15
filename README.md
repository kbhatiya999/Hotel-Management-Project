# Hotel-Management-Project
Refer below for tables
Credit:- JD

1. User

create table user(uid number(10) priamry key, email varchar(35), name varchar(50), phone number(10), address varchar(100), role char(3));


//Demo insert
insert into user values (1,'abc@gmail.com','abc',9999888811, 'publicis sapient', 'ind' );
insert into user values (2,'manager@gmail.com','Sapient manager',9999888822, 'publicis sapient manager', 'cor' );
insert into user values (101,'admin@gmail.com','Sapient admin',9999888833, 'publicis sapient employee', 'emp' );





2. Login

create table login (uid number(10), username varchar(20) primary key, password varchar(16), 
			role char(3), isactive boolean(1), foreign key (uid) references user(uid));


//Demo insert
insert into user values (1, 'abc123', 'password', 'ind', 1 );
insert into user values (2, 'manager', 'mypassword', 'cor', 1 );
insert into user values (101, 'admin', 'admin', 'emp', 1 );





3. Hotel

create table hotel (hid number(10) primary key, city varchar(30), discount number(3), totalrooms(5), hname varchar(40), address varchar(100));



//Demo insert
insert into hotel values(1, 'Delhi', 50, 20,'Hotel Hilton', 'Saket, New Delhi');
insert into hotel values(2, 'Mumbai', 30,150,'Hotel Taj', '256, Nehru nagar, Mumbai');
insert into hotel values(3, 'Jodhpur', 40, 10,'Hotel JW Mariott', 'Sco-45, Indira Nagar,Jodhpur');


4.roomtype

create table roomtype (rtypeid number(10) primary key,  type varchar(20), totalnoofrooms number(10), price number(5), 
			hid number(10), foreign key (hid) references hotel(hid));


//Demo insert

insert into roomtype values(1,'Deluxe-Non AC', 5, 1500, 1);
insert into roomtype values(2,'Deluxe-AC', 5, 2000, 1);
insert into roomtype values(3,'Premium-Queen AC', 5, 3000, 1);
insert into roomtype values(4,'Premium-King AC', 5, 4000, 1);
insert into roomtype values(1,'Deluxe-Non AC', 10, 2500, 2);
insert into roomtype values(2,'Deluxe-AC', 10, 3000, 2);
insert into roomtype values(3,'Premium-Queen AC', 30, 6000, 2);
insert into roomtype values(4,'Preimium-King AC', 100, 8000, 2);
insert into roomtype values(4,'Premium-King AC', 10, 15000, 3);


5. Reservation

create table Reservation (reservationId number(10) primary key, rtypeid number(10), uid number(10), hid number(10), pid number(10), 
				status varchar(10), checkindate date, noofrooms number(2), dealtype number(1),
				foreign key (hid) references hotel(hid), foreign key (rtypeid) references roomtype(rtypeid), 
				foreign key (uid) references user(uid), foreign key (pid) references package(pid) );


//Demo insert


insert into reservation values (1, 1, 1, 1, null, 'processing', 20/3/2019,2, 0);
insert into reservation values (2, 3, 2, 2, null, 'processing', 21/3/2019,20, 0);



6. Guest 


create table guest (gid number(10) primary key, name varchar(70), phone number(10), email varchar(35), reservationid(10), 
			modeofpayment char(3), isactive char(1),foreign key (reservationid) references reservation(reservationid));


//Demo insert

7. Package 

create table package (pid number(10) primary key, hid number(10), price number(5), description varchar(500), packagetype  number(1), 
			city varchar(30), noofdays number(2), rtypeid number(10), foreign key (hid) references hotel(hid), 
			foreign key (rtypeid) references roomtype(rtypeid) );


//Demo insert

8. Feedback


create table feedback (reservationid number(10), hid number(10), comment varchar(200), rating number(1),
			foreign key (reservationid) references reservation(reservationid),foreign key (hid) references hotel(hid));

