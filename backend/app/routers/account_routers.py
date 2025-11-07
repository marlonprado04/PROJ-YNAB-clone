from fastapi import APIRouter

account_router = APIRouter(prefix="/account", tags=["account"])


@account_router.get("/")
async def list():
    """_Listar Contas_

    Essa rota retorna todas as contas financeiras cadastradas no sistema, com informações resumidas de saldo atual e saldo projetado.

    ### Retorno esperado:

    **Exemplo de resposta (200):**
    ```json
    [
      {
        "id": 1,
        "description": "Carteira",
        "type": "CASH",
        "balance": 250.00,
        "projected_balance": 400.00,
        "is_budget_included": true,
        "balance_date": "2025-11-07",
        "created_at": "2025-10-15T14:20:00Z",
        "updated_at": "2025-11-01T10:15:00Z"
      },
      {
        "id": 2,
        "description": "Conta Corrente - Nubank",
        "type": "CHECKING",
        "balance": 1350.50,
        "projected_balance": 1620.75,
        "is_budget_included": true,
        "balance_date": "2025-11-07",
        "created_at": "2025-09-10T09:30:00Z",
        "updated_at": "2025-11-01T10:15:00Z"
      },
    ]
    ```
    """
    return {"message": "Lista de contas cadastradas"}

