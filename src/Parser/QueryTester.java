package Parser;



import Products.Car;

import Listings.Listing;



import java.util.List;
import java.util.Map;



public class QueryTester {
    public static final Listing BMW_X5 = new Listing(new Car("Name1", "D1", "1", "bmw", "x5", "1", 1, 2000, false), 10000.0, "T1", "D1", "1");
    public static final Listing BMW_E60 = new Listing(new Car("Name2", "D2", "2", "bmw", "e60", "2", 1, 2005, false), 7000.0, "T2", "D2", "2");
    public static final Listing A4_OLD = new Listing(new Car("Name3", "D3", "3", "audi", "a4", "3", 1, 2001, true), 5000.0, "T3", "D3", "3");
    public static final Listing A4_NEW = new Listing(new Car("Name4", "D4", "4", "audi", "a4", "4", 1, 2003, true), 5000.0, "T4", "D4", "4");
    public final static List<Listing> EXAMPLE_LISTINGS = List.of(
            BMW_X5,
            BMW_E60,
            A4_OLD,
            A4_NEW
    );

    public final static Map<String, List<Listing>> QUERY_TO_EXPECTED_RESULTS = Map.of(
            "brand = 'bmw'", List.of(BMW_X5, BMW_E60),
            "brand = 'bmw' | model = 'a4'", List.of(BMW_X5, BMW_E60, A4_OLD, A4_NEW),
            "year < 2002", List.of(BMW_X5, A4_OLD),
            "( brand = 'bmw' & model = 'x5' ) | ( brand = 'audi' & model = 'a4' & year < 2002 )", List.of(BMW_X5, A4_OLD)
    );

    public static void test(Searcher searcher) {
        QUERY_TO_EXPECTED_RESULTS.forEach((query, expected) -> test(searcher, query, expected));
    }

    private static void test(Searcher searcher, String query, List<Listing> expected) {
        try {
            List<Listing> result = searcher.search(EXAMPLE_LISTINGS, query);
            if (result.equals(expected)) {
                System.out.println("Query: " + query + " passed :)");
            } else {
                System.out.println("Query: " + query + " failed :(");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
            }
        } catch (Exception e) {
            System.out.println("Query: " + query + " failed with exception :(");
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Searcher searcher = new QuerySearcher();
        test(searcher);
    }
}
