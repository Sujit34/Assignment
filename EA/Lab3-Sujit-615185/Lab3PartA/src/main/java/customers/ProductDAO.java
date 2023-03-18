package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.*;



@Repository
public class ProductDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    public void save(Product product) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES ( :productNumber, :name, :price)", namedParameters);


    }


    public Product findByProductNumber(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getString("price")));

        return product;

    }

    public List<Product> getAllProducts() {
        List<Product> product = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getString("price")));


        return product;
    }


    public Product findByProductName(String name) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("name", name);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "name =:name ",
                namedParameters,
                (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getString("price")));

        return product;

    }

    public void removeProduct() {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        jdbcTemplate.update("DELETE from product", namedParameters);

    }
}
