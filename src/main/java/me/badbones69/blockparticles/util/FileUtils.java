package me.badbones69.blockparticles.util;

import com.google.common.io.ByteStreams;
import me.badbones69.blockparticles.SettingsManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class FileUtils {

    private FileUtils() {
    }

    public static void copyFileFromJar(String resourceName, File outputFile) throws IOException {
        try (InputStream inputStream = SettingsManager.class.getResourceAsStream("/" + resourceName);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            ByteStreams.copy(inputStream, outputStream);
        }
    }
}
