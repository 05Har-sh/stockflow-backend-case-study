package harsh.example.Inventory_Management_System.service;

import harsh.example.Inventory_Management_System.dto.LowStockAlertDTO;
import harsh.example.Inventory_Management_System.entity.Inventory;
import harsh.example.Inventory_Management_System.entity.Product;
import harsh.example.Inventory_Management_System.entity.Supplier;
import harsh.example.Inventory_Management_System.entity.Warehouse;
import harsh.example.Inventory_Management_System.repository.InventryRepo;
import harsh.example.Inventory_Management_System.repository.PoductRepo;
import harsh.example.Inventory_Management_System.repository.SupplierRepo;
import harsh.example.Inventory_Management_System.repository.WarehouseRepo;

import java.util.ArrayList;
import java.util.List;



public class AlertService {

    final LowStockAlertDTO lowStockAlertDTO;
    final InventryRepo inventoryRepo;
    final PoductRepo productRepo;
    final SupplierRepo supplierRepo;
    final WarehouseRepo warehouseRepo;

    public AlertService(LowStockAlertDTO lowStockAlertDTO, InventryRepo inventryRepo, PoductRepo productRepo, SupplierRepo supplierRepo, WarehouseRepo warehouseRepo) {
        this.lowStockAlertDTO = lowStockAlertDTO;
        this.inventoryRepo = inventryRepo;
        this.productRepo = productRepo;
        this.supplierRepo = supplierRepo;
        this.warehouseRepo = warehouseRepo;
    }

    public List<LowStockAlertDTO> getLowStockAlerts(Long companyId) {
        List<LowStockAlertDTO> alerts = new ArrayList<>();

        List<Warehouse> warehouses = warehouseRepo.findByCompanyId(companyId);

        for (Warehouse warehouse : warehouses) {

            List<Inventory> inventories = inventoryRepo.findByWarehouseId(warehouse.getId());

            for (Inventory inv : inventories) {
                Product product = (Product) productRepo.findById(inv.getProductId()).orElse(null);
                if (product == null) continue;
                int currentStock = inv.getQuantity();
                int threshold = 10; // assumeed fixed threshold

                if (currentStock < threshold) {

                    Supplier supplier = supplierRepo.findByProductId(product.getId());

                    LowStockAlertDTO dto = new LowStockAlertDTO();

                    dto.setProductId(product.getId());
                    dto.setProductName(product.getName());
                    dto.setSku(product.getSku());
                    dto.setWarehouseId(warehouse.getId());
                    dto.setWarehouseName(warehouse.getName());
                    dto.setCurrentStock(currentStock);
                    dto.setThreshold(threshold);
                    dto.setDaysUntilStockout(0);
                    dto.setSupplier(supplier);

                    alerts.add(dto);
                }
            }
        }

        return alerts;
    }
}
