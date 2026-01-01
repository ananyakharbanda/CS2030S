class Shape {
    public Shape() {
    }
    
    public void foo(int x) {
        System.out.println("calling base foo ");
    }
        
}


class Circle extends Shape {
    public Circle() {
    }
    
    @Override 
    public void foo(int x) {
        System.out.println("calling derived foo"); 
    }
}

class TestMain {
    public static void main(String[] args) {
        Shape s = new Circle();
        Shape s2 = new Shape();
        Circle c1 = new Circle();
        
        s.foo(1);
        s2.foo(2);
        c1.foo(3);
    }
}

