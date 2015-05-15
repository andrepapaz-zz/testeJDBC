CREATE DATABASE `livraria`;

CREATE TABLE `Editora` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Livro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `preco` double NOT NULL,
  `editora_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_editora` (`editora_id`),
  CONSTRAINT `fk_editora` FOREIGN KEY (`editora_id`) REFERENCES `Editora` (`id`)
);
