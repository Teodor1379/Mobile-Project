package Filters;



import java.util.Map    ;
import java.util.HashMap;


import java.util.List       ;
import java.util.ArrayList  ;

import java.util.Stack;



public class FilterBuilder<T> {
    public final Map<String, FieldExtractor<T, ?>> fields;



    public FilterBuilder(Map<String, FieldExtractor<T, ?>> fields) {
        this.fields = fields;
    }



    public Filter<T> buildFilter(List<String> tokens) {
        Stack<Filter<T>>    filters =   new Stack<>();
        Stack<String>       strings =   new Stack<>();
        Stack<String>       operats =   new Stack<>();

        // System.out.println("All tokens are: " + tokens);

        for (String token : tokens) {
            switch (token) {
                case "&"    ->  operats.push(token);
                case "|"    ->  operats.push(token);
                case "="    ->  operats.push(token);
                case "<"    ->  operats.push(token);
                case ">"    ->  operats.push(token);
                default     ->  strings.push(token);
            }
        }



        while (!operats.isEmpty()) {
            // System.out.println("Current operator is: " + operats.peek());

            switch (operats.peek()) {
                case "&"    ->  filters.push(buildFilterConjunction  (filters, strings));
                case "|"    ->  filters.push(buildFilterDisjunction  (filters, strings));
                case "="    ->  filters.push(buildFilterExactValue   (filters, strings));
                case "<"    ->  filters.push(buildLessThanFilter     (filters, strings));
                case ">"    ->  filters.push(buildMoreThanFilter     (filters, strings));
            }

            operats.pop();
        }

        return filters.pop();
    }



    private <V extends Comparable<V>> Filter<T> buildLessThanFilter(Stack<Filter<T>> filters, Stack<String> strings) {
        String fld = strings.pop();
        String max = strings.pop();

        FieldExtractor<T, V> fieldExtractor = (FieldExtractor<T, V>) this.fields.get(fld);

        if (fieldExtractor != null) {
            return new RangeFilter<>(fieldExtractor, null, this.parseValue(max));
        }

        return null;
    }

    private <V extends Comparable<V>> Filter<T> buildMoreThanFilter(Stack<Filter<T>> filters, Stack<String> strings) {
        String fld = strings.pop();
        String min = strings.pop();

        FieldExtractor<T, V> fieldExtractor = (FieldExtractor<T, V>) this.fields.get(fld);

        if (fieldExtractor != null) {
            return new RangeFilter<>(fieldExtractor, this.parseValue(min), null);
        }

        return null;
    }



    private <V> Filter<T> buildFilterExactValue(Stack<Filter<T>> filters, Stack<String> strings) {
        String field = strings.pop();
        String value = strings.pop();

        FieldExtractor<T, V> fieldExtractor = (FieldExtractor<T, V>) this.fields.get(field);

        if (fieldExtractor != null) {
            return new ExactFilter<>(fieldExtractor, this.parseValue(value));
        }

        return null;
    }



    private Filter<T> buildFilterConjunction(Stack<Filter<T>> filters, Stack<String> strings) {
        List<Filter<T>> list = new ArrayList<>();

        list.add(filters.pop());
        list.add(filters.pop());

        return new FilterConjunction<>(list);
    }

    private Filter<T> buildFilterDisjunction(Stack<Filter<T>> filters, Stack<String> strings) {
        List<Filter<T>> list = new ArrayList<>();

        list.add(filters.pop());
        list.add(filters.pop());

        return new FilterDisjunction<>(list);
    }



    private <V> V parseValue(String value) {
        if (value.startsWith("'") && value.endsWith("'")) {
            return (V) value.substring(1, value.length() - 1);
        }

        return (V) Integer.valueOf(value);
    }
}
