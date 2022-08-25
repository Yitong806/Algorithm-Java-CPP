import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public class Leet0836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean xIntersection = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
        boolean yIntersection = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);

        return xIntersection && yIntersection;

    }
}
