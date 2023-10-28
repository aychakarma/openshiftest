package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.metrics.CustomMetricsService;
import tn.esprit.devops_project.services.Iservices.IStockService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class StockController {

    IStockService stockService;
    CustomMetricsService customMetricsService;

    @PostMapping("/stock")
    Stock addStock(@RequestBody Stock stock){
        return stockService.addStock(stock);
    }

    @GetMapping("/stock/{id}")
    Stock retrieveStock(@PathVariable Long id){
        long startTime = System.currentTimeMillis();
        Stock stock = stockService.retrieveStock(id);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        customMetricsService.recordCustomValue(executionTime);
        return stock;
    }

    @GetMapping("/stock")
    List<Stock> retrieveAllStock(){
        return stockService.retrieveAllStock();
    }


}
