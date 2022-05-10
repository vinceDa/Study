package com.ohyoung;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

/**
 * @author ouyb01
 * @date 2022/5/10 17:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private ICompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        Assert.assertNotNull(cd);
    }

}
