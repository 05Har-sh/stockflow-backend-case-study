package harsh.example.Inventory_Management_System.controller;

import harsh.example.Inventory_Management_System.dto.LowStockAlertDTO;
import harsh.example.Inventory_Management_System.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;


public class LowStockAlertController {

    final AlertService alertService;

    public LowStockAlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/api/companies/{companyId}/alerts/low-stock")
    public ResponseEntity<?> getLowStock(@PathVariable Long companyId){
        List<LowStockAlertDTO> alerts = alertService.getLowStockAlerts(companyId);
        return ResponseEntity.ok(Map.of(
                "alerts", alerts,
                "total_alerts", alerts.size()
        ));
    }
}
