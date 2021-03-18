package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Joystick (Blocks to Java)", group = "")
public class Joystick extends LinearOpMode {

  private DcMotor right_drive;
  private DcMotor left_drive;
  private DcMotor hex_1;
  private DcMotor hex_2;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    right_drive = hardwareMap.get(DcMotor.class, "right_drive");
    left_drive = hardwareMap.get(DcMotor.class, "left_drive");
    hex_1 = hardwareMap.get(DcMotor.class, "hex_1");
    hex_2 = hardwareMap.get(DcMotor.class, "hex_2");

    // You will have to determine which motor to reverse for your robot.
    // In this example, the right motor was reversed so that positive
    // applied power makes it move the robot in the forward direction.
    right_drive.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        // The Y axis of a joystick ranges from -1 in its topmost position
        // to +1 in its bottommost position. We negate this value so that
        // the topmost position corresponds to maximum forward power.
        left_drive.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
        right_drive.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
        telemetry.addData("1", 0);
        telemetry.addData("1", 0);
        telemetry.update();
      }
      while (gamepad1.a) {
        hex_1.setPower(0);
        hex_2.setPower(1);
        if (gamepad1.atRest()) {
          hex_1.setPower(0);
          hex_2.setPower(0);
        }
      }
    }
  }
}
