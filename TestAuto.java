package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "TestAuto", group = "Default")
public class TestAuto extends LinearOpMode {

    DcMotor LM, RM;
    Servo SER;

    private final double DR = 0.5;
    private final double ST = 0.0;

    private final double SER1 = 0.3;
    private final double SER2 = 0.7;

    private boolean isRed = true;
    private boolean isBlue = false;

    @Override
    public void runOpMode() throws InterruptedException {

        LM = hardwareMap.dcMotor.get("LEFT_MOTOR");
        RM = hardwareMap.dcMotor.get("RIGHT_MOTOR");

        SER = hardwareMap.servo.get("SERVO");

        LM.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        int step = 0;

        while (opModeIsActive()) {
            switch (step) {
                case 0:
                    if (isRed && !isBlue) {
                        LM.setPower(DR);
                        RM.setPower(DR);
                        SER.setPosition(SER1);
                        sleep(1000);
                        LM.setPower(DR);
                        RM.setPower(-DR);
                        sleep(500);
                        LM.setPower(ST);
                        RM.setPower(ST);
                        step++;
                    } else if (isBlue && !isRed) {
                        LM.setPower(DR);
                        RM.setPower(DR);
                        SER.setPosition(SER1);
                        sleep(1000);
                        LM.setPower(-DR);
                        RM.setPower(DR);
                        sleep(500);
                        LM.setPower(ST);
                        RM.setPower(ST);
                        step++;
                    } else {
                        step++;
                    }
                    break;
                case 1:
                    if (isRed && !isBlue) {
                        SER.setPosition(SER2);
                        LM.setPower(DR/2);
                        RM.setPower(DR/2);
                        sleep(500);
                        LM.setPower(ST);
                        RM.setPower(ST);
                        sleep(500);
                        SER.setPosition(SER1);
                        sleep(500);
                        step++;
                    } else if (isBlue && !isRed) {
                        SER.setPosition(SER2);
                        LM.setPower(DR/2);
                        RM.setPower(DR/2);
                        sleep(500);
                        LM.setPower(ST);
                        RM.setPower(ST);
                        sleep(500);
                        SER.setPosition(SER1);
                        sleep(500);
                        step++;
                    } else {
                        step++;
                    }
                    break;
                case 2:
                    if (isRed && !isBlue) {
                        LM.setPower(-DR);
                        RM.setPower(-DR);
                        sleep(500);
                        LM.setPower(DR);
                        RM.setPower(-DR);
                        sleep(500);
                        LM.setPower(ST);
                        RM.setPower(ST);
                        step++;
                    } else if (isBlue && !isRed) {
                        LM.setPower(-DR);
                        RM.setPower(-DR);
                        sleep(500);
                        LM.setPower(-DR);
                        RM.setPower(DR);
                        sleep(500);
                        LM.setPower(ST);
                        RM.setPower(ST);
                        step++;
                    } else {
                        step++;
                    }
                    break;
                case 3:
                    idle();
                    break;
            }
        }
    }
}
