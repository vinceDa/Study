package com.ohyoung.dependence;

import com.ohyoung.base.ICompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ouyb01
 * @date 2022/5/10 17:34
 */
@Component
public class CDPlayer implements IMediaPlayer {

    private final ICompactDisc cd;

    @Autowired
    public CDPlayer(ICompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
