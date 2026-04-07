# StockFlow Backend Case Study

##  Overview
This project is a backend implementation for **StockFlow**, a B2B inventory management system.  
It focuses on designing a scalable backend to manage products across multiple warehouses and provides a **Low Stock Alert API** to help businesses restock efficiently.

---

##  Features
- Multi-warehouse inventory management
- Low stock alert system
- Supplier integration for restocking
- Clean and scalable database design
- RESTful API using Spring Boot

---

##  Problem Solved
Businesses need to:
- Track inventory across multiple warehouses
- Identify products running low on stock
- Quickly access supplier details for restocking

This system provides a centralized solution to handle all of the above.

---

##  Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Maven

---

##  Database Design
Key entities:
- Company
- Warehouse
- Product
- Inventory
- Supplier
- SupplierProduct
- InventoryTransaction

### Relationships:
- Company → Warehouse (1:N)
- Product ↔ Warehouse (M:N via Inventory)
- Product ↔ Supplier (M:N)

---

## 🔗 API Endpoint

### Get Low Stock Alerts

```http
GET /api/companies/{company_id}/alerts/low-stock
