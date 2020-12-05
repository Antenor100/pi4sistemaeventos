-- CRIACAO BANCO
CREATE DATABASE EVENTDB;

CREATE TABLE USUARIO(
	ID int PRIMARY KEY AUTO_INCREMENT,
	NOME varchar(50),
	SOBRENOME varchar(60),
	EMAIL varchar(100),
	SENHA varchar(100),
	TELEFONE varchar(60),
	DATANASCIMENTO date,
	CPFCNPJ varchar(14)
);

CREATE TABLE CERTIFICADO(
	ID int PRIMARY KEY AUTO_INCREMENT,
	LINK varchar(50),
	ID_EVENTO int,
	ID_USUARIO int,
	FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO (ID),
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID)
);

CREATE TABLE INGRESSO(
	ID int PRIMARY KEY AUTO_INCREMENT,
	VALOR numeric(6,2),
	DATAHORAPAGAMENTO datetime,
	FORMAPAGAMENTO char(2),
	VALORPAGAMENTO numeric(6,2),
	DATAHORAAQUISICAO datetime,
	ID_USUARIO int,
	ID_EVENTO int,
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID),
	FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO (ID)
); 

CREATE TABLE EVENTO(
	ID int PRIMARY KEY AUTO_INCREMENT,
	TITULO varchar(60),
	IMAGEM varchar(100),
	DATAHORAINICIO datetime,
	DATAHORATERMINO datetime,
	DESCRICAO varchar(300),
	QTDMAXIMAINGRESSO int,
	ID_USUARIO int,
	ID_CATEGORIA int,
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID),
	FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA (ID)
);

CREATE TABLE EVENTOONLINE(
	ID int PRIMARY KEY AUTO_INCREMENT,
	LINK varchar(100),
	PLATAFORMA varchar(60),
	ID_EVENTO int,
	FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO (ID)
);

CREATE TABLE CATEGORIA(
	ID int PRIMARY KEY AUTO_INCREMENT,
	NOME varchar(100),
	DESCRICAO varchar(300)
);

CREATE TABLE ENDERECO(
	ID int PRIMARY KEY AUTO_INCREMENT,
	CEP char(9),
	RUA varchar(60),
	NUMERO int,
	BAIRRO varchar(60),
	COMPLEMENTO varchar(60),
	CIDADE varchar(60),
	ESTADO char(2),
	ID_EVENTO int,
	FOREIGN KEY (ID_EVENTO) REFERENCES EVENTO (ID)
);

-- CARGAS
INSERT INTO usuario(NOME, SOBRENOME, EMAIL, SENHA, TELEFONE, DATANASCIMENTO, CPFCNPJ) VALUES
('caio', 'silva', 'caiosilva@gmail.com', '123456', '34995625487', '1998-02-15', '71738149013'), 
('amanda', 'teixeira', 'amandateixeira@gmail.com', '123456', '34995647854', '1960-05-27', '17858992000195'),
('patricia', 'tostes', 'patriciatostes@gmail.com', '123456', '34983599945', '1997-06-13', '40113990006'),
('lucas', 'pereira', 'lucaspereira@gmail.com', '123456', '34984568794', '1985-03-21', '90254619053'),
('ricardo', 'cavalcante', 'ricardocavalcante@gmail.com', '123456', '34998652247', '1977-11-03', '34249629000191');

INSERT INTO categoria(NOME, DESCRICAO) VALUES 
('congresso/semin�rio', 'Encontros para educa��o ex: gdg'),
('curso/workshop', 'reuni�es para aprendizado'),
('esportivo', 'eventos relacionados a esportes'),
('feira/exposi��o', 'reuni�es sobre feiras ou exposi��es'),
('show/musica/festa', 'festivos com musica e apresenta��es');

INSERT INTO evento(TITULO , IMAGEM, DATAHORAINICIO, DATAHORATERMINO, DESCRICAO, QTDMAXIMAINGRESSO, ID_USUARIO, ID_CATEGORIA) VALUES
('Semin�rio GDG', 'imagens/gdg.png', '2020-10-05 11:30:00', '2020-10-06 17:00:00', 'Evento sobre tecnologia que voce precisa ver!', 400, 3, 1),
('Curso sobre python', 'imagens/python.png', '2020-11-27 14:00:00', '2020-11-27 18:00:00', 'Curso de python para iniciantes', 50, 3, 2),
('Curso sobre java', 'imagens/java.png', '2020-11-27 14:00:00', '2020-11-27 19:00:00', 'Curso de java para iniciantes', 50, 6, 2),
('Jogo de futebol para 8 times', 'imagens/futebol.png', '2020-12-01 14:30:00', '2020-12-01 18:00:00', 'Jogo de futebol em quadra society com 8 times e premio para o campeao', 40, 5, 3),
('Udi reveillon 2021', 'imagens/udireve.png', '2020-12-31 22:00:00', '2021-01-01 08:30:00', 'Evento para reuni�o e fogos para o reveillon de 2021!', 10000, 6, 5);

INSERT INTO ingresso(VALOR, DATAHORAPAGAMENTO, FORMAPAGAMENTO, VALORPAGAMENTO, DATAHORAAQUISICAO, ID_USUARIO, ID_EVENTO) VALUES
(0, '2020-10-06 17:00:00', 'CC', 0, '2020-10-06 17:00:00', 2, 6),
(30, '2020-11-25 18:00:00', 'BB', 30, '2020-11-25 18:00:00', 3, 7),
(30, '2020-11-24 18:00:00', 'CC', 15, '2020-11-24 18:00:00', 4, 7),
(500, '2020-10-18 18:03:00', 'CC', 500, '2020-10-18 18:03:00', 6, 10),
(8, '2020-10-18 17:03:00', 'BB', 8, '2020-10-18 17:03:00', 2, 9);

INSERT INTO eventoonline(LINK, PLATAFORMA, ID_EVENTO) VALUES 
('https://www.cursopythononline.com.br', 'Zoom', 7),
('https://www.cursojavaonline.com.br', 'Google Meet', 8);

INSERT INTO endereco (BAIRRO, RUA, NUMERO, CEP, CIDADE, COMPLEMENTO, ESTADO, ID_EVENTO) VALUES
('Santa M�nica', 'Av. Jos� Roberto Migliorini', 0, '38408251', 'Uberl�ndia', 'Estadio parque sabi�', 'MG', 9),
('Altamira, Uberl�ndia', 'R. Blanche Galassi', 150, '38411104', 'Uberl�ndia', 'Predio na esquina branco', 'MG', 6),
('Shopping Park', 'Av. Lidormira Borges do Nascimento', 2005, '38411411', 'Uberl�ndia', 'predio bonito top grama na porta', 'MG', 10);

INSERT INTO certificado (ID_EVENTO, ID_USUARIO, LINK) VALUES (6, 2, 'certificados/caio.pdf');