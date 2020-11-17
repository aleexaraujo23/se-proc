create table tb_juiz (
	id bigint not null auto_increment,
    nome varchar(150),
    cpf varchar(11),
    data_nascimento date,
        
    primary key (id)
);