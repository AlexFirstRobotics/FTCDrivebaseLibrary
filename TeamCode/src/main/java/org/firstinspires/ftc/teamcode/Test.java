package org.firstinspires.ftc.teamcode;

import com.ftcwaylandmi.ftcwaylanddrivebasemodule.FtcWaylandDrivebaseModule;
import com.ftcwaylandmi.ftcwaylanddrivebasemodule.drivebases.RearDrive;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Test
{
    FtcWaylandDrivebaseModule drivebaseModule = new FtcWaylandDrivebaseModule();
    RearDrive driveModules = new RearDrive();

    public void Init()
    {
        drivebaseModule.DrivebaseDefines(
                30,
                90,
                20,
                20
        );

        driveModules.SetModules(
                "leftMotor",
                DcMotorSimple.Direction.FORWARD,
                "rightMotor",
                DcMotorSimple.Direction.REVERSE,
                DcMotor.RunMode.RUN_TO_POSITION
        );
    }

}
