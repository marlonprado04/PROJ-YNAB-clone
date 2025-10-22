# 💸 YNAB Clone – Clone Simples do YNAB

Aplicativo pessoal de **orçamento financeiro offline**, inspirado no **YNAB (You Need A Budget)**, desenvolvido com **Python (FastAPI)**, **React**, **SQLite** e **Electron**.

---

## 🎯 Objetivos

- Desenvolver uma aplicação pessoal de finanças com **FastAPI**, **SQLite**, **React (SPA frontend)** e **Electron**.  
- Aplicar o método de orçamento por **envelopes** para controle financeiro.  
- Foco em **uso pessoal**, **offline** e **multiplataforma**.  
- Servir como **portfólio profissional** e aprendizado de arquitetura fullstack com Python.  

---

### 🥇 Fase 1 – Aplicativo Local e Offline

- Backend local com **FastAPI** e **SQLite**, rodando no próprio computador.  
- Frontend em **React + TypeScript**, empacotado com **Electron** como app desktop.  
- Totalmente funcional **sem necessidade de internet**, ideal para uso pessoal.  
- Sem autenticação (modo single-user).  

---

### 🌐 Fase 2 – Aplicativo com Sincronização Remota (opcional)

- API web para sincronização e backup em nuvem.  
- Autenticação de usuário e suporte multi-dispositivo.  
- Banco de dados remoto com **PostgreSQL** hospedado em **VPS**.  
- Integração futura com aplicativos móveis.  

---

### 📌 Conceitos Aplicados

- Arquitetura modular e limpa entre backend e frontend.  
- Organização em camadas no backend: **models**, **schemas**, **routers** e **services**.  
- Comunicação via **API RESTful local**.  
- Persistência local leve com **SQLite** usando **SQLModel**.  
- Empacotamento multiplataforma via **Electron**.  
- Planejamento baseado em requisitos funcionais definidos.  

---

## 🛠️ Stack Tecnológica

- **Backend:** Python, FastAPI, SQLModel, SQLite (local), PostgreSQL (remoto opcional).  
- **Frontend:** React + Vite, TypeScript, Tailwind CSS, Electron.  
- **DevOps (futuro):** Docker.  

---

## 🏗️ Arquitetura

- **Fase 1:** App local (FastAPI + SQLite + React/Electron).  
- **Fase 2:** Sincronização remota (PostgreSQL, autenticação JWT, deploy em VPS).  

---

## 🚀 Execução Local (MVP)

```bash
# 1. Criar ambiente virtual
python -m venv venv
source venv/bin/activate  # Windows: venv\Scripts\activate

# 2. Instalar dependências
pip install fastapi uvicorn sqlmodel

# 3. Executar servidor local
uvicorn main:app --reload

# 4. Acessar documentação
http://localhost:8000/docs


---

---

## 📄 Licença

Distribuído sob a [GPL v3.0](./LICENSE).
