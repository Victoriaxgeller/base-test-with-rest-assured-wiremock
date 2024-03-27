package api.fakestore.client;

import api.common.BaseApiClient;
import api.fakestore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductClient extends BaseApiClient {

    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    public Product getProductById() {
        return new Product();
    }

    public List<Product> getLimitedProducts(int limit) {
        return new ArrayList<>();
    }

    public Product addNewProduct() {
        return new Product();
    }

    public Product updateProduct() {
        return new Product();
    }

    public Product deleteProduct() {
        return new Product();
    }

}
