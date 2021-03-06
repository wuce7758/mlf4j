/* 
 * Copyright (C) 2012-2014 TravelSky Technology Limited.
 * 
 * == Mlf4j (Monitoring Logging Facade for Java) ==
 * ============为监控而生的通用日志工具库===========
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Create by Zollty Tsou (zouty@travelsky.com, http://blog.csdn.net/zollty)
 */
package com.travelsky.mlf4j.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 * @author zollty
 * @since 2014-6-10
 */
public class ConsoleJdk14Logger extends Jdk14Logger {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2836404574562238891L;

    public ConsoleJdk14Logger(){
    }
    
    public ConsoleJdk14Logger(String name) {
        this.loggerName = name;
        this.log = LogManager.getLogManager().getLogger(name);
        if (this.log == null) {
            this.log = Logger.getLogger(name);
            Level level = getLevel();
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(level);
            log.addHandler(consoleHandler);
            log.setUseParentHandlers(false);// 不使用上级logger的Handler
            log.setLevel(level);
        }
    }
    
    @Override
    public com.travelsky.mlf4j.log.Logger newInstance(String name) {
        return new ConsoleJdk14Logger(name);
    }

}
