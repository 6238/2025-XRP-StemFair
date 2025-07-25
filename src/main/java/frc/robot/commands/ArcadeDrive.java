// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.util.JoystickSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.Supplier;

public class ArcadeDrive extends Command {
  private final Drivetrain m_drivetrain;
  private final Supplier<JoystickSpeeds> m_joystickSupplier;

  /**
   * Creates a new ArcadeDrive. This command will drive your robot according to the speed supplier
   * lambdas. This command does not terminate.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   * @param xaxisSpeedSupplier Lambda supplier of forward/backward speed
   * @param zaxisRotateSupplier Lambda supplier of rotational speed
   */
  public ArcadeDrive(
      Drivetrain drivetrain,
      Supplier<JoystickSpeeds> joystickSupplier) {
    m_drivetrain = drivetrain;
    m_joystickSupplier = joystickSupplier;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    JoystickSpeeds s = m_joystickSupplier.get();
    m_drivetrain.arcadeDrive(s.forward, s.rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
