import java.util.ArrayList;

class Customer {
    private int custID;
    private String name;
    private int phone;
    private String email;
    private ArrayList<Order> orders;
    
    public Customer(int custID, String name, int phone, String email) {    
        this.custID = custID;
        this.name = name;
        this.phone = phone;
        this.email = email; 
        this.orders = new ArrayList<Order>();
    }
        
    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public String getName() {
        return this.name;
    }
        
    public int getCustID() {
        return this.custID;
    }
    
    public int getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

class Item {
    private int itemID;
    private String name;
    private float price;
    private String category;
    
    public Item(int itemID, String name, float price, String category) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public int getItemID() {
        return this.itemID;
    }
    
    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }
    
    public String getCategory() {
        return this.category;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setName(String name) {   
        this.name = name;
    }

    public void setPrice(float price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("price cannot be negative!");
        }
    }
}

class Order {
    protected int orderID;
    protected Customer customer;
    protected ArrayList<Item> items;
    protected String orderStatus;
    protected float totalAmount;
    
    public Order(int orderID, Customer customer, ArrayList<Item> items, String orderStatus, float totalAmount) {
        this.orderID = orderID;
        this.customer = customer;
        this.items = items;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.customer.addOrder(this);
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    } 
        
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(Item item) {
        this.items.add(item); 
    }
    
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public float calculateTotal() {
        for (int i = 0; i < this.items.size(); i++) {
            this.totalAmount = this.totalAmount + this.items.get(i).getPrice();
        }
        return this.totalAmount;
    }
                
    public void setOrderStatus(String status) {
        if (status.equals("CREATED") ||
            status.equals("PAID") ||
            status.equals("SHIPPED") ||
            status.equals("DELIVERED") ||
            status.equals("CANCELLED")) {
                this.orderStatus = status;
        } else {
            System.out.println("Invalid order status");
        }
    }
    
    public void makePayment(float amount) {
        if (amount == this.totalAmount && this.getOrderStatus().equals("CREATED")) {
            this.setOrderStatus("PAID");
        } else {
            System.out.println("invalid payment");
        }
    }
   
    public void cancelOrder() {
        this.setOrderStatus("CANCELLED");
    }   
    
    public int getOrderID() {
        return this.orderID;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }
    
    public String getOrderStatus() {
        return this.orderStatus;
    }

    public float getTotalAmount() {
        return this.totalAmount;
    }
    
    public String viewOrder() {
        String toreturn = "Order ID: " + this.orderID + "Customer: " + this.customer.getName() + "Items: " + this.items + "Order Status: " + this.orderStatus + "Total amount: " + this.totalAmount;
        return toreturn;
    }

    public String toString() {
        return this.viewOrder();
    }
}

class DeliveryOrder extends Order {
    protected String address;
    protected float deliveryCharge;
    protected String estimatedTime;

    public DeliveryOrder(int orderID, Customer customer, ArrayList<Item> items, String orderStatus, float totalAmount, String address, float deliveryCharge, String estimatedTime) {  
        super(orderID, customer, items, orderStatus, totalAmount);
        this.address = address;
        this.deliveryCharge = deliveryCharge;
        this.estimatedTime = estimatedTime;
    }

    @Override
    public float calculateTotal() {
        this.totalAmount = this.totalAmount + this.deliveryCharge;
        return this.totalAmount;
    }

    @Override
    public void setOrderStatus(String status) {
        if (this.getOrderStatus().equals("SHIPPED") && status.equals("DELIVERED")) {
            this.orderStatus = status;
         } else if (this.getOrderStatus().equals("SHIPPED")) {
            System.out.println("Invalid order status");
         } else {
            this.orderStatus = status;
        }
     }
}


class ExpressDelivery extends DeliveryOrder {
    public ExpressDelivery(int orderID, Customer customer, ArrayList<Item> items, String orderStatus, float totalAmount, String address, float deliveryCharge, String estimatedTime) {
        super(orderID, customer, items, orderStatus, totalAmount, address, deliveryCharge, estimatedTime);
    }


    public void setNewDeliveryCharge(int multiplier) {
        this.deliveryCharge = multiplier * this.deliveryCharge;
    }

    public void setNewDeliveryTime(String newTime) {
        this.estimatedTime = newTime;
    }
    
}
class OrderSystem {
    public static void main(String[] args) {
        Customer c1 = new Customer(1, "Ananya", 98219012, "ananyakharbanda28@gmail.com");

        ArrayList<Item> items1 = new ArrayList<>();
        //     public Item(int itemID, String name, float price, String category) {
        items1.add(new Item(1, "apple", 1.23f, "food"));
        items1.add(new Item(2, "green apple", 1.234f, "food"));
        Order o1 = new Order(1, c1, items1, "CREATED", 15.0f);

        ArrayList<Item> items2 = new ArrayList<>();
        items2.add(new Item(3, "top", 20f, "clothes")); // polo t
        items2.add(new Item(4, "top", 20f, "clothes")); // polo t
        items2.add(new Item(5, "ss", 35f, "clothes")); // polo ss
        Order o2 = new Order(2, c1, items2, "CREATED", 77.0f);

        // print here to see that customer c1 has 2 orders in the arraylist
    }
} 
