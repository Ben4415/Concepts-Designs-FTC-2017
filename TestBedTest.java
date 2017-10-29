package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * TestBed Code to Analyze Concept.
 * @author Ben Decker.
 */

@Autonomous (name = "TestBedTest", group = "Default")
public class TestBedTest extends LinearOpMode {

    DcMotor LM;
    DcMotor RM;

    private ElapsedTime runtime = new ElapsedTime();

    private static double m1 = 0.5;
    private static double m2 = -0.5;
    private static double s = 0.0;

    boolean red = false;
    boolean blue = true;

    @Override
    public void runOpMode() throws InterruptedException {
        LM = hardwareMap.dcMotor.get("LM");
        RM = hardwareMap.dcMotor.get("RM");

        LM.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        int count = 0;
        while (opModeIsActive()) {
            switch (count) {
                case 0:
                    if (red && !blue) {
                        if (runtime.seconds() < 1.0) {
                            LM.setPower(m1);
                            RM.setPower(m1);
                        } else {
                            LM.setPower(s);
                            RM.setPower(s);

                            runtime.reset();
                            count++;
                        }
                    } else if (blue && !red) {
                        if (runtime.seconds() < 1.0) {
                            LM.setPower(m2);
                            RM.setPower(m2);
                        } else {
                            LM.setPower(s);
                            RM.setPower(s);

                            runtime.reset();
                            count++;
                        }
                    } else {
                        runtime.reset();
                        count++;
                    }
                    break;
                case 1:
                    if (red && !blue) {
                        if (runtime.seconds() < 1.0) {
                            LM.setPower(m1);
                            RM.setPower(m2);
                        } else {
                            LM.setPower(s);
                            RM.setPower(s);

                            runtime.reset();
                            count++;
                        }
                    } else if (blue && !red) {
                        if (runtime.seconds() < 1.0) {
                            LM.setPower(m2);
                            RM.setPower(m1);
                        } else {
                            LM.setPower(s);
                            RM.setPower(s);

                            runtime.reset();
                            count++;
                        }
                    } else {
                        runtime.reset();
                        count++;
                    }
                    break;
                case 2:
                    LM.setPower(s);
                    RM.setPower(s);
                    break;
                default:
                    break;
            }
            idle();
        }
    }
}
