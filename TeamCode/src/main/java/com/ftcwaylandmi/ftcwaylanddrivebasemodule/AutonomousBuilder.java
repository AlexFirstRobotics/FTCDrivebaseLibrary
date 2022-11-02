package com.ftcwaylandmi.ftcwaylanddrivebasemodule;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AutonomousBuilder
{

    /* Called Classes */
    private FtcWaylandDrivebaseModule ftcWaylandDrivebaseModule;
    private Config config;

    private DcMotor moduleA = ftcWaylandDrivebaseModule.moduleA;
    private DcMotor moduleB = ftcWaylandDrivebaseModule.moduleB;

    private final String autonName = config.AutonName;
    private final String autonGroup = config.AutonGroup;

    public void CreateAutonRearDrive (

    )
    {
        @com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = autonName, group = autonGroup)
        abstract class Auton extends LinearOpMode
        {

            public void runOpMode()
            {



            }

        }
        moduleA.setMode(RUN_TO_POSITION);
        moduleB.setMode(RUN_TO_POSITION);
    }


}
