package com.study.corejava.spi;

import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<Ishout> ishouts = ServiceLoader.load(Ishout.class);
        for (Ishout s :
                ishouts) {
            s.shout();
        }

    }
}
