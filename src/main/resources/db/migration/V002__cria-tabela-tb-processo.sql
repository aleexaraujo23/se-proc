create table tb_processo (
	id bigint not null auto_increment,
    nr_processo varchar(45) not null,
    data_criacao date not null,
    data_distribuicao date,
    id_classe bigint not null,
    
    primary key (id)
);

alter table tb_processo add constraint fk_processo_classe
foreign key (id_classe) references tb_classe (id);