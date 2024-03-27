package api.fakestore.model;

import lombok.*;

import java.util.*;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseModel {

    public int id;
    private int userId;
    private Date date;
    private ArrayList<CartProduct> products;
    private int __v;

    @Override
    public int hashCode() {
        int hash = Objects.hash(getId(), getUserId(), getDate(), getProducts(), get__v());
        System.out.println("HASHL: " + hash);
        return hash;
    }

    @ToString
    @Getter
    @Builder
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CartProduct {
        private int productId;
        private int quantity;

        @Override
        public int hashCode() {
            int h = Objects.hash(getProductId(), getQuantity());
            System.out.println("HASHL: " + h);

            return h;
        }
    }

}
