package top.hopestation.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {


    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValues.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : propertyValues) {
            if(pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }

}
