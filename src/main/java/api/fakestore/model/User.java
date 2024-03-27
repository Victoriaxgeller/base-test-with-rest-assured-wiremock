package api.fakestore.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Address address;
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
    private int __v;

    class Address {
        private Geolocation geolocation;
        private String city;
        private String street;
        private int number;
        private String zipcode;
    }

    class Geolocation {
        private String lat;
        @SerializedName("long")
        private String mylong;
    }

    class Name {
        private String firstname;
        private String lastname;
    }
}
