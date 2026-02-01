#!/bin/bash

if [ -z "$1" ]; then
  echo "Usage: ./create_problem.sh leetcode/_0XXX_problem_name"
  exit 1
fi

TASK_DIR="${1//-/_}"
TASK_PKG="${TASK_DIR//\//.}"
BASE_MAIN="src/main/java/com/serheev/${TASK_DIR}"
BASE_TEST="src/test/java/com/serheev/${TASK_DIR}"

# Create directories
mkdir -p "$BASE_MAIN"
mkdir -p "$BASE_TEST"

# Create Solution.java
cat > "${BASE_MAIN}/Solution.java" <<EOF
package com.serheev.${TASK_PKG};

/**
 * Problem:
 * URL:
 * <p>
 * Description:
 * <p>
 * Constraints:
 * <p>
 * Examples:
 * <p>
 * Categories:
 * -
 */
public class Solution {

     /**
     * Approach:
     *
     * <p>
     * Idea:
     *
     * <p>
     * Complexity:
     * Time: O()
     * Space: O()
     *
     * @param s input string
     * @return int
     */
    public int placeholder_optimal_solution(String s) {
        // TODO: implement solution

        return 0;
    }

     /**
     * Approach:
     *
     * <p>
     * Idea:
     *
     * <p>
     * Complexity:
     * Time: O()
     * Space: O()
     *
     * @param s input string
     * @return int
     */
    public int placeholder_brute_force(String s) {
        // TODO: implement solution

        return 0;
    }
}
EOF

# Create SolutionTest.java
cat > "${BASE_TEST}/SolutionTest.java" <<EOF
package com.serheev.${TASK_PKG};

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("")
    void testPlaceholder() {
        // TODO: add tests
    }
}
EOF

echo "Task created:"
echo "  - ${BASE_MAIN}/Solution.java"
echo "  - ${BASE_TEST}/SolutionTest.java"
