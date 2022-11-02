package com.ftcwaylandmi.ftcwaylanddrivebasemodule.drivebases;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODER;

public class RearDrive
{
    /* Qualcomm Classes */
    private HardwareMap hardwareMap;

    /* DriveModules */
    public DcMotor moduleA;
    public DcMotor moduleB;

    private DcMotor.RunMode runMode;
    private double leftStick;
    private double rightStick;
    private String driveMode;
    private String inputMode;
    private float reduction;
    private String moduleAName;
    private DcMotorSimple.Direction moduleADirection;
    int modulaATickPerRotation;
    private String moduleBName;
    private DcMotorSimple.Direction moduleBDirection;
    int modulaBTickPerRotation;

    /**
     *
     * @param moduleAName Left or Right motorName
     * @param moduleADirection moduleADirection: FORWARD, REVERSE
     * @param moduleBName Left or Right motorName
     * @param moduleBDirection moduleBDirection: FORWARD, REVERSE
     * @param runMode RunMode: RUN_TO_POSITION, RUN_USING_ENCODERS, RUN_WITHOUT_ENCODERS
     */
    public void DefineModules(
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

        this.moduleAName = moduleAName;
        this.moduleADirection = moduleADirection;
        this.modulaATickPerRotation = modulaATickPerRotation;
        this.moduleBName = moduleBName;
        this.moduleBDirection = moduleBDirection;
        this.modulaBTickPerRotation = modulaBTickPerRotation;
        this.runMode = runMode;
        hardwareMap = ahardwareMap;
    }

    /**
     *
     */
    public void SetModules(

    )
    {
        DcMotor moduleA;
        DcMotor moduleB;

        moduleA = hardwareMap.get(DcMotor.class, moduleAName);
        moduleA.setDirection(moduleADirection);

        moduleB = hardwareMap.get(DcMotor.class, moduleBName);
        moduleB.setDirection(moduleBDirection);

        switch(runMode)
        {
            case RUN_TO_POSITION:
                moduleA.setTargetPosition(0);
                moduleA.setMode(RUN_TO_POSITION);
                moduleB.setTargetPosition(0);
                moduleB.setMode(RUN_TO_POSITION);
                break;
            case RUN_USING_ENCODER:
                moduleA.setMode(RUN_USING_ENCODER);
                moduleB.setMode(RUN_USING_ENCODER);
            case RUN_WITHOUT_ENCODER:
                moduleA.setMode(RUN_WITHOUT_ENCODER);
                moduleB.setMode(RUN_WITHOUT_ENCODER);
        }

        moduleA.setPower(0);
        moduleB.setPower(0);

        this.moduleA = moduleA;
        this.moduleB = moduleB;
        this.runMode = runMode;

    }

    /**
     * @param leftStick
     * @param rightStick
     * @param driveMode
     * @param inputMode
     * @param reduction
     */
    public void DefineTeleOpDrive(
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

    /**
     *
     */
    public void SetTeleOpDrive(

    )
    {
        switch (driveMode)
        {
            case "TANK":
                switch (inputMode)
                {
                    case "LINEAR":
                        moduleA.setPower(leftStick-reduction);
                        moduleB.setPower(rightStick-reduction);
                        break;
                    case "CUBIC":
                        moduleA.setPower(leftStick*leftStick*leftStick-reduction);
                        moduleB.setPower(rightStick*rightStick*rightStick-reduction);
                        break;
                }
                break;
        }
    }

    public int GetModuleAMotorTicks(

    )
    {
        if(moduleA.getMode() == RUN_USING_ENCODER){
            return moduleA.getCurrentPosition();
        }else{
            return 0;
        }
    }

    public int GetModuleBMotorTicks(

    )
    {
        if(moduleB.getMode() == RUN_USING_ENCODER){
            return moduleB.getCurrentPosition();
        }else{
            return 0;
        }
    }



}
