package com.study.corejava.agent;

import java.lang.instrument.Instrumentation;

public class AgentSimplTest {
    public static void permain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("per main ");

        System.out.println("hello"+agentArgs);
    }
}
