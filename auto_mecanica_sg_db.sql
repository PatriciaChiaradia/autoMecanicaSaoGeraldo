CREATE DATABASE auto_mecanica_sg_db;

USE auto_mecanica_sg_db;

CREATE TABLE `cliente` (
  `id` int NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `modelo` varchar(255) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `placa` varchar(255) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `caixa` (
  `id_caixa` int NOT NULL,
  `data` date NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `saldo_total` double DEFAULT NULL,
  `tipo_lancamento` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id_caixa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `servico` (
  `id` int NOT NULL,
  `realizada` bit(1) DEFAULT NULL,
  `data` date NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor` double NOT NULL,
  `cliente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmyf32dr019utxoiq56tsthokp` (`cliente_id`),
  CONSTRAINT `FKmyf32dr019utxoiq56tsthokp` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM auto_mecanica_sg_db.cliente;
SELECT * FROM auto_mecanica_sg_db.servico;
SELECT * FROM auto_mecanica_sg_db.caixa;
