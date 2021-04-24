-- 创建部门信息表
create table department_info
(
    departmentId   int primary key,
    departmentName varchar(20) not null unique
);

-- 创建员工信息表
create table employee_info
(
    employeeId   int primary key auto_increment,
    departmentId int,
    employeeName varchar(30) not null,
    age          int,
    workAge      int,
    entryTime    date default '2021-01-01',
    isInOffice   char(2)
);

-- 外部生成部门编号外键
alter table employee_info
    add constraint fk_employee_info_departmentId
        foreign key (departmentId) references department_info (departmentId);


-- 工资信息表
create table salary_info
(
    salaryId      int primary key auto_increment,
    employeeId    int,
    salary        float(10, 2),
    paySalaryTime date,
    isPay         char(2) default 1
);


-- 外部生成员工编号外键
alter table salary_info
    add constraint fk_salary_info_employee_info
        foreign key (employeeId) references employee_info (employeeId);


-- 1.添加信息
insert into department_info
values (1, '开发');
insert into department_info
values (2, 'UI');
insert into department_info
values (3, '测试');

insert into employee_info
values (100, 1, 'tom', 25, 3, null, 0);
insert into employee_info
values (101, 1, 'lucy', 22, 4, null, 0);
insert into employee_info
values (104, 1, 'lisle', 22, 4, null, 1);
insert into employee_info
values (102, 2, 'lily', 23, 2, null, 0);
insert into employee_info
values (103, 3, 'cat', 28, 1, 2021 - 4 - 15, 0);

insert into salary_info
values (10, 100, 100001, '2021-4-15', 0);
insert into salary_info
values (11, 101, 100002, '2021-4-15', 0);
insert into salary_info
values (12, 102, 100003, '2021-4-15', 1);
insert into salary_info
values (13, 103, 100004, '2021-4-15', 1);
insert into salary_info
values (14, 104, 100005, '2021-4-15', 0);

-- 2.删除
delete
from salary_info
where employeeId in (select employeeId from employee_info where isInOffice = 1);
delete
from employee_info
where isInOffice = 1;

-- 3.修改
update salary_info
set salary = (salary + salary_info.salary * 0.2);

-- 4 修改
update salary_info
set paySalaryTime = '2021-03-01';
update salary_info
set isPay = 0;

-- 5
update employee_info
set workAge = workAge + 1
where entryTime > '2021-03-01';

-- 6
-- 1)	查询所有的员工信息！
select *
from employee_info ei
         left join department_info di on ei.departmentId = di.departmentId
         left join salary_info si on ei.employeeId = si.employeeId;

-- 2)	查询员工编号、员工薪资、薪资发放时间以及薪资是否发放
select salaryId '员工编号', salary '员工薪资', paySalaryTime '发放时间', isPay '是否发放'
from salary_info;

-- 3)	查询工资大于5000元的工资信息。
select *
from employee_info ei
         left join department_info di on ei.departmentId = di.departmentId
         left join salary_info si on ei.employeeId = si.employeeId
where si.salary > 5000;

-- 4)	查询‘2021-03-01’之前入职的员工信息。
select *
from employee_info ei
         left join department_info di on ei.departmentId = di.departmentId
         left join salary_info si on ei.employeeId = si.employeeId
where ei.entryTime > '2021-03-01';

-- 5)	查询部门编号为：101，并且在职的员工信息。
select *
from employee_info ei
         left join department_info di on ei.departmentId = di.departmentId
         left join salary_info si on ei.employeeId = si.employeeId
where ei.isInOffice = 0
  and di.departmentId = 1;

-- 6)	查询员工姓名中以“张”字开头的员工信息。
select *
from employee_info
where employeeName like '张%';

-- 7)	查询年龄大于25岁，并且工龄大于3年的员工姓名！
select *
from employee_info
where age > 25
  and workAge > 3;

-- 8)	统计每个部门的人数。
select departmentId, count(departmentId)
from employee_info
group by departmentId;

-- 9)	根据工龄将员工信息进行排序。按照降序。
select *
from employee_info
order by workAge desc;

-- 10)	按照入职时间进行降序，然后查询第3条到第5条的记录！ 坑?
select *
from employee_info
order by entryTime desc
limit 2, 3;

-- 11)	查询每个部门中，工龄最高的员工信息！
select ei.departmentId, max(salary) maxSalary, ei.*
from salary_info si
         right join employee_info ei on ei.employeeId = si.employeeId
group by ei.departmentId;

-- 12)	统计所有员工的平均工资！
select avg(salary)
from salary_info;

-- 连表查询
# 1)	查询所有的员工姓名、员工工龄、薪资、薪资发放时间！
select ei.employeeName  '员工姓名',
       ei.age           '员工工龄',
       si.salary        '薪资',
       si.paySalaryTime '薪资发放时间'
from employee_info ei
         left join salary_info si on ei.employeeId = si.employeeId;

# 2)	查询所有的员工姓名、所属部门、工龄、薪资、薪资发放时间。
select ei.employeeName   '员工姓名',
       di.departmentName '所属部门',
       ei.workAge        '工龄',
       si.salary         '薪资',
       si.paySalaryTime  '薪资发放时间 '
from employee_info ei
         left join department_info di on ei.departmentId = di.departmentId
         left join salary_info si on ei.employeeId = si.employeeId;

# 3)	查询所有薪资大于5000元的员工姓名和所属部门。
select ei.employeeName   '员工姓名',
       di.departmentName '所属部门'
from employee_info ei
         left join department_info di on ei.departmentId = di.departmentId
         left join salary_info si on ei.employeeId = si.employeeId
where si.salary > 50000;

# 4)	查询还没有招聘任何员工的部门信息。
select *
from department_info
where departmentId not in (select distinct employee_info.departmentId from employee_info);

select department_info.*
from department_info
         left join employee_info ei on department_info.departmentId = ei.departmentId
where ei.employeeId is null;


# 5)	查询工资最高的员工信息。
select *
from department_info,
     salary_info,
     employee_info
where salary_info.employeeId = employee_info.employeeId
  and department_info.departmentId = employee_info.departmentId
  and salary_info.salary = (select max(salary) from salary_info);

-- 子查询作为查询结果
select *, (select departmentName from department_info di where di.departmentId = ei.departmentId) '部门'
from employee_info ei;
-- 子查询作为 查询的条件
        # 5)	查询工资最高的员工信息。

-- 子查询作为临时表
 
-- 分页查询 limit
select *
from employee_info
         join salary_info
limit 0,10;

select *
from employee_info
         join salary_info
limit 10,10;
select *
from employee_info
         join salary_info
limit 20,10;

select now();


