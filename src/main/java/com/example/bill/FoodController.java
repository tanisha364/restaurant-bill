package com.example.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;
    
    private final  String pdfOutputDirectory = "C:/Users/amin/Downloads";
    
    @PostMapping("/saveitem")
    public List<Menu> saveMenuItems(@RequestBody List<Menu> menuItems) {
        return foodService.saveMenuItems(menuItems);
    }
       
    @PostMapping("/bill")
    public BillResponse createBill(@RequestBody List<OrderRequest> orderRequests) {
    	 BillResponse billResponse = foodService.createBill(orderRequests);
    	    String filePath = pdfOutputDirectory + "/bill_" + System.currentTimeMillis() + ".pdf";
    	    BillPdfGenerator.generateBillPdf(billResponse, filePath);
    	    return billResponse;
    }
    
    @GetMapping("/{orderId}")
    public List<Food> getFoodsByOrderId(@PathVariable String orderId) {
        return foodService.getFoodsByOrderId(orderId);
    }
}
