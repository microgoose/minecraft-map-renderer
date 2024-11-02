package net.minecountry.common;

import java.util.HashMap;
import java.util.Map;

public class PointsMap<Element> {
    private final Map<Point, Element> map = new HashMap<>();
    private int minX = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxY = Integer.MIN_VALUE;

    public void set(Point point, Element value) {
        if (minX > point.getX())
            minX = point.getX();
        if (maxX < point.getX())
            maxX = point.getX();
        if (minY > point.getY())
            minY = point.getY();
        if (maxY < point.getY())
            maxY = point.getY();

        map.put(point, value);
    }

    public void set(int x, int y, Element value) {
        set(new Point(x, y), value);
    }

    public Element get(Point point) {
        return map.get(point);
    }

    public Element get(int x, int y) {
        return get(new Point(x, y));
    }

    public Map<Point, Element> getMap() {
        return map;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinX() {
        return minX;
    }

    public int getWidth() {
        return (maxX - minX) + 1;
    }

    public int getHeight() {
        return (maxY - minY) + 1;
    }
}
