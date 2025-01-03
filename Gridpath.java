
public class GridPath {
    public GridPath(int[][] values)
    {
        grid = values;
    }

    public String toString()
    {
        String s = "";
        for (int row[]: grid)
        {
            for (int col: row)
            {
                s += col + " ";
            }
            s += "\n";
        }
        return s;
    }

    private int[][] grid;

    public Location getNextLoc(int row, int col) {
        int below = 100;
        if (row < grid.length - 1) below = grid[row+1][col];
        int right = 100;
        if (col < grid[0].length - 1) right = grid[row][col+1];
        if (below < right) return new Location(row+1, col);
        else return new Location (row, col+1);
    }

    public int sumPath(int row, int col) {
        int sum = grid[row][col];
        while (row < grid.length - 1 || col < grid[0].length - 1)
        {
            Location loc = getNextLoc(row, col);
            row = loc.getRow();
            col = loc.getCol();
            sum += grid[row][col];
        }
        return sum;
    }
}
