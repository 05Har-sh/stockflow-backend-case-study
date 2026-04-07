# StockFlow Backend Case Study

## 📄 Case Study Document

Full detailed solution (Part 1, 2, 3) is available here:  
https://docs.google.com/document/d/1U0wTot2Fawwb2Ph03snnUfW9wSQ3XNDGdQVRq64SSKY/edit?usp=sharing

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
```

Sample Response
```http
{
  "alerts": [
    {
      "product_id": 1,
      "product_name": "Laptop",
      "sku": "LP-123",
      "warehouse_id": 101,
      "warehouse_name": "Pune Warehouse",
      "current_stock": 5,
      "threshold": 10,
      "days_until_stockout": 0,
      "supplier": {
        "id": 1,
        "name": "ABC Supplier",
        "contact_email": "abc@email.com"
      }
    }
  ],
  "total_alerts": 1
}

```
🧠 Approach
- Fetch warehouses for a company
- Retrieve inventory for each warehouse
- Identify products below threshold
- Fetch supplier details
- Return structured alert response

⚠️ Assumptions
- Fixed stock threshold is used (for simplicity)
- Each product has one primary supplier

