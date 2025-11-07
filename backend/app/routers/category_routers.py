from fastapi import APIRouter

category_router = APIRouter(prefix="/category", tags=["category"])

@category_router.get("/")
async def list():
    """_Listar Categorias_

    Essa rota retorna todas as categorias cadastradas no sistema e vínculo com subcategorias.

    ### Retorno esperado:

    **Exemplo de resposta (200):**
    ```json
    [
      {
        "id": 1,
        "description": "Casa",
        "created_at": "2025-07-01T10:00:00Z",
        "updated_at": "2025-10-15T14:00:00Z",
        "subcategories": [
          {
            "id": 1,
            "description": "Supermercado",
          },
          {
            "id": 2,
            "description": "Internet",
          }
        ]
      },
      {
        "id": 2,
        "description": "Carro",
        "created_at": "2025-08-10T12:00:00Z",
        "updated_at": "2025-10-25T09:00:00Z",
        "subcategories": [
          {
            "id": 3,
            "description": "Combustível",
          },
          {
            "id": 4,
            "description": "Manutenção",
          }
        ]
      },
      {
        "id": 3,
        "description": "Saúde",
        "created_at": "2025-05-15T09:30:00Z",
        "updated_at": "2025-10-01T16:00:00Z",
        "subcategories": []
      }
    ]
    ```
    """
    return {"message": "Lista de categorias cadastradas"}