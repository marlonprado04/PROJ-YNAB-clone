## Índice
- [Índice](#índice)
- [1. Requisitos funcionais para versões futuras](#1-requisitos-funcionais-para-versões-futuras)
  - [1.1. Lançamentos recorrentes](#11-lançamentos-recorrentes)
    - [1.1.1 Detalhamento](#111-detalhamento)
  - [1.2. Funcionalidades Futuras (não incluídas no MVP)](#12-funcionalidades-futuras-não-incluídas-no-mvp)


## 1. Requisitos funcionais para versões futuras

### 1.1. Lançamentos recorrentes

- Ter novos campos:
  - `recurrenceType` (`NONE`, `MONTHLY`, `INSTALLMENT`)
  - `installmentCount` (se parcelado)
- Permitir lançamentos futuros simples (agendamento)
- Atualização automática dos saldos em contas envolvidas ao finalizar lançamentos

#### 1.1.1 Detalhamento

- Suporte simplificado para recorrência:
  - Tipos permitidos: `NONE`, `MONTHLY`, `INSTALLMENT`
  - Geração automática:
    - Para `MONTHLY`: criar lançamentos futuros para até 3 meses à frente
    - Para `INSTALLMENT`: criar todas parcelas na criação
- Sem controle avançado de edição (manualOverride removido)
- Edição de recorrência substitui futuras gerações

### 1.2. Funcionalidades Futuras (não incluídas no MVP)

- Relatórios detalhados com gráficos e comparativos
- Aplicativo móvel nativo
- Sincronização em nuvem e multiusuário
- Soft delete e histórico de alterações
- Controle avançado de lançamentos recorrentes (manualOverride, aplicar só a uma ocorrência, etc)
- Funcionalidades colaborativas ou compartilhamento de contas
- Suporte a múltiplos perfis de orçamento
