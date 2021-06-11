create table attendance(attendance_date date,student_roll_number varchar(30) not null,attendance varchar(10)not null,CONSTRAINT FK_roll_number FOREIGN KEY (student_roll_number) REFERENCES student(student_roll_number) on delete cascade, CONSTRAINT U_attendance UNIQUE (student_roll_number,attendance_date));