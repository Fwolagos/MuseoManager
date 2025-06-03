prompt PL/SQL Developer Export Tables for user USER_MUSEO_MANAGER@10.42.0.4:1521/FREE
prompt Created by ANTONY JOSUE on Sunday, June 1, 2025
set feedback off
set define off

prompt Dropping MM_MUSEOS...
drop table MM_MUSEOS cascade constraints;
prompt Dropping MM_SALAS...
drop table MM_SALAS cascade constraints;
prompt Dropping MM_AFICHE_DE_SALAS...
drop table MM_AFICHE_DE_SALAS cascade constraints;
prompt Dropping MM_COLECCIONES...
drop table MM_COLECCIONES cascade constraints;
prompt Dropping MM_ESPECIES...
drop table MM_ESPECIES cascade constraints;
prompt Dropping MM_PRECIO_DE_ENTRADAS...
drop table MM_PRECIO_DE_ENTRADAS cascade constraints;
prompt Dropping MM_TABLA_DE_VALORACIONES...
drop table MM_TABLA_DE_VALORACIONES cascade constraints;
prompt Dropping MM_TARJETA_Y_COMISIONES...
drop table MM_TARJETA_Y_COMISIONES cascade constraints;
prompt Dropping MM_TEMATICA...
drop table MM_TEMATICA cascade constraints;
prompt Dropping MM_VENTA_DE_ENTRADAS...
drop table MM_VENTA_DE_ENTRADAS cascade constraints;
prompt Dropping MM_VENTAS_Y_SALAS...
drop table MM_VENTAS_Y_SALAS cascade constraints;
prompt Creating MM_MUSEOS...
create table MM_MUSEOS
(
  id                 NUMBER generated always as identity,
  nombre_del_museo   VARCHAR2(85),
  tipo_de_museo      VARCHAR2(85),
  ubicacion          VARCHAR2(255),
  url_del_sitio_web  VARCHAR2(255),
  fecha_de_fundacion DATE
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255;
alter table MM_MUSEOS
  add constraint ID_MUSEO primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_MUSEOS
  add constraint TIPO_DE_MUSEO
  check (Tipo_De_Museo IN ('Arte','Historia'));

prompt Creating MM_SALAS...
create table MM_SALAS
(
  id             NUMBER generated always as identity,
  id_museo       NUMBER,
  nombre_de_sala VARCHAR2(50),
  descripcion    VARCHAR2(255),
  tipo_de_sala   VARCHAR2(50)
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_SALAS
  add constraint ID_SALAS_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_SALAS
  add constraint ID_MUSEO_FK foreign key (ID_MUSEO)
  references MM_MUSEOS (ID);
alter table MM_SALAS
  add constraint TIPO_DE_SALA
  check (Tipo_De_Sala IN ('Coleccion','Tematica'));

prompt Creating MM_AFICHE_DE_SALAS...
create table MM_AFICHE_DE_SALAS
(
  id                  NUMBER generated always as identity,
  id_sala             NUMBER not null,
  img1                VARCHAR2(255),
  img2                VARCHAR2(255),
  img3                VARCHAR2(255),
  valoracion_promedio NUMBER
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_AFICHE_DE_SALAS
  add constraint ID_AFICHES_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_AFICHE_DE_SALAS
  add constraint ID_AFICHES_SALA_FK foreign key (ID_SALA)
  references MM_SALAS (ID);

prompt Creating MM_COLECCIONES...
create table MM_COLECCIONES
(
  id                  NUMBER generated always as identity,
  id_sala             NUMBER,
  nombre_de_coleccion VARCHAR2(60),
  siglo               NUMBER,
  descripcion         VARCHAR2(255)
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_COLECCIONES
  add constraint ID_COLECCION_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_COLECCIONES
  add constraint ID_SALA_FK foreign key (ID_SALA)
  references MM_SALAS (ID);

prompt Creating MM_ESPECIES...
create table MM_ESPECIES
(
  id                 NUMBER generated always as identity,
  id_coleccion       NUMBER,
  nombre_cientifico  VARCHAR2(100),
  nombre_comun       VARCHAR2(100),
  fecha_de_extincion DATE,
  epoca              VARCHAR2(50),
  peso               NUMBER,
  tamaño             NUMBER,
  caracteristicas    VARCHAR2(255)
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_ESPECIES
  add constraint ID_ESPECIES_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_ESPECIES
  add constraint ID_COLECCION_FK foreign key (ID_COLECCION)
  references MM_COLECCIONES (ID);

prompt Creating MM_PRECIO_DE_ENTRADAS...
create table MM_PRECIO_DE_ENTRADAS
(
  id             NUMBER generated always as identity,
  id_museo       NUMBER not null,
  costo_lun_vier NUMBER,
  costo_sab_dom  NUMBER
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_PRECIO_DE_ENTRADAS
  add constraint ID_PRECIO_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_PRECIO_DE_ENTRADAS
  add constraint ID_PRECIO_MUSEO_FK foreign key (ID_MUSEO)
  references MM_MUSEOS (ID);

prompt Creating MM_TABLA_DE_VALORACIONES...
create table MM_TABLA_DE_VALORACIONES
(
  id            NUMBER generated always as identity,
  id_sala       NUMBER not null,
  calificacion  NUMBER,
  observaciones VARCHAR2(255)
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_TABLA_DE_VALORACIONES
  add constraint ID_VALORACIONES_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_TABLA_DE_VALORACIONES
  add constraint ID_VALORACIONES_SALA_FK foreign key (ID_SALA)
  references MM_SALAS (ID);

prompt Creating MM_TARJETA_Y_COMISIONES...
create table MM_TARJETA_Y_COMISIONES
(
  id              NUMBER generated always as identity,
  tipo_de_tarjeta VARCHAR2(50),
  comision        NUMBER,
  id_museo        NUMBER
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_TARJETA_Y_COMISIONES
  add constraint ID_TARJETAS_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_TARJETA_Y_COMISIONES
  add constraint ID_TARJETAS_MUSEO_FK foreign key (ID_MUSEO)
  references MM_MUSEOS (ID);
alter table MM_TARJETA_Y_COMISIONES
  add constraint TIPO_DE_TARJETAS
  check (Tipo_De_Tarjeta IN ('Visa','MasterCard'));

prompt Creating MM_TEMATICA...
create table MM_TEMATICA
(
  id                    NUMBER not null,
  id_sala               NUMBER,
  nombre_de_la_tematica VARCHAR2(50),
  caracteristicas       VARCHAR2(255),
  epoca                 VARCHAR2(50)
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_TEMATICA
  add constraint ID_TEMATICA_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_TEMATICA
  add constraint ID_SALAS_FK foreign key (ID_SALA)
  references MM_SALAS (ID);

prompt Creating MM_VENTA_DE_ENTRADAS...
create table MM_VENTA_DE_ENTRADAS
(
  id                   NUMBER generated always as identity,
  id_museo             NUMBER,
  fecha                DATE,
  nombre_del_visitante VARCHAR2(100),
  comision_cobrada     NUMBER,
  vigencia             VARCHAR2(50)
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_VENTA_DE_ENTRADAS
  add constraint ID_VENTA_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_VENTA_DE_ENTRADAS
  add constraint ID_MUSEOS_FK foreign key (ID_MUSEO)
  references MM_MUSEOS (ID);
alter table MM_VENTA_DE_ENTRADAS
  add constraint VIGENCIA
  check (Vigencia IN ('Vigente','Vencido'));

prompt Creating MM_VENTAS_Y_SALAS...
create table MM_VENTAS_Y_SALAS
(
  id       NUMBER generated always as identity,
  id_venta NUMBER not null,
  id_sala  NUMBER not null
)
tablespace MUSEO_MANAGER
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MM_VENTAS_Y_SALAS
  add constraint ID_VENTA_SALAS_PK primary key (ID)
  using index
  tablespace MUSEO_MANAGER
  pctfree 10
  initrans 2
  maxtrans 255;
alter table MM_VENTAS_Y_SALAS
  add constraint ID_SALAS_VENTAS_Y_SALAS_FK foreign key (ID_SALA)
  references MM_SALAS (ID);
alter table MM_VENTAS_Y_SALAS
  add constraint ID_VENTA_FK foreign key (ID_VENTA)
  references MM_VENTA_DE_ENTRADAS (ID);

prompt Disabling triggers for MM_MUSEOS...
alter table MM_MUSEOS disable all triggers;
prompt Disabling triggers for MM_SALAS...
alter table MM_SALAS disable all triggers;
prompt Disabling triggers for MM_AFICHE_DE_SALAS...
alter table MM_AFICHE_DE_SALAS disable all triggers;
prompt Disabling triggers for MM_COLECCIONES...
alter table MM_COLECCIONES disable all triggers;
prompt Disabling triggers for MM_ESPECIES...
alter table MM_ESPECIES disable all triggers;
prompt Disabling triggers for MM_PRECIO_DE_ENTRADAS...
alter table MM_PRECIO_DE_ENTRADAS disable all triggers;
prompt Disabling triggers for MM_TABLA_DE_VALORACIONES...
alter table MM_TABLA_DE_VALORACIONES disable all triggers;
prompt Disabling triggers for MM_TARJETA_Y_COMISIONES...
alter table MM_TARJETA_Y_COMISIONES disable all triggers;
prompt Disabling triggers for MM_TEMATICA...
alter table MM_TEMATICA disable all triggers;
prompt Disabling triggers for MM_VENTA_DE_ENTRADAS...
alter table MM_VENTA_DE_ENTRADAS disable all triggers;
prompt Disabling triggers for MM_VENTAS_Y_SALAS...
alter table MM_VENTAS_Y_SALAS disable all triggers;
prompt Disabling foreign key constraints for MM_SALAS...
alter table MM_SALAS disable constraint ID_MUSEO_FK;
prompt Disabling foreign key constraints for MM_AFICHE_DE_SALAS...
alter table MM_AFICHE_DE_SALAS disable constraint ID_AFICHES_SALA_FK;
prompt Disabling foreign key constraints for MM_COLECCIONES...
alter table MM_COLECCIONES disable constraint ID_SALA_FK;
prompt Disabling foreign key constraints for MM_ESPECIES...
alter table MM_ESPECIES disable constraint ID_COLECCION_FK;
prompt Disabling foreign key constraints for MM_PRECIO_DE_ENTRADAS...
alter table MM_PRECIO_DE_ENTRADAS disable constraint ID_PRECIO_MUSEO_FK;
prompt Disabling foreign key constraints for MM_TABLA_DE_VALORACIONES...
alter table MM_TABLA_DE_VALORACIONES disable constraint ID_VALORACIONES_SALA_FK;
prompt Disabling foreign key constraints for MM_TARJETA_Y_COMISIONES...
alter table MM_TARJETA_Y_COMISIONES disable constraint ID_TARJETAS_MUSEO_FK;
prompt Disabling foreign key constraints for MM_TEMATICA...
alter table MM_TEMATICA disable constraint ID_SALAS_FK;
prompt Disabling foreign key constraints for MM_VENTA_DE_ENTRADAS...
alter table MM_VENTA_DE_ENTRADAS disable constraint ID_MUSEOS_FK;
prompt Disabling foreign key constraints for MM_VENTAS_Y_SALAS...
alter table MM_VENTAS_Y_SALAS disable constraint ID_SALAS_VENTAS_Y_SALAS_FK;
alter table MM_VENTAS_Y_SALAS disable constraint ID_VENTA_FK;
prompt Loading MM_MUSEOS...
prompt Table is empty
prompt Loading MM_SALAS...
prompt Table is empty
prompt Loading MM_AFICHE_DE_SALAS...
prompt Table is empty
prompt Loading MM_COLECCIONES...
prompt Table is empty
prompt Loading MM_ESPECIES...
prompt Table is empty
prompt Loading MM_PRECIO_DE_ENTRADAS...
prompt Table is empty
prompt Loading MM_TABLA_DE_VALORACIONES...
prompt Table is empty
prompt Loading MM_TARJETA_Y_COMISIONES...
prompt Table is empty
prompt Loading MM_TEMATICA...
prompt Table is empty
prompt Loading MM_VENTA_DE_ENTRADAS...
prompt Table is empty
prompt Loading MM_VENTAS_Y_SALAS...
prompt Table is empty
prompt Enabling foreign key constraints for MM_SALAS...
alter table MM_SALAS enable constraint ID_MUSEO_FK;
prompt Enabling foreign key constraints for MM_AFICHE_DE_SALAS...
alter table MM_AFICHE_DE_SALAS enable constraint ID_AFICHES_SALA_FK;
prompt Enabling foreign key constraints for MM_COLECCIONES...
alter table MM_COLECCIONES enable constraint ID_SALA_FK;
prompt Enabling foreign key constraints for MM_ESPECIES...
alter table MM_ESPECIES enable constraint ID_COLECCION_FK;
prompt Enabling foreign key constraints for MM_PRECIO_DE_ENTRADAS...
alter table MM_PRECIO_DE_ENTRADAS enable constraint ID_PRECIO_MUSEO_FK;
prompt Enabling foreign key constraints for MM_TABLA_DE_VALORACIONES...
alter table MM_TABLA_DE_VALORACIONES enable constraint ID_VALORACIONES_SALA_FK;
prompt Enabling foreign key constraints for MM_TARJETA_Y_COMISIONES...
alter table MM_TARJETA_Y_COMISIONES enable constraint ID_TARJETAS_MUSEO_FK;
prompt Enabling foreign key constraints for MM_TEMATICA...
alter table MM_TEMATICA enable constraint ID_SALAS_FK;
prompt Enabling foreign key constraints for MM_VENTA_DE_ENTRADAS...
alter table MM_VENTA_DE_ENTRADAS enable constraint ID_MUSEOS_FK;
prompt Enabling foreign key constraints for MM_VENTAS_Y_SALAS...
alter table MM_VENTAS_Y_SALAS enable constraint ID_SALAS_VENTAS_Y_SALAS_FK;
alter table MM_VENTAS_Y_SALAS enable constraint ID_VENTA_FK;
prompt Enabling triggers for MM_MUSEOS...
alter table MM_MUSEOS enable all triggers;
prompt Enabling triggers for MM_SALAS...
alter table MM_SALAS enable all triggers;
prompt Enabling triggers for MM_AFICHE_DE_SALAS...
alter table MM_AFICHE_DE_SALAS enable all triggers;
prompt Enabling triggers for MM_COLECCIONES...
alter table MM_COLECCIONES enable all triggers;
prompt Enabling triggers for MM_ESPECIES...
alter table MM_ESPECIES enable all triggers;
prompt Enabling triggers for MM_PRECIO_DE_ENTRADAS...
alter table MM_PRECIO_DE_ENTRADAS enable all triggers;
prompt Enabling triggers for MM_TABLA_DE_VALORACIONES...
alter table MM_TABLA_DE_VALORACIONES enable all triggers;
prompt Enabling triggers for MM_TARJETA_Y_COMISIONES...
alter table MM_TARJETA_Y_COMISIONES enable all triggers;
prompt Enabling triggers for MM_TEMATICA...
alter table MM_TEMATICA enable all triggers;
prompt Enabling triggers for MM_VENTA_DE_ENTRADAS...
alter table MM_VENTA_DE_ENTRADAS enable all triggers;
prompt Enabling triggers for MM_VENTAS_Y_SALAS...
alter table MM_VENTAS_Y_SALAS enable all triggers;

set feedback on
set define on
prompt Done
