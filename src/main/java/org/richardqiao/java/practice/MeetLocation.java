package org.richardqiao.java.practice;

public class MeetLocation {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    MeetLocation ml = new MeetLocation();
    int[][] matrix = new int[][]{{1,0,0},
                                 {2,0,2},
                                 {1,2,0}};
    System.out.println(ml.meetLocation(matrix));
    //0, 2, 3,
    //0, 1, 4,
    //0, 6, 5,
    //1
  }

  //0: empty, 1: wall, 2:person
  private int meetLocation(int[][] matrix){
    int m = matrix.length;
    if(m == 0) return -1;
    int n = matrix[0].length;
    if(n == 0) return -1;
    int[][] map = new int[m][n];
    int empty = 0, visited = -1;
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(matrix[i][j] == 2){
          mark(map, i, j, matrix, 0, empty, visited);
          int tmp = empty;
          empty = visited;
          visited = tmp;
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        System.out.print(map[i][j] + ", ");
        if(map[i][j] == 0) continue;
        min = Math.min(min, map[i][j]);
      }
    }
    return min;
  }

  private void mark(int[][] map, int i, int j, int[][] matrix, int step, int empty, int visited){
    map[i][j] += step;
    matrix[i][j] = visited;
    if(i > 0 && matrix[i - 1][j] != visited && matrix[i - 1][j] != 1){
      mark(map, i - 1, j, matrix, step + 1, empty, visited);
    }
    if(i < map.length - 1 && matrix[i + 1][j] != visited && matrix[i + 1][j] != 1){
      mark(map, i + 1, j, matrix, step + 1, empty, visited);
    }
    if(j > 0 && matrix[i][j - 1] != visited && matrix[i][j - 1] != 1){
      mark(map, i, j - 1, matrix, step + 1, empty, visited);
    }
    if(j < matrix[0].length - 1 && matrix[i][j + 1] != visited && matrix[i][j + 1] != 1){
      mark(map, i, j + 1, matrix, step + 1, empty, visited);
    }
  }
}
