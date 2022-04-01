public class MyStack<T> {

    private MyArrayList<T> list;

    public MyStack() {

        this.list = new MyArrayList<T>();

    }
 
    public void push(T element) {

        list.add(element);

    }

    public T pop() {

        return list.remove(list.size()-1);

    }

    public boolean isEmpty() {

        return list.isEmpty();

    }

    public T peek() {

        return list.get(list.size()-1);

    }

    public int size(){
        return list.size();
    }

    @Override
    public boolean equals(Object otherStack) {

        if (otherStack instanceof MyStack) {
            MyStack os = (MyStack)otherStack;
            if (list.size() != os.list.size()) {
                return false; // stacks of different sizes can't possibly be equal
            }
            return this.list.equals(os.list);
        }
        return false;
    }
}//END CLASS
