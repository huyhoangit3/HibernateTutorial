package hibernate_mapping.many_to_many.annotation;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    /**
     *
     Với annotation @ManyToOne và @OneToOne thì fetchType mặc định là EAGER
     Với annotation @ManyToMany và @OneToMany thì fetchType mặc định là LAZY
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "category_product", joinColumns = {@JoinColumn(name = "pro_id")},
    inverseJoinColumns = {@JoinColumn(name = "cat_id")})
    private Set<Category> categories;

    public Product() {

    }
    public Product(String productName) {
        this.productName = productName;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
