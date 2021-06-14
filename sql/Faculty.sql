create table faculty_data(faculty_name varchar(30) not null,faculty_class varchar(10) not null,faculty_email_id varchar(30) not null primary key,faculty_password varchar(15) not null,faculty_mobile_number bigint not null,CONSTRAINT UC_faculty_data UNIQUE (faculty_password));


insert into faculty_data values('M.LAKSHMI','X','laksram@gmail.com','Rlakshmi@123','8070605040');