import java.util.*;

class Solution {
    private String[][] arr;
    private boolean[][][] visited;
    private List<Integer> list;

    public int[] solution(String[] grid) {
        arr = new String[grid.length][grid[0].length()];
        visited = new boolean[grid.length][grid[0].length()][4];
        list = new ArrayList<>();

        // 2차원 배열에 저장
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                arr[i][j] = grid[i].substring(j, j + 1);
            }
        }

        // 3차원 배열에 방문여부 저장 (좌표 + 4방향)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        dfs(i, j, k, 0);
                    }
                }
            }
        }

        return list.stream().mapToInt(i -> i).sorted().toArray();
    }

    public void dfs(int i, int j, int k, int depth) {
        // 방문하지 않은 좌표 + 방향이면 dfs 실행
        // 방문한 좌표 + 방향이면 사이클 완성
        int di = i;
        int dj = j;
        int direction = k;
        while (!visited[di][dj][direction]) {
            visited[di][dj][direction] = true;
            // 방향에 따라 다음 좌표 설정
            if (direction == 0) {
                dj = (dj + 1) % visited[0].length;
            } else if (direction == 1) {
                di = (di + 1) % visited.length;
            } else if (direction == 2) {
                if (dj == 0) dj = visited[0].length - 1;
                else dj--;
            } else if (direction == 3) {
                if (di == 0) di = visited.length - 1;
                else di--;
            }

            // 다음 좌표의 문자에 따라 방향 전환
            if (arr[di][dj].equals("R")) direction = (direction + 1) % 4;
            else if (arr[di][dj].equals("L")) direction = (direction + 3) % 4;

            depth++;
        }

        list.add(depth);
    }
}
