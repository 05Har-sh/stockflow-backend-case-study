package harsh.example.Inventory_Management_System.repository;

import harsh.example.Inventory_Management_System.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepo extends JpaRepository {
    List<Warehouse> findByCompanyId(Long companyId);
}
