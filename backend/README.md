## Para rodar o projeto

Para rodar o projeto localmente:

1. Instalar as dependências:

 `pip install fastapi uvicorn sqlalchemy sqlalchemy-utils alembic`

1. Acessar a pasta onde está o arquivo main.py, nesse caso `app`

2. Executar:

 `uvicorn main:app --reload`

1. Abrir no navegador a URL exibida no terminal (geralmente http://127.0.0.1:8000/docs) para acessar os endpoints e a documentação
