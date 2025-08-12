package Filters;



public class ExactFilter<T, V> implements Filter<T> {
    private final FieldExtractor<T, V>  fieldExtractor;

    private final V value;



    public ExactFilter(FieldExtractor<T, V> fieldExtractor, V value) {
        this.fieldExtractor =   fieldExtractor  ;
        this.value          =   value           ;
    }



    @Override
    public Boolean matches(T argument) {
        return this.value.equals(this.fieldExtractor.extractValue(argument));
    }
}
