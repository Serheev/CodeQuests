package com.serheev.leetcode._0207_course_schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: 207. Course Schedule (medium)
 * URL: https://leetcode.com/problems/course-schedule/
 * <p>
 * Description:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
 * bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 * <p>
 * Categories:
 * - Graphs
 */
public class Solution {

    /**
     * Determines whether all courses can be finished given prerequisite pairs.
     * Each pair [a, b] means: to take course a, you must first take course b.
     * <p>
     * Approach (Kahn's Algorithm - BFS Topological Sort):
     * 1. Build a directed graph using adjacency lists.
     * 2. Compute in-degrees for all nodes (how many prerequisites each course has).
     * 3. Push all nodes with in-degree 0 into a queue — these have no prerequisites.
     * 4. Repeatedly remove nodes from the queue:
     * - Count how many courses we can process.
     * - For each neighbor, reduce its in-degree.
     * - If a neighbor's in-degree becomes 0, push it into the queue.
     * 5. If we processed all courses, no cycle exists → return true.
     * Otherwise, a cycle prevents completion → return false.
     * <p>
     * Complexity:
     * Time: O(V + E), where V = numCourses, E = number of prerequisite pairs.
     * Space: O(V + E) for adjacency list and in-degree array.
     *
     * @param numCourses    total number of courses labeled 0..numCourses-1
     * @param prerequisites prerequisite pairs [course, prerequisite]
     * @return true if all courses can be completed, false if a cycle exists
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processed = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            processed++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return processed == numCourses;
    }
}
