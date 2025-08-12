package Filters;



import java.util.List;
import java.util.ArrayList;



public class FilterDisjunction<T> implements Filter<T> {
    private final List<Filter<T>> filters;


    public FilterDisjunction(List<Filter<T>> filters) {
        this.filters = filters;
    }



    @Override
    public Boolean matches(T argument) {
        for (Filter<T> filter : this.filters) {
            if (filter.matches(argument)) {
                return true;
            }
        }

        return false;
    }
}