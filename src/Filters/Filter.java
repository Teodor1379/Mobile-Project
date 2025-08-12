package Filters;



public interface Filter<T> {
    public Boolean matches(T argument);
}
