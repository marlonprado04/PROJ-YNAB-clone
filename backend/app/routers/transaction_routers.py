from fastapi import APIRouter

transaction_router = APIRouter(prefix="/transaction", tags=["transaction"])

@transaction_router.get("/")
async def list():
    """_Listar Lançamentos_

    Essa rota retorna todos os lançamentos financeiros cadastrados no sistema, com informações detalhadas de tipo, valor, contas envolvidas e status.

    ### Retorno esperado:

    **Exemplo de resposta (200):**
    ```json
    [
      {
        "id": 1,
        "transaction_type": "INFLOW",
        "date": "2025-11-05",
        "amount": 2500.00,
        "from_account_id": 1,
        "to_account_id": null,
        "payee": "Empresa XPTO",
        "description": "Salário Mensal",
        "subcategory_id": 10,
        "status": "CLEARED",
        "transfer_group_id": null,
        "created_at": "2025-11-05T08:00:00Z",
        "updated_at": "2025-11-05T08:00:00Z"
      },
      {
        "id": 2,
        "transaction_type": "OUTFLOW",
        "date": "2025-11-06",
        "amount": 120.75,
        "from_account_id": 2,
        "to_account_id": null,
        "payee": "Restaurante Sabor & Arte",
        "description": "Almoço",
        "subcategory_id": 3,
        "status": "CLEARED",
        "transfer_group_id": null,
        "created_at": "2025-11-06T12:15:00Z",
        "updated_at": "2025-11-06T12:15:00Z"
      },
      {
        "id": 3,
        "transaction_type": "TRANSFER",
        "date": "2025-11-07",
        "amount": 500.00,
        "from_account_id": 2,
        "to_account_id": 3,
        "payee": "Reserva Mensal",
        "description": "Reserva de emergencia mensal",
        "subcategory_id": null,
        "status": "PENDING",
        "transfer_group_id": "b82bca7e-4a10-4b59-8a8b-1f6f514c9a2a",
        "created_at": "2025-11-07T09:30:00Z",
        "updated_at": "2025-11-07T09:30:00Z"
      }
    ]
    ```
    """
    return {"message": "Lista de transações cadastradas"}