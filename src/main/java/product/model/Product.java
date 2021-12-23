package product.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10000)
    @NotBlank
    @Pattern(regexp = "^\\S*(.+)+\\S*")
    private String name;
    private int price;
    private String img;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product() {
    }

    public Product(String name, int price, String img, Category category) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
