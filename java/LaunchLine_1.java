package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "LaunchLine_1 (Blocks to Java)", group = "")
public class LaunchLine_1 extends LinearOpMode {

  private DcMotor right_drive;
  private DcMotor left_drive;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    right_drive = hardwareMap.get(DcMotor.class, "right_drive");
    left_drive = hardwareMap.get(DcMotor.class, "left_drive");

    // You will have to determine which motor to reverse for your robot.
    // In this example, the right motor was reversed so that positive
    // applied power makes it move the robot in the forward direction.
    right_drive.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    left_drive.setPower(0.54);
    right_drive.setPower(0.5);
    sleep(3000);
    left_drive.setPower(0);
    right_drive.setPower(0);
  }
}
