import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunWithConsole {
    public static void main(String[] args) throws IOException{
        PartitionService service = new PartitionServiceImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input : ");
        String input = br.readLine();
        System.out.print("Output : " + service.process(input));

    }
}
