package Filters;



import java.util.List;
import java.util.ArrayList;



public class FilterConjunction<T> implements Filter<T> {
    private final List<Filter<T>> filters;

    public FilterConjunction(List<Filter<T>> filters) {
        this.filters = filters;
    }



    @Override
    public Boolean matches(T argument) {
        for (Filter<T> filter : this.filters) {
            if (filter.matches(argument) == false) {
                return false;
            }
        }

        return true;
    }
}
