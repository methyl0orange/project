import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * google guava 布隆过滤器的使用
 */
public class BloomFilterTest {
    private static final int insertions = 1000000;// 100万

    public static void main(String[] args) {
        // 初始化一个存储string数据的布隆过滤器,默认fpp（误差率） 0.03
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions);

        Set<String> set = new HashSet<String>(insertions);
        List<String> list = new ArrayList<String>(insertions);

        for (int i = 0; i < insertions; i++) {
            String uuid = UUID.randomUUID().toString();
            bf.put(uuid);
            set.add(uuid);
            list.add(uuid);
        }

        int wrong = 0; // 布隆过滤器误判的次数
        int right = 0;// 布隆过滤器正确次数

        for (int i = 0; i < 10000; i++) {
            String str = i % 100 == 0 ? list.get(i / 100) : UUID.randomUUID().toString();
            if (bf.mightContain(str)) {
                if (set.contains(str)) {
                    right++;
                } else {
                    wrong++;
                }
            }
        }

        //right 为100
        System.out.println("right:" + right);
        //因为误差率为3%，所以一万条数据wrong的值在300左右
        System.out.println("wrong:" + wrong);
    }

}

