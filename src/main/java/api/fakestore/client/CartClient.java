package api.fakestore.client;

import api.common.BaseApiClient;
import api.fakestore.model.Cart;
import com.google.gson.Gson;
import api.common.RequestBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartClient extends BaseApiClient {
    Gson gson = new Gson();


    public CartClient() {
        super(config.fakestoreApiURL());
    }

    public List<Cart> getAllCarts() {
        return new ArrayList<>();
    }

    public Cart getCartById(int id) {
        RequestBuilder requestBuilder = RequestBuilder.builder()
                .path("carts/{id}")
                .pathParams(Collections.singletonMap("id", String.valueOf(id))).build();

        return getRequestWithPathParam(requestBuilder).body().as(Cart.class);
    }

    public List<Cart> getLimitedCarts(int limit) {
        return new ArrayList<>();
    }

    public Cart addNewCart(Cart cart) {
        RequestBuilder requestBuilder = RequestBuilder.builder()
                .body(gson.toJson(cart))
                .path("carts").build();
        return postRequest(requestBuilder).body().as(Cart.class);
    }

    public Cart updateCart() {
        return new Cart();
    }

    public Cart deleteCart() {
        return new Cart();
    }

}
