# Documento de Requisitos Funcionais — MVP

## Índice

- [Documento de Requisitos Funcionais — MVP](#documento-de-requisitos-funcionais--mvp)
  - [Índice](#índice)
  - [1. Introdução](#1-introdução)
  - [2. Objetivo do Produto](#2-objetivo-do-produto)
  - [3. Escopo do MVP](#3-escopo-do-mvp)
  - [4. Arquitetura Técnica](#4-arquitetura-técnica)
    - [4.1. Backend](#41-backend)
    - [4.2. Frontend](#42-frontend)
  - [5. Requisitos Funcionais](#5-requisitos-funcionais)
    - [5.1. Gestão de Contas](#51-gestão-de-contas)
    - [5.2. Gestão de Categorias e Subcategorias](#52-gestão-de-categorias-e-subcategorias)
    - [5.3. Gestão de Lançamentos](#53-gestão-de-lançamentos)
      - [5.3.1 Lançamentos Recorrentes](#531-lançamentos-recorrentes)
    - [5.4. Orçamento Mensal por Categoria](#54-orçamento-mensal-por-categoria)
  - [6. Requisitos Não Funcionais](#6-requisitos-não-funcionais)
  - [7. Funcionalidades Futuras (não incluídas no MVP)](#7-funcionalidades-futuras-não-incluídas-no-mvp)
  - [8. Modelo de Dados](#8-modelo-de-dados)
    - [8.1. Account](#81-account)
    - [8.2. Category](#82-category)
    - [8.3. Subcategory](#83-subcategory)
    - [8.4. Transaction](#84-transaction)
    - [8.5. Budget](#85-budget)
  - [9. Especificação da API REST (Endpoints)](#9-especificação-da-api-rest-endpoints)
    - [9.1 Accounts](#91-accounts)
    - [9.2 Categories](#92-categories)
    - [9.3 Subcategories](#93-subcategories)
    - [9.4 Transactions](#94-transactions)
    - [9.5 Budgets](#95-budgets)
  - [10. Considerações Finais](#10-considerações-finais)
  - [Referências e Materiais de Apoio](#referências-e-materiais-de-apoio)

---

## 1. Introdução

Este documento descreve os requisitos funcionais mínimos (MVP) para o desenvolvimento de um aplicativo de controle financeiro pessoal, focado em usabilidade offline, controle de orçamento mensal e gestão simples de contas e lançamentos.

---

## 2. Objetivo do Produto

Desenvolver uma aplicação desktop que permita ao usuário:

- Gerenciar contas bancárias e lançamentos financeiros;
- Categorizar receitas, despesas e transferências;
- Definir e acompanhar limites de orçamento mensal;
- Operar completamente sem conexão com a internet (modo offline).

---

## 3. Escopo do MVP

O MVP incluirá funcionalidades essenciais para o controle financeiro pessoal, garantindo facilidade de uso e operação offline, com foco em desktop via Electron.

---

## 4. Arquitetura Técnica

### 4.1. Backend

- Framework: Spring Boot (API REST local)
- Banco de dados: SQLite (persistência local)
- API RESTful para operações CRUD das entidades essenciais
- Sem autenticação para MVP (uso single user offline)

### 4.2. Frontend

- Framework: Angular
- Empacotado com Electron para aplicação desktop responsiva e amigável
- Telas principais:
  - Gestão de contas
  - Gestão de categorias e subcategorias
  - Lançamentos financeiros (receitas, despesas, transferências)
  - Orçamento mensal por categoria

---

## 5. Requisitos Funcionais

### 5.1. Gestão de Contas

- CRUD completo para contas financeiras
- Campos obrigatórios:
  - `name`
  - `type` (CHECKING, SAVINGS, INVESTMENT, CASH, CREDIT)
  - `balance`
  - `isBudgetIncluded` (boolean)
  - `balanceDate`
- Cálculo automático:
  - **Current Balance** com base em lançamentos finalizados
  - **Projected Balance** considerando lançamentos futuros
- Listagem clara de contas com saldos
- Regra simples: não permitir saldo negativo em conta do tipo `CASH`

---

### 5.2. Gestão de Categorias e Subcategorias

- CRUD para categorias e subcategorias
- Campos:
  - Categoria: `name`
  - Subcategoria: `name` + vínculo com categoria
- Bloqueio simples para exclusão se houver lançamentos ou orçamento vinculados (sem soft delete)
- Listagem para seleção em lançamentos

---

### 5.3. Gestão de Lançamentos

- CRUD para lançamentos dos tipos:
  - Receita (`INCOME`)
  - Despesa (`EXPENSE`)
  - Transferência (`TRANSFER`)
- Campos obrigatórios:
  - `date`
  - `amount`
  - `transactionType`
  - `fromAccount` (conta origem)
  - `toAccount` (conta destino para transferências, nullable para outros tipos)
  - `payee`
  - `subcategory` (nullable para transferências)
  - `description`
  - `status` (PENDING, CLEARED)
  - `recurrenceType` (NONE, MONTHLY, INSTALLMENT)
  - `installmentCount` (se parcelado)
- Permitir lançamentos futuros simples (agendamento)
- Atualização automática dos saldos ao finalizar lançamentos
- Validação simples para transferências: criar dois lançamentos vinculados (com `transferGroupId` opcional)
- Não permitir orçamento negativo

#### 5.3.1 Lançamentos Recorrentes

- Suporte simplificado para recorrência:
  - Tipos permitidos: `NONE`, `MONTHLY`, `INSTALLMENT`
  - Geração automática:
    - Para `MONTHLY`: criar lançamentos futuros para até 3 meses à frente
    - Para `INSTALLMENT`: criar todas parcelas na criação
- Sem controle avançado de edição (manualOverride removido)
- Edição de recorrência substitui futuras gerações

---

### 5.4. Orçamento Mensal por Categoria

- CRUD para limites de orçamento mensal por subcategoria
- Visualização clara do orçamento mensal, agrupado por categoria e subcategoria
- Cálculo do saldo consumido e disponível com base em lançamentos
- Atualização em tempo real
- Alertas básicos para orçamento excedido

---

## 6. Requisitos Não Funcionais

- Interface responsiva, simples e amigável
- Operação 100% offline
- Desempenho adequado para CRUD em tempo real com SQLite
- Uso em desktop com Electron

---

## 7. Funcionalidades Futuras (não incluídas no MVP)

- Relatórios detalhados com gráficos e comparativos
- Aplicativo móvel nativo
- Sincronização em nuvem e multiusuário
- Autenticação de usuário (Spring Security + JWT)
- Soft delete e histórico de alterações
- Controle avançado de lançamentos recorrentes (manualOverride, aplicar só a uma ocorrência, etc)
- Funcionalidades colaborativas ou compartilhamento de contas
- Suporte a múltiplos perfis de orçamento

---

## 8. Modelo de Dados

### 8.1. Account

| Campo            | Tipo                   | Comentário                        |
|------------------|------------------------|---------------------------------|
| id               | Long                   | Identificador                   |
| name             | String                 | Nome da conta                   |
| type             | Enum                   | CHECKING, SAVINGS, INVESTMENT, CASH, CREDIT |
| balance          | BigDecimal             | Saldo atual calculado           |
| is_budget_included | Boolean               | Se entra no orçamento           |
| balance_date     | LocalDateTime          | Data do saldo                   |
| created_at       | LocalDateTime          | Data de criação                 |
| updated_at       | LocalDateTime          | Data de atualização             |

---

### 8.2. Category

| Campo       | Tipo          | Comentário          |
|-------------|---------------|---------------------|
| id          | Long          | Identificador       |
| name        | String        | Nome da categoria   |
| created_at  | LocalDateTime | Criação             |
| updated_at  | LocalDateTime | Atualização         |

---

### 8.3. Subcategory

| Campo       | Tipo          | Comentário                |
|-------------|---------------|---------------------------|
| id          | Long          | Identificador             |
| name        | String        | Nome da subcategoria      |
| category    | FK Category   | Categoria vinculada       |
| created_at  | LocalDateTime | Criação                   |
| updated_at  | LocalDateTime | Atualização               |

---

### 8.4. Transaction

| Campo               | Tipo           | Comentário                                    |
|---------------------|----------------|-----------------------------------------------|
| id                  | Long           | Identificador                                 |
| from_account        | FK Account     | Conta origem                                  |
| to_account          | FK Account     | Conta destino para transferências (nullable) |
| subcategory         | FK Subcategory | Nullable para transferências                   |
| payee               | String         | Favorecido/recebedor                           |
| description         | String         | Descrição do lançamento                        |
| amount              | BigDecimal     | Valor                                         |
| date                | LocalDateTime  | Data do lançamento                             |
| transaction_type    | Enum           | INCOME, EXPENSE, TRANSFER                      |
| transfer_group_id    | UUID (opcional)| Grupo de transferência (opcional no MVP)      |
| recurrence_type     | Enum           | NONE, MONTHLY, INSTALLMENT                      |
| installment_count   | Integer        | Número de parcelas (nullable)                   |
| status              | Enum           | PENDING, CLEARED                               |
| created_at          | LocalDateTime  | Criação                                       |
| updated_at          | LocalDateTime  | Atualização                                   |

---

### 8.5. Budget

| Campo          | Tipo          | Comentário                          |
|----------------|---------------|-----------------------------------|
| id             | Long          | Identificador                     |
| subcategory    | FK Subcategory| Subcategoria vinculada            |
| month          | Integer (1-12)| Mês do orçamento                  |
| year           | Integer       | Ano do orçamento                  |
| planned_amount | BigDecimal    | Valor orçado                     |
| created_at     | LocalDateTime | Criação                          |
| updated_at     | LocalDateTime | Atualização                      |

---

## 9. Especificação da API REST (Endpoints)

Todos os endpoints e modelos usam nomes em inglês. A interface do usuário será em português.

### 9.1 Accounts

- `GET /accounts` — Lista todas as contas
- `POST /accounts` — Cria nova conta
- `GET /accounts/{id}` — Detalha conta
- `PUT /accounts/{id}` — Atualiza conta
- `DELETE /accounts/{id}` — Remove conta

---

### 9.2 Categories

- `GET /categories`
- `POST /categories`
- `GET /categories/{id}`
- `PUT /categories/{id}`
- `DELETE /categories/{id}` — Bloqueia exclusão se houver vínculos

---

### 9.3 Subcategories

- `GET /subcategories`
- `POST /subcategories`
- `GET /subcategories/{id}`
- `PUT /subcategories/{id}`
- `DELETE /subcategories/{id}` — Bloqueia exclusão se houver vínculos

---

### 9.4 Transactions

- `GET /transactions` — Lista com filtros opcionais (data, conta, categoria, status)
- `POST /transactions`
- `GET /transactions/{id}`
- `PUT /transactions/{id}`
- `DELETE /transactions/{id}`

---

### 9.5 Budgets

- `GET /budgets`
- `POST /budgets`
- `GET /budgets/{id}`
- `PUT /budgets/{id}`
- `DELETE /budgets/{id}`

---

## 10. Considerações Finais

Este documento serve como base para o desenvolvimento do MVP, focando no essencial para controle financeiro pessoal offline, com interface amigável e operação local. Futuras versões poderão expandir funcionalidades conforme necessidade e uso real.

---

## Referências e Materiais de Apoio

- [Protótipo Figma](https://www.figma.com/design/jVGa1laO8WMWhzxlJKT7TF/PROJETO--APP-FINANCEIRO?node-id=0-1&t=uwo571f7gmppxPd3-1)
- Diagramas, exemplos de layout e scripts SQL conforme necessidade.

