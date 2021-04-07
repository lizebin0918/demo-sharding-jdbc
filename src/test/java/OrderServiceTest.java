import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoxk.demo.Application;
import com.sinoxk.demo.dao.entity.Order;
import com.sinoxk.demo.dao.mapper.OrderMapper;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <br/>
 * Created on : 2020-05-22 16:05
 * @author chenpi 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderServiceTest {

    @Resource
    private ShardingDataSource shardingDataSource;

    /*@Resource
    private OrderMapper orderMapper;*/

    @Test
    public void test() {
        System.out.println(shardingDataSource);
        LambdaQueryWrapper<Order> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Order::getCustomerId, 2).eq(Order::getYear, 2016);
        System.out.println("------------------------------");
        //System.out.println(JSON.toJSONString(orderMapper.selectList(queryWrapper)));
        System.out.println("------------------------------");
    }

}
