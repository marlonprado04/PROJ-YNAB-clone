# ADR 001 – Escolha do Framework Backend

**Data:** 2025-10-21  
**Decisão tomada por:** Marlon (desenvolvedor)  

## Contexto
Para o MVP do YNAB Clone, precisamos de um backend que permita:  
- CRUD completo de contas, transações, categorias e orçamentos;  
- Operação **offline-first**, com persistência local (SQLite);  
- Comunicação via API REST para o frontend React dentro do Electron;  
- Evolução futura para sincronização em nuvem sem reescrever toda a base.  

## Decisão
Escolhemos **FastAPI** como framework backend principal, usando **SQLModel** para o ORM e **SQLite** para persistência local.  

## Alternativas consideradas
- **Django REST Framework**  
  - Prós: ORM robusto, admin pronto, muito suporte na comunidade  
  - Contras: pesado para uso offline, sobrecarga para MVP desktop, mais configuração inicial
- **Flask**  
  - Prós: leve, flexível, fácil de começar  
  - Contras: pouca validação automática, exige mais boilerplate para APIs REST, documentação manual
- **FastAPI**  
  - Prós: rápido, tipagem forte, validação automática com Pydantic, documentação Swagger pronta, fácil integração com Electron  
  - Contras: ORM menos completo que Django (resolvido com SQLModel)  

## Consequências
- Estrutura do backend organizada em **models**, **schemas**, **routers** e **services**;  
- JSON enviado/recebido seguirá **camelCase**, mantendo consistência com frontend;  
- Facilita futuras implementações de sincronização remota e autenticação;  
- Menor sobrecarga para MVP offline-first, com performance adequada para até 10.000 lançamentos.  

## Referências
- [FastAPI Official Docs](https://fastapi.tiangolo.com/)  
- [SQLModel Docs](https://sqlmodel.tiangolo.com/)  
- Experiência prévia com Django REST e conhecimento das limitações para apps offline desktop.
