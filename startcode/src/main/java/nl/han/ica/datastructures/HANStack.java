package nl.han.ica.datastructures;

import java.util.ArrayList;
import java.util.List;

public class HANStack<T> implements IHANStack<T> {
    private final List<T> list = new ArrayList<>();

    /**
     * pushes value T to the top of the stack
     *
     * @param value value to push
     */
    @Override
    public void push(T value) {
        list.addFirst(value);
    }

    /**
     * Pops (and removes) value at top of stack
     *
     * @return popped value
     */
    @Override
    public T pop() {
        return list.removeFirst();
    }

    /**
     * Peeks at the top of the stack. Does not remove anything
     *
     * @return value at the top of the stack
     */
    @Override
    public T peek() {
        return list.getFirst();
    }
}
