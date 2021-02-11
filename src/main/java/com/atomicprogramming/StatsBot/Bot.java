package com.atomicprogramming.StatsBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class Bot {
    public static final String token = "";
    public static final Logger logger = LoggerFactory.getLogger(Bot.class);
    public static void main(String[] args) {
        try {
        JDA jda = JDABuilder.createDefault(token).build();
        }
        catch (LoginException error) {
            logger.error("Invalid or non-existent token!");
        }
    }
}
