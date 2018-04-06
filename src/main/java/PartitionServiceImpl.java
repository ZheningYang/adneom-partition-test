import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class PartitionServiceImpl implements PartitionService {

    public PartitionServiceImpl() {
    }

    @Override
    public List<List<Integer>> partition(List<Integer> list, int factor) {

        // guava can safe my time and call it a game, but it's less fun
//         return Lists.partition(list, factor);

        List<List<Integer>> result = new ArrayList<>();

        int remains = list.size() % factor;
        for (int i = 0; i < list.size() - remains; i += factor) {
            result.add(list.subList(i, i + factor));
        }
        if (remains > 0) {
            result.add(list.subList(list.size() - remains, list.size()));
        }

        return result;
    }
}
