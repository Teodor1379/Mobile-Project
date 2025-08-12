package Parser;



import Listings.Listing;

import Products.Car;

import Filters.Filter           ;
import Filters.FieldExtractor   ;
import Filters.FilterBuilder    ;



import java.util.List       ;
import java.util.ArrayList  ;

import java.util.Map    ;
import java.util.HashMap;

import java.util.Stack;



public class QuerySearcher implements Searcher {

    @Override
    public List<Listing> search(List<Listing> listings, String query) {
        QueryParser     parser          = new QueryParser()             ;
        List<String>    polishNotation  = parser.toPolishNotation(query);

        Map<String, FieldExtractor<Car, ?>> fieldExtractors = new HashMap<>();

        fieldExtractors.put("year", Car::getYear);
        fieldExtractors.put("model", Car::getModel);
        fieldExtractors.put("brand", Car::getBrand);

        FilterBuilder<Car> builder = new FilterBuilder<>(fieldExtractors);
        Filter<Car> filter = builder.buildFilter(polishNotation);

        return listings.stream()
                .filter(listing -> filter.matches(listing.getCar()))
                .toList();
    }
}
