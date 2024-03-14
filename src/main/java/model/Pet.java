package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
public class Pet {

    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private String status;

    public class Category {
        int id;
        String name;
    }
}
