package ch.eshop.dao;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Bag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String sessionID;

    @ManyToOne
    private Product product;

    @Column
    private int quantity;

    public Bag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", sessionID='" + sessionID + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
