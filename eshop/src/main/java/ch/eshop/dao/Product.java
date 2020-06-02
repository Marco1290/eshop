package ch.eshop.dao;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column
    private String name;

    @Column
    private String imagePath;

    @Column
    private String image2Path;

    @Column
    private String description;

    @Column
    private double price;


    public Product() {

    }

    public Product(String name,String imagePath,String image2Path, String description,double price){
        this.name = name;
        this.imagePath = imagePath;
        this.image2Path = image2Path;
        this.description = description;
        this.price = price;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImage2Path() {
        return image2Path;
    }

    public void setImage2Path(String image2Path) {
        this.image2Path = image2Path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "nom='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
