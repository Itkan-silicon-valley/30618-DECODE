package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.RobotLog;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    private File logFile;

    public FileLogger(String filename) {
        // Stored in /sdcard/FIRST/settings/
        logFile = AppUtil.getInstance().getSettingsFile(filename);

        // Optional: Start with header
        write("===== NEW LOG STARTED =====");
    }

    // Writes one line to the file
    public void write(String text) {
        try {
            FileWriter writer = new FileWriter(logFile, true);
            writer.write(text + "\n");
            writer.close();
        } catch (IOException e) {
            RobotLog.ee("FileLogger", "Write failed: " + e.toString());
        }
    }

    // If needed, expose the file path
    public String getFilePath() {
        return logFile.getAbsolutePath();
    }
}
