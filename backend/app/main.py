from fastapi import FastAPI

app = FastAPI()

from routers.account_routers import account_router
from routers.category_routers import category_router
from routers.subcategory_routers import subcategory_router
from routers.transaction_routers import transaction_router

app.include_router(account_router)
app.include_router(category_router)
app.include_router(subcategory_router)
app.include_router(transaction_router)