package com.example.bill;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class BillPdfGenerator {

	public static void generateBillPdf(BillResponse billResponse, String filePath) {
	    try (PDDocument document = new PDDocument()) { //to represent the PDF document
	        PDPage page = new PDPage(); //A new page is added
	        document.addPage(page);

	        PDPageContentStream contentStream = new PDPageContentStream(document, page); //to write text content onto the page
	        contentStream.setFont(PDType1Font.HELVETICA, 12);
	        contentStream.beginText();
	        
	        contentStream.newLineAtOffset(100, 700);
	     
	        
	        contentStream.newLineAtOffset(0, -20); // Adjusting offset for better alignment
	        
	        contentStream.showText("Ordered Foods:");
	        List<Food> orderedFoods = billResponse.getOrderedFoods();
	        for (Food food : orderedFoods) {
	            contentStream.newLineAtOffset(0, -20);
	            contentStream.showText("   Name: " + food.getFoodName() + ", Quantity: " + food.getQuantity());
	        }
	        contentStream.newLineAtOffset(0, -20);
	        contentStream.newLineAtOffset(0, -20); 
	        contentStream.showText("Bill Details:");
	        
	        contentStream.newLineAtOffset(0, -20);
	        contentStream.showText("   Order Amount: " + billResponse.getBillDetails().getAmount());
	        
	        contentStream.newLineAtOffset(0, -20);
	        contentStream.showText("   GST: " + billResponse.getBillDetails().getGst());
	        
	        contentStream.newLineAtOffset(0, -20);
	        contentStream.showText("   Delivery Charge: " + billResponse.getBillDetails().getDeliveryCharge());
	        contentStream.newLineAtOffset(0, -20);
	        
	        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
	        contentStream.newLineAtOffset(0, -20);
	        contentStream.showText("Total Payable: " + billResponse.getTotalPrice());
	        
	        contentStream.endText();
	        contentStream.close();

	        document.save(new File(filePath));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
