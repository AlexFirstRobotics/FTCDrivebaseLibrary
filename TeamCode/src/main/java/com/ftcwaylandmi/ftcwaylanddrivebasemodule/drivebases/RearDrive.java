package com.ftcwaylandmi.ftcwaylanddrivebasemodule.drivebases;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;

public class RearDrive
{
    /* Qualcomm Classes */
    private HardwareMap hardwareMap;

    /* DriveModules */
    private DcMotor moduleA;
    private DcMotor moduleB;

    private DcMotor.RunMode runMode;



    /**
     *
     * @param moduleAName
     * @param moduleADirection
     * @param moduleBName
     * @param moduleBDirection
     * @param runMode
     */
    public void SetModules(
            String moduleAName,
            DcMotor.Direction moduleADirection,
            String moduleBName,
            DcMotor.Direction moduleBDirection,
            DcMotor.RunMode runMode

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
        }

        moduleA.setPower(0);
        moduleB.setPower(0);

        this.moduleA = moduleA;
        this.moduleB = moduleB;
        this.runMode = runMode;

    }

}
