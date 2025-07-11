// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final XRPServo m_armServo;
  public static final int SERVO0 = 4;
  public static final int SERVO1 = 5;

  /** Creates a new Arm. */
  public Arm(int servo) {
    // Device number 4 maps to the physical Servo 1 port on the XRP
    m_armServo = new XRPServo(servo);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Set the current angle of the arm (0 - 180 degrees).
   *
   * @param angleDeg Desired arm angle in degrees
   */
  public void setAngle(double angleDeg) {
    m_armServo.setAngle(angleDeg);
  }

  public double getAngle() {
    return m_armServo.getAngle();
  }
}
