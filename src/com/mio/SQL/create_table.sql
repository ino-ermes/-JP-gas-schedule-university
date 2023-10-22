CREATE DATABASE IF NOT EXISTS university;

USE university;

CREATE TABLE IF NOT EXISTS user
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(45) UNIQUE NOT NULL,
    token CHAR(50) NOT NULL,
    role INT NOT NULL
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS department
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(45) UNIQUE NOT NULL
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS teacher
(
	id INT PRIMARY KEY,
    name NVARCHAR(45) NOT NULL,
    phonenumber VARCHAR(45) NOT NULL,
    is_male BIT NOT NULL,
    birthday DATETIME NOT NULL,
	image_path VARCHAR(255) NOT NULL,
    department_id INT NOT NULL,
    busy CHAR(60) DEFAULT '000000000000000000000000000000000000000000000000000000000000',
    FOREIGN KEY (id) REFERENCES user(id),
    FOREIGN KEY (department_id) REFERENCES department(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS admin
(
	id INT PRIMARY KEY,
    name NVARCHAR(45) NOT NULL,
    phonenumber VARCHAR(45) NOT NULL,
    is_male BIT NOT NULL,
    birthday DATETIME NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES user(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS subject
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(45) NOT NULL,
    department_id INT NOT NULL,
    require_lab BIT NOT NULL,
    credit INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS edu_program
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(45) NOT NULL,
    department_id INT NOT NULL,
    semester_count INT NOT NULL,
    semester_current INT NOT NULL DEFAULT 0,
    FOREIGN KEY (department_id) REFERENCES department(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS edu_program_detail
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    edu_program_id INT NOT NULL,
    subject_id INT NOT NULL,
    semester INT NOT NULL,
    FOREIGN KEY (edu_program_id) REFERENCES edu_program(id),	
    FOREIGN KEY (subject_id) REFERENCES subject(id),
    UNIQUE (edu_program_id, subject_id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS student_group
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(45) NOT NULL,
	department_id INT NOT NULL,
    edu_program_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (edu_program_id) REFERENCES edu_program(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS student
(
	id INT PRIMARY KEY,
    name NVARCHAR(45) NOT NULL,
    phonenumber VARCHAR(45) NOT NULL,
    is_male BIT NOT NULL,
    birthday DATETIME NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    student_group_id INT NOT NULL,
    FOREIGN KEY (id) REFERENCES user(id),
    FOREIGN KEY (student_group_id) REFERENCES student_group(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS section
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    year YEAR NOT NULL,
    decription NVARCHAR(45) NOT NULL
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS cur_section
(
    onlyOneRow char(1) not null DEFAULT 'X',
    section_id INT,
    section_status INT,
    constraint PK_cur_section_PK PRIMARY KEY (onlyOneRow),
    constraint CK_cur_section_Locked CHECK (onlyOneRow='X'),
    constraint FK_section_FK FOREIGN KEY (section_id) REFERENCES section(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS room
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name NVARCHAR(45) NOT NULL UNIQUE,
    size INT NOT NULL,
    is_lab BIT NOT NULL,
    busy CHAR(60) DEFAULT '000000000000000000000000000000000000000000000000000000000000'
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS class
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    subject_id INT NOT NULL,
    teacher_id INT NOT NULL,
    section_id INT NOT NULL,
    duration INT NOT NULL,
    size INT NOT NULL,
    require_lab BIT NOT NULL,
    room_id INT,
	time_slot INT DEFAULT -1,
    week_start INT DEFAULT -1,
    week_end INT DEFAULT -1,
    busy CHAR(60) DEFAULT '000000000000000000000000000000000000000000000000000000000000',
    FOREIGN KEY (subject_id) REFERENCES subject(id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id),
    FOREIGN KEY (section_id) REFERENCES section(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
) ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS class_group
(
    class_id INT NOT NULL,
    student_group_id INT NOT NULL,
    PRIMARY KEY(class_id, student_group_id),
    FOREIGN KEY (class_id) REFERENCES class(id),
    FOREIGN KEY (student_group_id) REFERENCES student_group(id)
) ENGINE=INNODB;
insert into section(year, decription) values(2023, '学期１');
insert into cur_section(section_id, section_status) values(1, 1);
insert into user(username, token, role) values('admin', '$31$16$IYiNt0KGDIP_VK3DCQLWsKYDecLAQGYJ0Vbq7TADak4', 0);
insert into admin(id, name, phonenumber, is_male, birthday, image_path) values(1, 'Admin', '0000000000', 0, '1971/01/01', '');