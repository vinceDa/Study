package com.ohyoung;

import com.ohyoung.base.CDPlayerConfig;
import com.ohyoung.base.ICompactDisc;
import com.ohyoung.dependence.IMediaPlayer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ouyb01
 * @date 2022/5/10 17:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {


    @Autowired
    private ICompactDisc cd;

    @Autowired
    private IMediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        Assert.assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
    }

}
