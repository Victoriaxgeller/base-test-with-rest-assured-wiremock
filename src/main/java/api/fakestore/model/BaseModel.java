package api.fakestore.model;

import java.lang.reflect.Field;


public class BaseModel {
    @Override
    public boolean equals(Object anObject) {

        if (this == anObject) return true;
        if (this.hashCode() != anObject.hashCode()) return false;
        if (anObject.getClass() != this.getClass()) return false;

        Field[] fields = this.getClass().getFields();
        boolean fieldsEqual = true;
        for (Field field : fields) {
            try {
                fieldsEqual = field.get(anObject).equals(field.get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return fieldsEqual;
    }
}
