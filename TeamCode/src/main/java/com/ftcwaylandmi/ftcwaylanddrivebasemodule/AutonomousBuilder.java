package com.ftcwaylandmi.ftcwaylanddrivebasemodule;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AutonomousBuilder
{

    /* Called Classes */
    FtcWaylandDrivebaseModule ftcWaylandDrivebaseModule;

    private DcMotor moduleA = ftcWaylandDrivebaseModule.moduleA;
    private DcMotor moduleB = ftcWaylandDrivebaseModule.moduleB;

    public void CreateAutonomous (

    )
    {
        moduleA.setMode(RUN_TO_POSITION);
        moduleB.setMode(RUN_TO_POSITION);
    }

}
