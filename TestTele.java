package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class TestTele extends OpMode {

    DcMotor LM, RM, belt, belt2;
    Servo s0, s1, s2;
    private float x, y;

    private final double BP = 0.5;
    private final double ser1 = 0.3;
    private final double ser2 = 0.7;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void init() {

        LM = hardwareMap.dcMotor.get("Left_Motor");
        RM = hardwareMap.dcMotor.get("Right_Motor");
        belt = hardwareMap.dcMotor.get("Belt_Motor");
        belt2 = hardwareMap.dcMotor.get("Belt_Motor_2");

        s0 = hardwareMap.servo.get("Servo_0");
        s1 = hardwareMap.servo.get("Servo_1");

        LM.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {

        getJoysticks();

        //gradual motor speed increase?
        if (gamepad1.left_bumper) {
            LM.setPower(com.qualcomm.robotcore.util.Range.clip((LM.getPower() -0.01), 0.0, 1.0));
            RM.setPower(com.qualcomm.robotcore.util.Range.clip((RM.getPower() -0.01), 0.0, 1.0));
        } else {
            LM.setPower(0.0);
            RM.setPower(0.0);
        }

        LM.setPower(x/2);
        RM.setPower(y/2);

        while (gamepad2.a) belt.setPower(BP); //should also work with an if statement
        s0.setPosition((gamepad2.y) ? ser2 : ser1);
        s1.setPosition((gamepad2.x) ? ser2 : ser1);

        if (gamepad2.b) {
            if (runtime.seconds() < 1.0) {
                belt.setPower(BP);

            } else if (runtime.seconds() < 1.5) {
                s2.setPosition(ser2);
            } else {
                s2.setPosition(ser1);
                runtime.reset();
            }
        }

    }

    public void getJoysticks() {

        x = -gamepad1.left_stick_y;
        y = -gamepad1.right_stick_y;

    }

    public void stop() {

    }
}
