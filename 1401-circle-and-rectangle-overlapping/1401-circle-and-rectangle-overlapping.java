class Solution { // tc and sc is O(1)
    public boolean checkOverlap(
            int radius,
            int xCenter,
            int yCenter,
            int x1,
            int y1,
            int x2,
            int y2) {

        // Closest x-coordinate in rectangle to circle center
        int closestX = Math.max(x1, Math.min(xCenter, x2));

        // Closest y-coordinate in rectangle to circle center
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Distance from circle center to closest point
        int dx = closestX - xCenter;
        int dy = closestY - yCenter;

        // Compare squared distances
        return dx * dx + dy * dy <= radius * radius;
    }
}