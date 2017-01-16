package org.richardqiao.leetcode;

import java.util.LinkedList;

public class ShortestDistanceBuildings {

	public static void main(String[] args) {
		int[][] grid = new int[][]{{1,0,2,0,1,2,0,2},
								   {0,0,0,0,0,2,0,0},
								   {0,0,1,0,0,2,0,0},
								   {0,2,0,0,0,2,0,0},
								   {0,2,0,0,0,0,0,0}};
		System.out.println(shortestDist(grid));
	}
	//0: empty, 1: building, 2: obstacle
	static int shortestDist(int[][] grid){
		int min = 0;
		int m = grid.length;
		if(m == 0) return -1;
		int n = grid[0].length;
		int[][] dist = new int[m][n];
		int empty = 0, build = 1;
		LinkedList<int[]> queue = new LinkedList<int[]>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == build){
					queue.addLast(new int[]{i, j});
					int mark = empty == 0 ? 3 : 0;
					int mark_build = build == 1 ? 4 : 1;
					int step = 0;
					int min_point = Integer.MAX_VALUE;
					grid[i][j] = mark_build;
					while(!queue.isEmpty()){
						int size = queue.size();
						while(size-- > 0){
							int[] xy = queue.pollFirst();
							int x = xy[0], y = xy[1];
							dist[x][y] += step;
							min_point = Math.min(min_point, dist[x][y]);
							for(int k = x - 1; k < x + 2; k++){
								for(int l = y - 1; l < y + 2; l++){
									if((k == x || l == y) && k >= 0 && k < m && l >= 0 && l < n && (grid[k][l] == empty || grid[k][l] == build)){
										if(grid[k][l] == empty){
											grid[k][l] = mark;
										}else{
											grid[k][l] = mark_build;
										}
										queue.addLast(new int[]{k, l});
									}
								}
							}
						}
						step++;
					}
					empty = mark;
					build = mark_build;
					min = min_point;
				}
			}
		}
		return min;
	}
}
