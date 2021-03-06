package sort;/*
 * Date: 06.09.13 13:27
 * Author: ivan.bendyna
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSortRandomArrays.class,
        TestSortStability.class,
        TestSortTime.class,
        TestSortBoundary.class,
        TestSortReversedSequence.class,
        TestSortExceptions.class})
public class AllTests {

}
