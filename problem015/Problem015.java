package problem015;

//Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
//How many such routes are there through a 20×20 grid?
		
public class Problem015 {

	public static void main(String[] args) {
		long[][] grid = new long[21][21];
		for (int i = 0; i < 21; i++) {
			grid[0][i] = 1;
			grid[i][0] = 1;
		}
		
		for (int x = 1; x < 21; x++) {
			for (int y = 1; y < 21; y++) {
				grid[y][x] = grid[y - 1][x] + grid[y][x - 1];
			}
		}
		
		System.out.println(grid[20][20]);
	}

}

//Answer: 137846528820
