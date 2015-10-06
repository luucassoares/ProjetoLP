-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 06-Out-2015 às 13:56
-- Versão do servidor: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `SteamyDB`
--
CREATE DATABASE IF NOT EXISTS `SteamyDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `SteamyDB`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Grupos`
--

CREATE TABLE IF NOT EXISTS `Grupos` (
  `grupo_id` int(11) NOT NULL,
  `grupo_nome` varchar(30) NOT NULL,
  `grupo_admin` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Grupos`
--

INSERT INTO `Grupos` (`grupo_id`, `grupo_nome`, `grupo_admin`) VALUES
(1, 'GuardiansOfGalaxy', 11);

-- --------------------------------------------------------

--
-- Estrutura da tabela `grupo_servidor`
--

CREATE TABLE IF NOT EXISTS `grupo_servidor` (
  `grupo_id` int(11) NOT NULL,
  `servidor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogo`
--

CREATE TABLE IF NOT EXISTS `jogo` (
  `jogo_id` int(11) NOT NULL,
  `jogo_nome` varchar(100) NOT NULL,
  `jogo_appid` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `jogo`
--

INSERT INTO `jogo` (`jogo_id`, `jogo_nome`, `jogo_appid`) VALUES
(1, 'Angry Birds', 1653),
(2, 'Bioshock', 7264),
(3, 'Destiny', 9501);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Servidor`
--

CREATE TABLE IF NOT EXISTS `Servidor` (
  `servidor_id` int(11) NOT NULL,
  `servidor_nome` varchar(30) NOT NULL,
  `servidor_jogo` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Servidor`
--

INSERT INTO `Servidor` (`servidor_id`, `servidor_nome`, `servidor_jogo`) VALUES
(1, 'PassaroNervoso', 1),
(2, 'Galaxiando', 3),
(3, 'TomaEsseXoq', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_grupo`
--

CREATE TABLE IF NOT EXISTS `user_grupo` (
  `usuario_id` int(11) NOT NULL DEFAULT '0',
  `grupo_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario_id` int(11) NOT NULL,
  `usuario_nome` varchar(25) NOT NULL,
  `usuario_senha` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `usuario_nome`, `usuario_senha`) VALUES
(2, 'BomNome', 'Teste 2'),
(9, 'ïsnsknskd', '123'),
(10, 'ïsnsknskd', 'Teste 2'),
(11, 'bobe', '1234'),
(12, 'admin', 'admin'),
(13, 'pedro', 'cacique');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Grupos`
--
ALTER TABLE `Grupos`
  ADD PRIMARY KEY (`grupo_id`),
  ADD KEY `grupo_admin` (`grupo_admin`);

--
-- Indexes for table `grupo_servidor`
--
ALTER TABLE `grupo_servidor`
  ADD PRIMARY KEY (`grupo_id`,`servidor_id`),
  ADD KEY `servidor_id` (`servidor_id`);

--
-- Indexes for table `jogo`
--
ALTER TABLE `jogo`
  ADD PRIMARY KEY (`jogo_id`);

--
-- Indexes for table `Servidor`
--
ALTER TABLE `Servidor`
  ADD PRIMARY KEY (`servidor_id`),
  ADD KEY `servidor_jogo` (`servidor_jogo`);

--
-- Indexes for table `user_grupo`
--
ALTER TABLE `user_grupo`
  ADD PRIMARY KEY (`usuario_id`,`grupo_id`),
  ADD KEY `grupo_id` (`grupo_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Grupos`
--
ALTER TABLE `Grupos`
  MODIFY `grupo_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `jogo`
--
ALTER TABLE `jogo`
  MODIFY `jogo_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Servidor`
--
ALTER TABLE `Servidor`
  MODIFY `servidor_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `Grupos`
--
ALTER TABLE `Grupos`
  ADD CONSTRAINT `grupos_ibfk_1` FOREIGN KEY (`grupo_admin`) REFERENCES `usuario` (`usuario_id`);

--
-- Limitadores para a tabela `grupo_servidor`
--
ALTER TABLE `grupo_servidor`
  ADD CONSTRAINT `grupo_servidor_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `Grupos` (`grupo_id`),
  ADD CONSTRAINT `grupo_servidor_ibfk_2` FOREIGN KEY (`servidor_id`) REFERENCES `Servidor` (`servidor_id`);

--
-- Limitadores para a tabela `Servidor`
--
ALTER TABLE `Servidor`
  ADD CONSTRAINT `servidor_ibfk_1` FOREIGN KEY (`servidor_jogo`) REFERENCES `jogo` (`jogo_id`);

--
-- Limitadores para a tabela `user_grupo`
--
ALTER TABLE `user_grupo`
  ADD CONSTRAINT `user_grupo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`),
  ADD CONSTRAINT `user_grupo_ibfk_2` FOREIGN KEY (`grupo_id`) REFERENCES `grupos` (`grupo_id`);
