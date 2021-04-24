-- 练习2
# 3.查询student表的所有记录
select * from student;
# 4.查询student表的第2条到4条记录
select * from student limit 1,3;
# 5.从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息
select id,stuName,department from student;
# 6.从student表中查询计算机系和英语系的学生的信息
select * from  student where department in ('计算机系','英语系');
# 7.从student表中查询年龄1985~1990年份的学生信息
select * from student where birth in ('1985','1990');
# 8.从student表中查询每个院系有多少人
select department ,count(department) '人数' from student group by department;
# 9.从score表中查询每个科目的最高分
select c_name,max(grade) from  score group by c_name;
# 10.查询李四的考试科目（c_name）和考试成绩（grade）
select se.c_name,se.grade from score se, student st where se.stu_id =st.id and st.stuName = '李四';
# 11.用连接的方式查询所有学生的信息和考试信息
select * from score se, student st where se.stu_id =st.id ;
# 12.计算每个学生的总成绩
select * ,(select sum(grade) from score where score.stu_id = student.id group by stu_id ) from student where id in (select stu_id from score group by stu_id);
# 13.计算每个考试科目的平均成绩
select c_name, avg(grade) from score group by score.c_name;
# 14.查询计算机成绩低于95的学生信息
select * from student where  id in (select stu_id from score where c_name = '计算机' and grade < 95);
# 15.将计算机考试成绩按从高到低进行排序
select grade from score  where c_name = '计算机' order by grade desc;
# 16.查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
select st.stuName,st.department,se.c_name,se.grade from score se inner join student st on se.stu_id =st.id  where st.stuName like '%张%'or st.stuName like'%王%';
# 17.查询都是北京的学生的姓名、年龄、院系和考试科目及成绩
select st.stuName, (year(now())-st.birth)'年龄', st.department, se.c_name, se.grade ,st.address
from score se  inner join student st on se.stu_id = st.id
where st.address like '%北京%';

-- 练习三
# 1. 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
select dt.*, count(ep.empno)
from dept dt
         left join emp ep on dt.deptno = ep.deptno
group by dt.deptno
having count(ep.empno) > 1;
# 2. 列出所有员工的姓名及其直接上级的姓名。
#  ep1 员工  (员工的mgr和上级的empno相等既可)
#  ep2 上级  曾阿牛是董事长没有上级
-- 1
select ename, (select ep2.ename from emp ep2 where ep2.empno = ep.mgr) from emp ep;
-- 2
select ep1.ename, ep2.ename from emp ep1,emp ep2 where ep1.mgr = ep2.empno;
# 3. 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
select ep1.empno, ep1.ename, dt.dname
from emp ep1,
     emp ep2,
     dept dt
where ep1.mgr = ep2.empno
  and dt.deptno = ep1.deptno
  and ep1.hiredate > ep2.hiredate;
# 4. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
select dt.dname, ep.*
from dept dt
         left join emp ep on dt.deptno = ep.deptno;
# 5. 列出最低薪金大于15000的各种工作及从事此工作的员工人数。 保洁8w 学什么java吖
select job, count(*)
from emp ep
where ep.sal > 15000
group by job;
# 6. 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
select ep.ename
from emp ep
where ep.deptno = (select distinct deptno from dept where dname like '销售部');
# 7. 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
select ep1.*,
       d.dname   '部门名称',
        (select ename from emp where empno = ep1.mgr)  '上级领导 ',
        (select grade from salgrade where ep1.sal > salgrade.LOwSAL and ep1.sal <= salgrade.HISAL) '工资等级'
from emp ep1 left join dept d on ep1.deptno = d.deptno
where sal > (select avg(sal) from emp);


# 8.列出与庞统从事相同工作的所有员工及部门名称。
select ep.*, dt.dname
from emp ep,
     dept dt
where ep.deptno = (select deptno from emp where ename = '庞统')
  and ep.deptno = dt.deptno;
# 9.列出薪金高于在部门30工作的所有员工的薪金　的员工姓名和薪金、部门名称。
select ep.ename, ep.sal, dt.dname
from emp ep,
     dept dt
where ep.sal > (select max(sal) from emp where deptno = 30)
  and ep.deptno = dt.deptno;
# 10.查出年份、利润、年度增长比。
select year, zz, concat(round(((select p2.zz from profit p2 where p2.year = p1.year + 1) - p1.zz) / zz * 100, 2),'%') '增长比' from profit p1;



