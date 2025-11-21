package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * This is the actual Autonomous OpMode for the BLUE alliance for the DECODE season. It extends the
 * BaseAutonomous class, inheriting all of its hardware and action methods.
 */
@Autonomous(name = "Blue Auto", group = "Robot")
public class BlueAuto extends BaseAutonomous {

    /**
     * Constructor for the Blue Autonomous. It calls the constructor of the parent class
     * (BaseAutonomous) and provides the alliance-specific values for the DECODE game.
     */
    public BlueAuto() {
        // Pass the Blue Alliance Goal AprilTag ID (20) and the starting position boolean.
        super(20, false);
    }

    // All the main logic is in the BaseAutonomous class.
    // This class can be left empty unless a behavior unique to the Blue alliance is needed.
}
