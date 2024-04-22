package zest;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.IntegerArbitrary;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {


    @Test
    void nonPositiveNumCourses() { //T1
        int numCourses = 0;
        int[][] prerequisites = new int[][]{{1, 0}};
        Exception exception = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites));
        assertEquals("Invalid numCourses.", exception.getMessage());
    }

    @Test
    void InvalidFormatPrerequisite() { //T2
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 1, 1}};
        Exception exception = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites));
        assertEquals("Invalid prerequisite.", exception.getMessage());
    }

    @Test
    void NegativeNumbersPrerequisite() { //T3
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, -1}};
        Exception exception = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites));
        assertEquals("Invalid prerequisite.", exception.getMessage());
        int[][] prerequisites1 = new int[][]{{-1, 1}};
        Exception exception1 = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites1));
        assertEquals("Invalid prerequisite.", exception1.getMessage());
    }

    @Test
    void TooBigNumbersPrerequisite() { //T4
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{3, 2}};
        Exception exception = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites));
        assertEquals("Invalid prerequisite.", exception.getMessage());
        int[][] prerequisites1 = new int[][]{{2, 3}};
        Exception exception1 = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites1));
        assertEquals("Invalid prerequisite.", exception1.getMessage());
    }

    @Test
    void SelfPrerequisite() { //T5
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{0, 0}};
        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void CyclePrerequisite() { //T6
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void EmptyPrerequisite() { //T7
        int numCourses = 2;
        int[][] prerequisites = new int[][]{};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void DuplicatePrerequisite() { //T8
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void OnePrerequisiteValid() { //T9
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void ManyPrerequisiteValid() { //T10
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{4, 3}, {3, 2}, {2, 1}, {1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void ManyPrerequisiteInvalid() { //T11
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{4, 3}, {3, 2}, {2, 1}, {1, 0}, {0, 4}};
        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void BigNumCourses() { //T12
        int numCourses = 10000000;
        int[][] prerequisites = new int[][]{{1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void BigPrerequisite() { //T13
        int numCourses = 1000;
        int[][] prerequisites = new int[numCourses - 1][];

        for (int i = 0; i < numCourses - 1; i++) {
            prerequisites[i] = new int[]{i + 1, i};
        }

        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void BigPrerequisiteCycle() { //T14
        int numCourses = 1000;
        int[][] prerequisites = new int[numCourses][];

        for (int i = 0; i < numCourses - 1; i++) {
            prerequisites[i] = new int[]{i + 1, i};
        }
        prerequisites[999] = new int[]{0, 999};

        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void ManyPrerequisiteForOneCourse() { //T15
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{4, 3}, {4, 2}, {4, 1}, {4, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void OnePrerequisiteForManyCourse() { //T16
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void preConditionNumCourse() { //T1 and T9
        int numCourses = 0;
        int[][] prerequisites = new int[][]{{1, 0}};
        Exception exception = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites));
        assertEquals("Invalid numCourses.", exception.getMessage());

        int numCourses1 = 2;
        assertTrue(CourseSchedule.canFinish(numCourses1, prerequisites));
    }

    @Test
    void preConditionPrerequisite() {

        //T1
        int numCourses = 0;
        int[][] prerequisites = new int[][]{{1, 0}};
        Exception exception = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses, prerequisites));
        assertEquals("Invalid numCourses.", exception.getMessage());

        // T2
        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{{1, 1, 1}};
        Exception exception1 = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses2, prerequisites2));
        assertEquals("Invalid prerequisite.", exception1.getMessage());

        // T3
        int numCourses3 = 2;
        int[][] prerequisites3 = new int[][]{{1, -1}};
        Exception exception2 = assertThrows(RuntimeException.class, () -> CourseSchedule.canFinish(numCourses3, prerequisites3));
        assertEquals("Invalid prerequisite.", exception2.getMessage());

        // T5
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses1, prerequisites1));

        // T6
        int numCourses4 = 2;
        int[][] prerequisites4 = new int[][]{{0, 0}};
        assertFalse(CourseSchedule.canFinish(numCourses4, prerequisites4));

        // T10
        int numCourses5 = 5;
        int[][] prerequisites5 = new int[][]{{4, 3}, {3, 2}, {2, 1}, {1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses5, prerequisites5));

    }


    @Test
    void postCondition() { //T11 and T12
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{4, 3}, {3, 2}, {2, 1}, {1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));

        prerequisites = new int[][]{{4, 3}, {3, 2}, {2, 1}, {1, 0}, {0, 4}};
        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }

    @Test
    void invariant() { //T17
        int numCourses = 3;
        int[][] prerequisites = new int[][]{};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));

        prerequisites = new int[][]{{1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));

        prerequisites = new int[][]{{2, 1}, {1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));

        prerequisites = new int[][]{{2, 1}, {1, 0}};
        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));

        prerequisites = new int[][]{{0, 2}, {2, 1}, {1, 0}};
        assertFalse(CourseSchedule.canFinish(numCourses, prerequisites));
    }


    // Tests for property-based testing
    @Property
    //@Report(Reporting.GENERATED)
    void arrayIsSorted(
            @ForAll
            @IntRange(max = 100) int numPrerequisite,
            @ForAll
            @IntRange(min = 2, max = 200) int numCourses
    ) {

        int[][] prerequisites = new int[numPrerequisite][2];

        for (int i = 0; i< numPrerequisite; i++) {
            Random random = new Random();
            int lower = random.nextInt(numCourses-1 - 0) + 0;
            int upper = random.nextInt(numCourses-2 - lower+1) + lower+1;

            prerequisites[i][0] = lower;
            prerequisites[i][1] = upper;
        }

        assertTrue(CourseSchedule.canFinish(numCourses, prerequisites));
    }
}