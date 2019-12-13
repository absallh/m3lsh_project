create database HotelDataBase

use HotelDataBase

create table Employee( 
	id int primary key ,
	employee_name varchar(50) ,
	nationality varchar(20),
	permition varchar(40),
	user_password varchar(10) not null,
	UserName varchar(30) not null unique
);

create table customer(
	customer_id int identity(1,1) primary key,
	Fname varchar(20) not null,
	Lname varchar (20),
	nationality varchar(20),
	age int,
	coming_date date,
	check_out_date date
);

create table Room(
	Room_number varchar(10) not null,
	price int not null,
	boolean_busy varchar(50) not null,
	primary key(Room_number)
);

create table bill(
	bill_id int identity(1,1) primary key,
	customerID int,
	foreign key (customerID) references customer(customer_id)
);

create table Servicee(
	service_names varchar(50) primary key,
	service_description varchar(1000),
	service_price int
);

create table Room_services (
	room_number varchar(10),
	services_name varchar(50),
	foreign key (room_number) references Room(Room_number),
	foreign key (services_name) references Servicee(service_names)
);

create table bill_service (
	service_names varchar(50) not null,
	bill_id int,
	count_of_service int default 1,
	foreign key (service_names) references Servicee(service_names),
	foreign key (bill_id) references bill(bill_id),
	primary key (bill_id, service_names)
);

create table bill_room (
	room_number varchar(10),
	bill_id int,
	foreign key (room_number) references Room(Room_number),
	foreign key (bill_id) references bill(bill_id),
	primary key (room_number, bill_id)
);

create table customer_service(
	customer_id int,
	service_names varchar(50) not null,
	use_time date,
	foreign key (customer_id) references customer(customer_id),
	foreign key (service_names) references Servicee(service_names)
);

create table customer_room(
	customer_id int not null,
	Room_number varchar(10) not null,
	foreign key (Room_number) references Room(Room_number)
);