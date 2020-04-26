use hungmotospringmvc;
insert into category(name) values("HONDA");
insert into category(name) values("PAGGIO");
insert into category(name) values("YAMAHA");
insert into category(name) values("SUZUKI");
insert into category(name) values("SYM");
insert into motocrycle(quantity,description,name,price,thumbnail,category_id) values(2,
"Xe 1 chủ sử dụng odo 3000km, hình thức chưa 1 vết xước, đẹp long lanh như mới rời head, nilon dán full xe, máy nguyên bản tuyệt đối, phụ kiện theo xe đầy đủ.",
"HONDA SH 150 ABS VIETNAM 2018 BIỂN ĐẸP",106000000,"84397529_610349896414597_7420520580480237568_n.jpg",1);
insert into motocrycle(quantity,description,name,price,thumbnail,category_id) values(2,
"Xe 1 chủ sử dụng odo 3000km, hình thức chưa 1 vết xước, đẹp long lanh như mới rời head, nilon dán full xe, máy nguyên bản tuyệt đối, phụ kiện theo xe đầy đủ.",
"HONDA SH 150 ABS VIETNAM 2018 BIỂN ĐẸP",106000000,"84397529_610349896414597_7420520580480237568_n.jpg",1);
insert into motocrycle(quantity,description,name,price,thumbnail,category_id) values(2,
"Xe 1 chủ sử dụng odo 3000km, hình thức chưa 1 vết xước, đẹp long lanh như mới rời head, nilon dán full xe, máy nguyên bản tuyệt đối, phụ kiện theo xe đầy đủ.",
"HONDA SH 150 ABS VIETNAM 2018 BIỂN ĐẸP",106000000,"84397529_610349896414597_7420520580480237568_n.jpg",1);




insert into roles(code,name) values('ADMIN','Quản trị');
insert into roles(code,name) values('USER','Người dùng');

insert into user(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Trần Ngoc Hùng',1);
insert into user(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyễn Văn A',1);
insert into user(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyễn Văn B',1);

INSERT INTO user_role(user_id,roles_id) VALUES (1,1);
INSERT INTO user_role(user_id,roles_id) VALUES (2,2);
INSERT INTO user_role(user_id,roles_id) VALUES (3,2);