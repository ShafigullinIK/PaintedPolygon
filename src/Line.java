public class Line {
    private double k;
    private double b;

    public Line(double k, double b){
        this.k = k;
        this.b = b;
    }

    public int positionOfPoint(Point p){
        int pointX = p.getX();
        int pointY = p.getY();
        double lineY = valueOfLine(pointX);
        if(pointY > lineY) {
            return 1;
        }
        if(pointX == lineY){
            return 0;
        }
        return -1;
    }

    public double valueOfLine(double x){
        return k*x + b;
    }
}
