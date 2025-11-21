package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is an ABSTRACT class that contains all the common functionality for our autonomous modes. It
 * is not a real OpMode that can be run on its own. Instead, other classes like "BlueAuto" and
 * "RedAuto" will EXTEND this class.
 *
 * <p>It defines the robot's hardware and common action methods, but requires specific values
 * (aprilTagId and closeToGoal) to be provided by its subclasses.
 */
public abstract class BaseAutonomous extends LinearOpMode {

    // -----------------------------------------
    // --- CLASS MEMBERS (VARIABLES) ---
    // -----------------------------------------

    /* Declare Drive Motors */
    protected DcMotor leftFrontDrive = null;
    protected DcMotor rightFrontDrive = null;
    protected DcMotor leftBackDrive = null;
    protected DcMotor rightBackDrive = null;

    /* Declare OpMode members. */
    protected ElapsedTime runtime = new ElapsedTime();

    // --- These are the values that each specific Autonomous class MUST provide ---
    protected int targetAprilTagId;
    protected boolean isCloseToGoal;

    /**
     * The constructor for this abstract class.
     *
     * @param aprilTagId The alliance-specific AprilTag ID to look for (e.g., 20 for Blue, 24 for
     *     Red).
     * @param closeToGoal A boolean indicating the starting position.
     */
    public BaseAutonomous(int aprilTagId, boolean closeToGoal) {
        this.targetAprilTagId = aprilTagId;
        this.isCloseToGoal = closeToGoal;
    }

    /**
     * This is the main entry point for the autonomous mode. It runs once when "START" is pressed.
     */
    @Override
    public void runOpMode() {

        // --- INITIALIZATION ---
        initializeHardware();

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized for DECODE");
        telemetry.addData("Alliance AprilTag ID", targetAprilTagId);
        telemetry.addData("Position Boolean", isCloseToGoal);
        telemetry.update();

        waitForStart();
        runtime.reset();

        // --- AUTONOMOUS SEQUENCE ---
        // This is the sequence of actions the robot will perform.

        // Step 1: Shoot the pre-loaded artifact.
        shootArtifacts();

        // Step 2: Drive to a scoring line.
        driveToLine(1); // Example: drive to the first line

        // Step 3: Perform an action on the line.
        grabLine();

        // Step 4: Drive to the main shooting area.
        driveToShootingArea();

        // Step 5: Shoot more artifacts.
        shootArtifacts();

        // --- COMPLETION ---
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000); // Pause to display the final message.
    }

    // -----------------------------------------
    // --- HARDWARE & ACTION METHODS ---
    // -----------------------------------------

    /** Initializes all the robot hardware from the configuration. */
    private void initializeHardware() {
        // Get the motors from the hardware map using the names from your robot config
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front");
        leftBackDrive = hardwareMap.get(DcMotor.class, "left_back");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back");

        // Set the motor directions. For a typical 4WD, one side is reversed.
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    /** Placeholder method to shoot artifacts. */
    public void shootArtifacts() {
        telemetry.addData("Action", "Shooting Artifacts");
        telemetry.update();
        sleep(1000); // Simulate time for shooting
    }

    /** Placeholder method to drive to a line on the field. */
    public void driveToLine(int lineNumber) {
        telemetry.addData("Action", "Driving to line %d", lineNumber);
        telemetry.update();
        sleep(1500); // Simulate time for driving
    }

    /** Placeholder method to perform an action on a line. */
    public void grabLine() {
        telemetry.addData("Action", "Grabbing Line");
        telemetry.update();
        sleep(1000); // Simulate time for grabbing
    }

    /** Placeholder method to drive to the main shooting area. */
    public void driveToShootingArea() {
        telemetry.addData("Action", "Driving to Shooting Area");
        telemetry.update();
        sleep(1500); // Simulate time for driving
    }
}
