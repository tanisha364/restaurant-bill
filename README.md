Restaurant Bill Generator -
This is a Spring Boot project aimed at generating bills for restaurant orders. It allows users to save menu items, place orders, and automatically generate a bill in PDF format upon order confirmation.

Usage -
Once the application is up and running, you can access it through your web browser at http://localhost:8082.

Dependencies -
This project utilizes the following dependencies:

Spring Boot: for creating the RESTful application.
Spring Data JPA: for persistence.
Maven: for project management and dependency resolution.
PDF generation library (e.g., Apache PDFBox or iText): for creating bills in PDF format.

Usage -
1. Saving Menu Items
To save menu items, follow these steps:

Define your menu items in the MenuService through "/saveitem".
Each menu item should have attributes such as name, price, etc.
Use the MenuItemRepository to persist menu items to the database.
2. Placing Orders
To place orders, follow these steps:

Utilize the OrderService to create orders through "/bill".
Users can select items from the available menu.
The system checks if the ordered items are available in the menu list.
Orders are stored in the database using the OrderRepository.
3. Generating Bills
When a user places an order, a bill is automatically generated in PDF format. Follow these steps:

Upon order confirmation, the BillPdfGenerator generates a bill for the order.
The bill includes details such as order items, quantities, prices, and total amount.
PDF generation is handled using a library like Apache PDFBox or iText.
