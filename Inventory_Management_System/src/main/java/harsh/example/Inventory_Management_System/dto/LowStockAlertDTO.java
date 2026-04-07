package harsh.example.Inventory_Management_System.dto;

import harsh.example.Inventory_Management_System.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LowStockAlertDTO {
    Long productId;
    String productName;
    String sku;
    Long warehouseId;
    String warehouseName;
    int currentStock;
    int threshold;
    int daysUntilStockout;
    Supplier supplier;
}
