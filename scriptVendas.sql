set @@global.time_zone = '-4:00';
create database if not exists vendas;
use vendas;

CREATE TABLE `vendas`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `datanascimento` VARCHAR(10) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE INDEX `idnew_table_UNIQUE` (`idcliente` ASC) VISIBLE);
  
  CREATE TABLE `vendas`.`produto` (
  `idproduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idproduto`),
  UNIQUE INDEX `idproduto_UNIQUE` (`idproduto` ASC) VISIBLE);
  
  CREATE TABLE `vendas`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
  `idcliente` INT NOT NULL,
  `idproduto` INT NOT NULL,
  `valortotal` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idvenda`),
  UNIQUE INDEX `idvenda_UNIQUE` (`idvenda` ASC) VISIBLE);
  
  INSERT INTO `vendas`.`cliente`(`idcliente`,`nome`,`cpf`,`datanascimento`,`sexo`)VALUES
				(0,"Reginaldo Batista","82546975231","1958-02-18","H"),
                (0,"Ronaldo Santo","95463258756","1988-05-23","H"),
                (0,"Ana Carolina","84657852369","2003-04-15","M"),
                (0,"Fernanda Silva","98654568565","1983-02-15","M"),
                (0,"Helio Soares","48526469548","1995-01-02","H"),
                (0,"Juliana Silva","46529632587","1958-02-18","M");

INSERT INTO `vendas`.`produto`(`idproduto`,`nome`,`valor`)VALUES
(0,"Rexona 200ml",12.35);
	
        
select * from cliente;
select * from produto;


