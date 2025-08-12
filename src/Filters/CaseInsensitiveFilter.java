package Filters;



public class CaseInsensitiveFilter<T> implements Filter<T> {
    private final FieldExtractor<T, String> fieldExtractor;

    private final String value;



    public CaseInsensitiveFilter(FieldExtractor<T, String> fieldExtractor, String value) {
        this.fieldExtractor =   fieldExtractor  ;
        this.value          =   value           ;
    }



    @Override
    public Boolean matches(T argument) {
        return this.value.equals(fieldExtractor.extractValue(argument));
    }
}
