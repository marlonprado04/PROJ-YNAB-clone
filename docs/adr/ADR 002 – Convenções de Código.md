# ADR 002 – Convenções de Código e Estrutura de Repositório

Data: 2025-10-21  
Decisão tomada por: Marlon (desenvolvedor)

## Contexto
Para manter o projeto YNAB Clone consistente, legível e fácil de manter, escolhi decidir os padrões de nomenclatura, estrutura de pastas e convenções de código.

## Decisão
Definidas as seguintes convenções e estrutura:

### Backend (FastAPI + SQLModel + Python)
- Pastas/arquivos → snake_case (account_model.py, transaction_service.py)  
- Classes → PascalCase (Account, TransactionService)  
- Variáveis/funções → snake_case (calculate_balance, from_account_id)  
- Endpoints → kebab-case (/accounts, /transactions)  
- JSON payload → camelCase (balanceDate, isBudgetIncluded)  
- Constantes globais → UPPER_SNAKE_CASE (DEFAULT_BUDGET_AMOUNT)  
- Commits → padrão type: descrição (feat: adiciona endpoint de contas)  

### Frontend (React + TypeScript)
- Componentes → PascalCase (AccountList.tsx)  
- Funções → camelCase (formatCurrency)  
- Variáveis → camelCase (selectedAccount, budgetAmount)  
- Pastas → snake_case (components/, pages/, services/, hooks/)  
- CSS/Tailwind → mesma paleta de cores e espaçamento consistente  

### Estrutura de Repositório
ynab-clone/
│
├── backend/
│   ├── app/
│   │   ├── main.py
│   │   ├── models/
│   │   ├── schemas/
│   │   ├── routers/
│   │   ├── services/
│   │   └── core/
│   ├── tests/
│   └── requirements.txt
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── hooks/
│   │   ├── services/
│   │   └── utils/
│   └── package.json
│
├── docs/
│   ├── ADR/
│   └── diagramas/
│
├── .gitignore
├── README.md
└── LICENSE

### Boas práticas gerais
- Comentários curtos e objetivos  
- Evitar abreviações vagas (acc → account)  
- Documentar decisões importantes no ADR  

## Consequências
- Código consistente e mais fácil de manter  
- Facilita integração entre backend e frontend  
- Preparação para futuras features, testes e deploys  
- Histórico claro de decisões documentadas  

