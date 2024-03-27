package api.swagger.fake.model;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private String status;

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Category {
        int id;
        String name;
    }
}
