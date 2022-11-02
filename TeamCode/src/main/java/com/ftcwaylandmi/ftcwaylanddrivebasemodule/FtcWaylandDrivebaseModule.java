package com.ftcwaylandmi.ftcwaylanddrivebasemodule;

import com.ftcwaylandmi.ftcwaylanddrivebasemodule.drivebases.RearDrive;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FtcWaylandDrivebaseModule
{

    /* Qualcomm Libraries */

    /* Called Classes */
    private RearDrive rearDrive;
    private TeleOpBuilder teleOpBuilder;

    /* DrivebaseDefines */
    private float frameWidthCM;
    private float frameLegthCM;
    private float frontWheelDiameterCM;
    private float rearWheelDiameterCM;

    public double frontWheelCircumferenceCM;
    public double rearWheelCirumferenceCM;

    public DcMotor moduleA = rearDrive.moduleA;
    public DcMotor moduleB = rearDrive.moduleB;

    private double leftStick;
    private double rightStick;
    private String driveMode;
    private String inputMode;
    private float reduction;

    /**
     *
     */
    private void _calculateFromDrivebaseDefines(){
        frontWheelCircumferenceCM = frontWheelDiameterCM*Math.PI;
        rearWheelCirumferenceCM = rearWheelDiameterCM*Math.PI;
    }

    /**
     *
     * @param frameWidthCM
     * @param frameLegthCM
     * @param frontWheelDiameterCM
     * @param rearWheelDiameterCM
     */
    public void DrivebaseDefines(
            float frameWidthCM,
            float frameLegthCM,
            float frontWheelDiameterCM,
            float rearWheelDiameterCM
    )
    {
        this.frameWidthCM = frameWidthCM;
        this.frameLegthCM = frameLegthCM;
        this.frontWheelDiameterCM = frontWheelDiameterCM;
        this.rearWheelDiameterCM = rearWheelDiameterCM;
        _calculateFromDrivebaseDefines();
    }


    /**
     *
     * @param moduleAName
     * @param moduleADirection
     * @param modulaATickPerRotation
     * @param moduleBName
     * @param moduleBDirection
     * @param modulaBTickPerRotation
     * @param runMode
     * @param ahardwareMap
     */
    public void DefineModulesRearDrive(
            String moduleAName,
            DcMotor.Direction moduleADirection,
            int modulaATickPerRotation,
            String moduleBName,
            DcMotor.Direction moduleBDirection,
            int modulaBTickPerRotation,
            DcMotor.RunMode runMode,
            HardwareMap ahardwareMap
    )
    {
        rearDrive.DefineModules(
                moduleAName,
                moduleADirection,
                modulaATickPerRotation,
                moduleBName,
                moduleBDirection,
                modulaBTickPerRotation,
                runMode,
                ahardwareMap
        );
    }

    public void DefineTeleOpDriveRearDrive(
            double leftStick,
            double rightStick,
            String driveMode,
            String inputMode,
            float reduction
    )
    {

        this.leftStick = leftStick;
        this.rightStick = rightStick;
        this.driveMode = driveMode;
        this.inputMode = inputMode;
        this.reduction = reduction;
    }

    public void CreateTeleOpRearDriveRearDrive(
            boolean telemetryEnabled
    )
    {
        teleOpBuilder.CreateTeleOpRearDrive(telemetryEnabled);
    }

}
