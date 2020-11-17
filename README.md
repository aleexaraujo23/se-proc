# API SPRING REST SE-PROC - V.1

### PROJETO

Esta é a Primeira versão -- V.1 -- API SE-PROC que é ultizada para o cadastro de proecessos e sua distribuicao para a analise de um juiz cadastrado no sistema
que estaja com menor numero de processos... Uma nova versão com melhorias será lançada em breve!!! {Apesar do projeto ser iniciado há 2 dias, está faltando 
apenas a funcionalide de  cadastrar as partes juntamente com o processos, e alguns testes} !!

---

## 📋 Índice

- [Sobre](#-Sobre-o-Projeto)
- [Tecnologias de Desenvolvimento](#-Tecnologias-de-Desenvolvimento)
- [Como Executar O Projeto](#-Como-Executar-O-Projeto)
- [Licença](#-Licença)
- [Status](#-Status)

---

## 📖 Sobre o Projeto

A proposta do projeto é uma aplicação possibilitar o cadastro de processos, partes e o sistema distribuir esse processo ao juiz que tenha o menor numero de processos em sua responsabilidade. Como tambem gerar automaticamente o codigo do processo de acordocom a regra definida!
 
 - Listar {Partes, Processos, Juiz}
 - Adicionar {Partes, Processos, Juiz}
 - Busca {Partes, Processos, Juiz} -> {@Nome, @ID, @NumeroProcesso}
 - API de busca de CEP para verificacao de endereco da parte.
 - API Documentada {SWAGGER}
 
 - * Método {schedulleTask} de distribuicao os processos está localizado em `/src/main/java/com/tjmt/procs/domain/scheduleTask/VerificadorDeProcessos.java`.
 - * Método gerar o numero no processo está disponivel em `src/main/java/com/tjmt/procs/domain/validacep/Util.java`.
	

--- 

## 🚀 Tecnologias de Desenvolvimento

O projeto está desenvolvido utilizando as seguintes tecnologias:

- SPRING
- HIBERNATE
- JAVA
- MYSQL 
- SWAGGER
- FLYWAY


---


## ⌨ Como Executar O Projeto


1 - Tenha instalado o MYSQL em sua maquina (Posteriormente será implementado em Banco em Memória);

2 - Abra o projeto em uma IDE, altere as vaviareis USER e SENHA do do arquivo `application.properties` localizado em `/se-eproc/src/main/resources/` para seu usuário e senha do MYSQL, bem como o nome do seu banco de dados no lugar da variavel " NOME DO SEU BANCO DE DADOS " removendo as aspas.

2 - Execute o programa e ira realizar automaticamente a criacao das tabelas {FLYWAY} e atualizacao do banco de dados de classes de processos;

3 - Logo apos é so abrir o endereco  `http://localhost:8080/swagger-ui.html#/` em seu navegador que verá todos os metodos disponiveis na API Documentados pelo SWAGGER;



---


## 📚 Licença
<p align="justify">
Este projeto está licenciado sob o <a href="https://github.com/aleexaraujo23/nextlevelweek2">MIT<a/> License
</p>
  
---


## :hourglass_flowing_sand: Status

<h4 align="center"> 
	🚧  SE-PROC 💻   Em construção...  🚧
</h4>

---


## ✋ Sobre Mim

<a href="https://github.com/aleexaraujo23/">
  <img src="https://avatars3.githubusercontent.com/u/12380561?s=460&u=f58815e96f327f16ddfa0ae752eb602c52448936&v=4" width= "50px;" height= "50px;" alt="Avatar"/>
  <br />
 <sub>
  <b>
    Alex de Araújo Souza
  </b>
</sub>
</a> 
<a href="<a href="https:https://github.com/aleexaraujo23/" title="proffy">🚀 📚 💻 </a>
<br />

👋 [Fale comigo!] (https://www.linkedin.com/in/alex-araujo-souza/) 
