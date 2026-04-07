package harsh.example.Inventory_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    Long id;
    Long productId;
    Long warehouseId;
    int quantity;
}
