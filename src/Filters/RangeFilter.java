package Filters;



public class RangeFilter<T, V extends Comparable<V>> implements Filter<T> {
    private final FieldExtractor<T, V> fieldExtractor;

    private final V min;
    private final V max;



    public RangeFilter(FieldExtractor<T, V> fieldExtractor, V min, V max) {
        this.fieldExtractor =   fieldExtractor;

        this.min    =   min;
        this.max    =   max;
    }



    @Override
    public Boolean matches(T argument) {
        V value = fieldExtractor.extractValue(argument);

        if (value == null) {
            return false;
        }

        if (this.min == null && this.max == null) {
            return false;
        }

        if (this.min == null) {
            return value.compareTo(this.max) < 0;
        }

        if (this.max == null) {
            return value.compareTo(this.min) > 0;
        }

        return value.compareTo(this.min) >= 0 && value.compareTo(max) <= 0;
    }
}
