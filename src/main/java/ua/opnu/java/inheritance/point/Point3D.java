package ua.opnu.java.inheritance.point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Перевизначення setLocation для 3 координат
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    // Якщо викликається старий setLocation(int x, int y), z = 0
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public int getZ() {
        return z;
    }

    // Відстань до іншої точки 3D
    public double distance(Point3D p) {
        int dx = getX() - p.getX();
        int dy = getY() - p.getY();
        int dz = this.z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        int x = getX();
        int y = getY();
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
