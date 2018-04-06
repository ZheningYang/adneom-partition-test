import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestPartitionService {

    private static PartitionService service;

    @BeforeClass
    public static void init() {
        service = new PartitionServiceImpl();
    }

    @Test
    public void shouldDoPartitionForList() {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        List<List<Integer>> output1 = service.partition(input, 2);
        List<List<Integer>> expectation1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Collections.singletonList(5));
        Assert.assertEquals(output1, expectation1);

        List<List<Integer>> output2 = service.partition(input, 3);
        List<List<Integer>> expectation2 = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        Assert.assertEquals(output2, expectation2);

        List<List<Integer>> output3 = service.partition(input, 1);
        List<List<Integer>> expectation3 = Arrays.asList(Collections.singletonList(1), Collections.singletonList(2),
                Collections.singletonList(3), Collections.singletonList(4), Collections.singletonList(5));
        Assert.assertEquals(output3, expectation3);

    }
}