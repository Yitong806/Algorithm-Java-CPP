import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class P1518 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);
        char[][] map = new char[10][];
        for (int i = 0; i < 10; i++) {
            map[i] = fastReader.next().toCharArray();
        }

        fastWriter.println(running(map));

        fastReader.close();
        fastWriter.close();
    }

    private static int running(char[][] map) {
        int cX = 0, cY = 0;
        int fX = 0, fY = 0;
        char cDirection = 'U', fDirection = 'U';

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 'C') {
                    cX = i;
                    cY = j;

                } else if (map[i][j] == 'F') {
                    fX = i;
                    fY = j;

                }
            }
        }

        int minute = 0;
        List<LocationPair> locationPairSet = new ArrayList<>();

        while (!(fX == cX && fY == cY)) {
            Location cLocation = new Location(cX, cY, cDirection);
            Location fLocation = new Location(fX, fY, fDirection);
            LocationPair cf = new LocationPair(cLocation, fLocation);
            if(locationPairSet.contains(cf)){
                return 0;
            }
            locationPairSet.add(cf);

            Object[] fMove = move(map, fX, fY, fDirection);
            Object[] cMove = move(map, cX, cY, cDirection);

            cX = (int) cMove[0];
            cY = (int) cMove[1];
            cDirection = (char) cMove[2];

            fX = (int) fMove[0];
            fY = (int) fMove[1];
            fDirection = (char) fMove[2];

            minute++;
        }

        return minute;
    }

    private static Object[] move(char[][] map, int x, int y, char dir) {
        if (dir == 'U') {
            x--;
            if (rangeInvalid(map, x, y)) {
                x++;
                dir = 'R';

            }
        } else if (dir == 'R') {
            y++;
            if (rangeInvalid(map, x, y)) {
                y--;
                dir = 'D';
            }
        } else if (dir == 'D') {
            x++;
            if (rangeInvalid(map, x, y)) {
                x--;
                dir = 'L';
            }
        } else {
            y--;
            if (rangeInvalid(map, x, y)) {
                y++;
                dir = 'U';
            }
        }
        return new Object[]{x, y, dir};
    }

    private static boolean rangeInvalid(char[][] map, int x, int y) {
        return (0 > x || x >= 10) || (0 > y || y >= 10) || map[x][y] == '*';
    }

    private static class LocationPair{
        private final Location location1;
        private final Location location2;

        public LocationPair(Location location1, Location location2){
            this.location1 = location1;
            this.location2 = location2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LocationPair that = (LocationPair) o;
            return Objects.equals(location1, that.location1) && Objects.equals(location2, that.location2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(location1, location2);
        }

        @Override
        public String toString() {
            return "LocationPair{" +
                    "location1=" + location1 +
                    ", location2=" + location2 +
                    '}';
        }
    }

    private static class Location {
        private final char dir;
        private final int x;
        private final int y;

        public Location(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return dir == location.dir && x == location.x && y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dir, x, y);
        }

        @Override
        public String toString() {
            return "Location{" +
                    "dir=" + dir +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class FastReader implements Closeable {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in), 16384);
            eat("");
        }

        private void eat(String s) {
            st = new StringTokenizer(s);
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!st.hasMoreTokens()) {
                String s = nextLine();
                if (s == null) return false;
                eat(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        public void close() {
            try {
                st = null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

        }
    }

    private static class FastWriter implements Closeable {
        private final PrintWriter writer;

        public FastWriter(OutputStream out) {
            this.writer = new PrintWriter(out);
        }

        public void print(Object object) {
            writer.write(object.toString());
        }

        public void printf(String format, Object... os) {
            writer.write(String.format(format, os));
        }

        public void println() {
            writer.write(System.lineSeparator());
        }

        public void println(Object object) {
            writer.write(object.toString());
            writer.write(System.lineSeparator());
        }

        @Override
        public void close() {
            writer.close();
        }
    }
}
