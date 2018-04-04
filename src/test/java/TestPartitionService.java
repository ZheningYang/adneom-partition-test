import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPartitionService {

    private static PartitionService service;

    @BeforeClass
    public static void init(){
        service = new PartitionServiceImpl();
    }

    @Test
    public void shouldDoPartition() {
        String input1 = "partition([1,2,3,4,5], 2)";
        String input2 = "partition([1,2,3,4,5], 3)";
        String input3 = "partition([1,2,3,4,5], 1)";
        String output1 = service.process(input1);
        String output2 = service.process(input2);
        String output3 = service.process(input3);
        Assert.assertEquals(output1, "[ [1,2], [3,4], [5] ]");
        Assert.assertEquals(output2, "[ [1,2,3], [4,5] ]");
        Assert.assertEquals(output3, "[ [1], [2], [3], [4], [5] ]");


    }
}