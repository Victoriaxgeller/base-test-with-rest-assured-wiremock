package fakestore.data;

import api.fakestore.model.Cart;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Date;

public class GenerateTestData {

    Faker faker = new Faker();

    public Cart generateCart() {
        return Cart.builder().id(numberFrom_0_to_1000())
                .userId(numberFrom_0_to_1000())
                .__v(numberFrom_0_to_1000())
//                .date(date())
                .products(generateCartProducts(numberFrom_0_to_10())).build();
    }

    public ArrayList<Cart.CartProduct> generateCartProducts(int count) {
        ArrayList<Cart.CartProduct> products = new ArrayList();
        for (int i = 0; i < count; i++) {
            products.add(Cart.CartProduct.builder().productId(numberFrom_0_to_10())
                    .quantity(numberFrom_0_to_10()).build());
        }
        return products;
    }

    private int numberFrom_0_to_10() {
        return faker.number().numberBetween(1, 10);
    }

    private int numberFrom_0_to_1000() {
        return faker.number().numberBetween(1, 1000);
    }

    private Date date() {
        return faker.date().birthday();
    }
}
