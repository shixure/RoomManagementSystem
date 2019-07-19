insert into guset(gname,gphone) values('王涛','17855512033');

insert into book(gid,rid,btime) values('1000001','101',to_date(sysdate,'yyyy-mm-dd'));
insert into book(gid,rid,btime) values((select gid from guset where gname='孙小勤'),'102',to_date(sysdate,'yyyy-mm-dd'));

--查询入住情况（简）
select a.RID,GNAME from ROOM a
join BOOK B on B.RID = a.RID
join GUSET c on c.GID = B.GID
where sid=1;

select a.rid,gname,gphone,bednum,price,pname from room a 
join book b on b.rid = a.rid 
join guset c on c.gid = b.gid 
join rtype d on d.tid=a.tid 
join principal e on e.pid=a.pid;

select * from room where rid=101 and sid=0;
--查询入住情况
select a.rid,gname,gphone,bednum,price,pname from room a 
join book b on b.rid = a.rid 
join guset c on c.gid = b.gid 
join rtype d on d.tid=a.tid 
join principal e on e.pid=a.pid 
where sid=1;

select rid,tname,price,pname,sname from room a 
join rtype b on b.tid = a.tid 
join principal c on c.pid=a.pid 
join rstatus d on d.sid=a.sid order by rid;
update book set utime=to_date(sysdate,'yyyy-mm-dd hh24:mi:ss') where rid=104 and gid=(select gid from guset where gname='孙小勤') and utime is null;
select* from guset;
select* from room;
select * from book;
delete from book;
set serveroutput on;
execute pro_checkout('孙小勤',103);
execute pro_reserve('孙小勤',104);
execute pro_reserve('崔大军',101);
execute pro_change('孙小勤',102,103);