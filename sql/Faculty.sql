create table faculty_data(faculty_name varchar(30) not null,faculty_password varchar(15) not null,faculty_class varchar(10) not null,faculty_mobile_number bigint not null,faculty_email_id varchar(30) not null primary key,CONSTRAINT UC_faculty_data UNIQUE (faculty_password));


insert into faculty_data values('M.LAKSHMI','Rlakshmi@123','X','8070605040','laksram@gmail.com');