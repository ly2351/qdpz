-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯', '1', '1', '/system/journalism', 'C', '0', 'system:journalism:view', '#', 'admin', sysdate(), '', null, '文章资讯菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯查询', @parentId, '1',  '#',  'F', '0', 'system:journalism:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯新增', @parentId, '2',  '#',  'F', '0', 'system:journalism:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯修改', @parentId, '3',  '#',  'F', '0', 'system:journalism:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯删除', @parentId, '4',  '#',  'F', '0', 'system:journalism:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯导出', @parentId, '5',  '#',  'F', '0', 'system:journalism:export',       '#', 'admin', sysdate(), '', null, '');
