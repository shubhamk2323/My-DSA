class L15Stack {
    // properties
    public int[] arr;
    public int top;
    public int size;

    // behavior
    L15Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int element) {
        if (size - top > 1) {
            top++;
            arr[top] = element;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    void pop() {
        if (top >= 0) {
            top--;
        } else {
            System.out.println("Stack Underflow");
        }
    }

    int peek() {
        if (top >= 0)
            return arr[top];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    boolean isEmpty() {
        return top == -1;
    }


    public static void main(String[] args) {
        L15Stack st = new L15Stack(5);
        st.push(22);
        st.push(43);
        st.push(44);
        st.push(22);
        st.push(43);
        st.push(44);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        if(st.isEmpty()){
            System.out.println("Stack is Empty, my friend");
        }
        else{
            System.out.println("Stack is not Empty, my friend");
        }
    }
}