class MyInteger
{
    public MyInteger(int i)
    {
        myint = i;
    }

    int getMyInt()
    {
        return myint;
    }

    protected int myint;
    

    public static MyInteger valueOf(int i) {
        return new MyInteger(i);
    }
    
    public MyInteger plus(MyInteger rhs)
    {
        int temp = this.myint + rhs.myint;
        return new MyInteger(temp);
    }
}


class MyIntMain
{
    public static void main(String[] args)
    {
        double sum = 0.0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
    }
}
