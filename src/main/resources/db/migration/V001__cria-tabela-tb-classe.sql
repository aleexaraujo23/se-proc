create table tb_classe (
	id bigint not null auto_increment,
    id_cnj varchar(20) not null,
    ds_classe varchar(100) not null,
    sigla varchar(45) not null,
    tipo varchar(45) not null,
    
    primary key (id)
);