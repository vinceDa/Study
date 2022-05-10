package com.ohyoung;

import org.springframework.stereotype.Component;

/**
 * @author ouyb01
 * @date 2022/5/10 17:14
 */
@Component
public class SgtPeppers implements ICompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";

    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing" + title + "by" + artist);
    }

}
