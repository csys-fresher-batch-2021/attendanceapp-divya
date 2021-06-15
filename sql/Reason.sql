create table reason(student_roll_number varchar(30) not null,attendance_date date,attendance_type varchar(10)not null,faculty_email_id varchar(30)not null,reason varchar(70)not null,CONSTRAINT FK_roll_number FOREIGN KEY (student_roll_number) REFERENCES student(student_roll_number) on delete cascade, CONSTRAINT UC_reason UNIQUE (student_roll_number,attendance_date));

