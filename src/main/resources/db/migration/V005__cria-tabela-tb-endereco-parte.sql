create table tb_endereco_parte (
	id bigint not null auto_increment,
    bairro varchar(100),
    cidade varchar(100),
    estado varchar(45),
    cep varchar(45),
    logradouro varchar(100),
    numero int,
    id_parte bigint not null,
    
    primary key (id)
);

alter table tb_endereco_parte add constraint fk_endereco_parte
foreign key (id_parte) references tb_parte (id);