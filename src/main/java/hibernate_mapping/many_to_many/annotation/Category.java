package hibernate_mapping.many_to_many.annotation;

import javax.persistence.*;
import java.util.Set;

@Entity
// name of table mapping with this class in db.
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // name of column in db.
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // name: name of third table in db.
    // joinColumns: name - name of column in third table mapping with id column of this table.
    // inverseJoinColumns: name - name of column in third table mapping
    // with id column of rest table.
    @JoinTable(name = "category_product", joinColumns = {@JoinColumn(name = "cat_id")},
            inverseJoinColumns = {@JoinColumn(name = "pro_id")})
    private Set<Product> products;

    public Category() {

    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
