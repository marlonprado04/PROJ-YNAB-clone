# 📘 Documento de Requisitos Funcionais — MVP (Stack Python)

## Índice
- [📘 Documento de Requisitos Funcionais — MVP (Stack Python)](#-documento-de-requisitos-funcionais--mvp-stack-python)
  - [Índice](#índice)
  - [1. Introdução](#1-introdução)
  - [2. Objetivo do Produto](#2-objetivo-do-produto)
  - [3. Escopo do MVP V1](#3-escopo-do-mvp-v1)
  - [4. Arquitetura Técnica](#4-arquitetura-técnica)
    - [4.1 Backend](#41-backend)
    - [4.2 Frontend](#42-frontend)
  - [5. Requisitos Funcionais](#5-requisitos-funcionais)
    - [5.1. Gestão de Contas](#51-gestão-de-contas)
    - [5.2. Gestão de Categorias e Subcategorias](#52-gestão-de-categorias-e-subcategorias)
    - [5.3. Gestão de Lançamentos](#53-gestão-de-lançamentos)
    - [5.4. Orçamento Mensal por Categoria](#54-orçamento-mensal-por-categoria)
  - [6. Requisitos Não Funcionais](#6-requisitos-não-funcionais)
  - [7. Modelo de Dados](#7-modelo-de-dados)
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

---

## 1. Introdução
Requisitos para o desenvolvimento de um aplicativo de **gestão financeira pessoal** com Django, React e Electron e com foco em **uso offline first**.

- **Público-alvo**: Usuários individuais que desejam controlar finanças pessoais sem depender de internet ou serviços externos.  
- **Contexto e inspiração**: Aplicativo inspirado no YNAB, focado em gerenciamento de orçamento pessoal offline-first. O app visa trazer clareza sobre gastos e planejamento financeiro.


---

## 2. Objetivo do Produto
- CRUD de contas de banco, lançamentos, categorias e orçamentos.
- Categorizar lançamentos entre entradas, saídas e transferências.  
- Definir e acompanhar orçamentos mensais.  
- Operar offline em desktop.
- Permitir que o usuário tenha uma visão clara de gastos, orçamentos e saldo disponível, evitando surpresas financeiras


---

## 3. Escopo do MVP V1
- CRUD de contas, categorias, subcategorias e lançamentos.  
- CRUD de orçamento mensal por subcategoria.  
- Empacotamento em Electron.  

- **Limitações do MVP**:
  - Apenas usuário único (sem autenticação)
  - Sem integração automática com bancos
  - Sem relatórios complexos ou gráficos avançados
- Funcionalidades offline-first, com sincronização futura opcional


---

## 4. Arquitetura Técnica

### 4.1 Backend
- **Framework**: Django REST Framework.  
- **Banco**: SQLite (persistência local).  
- **ORM**: Django ORM.  
- **Autenticação**: não incluída no MVP (single user offline first).  
- **Convenção de nomenclatura:**
  - Modelos e atributos no backend (Python/Django): `snake_case` (ex.: `transaction_type`, `balance_date`)
  - Colunas e tabelas no banco de dados: `snake_case` (ex.: `planned_amount`, `is_budget_included`)
  - Payloads da API (JSON) consumidos pelo frontend: `camelCase` (ex.: `balanceDate`, `isBudgetIncluded`)

- Justificativa de stack:
  - Django REST: rápido para desenvolvimento e testes, bom ORM
  - React: interface responsiva e modular
  - Electron: empacotamento desktop multiplataforma
- Persistência de dados local (SQLite) com futura sincronização em nuvem opcional


### 4.2 Frontend
- **React** (com TypeScript).  
- **Electron** para empacotar como aplicativo desktop.  
- Consumo da API REST local.  

---


## 5. Requisitos Funcionais

### 5.1. Gestão de Contas

- CRUD completo para contas financeiras
- Campos obrigatórios:
  - `description`
  - `type` (`CHECKING`, `SAVINGS`, `INVESTMENT`, `CASH`, `CREDIT`) 
  - `balance`
  - `is_budget_included` (boolean)
  - `balance_date`
- Cálculo automático:
  - **Current Balance** com base em lançamentos finalizados dentro daquela determinada conta
  - **Projected Balance** considerando lançamentos finalizados + futuros dentro daquela determinada conta
- Listagem clara de contas com saldos
- Regra simples: não permitir saldo negativo em conta do tipo `CASH`
- Permitir filtros e ordenação na listagem (ex.: saldo crescente/decrescente, tipo de conta)

---

### 5.2. Gestão de Categorias e Subcategorias

- CRUD para categorias e subcategorias
- Campos:
  - Categoria: `description`
  - Subcategoria: `description` e vínculo com categoria
- Bloqueio simples para impedir exclusão se tiver algum lançamento vinculado
- Permitir ativar/desativar categorias sem excluir (para manter histórico)


---

### 5.3. Gestão de Lançamentos

- CRUD para lançamentos dos tipos:
- Campos obrigatórios:
  - `transaction_type` (`INFLOW`, `OUTFLOW`, `TRANSFER`)
  - `date` 
  - `amount`
  - `from_account` (conta origem)
  - `to_account` (conta destino para transações de tipo transferência, nullable para outros tipos)
  - `payee` 
  - `description`
  - `subcategory` (nullable para transferências, mas aceita preenchimento pro caso de reservas para determinadas finalidades) 
  - `status` (`PENDING`, `CLEARED`)
- Validação simples para transferências: criar dois lançamentos vinculados (com `transfer_group_id` pra vinculo e alteração simultanea)
- Visualização de lançamentos por `status`, `data`, `categoria` ou `conta`

---

### 5.4. Orçamento Mensal por Categoria

- CRUD completo de `orçamentos mensais` definidos por `subcategoria`
- Para obrigatórios
  - `budget_month` (ano e mês de referencia, ex: 2025-10)
  - `subcategory`
  - `budgeted_amount` (nullable se ainda não for planejado)
- Campos calculados automaticamente
  - `activity_amount` (soma dos lançamentos inseridos (finalizado ou não), na subcategoria e mês correspondente)
  - `available_amount` (diferença entre `budgeted_amount` e `activity_amount`)
- Exibir saldo `negativo` quando gastos ultrapassarem valor orçado 
- Exibir `totais do mês` pra cada um dos campos
- Permitir que o usuário mude o orçamento a qualquer momento recalculando os demais campos de acordo
- Permitir navegar entre meses anteriores e seguintes
- Calcular automaticamente com base em qualquer lançamento finalizado que afete a subcategoria / mês


---

## 6. Requisitos Não Funcionais

- Interface responsiva e simples
- Desempenho adequado para CRUD em tempo real
- Uso em desktop single user 100% offline
- Performance: carregamento de dados < 2s para até 10.000 lançamentos
- Compatibilidade: Windows e Linux via Electron

---


## 7. Modelo de Dados

- Dado monetário: Todo valor monetário será Integer (centavos) para evitar erros de precisão e facilitar calculos com precisão decimal financeira.


### 8.1. Account

| Campo            | Tipo                   | Comentário                        |
|------------------|------------------------|---------------------------------|
| id               | Long                   | Identificador                   |
| description      | String                 | Nome da conta                   |
| type             | Enum                   | CHECKING, SAVINGS, INVESTMENT, CASH, CREDIT |
| balance          | Int                    | Saldo atual calculado           |
| is_budget_included | Boolean              | Se entra no orçamento           |
| balance_date     | LocalDateTime          | Data do saldo                   |
| created_at       | LocalDateTime          | Data de criação                 |
| updated_at       | LocalDateTime          | Data de atualização             |

---

### 8.2. Category

| Campo       | Tipo          | Comentário          |
|-------------|---------------|---------------------|
| id          | Long          | Identificador       |
| description | String        | Nome da categoria   |
| created_at  | LocalDateTime | Criação             |
| updated_at  | LocalDateTime | Atualização         |

---

### 8.3. Subcategory

| Campo       | Tipo          | Comentário                |
|-------------|---------------|---------------------------|
| id          | Long          | Identificador             |
| description | String        | Nome da subcategoria      |
| category_id | FK Category   | Categoria vinculada       |
| created_at  | LocalDateTime | Criação                   |
| updated_at  | LocalDateTime | Atualização               |

---

### 8.4. Transaction

| Campo               | Tipo           | Comentário                                     |
|---------------------|----------------|----------------------------------------------- |
| id                  | Long           | Identificador                                  |
| from_account_id     | FK Account     | Conta origem                                   |
| to_account_id       | FK Account     | Conta destino para transferências (nullable)   |
| subcategory_id      | FK Subcategory | Subcategoria de transação (nullable para transferencias) |
| payee               | String         | Entidade de destino / origem                   |
| description         | String         | Descrição do lançamento                        |
| amount              | Int            | Valor                                          |
| date                | LocalDateTime  | Data do lançamento                             |
| transaction_type    | Enum           | INFLOW, OUTFLOW, TRANSFER                      |
| transfer_group_id    | UUID (opcional) | Grupo de transferência (nullable para não transferencias)|
| status              | Enum           | PENDING, CLEARED                               |
| created_at          | LocalDateTime  | Criação                                        |
| updated_at          | LocalDateTime  | Atualização                                    |

---

### 8.5. Budget

| Campo          | Tipo          | Comentário                        |
|----------------|---------------|-----------------------------------|
| id             | Long          | Identificador                     |
| subcategory_id | FK Subcategory| Subcategoria vinculada            |
| budget_month   | Date          | Mês do orçamento                  |
| budgeted_amount | Int          | Valor orçado para o mês           |
| activity_amount | Int          | Valor lançado para o mês          |
| available_amount| Int          | Valor disponivel para o mês       |
| created_at     | LocalDateTime | Criação                           |
| updated_at     | LocalDateTime | Atualização                       |

---

## 9. Especificação da API REST (Endpoints)

- Todos os endpoints e modelos usam o padrão de nomenclatura em inglês. 
- A interface do usuário será apresentada em português.
- Todos os endpoints usam padrão **camelCase** no JSON.  

### 9.1 Accounts
- `GET /accounts`
- `POST /accounts`

```json
{
  "description": "Conta Corrente",
  "type": "CHECKING",
  "balance": 3500,
  "isBudgetIncluded": true,
  "balanceDate": "2025-10-19T00:00:00"
}
```
- `GET /accounts/{id}`
- `PUT /accounts/{id}`

```json
{
  "description": "Conta Corrente Atualizada",
  "type": "CHECKING",
  "balance": 3600,
  "isBudgetIncluded": true,
  "balanceDate": "2025-10-20T00:00:00"
}
```

- `DELETE /accounts/{id}`

### 9.2 Categories
- `GET /categories` (paginação)
- `POST /categories`

```json
{
  "description": "Alimentação"
}

```
- `GET /categories/{id}`
- `PUT /categories/{id}`

```json
{
  "description": "Alimentação e Bebidas"
}
```

- `DELETE /categories/{id}` — Bloqueia exclusão se houver vínculo

### 9.3 Subcategories

- `GET /subcategories` (paginação)
- `POST /subcategories`

```json
{
  "description": "Supermercado",
  "categoryId": 1
}
```

- `GET /subcategories/{id}`
- `PUT /subcategories/{id}`

```json
{
  "description": "Mercado e Hortifruti",
  "categoryId": 1
}
```

- `DELETE /subcategories/{id}` — Bloqueia exclusão se houver vínculo

### 9.4 Transactions

- `GET /transactions` (filtros: data, conta, categoria, status, paginação)
- `POST /transactions`

```json
{
  "transactionType": "OUTFLOW",
  "date": "2025-10-19T14:30:00",
  "amount": 120,
  "fromAccountId": 1,
  "toAccountId": null,
  "payee": "Supermercado",
  "description": "Compra de mercado",
  "subcategoryId": 5,
  "status": "CLEARED"
}
```

- `GET /transactions/{id}`
- `PUT /transactions/{id}`

```json
{
  "transactionType": "OUTFLOW",
  "date": "2025-10-19T14:30:00",
  "amount": 150,
  "fromAccountId": 1,
  "toAccountId": null,
  "payee": "Supermercado",
  "description": "Compra de mercado atualizada",
  "subcategoryId": 5,
  "status": "CLEARED"
}
```

- `DELETE /transactions/{id}`

### 9.5 Budgets

- `GET /budgets` (paginação)
- `POST /budgets`

```json
{
  "subcategoryId": 5,
  "budgetMonth": "2025-10-01",
  "budgetedAmount": 500
}
```

- `GET /budgets/{id}`
- `PUT /budgets/{id}`

```json
{
  "subcategoryId": 5,
  "budgetMonth": "2025-10-01",
  "budgetedAmount": 600
}
```

- `DELETE /budgets/{id}`

---

## 10. Considerações Finais

Este documento serve como base para o desenvolvimento do MVP, focando no essencial para controle financeiro pessoal offline, com interface amigável e operação local. Futuras versões poderão expandir funcionalidades conforme necessidade e uso real.

- Próximos passos / futuras versões:
  - Autenticação para sincronização em nuvem
  - Aplicação Android


