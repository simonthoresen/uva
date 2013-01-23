import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Problem556 {

    final static Vector2 EAST = new Vector2(1, 0);
    final static Vector2 WEST = new Vector2(-1, 0);
    final static Vector2 NORTH = new Vector2(0, -1);
    final static Vector2 SOUTH = new Vector2(0, 1);

    private static class Vector2 {

        final int x;
        final int y;

        Vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Vector2 add(Vector2 val) {
            return new Vector2(x + val.x, y + val.y);
        }
    }

    Vector2 turnLeft(Vector2 dir) {
        if (dir == NORTH) {
            return WEST;
        } else if (dir == WEST) {
            return SOUTH;
        } else if (dir == SOUTH) {
            return EAST;
        } else {
            return NORTH;
        }
    }

    Vector2 turnRight(Vector2 dir) {
        if (dir == NORTH) {
            return EAST;
        } else if (dir == EAST) {
            return SOUTH;
        } else if (dir == SOUTH) {
            return WEST;
        } else {
            return NORTH;
        }
    }

    void solve(int[][] maze) {
        Vector2 end = new Vector2(0, maze.length - 1);
        Vector2 dir = EAST;
        Vector2 prev = end;
        while (true) {
            Vector2 next = prev.add(dir);
            if (next.x < 0 || next.x >= maze[0].length ||
                next.y < 0 || next.y >= maze.length ||
                maze[next.y][next.x] < 0) {
                dir = turnLeft(dir);
            } else {
                ++maze[next.y][next.x];
                if (next.x == end.x && next.y == end.y) {
                    break;
                }
                prev = next;
                dir = turnRight(dir);
            }
        }
    }

    public Problem556(InputStream ins, PrintStream out) {
        Scanner in = new Scanner(ins);
        while (true) {
            int yMax = in.nextInt();
            int xMax = in.nextInt();
            if (yMax == 0 && xMax == 0) {
                break;
            }
            if (yMax == 1 && xMax == 1) {
                out.println("  1  0  0  0  0");
                continue;
            }
            int[][] maze = new int[yMax][];
            for (int y = 0; y < yMax; ++y) {
                maze[y] = new int[xMax];
                String str = in.next();
                for (int x = 0; x < xMax; ++x) {
                    maze[y][x] = str.charAt(x) == '1' ? -1 : 0;
                }
            }
            solve(maze);
            int[] buckets = new int[] { 0, 0, 0, 0, 0 };
            for (int y = 0; y < yMax; ++y) {
                for (int x = 0; x < xMax; ++x) {
                    int bucket = maze[y][x];
                    if (bucket < 0) {
                        continue;
                    }
                    ++buckets[bucket];
                }
            }
            out.format("%3d%3d%3d%3d%3d\n", buckets[0], buckets[1], buckets[2], buckets[3], buckets[4]);
        }
    }

    public static void main(String[] args) {
        new Main(System.in, System.out);
    }

    public static class TestCase {

        @org.junit.Test
        public void requireThatOutputMatches() throws Exception {
            Main.assertOutput("3 5\n" +
                              "01010\n" +
                              "01010\n" +
                              "00000\n" +
                              "1 1\n" +
                              "0\n" +
                              "0 0",
                              "  2  3  5  1  0\n" +
                              "  1  0  0  0  0\n");
        }
    }
}
