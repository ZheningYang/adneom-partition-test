import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PartitionServiceImpl implements PartitionService {

    public PartitionServiceImpl() {
    }

    @Override
    public String process(String input) {
        input = peeling(input);
        Integer factor = findFactor(input);
        List<Integer> list = findData(input);

        return print(list, factor);
    }

    private String peeling(String input) {
        Matcher inputMatcher = Pattern.compile("\\((.*?)\\)").matcher(input);
        while (inputMatcher.find()) {
            input = inputMatcher.group(1);
        }
        return input;
    }

    private Integer findFactor(String input) {
        Integer factor = null;
        Matcher factorMatcher = Pattern.compile("[0-9]+$").matcher(input);
        if (factorMatcher.find()) {
            factor = Integer.parseInt(factorMatcher.group());
        }
        return factor;
    }

    private List<Integer> findData(String input) {
        List<Integer> list = new ArrayList<>();
        Matcher numbersMatcher = Pattern.compile("\\[(.*?)\\]").matcher(input);
        if (numbersMatcher.find()) {
            Pattern pattern = Pattern.compile("\\s*,\\s*");
            list = pattern.splitAsStream(numbersMatcher.group(1)).map(Integer::valueOf).collect(Collectors.toList());
        }
        return list;
    }

    private String print(List<Integer> list, Integer factor) {
        StringBuilder sb = new StringBuilder();

        int remains = list.size() % factor;
        String prefix = "";
        for (int i = 0; i < list.size() - remains; i += factor) {
            sb.append(prefix);
            prefix = ", ";
            sb.append(list.subList(i, i + factor).toString().replace(" ", ""));
        }
        if (remains > 0) {
            sb.append(", " + list.subList(Math.max(list.size() - remains, 0), list.size()).toString().replace(" ", ""));
        }
        return "[ " + sb.toString() + " ]";
    }
}
