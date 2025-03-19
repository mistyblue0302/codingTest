package week01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // key : 노드, value : 해당 노드와 연결된 노드
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>()); // 노드별 연결리스트 생성
        }

        // 연결상태 표시
        /** put() vs add()의 차이
         ** Map에서 새로운 key-value를 저장할 때는 put, List나 Set과 같은 컬렉션에서 값을 추가할때는 add
         */
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(map, visited, source, destination);
    }

    public boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int source, int destination) {

        if(source == destination) return true;

        visited[source] = true;
        for(int a : map.get(source)) {
            if(!visited[a]) {
                if(dfs(map, visited, a, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
