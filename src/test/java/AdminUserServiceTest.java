import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sinoxk.demo.Application;
import com.sinoxk.demo.dao.entity.AdminUser;
import com.sinoxk.demo.dao.mapper.AdminUserMapper;
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
public class AdminUserServiceTest {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Test
    public void test() {
        LambdaQueryWrapper<AdminUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminUser::getCustomerId, 1);
        System.out.println(JSON.toJSONString(adminUserMapper.selectList(queryWrapper)));
    }

}
