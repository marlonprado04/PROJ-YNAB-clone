# Dev Journal - Marlon

## Índice

- [Dev Journal - Marlon](#dev-journal---marlon)
  - [Índice](#índice)
  - [TEMPLATE](#template)
    - [✅ Objetivo](#-objetivo)
    - [⚙️ Decisões Técnicas](#️-decisões-técnicas)
    - [🧠 Aprendizados](#-aprendizados)
    - [🐞 Problemas Encontrados](#-problemas-encontrados)
    - [💡 Soluções / Estratégias](#-soluções--estratégias)
    - [🔗 Referências](#-referências)
    - [📌 Pendências](#-pendências)
  - [14/06/2025 - Decisoes arquiteturais (DDD, Clean, etc) e null](#14062025---decisoes-arquiteturais-ddd-clean-etc-e-null)
    - [✅ Objetivo](#-objetivo-1)
    - [⚙️ Decisões Técnicas](#️-decisões-técnicas-1)
    - [🧠 Aprendizados](#-aprendizados-1)
    - [🐞 Problemas Encontrados](#-problemas-encontrados-1)
    - [💡 Soluções / Estratégias](#-soluções--estratégias-1)
    - [🔗 Referências](#-referências-1)
    - [📌 Pendências](#-pendências-1)
  - [11/06/2025 — Model Classes](#11062025--model-classes)
    - [✅ Objetivo](#-objetivo-2)
    - [⚙️ Decisões Técnicas](#️-decisões-técnicas-2)
    - [🧠 Aprendizados](#-aprendizados-2)
    - [🐞 Problemas Encontrados](#-problemas-encontrados-2)
    - [💡 Soluções / Estratégias](#-soluções--estratégias-2)
    - [🔗 Referências](#-referências-2)
    - [📌 Pendências](#-pendências-2)

## TEMPLATE

### ✅ Objetivo

### ⚙️ Decisões Técnicas

### 🧠 Aprendizados

### 🐞 Problemas Encontrados

### 💡 Soluções / Estratégias

### 🔗 Referências

### 📌 Pendências


## 14/06/2025 - Decisoes arquiteturais (DDD, Clean, etc) e null 

### ✅ Objetivo

Refletir sobre a arquitetura geral do projeto e sobre `null` dentro do spring

### ⚙️ Decisões Técnicas

### 🧠 Aprendizados

- Clean Archtecture separa de forma modular as camadas, deixando tudo desacoplado e tornando mais transferivel (ex: pode usar o mesmo CORE de aplicação para multiplos fonts, bancos, etc de forma facilitada)
- Para o MVP é desnecessário, altamente complexo
- Posso seguir estudando isso para projetos futuros quando estiver familiarizado com Spring Framework

### 🐞 Problemas Encontrados


### 💡 Soluções / Estratégias

### 🔗 Referências

- [Video para entender o que é Clean Architecture](https://www.youtube.com/watch?v=HynTfTli4mw)
- [Video de projeto Java Spring com arquitetura limpa](https://www.youtube.com/watch?v=kImcxK3Hmu8&list=PLUOqm1GRyVXaJG29--_tYtO8AkMChovx1)

### 📌 Pendências

## 11/06/2025 — Model Classes

### ✅ Objetivo
Implementar iniciar construção de models do banco

### ⚙️ Decisões Técnicas
- Modifiquei ``OperationType`` para ``TransactionType`` para manter consistência lógica na
- Modifiquei coluna ``account`` de Transaction para ``fromAccount`` para fazer mais sentido semantico  
- Criei a base das classes ``Model``, mantendo de fora os ``relationships``, ``ENUM`` e ``UUID`` para estudar melhor como implementar

### 🧠 Aprendizados
- Relembradas anotations de ``Data``, ``Entity`` e ``Id`` do Spring

### 🐞 Problemas Encontrados
- Nenhum por enquanto

### 💡 Soluções / Estratégias
- Nenhuma por enquanto

### 🔗 Referências
- [Video de Spring para iniciantes](https://www.youtube.com/watch?v=YY_hf0FOIcU&list=PLNCSWIsR6ADI_wMAx9F-Iu8Hs9HHxj4sb&index=2&t=1588sM)
- [Video de Spring com SQlite](https://www.youtube.com/watch?v=EqJMYLTmqW4)

### 📌 Pendências
- TODO Estudar como implementar Enum, UUID e revisar Relationship com Spring
- TODO Finalizar vídeos de Spring com SQLite e playlist da Fernanda Kipper
