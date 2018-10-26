package ex02;

import java.beans.PropertyEditorSupport;

public class CarPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            String[] values = text.split(",");
            Car car = new Car();
            car.setModel(values[0]);
            car.setMaker(values[1]);
            car.setAuto(Boolean.parseBoolean(values[2]));
            this.setValue(car);
        } catch(Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Object getValue() {
        return super.getValue();
    }
}










