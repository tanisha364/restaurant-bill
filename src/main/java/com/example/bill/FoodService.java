package com.example.bill;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private FoodRepository orderRepository;
    
    @Autowired
    private MenuRepository menuRepository;
    
    private final  String pdfOutputDirectory = "C:/Users/amin/Downloads";

    public List<Menu> saveMenuItems(List<Menu> menuItems) {
        return menuRepository.saveAll(menuItems);
    }
       
    
    
    public BillResponse createBill(List<OrderRequest> orderRequests) {
        double totalAmount = 0;
        List<Food> orderedFoods = new ArrayList<>();
        
        // Generate a unique order identifier
        String orderId = UUID.randomUUID().toString();

        for (OrderRequest orderRequest : orderRequests) {
            String foodName = orderRequest.getFoodName();
            int quantity = orderRequest.getQuantity();
            Menu menuItem = menuRepository.findByFoodName(foodName);
            if (menuItem == null) {
                throw new RuntimeException("Menu item not found: " + foodName);
            }

            Food orderedFood = new Food();
            orderedFood.setFoodName(foodName);
            orderedFood.setQuantity(quantity);
            orderedFood.setOrderId(orderId); 
            orderedFoods.add(orderedFood);
            
            orderRepository.save(orderedFood);

            totalAmount += menuItem.getPrice() * quantity;
        }

        // Calculate GST, tax, and delivery charges (example values)
        double gst = totalAmount * 0.18; // Assuming GST is 18%
        gst = Math.floor(gst * 100) / 100.0;
        int deliveryCharge = 20;

        // Construct bill details
        BillDetails billDetails = new BillDetails(deliveryCharge, gst, deliveryCharge);
        billDetails.setAmount((int) totalAmount);
        billDetails.setGst(gst);
        billDetails.setDeliveryCharge(deliveryCharge);

        // Calculate total price
        double totalPrice = totalAmount + gst + deliveryCharge;

        // Construct bill response
        BillResponse billResponse = new BillResponse();
        billResponse.setOrderedFoods(orderedFoods);
        billResponse.setBillDetails(billDetails);
        billResponse.setTotalPrice(totalPrice);        
                
        return billResponse;
    }


	public List<Food> getFoodsByOrderId(String orderId) {
		return orderRepository.findByOrderId(String.valueOf(orderId));
	}

 
}
