/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {  // The hierarchy of the type "Class" is inconsistent
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private Joystick m_trigger;
  public Joystick stick;
  private Joystick m_button1;
  
  private static final int leftfrontDeviceID = 1; 
  private static final int leftrearDeviceID = 2;
  private static final int rightrearDeviceID = 3;
  private static final int rightfrontDeviceID = 4;
  
  private CANSparkMax leftfrontmotor;
  private CANSparkMax leftrearmotor;
  private CANSparkMax rightfrontmotor;
  private CANSparkMax rightrearmotor;

  private CANSparkMax rightfrontencoder;
  private CANSparkMax rightrearencoder;
  private CANSparkMax leftfrontencoder;
  private CANSparkMax leftrearencoder;

  private static final int rightfrontenocderDeviceID = 1;
  private static final int rightrearencoderDeviceID = 2;
  private static final int leftfrontencoderDeviceID = 3;
  private static final int leftrearencoderDeviceID = 4;

  @Override
  public void robotInit() {
    leftfrontmotor = new CANSparkMax(leftfrontDeviceID, MotorType.kBrushless);
    leftrearmotor = new CANSparkMax(leftrearDeviceID, MotorType.kBrushless);

    rightfrontmotor = new CANSparkMax(rightrearDeviceID, MotorType.kBrushless);
    rightrearmotor = new CANSparkMax(rightfrontDeviceID, MotorType.kBrushless);
    //rightfrontencoder = new (rightfrontmotor.getEncoder());
    m_myRobot = new DifferentialDrive(leftfrontmotor, rightfrontmotor);

    m_leftStick = new Joystick(1);
    m_rightStick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    //Forward Backward
    leftfrontmotor.setInverted(true);
    leftrearmotor.setInverted(true);

    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());

  }
}
