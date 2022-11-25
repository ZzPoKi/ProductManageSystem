package pojo;
//创建产品的JavaBean类
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer sales;

    public Product() {
    }

    public Product(Integer id, String name, Integer price, Integer sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取
     * @return sales
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置
     * @param sales
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String toString() {
        return "Product{id = " + id + ", name = " + name + ", price = " + price + ", sales = " + sales + "}";
    }
}
