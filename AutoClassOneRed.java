package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.internal.FTCBOTHARDWARE;

@Autonomous (name = "AutoClassOneRed", group = "Default")
public class AutoClassOneRed extends LinearOpMode {

    FTCBOTHARDWARE robot = new FTCBOTHARDWARE();

    boolean red = true;
    boolean blue = false;

    private final double driveforward = 0.5;
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
                    robot.Lift.setPower(driveforward);
                    sleep(500);
                    robot.Lift.setPower(stop);
                    count++;
                    break;
                case 1:
                    if (red && !blue) {
                        robot.FrontLeft.setPower(driveforward);
                        robot.FrontRight.setPower(driveforward);
                        robot.BackLeft.setPower(driveforward);
                        robot.BackRight.setPower(driveforward);
                        sleep(750);
                        robot.FrontLeft.setPower(driveforward);
                        robot.FrontRight.setPower(-driveforward);
                        robot.BackLeft.setPower(driveforward);
                        robot.BackRight.setPower(-driveforward);
                        sleep(750);
                        robot.FrontLeft.setPower(driveforward);
                        robot.FrontRight.setPower(driveforward);
                        robot.BackLeft.setPower(driveforward);
                        robot.BackRight.setPower(driveforward);
                        sleep(200);
                        robot.FrontLeft.setPower(stop);
                        robot.FrontRight.setPower(stop);
                        robot.BackLeft.setPower(stop);
                        robot.BackRight.setPower(stop);
                        count++;
                    } else if (blue && !red) {
                        robot.FrontLeft.setPower(driveforward);
                        robot.FrontRight.setPower(driveforward);
                        robot.BackLeft.setPower(driveforward);
                        robot.BackRight.setPower(driveforward);
                        sleep(750);
                        robot.FrontLeft.setPower(-driveforward);
                        robot.FrontRight.setPower(driveforward);
                        robot.BackLeft.setPower(-driveforward);
                        robot.BackRight.setPower(driveforward);
                        sleep(750);
                        robot.FrontLeft.setPower(driveforward);
                        robot.FrontRight.setPower(driveforward);
                        robot.BackLeft.setPower(driveforward);
                        robot.BackRight.setPower(driveforward);
                        sleep(200);
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
                    idle();
                    break;
                default:
            }
        }
    }
}
