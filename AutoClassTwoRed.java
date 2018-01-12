package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcontroller.internal.FTCBOTHARDWARE;


@Autonomous (name = "AutoClassTwoRed", group = "AutoClassTwoRed")
public class AutoClassTwoRed extends LinearOpMode {

    FTCBOTHARDWARE robot = new FTCBOTHARDWARE();

    boolean red = true;
    boolean blue = false;

    private final double driveForward = 0.5;
    private final double slowForward = driveForward/2;
    private final double shiftMove = 1.0;
    private final double stop = 0.0;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);

        waitForStart();

        int count = 0;
        while (opModeIsActive()) {
            switch (count) {
                case 0:
                    robot.Shift.setPower(-shiftMove);
                    sleep(350);
                    robot.Shift.setPower(stop);
                    robot.Lift.setPower(driveForward);
                    sleep(500);
                    robot.Lift.setPower(stop);
                    count++;
                    break;
                case 1:
                    if (red && !blue) {
                        robot.FrontLeft.setPower(driveForward);
                        robot.FrontRight.setPower(driveForward);
                        robot.BackLeft.setPower(driveForward);
                        robot.BackRight.setPower(driveForward);
                        sleep(2225);
                        robot.FrontLeft.setPower(driveForward);
                        robot.FrontRight.setPower(-driveForward);
                        robot.BackLeft.setPower(driveForward);
                        robot.BackRight.setPower(-driveForward);
                        sleep(750);
                        robot.FrontLeft.setPower(driveForward);
                        robot.FrontRight.setPower(driveForward);
                        robot.BackLeft.setPower(driveForward);
                        robot.BackRight.setPower(driveForward);
                        sleep(9400);
                        robot.FrontLeft.setPower(driveForward);
                        robot.FrontRight.setPower(-driveForward);
                        robot.BackLeft.setPower(driveForward);
                        robot.BackRight.setPower(-driveForward);
                        sleep(1100);
                        robot.FrontLeft.setPower(stop);
                        robot.FrontRight.setPower(stop);
                        robot.BackLeft.setPower(stop);
                        robot.BackRight.setPower(stop);
                        count++;
                    } else if (blue && !red) {
                        robot.FrontLeft.setPower(driveForward);
                        robot.FrontRight.setPower(driveForward);
                        robot.BackLeft.setPower(driveForward);
                        robot.BackRight.setPower(driveForward);
                        sleep(2225);
                        robot.FrontLeft.setPower(-driveForward);
                        robot.FrontRight.setPower(driveForward);
                        robot.BackLeft.setPower(-driveForward);
                        robot.BackRight.setPower(driveForward);
                        sleep(750);
                        robot.FrontLeft.setPower(driveForward);
                        robot.FrontRight.setPower(driveForward);
                        robot.BackLeft.setPower(driveForward);
                        robot.BackRight.setPower(driveForward);
                        sleep(9400);
                        robot.FrontLeft.setPower(-driveForward);
                        robot.FrontRight.setPower(driveForward);
                        robot.BackLeft.setPower(-driveForward);
                        robot.BackRight.setPower(driveForward);
                        sleep(1100);
                        robot.FrontLeft.setPower(stop);
                        robot.FrontRight.setPower(stop);
                        robot.BackLeft.setPower(stop);
                        robot.BackRight.setPower(stop);
                        count++;
                    } else {
                        robot.FrontLeft.setPower(stop);
                        robot.FrontRight.setPower(stop);
                        robot.BackLeft.setPower(stop);
                        robot.BackRight.setPower(stop);
                        count++;
                    }
                    break;
                case 2:
                    robot.Shift.setPower(shiftMove);
                    sleep(350);
                    robot.Shift.setPower(stop);
                    sleep(100);
                    robot.FrontLeft.setPower(slowForward);
                    robot.FrontRight.setPower(slowForward);
                    robot.BackLeft.setPower(slowForward);
                    robot.BackRight.setPower(slowForward);
                    sleep(3800);
                    robot.FrontLeft.setPower(stop);
                    robot.FrontRight.setPower(stop);
                    robot.BackLeft.setPower(stop);
                    robot.BackRight.setPower(stop);
                    sleep(100);
                    robot.FrontLeft.setPower(-slowForward);
                    robot.FrontRight.setPower(-slowForward);
                    robot.BackLeft.setPower(-slowForward);
                    robot.BackRight.setPower(-slowForward);
                    sleep(250);
                    robot.FrontLeft.setPower(stop);
                    robot.FrontRight.setPower(stop);
                    robot.BackLeft.setPower(stop);
                    robot.BackRight.setPower(stop);
                    idle();
                    break;
                default:
                    break;
            }
        }
    }
}
