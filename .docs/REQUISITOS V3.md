# Documento de Requisitos Funcionais — MVP Mobile First

## 1. Introdução

Este documento define os requisitos funcionais para um aplicativo mobile-first de controle financeiro pessoal, combinando conceitos dos apps Organizze e YNAB. O objetivo é oferecer uma experiência fluida e responsiva para usuários que gerenciam seu orçamento mensal diretamente do smartphone.

---

## 2. Objetivo do Produto

Criar um aplicativo mobile de controle financeiro pessoal que permita:

- Gerenciar contas bancárias;
- Cadastrar e acompanhar receitas, despesas e transferências;
- Planejar e monitorar orçamento mensal por categoria;
- Visualizar previsão de saldo e comportamento financeiro futuro;
- Operar com ou sem internet.

---

## 3. Princípios de Design

- **Mobile First**: Otimização e priorização da usabilidade em telas pequenas;
- **Offline First**: Dados persistidos localmente, com sincronização futura;
- **Experiência intuitiva**: Navegação simples, com foco em usabilidade.

---

## 4. Funcionalidades do MVP

### 4.1. Contas Financeiras

- CRUD completo;
- Campos: `name`, `type`, `initialBalance`, `isBudgetIncluded`, `balanceDate`;
- Tipos: CHECKING, SAVINGS, INVESTMENT, CASH, CREDIT;
- Validação de saldo negativo apenas para `CASH`;
- Exibição de saldo atual e projetado.

### 4.2. Categorias e Subcategorias

- CRUD de categorias e subcategorias hierárquicas;
- Vinculação com lançamentos e orçamento;
- Bloqueio de exclusão caso haja lançamentos vinculados.

### 4.3. Lançamentos

- Tipos: Receita, Despesa, Transferência;
- Campos: `date`, `value`, }, contas, pagador, subcategoria, descrição, status (PENDING, CLEARED);
- Lógica de dupla entrada para transferências (duas transações ligadas);
- CRUD completo com validações;
- Agendamento de lançamentos futuros e recorrentes;
- Suporte a parcelamento com cálculo automático de parcelas.

### 4.4. Lançamentos Recorrentes

- Frequências: mensal, semanal, anual, etc.;
- Tipos: FIXED, INSTALLMENT;
- Edição pontual ou em grupo;
- Campo `manualOverride` para edições individuais.

### 4.5. Orçamento Mensal

- CRUD de limites mensais por subcategoria;
- Cálculo de valores planejados x gastos;
- Alertas para estouro de orçamento;
- Apresentação visual por cores ou ícones.

### 4.6. Dashboard Mobile

- Visão resumida do mês atual:
  - Saldo total
  - Projeção do mês
  - Total de gastos e receitas
  - Barra de progresso do orçamento

---

## 5. Tecnologias

- **Frontend Mobile**: React Native ou Flutter
- **Persistência Local**: SQLite ou Realm
- **Backend (posterior)**: Node.js + REST ou Firebase opcional

---

## 6. Requisitos Não Funcionais

- Interface responsiva (mobile > tablet);
- Operação 100% offline com persistência local;
- Performance fluida em CRUD e consultas;
- Design minimalista e funcional;

---

## 7. Itens Excluídos do MVP

- Web app ou desktop
- Gráficos analíticos detalhados
- Compartilhamento multiusuário
- Exportação de relatórios

---

## 8. Modelo de Dados (Resumo)

- **Account**: id, name, type, balance, isBudgetIncluded, balanceDate
- **Category**: id, name
- **Subcategory**: id, name, categoryId
- **Transaction**: id, type, fromAccountId, toAccountId, amount, date, subcategoryId, recurrence info
- **Budget**: id, subcategoryId, month, year, plannedAmount

---

## 9. Telas Previstas (Mobile)

- Tela Inicial (Resumo do Mês)
- Listagem de Transações
- Cadastro de Transação
- Tela de Contas
- Cadastro de Contas
- Tela de Categorias
- Orçamento Mensal
- Configurações

---

## 10. Considerações Finais

Este MVP foca em mobilidade, usabilidade e autonomia offline. A evolução para funcionalidades mais completas, sincronização e relatórios virá em etapas futuras.

