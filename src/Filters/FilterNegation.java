package Filters;



public class FilterNegation<T> implements Filter<T> {
    private final Filter<T> filter;

    public FilterNegation(Filter<T> filter) {
        this.filter = filter;
    }


    @Override
    public Boolean matches(T argument) {
        return filter.matches(argument) == false;
    }
}
