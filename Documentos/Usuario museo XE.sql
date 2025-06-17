

create tablespace MUSEO_MANAGER datafile '/opt/oracle/oradata/XE/MUSEO_MANAGER.dbf' size 100M;
alter session set "_ORACLE_SCRIPT" = true;
create user USER_MUSEO_MANAGER identified by "database852+" default tablespace MUSEO_MANAGER;
grant dba to USER_MUSEO_MANAGER;
