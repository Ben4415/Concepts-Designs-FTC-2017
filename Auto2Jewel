package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
* Created by robotics on 12/5/2017.
*/
@Automous (name = “Auto2Jewel”, group = “Default”)
public class Auto2Jewel extends LinearOpMode {
   DcMotor FL, FR, BL, BR;
   DcMotor Sl, BM;
   ColorSensor CS;
   Hardware robot;
   int step = 0;
   boolean red = true;
   boolean blue = false;
   double d = 0.5;
   double s = 0.0;
   double sd = 0.25;
   private ElapsedTime runtime = new ElapsedTime();

   @Override
   public void runOpMode() throws InterruptedException{
       FL = robot.FrontLeft;
       FR = robot.FrontRight;
       BL = robot.BackLeft;
       BR = robot.BackRight;
       BM = robot.Lift;
       Sl = robot.Shift;
       CS = hardwareMap.colorSensor.get("CS");
       CS.red();
       CS.green();
       CS.blue();
       CS.alpha();
       CS.argb();
       waitForStart();

       while (opModeIsActive()) {
           switch (step) {
               case 0:
                       if (runtime.seconds() < 2.5) {
                           FL.setPower(d);
                           FR.setPower(d);
                           BL.setPower(d);
                           BR.setPower(d);
                       } else if (runtime.seconds() < 3){
                           FL.setPower(d);
                           FR.setPower(-d);
                           BL.setPower(d);
                           BR.setPower(-d);
                       } else if (runtime.seconds() < 4.25) {
                           FL.setPower(d);
                           FR.setPower(d);
                           BL.setPower(d);
                           BR.setPower(d);
                       } else if (runtime.seconds() < 4.75) {
                           FL.setPower(-d);
                           FR.setPower(d);
                           BL.setPower(-d);
                           BR.setPower(d);
                       } else if (runtime.seconds() < 5.25) {
                           FL.setPower(d);
                           FR.setPower(d);
                           BL.setPower(d);
                           BR.setPower(d);
                       } else{
                           FL.setPower(s);
                           FR.setPower(s);
                           BL.setPower(s);
                           BR.setPower(s);
                           runtime.reset();
                           step++;
                       }
                   break;
               case 1:
                   CS.enableLed(true);
                   if (red && !blue) {
                       if (CS.red() > 25) {
                           CS.enableLed(false);
                           if (runtime.seconds() < 0.5) {
                               FL.setPower(sd);
                               FR.setPower(sd);
                               BL.setPower(sd);
                               BR.setPower(sd);
                           } else if (runtime.seconds() < 1) {
                               FL.setPower(sd);
                               FR.setPower(-sd);
                               BL.setPower(sd);
                               BR.setPower(-sd);
                           }
                           else {
                               FL.setPower(s);
                               FR.setPower(s);
                               BL.setPower(s);
                               BR.setPower(s);
                               runtime.reset();
                               step++;
                           }
                       } else if (CS.blue() > 25) {
                           CS.enableLed(false);
                           if (runtime.seconds() < 0.5) {
                               FL.setPower(-sd);
                               FR.setPower(-sd);
                               BL.setPower(-sd);
                               BR.setPower(-sd);
                           } else if (runtime.seconds() < 1) {
                               FL.setPower(-sd);
                               FR.setPower(sd);
                               BL.setPower(-sd);
                               BR.setPower(sd);
                           } else if (runtime.seconds() < 1.25) {
                               FL.setPower(sd);
                               FR.setPower(sd);
                               BL.setPower(sd);
                               BR.setPower(sd);
                           } else if (runtime.seconds() < 1.5) {
                               FL.setPower(sd);
                               FR.setPower(-sd);
                               BL.setPower(sd);
                               BR.setPower(-sd);
                           } else if (runtime.seconds() < 2) {
                               FL.setPower(sd);
                               FR.setPower(sd);
                               BL.setPower(sd);
                               BR.setPower(sd);
                           } else if (runtime.seconds() < 2.5) {
                               FL.setPower(-sd);
                               FR.setPower(sd);
                               BL.setPower(-sd);
                               BR.setPower(sd);
                           } else {
                               FL.setPower(s);
                               FR.setPower(s);
                               BL.setPower(s);
                               BR.setPower(s);
                               runtime.reset();
                               step++;
                           }
                       }
                   } else if (!red && blue) {
                           if (CS.blue() > 25) {
                               CS.enableLed(false);
                               if (runtime.seconds() < 0.5) {
                                   FL.setPower(sd);
                                   FR.setPower(sd);
                                   BL.setPower(sd);
                                   BR.setPower(sd);
                               } else if (runtime.seconds() < 1) {
                                   FL.setPower(sd);
                                   FR.setPower(-sd);
                                   BL.setPower(sd);
                                   BR.setPower(-sd);
                               }
                               else {
                                   FL.setPower(s);
                                   FR.setPower(s);
                                   BL.setPower(s);
                                   BR.setPower(s);
                                   runtime.reset();
                                   step++;
                               }
                           } else if (CS.red() > 25) {
                               CS.enableLed(false);
                               if (runtime.seconds() < 0.5) {
                                   FL.setPower(-sd);
                                   FR.setPower(-sd);
                                   BL.setPower(-sd);
                                   BR.setPower(-sd);
                               } else if (runtime.seconds() < 1) {
                                   FL.setPower(-sd);
                                   FR.setPower(sd);
                                   BL.setPower(-sd);
                                   BR.setPower(sd);
                               } else if(runtime.seconds() < 1.25) {
                                   FL.setPower(sd);
                                   FR.setPower(sd);
                                   BL.setPower(sd);
                                   BR.setPower(sd);
                               } else if (runtime.seconds() < 1.5) {
                                   FL.setPower(sd);
                                   FR.setPower(-sd);
                                   BL.setPower(sd);
                                   BR.setPower(-sd);
                               } else if (runtime.seconds() < 2) {
                                   FL.setPower(sd);
                                   FR.setPower(sd);
                                   BL.setPower(sd);
                                   BR.setPower(sd);
                               } else if (runtime.seconds() < 2.5) {
                                   FL.setPower(-sd);
                                   FR.setPower(sd);
                                   BL.setPower(-sd);
                                   BR.setPower(sd);
                               } else {
                                   FL.setPower(s);
                                   FR.setPower(s);
                                   BL.setPower(s);
                                   BR.setPower(s);
                                   runtime.reset();
                                   step++;
                               }
                   } else {
                       FL.setPower(s);
                       FR.setPower(s);
                       BL.setPower(s);
                       BR.setPower(s);
                       runtime.reset();
                       step++;
                   }

               }
               break;
               case 3:
                   if (runtime.seconds() < 2.5) {
                       FL.setPower(-d);
                       FR.setPower(-d);
                       BL.setPower(-d);
                       BR.setPower(-d);
                   } else if (runtime.seconds() < 3){
                       FL.setPower(-d);
                       FR.setPower(d);
                       BL.setPower(-d);
                       BR.setPower(d);
                   } else if (runtime.seconds() < 4.25) {
                       FL.setPower(-d);
                       FR.setPower(-d);
                       BL.setPower(-d);
                       BR.setPower(-d);
                   } else if (runtime.seconds() < 4.75) {
                       FL.setPower(d);
                       FR.setPower(-d);
                       BL.setPower(d);
                       BR.setPower(-d);
                   } else if (runtime.seconds() < 5.25) {
                       FL.setPower(-d);
                       FR.setPower(-d);
                       BL.setPower(-d);
                       BR.setPower(-d);
                   } else{
                       FL.setPower(s);
                       FR.setPower(s);
                       BL.setPower(s);
                       BR.setPower(s);
                       runtime.reset();
                       step++;
                   }
                   break;
               default:
                   break;

           }

       }
   }
}


