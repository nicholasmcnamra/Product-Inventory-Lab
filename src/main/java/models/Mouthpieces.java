package models;

public class Mouthpieces {

    private int id;
    private String manufacturer;
    private String type;
    private String material;
    private String model;
    private int quantity;
    private double price;

    public Mouthpieces(int id, String manufacturer, String model, String type, String material, int quantity, double price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.material = material;
        this.quantity = quantity;
        this.price = price;
    }

    public Mouthpieces() {

    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nManufacturer: %s\nModel: %s\nType: %s\nMaterial: %s\nQuantity: %d\nPrice: %.2f\n", id, manufacturer, model, type, material, quantity, price);
    }
}
