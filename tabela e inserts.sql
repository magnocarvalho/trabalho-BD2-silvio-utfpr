-- DBTools Manager Professional (Enterprise Edition)
-- Database Dump for: dbestoque
-- Backup Generated in: 21/06/2016 20:39:10
-- Database Server Version: PostgreSQL 9.5.-31200

-- USEGO

--


--
-- Sequence: hibernate_sequence



--
CREATE TABLE "public"."entrada_produtos" 
(
	"id" integer NOT NULL , 
	"fk_fornecedor" integer, 
	"data" timestamp, 
	"fk_produto" integer, 
	"quantidde" integer, 
	"valor" money, 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: entrada_produtos
--

--
-- Table: estado
--
CREATE TABLE "public"."estado" 
(
	"id" integer NOT NULL , 
	"estad" varchar(40), 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: estado
--

-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(0, 'Acre (AC)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(1, 'Alagoas (AL)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(2, 'Amapá (AP)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(3, 'Amazonas (AM)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(4, 'Bahia (BA)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(5, 'Ceará (CE)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(6, 'Distrito Federal (DF)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(7, 'Espírito Santo (ES)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(8, 'Goiás (GO)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(9, 'Maranhão (MA)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(10, 'Mato Grosso (MT)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(11, 'Mato Grosso do Sul (MS)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(12, 'Minas Gerais (MG)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(13, 'Pará (PA)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(14, 'Paraíba (PB)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(15, 'Paraná (PR)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(16, 'Pernambuco (PE)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(17, 'Piauí (PI)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(18, 'Rio de Janeiro (RJ)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(19, 'Rio Grande do Norte (RN)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(20, 'Rio Grande do Sul (RS)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(21, 'Rondônia (RO)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(22, 'Roraima (RR)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(23, 'Santa Catarina (SC)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(24, 'Sergipe (SE)');
-- GO
INSERT INTO "public"."estado" ("id", "estad") VALUES(25, 'Tocantins (TO)');

-- GO

--
-- Table: familia
--
CREATE TABLE "public"."familia" 
(
	"id" integer NOT NULL , 
	"descricao" text, 
	"fk_setor" integer, 
	"quantidade" integer, 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: familia

-- GO
INSERT INTO "public"."familia" ("id", "descricao", "fk_setor", "quantidade") VALUES(0, 'carnes', 1, 5);
-- GO
INSERT INTO "public"."familia" ("id", "descricao", "fk_setor", "quantidade") VALUES(1, 'linguiça', 1, 6);
-- GO
INSERT INTO "public"."familia" ("id", "descricao", "fk_setor", "quantidade") VALUES(2, 'paes', 2, 6);
-- GO
INSERT INTO "public"."familia" ("id", "descricao", "fk_setor", "quantidade") VALUES(3, 'bolos', 2, 1);
-- GO
INSERT INTO "public"."familia" ("id", "descricao", "fk_setor", "quantidade") VALUES(4, 'sabão em pó', 3, 2);
-- GO
INSERT INTO "public"."familia" ("id", "descricao", "fk_setor", "quantidade") VALUES(5, 'frutas', 4, 2);
-- GO


--
-- Table: fornecedor
--
CREATE TABLE "public"."fornecedor" 
(
	"id" serial, 
	"cnpj" varchar(19), 
	"razao_social" varchar(120), 
	"logradouro" varchar(123), 
	"numero" varchar(10), 
	"bairro" varchar(100), 
	"cidade" varchar(255), 
	"fk_estado" integer, 
	"telefone" varchar(20), 
	"registro" bool, 
	"cep" varchar(9), 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: fornecedor
--

-- GO
INSERT INTO "public"."fornecedor" ("id", "cnpj", "razao_social", "logradouro", "numero", "bairro", "cidade", "fk_estado", "telefone", "registro", "cep") VALUES(3, '35.659.995/5465-42', 'razao de nada ', 'rua pvh', '999', 'bairo da luz ', 'brasilia', 6, '66666666', 't', '76854-222');
-- GO
INSERT INTO "public"."fornecedor" ("id", "cnpj", "razao_social", "logradouro", "numero", "bairro", "cidade", "fk_estado", "telefone", "registro", "cep") VALUES(1, '02.122.555/1546-51', 'jjjjjjjjjjj', '', '', '', '', 5, '', 'f', '-');
-- GO
INSERT INTO "public"."fornecedor" ("id", "cnpj", "razao_social", "logradouro", "numero", "bairro", "cidade", "fk_estado", "telefone", "registro", "cep") VALUES(2, '11.111.111/1111-11', 'ranzao de nadaq', '', '', '', '', 11, '', 'f', '99999-999');
-- GO
INSERT INTO "public"."fornecedor" ("id", "cnpj", "razao_social", "logradouro", "numero", "bairro", "cidade", "fk_estado", "telefone", "registro", "cep") VALUES(4, '55.828.969/8698-68', 'yytutyutyu7', '', '', '', '', 6, '', 'f', '76854-222');

-- GO

--
-- Table: movimentacao_estoque
--
CREATE TABLE "public"."movimentacao_estoque" 
(
	"id" integer NOT NULL , 
	"fk_setor" integer, 
	"operacao" bool, 
	"dt" timestamp[], 
	"fk_produto" integer, 
	"quantidade" integer, 
	"fk_tipo" integer, 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping 

--
-- Table: produto
--
CREATE TABLE "public"."produto" 
(
	"id" integer NOT NULL , 
	"descricao" text, 
	"peso_bruto" numeric(7,2), 
	"peso_liquido" numeric(7,2), 
	"fk_familia" integer, 
	"estoque_minino" integer, 
	"fk_unidade" integer, 
	"quantidade" integer, 
	"codigo_barras" varchar(255), 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: produto

-- GO
INSERT INTO "public"."produto" ("id", "descricao", "peso_bruto", "peso_liquido", "fk_familia", "estoque_minino", "fk_unidade", "quantidade", "codigo_barras") VALUES(1, 'caneta bic', 6.00, 7.00, 1, 20, 1, 350, '0126516545');
-- GO
INSERT INTO "public"."produto" ("id", "descricao", "peso_bruto", "peso_liquido", "fk_familia", "estoque_minino", "fk_unidade", "quantidade", "codigo_barras") VALUES(2, 'picanha', 632.00, 456.00, 0, 555, 3, 65461, '5445646');
-- GO
INSERT INTO "public"."produto" ("id", "descricao", "peso_bruto", "peso_liquido", "fk_familia", "estoque_minino", "fk_unidade", "quantidade", "codigo_barras") VALUES(3, 'omo multiação', 1.00, 1.00, 4, 500, 5, 25000, '321313153246');
-- GO

-- GO

--
-- Table: saida_produtos
--
CREATE TABLE "public"."saida_produtos" 
(
	"id" integer NOT NULL , 
	"data" timestamp[], 
	"fk_setor" integer, 
	"fk_produto" integer, 
	"quantidade" integer, 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: saida_produtos

--
-- Table: setor
--
CREATE TABLE "public"."setor" 
(
	"id" integer NOT NULL , 
	"descricao" text, 
	"quantidade" integer, 
	PRIMARY KEY ("id")
);
-- GO


-- GO
INSERT INTO "public"."setor" ("id", "descricao", "quantidade") VALUES(1, 'açougue', NULL);
-- GO
INSERT INTO "public"."setor" ("id", "descricao", "quantidade") VALUES(2, 'padaria', NULL);
-- GO
INSERT INTO "public"."setor" ("id", "descricao", "quantidade") VALUES(3, 'Limpeza', NULL);
-- GO
INSERT INTO "public"."setor" ("id", "descricao", "quantidade") VALUES(4, 'verduras', NULL);
-- GO

-- GO

--
-- Table: tipo_movimentacao
--
CREATE TABLE "public"."tipo_movimentacao" 
(
	"id" integer NOT NULL , 
	"tipo" varchar(20), 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: tipo_movimentacao
--

-- GO
INSERT INTO "public"."tipo_movimentacao" ("id", "tipo") VALUES(1, 'Entrada');
-- GO
INSERT INTO "public"."tipo_movimentacao" ("id", "tipo") VALUES(2, 'Transferêcia');
-- GO
INSERT INTO "public"."tipo_movimentacao" ("id", "tipo") VALUES(3, 'Saída por Nota Fisca');

-- GO

--
-- Table: tranferencia_produtos
--
CREATE TABLE "public"."tranferencia_produtos" 
(
	"id" integer NOT NULL , 
	"data" timestamp, 
	"fk_produto" integer, 
	"quantidade" integer, 
	"fk_origem" integer, 
	"fk_destino" integer, 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: tranferencia_produtos

--
-- Table: unidade
--
CREATE TABLE "public"."unidade" 
(
	"id" integer NOT NULL , 
	"tipo" varchar(100), 
	PRIMARY KEY ("id")
);
-- GO

--
-- Dumping Table Data: unidade
--

-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(1, 'UN');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(2, 'METRO');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(3, 'PESO');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(4, 'BARRIL');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(5, 'CAIXA');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(6, 'SACO');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(7, 'ENGRADADO');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(8, 'LITRO');
-- GO
INSERT INTO "public"."unidade" ("id", "tipo") VALUES(0, 'fRACIONADO');
-- GO

-- GO

--
-- Dumping Tables Foreign Keys
--

--
ALTER TABLE "public"."entrada_produtos" ADD CONSTRAINT "fk02" FOREIGN KEY ("fk_produto") REFERENCES "produto"("id");
-- GO

--
-- Foreign Key Constraint: fk_01
--
ALTER TABLE "public"."entrada_produtos" ADD CONSTRAINT "fk_01" FOREIGN KEY ("fk_fornecedor") REFERENCES "fornecedor"("id");
-- GO

--
-- Foreign Key Constraint: familia_fk_setor_fkey
--
ALTER TABLE "public"."familia" ADD CONSTRAINT "familia_fk_setor_fkey" FOREIGN KEY ("fk_setor") REFERENCES "setor"("id");
-- GO

--
-- Foreign Key Constraint: fornecedor_fk_estado_fkey
--
ALTER TABLE "public"."fornecedor" ADD CONSTRAINT "fornecedor_fk_estado_fkey" FOREIGN KEY ("fk_estado") REFERENCES "estado"("id");
-- GO

--
-- Foreign Key Constraint: movimentacao_estoque_fk_setor_fkey
--
ALTER TABLE "public"."movimentacao_estoque" ADD CONSTRAINT "movimentacao_estoque_fk_setor_fkey" FOREIGN KEY ("fk_setor") REFERENCES "setor"("id");
-- GO

--
-- Foreign Key Constraint: movimentacao_estoque_fk_produto_fkey
--
ALTER TABLE "public"."movimentacao_estoque" ADD CONSTRAINT "movimentacao_estoque_fk_produto_fkey" FOREIGN KEY ("fk_produto") REFERENCES "produto"("id");
-- GO

--
-- Foreign Key Constraint: movimentacao_estoque_fk_tipo_fkey
--
ALTER TABLE "public"."movimentacao_estoque" ADD CONSTRAINT "movimentacao_estoque_fk_tipo_fkey" FOREIGN KEY ("fk_tipo") REFERENCES "tipo_movimentacao"("id");
-- GO

--
-- Foreign Key Constraint: produto_fk_familia_fkey
--
ALTER TABLE "public"."produto" ADD CONSTRAINT "produto_fk_familia_fkey" FOREIGN KEY ("fk_familia") REFERENCES "familia"("id");
-- GO

--
-- Foreign Key Constraint: produto_fk_unidade_fkey
--
ALTER TABLE "public"."produto" ADD CONSTRAINT "produto_fk_unidade_fkey" FOREIGN KEY ("fk_unidade") REFERENCES "unidade"("id");
-- GO

--
-- Foreign Key Constraint: saida_produtos_fk_setor_fkey
--
ALTER TABLE "public"."saida_produtos" ADD CONSTRAINT "saida_produtos_fk_setor_fkey" FOREIGN KEY ("fk_setor") REFERENCES "setor"("id");
-- GO

--
-- Foreign Key Constraint: saida_produtos_fk_produto_fkey
--
ALTER TABLE "public"."saida_produtos" ADD CONSTRAINT "saida_produtos_fk_produto_fkey" FOREIGN KEY ("fk_produto") REFERENCES "produto"("id");
-- GO

--
-- Foreign Key Constraint: tranferencia_produtos_fk_produto_fkey
--
ALTER TABLE "public"."tranferencia_produtos" ADD CONSTRAINT "tranferencia_produtos_fk_produto_fkey" FOREIGN KEY ("fk_produto") REFERENCES "produto"("id");
-- GO

--
-- Foreign Key Constraint: tranferencia_produtos_fk_origem_fkey
--
ALTER TABLE "public"."tranferencia_produtos" ADD CONSTRAINT "tranferencia_produtos_fk_origem_fkey" FOREIGN KEY ("fk_origem") REFERENCES "setor"("id");
-- GO

--
-- Foreign Key Constraint: tranferencia_produtos_fk_destino_fkey
--
ALTER TABLE "public"."tranferencia_produtos" ADD CONSTRAINT "tranferencia_produtos_fk_destino_fkey" FOREIGN KEY ("fk_destino") REFERENCES "setor"("id");
-- GO

--
-- Dumping Triggers
--
create role usuario;
create role financeiro;

grant select, insert on entrada_produtos, estado, familia, fornecedor, movimentacao_estoque, produto, saida_produtos, setor, tipo_movimentacao, tranferencia_produtos, unidade TO financeiro with grant option

grant select on entrada_produtos, estado, familia, fornecedor, movimentacao_estoque, produto, saida_produtos, setor, tipo_movimentacao, tranferencia_produtos, unidade to usuario with grant option


