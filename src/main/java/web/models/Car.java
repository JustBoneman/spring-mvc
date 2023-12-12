package web.models;

import java.util.Objects;

public class Car {
    private String model;
    private String condition;
    private int series;

    public Car(){}

    public Car(String model, String condition, int series) {
        this.model = model;
        this.condition = condition;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(model, car.model) && Objects.equals(condition, car.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, condition, series);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", condition='" + condition + '\'' +
                ", series=" + series +
                '}';
    }
}
