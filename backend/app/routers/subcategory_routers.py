from fastapi import APIRouter

subcategory_router = APIRouter(prefix="/subcategory", tags=["subcategory"])

@subcategory_router.get("/")
async def list():

    """_Listar Subcategorias_

    Essa rota retorna todas as subcategorias cadastradas, com vínculo à categoria principal.

    ### Retorno esperado:

    **Exemplo de resposta (200):**
    ```json
    [
      {
        "id": 1,
        "description": "Supermercado",
        "category_id": 1,
        "category_description": "Casa",
        "created_at": "2025-07-01T10:10:00Z",
        "updated_at": "2025-10-15T14:00:00Z"
      },
      {
        "id": 2,
        "description": "Internet",
        "category_id": 1,
        "category_description": "Casa",
        "created_at": "2025-07-01T10:15:00Z",
        "updated_at": "2025-10-15T14:00:00Z"
      },
      {
        "id": 3,
        "description": "Combustível",
        "category_id": 2,
        "category_description": "Carro",
        "created_at": "2025-08-10T12:10:00Z",
        "updated_at": "2025-10-25T09:00:00Z"
      },
    ]
    ```
    """
    return {"message": "Lista de subcategorias cadastradas"}