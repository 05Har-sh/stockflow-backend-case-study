package harsh.example.Inventory_Management_System.repository;

import harsh.example.Inventory_Management_System.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventryRepo extends JpaRepository {
    List<Inventory> findByCompanyId(Long companyId);

    List<Inventory> findByWarehouseId(Long id);
}
