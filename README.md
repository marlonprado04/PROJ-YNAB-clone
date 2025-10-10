# 💸 YNAB Clone – Clone Simples do YNAB

Aplicativo pessoal de **orçamento financeiro offline**, inspirado no **YNAB (You Need A Budget)**, desenvolvido com **Python (Django REST Framework)**, **React**, **SQLite** e **Electron**.

---

## 🎯 Objetivos

- Desenvolver uma aplicação pessoal de finanças com **Django REST Framework**, **SQLite**, **React (SPA frontend)** e **Electron**.  
- Aplicar o método de orçamento por **envelopes** para controle financeiro.  
- Foco em **uso pessoal**, **offline** e **multiplataforma**.  
- Servir como **portfólio profissional** e aprendizado de arquitetura fullstack com Python.  

---

### 🥇 Fase 1 – Aplicativo Local e Offline

- Backend local com **Django REST Framework** e **SQLite**, rodando no próprio computador.  
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
- Organização em camadas no backend: **models**, **serializers**, **views** e **services**.  
- Comunicação via **API RESTful local**.  
- Persistência local leve com **SQLite**.  
- Empacotamento multiplataforma via **Electron**.  
- Planejamento baseado em requisitos funcionais definidos.  

---

## 🛠️ Stack Tecnológica

- **Backend:** Python, Django REST Framework, SQLite (local), PostgreSQL (remoto opcional).  
- **Frontend:** React + Vite, TypeScript, Tailwind CSS, Electron.  
- **ORM:** Django ORM.  
- **DevOps (futuro):** Docker.  

---

## 🏗️ Arquitetura

- **Fase 1:** App local (Django REST + SQLite + React/Electron).  
- **Fase 2:** Sincronização remota (PostgreSQL, autenticação JWT, deploy em VPS).  

---

---

## 📄 Licença

Distribuído sob a [GPL v3.0](./LICENSE).
