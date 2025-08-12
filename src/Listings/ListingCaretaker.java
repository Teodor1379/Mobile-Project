package Listings;



import java.util.Stack;

import java.util.List       ;
import java.util.ArrayList  ;

import java.util.stream.Collectors;


public class ListingCaretaker {
    // Later optimization: Maybe use List in
    // order to avoid buffer stacks entities.

    private final Stack<ListingMemento> history;



    public ListingCaretaker() {
        this.history = new Stack<>();
    }



    public void add(ListingMemento memento) {
        this.history.push(memento);
    }



    public List<Listing> getHistory() {
        return this.history.stream().map(ListingMemento::getSnapshot).collect(Collectors.toList());
    }



    public ListingMemento get() {
        return this.get(1);
    }



    public ListingMemento get(Integer times) {
        if (times > this.history.size()) {
            throw new RuntimeException();
        }

        Stack<ListingMemento> buffer = new Stack<>();

        ListingMemento current = null;

        while (times > 0 && !this.history.isEmpty()) {
            buffer.push(this.history.pop());

            times = times - 1;
        }

        if (!this.history.isEmpty()) {
            current = this.history.peek();
        }

        while (!buffer.isEmpty()) {
            this.history.push(buffer.pop());
        }

        return current;
    }
}
