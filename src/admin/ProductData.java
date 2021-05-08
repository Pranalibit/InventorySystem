package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductData {
    private final StringProperty ProductID;
    private final StringProperty ProductName;
    private final StringProperty ProductQuantity;
    private final StringProperty ProductPrice;
    private final StringProperty ProductDiscount;

    public ProductData(String productid, String productname, String productquantity, String productprice, String productdiscount) {
        this.ProductID = new SimpleStringProperty(productid);
        this.ProductName = new SimpleStringProperty(productname);
        this.ProductQuantity = new SimpleStringProperty(productquantity);
        this.ProductPrice = new SimpleStringProperty(productprice);
        this.ProductDiscount = new SimpleStringProperty(productdiscount);

    }

    public String getProductID() {
        return ProductID.get();
    }

    public StringProperty productIDProperty() {
        return ProductID;
    }

    public void setProductID(String productID) {
        this.ProductID.set(productID);
    }

    public String getProductName() {
        return ProductName.get();
    }

    public StringProperty productNameProperty() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName.set(productName);
    }

    public String getProductQuantity() {
        return ProductQuantity.get();
    }

    public StringProperty productQuantityProperty() {
        return ProductQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.ProductQuantity.set(productQuantity);
    }

    public String getProductPrice() {
        return ProductPrice.get();
    }

    public StringProperty productPriceProperty() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        this.ProductPrice.set(productPrice);
    }

    public String getProductDiscount() {
        return ProductDiscount.get();
    }

    public StringProperty productDiscountProperty() {
        return ProductDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.ProductDiscount.set(productDiscount);
    }
}
