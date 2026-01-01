class Shape {
}


class TestMain {
    public float findMaxArea(Shape[] shapes) {
        float maxArea = 0.0f;
        for (Shape aShape : shapes) {
            if (aShape.getArea() > maxArea) {
                maxArea = aShape.getArea();
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
    }
}

