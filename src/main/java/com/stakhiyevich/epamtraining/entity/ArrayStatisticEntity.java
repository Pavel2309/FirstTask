package com.stakhiyevich.epamtraining.entity;

public class ArrayStatisticEntity {

    private int max;
    private int min;
    private double average;
    private int numberOfPositiveElements;
    private int numberOfNegativeElements;

    public ArrayStatisticEntity(int max, int min, double average,
                                int numberOfPositiveElements, int numberOfNegativeElements) {
        this.max = max;
        this.min = min;
        this.average = average;
        this.numberOfPositiveElements = numberOfPositiveElements;
        this.numberOfNegativeElements = numberOfNegativeElements;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getNumberOfPositiveElements() {
        return numberOfPositiveElements;
    }

    public void setNumberOfPositiveElements(int numberOfPositiveElements) {
        this.numberOfPositiveElements = numberOfPositiveElements;
    }

    public int getNumberOfNegativeElements() {
        return numberOfNegativeElements;
    }

    public void setNumberOfNegativeElements(int numberOfNegativeElements) {
        this.numberOfNegativeElements = numberOfNegativeElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayStatisticEntity)) return false;

        ArrayStatisticEntity that = (ArrayStatisticEntity) o;

        if (getMax() != that.getMax()) return false;
        if (getMin() != that.getMin()) return false;
        if (Double.compare(that.getAverage(), getAverage()) != 0) return false;
        if (getNumberOfPositiveElements() != that.getNumberOfPositiveElements()) return false;
        return getNumberOfNegativeElements() == that.getNumberOfNegativeElements();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMax();
        result = 31 * result + getMin();
        temp = Double.doubleToLongBits(getAverage());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getNumberOfPositiveElements();
        result = 31 * result + getNumberOfNegativeElements();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayStatisticsEntity{");
        sb.append("max=").append(max);
        sb.append(", min=").append(min);
        sb.append(", average=").append(average);
        sb.append(", numberOfPositiveElements=").append(numberOfPositiveElements);
        sb.append(", numberOfNegativeElements=").append(numberOfNegativeElements);
        sb.append('}');
        return sb.toString();
    }
}
