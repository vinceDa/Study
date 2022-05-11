package com.ohyoung.base;

import com.ohyoung.dependence.CDPlayer;
import com.ohyoung.dependence.IMediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ouyb01
 * @date 2022/5/10 17:16
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public ICompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public IMediaPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

}
