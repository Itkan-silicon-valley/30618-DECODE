package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * This is the actual Autonomous OpMode for the RED alliance for the DECODE season.
 * It extends the BaseAutonomous class, inheriting all of its hardware and action methods.
 */
@Autonomous(name = "Red Auto", group = "Robot")
public class RedAuto extends BaseAutonomous {

    /**
     * Constructor for the Red Autonomous.
     * It calls the constructor of the parent class (BaseAutonomous) and provides
     * the alliance-specific values for the DECODE game.
     */
    public RedAuto() {
        // Pass the Red Alliance Goal AprilTag ID (24) and the starting position boolean.
        super(24, false);
    }

    // All the main logic is in the BaseAutonomous class.
    // This class can be left empty unless a behavior unique to the Red alliance is needed.
}
