package fakestore;

import api.fakestore.client.CartClient;
import api.fakestore.model.Cart;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest extends FakeStoreBaseTest {

    CartClient cartClient = new CartClient();

    @Test
    public void addNewCartTest() throws IOException {
        Cart expectedCart = generateCart.generateCart();
        Cart actualCart = cartClient.addNewCart(expectedCart);
        Cart mockCart = wireMockClient.sendPostRequest(expectedCart, "/cart", Cart.class);

        assertAll(
                "Grouped Assertions of Cart",
                () -> assertEquals(expectedCart, mockCart),
                () -> assertNotNull(actualCart));
    }

    @Test
    public void updateCartTest() {

    }

    @Test
    public void deleteCartTest() {

    }
}
