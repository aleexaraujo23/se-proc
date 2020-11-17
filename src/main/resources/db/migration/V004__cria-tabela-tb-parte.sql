create table tb_parte (
	id bigint not null auto_increment,
    nome varchar(150) not null,
    data_nascimento date not null,
    cpf varchar(11) not null,
    tipo_parte varchar(45) not null,
    
    primary key (id)
);