package Filters;



import java.util.List;
import java.util.ArrayList;



public class FilterCount<T> implements Filter<T> {
    private final List<Filter<T>> filters ;
    private final Integer         num     ;


    public FilterCount(List<Filter<T>> filters, Integer num) {
        if (num > filters.size()) {
            throw new IllegalArgumentException("Invalid Filter Parameters!");
        }

        this.filters    =   filters ;
        this.num        =   num     ;
    }



    @Override
    public Boolean matches(T argument) {
        Integer counter = 0;

        for (Filter<T> filter: filters) {
            if (filter.matches(argument)) {
                counter = counter + 1;
            }
        }

        return counter >= this.num;
    }
}
