package com.atomicprogramming.StatsBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Bot {
    public static final Logger logger = LoggerFactory.getLogger(Bot.class);

    public static String GetToken() {
        try {
            return Files.readString(Path.of("token.txt"));
        } catch (IOException error) {
            logger.error("Could not find token file!");
            return null;
        }
    }

    public static void CheckTokenFile() {
        File file = new File("token.txt");
        try {
            if (file.createNewFile()) {
                logger.info("Created token.txt file, please add the discord token and rerun the program!");
                System.exit(0);
            }
        } catch (IOException error) {
            logger.error(String.valueOf(error));
        }
    }

    public static void main(String[] args) {
        CheckTokenFile();
        String token = GetToken();
        if (token == null) {
            System.exit(1);
        }
        try {
            JDA jda = JDABuilder.createDefault(token)
                    .setActivity(Activity.playing("Stats Bot | Version 1.0.0")).build();
        }
        catch (LoginException error) {
            logger.error("Invalid or non-existent token!");
        }
    }
}
