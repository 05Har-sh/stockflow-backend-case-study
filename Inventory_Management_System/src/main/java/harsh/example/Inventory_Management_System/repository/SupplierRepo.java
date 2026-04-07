package harsh.example.Inventory_Management_System.repository;

import harsh.example.Inventory_Management_System.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository {
    Supplier findByProductId(Long id);
}
