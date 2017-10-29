package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * TEST CONCEPT FOR AUTONOMOUS FTC 2017 IMPLEMENTING THE USE OF LOOPS/SWITCH.
 * THIS IS A THEORETICAL AUTONOMOUS CODE AND SHOULD BE USED ON A TESTBED FIRST.
 * @author Ben
 */

@Autonomous (name = "AutonomousTest", group = "Default")
public class AutonomousTest extends LinearOpMode {

    DcMotor LM;
    DcMotor RM;

    Servo servo;

    ColorSensor s;

    private final static double m1 = 0.5; //normal power
    //private final static double m2 = -0.5; //reverse normal power

    private final static double m3 = 0.25; //half power
    private final static double m4 = -0.25; //negative half power

    private final static double m5 = 0.0; //stop

    private final static double s1 = 0.35; //servo pos 1.
    private final static double s2 = 0.75; //servo pos 2.

    //what team are you on? Set one of the following values to true on corresponding team
    boolean red = true;
    boolean blue = false;

    private ElapsedTime runtime = new ElapsedTime(); //Creates an internal clock in seconds

    @Override
    public void runOpMode() throws InterruptedException {
        LM = hardwareMap.dcMotor.get("LM");
        RM = hardwareMap.dcMotor.get("RM");

        servo = hardwareMap.servo.get("servo");

        s = hardwareMap.colorSensor.get("s");

        LM.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        //initiate color sensor values.
        s.red();
        s.green();
        s.blue();
        s.alpha();
        s.argb();

        //stepper value for switch method below.
        int step = 0;
        while (opModeIsActive()) {

            //prints color values to driver station via telemetry.
            telemetry.addData("red", s.red());
            telemetry.addData("green", s.green());
            telemetry.addData("blue", s.blue());
            telemetry.addData("clear", s.alpha());
            telemetry.addData("mix", s.argb());

            switch (step) {
                case 0: //case 0 will drive forward for 1 second, then sense a color.
                    if (red && !blue) { //if red is true and blue is false, execute.
                        if (runtime.seconds() < 1.0) {
                            servo.setPosition(s1);

                            s.enableLed(true);

                            LM.setPower(m1);
                            RM.setPower(m1);
                        } else {
                            LM.setPower(m5);
                            RM.setPower(m5);
                            while (s.red() > 25) {
                                servo.setPosition(s2);
                                runtime.reset();
                                step++; //change case.

                            }
                        }
                    } else if (blue && !red) { //if blue is true and red is false, execute.
                        if (runtime.seconds() < 1.0) {
                            servo.setPosition(s1);

                            s.enableLed(true);

                            LM.setPower(m1);
                            RM.setPower(m1);
                        } else {
                            LM.setPower(m5);
                            RM.setPower(m5);
                            while (s.blue() > 25) {
                                servo.setPosition(s2);
                                runtime.reset();
                                step++;
                            }
                        }
                    } else { //if anything else is done (IE both true or both false), skip.
                        runtime.reset();
                        step++;
                    }
                    break;
                case 1: //if red, the robot will turn slightly one way, vise-versa for blue.
                    if (red && !blue) { //if red is true and blue is false, execute.
                        if (runtime.seconds() < 0.25) {
                            LM.setPower(m3);
                            RM.setPower(m4);
                        } else {
                            LM.setPower(m5);
                            RM.setPower(m5);

                            runtime.reset();
                            step++;
                        }
                    } else if (blue && !red) { //if blue is true and red is false, execute.
                        if (runtime.seconds() < 0.25) {
                            LM.setPower(m4);
                            RM.setPower(m3);
                        } else {
                            LM.setPower(m5);
                            RM.setPower(m5);

                            runtime.reset();
                            step++;
                        }
                    } else { //if anything else is done (IE both true or both false), skip.
                        runtime.reset();
                        step++;
                    }
                    break;
                case 2: //universal stop code.
                    servo.setPosition(s1);

                    s.enableLed(false);

                    LM.setPower(m5);
                    RM.setPower(m5);
                    
                    break;
                default: 
                    break;
            }
            idle();
        }
    }
}
