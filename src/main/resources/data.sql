--TRUNCATE ROLE, TASK, MESSAGE, ANNOUNCEMENT, ATTENDANCE, ATTENDANCE, EMPLOYEE, EMPLOYEE_ROLES CASCADE;

/*---------------------------------------------USER ROLES INSERT----------------------------------------------------*/
INSERT INTO ROLE VALUES (1,'ADMIN'), (2,'USER');

/*----------------------- TASKS INSERT ---------------------------*/
INSERT INTO TASK(id, taskname, description, priority, percentage, status)
            VALUES (1, 'Finish Project of Web Design', 'This project is an important port', 'HIGH', 20, 'READY'),
                   (2, 'Shipment task', 'The shipment process should be finished', 'NORMAL', 30, 'DONE'),
                   (3, 'New Development Phase', 'Creating new develpoment phase is important', 'LOW', 90, 'NOT_READY');

/*----------------------- POPULATE MESSAGES ----------------------*/
INSERT INTO MESSAGE(id, message, created)
VALUES (1, 'Hey Ahmad, this is Karim', '2020-05-01'),
       (2, 'I want to inform you that this is just a simple reminder', '2020-05-01');

/*----------------------- POPULATE ANNOUNCEMENT ----------------------*/
INSERT INTO ANNOUNCEMENT(id, text, created)
VALUES (1, 'This is an important announcement in regard to our new rule in company', '2020-06-01'),
       (2, 'Announcement about renewal of information', '2020-08-01');

/*----------------------- POPULATE ATTENDANCE ----------------------*/
INSERT INTO ATTENDANCE(id, present, date)
VALUES (1, 'false', '2020-06-01'),
       (2, 'true', '2020-08-01');

/*---------------------- EMPLOYEE INSERT ---------------------------------*/
INSERT INTO EMPLOYEE(id, firstName, lastName, username, password, salary, title)
	VALUES (1, 'Adam', 'Smith', 'username1', 'password1', 3000 , 'DEVELOPER'),
	       (2, 'Ahmad', 'Nadimi', 'username2', 'password2', 4000 , 'HR'),
	       (3, 'Jamshid', 'Nazari', 'username3', 'password3', 4000 , 'MANAGER');

INSERT INTO EMPLOYEE_ROLES VALUES (1, 1);
INSERT INTO EMPLOYEE_ROLES VALUES (1, 2);